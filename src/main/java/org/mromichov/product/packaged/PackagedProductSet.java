package org.mromichov.product.packaged;

import org.mromichov.product.ProductPackage;

import java.util.List;

public class PackagedProductSet implements PackagedProduct {
    private final ProductPackage productPackage;
    private final List<PackagedProduct> innerProducts;

    public PackagedProductSet(ProductPackage productPackage, PackagedProduct... innerProducts) {
        this.productPackage = productPackage;
        this.innerProducts = List.of(innerProducts);
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
}
