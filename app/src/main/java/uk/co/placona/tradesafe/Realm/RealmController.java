package uk.co.placona.tradesafe.Realm;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import io.realm.Realm;
import io.realm.RealmResults;
import uk.co.placona.tradesafe.Models.Trade;

/**
 * Created by mplacona on 27/06/2016.
 */
public class RealmController {
    private static RealmController instance;
    private final Realm realm;

    public RealmController(Application application) {
        realm = Realm.getDefaultInstance();
    }

    public static RealmController with(Fragment fragment) {

        if (instance == null) {
            instance = new RealmController(fragment.getActivity().getApplication());
        }
        return instance;
    }

    public static RealmController with(Activity activity) {

        if (instance == null) {
            instance = new RealmController(activity.getApplication());
        }
        return instance;
    }

    public static RealmController with(Application application) {

        if (instance == null) {
            instance = new RealmController(application);
        }
        return instance;
    }

    public static RealmController getInstance() {

        return instance;
    }

    public Realm getRealm() {

        return realm;
    }

    //Refresh the realm istance
    public void refresh() {

        realm.waitForChange();
    }

    //clear all objects from Trade.class
    public void clearAll() {

        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }

    //find all objects in the Trade.class
    public RealmResults<Trade> getTrades() {

        return realm.where(Trade.class).findAll();
    }

    //query a single item with the given id
    public Trade getTrade(String id) {

        return realm.where(Trade.class).equalTo("id", id).findFirst();
    }

    //check if Trade.class is empty
    public boolean hasTrades() {

        return !realm.where(Trade.class).findAll().isEmpty();
    }

    //query example
    public RealmResults<Trade> queryedTrades() {

        return realm.where(Trade.class)
                .contains("author", "Author 0")
                .or()
                .contains("title", "Realm")
                .findAll();

    }
}
