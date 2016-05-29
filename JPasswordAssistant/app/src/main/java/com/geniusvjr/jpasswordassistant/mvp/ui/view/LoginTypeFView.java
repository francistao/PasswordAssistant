package com.geniusvjr.jpasswordassistant.mvp.ui.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by dream on 16/5/28.
 */
public interface LoginTypeFView {

    void initRecycler(LinearLayoutManager linearLayoutManager, RecyclerView.Adapter adapter);
    void readGo(Class clazz, int type, int position, int positionType);
    void hideException();
    void showException();

}
