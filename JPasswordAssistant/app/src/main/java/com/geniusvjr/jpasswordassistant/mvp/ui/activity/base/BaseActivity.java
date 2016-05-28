package com.geniusvjr.jpasswordassistant.mvp.ui.activity.base;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.geniusvjr.jpasswordassistant.mvp.model.eventbus.EventCenter;

/**
 * Created by dream on 16/5/27.
 */
public abstract class BaseActivity extends Base{


    protected ViewDataBinding mDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    protected abstract void onEventComing(EventCenter eventCenter);

    protected abstract int getContentView();

    protected abstract void initToolbar();

    protected abstract boolean isApplyTranslucency();

    protected abstract boolean isApplyButterKnife();

    protected abstract boolean isApplyEventBus();
}
