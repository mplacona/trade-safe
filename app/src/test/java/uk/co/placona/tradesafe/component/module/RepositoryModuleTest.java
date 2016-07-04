package uk.co.placona.tradesafe.component.module;

import uk.co.placona.tradesafe.repository.DatabaseRealm;
import uk.co.placona.tradesafe.repository.StethoDebug;
import uk.co.placona.tradesafe.repository.TradeRepository;
import uk.co.placona.tradesafe.repository.impl.TradeRepositoryImpl;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;

@Module
public class RepositoryModuleTest {

    private boolean isMocked;

    public RepositoryModuleTest(boolean isMocked) {
        this.isMocked = isMocked;
    }

    @Provides
    @Singleton
    public TradeRepository provideTradeRepository() {
        return isMocked ? mock(TradeRepository.class) : new TradeRepositoryImpl();
    }

    @Provides
    @Singleton
    public DatabaseRealm provideDatabaseHelper() {
        return mock(DatabaseRealm.class);
    }

    @Provides
    @Singleton
    public StethoDebug provideStethoDebug() {
        return mock(StethoDebug.class);
    }
}
