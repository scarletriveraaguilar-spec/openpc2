package com.acme.center.platform.diagnosis.domain.model.valueobjects;

/**
 * Positive identifier value object for DiagnosisId.
 *
 * @param id identifier value; must be greater than zero
 */
public record DiagnosisId(Long id) {
    public DiagnosisId {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("validation.disease.diagnosis-id.positive");
        }
    }
}
