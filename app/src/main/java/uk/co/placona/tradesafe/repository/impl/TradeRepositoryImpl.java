package uk.co.placona.tradesafe.repository.impl;

import android.util.Log;

import javax.inject.Inject;

import io.realm.RealmResults;
import uk.co.placona.tradesafe.component.Injector;
import uk.co.placona.tradesafe.models.Trade;
import uk.co.placona.tradesafe.repository.DatabaseRealm;
import uk.co.placona.tradesafe.repository.TradeRepository;

/**
 * Created by mplacona on 30/06/2016.
 */
public class TradeRepositoryImpl implements TradeRepository{
    private static final String TAG = "TradeRepositoryImpl";

    @Inject
    DatabaseRealm databaseRealm;

    public TradeRepositoryImpl() {
        Injector.getApplicationComponent().inject(this);
    }

    @Override
    public RealmResults<Trade> findAll() {
        return databaseRealm.findAll(Trade.class);
    }

    @Override
    public void add(Trade trade) {
        try {
            databaseRealm.add(trade);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    @Override
    public void clear() {
        databaseRealm.clear(Trade.class);
    }
}
