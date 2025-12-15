package edu.unl.cc.succession.business;

import edu.unl.cc.succession.domain.Successionable;

/**
 * Serie de primos elevados a la raiz de numeros impares hasta un n términos
 * (S = 1^(1/1) + 3^(1/3) + 5^(1/5) + 7^(1/7) + 11^(1/9) + 13^(1/11)): ")
 * @author James Sebastian Pinto Vasquez
 */
public class PrimeNumPowInverseOddNumCalcWithTerm implements Successionable {

    private Integer limit;
    private Integer currentTerm;
    private StringBuilder printableTerms;

    public PrimeNumPowInverseOddNumCalcWithTerm(Number limit) {
        this(0, limit);
    }

    public PrimeNumPowInverseOddNumCalcWithTerm(Number start, Number limit) {
        if (start.intValue() < 0){
            throw new IllegalArgumentException("Start must be greater than 0");
        }
        setLimit(limit);
        this.currentTerm = (start).intValue();
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
        boolean isPrime = false;
        while (!isPrime){
            isPrime = isPrime(currentTerm.intValue());
            if (!isPrime){
                currentTerm = currentTerm.intValue() + 1;
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
        int exponent = 1;
        int count = 0;
        currentTerm = this.currentTerm > 0 ? this.currentTerm - 1 : 0;
        while (count < limit) {
            currentTerm = nextTerm(currentTerm).intValue();
            exponent = (exponent % 2 == 0) ? exponent + 1 : exponent;
            this.printableTerms.append(currentTerm).append("^(1/").append(exponent).append(") + ");
            result = result + Math.pow(currentTerm, 1.0 / exponent);
            exponent++;
            count++;
        }
        this.printableTerms.delete(this.printableTerms.length() - 2, this.printableTerms.length());
        return result;
    }

    @Override
    public String print() {
        return printableTerms.toString();
    }
}
