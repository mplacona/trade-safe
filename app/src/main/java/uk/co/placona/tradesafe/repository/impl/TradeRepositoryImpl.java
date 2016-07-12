package uk.co.placona.tradesafe.repository.impl;

import android.util.Log;

import io.realm.RealmResults;
import uk.co.placona.tradesafe.models.Trade;
import uk.co.placona.tradesafe.repository.DatabaseRealm;
import uk.co.placona.tradesafe.repository.TradeRepository;

/**
 * Created by mplacona on 30/06/2016.
 */
public class TradeRepositoryImpl implements TradeRepository{
    private static final String TAG = "TradeRepositoryImpl";

    DatabaseRealm databaseRealm;

    public TradeRepositoryImpl(DatabaseRealm databaseRealm) {
        this.databaseRealm = databaseRealm;
    }

    @Override
    public RealmResults<Trade> findAll() {
        return databaseRealm.findAll(Trade.class);
    }

    @Override
    public Trade find(String id) {
        return databaseRealm.find(Trade.class, id);
    }

    @Override
    public void upsert(Trade trade) {
        try {
            databaseRealm.upsert(trade);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    @Override
    public void clear() {
        databaseRealm.clear(Trade.class);
    }
}
