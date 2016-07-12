package uk.co.placona.tradesafe;

import android.app.Application;

import javax.inject.Inject;

import uk.co.placona.tradesafe.component.ApplicationComponent;
import uk.co.placona.tradesafe.component.DaggerApplicationComponent;
import uk.co.placona.tradesafe.component.module.ApplicationContextModule;
import uk.co.placona.tradesafe.component.module.RepositoryModule;
import uk.co.placona.tradesafe.repository.DatabaseRealm;
import uk.co.placona.tradesafe.repository.StethoDebug;

public class CustomApplication extends Application {

    @Inject
    DatabaseRealm databaseRealm;

    @Inject
    StethoDebug stethoDebug;

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        setup();
    }

    public void setup(){
        getOrCreateApplicationComponent().inject(this);
        databaseRealm.setup();
        stethoDebug.setup();
    }

    public ApplicationComponent getOrCreateApplicationComponent() {
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.builder()
                    .applicationContextModule(new ApplicationContextModule(this))
                    .repositoryModule(new RepositoryModule())
                    .build();
        }

        return applicationComponent;
    }
}
