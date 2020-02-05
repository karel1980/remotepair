package org.exercise.remotepair.views;

import com.google.inject.Inject;
import org.exercise.remotepair.core.io.IOFacade;
import org.exercise.remotepair.profile.ProfileService;
import org.exercise.remotepair.user.User;

import java.util.List;
import java.util.stream.IntStream;

public class ProfileView implements View {

    private final IOFacade ioFacade;
    private final ProfileService profileService;

    @Inject
    public ProfileView(IOFacade ioFacade, ProfileService profileService) {
        this.ioFacade = ioFacade;
        this.profileService = profileService;
    }

    @Override
    public Class<? extends View> run() {
        ioFacade.output("You liked following users, press their number for more info\nPress 1 to exit");

        List<User> likedUsers = profileService.getLikedUsers();
        IntStream.range(0, likedUsers.size())
                .forEach(i -> ioFacade.output(String.format("%d. %s %s", i + 2, likedUsers.get(i).getName(), likedUsers.get(i).getSurName())));

        int choice;
        do {
            choice = ioFacade.inputMenu(likedUsers.size() + 1);
            if(choice >= 2) {
                ioFacade.output(likedUsers.get(choice - 2).getInfo());
            }
        } while(choice != 1);

        return MainView.class;
    }
}
