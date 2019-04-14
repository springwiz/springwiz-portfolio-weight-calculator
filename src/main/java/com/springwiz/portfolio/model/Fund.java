package com.springwiz.portfolio.model;
import java.util.Objects;

/**
 * The Class Fund.
 */
public class Fund implements Comparable<Fund> {
    
    /** The fund name. */
    private String fundName;
    
    /** The fund value. */
    private long fundValue;

    /**
     * Instantiates a new fund.
     *
     * @param fundName the fund name
     * @param fundValue the fund value
     */
    public Fund(String fundName, long fundValue) {
        this.fundName = fundName;
        this.fundValue = fundValue;
    }

    /**
     * Equals.
     *
     * @param o the o
     * @return true, if successful
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fund)) return false;
        Fund fund = (Fund) o;
        return getFundValue() == fund.getFundValue() &&
                Objects.equals(getFundName(), fund.getFundName());
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {

        return Objects.hash(getFundName(), getFundValue());
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Fund{" +
                "fundName='" + fundName + '\'' +
                ", fundValue=" + fundValue +
                '}';
    }

    /**
     * Gets the fund name.
     *
     * @return the fund name
     */
    public String getFundName() {
        return fundName;
    }


    /**
     * Gets the fund value.
     *
     * @return the fund value
     */
    public long getFundValue() {
        return fundValue;
    }

    /**
     * Compare to.
     *
     * @param o the o
     * @return the int
     */
    @Override
    public int compareTo(Fund o) {
        return this.fundName.compareTo(o.fundName);
    }
}
