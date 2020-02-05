package org.exercise.remotepair.views;

import org.exercise.remotepair.core.io.IOFacade;
import org.exercise.remotepair.profile.ProfileService;
import org.exercise.remotepair.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.exercise.remotepair.user.UserTestConstants.aUserBuilder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProfileViewTest {

    @InjectMocks
    private ProfileView profileView;

    @Mock
    private IOFacade ioFacade;

    @Mock
    private ProfileService profileService;

    private User aUser;
    private User anotherUser;

    @BeforeEach
    void setUp() {
        aUser = aUserBuilder().build();
        anotherUser = aUserBuilder().withName("Miet").build();
        when(profileService.getLikedUsers()).thenReturn(asList(aUser, anotherUser));
    }

    @Test
    void pressingOne_returnsMainView() {
        when(ioFacade.inputMenu(3)).thenReturn(1);

        Class<? extends View> actual = profileView.run();

        assertThat(actual).isEqualTo(MainView.class);
    }

    @Test
    void outputsRightText() {
        when(ioFacade.inputMenu(3)).thenReturn(1);

        profileView.run();

        verify(ioFacade).output("You liked following users, press their number for more info\nPress 1 to exit");
        verify(ioFacade).output(String.format("2. %s %s", aUser.getName(), aUser.getSurName()));
        verify(ioFacade).output(String.format("3. %s %s", anotherUser.getName(), anotherUser.getSurName()));
    }

    @Test
    void pressingTwo_One_outputsRightText() {
        when(ioFacade.inputMenu(3)).thenReturn(2, 1);

        profileView.run();

        verify(ioFacade).output(aUser.getInfo());
    }

    @Test
    void pressingThree_One_outputsRightText() {
        when(ioFacade.inputMenu(3)).thenReturn(3, 1);

        profileView.run();

        verify(ioFacade).output(anotherUser.getInfo());
    }
}