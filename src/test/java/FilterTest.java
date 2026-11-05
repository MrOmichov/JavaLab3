import org.junit.jupiter.api.Test;
import org.mromichov.filter.BeginStringFilter;
import org.mromichov.filter.EndStringFilter;
import org.mromichov.filter.CountSubstringFilter;
import static org.junit.jupiter.api.Assertions.*;

class FilterTest {
    @Test
    void checksBeginningAndEnd() {
        assertTrue(new BeginStringFilter("Мама").apply("Мама мыла раму"));
        assertFalse(new BeginStringFilter("мыла").apply("Мама мыла раму"));
        assertTrue(new EndStringFilter("раму").apply("Мама мыла раму"));
        assertFalse(new EndStringFilter("мыла").apply("Мама мыла раму"));
    }

    @Test
    void countsLiteralNonOverlappingSubstrings() {
        assertTrue(new CountSubstringFilter(".", 1).apply("a.b"));
        assertFalse(new CountSubstringFilter(".", 3).apply("a.b"));
        assertTrue(new CountSubstringFilter("aa", 1).apply("aaa"));
        assertTrue(new CountSubstringFilter("x", 0).apply("abc"));
        assertTrue(new CountSubstringFilter("", 4).apply("abc"));
    }

    @Test
    void rejectsNullPatternsAndInput() {
        assertThrows(NullPointerException.class, () -> new BeginStringFilter(null));
        assertThrows(NullPointerException.class, () -> new EndStringFilter(null));
        assertThrows(NullPointerException.class, () -> new CountSubstringFilter(null, 1));
        assertThrows(NullPointerException.class, () -> new BeginStringFilter("a").apply(null));
        assertThrows(NullPointerException.class, () -> new EndStringFilter("a").apply(null));
        assertThrows(NullPointerException.class, () -> new CountSubstringFilter("a", 1).apply(null));
    }
}
