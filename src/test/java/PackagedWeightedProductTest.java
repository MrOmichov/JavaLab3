import org.junit.jupiter.api.Test;
import org.mromichov.product.ProductPackage;
import org.mromichov.product.WeightedProduct;
import org.mromichov.product.packaged.PackagedWeightedProduct;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PackagedWeightedProductTest {
    @Test
    void totalWeightCorrectlyCalculates() {
        PackagedWeightedProduct packagedWeightedProduct = new PackagedWeightedProduct(
                new WeightedProduct("test", "test"),
                5,
                new ProductPackage("test", 1)
        );
        assertEquals(6, packagedWeightedProduct.getTotalWeight());
    }

    @Test
    void totalWeightCorrectlyCalculatesWithZerNetWeight() {
        PackagedWeightedProduct packagedWeightedProduct = new PackagedWeightedProduct(
                new WeightedProduct("test", "test"),
                0,
                new ProductPackage("test", 1)
        );
        assertEquals(1, packagedWeightedProduct.getTotalWeight());
    }

    @Test
    void rejectsToUseNullArgumentsAndThrowsNLP() {
        assertThrows(NullPointerException.class, () -> new PackagedWeightedProduct(null, 0, null));
    }

    @Test
    void rejectsNullPackageSeparately() {
        assertThrows(NullPointerException.class,
                () -> new PackagedWeightedProduct(new WeightedProduct("rice", "food"), 5, null));
    }
}
