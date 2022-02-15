package org.luo.arithmetic.designpattern.behavioral.chain.standard;

import org.luo.arithmetic.designpattern.behavioral.chain.PreparationList;
import org.luo.arithmetic.designpattern.behavioral.chain.Study;

public abstract class AbstractPrepareFilter {

    private AbstractPrepareFilter nextPrepareFilter;

    public AbstractPrepareFilter(AbstractPrepareFilter nextPrepareFilter) {
        this.nextPrepareFilter = nextPrepareFilter;
    }

    public void doFilter(PreparationList preparationList, Study study) {
        prepare(preparationList);

        if (nextPrepareFilter == null) {
            study.study();
        } else {
            nextPrepareFilter.doFilter(preparationList, study);
        }
    }

    public abstract void prepare(PreparationList preparationList);

}