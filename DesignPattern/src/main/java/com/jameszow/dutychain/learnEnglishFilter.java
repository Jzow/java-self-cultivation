package com.jameszow.dutychain;

/**
 * 学英语过滤器
 *
 * @author James Zow
 * @create 2022/9/14
 */
public class learnEnglishFilter implements StudyService{
    @Override
    public void doFilter(TodoList todoList, FilterChain filterChain) {
        if (todoList.isLearnEnglish()) {
            System.out.println("学习完英语");
        }

        filterChain.doFilter(todoList, filterChain);
    }
}
