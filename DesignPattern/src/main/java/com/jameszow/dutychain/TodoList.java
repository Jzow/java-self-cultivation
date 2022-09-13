package com.jameszow.dutychain;

/**
 * 要做的事情清单
 *
 * @author James Zow
 * @create 2022/9/14
 */
public class TodoList {

    private boolean learnEnglish;

    private boolean readRustBook;

    private boolean codeDesignPattern;

    public boolean isLearnEnglish() {
        return learnEnglish;
    }

    public void setLearnEnglish(boolean learnEnglish) {
        this.learnEnglish = learnEnglish;
    }

    public boolean isReadRustBook() {
        return readRustBook;
    }

    public void setReadRustBook(boolean readRustBook) {
        this.readRustBook = readRustBook;
    }

    public boolean isCodeDesignPattern() {
        return codeDesignPattern;
    }

    public void setCodeDesignPattern(boolean codeDesignPattern) {
        this.codeDesignPattern = codeDesignPattern;
    }

    @Override
    public String toString() {
        return "TodoList{" +
                "learnEnglish=" + learnEnglish +
                ", readRustBook=" + readRustBook +
                ", codeDesignPattern=" + codeDesignPattern +
                '}';
    }
}
