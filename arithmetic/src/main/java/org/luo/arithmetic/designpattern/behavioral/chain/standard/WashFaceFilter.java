package org.luo.arithmetic.designpattern.behavioral.chain.standard;

import org.luo.arithmetic.designpattern.behavioral.chain.PreparationList;

public class WashFaceFilter extends AbstractPrepareFilter {

    public WashFaceFilter(AbstractPrepareFilter nextPrepareFilter) {
        super(nextPrepareFilter);
    }

    @Override
    public void prepare(PreparationList preparationList) {
        if (preparationList.isWashFace()) {
            System.out.println("洗脸");
        }

    }

}