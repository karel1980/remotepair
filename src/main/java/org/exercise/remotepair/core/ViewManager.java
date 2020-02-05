package org.exercise.remotepair.core;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.exercise.remotepair.core.guice.BasicModule;
import org.exercise.remotepair.views.View;

public class ViewManager {

    private Injector injector;

    @Inject
    public ViewManager() {
        injector = Guice.createInjector(new BasicModule());
    }

    public void start(Class<? extends View> viewClass) {
        while (viewClass != null) {
            View view = injector.getInstance(viewClass);
            viewClass = view.run();
        }
    }
}
