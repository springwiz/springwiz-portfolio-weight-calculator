/**
 * 
 */
package com.springwiz.portfolio.input;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.springwiz.portfolio.input.FundParser;
import com.springwiz.portfolio.input.InputHandler;

/**
 * @author sumitnarayan
 *
 */
public class FundParserTest {

	private String file = "./data/input.txt";
	
	private InputHandler parser = null;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		parser = new FundParser();
	}

	/**
	 * Test method for {@link com.springwiz.portfolio.input.FundParser#parse(java.lang.String)}.
	 */
	@Test
	public void testParse() {
		try {
			assertTrue(parser.parse(file).size() > 0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
