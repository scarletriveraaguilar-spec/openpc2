package com.acme.center.platform.diagnosis.domain.model.events;

import com.acme.center.platform.diagnosis.domain.model.valueobjects.DiagnosisId;
import org.springframework.context.ApplicationEvent;

/**
 * Domain event raised when a disease is registered under a diagnosis.
 * It is published through the shared event infrastructure so interested
 * application components can react without coupling the aggregate to them.
 */
public class DiseaseRegisteredEvent extends ApplicationEvent {

    private final String diseaseName;
    private final DiagnosisId diagnosisId;

    public DiseaseRegisteredEvent(Object source, String diseaseName, DiagnosisId diagnosisId) {
        super(source);
        this.diseaseName = diseaseName;
        this.diagnosisId = diagnosisId;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public DiagnosisId getDiagnosisId() {
        return diagnosisId;
    }
}
