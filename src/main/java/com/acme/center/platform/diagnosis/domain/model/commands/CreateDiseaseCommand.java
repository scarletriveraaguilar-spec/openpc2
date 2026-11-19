package com.acme.center.platform.diagnosis.domain.model.commands;

/**
 * Command to register a disease under a diagnosis.
 *
 * @param diseaseName disease name
 * @param category category name as supplied by the REST request
 * @param causativeAgentId causative agent identifier
 * @param commonSymptomsId common symptoms identifier
 * @param transmissionMethodId transmission method identifier
 * @param preventionMethods prevention methods
 * @param diagnosisId parent diagnosis identifier supplied by the path
 * @param mortalityRatePercent mortality rate in the range 0.0 to 1.0
 * @param incidenceRatePer100k incidence rate per 100,000 people
 */
public record CreateDiseaseCommand(
        String diseaseName,
        String category,
        Long causativeAgentId,
        Long commonSymptomsId,
        Long transmissionMethodId,
        String preventionMethods,
        Long diagnosisId,
        Float mortalityRatePercent,
        Integer incidenceRatePer100k) {
}
