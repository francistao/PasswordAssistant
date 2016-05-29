package com.geniusvjr.jpasswordassistant.mvp.ui.activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.BaseAdapter;

import com.geniusvjr.jpasswordassistant.R;
import com.geniusvjr.jpasswordassistant.databinding.ActivityIndexBinding;
import com.geniusvjr.jpasswordassistant.mvp.model.Constants;
import com.geniusvjr.jpasswordassistant.mvp.model.eventbus.EventCenter;
import com.geniusvjr.jpasswordassistant.mvp.presenter.impl.IndexPreImpl;
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

    private IndexPreImpl mIndexPre;
    private ActivityIndexBinding mDataBinding;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private int INDEX_EVENT_SUCCESS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataBinding = (ActivityIndexBinding) super.mDataBinding;
        mIndexPre = new IndexPreImpl(this, this, mDataBinding);
        mIndexPre.onCreate(savedInstanceState);
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

    @Override
    protected int getContentView() {
        return R.layout.activity_index;
    }

    @Override
    protected void initToolbar() {
        super.initToolBar(mToolBar);
    }

    @Override
    protected boolean isApplyTranslucency() {
        return true;
    }

    @Override
    protected boolean isApplyButterKnife() {
        return true;
    }

    @Override
    protected boolean isApplyEventBus() {
        return true;
    }

    @Override
    public void initDrawerToggle() {
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDataBinding.drawerLayout, mDataBinding.commonToolbar, 0, 0){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        mActionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        mDataBinding.drawerLayout.setDrawerListener(mActionBarDrawerToggle);
    }

    @Override
    public void initXViewPager() {

    }

    @Override
    public void readyGoForResult(Class clazz) {
        Intent intent = new Intent(this, clazz);
        intent.putExtra("CREATE_MODE", Constants.CREATE_MODE);
        startActivityForResult(intent, INDEX_REQUEST_CODE);
    }

    @Override
    public void go2Setting() {

    }

    @Override
    public void showSnackBar(String msg) {
        Snackbar.make(mToolBar, msg, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void kill() {
        finish();
    }

    @Override
    public void onBackPressed() {
        if(mIndexPre.onBackPress()){
            super.onBackPressed();
        }
    }
}
