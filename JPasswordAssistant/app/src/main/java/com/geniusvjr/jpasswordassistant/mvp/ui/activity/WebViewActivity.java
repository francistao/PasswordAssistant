package com.geniusvjr.jpasswordassistant.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.geniusvjr.jpasswordassistant.R;
import com.geniusvjr.jpasswordassistant.mvp.model.eventbus.EventCenter;
import com.geniusvjr.jpasswordassistant.mvp.ui.activity.base.Base;
import com.geniusvjr.jpasswordassistant.mvp.ui.activity.base.BaseSwipeBackActivity;
import com.geniusvjr.jpasswordassistant.widget.BrowserLayout;

import butterknife.Bind;

/**
 * Created by dream on 16/5/29.
 */
public class WebViewActivity extends BaseSwipeBackActivity {

    @Bind(R.id.common_toolbar)
    Toolbar mToolBar;
    @Bind(R.id.brower)
    BrowserLayout mBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();
            String url = bundle.getString("URL");
            mBrowser.loadUrl(url);
        }
    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_web_view;
    }

    @Override
    protected void initToolbar() {
        initToolBar(mToolBar);
        mToolBar.setTitle("作者博客");
    }

    @Override
    public void onBackPressed() {
        if(mBrowser.canGoBack()){
            mBrowser.getWebView().goBack();
        }else {
            super.onBackPressed();
        }
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
        return false;
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return null;
    }

    @Override
    protected boolean toggleOverridePendingTransition() {
        return false;
    }
}
