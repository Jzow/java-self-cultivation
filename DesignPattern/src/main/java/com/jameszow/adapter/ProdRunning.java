package com.jameszow.adapter;

/**
 *  (线上正在运行的接口)
 *
 * @author James Zow
 * @create 2022/9/11
 */
public interface ProdRunning {

    <T> T checkCpu();

    String getCpuInfo();
}
