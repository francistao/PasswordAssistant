package com.geniusvjr.jpasswordassistant.mvp.presenter.impl;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.text.TextUtils;

import com.geniusvjr.jpasswordassistant.R;
import com.geniusvjr.jpasswordassistant.mvp.model.Constants;
import com.geniusvjr.jpasswordassistant.mvp.model.eventbus.EventCenter;
import com.geniusvjr.jpasswordassistant.mvp.presenter.FragmentPresenter;
import com.geniusvjr.jpasswordassistant.mvp.ui.view.SettingAView;
import com.geniusvjr.jpasswordassistant.utils.SPUtils;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by dream on 16/5/30.
 */
public class SettingFImpl implements FragmentPresenter{

    private final Context mContext;
    private final SettingAView settingAView;
    private Boolean isOpen;
    private boolean isOpenShow;

    public SettingFImpl(Context context, SettingAView view) {
        this.mContext = context;
        this.settingAView = view;
    }

    @Override
    public void onFirstUserVisible() {
        settingAView.findView();
        isOpen = (Boolean) SPUtils.get(mContext, Constants.SETTING.OPEN_GESTURE, true);
        isOpenShow = (boolean) SPUtils.get(mContext, Constants.SETTING.OPEN_PASS_WORD_SHOW, true);
        settingAView.initState(isOpen);
        settingAView.initOpenShow(isOpenShow);
    }

    @Override
    public void onUserVisible() {

    }

    @Override
    public void onUserInvisible() {

    }

    public void onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference){
        String key = preference.getKey();

        if(TextUtils.equals(key, "开启手势密码")){
            isOpen = !isOpen;
            SPUtils.put(mContext, Constants.SETTING.OPEN_GESTURE, isOpen);
        }else if(TextUtils.equals(key, "首页密码可见")){
            isOpenShow = !isOpenShow;
            SPUtils.put(mContext, Constants.SETTING.OPEN_PASS_WORD_SHOW, isOpenShow);
            EventBus.getDefault().post(new EventCenter(Constants.EVEN_BUS.CHANGE_PASS_WORD_SHOW));
        }else if(TextUtils.equals(key, "修改手势密码")){
//            Intent intent = new Intent()
        }else if(TextUtils.equals(key, "更换主题")){
            settingAView.showChangeThemeDialog();
        }else if(TextUtils.equals(key, "意见反馈")){

        }else if(TextUtils.equals(key, "检测更新")){

        }
    }

    public void onThemeChoose(int position){
        SPUtils.put(mContext, mContext.getResources().getString(R.string.change_theme_key), position);
        EventBus.getDefault().post(new EventCenter(Constants.EVEN_BUS.CHANGE_THEME));
        settingAView.reCreate();
    }

}
