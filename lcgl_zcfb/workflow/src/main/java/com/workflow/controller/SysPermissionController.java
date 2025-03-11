package com.workflow.controller;

import com.workflow.annotation.RequiresPermission;
import com.workflow.entity.SysPermission;
import com.workflow.service.SysPermissionService;
import com.workflow.dto.Result;
import com.workflow.dto.RolePermissionDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/permission")
@Api(tags = "权限管理接口")
public class SysPermissionController {
    
    @Autowired
    private SysPermissionService permissionService;
    
    @SuppressWarnings("rawtypes")
    @GetMapping("/user/{userId}")
    @ApiOperation("获取用户权限列表")
    @RequiresPermission("sys:permission:list")
    public Result getUserPermissions(@PathVariable Long userId) {
        List<SysPermission> permissions = permissionService.getUserPermissions(userId);
        return Result.success(permissions);
    }
    
    @SuppressWarnings("rawtypes")
    @GetMapping("/role/{roleId}")
    @ApiOperation("获取角色权限列表")
    @RequiresPermission("sys:permission:list")
    public Result getRolePermissions(@PathVariable Long roleId) {
        List<SysPermission> permissions = permissionService.getRolePermissions(roleId);
        return Result.success(permissions);
    }
    
    @SuppressWarnings("rawtypes")
    @PostMapping("/assign")
    @ApiOperation("分配角色权限")
    @RequiresPermission("sys:permission:assign")
    public Result assignPermissions(@RequestBody RolePermissionDTO dto) {
        permissionService.assignPermissions(dto.getRoleId(), dto.getPermissionIds());
        return Result.success();
    }
}