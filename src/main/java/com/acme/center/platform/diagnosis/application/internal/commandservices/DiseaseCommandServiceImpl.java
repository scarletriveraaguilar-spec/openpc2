package com.acme.center.platform.diagnosis.application.internal.commandservices;

import com.acme.center.platform.diagnosis.application.commandservices.DiseaseCommandService;
import com.acme.center.platform.diagnosis.domain.model.aggregates.Disease;
import com.acme.center.platform.diagnosis.domain.model.commands.CreateDiseaseCommand;
import com.acme.center.platform.diagnosis.domain.repositories.DiseaseRepository;
import com.acme.center.platform.shared.application.result.ApplicationError;
import com.acme.center.platform.shared.application.result.Result;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Executes disease creation commands.
 */
@Service
public class DiseaseCommandServiceImpl implements DiseaseCommandService {

    private final DiseaseRepository diseaseRepository;

    public DiseaseCommandServiceImpl(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    @Override
    @Transactional
    public Result<Disease, ApplicationError> handle(CreateDiseaseCommand command) {
        // Domain constructors enforce invariants; IllegalArgumentException is translated
        // by the original shared GlobalExceptionHandler into a localized ProblemDetail.
        final Disease disease = new Disease(command);

        if (diseaseRepository.existsByDiseaseNameAndCausativeAgentIdAndDiagnosisId(
                disease.getDiseaseName(),
                disease.getCausativeAgentId().id(),
                disease.getDiagnosisId().id())) {
            return Result.failure(ApplicationError.conflict(
                    "Disease",
                    "A disease with the same name, causative agent and diagnosis already exists."));
        }

        try {
            return Result.success(diseaseRepository.save(disease));
        } catch (DataIntegrityViolationException exception) {
            return Result.failure(ApplicationError.conflict(
                    "Disease",
                    "A disease with the same name, causative agent and diagnosis already exists."));
        } catch (RuntimeException exception) {
            return Result.failure(ApplicationError.unexpected("create-disease", exception.getMessage()));
        }
    }
}
