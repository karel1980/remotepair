package org.exercise.remotepair.views;

import org.exercise.remotepair.core.io.IOFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PreferencesViewTest {
    @InjectMocks
    private PreferencesView preferencesView;

    @Mock
    private IOFacade ioFacade;

    @Test
    public void hello() {
        //todo
    }
}