package org.mromichov.product.packaged;

import org.mromichov.product.ProductPackage;
import org.mromichov.product.PieceProductType;

public class PackagedPieceProduct implements PackagedProduct {
    private final PieceProductType pieceProduct;
    private final ProductPackage productPackage;
    private final int piecesNumber;

    public PackagedPieceProduct(PieceProductType pieceProduct, int piecesNumber, ProductPackage productPackage) {
        this.pieceProduct = pieceProduct;
        this.productPackage = productPackage;
        this.piecesNumber = piecesNumber;
    }

    @Override
    public int getNetWeight() {
        return piecesNumber * pieceProduct.getWeight();
    }

    @Override
    public int getTotalWeight() {
        return getNetWeight() + productPackage.getWeight();
    }
}
