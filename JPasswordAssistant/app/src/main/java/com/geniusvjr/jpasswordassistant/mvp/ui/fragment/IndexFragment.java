package com.geniusvjr.jpasswordassistant.mvp.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.geniusvjr.jpasswordassistant.R;
import com.geniusvjr.jpasswordassistant.mvp.model.eventbus.EventCenter;
import com.geniusvjr.jpasswordassistant.mvp.ui.view.LoginTypeFView;

/**
 * Created by dream on 16/5/28.
 */
public class IndexFragment extends BaseFragment implements LoginTypeFView{


    private static final int INDEX_FRAGMENT_REQUEST_CODE = 2;
    private static final int EDIT_SAVE = 1;
    private static final int SUCCESS = 1;

    @Override
    protected void onFirstUserVisible() {

    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    protected void onUserInvisible() {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_login_type;
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
    protected void onEventComing(EventCenter eventCenter) {

    }

    @Override
    public void initRecycler(LinearLayoutManager linearLayoutManager, RecyclerView.Adapter adapter) {

    }

    @Override
    public void readGo(Class clazz, int type, int position, int positionType) {

    }

    @Override
    public void hideException() {

    }

    @Override
    public void showException() {

    }
}
