package edu.unl.cc.sussesion.business;

import edu.unl.cc.sussesion.domain.Sussesionable;

/**
 * Representa el cálculo de la serie de primos elevados al cubo  hasta N términos
 * (S = 1^3 + 3^3 + 5^3 + 7^3 + 11^3 + 13^3 ...)
 * @author bluebul (Maria Jose Rodriguez)
 */

public class PrimeNumberCubedCalculatorWithNTerms implements Sussesionable {

    private Integer currentTerm;
    private Integer limit;
    private StringBuilder printableTerms;

    public PrimeNumberCubedCalculatorWithNTerms(Integer limit) {
        this(0,limit);
    }

    public PrimeNumberCubedCalculatorWithNTerms(Number start, Number limit) {
        if(start.intValue()< 0){
            throw new IllegalArgumentException("Start number must be greater than 0");
        }
        setLimit(limit);
        currentTerm = nextTerm(start).intValue();
        this.printableTerms = new StringBuilder("S = ");
    }

    private boolean isPrime(Integer number){
        if (number <=1){
            return false;
        }
        for (int i = 2; i < number; i++){
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }

    @Override
    public Number nextTerm(Number currentTerm) {
        currentTerm = currentTerm.intValue() + 1;
        boolean isPrimo = false;
        while(!isPrimo){
            isPrimo = isPrime(currentTerm.intValue());
            if(!isPrimo){
                currentTerm = currentTerm.intValue()+ 1;
            }
        }
        return currentTerm;
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
        Double result = 0.0;
        int counterTerm = 0;
        while(counterTerm < limit){
            this.printableTerms.append(currentTerm).append(" ^3 ");
            if (counterTerm < limit - 1) {
                this.printableTerms.append(" + ");
            }
            counterTerm++;
            result += Math.pow(currentTerm,3);
            currentTerm =  nextTerm(currentTerm).intValue();
        }
        return result;
    }

    @Override
    public String print() {
        return this.printableTerms.toString();
    }
}
