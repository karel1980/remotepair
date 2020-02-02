package org.exercise.remotepair;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.exercise.remotepair.guice.BasicModule;
import org.exercise.remotepair.io.IOService;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;


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
