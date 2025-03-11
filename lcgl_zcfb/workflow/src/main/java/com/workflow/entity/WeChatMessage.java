package com.workflow.entity;


public class WeChatMessage {
    private String touser;
    private String msgtype;
    private String agentid;
    private Text text;

    public static class Text {
        private String content;

        public Text(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        // getters and setters
    }

    // getters and setters
    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser; 
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }
} 