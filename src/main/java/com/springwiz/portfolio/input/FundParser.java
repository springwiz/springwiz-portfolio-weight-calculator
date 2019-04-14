package com.springwiz.portfolio.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.springwiz.portfolio.model.Edge;
import com.springwiz.portfolio.model.Fund;

/**
 * The Class FundParser 
 * Reads input from a file.
 */
public class FundParser implements InputHandler {
    
    /** The market value. */
    private Long marketValue;
    
    /** The Constant log. */
    private static final Logger log = Logger.getLogger(FundParser.class.getName());
    
    /**
     * Instantiates a new fund parser.
     */
    public FundParser() {
    	
    }
    
    /**
     * Parses the.
     *
     * @param fileName the file name
     * @return the list
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Override
    public List<Edge> parse(String fileName) throws IOException {

        List<String> content = read(fileName);
        log.info("Lines read:"+ content.size());
        Map<String, Long> fundMap = new HashMap<>();
        content.forEach(p -> {
            String[] tokens = p.split(",");
            fundMap.put(tokens[1], Long.valueOf(tokens[2]));
        });
        marketValue = fundMap.values()
                .stream()
                .mapToLong(Long::valueOf)
                .sum();
        log.info("Calculated marketValue:"+ marketValue);
        return content.stream()
                .map(p -> p.split(","))
                .map(p ->
                        new Edge(
                                new Fund(p[0], fundMap.getOrDefault(p[0], 0L)),
                                new Fund(p[1], Long.parseLong(p[2])))
                )
                .collect(Collectors.toList());
    }

    /**
     * Read.
     *
     * @param fileName the file name
     * @return the list
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private List<String> read(String fileName) throws IOException {
        Stream<String> lines = null;
        lines = Files.lines(Paths.get(fileName));
        return Objects.requireNonNull(lines).collect(Collectors.toList());
    }

    /**
     * Gets the market value.
     *
     * @return the market value
     */
    public Long getMarketValue() {
        return marketValue;
    }
}
