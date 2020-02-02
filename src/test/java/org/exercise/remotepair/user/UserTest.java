package org.exercise.remotepair.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {
    private User.Builder userBuilder;

    @BeforeEach
    void setUp() {
        userBuilder = new User.Builder()
                .withName("Jantje")
                .withSurName("Peeters")
                .withPersonalityTraits(Arrays.asList("funny", "happy", "witty"));
    }

    @Test
    void getInfo() {
        User user = userBuilder.build();

        String actual = user.getInfo();

        assertThat(actual).isEqualTo("Hello, my name is Jantje Peeters. I am funny, happy and witty.");
    }

    @Test
    void getInfo_onePersonalityTrait() {
        User user = userBuilder.withPersonalityTraits(Collections.singletonList("witty")).build();

        String actual = user.getInfo();

        assertThat(actual).isEqualTo("Hello, my name is Jantje Peeters. I am witty.");
    }

    @Test
    void changingPersonalityList_doesNotChangeUserList() {
        User user = userBuilder.build();

        user.getPersonalityTraits().set(0, "stinky");

        assertThat(user.getPersonalityTraits()).doesNotContain("stinky");
    }
}