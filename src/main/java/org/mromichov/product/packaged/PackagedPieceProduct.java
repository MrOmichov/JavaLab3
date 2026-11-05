package org.mromichov.product.packaged;

import org.mromichov.product.ProductPackage;
import org.mromichov.product.PieceProduct;

import java.util.Objects;

public class PackagedPieceProduct implements PackagedProduct {
    private final PieceProduct pieceProduct;
    private final ProductPackage productPackage;
    private final int piecesNumber;

    public PackagedPieceProduct(PieceProduct pieceProduct, int piecesNumber, ProductPackage productPackage) {
        this.pieceProduct = Objects.requireNonNull(pieceProduct, "Piece product cannot be null!");
        this.productPackage = Objects.requireNonNull(productPackage, "Product package cannot be null!");
        this.piecesNumber = piecesNumber;
    }

    public PieceProduct getPieceProduct() {
        return pieceProduct;
    }

    @Override
    public String getName() {
        return pieceProduct.getName();
    }

    @Override
    public String getDescription() {
        return pieceProduct.getDescription();
    }

    public ProductPackage getProductPackage() {
        return productPackage;
    }

    public int getPiecesNumber() {
        return piecesNumber;
    }

    @Override
    public int getNetWeight() {
        return piecesNumber * pieceProduct.getWeight();
    }

    @Override
    public int getTotalWeight() {
        return getNetWeight() + productPackage.getWeight();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PackagedPieceProduct that = (PackagedPieceProduct) o;
        return piecesNumber == that.piecesNumber && Objects.equals(pieceProduct, that.pieceProduct) &&
                Objects.equals(productPackage, that.productPackage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceProduct, productPackage, piecesNumber);
    }

    @Override
    public String toString() {
        return "PackagedPieceProduct{" +
                "pieceProduct=" + pieceProduct +
                ", productPackage=" + productPackage +
                ", piecesNumber=" + piecesNumber +
                '}';
    }
}
