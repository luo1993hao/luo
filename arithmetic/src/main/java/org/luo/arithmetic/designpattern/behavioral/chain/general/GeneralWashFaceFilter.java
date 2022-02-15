package org.luo.arithmetic.designpattern.behavioral.chain.general;

import org.luo.arithmetic.designpattern.behavioral.chain.PreparationList;

public class GeneralWashFaceFilter implements StudyPrepareFilter {

    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain) {
        if (preparationList.isWashFace()) {
            System.out.println("洗完脸");
        }

        filterChain.doFilter(preparationList, filterChain);
    }

}