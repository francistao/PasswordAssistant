package com.geniusvjr.jpasswordassistant;

import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.BaseAdapter;

import com.geniusvjr.jpasswordassistant.databinding.ActivityIndexBinding;
import com.geniusvjr.jpasswordassistant.mvp.model.eventbus.EventCenter;
import com.geniusvjr.jpasswordassistant.mvp.ui.activity.base.Base;
import com.geniusvjr.jpasswordassistant.mvp.ui.activity.base.BaseActivity;
import com.geniusvjr.jpasswordassistant.mvp.ui.view.IndexAView;

import butterknife.Bind;

public class IndexActivity extends BaseActivity implements IndexAView{

    private static final int INDEX_REQUEST_CODE = 1;
    private static final int SETTING_REQUEST_CODE = 2;
    private static final int EDIT_SAVE = 1;
    private int SUCCESS = 1;

    @Bind(R.id.common_toolbar)
    Toolbar mToolBar;


    private ActivityIndexBinding mDataBinding;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private int INDEX_EVENT_SUCCESS = 1;

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
