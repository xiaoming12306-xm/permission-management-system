package com.flow.platform.entity;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@Data
public class File {
    private Long fileId;       // 文件ID
    private String fileName;   // 文件名称
    private String filePath;   // 文件路径
    private Long uploadUser;   // 上传用户ID
    private Date createTime;   // 创建时间

}