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
        assertThrows(IllegalArgumentException.class, () -> new PackagedPieceProduct(product.getName(), product.getDescription(), product.getWeight(), 0, productPackage));
        assertThrows(IllegalArgumentException.class, () -> new PackagedPieceProduct(product.getName(), product.getDescription(), product.getWeight(), -1, productPackage));
    }

    @Test
    void calculatesWeightsForMultiplePieces() {
        var packed = new PackagedPieceProduct(product.getName(), product.getDescription(), product.getWeight(), 3, productPackage);
        assertEquals(6, packed.getNetWeight());
        assertEquals(7, packed.getTotalWeight());
    }

    @Test
    void rejectsNullNameAndPackage() {
        assertThrows(NullPointerException.class, () -> new PackagedPieceProduct(null, null, 1, 1, productPackage));
        assertThrows(NullPointerException.class, () -> new PackagedPieceProduct(product.getName(), product.getDescription(), product.getWeight(), 1, null));
    }
}
