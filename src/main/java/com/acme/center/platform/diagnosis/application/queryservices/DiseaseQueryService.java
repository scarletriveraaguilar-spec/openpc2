package com.acme.center.platform.diagnosis.application.queryservices;

import com.acme.center.platform.diagnosis.domain.model.aggregates.Disease;
import com.acme.center.platform.diagnosis.domain.model.queries.GetDiseaseByIdQuery;

import java.util.Optional;

/**
 * Application query service contract for diseases.
 */
public interface DiseaseQueryService {
    Optional<Disease> handle(GetDiseaseByIdQuery query);
}
