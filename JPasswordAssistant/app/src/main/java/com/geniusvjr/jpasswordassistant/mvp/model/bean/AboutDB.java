package com.geniusvjr.jpasswordassistant.mvp.model.bean;

/**
 * Created by dream on 16/5/29.
 */
public class AboutDB {

    private String version;

    public AboutDB(String version) {
        this.version = version;
    }

    public String getVersion() {
        return "V"+this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
