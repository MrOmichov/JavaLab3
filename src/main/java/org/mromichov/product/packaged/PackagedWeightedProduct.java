package org.mromichov.product.packaged;

import org.mromichov.product.ProductPackage;
import org.mromichov.product.WeightedProduct;

import java.util.Objects;

public class PackagedWeightedProduct extends WeightedProduct implements PackagedProduct {
    private final ProductPackage productPackage;
    private final int netWeight;

    public PackagedWeightedProduct(String name, String description, int netWeight, ProductPackage productPackage) {
        super(name, description);
        this.productPackage = Objects.requireNonNull(productPackage, "Product package cannot be null!");
        if (netWeight < 1) {
            throw new IllegalArgumentException("Net weight must be positive");
        }
        this.netWeight = netWeight;
    }

    public ProductPackage getProductPackage() {
        return productPackage;
    }

    @Override
    public int getTotalWeight() {
        return netWeight + productPackage.getWeight();
    }

    @Override
    public int getNetWeight() {
        return netWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PackagedWeightedProduct that = (PackagedWeightedProduct) o;
        return Objects.equals(productPackage, that.productPackage) && netWeight == that.netWeight
                && Objects.equals(getName(), that.getName()) && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), productPackage, netWeight);
    }

    @Override
    public String toString() {
        return "PackagedWeightedProduct{" +
                "name=" + getName() +
                ", description" + getDescription() +
                ", productPackage=" + productPackage +
                ", netWeight=" + netWeight +
                '}';
    }
}
