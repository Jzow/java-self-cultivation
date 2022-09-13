package com.jameszow.dutychain;

/**
 * 编码设计模式
 *
 * @author James Zow
 * @create 2022/9/14
 */
public class codeDesignPatternFilter implements StudyService{

    @Override
    public void doFilter(TodoList todoList, FilterChain filterChain) {
        if(todoList.isCodeDesignPattern()) {
            System.out.println("编码完了");
        }
    }
}
