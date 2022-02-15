package org.luo.arithmetic.designpattern.behavioral.chain.general;

import org.luo.arithmetic.designpattern.behavioral.chain.PreparationList;

public class GeneralWashHairFilter implements StudyPrepareFilter {

    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain) {
        if (preparationList.isWashHair()) {
            System.out.println("洗完头发");
        }

        filterChain.doFilter(preparationList, filterChain);
    }

}