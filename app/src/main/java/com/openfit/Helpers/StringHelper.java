package com.openfit.Helpers;

import org.apache.commons.lang3.StringUtils;

public class StringHelper {
    public static boolean stringContains(String source, String substring) {
        return StringUtils
                .stripAccents(source)
                .toLowerCase()
                .contains(StringUtils
                        .stripAccents(substring)
                        .toLowerCase());
    }
}
