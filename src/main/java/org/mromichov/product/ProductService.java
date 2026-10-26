package org.mromichov.product;

import org.mromichov.filter.Filter;
import org.mromichov.product.packaged.PackagedProduct;
import org.mromichov.product.packaged.PackagedProductSet;

public class ProductService {
    public static int countByFilter(ProductParty party, Filter filter) {
        return party.getProducts()
                .stream()
                .filter(product -> filter.apply(product.getName()))
                .toList()
                .size();
    }

    public static int countByFilterDeep(ProductParty party, Filter filter) {
        return party.getProducts()
                .stream()
                .filter(product -> hasNameDeeply(product, filter))
                .toList()
                .size();
    }

    private static boolean hasNameDeeply(PackagedProduct productToCheck, Filter filter) {
        return switch (productToCheck) {
            case PackagedProductSet packagedProductSet -> hasNameInPackagedProductSet(packagedProductSet, filter);
            default -> filter.apply(productToCheck.getName());
        };
    }

    private static boolean hasNameInPackagedProductSet(PackagedProductSet packagedProductSet, Filter filter) {
        if (filter.apply(packagedProductSet.getName())) return true;
        for (PackagedProduct packagedProduct : packagedProductSet.getInnerProducts()) {
            if (filter.apply(packagedProduct.getName()) || hasNameDeeply(packagedProduct, filter))
                return true;
        }
        return false;
    }

    public static boolean checkAllWeighted(ProductParty party) {
        return party.getProducts().stream().allMatch(product -> product instanceof WeightedProduct);
    }
}
