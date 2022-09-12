package com.jameszow.proxy;

import java.util.Arrays;
import java.util.List;

/**
 * 代理服务
 *
 * @author James Zow
 * @create 2022/9/12
 */
public class ProxyService implements OldService{

    private OldService oldService = new OldServiceImpl();

    void checkListIsEmpty(List<String> params) {
        if (params.isEmpty()) {
            System.err.println("集合元素是空的");
        } else {
            System.out.println("集合元素个数：" + params.size());
        }
    }

    @Override
    public List<String> getTodayToDoList() {
        new OldServiceImpl().getTodayToDoList();
        oldService.getTodayToDoList();

        new ProxyService().checkListIsEmpty(new OldServiceImpl().getTodayToDoList());
        String [] lang = {"java", "rust"};
        checkListIsEmpty(Arrays.asList(lang));

        return null;
    }

    public static void main(String[] args) {
        ProxyService proxyService = new ProxyService();
        proxyService.getTodayToDoList();
    }
}
