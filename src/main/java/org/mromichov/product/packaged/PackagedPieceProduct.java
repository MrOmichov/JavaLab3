package org.mromichov.product.packaged;

import org.mromichov.product.ProductPackage;
import org.mromichov.product.PieceProduct;

import java.util.Objects;

public class PackagedPieceProduct extends PieceProduct implements PackagedProduct {
    private final ProductPackage productPackage;
    private final int piecesNumber;

    public PackagedPieceProduct(PieceProduct pieceProduct, int piecesNumber, ProductPackage productPackage) {
        super(pieceProduct.getName(), pieceProduct.getDescription(), pieceProduct.getWeight());
        this.productPackage = productPackage;
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
        return piecesNumber == that.piecesNumber && Objects.equals(productPackage, that.productPackage) &&
                Objects.equals(getName(), that.getName()) && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), productPackage, piecesNumber);
    }
}
