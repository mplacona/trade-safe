package uk.co.placona.tradesafe.component;

import javax.inject.Singleton;

import dagger.Component;
import uk.co.placona.tradesafe.CustomApplication;
import uk.co.placona.tradesafe.repository.impl.StethoDebugImpl;
import uk.co.placona.tradesafe.view.MainActivity;
import uk.co.placona.tradesafe.component.module.ApplicationContextModule;
import uk.co.placona.tradesafe.component.module.RepositoryModule;
import uk.co.placona.tradesafe.repository.DatabaseRealm;
import uk.co.placona.tradesafe.repository.impl.TradeRepositoryImpl;

@Singleton
@Component(modules = {ApplicationContextModule.class, RepositoryModule.class})
public interface ApplicationComponent {

    void inject(CustomApplication application);
    void inject(MainActivity mainActivity);

    void inject(DatabaseRealm databaseRealm);
    void inject(TradeRepositoryImpl tradeRepository);
    void inject(StethoDebugImpl stethoDebug);

}
