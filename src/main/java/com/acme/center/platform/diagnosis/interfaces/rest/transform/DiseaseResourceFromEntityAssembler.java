package com.acme.center.platform.diagnosis.interfaces.rest.transform;

import com.acme.center.platform.diagnosis.domain.model.aggregates.Disease;
import com.acme.center.platform.diagnosis.interfaces.rest.resources.DiseaseResource;

/**
 * Assembles REST resources from Disease aggregates.
 */
public final class DiseaseResourceFromEntityAssembler {

    private DiseaseResourceFromEntityAssembler() {
    }

    public static DiseaseResource toResourceFromEntity(Disease entity) {
        return new DiseaseResource(
                entity.getId(),
                entity.getDiseaseName(),
                entity.getCategory().getId(),
                entity.getCausativeAgentId().id(),
                entity.getCommonSymptomsId().id(),
                entity.getTransmissionMethodId().id(),
                entity.getPreventionMethods(),
                entity.getDiagnosisId().id(),
                entity.getMortalityRatePercent(),
                entity.getIncidenceRatePer100k());
    }
}
