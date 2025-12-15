package edu.unl.cc.succession.business;

import edu.unl.cc.succession.domain.Succesionable;

/**
 * @author wduck (Carlos Zumba.)
 */
public class EvenNumberCalculaterUpToLimint implements Succesionable {

    private Integer limit;
    private Integer currentTerm;
    private final StringBuilder printableTerms;

    public EvenNumberCalculaterUpToLimint(Number limit) {
        this(0, limit);
    }

    public EvenNumberCalculaterUpToLimint(Number start, Number limit) {
        if (start.intValue() < 0){
            throw new IllegalArgumentException("Start must be greater than 0");
        }
        setLimit(limit);
        currentTerm = (start.intValue() % 2 != 0) ? start.intValue() + 1 : start.intValue();
        printableTerms = new StringBuilder("S = ");
    }


    @Override
    public Number nextTerm(Number currentTerm) {
        return currentTerm.intValue() + 2;
    }

    @Override
    public void setLimit(Number limit) {
        if (limit.intValue() < 0){
            throw new IllegalArgumentException("Limit must be greater than 0");
        }
        this.limit = limit.intValue();
    }

    @Override
    public Number calculate() {
        long result = 0;
        this.currentTerm = nextTerm(this.currentTerm).intValue();
        while (this.currentTerm <= this.limit) {
            this.printableTerms.append(this.currentTerm).append(" + ");
            result = result + this.currentTerm;
            this.currentTerm = nextTerm(this.currentTerm).intValue();
        }
        return result;
    }

    @Override
    public String print() {
        return this.printableTerms.toString();
    }

}
