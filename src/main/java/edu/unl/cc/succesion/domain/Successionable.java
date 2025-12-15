package edu.unl.cc.succession.domain;

/**
 * @author MacGyver2.0
 */
public interface Successionable extends Printable{
    /**
     * Generates the next term in the series based on the current term.
     * @param currentTerm The current term in the series
     * @return The next term in the series
     */
    Number nextTerm(Number currentTerm);

    /**
     * Setter the limit in the series
     * @param limit
     */
    void setLimit(Number limit);

    /**
     * Calculate the result, if the necessary in the serie. The main metod
     * @return The result of the calculate
     */
    Number calculate();
}
