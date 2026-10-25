package org.mromichov.product.packaged;

import org.mromichov.product.ProductPackage;

import java.util.List;
import java.util.Objects;

public class PackagedProductSet implements PackagedProduct {
    private final ProductPackage productPackage;
    private final List<PackagedProduct> innerProducts;

    public PackagedProductSet(ProductPackage productPackage, PackagedProduct... innerProducts) {
        this.productPackage = productPackage;
        this.innerProducts = List.of(innerProducts);
    }

    public ProductPackage getProductPackage() {
        return productPackage;
    }

    public List<PackagedProduct> getInnerProducts() {
        return innerProducts;
    }

    @Override
    public int getNetWeight() {
        int netWeight = 0;
        for (PackagedProduct product:
             innerProducts) {
            netWeight += product.getTotalWeight();
        }
        return netWeight;
    }

    @Override
    public int getTotalWeight() {
        return getNetWeight() + productPackage.getWeight();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PackagedProductSet that = (PackagedProductSet) o;
        return Objects.equals(productPackage, that.productPackage) && Objects.equals(innerProducts, that.innerProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productPackage, innerProducts);
    }
}
