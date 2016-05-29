package com.geniusvjr.jpasswordassistant;

import android.app.Application;

import com.geniusvjr.jpasswordassistant.mvp.model.Constants;
import com.geniusvjr.jpasswordassistant.mvp.model.Realm.RealmMigration;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by dream on 16/5/27.
 */
public class APP extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        initRealm();
    }

    private void initRealm() {
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name("pa.realm")
                .migration(new RealmMigration())
                .schemaVersion(Constants.REALM_VERSION)
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

}
