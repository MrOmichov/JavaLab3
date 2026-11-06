import org.junit.jupiter.api.Test;
import org.mromichov.product.PieceProduct;
import org.mromichov.product.ProductPackage;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductPackageTest {
    @Test
    void nonPositiveNumberOfPiecesCausesException() {
        String name = "bag";
        assertThrows(IllegalArgumentException.class, () -> new ProductPackage(name, 0));
        assertThrows(IllegalArgumentException.class, () -> new ProductPackage(name, -1));
    }
}
