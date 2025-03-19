package com.flow.platform.entity;

import lombok.Data;
import java.util.Date;

@Data
public class Notification {
    private Long notificationId; // 通知ID
    private Long userId;         // 用户ID
    private String message;      // 通知内容
    private Boolean isRead;      // 是否已读
    private Date createTime;     // 创建时间

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}