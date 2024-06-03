package com.srt.dto;

public class ProductListingDto {
    private int productNo;
    private String productName;
    private String category;

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductListingDto{" +
                "productNo=" + productNo +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
