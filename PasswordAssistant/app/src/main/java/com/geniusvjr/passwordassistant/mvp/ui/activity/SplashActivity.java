package com.geniusvjr.passwordassistant.mvp.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.geniusvjr.passwordassistant.R;
import com.geniusvjr.passwordassistant.mvp.model.eventbus.EventCenter;
import com.geniusvjr.passwordassistant.mvp.ui.activity.base.Base;
import com.geniusvjr.passwordassistant.mvp.ui.activity.base.BaseActivity;
import com.geniusvjr.passwordassistant.utils.SPUtils;

public class SplashActivity extends BaseActivity {

    private static final String CREATE_LOCK_SUCCESS = "CREATE_LOCK_SUCCESS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);// 设置全屏
        new Handler().postDelayed( () ->  pullActivity() , 0);
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return TransitionMode.RIGHT;
    }

    @Override
    protected boolean toggleOverridePendingTransition() {
        return false;
    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }

    private void pullActivity(){
        Boolean isSuccess = (Boolean) SPUtils.get(this, CREATE_LOCK_SUCCESS, false);
        Intent intent = null;
        if(!isSuccess){

        }
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
