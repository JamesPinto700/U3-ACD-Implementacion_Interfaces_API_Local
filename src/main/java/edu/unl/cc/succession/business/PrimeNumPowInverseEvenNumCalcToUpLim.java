package edu.unl.cc.succession.business;

import edu.unl.cc.succession.domain.Successionable;

/**
 * Serie de primos elevados a la raiz de numeros pares hasta un limite
 * (S = 1^(1/2) + 3^(1/4) + 5^(1/6) + 7^(1/8) + 11^(1/10) + 13^(1/12) ... + N): ")
 * @author James Sebastian Pinto Vasquez
 */
public class PrimeNumPowInverseEvenNumCalcToUpLim implements Successionable {

    private Integer limit;
    private Integer currentTerm;
    private StringBuilder printableTerms;

    public PrimeNumPowInverseEvenNumCalcToUpLim(Number limit) {
        this(0, limit);
    }

    public PrimeNumPowInverseEvenNumCalcToUpLim(Number start, Number limit) {
        if (start.intValue() < 0 ) {
            throw new IllegalArgumentException("Start must be grater than 0");
        }
        setLimit(limit);
        currentTerm = nextTerm(start).intValue();
        this.printableTerms = new StringBuilder("S = ");
    }

    private boolean isPrime(Integer number) {
        if (number <= 1 ) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Number nextTerm(Number currentTerm) {
        currentTerm = currentTerm.intValue() + 1;
        boolean isPrime = false;
        while (!isPrime) {
            isPrime = isPrime(currentTerm.intValue());
            if (!isPrime) {
                currentTerm = currentTerm.intValue() + 1;
            }
        }
        return currentTerm;
    }

    @Override
    public void setLimit(Number limit) {
        if (limit.intValue() < 0) {
            throw new IllegalArgumentException("Limit must be grater than 0");
        }
        this.limit = limit.intValue();
    }

    @Override
    public Number calculate() {
        Double result = 0.0;
        int exponent = 2;
        while (currentTerm <= limit){
            exponent = (exponent % 2 != 0) ? exponent + 1 : exponent;
            this.printableTerms.append(currentTerm).append("^(1/").append(exponent).append(") + ");
            result = result + Math.pow(currentTerm, 1.0 / exponent);
            exponent++;
            currentTerm = nextTerm(currentTerm).intValue();
        }
        this.printableTerms.delete(this.printableTerms.length() - 2, this.printableTerms.length());
        return result;
    }

    @Override
    public String print() {
        return printableTerms.toString();
    }
}
