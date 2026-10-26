package org.mromichov.product.packaged;

import org.mromichov.product.Product;
import org.mromichov.product.ProductPackage;

import java.util.List;
import java.util.Objects;

public class PackagedProductSet extends Product implements PackagedProduct {
    private final ProductPackage productPackage;
    private final List<PackagedProduct> innerProducts;

    public PackagedProductSet(String name, String description, ProductPackage productPackage, PackagedProduct... innerProducts) {
        super(name, description);
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
        return Objects.equals(getName(), that.getName()) && Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(productPackage, that.productPackage) && Objects.equals(innerProducts, that.innerProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), productPackage, innerProducts);
    }
}
