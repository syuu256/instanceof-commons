/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.util.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 */
public class IsbnHelper {
	/**
	 * ISBN10toISBN13化の為の正規化表現.
	 */
	private static final Pattern REXPAT10TO13 = Pattern.compile("^(\\d)(\\d)(\\d)-?(\\d)-?(\\d)-?(\\d)-?(\\d)-?(\\d)-?(\\d)-?(\\d)-?(\\d)-?(\\d)-?[\\dX]$");
	
	/**
	 * ISBN10正規表現.
	 */
	private static final Pattern REXPAT10 = Pattern.compile("^\\d-?(?:\\d{1}-?\\d{7}|\\d{2}-?\\d{6}|\\d{3}-?\\d{5}|\\d{4}-?\\d{4}|\\d{5}-?\\d{3}|\\d{6}-?\\d{2}|\\d{7}-?\\d{1})-?[\\dX]");
	
	/**
	 * ISBN13正規表現.
	 */
	private static final Pattern REXPAT13 = Pattern.compile("^\\d{3}-?\\d-?\\d{2}-?\\d{6}-?\\d$");
	
	/**
	 * ISBN10形式の文字列判定.
	 * @param str
	 * @return ISBN10の時true
	 */
	private static final boolean isIsbn10(String str) {
		return REXPAT10.matcher(str).matches();
	}
	
	
	/**
	 * ISBN 13形式の文字列判定
	 * @param str
	 * @return ISBN13の時true
	 */
	private static final boolean isIsbn13(String str) {
		return REXPAT13.matcher(str).matches();
	}
	
	public static final String toIsbn13(final String str) {
		String ret	= null;
		
		if (isIsbn10(str)) {
			Matcher m = REXPAT10TO13.matcher("978-" + str);
			if (m.matches()) {
				int n	= m.groupCount();
				int check_sum	= 0;
				int value	= 0;
				String isbn10	= "";
				
				for (int i = 1; i <= n; i++) {
					value	= Integer.parseInt(m.group(i));
					isbn10	+= value;
					check_sum	+= (((i % 2) == 0) ? 3 : 1) * value; 
				}
				check_sum	= 10 - (check_sum % 10);
				ret	= isbn10 + (check_sum == 10 ? 0 : check_sum);
			}
		} else if (isIsbn13(str)) {
			ret	= str.replaceAll("-", "");
		}
		return ret;
	}
	
}
