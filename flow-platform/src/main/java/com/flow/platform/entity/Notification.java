package com.flow.platform.entity;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@Data
public class Notification {
    private Long notificationId; // 通知ID
    private Long userId;         // 用户ID
    private String message;      // 通知内容
    private Boolean isRead;      // 是否已读
    private Date createTime;     // 创建时间

}