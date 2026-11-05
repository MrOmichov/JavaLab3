package org.mromichov.filter;

import java.util.Objects;

public class BeginStringFilter implements Filter {
    private final String pattern;

    public BeginStringFilter(String pattern) {
        this.pattern = Objects.requireNonNull(pattern, "Pattern cannot be null!");
    }


    @Override
    public boolean apply(String stringToCheck) {
        Objects.requireNonNull(stringToCheck, "String cannot be null!");
        return stringToCheck.startsWith(pattern);
    }
}
