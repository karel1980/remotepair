package org.exercise.remotepair.profile;

import com.google.inject.Inject;
import org.exercise.remotepair.user.User;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class ProfileService {

    private final Profile profile;

    @Inject
    public ProfileService(Profile profile) {
        this.profile = profile;
    }

    public void like(User user) {
        profile.addLikedUser(user);
    }

    public List<User> getLikedUsers() {
        return profile.getLikedUsers();
    }
}
