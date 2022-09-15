package com.jameszow.memento;

/**
 * 管理者
 *
 * @author James Zow
 * @create 2022/9/15
 */
public class Caretaker {

    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
