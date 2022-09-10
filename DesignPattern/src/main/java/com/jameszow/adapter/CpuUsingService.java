package com.jameszow.adapter;

/**
 *
 * cpu 使用情况业务类 (线上正在运行)
 *
 * @author James Zow
 * @create 2022/9/11
 */
public class CpuUsingService {

    private static CpuUsingService instance = new CpuUsingService();

    public CpuUsingService() {
    }

    public static CpuUsingService getInstance() {
        return instance;
    }
}
