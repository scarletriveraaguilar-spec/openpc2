package com.acme.center.platform.diagnosis.domain.repositories;

import com.acme.center.platform.diagnosis.domain.model.aggregates.Disease;

/**
 * Repository port for the Disease aggregate.
 */
public interface DiseaseRepository {
    boolean existsByDiseaseNameAndCausativeAgentIdAndDiagnosisId(
            String diseaseName, Long causativeAgentId, Long diagnosisId);

    Disease save(Disease disease);

    java.util.Optional<Disease> findById(Long diseaseId);
}
