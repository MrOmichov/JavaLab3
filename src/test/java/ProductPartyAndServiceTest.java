import org.junit.jupiter.api.Test;
import org.mromichov.filter.BeginStringFilter;
import org.mromichov.product.*;
import org.mromichov.product.packaged.*;
import static org.junit.jupiter.api.Assertions.*;

class ProductPartyAndServiceTest {
    private final ProductPackage box = new ProductPackage("box", 1);
    private final PackagedWeightedProduct rice = new PackagedWeightedProduct(new WeightedProduct("rice", "food"), 5, box);
    private final PackagedPieceProduct apple = new PackagedPieceProduct(new PieceProduct("apple", "fruit", 2), 3, box);

    @Test
    void calculatesPartyWeightIncludingNestedPackaging() {
        var set = new PackagedProductSet("basket", "set", new ProductPackage("basket", 3), apple);
        assertEquals(16, new ProductParty("party", rice, set).getTotalWeight());
        assertEquals(0, new ProductParty("empty").getTotalWeight());
    }

    @Test
    void countsTopLevelNamesAndSearchesNestedSets() {
        var inner = new PackagedProductSet("inner", "set", box, apple, apple);
        var outer = new PackagedProductSet("outer", "set", box, inner);
        var party = new ProductParty("party", rice, outer);
        var appleFilter = new BeginStringFilter("app");
        assertEquals(0, ProductService.countByFilter(party, appleFilter));
        assertEquals(1, ProductService.countByFilterDeep(party, appleFilter));
        assertEquals(1, ProductService.countByFilter(party, new BeginStringFilter("out")));
        assertEquals(0, ProductService.countByFilterDeep(party, new BeginStringFilter("missing")));
    }

    @Test
    void checksTopLevelWeightedProducts() {
        assertTrue(ProductService.checkAllWeighted(new ProductParty("party", rice)));
        assertFalse(ProductService.checkAllWeighted(new ProductParty("party", rice, apple)));
        assertTrue(ProductService.checkAllWeighted(new ProductParty("empty")));
        assertFalse(ProductService.checkAllWeighted(new ProductParty("party", new PackagedProductSet("set", "set", box, rice))));
    }

    @Test
    void rejectsNullPartyArgumentsAndElements() {
        assertThrows(NullPointerException.class, () -> new ProductParty(null, rice));
        assertThrows(NullPointerException.class, () -> new ProductParty("party", (PackagedProduct[]) null));
        assertThrows(NullPointerException.class, () -> new ProductParty("party", rice, null));
    }

    @Test
    void serviceRejectsNullArgumentsEvenForEmptyParty() {
        var empty = new ProductParty("empty");
        var filter = new BeginStringFilter("a");
        assertThrows(NullPointerException.class, () -> ProductService.countByFilter(null, filter));
        assertThrows(NullPointerException.class, () -> ProductService.countByFilter(empty, null));
        assertThrows(NullPointerException.class, () -> ProductService.countByFilterDeep(null, filter));
        assertThrows(NullPointerException.class, () -> ProductService.countByFilterDeep(empty, null));
        assertThrows(NullPointerException.class, () -> ProductService.checkAllWeighted(null));
    }

    @Test
    void productsAndPackagesRejectNullText() {
        assertThrows(NullPointerException.class, () -> new WeightedProduct(null, "description"));
        assertThrows(NullPointerException.class, () -> new WeightedProduct("name", null));
        assertThrows(NullPointerException.class, () -> new PieceProduct(null, "description", 1));
        assertThrows(NullPointerException.class, () -> new PieceProduct("name", null, 1));
        assertThrows(NullPointerException.class, () -> new ProductPackage(null, 1));
    }
}
