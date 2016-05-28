package com.geniusvjr.jpasswordassistant.mvp.model.eventbus;

/**
 * Created by dream on 16/5/27.
 */
public class EventCenter<T> {


    /**
     * 保留数据
     */
    private T data;
    private int position;


    /**
     *  这段代码区分不同的事件
     */
    private int eventCode = -1;

    public EventCenter(int eventCode){
        this(eventCode, null);
    }

    public EventCenter(int eventCode,T data){
        this.eventCode = eventCode;
        this.data = data;
    }

    /**
     * 获得事件代码
     * @return
     */
    public int getEventCode() {
        return this.eventCode;
    }

    /**
     * 获得事件保留代码
     */
    public T getData(){
        return this.data;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
