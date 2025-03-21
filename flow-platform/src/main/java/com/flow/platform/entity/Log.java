package com.flow.platform.entity;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@Data
public class Log {
    private Long logId;       // 日志ID
    private String username;  // 操作用户
    private String operation; // 操作内容
    private String method;    // 操作方法
    private String params;    // 操作参数
    private String ip;        // IP地址
    private Date createTime;  // 操作时间

}