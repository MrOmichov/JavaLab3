package org.mromichov.product.packaged;

import org.mromichov.product.ProductPackage;
import org.mromichov.product.WeightedProduct;

import java.util.Objects;

public class PackagedWeightedProduct extends WeightedProduct implements PackagedProduct {
    private final ProductPackage productPackage;
    private final int netWeight;

    public PackagedWeightedProduct(WeightedProduct weightedProduct, int netWeight, ProductPackage productPackage) {
        super(weightedProduct.getName(), weightedProduct.getDescription());
        this.productPackage = productPackage;
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
        return Objects.equals(getName(), that.getName()) && Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(productPackage, that.productPackage) && netWeight == that.netWeight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), productPackage, netWeight);
    }
}
