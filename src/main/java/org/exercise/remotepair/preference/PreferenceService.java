package org.exercise.remotepair.preference;

public class PreferenceService {
    private Preferences preferences;

    public void savePreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    public Preferences getPreferences() {
        return preferences;
    }
}
