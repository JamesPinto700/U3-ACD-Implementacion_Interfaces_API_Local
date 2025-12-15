package edu.unl.cc.succession.business;

import edu.unl.cc.succession.domain.Successionable;
//
public class PrimeNumberWithCubeRootCalculatorWithNTerm implements Successionable {
    private Integer limit;
    private Integer currentTerm;
    private StringBuilder printableTerms;

    public PrimeNumberWithCubeRootCalculatorWithNTerm(Number limit) {
        this(0, limit);
    }

    public PrimeNumberWithCubeRootCalculatorWithNTerm(Number start, Number limit) {
        if(start.intValue() < 0){
            throw new IllegalArgumentException("El valor inicial debe ser mayor a 0");
        }
        setLimit(limit);
        this.currentTerm = start.intValue();
        this.printableTerms = new StringBuilder("S = ");
    }

    private boolean isPrime(Integer number){
        if(number < 1){
            return false;
        }
        for(int i=2; i<number; i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }

    @Override
    public Number nextTerm(Number currentPrime) {
        currentPrime = currentPrime.intValue() + 1;
        boolean isPrime = false;
        while(!isPrime){
            isPrime = isPrime(currentPrime.intValue());
            if(!isPrime){
                currentPrime = currentPrime.intValue() + 1;
            }
        }
        return currentPrime;
    }

    @Override
    public void setLimit(Number limit) {
        if (limit.intValue() < 0){
            throw new IllegalArgumentException("El limite debe ser mayor a 0");
        }
        this.limit = limit.intValue();
    }

    @Override
    public Number calculate() {
        Double result = 0.0;
        int counterTerm = 0;
        while(counterTerm < limit){
            result += Math.pow(this.currentTerm, 1/3);
            currentTerm = nextTerm(currentTerm).intValue();
            this.printableTerms.append(currentTerm).append("^(1/3)")
                    .append(" + ");
            counterTerm++;
        }
        this.printableTerms.delete(this.printableTerms.length()-2, this.printableTerms.length());
        return result;
    }

    @Override
    public String print() {
        return printableTerms.toString();
    }
}

