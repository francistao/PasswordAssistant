package com.geniusvjr.passwordassistant.mvp.ui.view;

/**
 * Created by dream on 16/5/21.
 */
public interface BaseView {

    void readyGoThenKill(Class clazz);
    void kill();
    void showSnackBar(String msg);

}
