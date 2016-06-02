package com.geniusvjr.jpasswordassistant.mvp.ui.view;

/**
 * Created by dream on 16/5/28.
 */
public interface IndexAView {

    void initDrawerToggle();

    void initXViewPager();

    void readyGoForResult(Class clazz);

    void go2Setting();

    void showSnackBar(String msg);

    void kill();

    void go2About();
}
