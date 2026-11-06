import org.junit.jupiter.api.Test;
import org.mromichov.product.PieceProduct;
import org.mromichov.product.ProductPackage;
import org.mromichov.product.packaged.PackagedPieceProduct;

import static org.junit.jupiter.api.Assertions.*;

class PackagedPieceProductTest {
    private final PieceProduct product = new PieceProduct("apple", "fruit", 2);
    private final ProductPackage productPackage = new ProductPackage("box", 1);

    @Test
    void nonPositiveNumberOfPiecesCausesException() {
        assertThrows(IllegalArgumentException.class, () -> new PackagedPieceProduct(product, 0, productPackage));
        assertThrows(IllegalArgumentException.class, () -> new PackagedPieceProduct(product, -1, productPackage));
    }

    @Test
    void calculatesWeightsForMultiplePieces() {
        var packed = new PackagedPieceProduct(product, 3, productPackage);
        assertEquals(6, packed.getNetWeight());
        assertEquals(7, packed.getTotalWeight());
    }

    @Test
    void rejectsNullProductAndPackage() {
        assertThrows(NullPointerException.class, () -> new PackagedPieceProduct(null, 1, productPackage));
        assertThrows(NullPointerException.class, () -> new PackagedPieceProduct(product, 1, null));
    }
}
