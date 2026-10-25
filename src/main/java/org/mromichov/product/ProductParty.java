package org.mromichov.product;

import org.mromichov.product.packaged.PackagedProduct;

import java.util.List;
import java.util.Objects;

public class ProductParty {
    private final String description;
    private final List<PackagedProduct> products;

    public ProductParty(String name, String description, PackagedProduct... products) {
        this.description = description;
        this.products = List.of(products);
    }
    
    public int getTotalWeight() {
        int totalWeight = 0;
        for (PackagedProduct product:
             products) {
            totalWeight += product.getTotalWeight();
        }
        return totalWeight;
    }


    public String getDescription() {
        return description;
    }

    public List<PackagedProduct> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductParty that = (ProductParty) o;
        return Objects.equals(description, that.description) && Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, products);
    }
}
