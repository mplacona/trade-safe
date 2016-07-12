package uk.co.placona.tradesafe.repository;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class DatabaseRealm {
    Context mContext;

    RealmConfiguration realmConfiguration;

    public DatabaseRealm(Context context) {
        mContext = context;
    }

    public void setup() {
        if (realmConfiguration == null) {
            realmConfiguration = new RealmConfiguration
                    .Builder(mContext)
                    .build();

            Realm.setDefaultConfiguration(realmConfiguration);
        } else {
            throw new IllegalStateException("database already configured");
        }
    }

    public Realm getRealmInstance() {
        return Realm.getDefaultInstance();
    }

    public <T extends RealmObject> T upsert(T model) {
        Realm realm = getRealmInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(model);
        realm.commitTransaction();
        return model;
    }

    public <T extends RealmObject> RealmResults<T> findAll(Class<T> clazz) {
        return getRealmInstance().where(clazz).findAll().sort("date");
    }

    public <T extends RealmObject> T find(Class<T> clazz, String id) {
        return getRealmInstance().where(clazz).equalTo("id", id).findFirst();
    }

    public <T extends RealmObject> void clear(Class<T> clazz){
        Realm realm = getRealmInstance();
        realm.beginTransaction();
        getRealmInstance().delete(clazz);
        realm.commitTransaction();
    }
}