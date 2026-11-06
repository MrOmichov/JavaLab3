import org.junit.jupiter.api.Test;
import org.mromichov.product.ProductPackage;
import org.mromichov.product.WeightedProduct;
import org.mromichov.product.packaged.PackagedWeightedProduct;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PackagedWeightedProductTest {
    private final WeightedProduct product = new WeightedProduct("flour", "for bakery");
    private final ProductPackage productPackage = new ProductPackage("bag", 1);

    @Test
    void totalWeightCorrectlyCalculates() {
        PackagedWeightedProduct packagedWeightedProduct = new PackagedWeightedProduct(
                "test",
                "test",
                5,
                new ProductPackage("test", 1)
        );
        assertEquals(6, packagedWeightedProduct.getTotalWeight());
    }


    @Test
    void nonPositiveNetWeightCausesException() {
        assertThrows(IllegalArgumentException.class, () -> new PackagedWeightedProduct(product.getName(), product.getDescription(), 0, productPackage));
        assertThrows(IllegalArgumentException.class, () -> new PackagedWeightedProduct(product.getName(), product.getDescription(), -1, productPackage));
    }

    @Test
    void rejectsToUseNullArgumentsAndThrowsNLP() {
        assertThrows(NullPointerException.class, () -> new PackagedWeightedProduct(null, null, 0, null));
    }

    @Test
    void rejectsNullPackageSeparately() {
        assertThrows(NullPointerException.class,
                () -> new PackagedWeightedProduct("rice", "food", 5, null));
    }
}
