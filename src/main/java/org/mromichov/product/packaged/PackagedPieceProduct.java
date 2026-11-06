package org.mromichov.product.packaged;

import org.mromichov.product.ProductPackage;
import org.mromichov.product.PieceProduct;

import java.util.Objects;

public class PackagedPieceProduct extends PieceProduct implements PackagedProduct {
    private final ProductPackage productPackage;
    private final int piecesNumber;

    public PackagedPieceProduct(String name, String description, int pieceWeight, int piecesNumber, ProductPackage productPackage) {
        super(name, description, pieceWeight);
        this.productPackage = Objects.requireNonNull(productPackage, "Product package cannot be null!");

        if (piecesNumber < 1) {
            throw new IllegalArgumentException("Number of pieces must be positive");
        }
        this.piecesNumber = piecesNumber;
    }

    public ProductPackage getProductPackage() {
        return productPackage;
    }

    public int getPiecesNumber() {
        return piecesNumber;
    }

    @Override
    public int getNetWeight() {
        return piecesNumber * getWeight();
    }

    @Override
    public int getTotalWeight() {
        return getNetWeight() + productPackage.getWeight();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PackagedPieceProduct that = (PackagedPieceProduct) o;
        return piecesNumber == that.piecesNumber && Objects.equals(getName(), that.getName()) &&
                Objects.equals(productPackage, that.productPackage) && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), productPackage, piecesNumber);
    }

    @Override
    public String toString() {
        return "PackagedPieceProduct{" +
                "name=" + getName() +
                ", description" + getDescription() +
                ", productPackage=" + productPackage +
                ", piecesNumber=" + piecesNumber +
                '}';
    }
}
