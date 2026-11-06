import org.junit.jupiter.api.Test;
import org.mromichov.product.PieceProduct;
import org.mromichov.product.packaged.PackagedPieceProduct;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PieceProductTest {
    @Test
    void nonPositiveNumberOfPiecesCausesException() {
        String name = "apple";
        String description = "tasty";
        assertThrows(IllegalArgumentException.class, () -> new PieceProduct(name, description, 0));
        assertThrows(IllegalArgumentException.class, () -> new PieceProduct(name, description, -1));
    }
}
