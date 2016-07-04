package uk.co.placona.tradesafe.component.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.placona.tradesafe.repository.DatabaseRealm;
import uk.co.placona.tradesafe.repository.StethoDebug;
import uk.co.placona.tradesafe.repository.TradeRepository;
import uk.co.placona.tradesafe.repository.impl.StethoDebugImpl;
import uk.co.placona.tradesafe.repository.impl.TradeRepositoryImpl;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public TradeRepository provideTradeRepository() {
        return new TradeRepositoryImpl();
    }

    @Provides
    @Singleton
    public DatabaseRealm provideDatabaseRealm() {
        return new DatabaseRealm();
    }

    @Provides
    @Singleton
    public StethoDebug provideStethoDebug(){
        return new StethoDebugImpl();
    }
}