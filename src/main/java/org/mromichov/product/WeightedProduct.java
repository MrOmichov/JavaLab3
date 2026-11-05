package org.mromichov.product;

public class WeightedProduct extends Product {
    public WeightedProduct(String name, String description) {
        super(name, description);
    }

    @Override
    public String toString() {
        return "WeightedProduct{" +
                "name=" + getName() +
                ", description=" + getDescription() +
                '}';
    }
}
