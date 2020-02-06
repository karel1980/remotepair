package org.exercise.remotepair.preference;

import com.google.common.base.Preconditions;

import java.util.List;

import static java.util.Collections.emptyList;

public class Preferences {

    private Integer minAge;
    private Integer maxAge;
    private List<Sex> preferredSexes;
    private List<String> personalityTraits;

    private Preferences(Builder builder) {
        Preconditions.checkArgument(builder.minAge >= 18, "no no no");
        minAge = builder.minAge;
        maxAge = builder.maxAge;
        preferredSexes = builder.preferredSexes;
        personalityTraits = builder.personalityTraits;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private Integer minAge;
        private Integer maxAge;
        private List<Sex> preferredSexes = emptyList();
        private List<String> personalityTraits = emptyList();

        private Builder() {
        }

        public Builder withMinAge(Integer val) {
            minAge = val;
            return this;
        }

        public Builder withMaxAge(Integer val) {
            maxAge = val;
            return this;
        }

        public Builder withPreferredSexes(List<Sex> val) {
            preferredSexes = val;
            return this;
        }

        public Builder withPersonalityTraits(List<String> val) {
            personalityTraits = val;
            return this;
        }

        public Preferences build() {
            return new Preferences(this);
        }
    }
}
