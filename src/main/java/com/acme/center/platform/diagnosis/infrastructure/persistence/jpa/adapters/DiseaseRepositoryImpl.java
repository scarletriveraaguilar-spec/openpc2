package com.acme.center.platform.diagnosis.infrastructure.persistence.jpa.adapters;

import com.acme.center.platform.diagnosis.domain.model.aggregates.Disease;
import com.acme.center.platform.diagnosis.domain.repositories.DiseaseRepository;
import com.acme.center.platform.diagnosis.infrastructure.persistence.jpa.assemblers.DiseasePersistenceAssembler;
import com.acme.center.platform.diagnosis.infrastructure.persistence.jpa.repositories.DiseasePersistenceRepository;
import com.acme.center.platform.shared.infrastructure.events.DomainEventPublisher;
import org.springframework.stereotype.Repository;

/**
 * JPA adapter implementing the Disease repository port.
 */
@Repository
public class DiseaseRepositoryImpl implements DiseaseRepository {

    private final DiseasePersistenceRepository persistenceRepository;
    private final DomainEventPublisher domainEventPublisher;

    public DiseaseRepositoryImpl(
            DiseasePersistenceRepository persistenceRepository,
            DomainEventPublisher domainEventPublisher) {
        this.persistenceRepository = persistenceRepository;
        this.domainEventPublisher = domainEventPublisher;
    }

    @Override
    public boolean existsByDiseaseNameAndCausativeAgentIdAndDiagnosisId(
            String diseaseName, Long causativeAgentId, Long diagnosisId) {
        return persistenceRepository.existsByDiseaseNameAndCausativeAgentIdAndDiagnosisId(
                diseaseName, causativeAgentId, diagnosisId);
    }

    @Override
    public java.util.Optional<Disease> findById(Long diseaseId) {
        return persistenceRepository.findById(diseaseId)
                .map(DiseasePersistenceAssembler::toDomainFromEntity);
    }

    @Override
    public Disease save(Disease disease) {
        var savedEntity = persistenceRepository.save(
                DiseasePersistenceAssembler.toEntityFromDomain(disease));
        var savedDisease = DiseasePersistenceAssembler.toDomainFromEntity(savedEntity);
        domainEventPublisher.publishAndClearEvents(disease);
        return savedDisease;
    }
}
