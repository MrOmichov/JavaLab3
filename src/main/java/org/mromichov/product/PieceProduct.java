package org.mromichov.product;

import java.util.Objects;

public class PieceProduct extends Product {
    private final int weight;
    public PieceProduct(String name, String description, int weight) {
        super(name, description);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PieceProduct that = (PieceProduct) o;
        return weight == that.weight && Objects.equals(getName(), that.getName()) && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), weight);
    }
}
