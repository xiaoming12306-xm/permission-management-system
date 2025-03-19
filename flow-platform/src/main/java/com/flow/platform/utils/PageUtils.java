package com.flow.platform.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public class PageUtils {

    /**
     * 创建分页对象
     */
    public static <T> Page<T> createPage(int pageNum, int pageSize) {
        return new Page<>(pageNum, pageSize);
    }

    /**
     * 计算总页数
     */
    public static int calculateTotalPages(long total, int pageSize) {
        return (int) Math.ceil((double) total / pageSize);
    }
}