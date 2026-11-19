package com.acme.center.platform.diagnosis.application.internal.queryservices;

import com.acme.center.platform.diagnosis.application.queryservices.DiseaseQueryService;
import com.acme.center.platform.diagnosis.domain.model.aggregates.Disease;
import com.acme.center.platform.diagnosis.domain.model.queries.GetDiseaseByIdQuery;
import com.acme.center.platform.diagnosis.domain.repositories.DiseaseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Executes disease retrieval queries.
 */
@Service
public class DiseaseQueryServiceImpl implements DiseaseQueryService {

    private final DiseaseRepository diseaseRepository;

    public DiseaseQueryServiceImpl(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    @Override
    public Optional<Disease> handle(GetDiseaseByIdQuery query) {
        return diseaseRepository.findById(query.diseaseId());
    }
}
