package org.exercise.remotepair;

import com.google.inject.Inject;
import org.exercise.remotepair.core.io.IOFacade;

import java.util.List;

public class UserInfoRepository {
    private List<String> personalityTraits;
    private List<String> femaleNames;
    private List<String> maleNames;
    private List<String> surnames;

    private final IOFacade ioFacade;

    @Inject
    public UserInfoRepository(IOFacade ioFacade) {
        this.ioFacade = ioFacade;
    }

    public List<String> getPersonalityTraits() {
        if (personalityTraits == null) {
            personalityTraits = ioFacade.readFile("adjectives.txt");
        }
        return personalityTraits;
    }

    public List<String> getFemaleNames() {
        if (femaleNames == null) {
            femaleNames = ioFacade.readFile("femalenames.txt");
        }
        return femaleNames;
    }

    public List<String> getMaleNames() {
        if (maleNames == null) {
            maleNames = ioFacade.readFile("malenames.txt");
        }
        return maleNames;
    }

    public List<String> getSurnames() {
        if (surnames == null) {
            surnames = ioFacade.readFile("surnames.txt");
        }
        return surnames;
    }
}
