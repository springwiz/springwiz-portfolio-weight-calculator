package com.springwiz.portfolio.output;

import java.io.PrintStream;

/**
 * The Class StdOutHandler.
 */
public class StdOutHandler implements OutputHandler {
	
	/**
	 * Instantiates a new std out handler.
	 */
	public StdOutHandler()  {

	}
	
	/**
	 * Gets the output stream.
	 *
	 * @return the output stream
	 */
	@Override
	public PrintStream getOutputStream() {
		return System.out;
	}
}
