package com.acme.center.platform.diagnosis.interfaces.rest.transform;

import com.acme.center.platform.diagnosis.domain.model.commands.CreateDiseaseCommand;
import com.acme.center.platform.diagnosis.interfaces.rest.resources.CreateDiseaseResource;

/** Assembles a domain command from the incoming REST resource. */
public final class CreateDiseaseCommandFromResourceAssembler {

    private CreateDiseaseCommandFromResourceAssembler() {
    }

    public static CreateDiseaseCommand toCommandFromResource(
            CreateDiseaseResource resource, Long diagnosisId) {
        return new CreateDiseaseCommand(
                resource.diseaseName(),
                resource.category(),
                resource.causativeAgentId(),
                resource.commonSymptomsId(),
                resource.transmissionMethodId(),
                resource.preventionMethods(),
                diagnosisId,
                resource.mortalityRatePercent(),
                resource.incidenceRatePer100k());
    }
}
