package com.acme.center.platform.diagnosis.domain.model.aggregates;

import com.acme.center.platform.diagnosis.domain.model.commands.CreateDiseaseCommand;
import com.acme.center.platform.diagnosis.domain.model.events.DiseaseRegisteredEvent;
import com.acme.center.platform.diagnosis.domain.model.valueobjects.Category;
import com.acme.center.platform.diagnosis.domain.model.valueobjects.CausativeAgentId;
import com.acme.center.platform.diagnosis.domain.model.valueobjects.CommonSymptomsId;
import com.acme.center.platform.diagnosis.domain.model.valueobjects.DiagnosisId;
import com.acme.center.platform.diagnosis.domain.model.valueobjects.TransmissionMethodId;
import com.acme.center.platform.shared.domain.model.aggregates.AbstractDomainAggregateRoot;
import lombok.Getter;

/**
 * Disease aggregate root.
 *
 * <p>Contains the domain state and invariants for a disease registered under a diagnosis.
 * Persistence annotations are deliberately kept outside the domain model.</p>
 */
@Getter
public class Disease extends AbstractDomainAggregateRoot<Disease> {

    private Long id;
    private String diseaseName;
    private Category category;
    private CausativeAgentId causativeAgentId;
    private CommonSymptomsId commonSymptomsId;
    private TransmissionMethodId transmissionMethodId;
    private String preventionMethods;
    private DiagnosisId diagnosisId;
    private Float mortalityRatePercent;
    private Integer incidenceRatePer100k;

    public Disease(CreateDiseaseCommand command) {
        this(
                null,
                command.diseaseName(),
                Category.fromName(command.category()),
                new CausativeAgentId(command.causativeAgentId()),
                new CommonSymptomsId(command.commonSymptomsId()),
                new TransmissionMethodId(command.transmissionMethodId()),
                command.preventionMethods(),
                new DiagnosisId(command.diagnosisId()),
                command.mortalityRatePercent(),
                command.incidenceRatePer100k()
        );
    }

    private Disease(
            Long id,
            String diseaseName,
            Category category,
            CausativeAgentId causativeAgentId,
            CommonSymptomsId commonSymptomsId,
            TransmissionMethodId transmissionMethodId,
            String preventionMethods,
            DiagnosisId diagnosisId,
            Float mortalityRatePercent,
            Integer incidenceRatePer100k) {
        this.id = id;
        this.diseaseName = requiredText(diseaseName, 80, "validation.disease.name.invalid");
        this.category = required(category, "validation.disease.category.required");
        this.causativeAgentId = required(causativeAgentId, "validation.disease.causative-agent-id.positive");
        this.commonSymptomsId = required(commonSymptomsId, "validation.disease.common-symptoms-id.positive");
        this.transmissionMethodId = required(transmissionMethodId, "validation.disease.transmission-method-id.positive");
        this.preventionMethods = requiredText(preventionMethods, 50, "validation.disease.prevention-methods.invalid");
        this.diagnosisId = required(diagnosisId, "validation.disease.diagnosis-id.positive");

        if (mortalityRatePercent == null || !Float.isFinite(mortalityRatePercent)
                || mortalityRatePercent < 0.0f || mortalityRatePercent > 1.0f) {
            throw new IllegalArgumentException("validation.disease.mortality-rate.range");
        }
        if (incidenceRatePer100k == null) {
            throw new IllegalArgumentException("validation.disease.incidence-rate.required");
        }
        this.mortalityRatePercent = mortalityRatePercent;
        this.incidenceRatePer100k = incidenceRatePer100k;
        if (id == null) {
            registerDomainEvent(new DiseaseRegisteredEvent(this, this.diseaseName, this.diagnosisId));
        }
    }

    public static Disease reconstitute(
            Long id,
            String diseaseName,
            Category category,
            CausativeAgentId causativeAgentId,
            CommonSymptomsId commonSymptomsId,
            TransmissionMethodId transmissionMethodId,
            String preventionMethods,
            DiagnosisId diagnosisId,
            Float mortalityRatePercent,
            Integer incidenceRatePer100k) {
        return new Disease(id, diseaseName, category, causativeAgentId, commonSymptomsId,
                transmissionMethodId, preventionMethods, diagnosisId, mortalityRatePercent, incidenceRatePer100k);
    }

    private static String requiredText(String value, int maxLength, String messageKey) {
        if (value == null || value.isBlank() || value.trim().length() > maxLength) {
            throw new IllegalArgumentException(messageKey);
        }
        return value.trim();
    }

    private static <T> T required(T value, String messageKey) {
        if (value == null) {
            throw new IllegalArgumentException(messageKey);
        }
        return value;
    }
}
