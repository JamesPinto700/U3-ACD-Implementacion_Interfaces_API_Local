package edu.unl.cc.succession.business;

import edu.unl.cc.succession.domain.Successionable;
//
public class PrimeNumberCalculatorUpToLimit implements Successionable {
    private Integer limit;
    private Integer currentPrime;
    private StringBuilder printableTerms;

    public PrimeNumberCalculatorUpToLimit(Number limit) {
        this(0, limit);
    }

    public PrimeNumberCalculatorUpToLimit(Number start, Number limit) {
        if(start.intValue() < 0){
            throw new IllegalArgumentException("El valor inicial debe ser mayor a 0");
        }
        setLimit(limit);
        this.currentPrime = nextTerm(start).intValue();
        this.printableTerms = new StringBuilder("S = ");
    }

    private boolean isPrime(Integer number){
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
        long result = 0;
        while(currentPrime < limit){
            this.printableTerms.append(currentPrime).append(" + ");
            result += this.currentPrime;
            currentPrime = nextTerm(currentPrime).intValue();
        }
        this.printableTerms.delete(this.printableTerms.length() - 2, this.printableTerms.length());
        return result;
    }

    @Override
    public String print() {
        return printableTerms.toString();
    }
}


