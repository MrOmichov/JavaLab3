package org.mromichov.product;

import java.util.Objects;

public final class ProductPackage {
    private final String name;
    private final int weight;

    public ProductPackage(String name, int weight) {
        Objects.requireNonNull(name, "Name cannot be null!");
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductPackage that = (ProductPackage) o;
        return weight == that.weight && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight);
    }

    @Override
    public String toString() {
        return "ProductPackage{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
