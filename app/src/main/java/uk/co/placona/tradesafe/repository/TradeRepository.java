package uk.co.placona.tradesafe.repository;

import java.util.List;

import io.realm.RealmQuery;
import io.realm.RealmResults;
import uk.co.placona.tradesafe.models.Trade;

/**
 * Created by mplacona on 30/06/2016.
 */
public interface TradeRepository {
    Trade find(String id);
    RealmResults<Trade> findAll();
    void upsert(Trade trade);
    void clear();
}
