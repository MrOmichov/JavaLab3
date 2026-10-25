package org.mromichov.product.packaged;

import org.mromichov.product.ProductPackage;
import org.mromichov.product.PieceProductType;

import java.util.Objects;

public class PackagedPieceProduct implements PackagedProduct {
    private final PieceProductType pieceProduct;
    private final ProductPackage productPackage;
    private final int piecesNumber;

    public PackagedPieceProduct(PieceProductType pieceProduct, int piecesNumber, ProductPackage productPackage) {
        this.pieceProduct = pieceProduct;
        this.productPackage = productPackage;
        this.piecesNumber = piecesNumber;
    }

    public PieceProductType getPieceProduct() {
        return pieceProduct;
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
        return piecesNumber == that.piecesNumber && Objects.equals(pieceProduct, that.pieceProduct) && Objects.equals(productPackage, that.productPackage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceProduct, productPackage, piecesNumber);
    }
}
