-- 用户表
CREATE TABLE `sys_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `real_name` varchar(50) COMMENT '真实姓名',
  `email` varchar(100) COMMENT '邮箱',
  `mobile` varchar(20) COMMENT '手机号',
  `wechat_id` varchar(100) COMMENT '企业微信ID',
  `status` tinyint DEFAULT 1 COMMENT '状态(0:禁用,1:正常)',
  `create_time` datetime COMMENT '创建时间',
  `update_time` datetime COMMENT '更新时间',
  PRIMARY KEY (`id`)
) COMMENT='系统用户表';

-- 角色表
CREATE TABLE `sys_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(50) NOT NULL COMMENT '角色名称',
  `role_code` varchar(50) NOT NULL COMMENT '角色编码',
  `description` varchar(200) COMMENT '角色描述',
  `create_time` datetime COMMENT '创建时间',
  PRIMARY KEY (`id`)
) COMMENT='角色表';

-- 权限表
CREATE TABLE `sys_permission` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `permission_name` varchar(50) NOT NULL COMMENT '权限名称',
  `permission_code` varchar(50) NOT NULL COMMENT '权限编码',
  `type` tinyint COMMENT '类型(1:菜单,2:按钮)',
  `parent_id` bigint COMMENT '父级ID',
  `sort` int COMMENT '排序',
  PRIMARY KEY (`id`)
) COMMENT='权限表';

-- 表单模板表
CREATE TABLE `form_template` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '模板ID',
  `template_name` varchar(100) NOT NULL COMMENT '模板名称',
  `template_code` varchar(50) NOT NULL COMMENT '模板编码',
  `form_fields` text NOT NULL COMMENT '表单字段(JSON格式)',
  `create_time` datetime COMMENT '创建时间',
  PRIMARY KEY (`id`)
) COMMENT='表单模板表';

-- 表单数据表
CREATE TABLE `form_data` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '数据ID',
  `template_id` bigint NOT NULL COMMENT '模板ID',
  `form_data` text NOT NULL COMMENT '表单数据(JSON格式)',
  `creator_id` bigint NOT NULL COMMENT '创建人ID',
  `status` tinyint DEFAULT 0 COMMENT '状态(0:草稿,1:审批中,2:已完成,3:已驳回)',
  `create_time` datetime COMMENT '创建时间',
  PRIMARY KEY (`id`)
) COMMENT='表单数据表';

-- 审批流程表
CREATE TABLE `workflow` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '流程ID',
  `workflow_name` varchar(100) NOT NULL COMMENT '流程名称',
  `template_id` bigint NOT NULL COMMENT '关联模板ID',
  `nodes` text NOT NULL COMMENT '流程节点(JSON格式)',
  `create_time` datetime COMMENT '创建时间',
  PRIMARY KEY (`id`)
) COMMENT='审批流程表';

-- 审批记录表
CREATE TABLE `approval_record` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `form_data_id` bigint NOT NULL COMMENT '表单数据ID',
  `approver_id` bigint NOT NULL COMMENT '审批人ID',
  `node_id` varchar(50) NOT NULL COMMENT '节点ID',
  `status` tinyint COMMENT '状态(0:待审批,1:通过,2:驳回)',
  `comment` varchar(500) COMMENT '审批意见',
  `create_time` datetime COMMENT '创建时间',
  PRIMARY KEY (`id`)
) COMMENT='审批记录表';