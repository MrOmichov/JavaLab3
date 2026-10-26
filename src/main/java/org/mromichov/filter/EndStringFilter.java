package org.mromichov.filter;

public class EndStringFilter implements Filter {
    private final String pattern;

    public EndStringFilter(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean apply(String stringToCheck) {
        return stringToCheck.endsWith(pattern);
    }
}
