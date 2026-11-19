package com.acme.center.platform.diagnosis.interfaces.rest;

import com.acme.center.platform.diagnosis.application.commandservices.DiseaseCommandService;
import com.acme.center.platform.diagnosis.application.queryservices.DiseaseQueryService;
import com.acme.center.platform.diagnosis.domain.model.queries.GetDiseaseByIdQuery;
import com.acme.center.platform.diagnosis.interfaces.rest.transform.CreateDiseaseCommandFromResourceAssembler;
import com.acme.center.platform.diagnosis.interfaces.rest.resources.CreateDiseaseResource;
import com.acme.center.platform.diagnosis.interfaces.rest.transform.DiseaseResourceFromEntityAssembler;
import com.acme.center.platform.shared.interfaces.rest.transform.ResponseEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller exposing the disease registration operation.
 */
@RestController
@RequestMapping("/api/v1/treatments/{diagnosisId}/diseases")
@Tag(name = "Diseases", description = "Disease registration operations")
public class DiseasesController {

    private final DiseaseCommandService diseaseCommandService;
    private final DiseaseQueryService diseaseQueryService;

    public DiseasesController(
            DiseaseCommandService diseaseCommandService,
            DiseaseQueryService diseaseQueryService) {
        this.diseaseCommandService = diseaseCommandService;
        this.diseaseQueryService = diseaseQueryService;
    }

    /**
     * Registers a disease for the diagnosis identified in the path.
     *
     * @param diagnosisId diagnosis identifier
     * @param resource request body
     * @return HTTP 201 with the created disease, or a ProblemDetail error
     */
    @PostMapping
    @Operation(
            summary = "Register a disease",
            description = "Creates a disease associated with the diagnosis identifier in the URL.")
    public ResponseEntity<?> createDisease(
            @PathVariable Long diagnosisId,
            @Valid @RequestBody CreateDiseaseResource resource) {
        var command = CreateDiseaseCommandFromResourceAssembler
                .toCommandFromResource(resource, diagnosisId);

        var result = diseaseCommandService.handle(command);
        return ResponseEntityAssembler.toResponseEntityFromResult(
                result,
                disease -> diseaseQueryService.handle(new GetDiseaseByIdQuery(disease.getId()))
                        .map(DiseaseResourceFromEntityAssembler::toResourceFromEntity)
                        .orElseThrow(() -> new IllegalStateException(
                                "The created disease could not be retrieved.")),
                HttpStatus.CREATED);
    }
}
