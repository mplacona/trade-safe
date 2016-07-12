package uk.co.placona.tradesafe;

import uk.co.placona.tradesafe.component.ApplicationComponent;
import uk.co.placona.tradesafe.component.DaggerApplicationComponentTest;
import uk.co.placona.tradesafe.component.module.ApplicationContextModuleTest;
import uk.co.placona.tradesafe.component.module.RepositoryModuleTest;

/**
 * Created by mplacona on 02/07/2016.
 */
public class TestCustomApplication extends CustomApplication {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public ApplicationComponent getOrCreateApplicationComponent() {
        return DaggerApplicationComponentTest.builder()
                .applicationContextModuleTest(new ApplicationContextModuleTest())
                .repositoryModuleTest(new RepositoryModuleTest(false))
                .build();
    }
}
