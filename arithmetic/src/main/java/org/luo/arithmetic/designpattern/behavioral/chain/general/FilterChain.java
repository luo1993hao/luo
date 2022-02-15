package org.luo.arithmetic.designpattern.behavioral.chain.general;

import org.luo.arithmetic.designpattern.behavioral.chain.PreparationList;
import org.luo.arithmetic.designpattern.behavioral.chain.Study;

import java.util.ArrayList;
import java.util.List;

/**
 * 普遍版的核心类：filterChain。用于串起所有的责任对象。
 */
public class FilterChain implements StudyPrepareFilter {

    private int pos = 0;

    private Study study;

    private List<StudyPrepareFilter> studyPrepareFilterList;

    public FilterChain(Study study) {
        this.study = study;
    }

    public void addFilter(StudyPrepareFilter studyPrepareFilter) {
        if (studyPrepareFilterList == null) {
            studyPrepareFilterList = new ArrayList<>();
        }

        studyPrepareFilterList.add(studyPrepareFilter);
    }

    @Override
    public void doFilter(PreparationList thingList, FilterChain filterChain) {
        // 所有过滤器执行完毕
        if (pos == studyPrepareFilterList.size()) {
            study.study();
        }

        studyPrepareFilterList.get(pos++).doFilter(thingList, filterChain);
    }

}