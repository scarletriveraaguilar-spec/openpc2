package com.acme.center.platform.diagnosis.domain.model.valueobjects;

/**
 * Positive identifier value object for CommonSymptomsId.
 *
 * @param id identifier value; must be greater than zero
 */
public record CommonSymptomsId(Long id) {
    public CommonSymptomsId {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("validation.disease.common-symptoms-id.positive");
        }
    }
}
