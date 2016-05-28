package com.geniusvjr.jpasswordassistant.mvp.presenter.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;

import com.geniusvjr.jpasswordassistant.databinding.ActivityIndexBinding;
import com.geniusvjr.jpasswordassistant.mvp.presenter.ActivityPresenter;
import com.geniusvjr.jpasswordassistant.mvp.ui.activity.EditActivity;
import com.geniusvjr.jpasswordassistant.mvp.ui.view.IndexAView;
import com.jakewharton.rxbinding.view.RxView;

import java.util.concurrent.TimeUnit;

/**
 * Created by dream on 16/5/28.
 */
public class IndexPreImpl implements ActivityPresenter{


    private final Context mContext;
    private final ActivityIndexBinding mDataBinding;
    private final IndexAView mIndexView;
    private int currentSelectedItem = 0;
    private static long DOUBLE_CLICK_TIME = 0L;

    public IndexPreImpl(Context context, IndexAView view, ActivityIndexBinding dataBinding) {
        this.mContext = context;
        mIndexView = view;
        mDataBinding = dataBinding;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        mIndexView.initDrawerToggle();
        mIndexView.initXViewPager();
        FloatingActionButton fab = mDataBinding.fab;
        RxView.clicks(fab).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe((aVoid) ->mIndexView.readyGoForResult(EditActivity.class));
//        mDataBinding.na
    }

    @Override
    public void getIntent(Intent intent) {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }
}
