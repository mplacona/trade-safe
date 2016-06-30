package uk.co.placona.tradesafe.App;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import java.util.concurrent.atomic.AtomicLong;

import co.moonmonkeylabs.realmrecyclerview.RealmRecyclerView;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import uk.co.placona.tradesafe.Models.Trade;
import uk.co.placona.tradesafe.R;

/**
 * Created by mplacona on 27/06/2016.
 */
public class MyApplication extends Application {
    public static Realm realm;
    public static RealmConfiguration realmConfig;
    public static AtomicLong primaryKeyValue;

    @Override
    public void onCreate() {
        super.onCreate();

        initialiseRealm();

        initialiseStetho();
    }

    public void initialiseRealm() {
        realmConfig = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(realmConfig);

        realm = Realm.getDefaultInstance();

        primaryKeyValue = new AtomicLong(realm.where(Trade.class).max("id").longValue());
    }

    public void initialiseStetho(){
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());
    }
}
