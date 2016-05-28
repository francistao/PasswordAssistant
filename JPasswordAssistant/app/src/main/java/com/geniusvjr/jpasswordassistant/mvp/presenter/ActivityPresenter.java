package com.geniusvjr.jpasswordassistant.mvp.presenter;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by dream on 16/5/28.
 */
public interface ActivityPresenter {

    void onCreate(Bundle savedInstanceState);

    void getIntent(Intent intent);

    void onResume();

    void onStart();

    void onPause();

    void onStop();

    void onDestroy();


}
