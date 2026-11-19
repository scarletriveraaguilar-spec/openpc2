package com.acme.center.platform.diagnosis.domain.model.queries;

/**
 * Query to retrieve a disease by its generated identifier.
 *
 * @param diseaseId identifier of the disease to retrieve
 */
public record GetDiseaseByIdQuery(Long diseaseId) {
}
