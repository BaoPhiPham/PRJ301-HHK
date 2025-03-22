
package Entity;


public class CartItem extends Product {
    private int quantity;

    public CartItem(Product product) {
        super(product.getProductID(), product.getProductName(), product.getSupplierID(),
              product.getCategoryID(), product.getQuantityPerUnit(), product.getUnitPrice(), 
              product.getProductImage());
        this.quantity = 1;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity() {
        this.quantity++;
    }

    public void decreaseQuantity() {
        this.quantity--;
    }
}

