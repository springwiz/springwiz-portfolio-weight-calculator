package com.springwiz.portfolio.model;

/**
 * The Class Edge.
 */
public class Edge {
    
    /** The parent fund. */
    private Fund parentFund;
    
    /** The child fund. */
    private Fund childFund;


    /**
     * Instantiates a new edge.
     *
     * @param parentFund the parent fund
     * @param childFund the child fund
     */
    public Edge(Fund parentFund, Fund childFund) {
        this.parentFund = parentFund;
        this.childFund = childFund;

    }

    /**
     * Gets the parent fund.
     *
     * @return the parent fund
     */
    Fund getParentFund() {
        return parentFund;
    }


    /**
     * Gets the child fund.
     *
     * @return the child fund
     */
    Fund getChildFund() {
        return childFund;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Edge{" +
                "parentFund=" + parentFund +
                ", childFund=" + childFund +
                '}';
    }
}
