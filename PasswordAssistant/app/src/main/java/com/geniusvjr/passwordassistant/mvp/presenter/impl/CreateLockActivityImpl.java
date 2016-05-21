package com.geniusvjr.passwordassistant.mvp.presenter.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.geniusvjr.passwordassistant.databinding.ActivityCreateLockBinding;
import com.geniusvjr.passwordassistant.mvp.model.bean.LockBean;
import com.geniusvjr.passwordassistant.mvp.presenter.ActivityPresenter;
import com.geniusvjr.passwordassistant.mvp.ui.view.CreateLockAView;

/**
 * Created by dream on 16/5/21.
 */
public class CreateLockActivityImpl implements ActivityPresenter{


    private static final String CREATE_LOCK_SUCCESS = "CREATE_LOCK_SUCCESS";
    private final Context mContext;
    private final ActivityCreateLockBinding mBinding;
    private LockBean lockBeanText;
    private final CreateLockAView mCreateLockAView;
    private boolean isFinishOnce = false;
    private int createMode;

    public CreateLockActivityImpl(Context context, CreateLockAView view,ActivityCreateLockBinding binding) {
        mContext = context;
        mCreateLockAView = view;
        mBinding = binding;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

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
