package org.exercise.remotepair.preference;

import com.google.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class PreferenceServiceTest {

    @InjectMocks
    private PreferenceService service;

    @Test
    public void savePreferences() {
        Preferences preferences = aPreferences();
        service.savePreferences(preferences);

        assertThat(service.getPreferences()).isEqualTo(preferences);
    }

    private Preferences aPreferences() {
        return Preferences.newBuilder()
                .withMinAge(25)
                .withMaxAge(50)
                .withPreferredSexes(singletonList(Sex.MALE))
                .withPersonalityTraits(asList(
                        "warm", "serene", "maybe"
                ))
                .build();
    }


}