package uk.co.placona.tradesafe;

import android.app.Application;

import javax.inject.Inject;

import uk.co.placona.tradesafe.component.Injector;
import uk.co.placona.tradesafe.repository.DatabaseRealm;
import uk.co.placona.tradesafe.repository.StethoDebug;

public class CustomApplication extends Application {

    @Inject
    DatabaseRealm databaseRealm;

    @Inject
    StethoDebug stethoDebug;

    @Override
    public void onCreate() {
        super.onCreate();

        setup();
    }

    public void setup(){
        Injector.initializeApplicationComponent(this);
        Injector.getApplicationComponent().inject(this);
        databaseRealm.setup();
        stethoDebug.setup(this);
    }

//    public void initialiseStetho(){
//        Stetho.initialize(
//                Stetho.newInitializerBuilder(this)
//                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
//                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
//                        .build());
//    }
}
