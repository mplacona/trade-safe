package uk.co.placona.tradesafe.component.module;

import android.content.Context;

import io.realm.RealmResults;
import uk.co.placona.tradesafe.adapters.TradeRecyclerViewAdapter;
import uk.co.placona.tradesafe.models.Trade;
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
    public TradeRepository provideTradeRepository(DatabaseRealm databaseRealm) {
        return isMocked ? mock(TradeRepository.class) : new TradeRepositoryImpl(databaseRealm);
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

//    @Provides
//    @Singleton
//    public TradeRecyclerViewAdapter provideTradeRecyclerViewAdapter() {
//        return mock(TradeRecyclerViewAdapter.class);
//    }
}
