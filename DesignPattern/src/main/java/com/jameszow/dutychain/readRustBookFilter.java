package com.jameszow.dutychain;

/**
 * 读rust书籍过滤器
 *
 * @author James Zow
 * @create 2022/9/14
 */
public class readRustBookFilter implements StudyService{

    @Override
    public void doFilter(TodoList todoList, FilterChain filterChain) {
        if(todoList.isReadRustBook()) {
            System.out.println("读完了rust书");
        }

        filterChain.doFilter(todoList, filterChain);
    }
}
