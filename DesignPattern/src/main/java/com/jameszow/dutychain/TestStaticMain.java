package com.jameszow.dutychain;

/**
 * 主函数测试方法
 *
 * @author James Zow
 * @create 2022/9/14
 */
public class TestStaticMain {

    public static void main(String[] args) {
        TodoList todoList = new TodoList();

        todoList.setLearnEnglish(true);
        todoList.setReadRustBook(false);
        todoList.setCodeDesignPattern(true);

        Study study = new Study();

        StudyService learnEnglishFilter = new learnEnglishFilter();
        StudyService readRustBookFilter = new readRustBookFilter();
        StudyService codeDesignPatternFilter = new codeDesignPatternFilter();

        FilterChain filterChain = new FilterChain(study);
        filterChain.addFilter(learnEnglishFilter);
        filterChain.addFilter(readRustBookFilter);
        filterChain.addFilter(codeDesignPatternFilter);

        filterChain.doFilter(todoList, filterChain);
    }
}
