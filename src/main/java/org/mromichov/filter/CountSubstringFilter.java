package org.mromichov.filter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountSubstringFilter implements Filter {
    private final Pattern pattern;
    private final int times;

    public CountSubstringFilter(String pattern, int times) {
        this.pattern = Pattern.compile(pattern);
        this.times = times;
    }

    @Override
    public boolean apply(String stringToCheck) {
        Matcher matcher = pattern.matcher(stringToCheck);
        int count = 0;
        while (matcher.find())
            count++;


        return count == times;
    }
}
