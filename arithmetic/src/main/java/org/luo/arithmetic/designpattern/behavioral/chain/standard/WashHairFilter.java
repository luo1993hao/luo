package org.luo.arithmetic.designpattern.behavioral.chain.standard;

import org.luo.arithmetic.designpattern.behavioral.chain.PreparationList;

public class WashHairFilter extends AbstractPrepareFilter {

    public WashHairFilter(AbstractPrepareFilter nextPrepareFilter) {
        super(nextPrepareFilter);
    }

    @Override
    public void prepare(PreparationList preparationList) {
        if (preparationList.isWashHair()) {
            System.out.println("洗头");
        }

    }

}