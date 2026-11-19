package com.acme.center.platform.diagnosis.infrastructure.persistence.jpa.entities;

import com.acme.center.platform.shared.infrastructure.persistence.jpa.entities.AuditableAbstractPersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * JPA persistence representation of the Disease aggregate.
 */
@Entity
@Table(
        name = "disease",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_disease_name_agent_diagnosis",
                columnNames = {"disease_name", "causative_agent_id", "diagnosis_id"}))
@Getter
@Setter
@NoArgsConstructor
public class DiseasePersistenceEntity extends AuditableAbstractPersistenceEntity {

    @Column(name = "disease_name", nullable = false, length = 80)
    private String diseaseName;

    @Column(nullable = false, length = 32)
    private String category;

    @Column(name = "causative_agent_id", nullable = false)
    private Long causativeAgentId;

    @Column(name = "common_symptoms_id", nullable = false)
    private Long commonSymptomsId;

    @Column(name = "transmission_method_id", nullable = false)
    private Long transmissionMethodId;

    @Column(name = "prevention_methods", nullable = false, length = 50)
    private String preventionMethods;

    @Column(name = "diagnosis_id", nullable = false)
    private Long diagnosisId;

    @Column(name = "mortality_rate_percent", nullable = false)
    private Float mortalityRatePercent;

    @Column(name = "incidence_rate_per_100k", nullable = false)
    private Integer incidenceRatePer100k;
}
