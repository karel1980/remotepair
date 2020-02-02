package org.exercise.remotepair.user;

import org.exercise.remotepair.core.InstanceBuilder;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String surName;
    private List<String> personalityTraits;

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public List<String> getPersonalityTraits() {
        return new ArrayList<>(personalityTraits);
    }

    public String getInfo() {
        String traits = getPersonalityString();
        return String.format("Hello, my name is %s %s. I am %s.", name, surName, traits);
    }

    private String getPersonalityString() {
        String traits = personalityTraits.get(personalityTraits.size() - 1);
        if (personalityTraits.size() > 1) {
            List<String> firstTraits = personalityTraits.subList(0, personalityTraits.size() - 1);
            String joinedTraits = String.join(", ", firstTraits);
            traits = String.format("%s and %s", joinedTraits, traits);
        }
        return traits;
    }

    public static class Builder extends InstanceBuilder<User> {
        public Builder withName(String name) {
            instance.name = name;
            return this;
        }

        public Builder withSurName(String surName) {
            instance.surName = surName;
            return this;
        }

        public Builder withPersonalityTraits(List<String> personalityTraits) {
            instance.personalityTraits = personalityTraits;
            return this;
        }

        @Override
        protected User instance() {
            return new User();
        }
    }
}
