package com.geniusvjr.jpasswordassistant.mvp.model.bean;

/**
 * Created by dream on 16/5/28.
 */
public class IndexBean {

    private String toolBarTitle;

    public IndexBean(String title){
        this.toolBarTitle = title;
    }

    public String getToolBarTitle() {
        return toolBarTitle;
    }

    public void setToolBarTitle(String toolBarTitle) {
        this.toolBarTitle = toolBarTitle;
    }
}
