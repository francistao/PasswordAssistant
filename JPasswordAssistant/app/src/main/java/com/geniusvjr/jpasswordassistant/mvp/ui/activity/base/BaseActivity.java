package com.geniusvjr.jpasswordassistant.mvp.ui.activity.base;

import android.annotation.TargetApi;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.WindowManager;

import com.geniusvjr.jpasswordassistant.R;
import com.geniusvjr.jpasswordassistant.mvp.model.eventbus.EventCenter;
import com.geniusvjr.jpasswordassistant.utils.ThemeUtils;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;

/**
 * Created by dream on 16/5/27.
 */
public abstract class BaseActivity extends Base{


    protected ViewDataBinding mDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initTheme();
        super.onCreate(savedInstanceState);
        //如果是透明主题
        if(isApplyTranslucency()){
            initWindow();
        }
//        mDataBinding = DataBindingUtil.setContentView(this, getContentView());

        if(isApplyButterKnife()){
            ButterKnife.bind(this);
        }

        initToolbar();
        if(isApplyEventBus()){
            EventBus.getDefault().register(this);
        }
    }

    /**
     * api大于19的时候，实现沉浸式状态栏
     */
    @TargetApi(19)
    private void initWindow() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintColor(getStatusBarColor());
            tintManager.setStatusBarTintEnabled(true);
        }
    }

    /**
     * 得到状态栏的颜色
     */
    protected int getStatusBarColor(){
        return getColorPrimary();
    }

    private int getColorPrimary(){
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        return typedValue.data;
    }

    /**
     * 初始化主题
     */
    private void initTheme() {
        ThemeUtils.Theme currentTheme = ThemeUtils.getCurrentTheme(this);
        ThemeUtils.changeTheme(this, currentTheme);
    }

    /**
     * 初始化ToolBar
     * @param toolbar
     */
    protected void initToolBar(Toolbar toolbar){
        if(toolbar == null){
            return;
        }
        toolbar.setBackgroundColor(getColorPrimary());
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }

    /**
     * 重新加载
     * @param anim
     */
    public void reload(boolean anim){
        Intent intent = getIntent();
        if(!anim){
            overridePendingTransition(0, 0);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        }
        finish();
        if(!anim){
            overridePendingTransition(0, 0);
        }
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onDestroy() {
        if (isApplyButterKnife()) ButterKnife.unbind(this);
        if (isApplyEventBus()) EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe
    public void onMessageEvent(EventCenter event){
        if(event != null){
            onEventComing(event);
        }
    }

    protected abstract void onEventComing(EventCenter eventCenter);

    protected abstract int getContentView();

    /**
     * 初始化Toolbar
     */
    protected abstract void initToolbar();

    /**
     * 是否应用透明主题
     * @return
     */
    protected abstract boolean isApplyTranslucency();

    /**
     * 是否应用ButterKnife
     * @return
     */
    protected abstract boolean isApplyButterKnife();

    /**
     * 是否应用EventBus
     * @return
     */
    protected abstract boolean isApplyEventBus();
}
