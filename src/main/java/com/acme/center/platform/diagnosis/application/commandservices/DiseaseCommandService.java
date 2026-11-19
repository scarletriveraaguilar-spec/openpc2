package com.acme.center.platform.diagnosis.application.commandservices;

import com.acme.center.platform.diagnosis.domain.model.aggregates.Disease;
import com.acme.center.platform.diagnosis.domain.model.commands.CreateDiseaseCommand;
import com.acme.center.platform.shared.application.result.ApplicationError;
import com.acme.center.platform.shared.application.result.Result;

/**
 * Application service contract for disease commands.
 */
public interface DiseaseCommandService {
    Result<Disease, ApplicationError> handle(CreateDiseaseCommand command);
}
