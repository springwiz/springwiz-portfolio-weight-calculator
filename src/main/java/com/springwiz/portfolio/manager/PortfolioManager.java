package com.springwiz.portfolio.manager;
import java.io.IOException;
import java.util.List;

import com.springwiz.portfolio.input.FundParser;
import com.springwiz.portfolio.input.InputHandler;
import com.springwiz.portfolio.model.Edge;
import com.springwiz.portfolio.model.FundGraph;
import com.springwiz.portfolio.output.OutputHandler;
import com.springwiz.portfolio.output.StdOutHandler;

/**
 * The Class PortfolioManager.
 * Serves as entry point of the application
 */
public class PortfolioManager {
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        String inputfile = args[0];
        long marketCap = Long.valueOf(args[1]);
        OutputHandler out = new StdOutHandler();
        
        InputHandler parser = new FundParser();
        
        List<Edge> edgeList = null;
		try {
			edgeList = parser.parse(inputfile);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		new FundGraph(edgeList).parseGraph(marketCap, out, parser);
    }
}
