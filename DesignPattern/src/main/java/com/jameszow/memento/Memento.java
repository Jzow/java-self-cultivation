package com.jameszow.memento;

/**
 * 备忘录
 *
 * @author James Zow
 * @create 2022/9/15
 */
public class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
