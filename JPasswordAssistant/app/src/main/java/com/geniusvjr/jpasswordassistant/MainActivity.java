package com.geniusvjr.jpasswordassistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;

import com.geniusvjr.jpasswordassistant.mvp.model.eventbus.EventCenter;
import com.geniusvjr.jpasswordassistant.mvp.ui.activity.base.Base;
import com.geniusvjr.jpasswordassistant.mvp.ui.activity.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return null;
    }

    @Override
    protected boolean toggleOverridePendingTransition() {
        return false;
    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }

    @Override
    protected int getContentView() {
        return 0;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected boolean isApplyTranslucency() {
        return false;
    }

    @Override
    protected boolean isApplyButterKnife() {
        return false;
    }

    @Override
    protected boolean isApplyEventBus() {
        return false;
    }
}
