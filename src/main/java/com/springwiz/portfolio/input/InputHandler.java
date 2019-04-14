/**
 * 
 */
package com.springwiz.portfolio.input;

import java.io.IOException;
import java.util.List;

import com.springwiz.portfolio.model.Edge;

/**
 * The Interface InputHandler.
 */
public interface InputHandler {
	
	/**
	 * Parses the.
	 *
	 * @param fileName the file name
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	List<Edge> parse(String fileName) throws IOException;

	/**
	 * Gets the market value.
	 *
	 * @return the market value
	 */
	Long getMarketValue();
}
