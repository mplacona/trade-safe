package uk.co.placona.tradesafe.repository.impl;

import android.content.Context;

import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import uk.co.placona.tradesafe.repository.StethoDebug;

/**
 * Created by mplacona on 04/07/2016.
 */
public class StethoDebugImpl implements StethoDebug {

    Context mContext;

    public StethoDebugImpl(Context context) {
        mContext = context;
    }

    @Override
    public void setup() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(mContext)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(mContext))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(mContext).build())
                        .build());
    }
}
