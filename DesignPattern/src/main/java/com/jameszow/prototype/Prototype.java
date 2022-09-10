package com.jameszow.prototype;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author James Zow
 * @create 2022/9/10
 */
public class Prototype implements Cloneable{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * jdk建议重写clone方法的时候 修饰符使用public，由于我们目前只在本包下使用所以用protected
     * 如果涉及到多个模块调用需要改成public。
     * @return
     */
    @Override
    protected Object clone(){
        try{
            return super.clone();
        }catch (Exception e) {
            e.printStackTrace();
            System.err.println("clone error");
        }
        return null;
    }

    public static void main(String[] args) {

        List<Prototype> prototypeList = new LinkedList<>();

        Prototype prototype = new Prototype();
        for (int i = 0; i < 10; ++i) {
            var people = (Prototype) prototype.clone();
            people.setName("user" + i);
            prototypeList.add(people);
        }

        List<Prototype> read = new ArrayList<>(prototypeList);

        for (Prototype item : read) {
            System.out.println(item.getName());
        }
    }
}
