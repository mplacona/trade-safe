package uk.co.placona.tradesafe.component.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.RealmResults;
import uk.co.placona.tradesafe.adapters.TradeRecyclerViewAdapter;
import uk.co.placona.tradesafe.models.Trade;
import uk.co.placona.tradesafe.repository.DatabaseRealm;
import uk.co.placona.tradesafe.repository.StethoDebug;
import uk.co.placona.tradesafe.repository.TradeRepository;
import uk.co.placona.tradesafe.repository.impl.StethoDebugImpl;
import uk.co.placona.tradesafe.repository.impl.TradeRepositoryImpl;

@Module
public class RepositoryModule {
    @Provides
    @Singleton
    public StethoDebug provideStethoDebug(Context context){
        return new StethoDebugImpl(context);
    }

    @Provides
    @Singleton
    public TradeRepository provideTradeRepository(DatabaseRealm databaseRealm) {
        return new TradeRepositoryImpl(databaseRealm);
    }

    @Provides
    @Singleton
    public DatabaseRealm provideDatabaseRealm(Context context) {
        return new DatabaseRealm(context);
    }

//    @Provides
//    @Singleton
//    public TradeRecyclerViewAdapter provideTradeRecyclerViewAdapter(Context context, RealmResults<Trade> realmResults) {
//        return new TradeRecyclerViewAdapter(context, realmResults);
//    }
}