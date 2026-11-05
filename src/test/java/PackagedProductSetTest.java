import org.junit.jupiter.api.Test;
import org.mromichov.product.PieceProduct;
import org.mromichov.product.ProductPackage;
import org.mromichov.product.WeightedProduct;
import org.mromichov.product.packaged.PackagedPieceProduct;
import org.mromichov.product.packaged.PackagedProductSet;
import org.mromichov.product.packaged.PackagedWeightedProduct;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.mromichov.product.packaged.PackagedProduct;

public class PackagedProductSetTest {
    @Test
    void totalWeightCalculatesCorrectly() {
        PackagedProductSet packagedProductSet = usualPackagedProductSet();
        assertEquals(19, packagedProductSet.getTotalWeight());
    }

    @Test
    void nestedSetIncludesEachPackagingWeight() {
        var inner = usualPackagedProductSet();
        var outer = new PackagedProductSet("outer", "set", new ProductPackage("outer box", 4), inner);
        assertEquals(19, outer.getNetWeight());
        assertEquals(23, outer.getTotalWeight());
    }

    @Test
    void emptySetWeighsOnlyItsPackaging() {
        var set = new PackagedProductSet("empty", "set", new ProductPackage("box", 2));
        assertEquals(0, set.getNetWeight());
        assertEquals(2, set.getTotalWeight());
    }

    @Test
    void rejectsNullArgumentsAndElements() {
        var box = new ProductPackage("box", 2);
        assertThrows(NullPointerException.class, () -> new PackagedProductSet(null, "set", box));
        assertThrows(NullPointerException.class, () -> new PackagedProductSet("set", null, box));
        assertThrows(NullPointerException.class, () -> new PackagedProductSet("set", "set", null));
        assertThrows(NullPointerException.class, () -> new PackagedProductSet("set", "set", box, (PackagedProduct[]) null));
        assertThrows(NullPointerException.class, () -> new PackagedProductSet("set", "set", box, (PackagedProduct) null));
    }


    private PackagedProductSet usualPackagedProductSet() {
        PieceProduct pieceProduct = new PieceProduct(
                "test",
                "test",
                1
        );

        WeightedProduct weightedProduct = new WeightedProduct(
                "test",
                "test"
        );

        ProductPackage productPackage = new ProductPackage(
                "test",
                2
        );

        return new PackagedProductSet(
                "test",
                "test",
                productPackage,
                new PackagedPieceProduct(
                        pieceProduct,
                        10,
                        productPackage

                ),
                new PackagedWeightedProduct(
                        weightedProduct,
                        3,
                        productPackage
                )
        );
    }
}
