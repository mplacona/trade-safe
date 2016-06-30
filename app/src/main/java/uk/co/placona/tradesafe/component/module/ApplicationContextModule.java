package uk.co.placona.tradesafe.component.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.placona.tradesafe.CustomApplication;

@Module
public class ApplicationContextModule {

    private final CustomApplication application;

    public ApplicationContextModule(CustomApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public CustomApplication application() {
        return application;
    }

    @Provides
    @Singleton
    public Context applicationContext() {
        return application.getApplicationContext();
    }

}