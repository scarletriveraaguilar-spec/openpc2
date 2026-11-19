package com.acme.center.platform.diagnosis.infrastructure.persistence.jpa.repositories;

import com.acme.center.platform.diagnosis.infrastructure.persistence.jpa.entities.DiseasePersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data repository for Disease persistence entities.
 */
public interface DiseasePersistenceRepository extends JpaRepository<DiseasePersistenceEntity, Long> {
    boolean existsByDiseaseNameAndCausativeAgentIdAndDiagnosisId(
            String diseaseName, Long causativeAgentId, Long diagnosisId);
}
