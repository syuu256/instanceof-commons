/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.util.collect;

import java.util.Collection;

public class Collect {

    public static String toCommaTokenString(final Collection<String> set) {
        final StringBuilder sb = new StringBuilder();
        for (final String s : set)
            sb.append(s).append(",");
        if (sb.length() != 0) sb.setLength(sb.length() - 1);
        return sb.toString();
    }

}
