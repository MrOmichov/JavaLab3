package org.mromichov.filter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Objects;

public class CountSubstringFilter implements Filter {
    private final Pattern pattern;
    private final int times;

    public CountSubstringFilter(String pattern, int times) {
        this.pattern = Pattern.compile(Objects.requireNonNull(pattern, "Pattern cannot be null!"), Pattern.LITERAL);
        this.times = times;
    }

    @Override
    public boolean apply(String stringToCheck) {
        Objects.requireNonNull(stringToCheck, "String cannot be null!");
        Matcher matcher = pattern.matcher(stringToCheck);
        int count = 0;
        while (matcher.find())
            count++;


        return count == times;
    }
}
