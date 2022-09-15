package com.jameszow.memento;

/**
 * 发起者
 *
 * 将要决定哪些内部数据需要进行保存到备忘录中，并可以使备忘录来恢复原来到状态
 *
 * @author James Zow
 * @create 2022/9/15
 */
public class Originator {

    // 状态
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento Originator() {
        return new MementoImpl(state);
    }

    public void recoverFromMemento(Memento memento) {
        MementoImpl mementoImpl = (MementoImpl) memento;
        this.state = mementoImpl.getState();
    }

    /**
     * 备忘录对象，实现了备忘录接口，内部类
     */
    private static class MementoImpl extends Memento {

        private String state;

        public MementoImpl(String state) {
            super(state);
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

}
