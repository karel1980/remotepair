package org.exercise.remotepair;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.exercise.remotepair.core.RandomFacade;
import org.exercise.remotepair.core.guice.BasicModule;
import org.exercise.remotepair.core.io.IOFacade;

public class Main {

    private final IOFacade ioFacade;

    private final RandomFacade randomFacade;

    @Inject
    public Main(IOFacade ioFacade, RandomFacade randomFacade) {
        this.ioFacade = ioFacade;
        this.randomFacade = randomFacade;
    }

    public static void main(String[] args) throws Exception {
        Injector injector = Guice.createInjector(new BasicModule());
        Main main = injector.getInstance(Main.class);
    }

}
