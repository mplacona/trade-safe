package uk.co.placona.tradesafe.repository.impl;

import android.content.Context;

import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import uk.co.placona.tradesafe.repository.StethoDebug;

/**
 * Created by mplacona on 04/07/2016.
 */
public class StethoDebugImpl implements StethoDebug {
    @Override
    public void setup(Context context) {
        Stetho.initialize(
                Stetho.newInitializerBuilder(context)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(context))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(context).build())
                        .build());
    }
}
