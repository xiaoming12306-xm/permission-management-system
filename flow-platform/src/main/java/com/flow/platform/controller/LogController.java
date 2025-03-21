package com.flow.platform.controller;


import com.flow.platform.entity.Log;
import com.flow.platform.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/")
    public List<Log> getAllLogs() {
        return logService.getAllLogs();
    }

    @GetMapping("/{logId}")
    public Log getLogById(@PathVariable Long logId) {
        return logService.getLogById(logId);
    }

    @PostMapping("/")
    public Log createLog(@RequestBody Log log) {
        return logService.createLog(log);
    }

    @DeleteMapping("/{logId}")
    public void deleteLog(@PathVariable Long logId) {
        logService.deleteLog(logId);
    }

    @GetMapping("/user/{username}")
    public List<Log> getLogsByUsername(@PathVariable String username) {
        return logService.getLogsByUsername(username);
    }

    @GetMapping("/operation/{operation}")
    public List<Log> getLogsByOperation(@PathVariable String operation) {
        return logService.getLogsByOperation(operation);
    }
}