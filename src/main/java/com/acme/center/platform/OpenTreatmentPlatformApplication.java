package com.acme.center.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import com.acme.center.platform.shared.infrastructure.security.configuration.WebSecurityConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Bootstrap class for the Open Treatment application.
 *
 * <p>Initializes Spring Boot auto-configuration and JPA auditing infrastructure.</p>
 */
@EnableJpaAuditing
@SpringBootApplication
@Import(WebSecurityConfiguration.class)
public class OpenTreatmentPlatformApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenTreatmentPlatformApplication.class, args);
    }
}
