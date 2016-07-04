package uk.co.placona.tradesafe.component;

import uk.co.placona.tradesafe.CustomApplication;
import uk.co.placona.tradesafe.component.module.ApplicationContextModule;
import uk.co.placona.tradesafe.component.module.RepositoryModule;

/**
 * Created by mplacona on 30/06/2016.
 */
public class Injector {
    private static ApplicationComponent applicationComponent;

    public static void initializeApplicationComponent(CustomApplication myApplication) {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationContextModule(new ApplicationContextModule(myApplication))
                .repositoryModule(new RepositoryModule())
                .build();
    }

    public static ApplicationComponent getApplicationComponent() {
        //Objects..requireNonNull(applicationComponent, "applicationComponent is null");
        return applicationComponent;
    }
}
