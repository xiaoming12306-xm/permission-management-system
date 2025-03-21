package com.flow.platform.service;

import com.flow.platform.entity.Log;
import com.flow.platform.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 日志服务类
 */
@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    /**
     * 获取所有日志
     *
     * @return 日志列表
     */
    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }

    /**
     * 根据日志ID获取日志
     *
     * @param logId 日志ID
     * @return 日志信息
     */
    public Log getLogById(Long logId) {
        return logRepository.findById(logId)
                .orElseThrow(() -> new RuntimeException("日志未找到"));
    }

    /**
     * 创建日志
     *
     * @param log 日志信息
     * @return 创建的日志
     */
    public Log createLog(Log log) {
        return logRepository.save(log);
    }

    /**
     * 根据日志ID删除日志
     *
     * @param logId 日志ID
     */
    public void deleteLog(Long logId) {
        logRepository.deleteById(logId);
    }

    /**
     * 根据操作用户查找日志
     *
     * @param username 操作用户
     * @return 日志列表
     */
    public List<Log> getLogsByUsername(String username) {
        return logRepository.findByUsername(username);
    }

    /**
     * 根据操作类型查找日志
     *
     * @param operation 操作类型
     * @return 日志列表
     */
    public List<Log> getLogsByOperation(String operation) {
        return logRepository.findByOperation(operation);
    }
}