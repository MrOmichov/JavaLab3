package org.mromichov.product;

import java.util.Objects;

public abstract class ProductType {
    private final String name;
    private final String description;

    public ProductType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductType productType = (ProductType) o;
        return Objects.equals(name, productType.name) && Objects.equals(description, productType.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }
}
