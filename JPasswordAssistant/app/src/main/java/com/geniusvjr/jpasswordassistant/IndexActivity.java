package com.geniusvjr.jpasswordassistant;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;

import com.geniusvjr.jpasswordassistant.mvp.model.eventbus.EventCenter;
import com.geniusvjr.jpasswordassistant.mvp.ui.activity.base.Base;
import com.geniusvjr.jpasswordassistant.mvp.ui.activity.base.BaseActivity;
import com.geniusvjr.jpasswordassistant.mvp.ui.view.IndexAView;

public class IndexActivity extends BaseActivity implements IndexAView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        return R.layout.activity_index;
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

    @Override
    public void initDrawerToggle() {

    }

    @Override
    public void initXViewPager() {

    }

    @Override
    public void readyGoForResult(Class clazz) {

    }

    @Override
    public void go2Setting() {

    }

    @Override
    public void showSnackBar(String msg) {
//        Snackbar.make()
    }

    @Override
    public void kill() {
        finish();
    }
}
