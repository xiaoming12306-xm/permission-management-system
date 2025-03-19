package com.flow.platform.repository;

import com.flow.platform.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 角色仓库接口
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * 根据角色名称查找角色
     *
     * @param roleName 角色名称
     * @return 角色信息
     */
    Optional<Role> findByRoleName(String roleName);

    /**
     * 根据角色ID查找角色
     *
     * @param roleId 角色ID
     * @return 角色信息
     */
    Optional<Role> findByRoleId(Long roleId);

    /**
     * 根据角色ID删除角色
     *
     * @param roleId 角色ID
     */
    void deleteByRoleId(Long roleId);

    /**
     * 判断角色名称是否存在
     *
     * @param roleName 角色名称
     * @return 是否存在
     */
    Boolean existsByRoleName(String roleName);
}