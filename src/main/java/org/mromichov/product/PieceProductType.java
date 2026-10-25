package org.mromichov.product;

import java.util.Objects;

public class PieceProductType extends ProductType {
    private final int weight;
    public PieceProductType(String name, String description, int weight) {
        super(name, description);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PieceProductType that = (PieceProductType) o;
        return weight == that.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), weight);
    }
}
