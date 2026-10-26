package org.mromichov.filter;

public class BeginStringFilter implements Filter {
    private final String pattern;

    public BeginStringFilter(String pattern) {
        this.pattern = pattern;
    }


    @Override
    public boolean apply(String stringToCheck) {
        return stringToCheck.startsWith(pattern);
    }
}
