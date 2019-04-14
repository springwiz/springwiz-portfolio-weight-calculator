package com.springwiz.portfolio.model;
import java.util.*;
import java.util.logging.Logger;

import com.springwiz.portfolio.input.FundParser;
import com.springwiz.portfolio.input.InputHandler;
import com.springwiz.portfolio.output.OutputHandler;

import static java.util.stream.Collectors.toList;

import java.text.DecimalFormat;

/**
 * The Class FundGraph.
 */
public class FundGraph {
    
    /** The adj list. */
    private Map<Fund, Set<Fund>> adjList = new HashMap<>();
    
    /** The Constant log. */
    private static final Logger log = Logger.getLogger(FundGraph.class.getName());
    
    /** The profit. */
    private long profit = 0;

	/**
     * Instantiates a new fund graph.
     *
     * @param edges the edges
     */
    public FundGraph(List<Edge> edges) {
        addEdges(edges);
    }

    /**
     * Gets the adj list.
     *
     * @return the adj list
     */
    public Map<Fund, Set<Fund>> getAdjList() {
        return adjList;
    }

    /**
     * Adds the edges.
     *
     * @param edges the edges
     */
    private void addEdges(List<Edge> edges) {
        edges.forEach(edge -> {
            adjList.computeIfAbsent(
                    edge.getParentFund(),
                    (v) -> new TreeSet<>()
            );
            adjList.computeIfPresent(
                    edge.getParentFund(),
                    (k, v) -> {
                        v.add(edge.getChildFund());
                        return v;
                    });
        });
    }

    /**
     * Traverse.
     *
     * @param fund the fund
     * @return the array list
     */
    public ArrayList<Fund> traverse(Fund fund) {
        ArrayList<Fund> path = new ArrayList<>();
        Queue<Fund> queue = new LinkedList<>();
        queue.add(fund);
        while (!queue.isEmpty()) {
            Fund node = queue.remove();
            if (!path.contains(node)) {
                path.add(node);
                if (adjList.containsKey(node)) {
                    Set<Fund> funds = adjList.get(node);
                    queue.addAll(funds);
                }
            }
        }
        return path;
    }

    /**
     * Gets the leaves.
     *
     * @return the leaves
     */
    public List<Fund> getLeaves() {
        List<Fund> keys = new ArrayList<>(adjList.keySet());
        List<Fund> values = adjList.values()
                .stream()
                .flatMap(Set::stream)
                .collect(toList());
        return values.stream()
                .filter(p -> !keys.contains(p))
                .collect(toList());
    }
    
    /**
     * Parses the graph.
     *
     * @param marketCap the market cap
     * @param out the out
     * @param parser the parser
     */
    public void parseGraph(long marketCap, OutputHandler out, InputHandler parser) {
        List<Fund> leaves = getLeaves();
        getAdjList()
                .keySet()
                .forEach(fund -> {
                    ArrayList<Fund> pathToLeaves = traverse(fund);
                    List<Fund> parentFunds = pathToLeaves.stream()
                            .filter(leaves::contains)
                            .collect(toList());
                    List<Fund> childFunds = pathToLeaves.stream()
                            .filter(parentFunds::contains)
                            .collect(toList());
                    long parentSum = parentFunds.stream()
                            .map(Fund::getFundValue)
                            .mapToLong(Long::longValue)
                            .sum();
                    childFunds.forEach(f ->
                    out.getOutputStream().printf(
                                    "%s,%s,%.3f\n",
                                    fund.getFundName(),
                                    f.getFundName(),
                                    (double) f.getFundValue() / parentSum));
                });
        profit = marketCap - parser.getMarketValue();
        log.info("Calculated profit:"+ profit);
        out.getOutputStream().println(
                new DecimalFormat(".## %")
                .format((double)profit/parser.getMarketValue())
        );
	}
    
    /**
     * Gets the profit.
     *
     * @return the profit
     */
    public long getProfit() {
		return profit;
	}
}
