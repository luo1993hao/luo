package org.luo.arithmetic.designpattern.behavioral.chain.standard;

import org.luo.arithmetic.designpattern.behavioral.chain.PreparationList;

public class HaveBreakfastFilter extends AbstractPrepareFilter {

    public HaveBreakfastFilter(AbstractPrepareFilter nextPrepareFilter) {
        super(nextPrepareFilter);
    }

    @Override
    public void prepare(PreparationList preparationList) {
        if (preparationList.isHaveBreakfast()) {
            System.out.println("吃早餐");
        }

    }

}