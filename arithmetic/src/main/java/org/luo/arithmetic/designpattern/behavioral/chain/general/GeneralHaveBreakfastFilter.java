package org.luo.arithmetic.designpattern.behavioral.chain.general;

import org.luo.arithmetic.designpattern.behavioral.chain.PreparationList;

public class GeneralHaveBreakfastFilter implements StudyPrepareFilter {

    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain) {
        if (preparationList.isHaveBreakfast()) {
            System.out.println("吃完早饭");
        }

        filterChain.doFilter(preparationList, filterChain);
    }

}