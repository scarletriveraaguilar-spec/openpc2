package com.acme.center.platform.diagnosis.domain.model.valueobjects;

/**
 * Positive identifier value object for TransmissionMethodId.
 *
 * @param id identifier value; must be greater than zero
 */
public record TransmissionMethodId(Long id) {
    public TransmissionMethodId {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("validation.disease.transmission-method-id.positive");
        }
    }
}
