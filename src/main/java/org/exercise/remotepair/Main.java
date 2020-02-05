package org.exercise.remotepair;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.exercise.remotepair.core.ViewManager;
import org.exercise.remotepair.core.guice.BasicModule;
import org.exercise.remotepair.views.MainView;

public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BasicModule());
        ViewManager viewManager = injector.getInstance(ViewManager.class);

        viewManager.start(MainView.class);
    }

}
