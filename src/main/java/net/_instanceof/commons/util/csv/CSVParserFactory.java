/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.util.csv;

/**
 * 
 *
 */
public class CSVParserFactory {
	public CSVParser createCSVParser(final String tag) {
		return new CSVParserImpl();
	}
}
