package uk.co.placona.tradesafe.component.module;

import android.content.Context;

import org.robolectric.RuntimeEnvironment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationContextModuleTest {

    @Provides
    @Singleton
    public Context applicationContext() {
        return RuntimeEnvironment.application.getApplicationContext();
    }
}
