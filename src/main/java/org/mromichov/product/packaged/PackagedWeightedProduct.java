package org.mromichov.product.packaged;

import org.mromichov.product.ProductPackage;
import org.mromichov.product.WeightedProductType;

import java.util.Objects;

public class PackagedWeightedProduct implements PackagedProduct {
    private final ProductPackage productPackage;
    private final int netWeight;

    public PackagedWeightedProduct(WeightedProductType weightedProduct, int netWeight, ProductPackage productPackage) {
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
        return netWeight == that.netWeight;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(netWeight);
    }
}
