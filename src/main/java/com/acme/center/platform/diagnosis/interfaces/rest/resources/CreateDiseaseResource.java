package com.acme.center.platform.diagnosis.interfaces.rest.resources;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/**
 * Request resource for creating a disease.
 */
@Schema(name = "CreateDiseaseRequest", description = "Data required to register a disease.")
public record CreateDiseaseResource(
        @Schema(example = "Influenza", maxLength = 80)
        @NotBlank @Size(max = 80) String diseaseName,

        @Schema(example = "INFECTIOUS")
        @NotBlank String category,

        @Schema(example = "1")
        @NotNull @Positive Long causativeAgentId,

        @Schema(example = "2")
        @NotNull @Positive Long commonSymptomsId,

        @Schema(example = "3")
        @NotNull @Positive Long transmissionMethodId,

        @Schema(example = "Annual vaccination and hand hygiene", maxLength = 50)
        @NotBlank @Size(max = 50) String preventionMethods,

        @Schema(example = "0.02")
        @NotNull @DecimalMin("0.0") @DecimalMax("1.0") Float mortalityRatePercent,

        @Schema(example = "120")
        @NotNull Integer incidenceRatePer100k) {
}
