package com.geniusvjr.passwordassistant.mvp.ui.view;

/**
 * Created by dream on 16/5/21.
 */
public interface CreateLockAView extends BaseView{

    void initLockPatternView();

    void lockDisplayError();

    void setResults(int isSuccess);

    void clearPattern();

}
