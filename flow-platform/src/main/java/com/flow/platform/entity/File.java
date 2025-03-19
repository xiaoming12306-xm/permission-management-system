package com.flow.platform.entity;

import lombok.Data;
import java.util.Date;

@Data
public class File {
    private Long fileId;       // 文件ID
    private String fileName;   // 文件名称
    private String filePath;   // 文件路径
    private Long uploadUser;   // 上传用户ID
    private Date createTime;   // 创建时间

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Long getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(Long uploadUser) {
        this.uploadUser = uploadUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}