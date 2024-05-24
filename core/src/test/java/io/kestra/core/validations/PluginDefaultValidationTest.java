package io.kestra.core.validations;

import io.kestra.core.models.flows.PluginDefault;
import io.kestra.core.models.validations.ModelValidator;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@MicronautTest
class PluginDefaultValidationTest {
    @Inject
    private ModelValidator modelValidator;

    @Test
    void nullValue() {
        PluginDefault pluginDefault = PluginDefault.builder()
            .type("io.kestra.tests")
            .build();

        Optional<ConstraintViolationException> validate = modelValidator.isValid(pluginDefault);

        assertThat(validate.isPresent(), is(true));
    }

}