package org.luo.arithmetic.designpattern.behavioral.chain.general;

import org.luo.arithmetic.designpattern.behavioral.chain.PreparationList;

public interface StudyPrepareFilter {
    public void doFilter(PreparationList preparationList, FilterChain filterChain);

}
