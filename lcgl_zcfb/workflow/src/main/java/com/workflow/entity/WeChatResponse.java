package com.workflow.entity;


public class WeChatResponse {
    private int errcode;
    private String errmsg;

    // getters and setters
    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }   

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }   
} 