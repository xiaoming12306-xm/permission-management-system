-- 用户表
CREATE TABLE `user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` VARCHAR(50) NOT NULL COMMENT '用户名',
  `password` VARCHAR(100) NOT NULL COMMENT '密码',
  `email` VARCHAR(100) NOT NULL COMMENT '邮箱',
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- 角色表
CREATE TABLE `role` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name` VARCHAR(50) NOT NULL COMMENT '角色名称',
  `description` VARCHAR(255) DEFAULT NULL COMMENT '角色描述',
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

-- 用户角色关联表
CREATE TABLE `user_role` (
  `user_id` BIGINT(20) NOT NULL COMMENT '用户ID',
  `role_id` BIGINT(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`),
  CONSTRAINT `fk_user_role_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_user_role_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关联表';

-- 权限表
CREATE TABLE `permission` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `name` VARCHAR(50) NOT NULL COMMENT '权限名称',
  `description` VARCHAR(255) DEFAULT NULL COMMENT '权限描述',
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限表';

-- 角色权限关联表
CREATE TABLE `role_permission` (
  `role_id` BIGINT(20) NOT NULL COMMENT '角色ID',
  `permission_id` BIGINT(20) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`role_id`, `permission_id`),
  CONSTRAINT `fk_role_permission_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_role_permission_permission` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色权限关联表';

-- 表单数据表
CREATE TABLE `form_data` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '表单数据ID',
  `user_id` BIGINT(20) NOT NULL COMMENT '提交用户ID',
  `data` TEXT NOT NULL COMMENT '表单数据',
  `status` ENUM('PENDING', 'APPROVED', 'REJECTED') NOT NULL DEFAULT 'PENDING' COMMENT '审批状态',
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_form_data_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='表单数据表';

-- 审批记录表
CREATE TABLE `approval_record` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '审批记录ID',
  `form_data_id` BIGINT(20) NOT NULL COMMENT '表单数据ID',
  `approver_id` BIGINT(20) NOT NULL COMMENT '审批人ID',
  `status` ENUM('APPROVED', 'REJECTED') NOT NULL COMMENT '审批状态',
  `comments` TEXT DEFAULT NULL COMMENT '审批意见',
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_approval_record_form_data` FOREIGN KEY (`form_data_id`) REFERENCES `form_data` (`id`),
  CONSTRAINT `fk_approval_record_user` FOREIGN KEY (`approver_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='审批记录表';