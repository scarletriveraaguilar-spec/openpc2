package com.acme.center.platform.diagnosis.domain.model.valueobjects;

/**
 * Positive identifier value object for CausativeAgentId.
 *
 * @param id identifier value; must be greater than zero
 */
public record CausativeAgentId(Long id) {
    public CausativeAgentId {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("validation.disease.causative-agent-id.positive");
        }
    }
}
