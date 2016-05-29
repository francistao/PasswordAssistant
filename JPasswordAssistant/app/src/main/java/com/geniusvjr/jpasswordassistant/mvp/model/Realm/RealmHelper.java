package com.geniusvjr.jpasswordassistant.mvp.model.Realm;

import android.content.Context;

import com.geniusvjr.jpasswordassistant.mvp.model.bean.God;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by dream on 16/5/29.
 */
public class RealmHelper {

    //懒汉式单例
    private static RealmHelper instances;
    private Context mContext;

    private RealmHelper(Context context){
        mContext = context;
    }

    public static RealmHelper getInstances(Context context){
        synchronized (RealmHelper.class){
            if(instances == null){
                instances = new RealmHelper(context);
            }
        }
        return instances;
    }

    //关闭连接
    private static void closeConnect(Realm realm){
        if(realm != null){
            try{
                realm.close();
                realm = null;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private static RealmConfiguration secure(Context context){
        byte[] key = new byte[64];
        new SecureRandom().nextBytes(key);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(context)
                .encryptionKey(key)
                .build();

        // Start with a clean slate every time
        Realm.deleteRealm(realmConfiguration);
        return realmConfiguration;
    }

    public static ArrayList<God> selector(Context context, int godType){
        Realm realm = Realm.getInstance(context);
        RealmQuery<God> realmQuery = realm.where(God.class);
        RealmQuery<God> godRealmQuery = realmQuery.equalTo("godType", godType);
        RealmResults<God> realmResults = godRealmQuery.findAll();
        if (realmResults != null && realmResults.size() > 0) {
            ArrayList<God> godList = new ArrayList<>();
            for (God god : realmResults) {
                godList.add(god);
            }
            Collections.reverse(godList);
            return godList;
        }
        return null;
    }

    /**
     * 保存
     * @param context
     * @param god
     * @return
     */
    public static boolean save(Context context, God god) {
        if (check(context, god)) {
            return true;
        }
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        realm.copyToRealm(god);
        realm.commitTransaction();
        return false;
    }

    /**
     * 检查
     * @param context
     * @param god
     * @return
     */
    private static boolean check(Context context, God god) {
        int godType = god.getGodType();
        Realm realm = Realm.getInstance(context);
        RealmQuery<God> realmQuery = realm.where(God.class);
        RealmQuery<God> godRealmQuery = realmQuery.equalTo("godType", godType);
        RealmResults<God> title = godRealmQuery.contains("title", god.getTitle()).findAll();
        if (title!=null&&title.size()>0) {
            return true;
        }
        return false;
    }

    /**
     * 更新数据库
     * @param context 上下文
     * @param god bean
     * @return 成功返回true
     */
    public static boolean update(Context context, God god) {
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(god);
        realm.commitTransaction();
        return true;
    }

    /**
     * 删除
     * @param context
     * @param god
     * @param position
     */
    public static void delete(Context context, God god, int position) {
        Realm realm = Realm.getInstance(context);
        RealmQuery<God> realmQuery = realm.where(God.class);
        RealmQuery<God> godRealmQuery = realmQuery.equalTo("godType", god.getGodType());
        RealmResults<God> realmResults = godRealmQuery.findAll();
        if (realmResults != null ) {
            int size = realmResults.size() - 1;
            int i = size - position;
            realm.beginTransaction();
            realmResults.remove(i);
            realm.commitTransaction();
        }
    }
}
