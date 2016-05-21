package com.geniusvjr.passwordassistant.app;

import android.app.Application;

import com.geniusvjr.passwordassistant.mvp.model.Constants;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;

/**
 * Created by dream on 16/5/21.
 */
public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        initRealm();
    }

    private void initRealm() {
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name("passwordassistant.realm")
                .migration(new com.geniusvjr.passwordassistant.mvp.model.Realm.RealmMigration())
                .schemaVersion(Constants.REALM_VERSION)
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
