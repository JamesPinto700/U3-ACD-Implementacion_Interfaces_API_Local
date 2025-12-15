package edu.unl.cc.sussesion.business;

import edu.unl.cc.sussesion.domain.Sussesionable;

/**
 * Representa el cálculo de la serie de primos elevados por pares hasta un limite
 * (S = 1^2 + 3^4 + 5^6 + 7^8 + 11^10 + 13^(12) ... + N)
 * @author bluebul (Maria Jose Rodriguez)
 */

public class PrimeNumberWithEvenPowersCalculatorUpToLimit implements Sussesionable {
    private Integer limit;
    private Integer currentTerm;
    private StringBuilder printableTerms;

    public PrimeNumberWithEvenPowersCalculatorUpToLimit(Integer limit) {
        this(0,limit);
    }

    public PrimeNumberWithEvenPowersCalculatorUpToLimit(Number start, Number limit) {
        if(start.intValue()< 0){
            throw new IllegalArgumentException("Start number must be greater than 0");
        }
        setLimit(limit);
        currentTerm = nextTerm(start).intValue();
        this.printableTerms = new StringBuilder("S = ");
    }

    private boolean isPrime(Integer number){
        if (number <= 1){
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
        int exponent = 2;
        while(currentTerm <= limit){
            this.printableTerms.append(currentTerm).append("^").append(exponent);
            int next = nextTerm(this.currentTerm).intValue();
            if (next <= limit) {
                this.printableTerms.append(" + ");
            }
            result += Math.pow(currentTerm,exponent);
            exponent = exponent + 2;
            currentTerm =  nextTerm(currentTerm).intValue();
        }
        return result;
    }

    @Override
    public String print() {
        return this.printableTerms.toString();
    }
}
