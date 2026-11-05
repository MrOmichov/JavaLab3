package org.mromichov.product.packaged;

import org.mromichov.product.ProductPackage;
import org.mromichov.product.WeightedProduct;

import java.util.Objects;

public class PackagedWeightedProduct implements PackagedProduct {
    private final WeightedProduct weightedProduct;
    private final ProductPackage productPackage;
    private final int netWeight;

    public PackagedWeightedProduct(WeightedProduct weightedProduct, int netWeight, ProductPackage productPackage) {
        this.weightedProduct = Objects.requireNonNull(weightedProduct, "Weighted product cannot be null!");
        this.productPackage = Objects.requireNonNull(productPackage, "Product package cannot be null!");
        this.netWeight = netWeight;
    }

    public WeightedProduct getWeightedProduct() {
        return weightedProduct;
    }

    @Override
    public String getName() {
        return weightedProduct.getName();
    }

    @Override
    public String getDescription() {
        return weightedProduct.getDescription();
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
        return Objects.equals(weightedProduct, that.weightedProduct) &&
                Objects.equals(productPackage, that.productPackage) && netWeight == that.netWeight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weightedProduct, productPackage, netWeight);
    }

    @Override
    public String toString() {
        return "PackagedWeightedProduct{" +
                "weightedProduct=" + weightedProduct +
                ", productPackage=" + productPackage +
                ", netWeight=" + netWeight +
                '}';
    }
}
