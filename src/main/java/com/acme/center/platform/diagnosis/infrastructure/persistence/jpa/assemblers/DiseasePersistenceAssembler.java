package com.acme.center.platform.diagnosis.infrastructure.persistence.jpa.assemblers;

import com.acme.center.platform.diagnosis.domain.model.aggregates.Disease;
import com.acme.center.platform.diagnosis.domain.model.valueobjects.Category;
import com.acme.center.platform.diagnosis.domain.model.valueobjects.CausativeAgentId;
import com.acme.center.platform.diagnosis.domain.model.valueobjects.CommonSymptomsId;
import com.acme.center.platform.diagnosis.domain.model.valueobjects.DiagnosisId;
import com.acme.center.platform.diagnosis.domain.model.valueobjects.TransmissionMethodId;
import com.acme.center.platform.diagnosis.infrastructure.persistence.jpa.entities.DiseasePersistenceEntity;

/**
 * Maps between the Disease aggregate and its JPA persistence entity.
 */
public final class DiseasePersistenceAssembler {

    private DiseasePersistenceAssembler() {
    }

    public static DiseasePersistenceEntity toEntityFromDomain(Disease disease) {
        var entity = new DiseasePersistenceEntity();
        entity.setId(disease.getId());
        entity.setDiseaseName(disease.getDiseaseName());
        entity.setCategory(disease.getCategory().name());
        entity.setCausativeAgentId(disease.getCausativeAgentId().id());
        entity.setCommonSymptomsId(disease.getCommonSymptomsId().id());
        entity.setTransmissionMethodId(disease.getTransmissionMethodId().id());
        entity.setPreventionMethods(disease.getPreventionMethods());
        entity.setDiagnosisId(disease.getDiagnosisId().id());
        entity.setMortalityRatePercent(disease.getMortalityRatePercent());
        entity.setIncidenceRatePer100k(disease.getIncidenceRatePer100k());
        return entity;
    }

    public static Disease toDomainFromEntity(DiseasePersistenceEntity entity) {
        return Disease.reconstitute(
                entity.getId(),
                entity.getDiseaseName(),
                Category.valueOf(entity.getCategory()),
                new CausativeAgentId(entity.getCausativeAgentId()),
                new CommonSymptomsId(entity.getCommonSymptomsId()),
                new TransmissionMethodId(entity.getTransmissionMethodId()),
                entity.getPreventionMethods(),
                new DiagnosisId(entity.getDiagnosisId()),
                entity.getMortalityRatePercent(),
                entity.getIncidenceRatePer100k());
    }
}
