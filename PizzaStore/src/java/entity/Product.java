/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author PhamBaoPhi
 */
public class Product {

    private String productID;
    private String productName;
    private String supplierID;
    private String categoryID;
    private int quantityPerUnit;
    private double unitPrice;
    private String description;
    private String productImage;
    private String categoryName;

    public Product(String productID, String productName, String supplierID,
            String categoryID, int quantityPerUnit, double unitPrice,
            String description, String categoryName, String productImage) {
        this.productID = productID;
        this.productName = productName;
        this.supplierID = supplierID;
        this.categoryID = categoryID;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.description = description;
        this.productImage = productImage;
        this.categoryName = categoryName;
    }

    public Product() {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getDescription() {
        return description;
    }

    public String getproductID() {
        return productID;
    }

    public String getproductName() {
        return productName;
    }

    public String getsupplierID() {
        return supplierID;
    }

    public String getcategoryID() {
        return categoryID;
    }

    public int getquantityPerUnit() {
        return quantityPerUnit;
    }

    public double getunitPrice() {
        return unitPrice;
    }

    public String getproductImage() {
        return productImage;
    }

    public void setproductID(String productID) {
        this.productID = productID;
    }

    public void setproductName(String productName) {
        this.productName = productName;
    }

    public void setsupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public void setcategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public void setquantityPerUnit(int quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setunitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setproductImage(String productImage) {
        this.productImage = productImage;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", supplierID=" + supplierID + ", categoryID=" + categoryID + ", quantityPerUnit=" + quantityPerUnit + ", unitPrice=" + unitPrice + ", description=" + description + ", productImage=" + productImage + ", categoryName=" + categoryName + '}';
    }

}
