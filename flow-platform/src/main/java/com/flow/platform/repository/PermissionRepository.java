package com.flow.platform.repository;

import com.flow.platform.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 权限仓库接口
 */
@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    /**
     * 根据权限名称查找权限
     *
     * @param permName 权限名称
     * @return 权限信息
     */
    Optional<Permission> findByPermName(String permName);

    /**
     * 根据权限ID查找权限
     *
     * @param permId 权限ID
     * @return 权限信息
     */
    Optional<Permission> findByPermId(Long permId);

    /**
     * 根据权限ID删除权限
     *
     * @param permId 权限ID
     */
    void deleteByPermId(Long permId);

    /**
     * 判断权限名称是否存在
     *
     * @param permName 权限名称
     * @return 是否存在
     */
    Boolean existsByPermName(String permName);
}