package com.geniusvjr.jpasswordassistant.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geniusvjr.jpasswordassistant.mvp.model.eventbus.EventCenter;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.Field;

import butterknife.ButterKnife;

/**
 * Created by dream on 16/5/28.
 */
public abstract class BaseFragment extends Fragment{

    private boolean isFirstResume = true;
    private boolean isFirstVisible = true;
    private boolean isFirstInvisible = true;
    private boolean isPrepared;
    protected FragmentActivity mActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getContentViewLayoutID(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mActivity = getActivity();
        if (isApplyButterKnife()) ButterKnife.bind(this, view);
        if (isApplyEventBus()) EventBus.getDefault().register(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPrepare();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        if (isApplyEventBus()) EventBus.getDefault().unregister(this);
        if (isApplyButterKnife()) ButterKnife.unbind(this);
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(isFirstResume){
            isFirstResume = false;
            return;
        }
        if(getUserVisibleHint()){
            onUserVisible();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(getUserVisibleHint()){
            onUserInvisible();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            if(isFirstVisible){
                isFirstVisible = false;
                initPrepare();
            }else {
                onUserVisible();
            }
        }else {
            if (isFirstInvisible) {
                isFirstInvisible = false;
                onFirstUserInvisible();
            } else {
                onUserInvisible();
            }
        }
    }

    private synchronized void initPrepare() {
        if(isPrepared){
            onFirstUserVisible();
        }else {
            isPrepared = true;
        }
    }

    public void onMessageEvent(EventCenter event){
        if(event != null){
            onEventComing(event);
        }
    }


    /**
     * 当第一次看到片段是可见的，我们可以做一些初始化的工作或刷新数据
     */
    protected abstract void onFirstUserVisible();

    /**
     * 就像是fragment的onResume()方法
     */
    protected abstract void onUserVisible();

    /**
     * 当fragment是第一次不可见
     */
    private void onFirstUserInvisible(){

    }
    /**
     * 就像是fragment的onPause()方法
     */
    protected abstract void onUserInvisible();

    protected abstract int getContentViewLayoutID();

    protected abstract boolean isApplyButterKnife();

    protected abstract boolean isApplyEventBus();

    protected abstract void onEventComing(EventCenter eventCenter);

}
