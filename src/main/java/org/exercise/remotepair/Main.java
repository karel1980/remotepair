package org.exercise.remotepair;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.exercise.remotepair.core.guice.BasicModule;
import org.exercise.remotepair.core.io.IOService;

public class Main {

    private final IOService ioService;

    @Inject
    public Main(IOService ioService) {
        this.ioService = ioService;
    }

    public static void main(String[] args) throws Exception {
        Injector injector = Guice.createInjector(new BasicModule());
        Main main = injector.getInstance(Main.class);

        main.ioService.output("This works.");
    }

}
