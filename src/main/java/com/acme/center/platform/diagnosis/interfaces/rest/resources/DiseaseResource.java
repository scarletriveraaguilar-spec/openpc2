package com.acme.center.platform.diagnosis.interfaces.rest.resources;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Response resource representing a registered disease.
 */
@Schema(name = "DiseaseResource")
public record DiseaseResource(
        Long id,
        String diseaseName,
        Integer category,
        Long causativeAgentId,
        Long commonSymptomsId,
        Long transmissionMethodId,
        String preventionMethods,
        Long diagnosisId,
        Float mortalityRatePercent,
        Integer incidenceRatePer100k) {
}
