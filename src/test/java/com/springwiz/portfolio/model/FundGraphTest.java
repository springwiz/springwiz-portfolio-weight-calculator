package com.springwiz.portfolio.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.springwiz.portfolio.input.FundParser;
import com.springwiz.portfolio.input.InputHandler;
import com.springwiz.portfolio.output.OutputHandler;
import com.springwiz.portfolio.output.StdOutHandler;

public class FundGraphTest {

	private FundGraph graph = null;
	
	private String file = "./data/input.txt";
	
	private InputHandler parser = null;
	
	private OutputHandler out = null;
	
	@Before
	public void setUp() throws Exception {
		parser = new FundParser();
        graph = new FundGraph(parser.parse(file));
        out = new StdOutHandler();
	}

	@Test
	public void testParseGraph() {
		graph.parseGraph(9000, out, parser);
		assertTrue(graph.getProfit() != 0);
	}

}
