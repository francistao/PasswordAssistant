package com.geniusvjr.passwordassistant.mvp.ui.activity;

import com.geniusvjr.passwordassistant.mvp.model.eventbus.EventCenter;
import com.geniusvjr.passwordassistant.mvp.ui.activity.base.Base;
import com.geniusvjr.passwordassistant.mvp.ui.activity.base.BaseActivity;

/**
 * Created by dream on 16/5/21.
 */
public class CreateLockActivity extends BaseActivity {


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

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return null;
    }

    @Override
    protected boolean toggleOverridePendingTransition() {
        return false;
    }
}
