package com.jameszow.dutychain;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链
 *
 * @author James Zow
 * @create 2022/9/14
 */
public class FilterChain implements StudyService{

    // 计数器控制方法有没有调用完，如果掉完了执行study()
    private int pos = 0;

    private Study study;

    private List<StudyService> studyServiceList;

    public FilterChain(Study study) {
        this.study = study;
    }

    public void addFilter(StudyService studyService) {
        if(studyServiceList == null) {
            studyServiceList = new ArrayList<>();
        }
        studyServiceList.add(studyService);
    }

    @Override
    public void doFilter(TodoList todoList, FilterChain filterChain) {
        if(pos == studyServiceList.size()) {
            study.study();
        }

        studyServiceList.get(pos++).doFilter(todoList, filterChain);
    }
}
