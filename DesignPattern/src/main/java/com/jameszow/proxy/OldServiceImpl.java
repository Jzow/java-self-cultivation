package com.jameszow.proxy;

import java.util.ArrayList;
import java.util.List;

/**
 * 旧服务实现类
 *
 * @author James Zow
 * @create 2022/9/12
 */
public class OldServiceImpl implements OldService{

    @Override
    public List<String> getTodayToDoList() {
        return new ArrayList<>();
    }
}
