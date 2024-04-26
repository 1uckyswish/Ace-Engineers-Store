package com.pluralsight;
/*

The CartItem class models an item within a shopping cart,
associating a Product with a specific quantity.
This encapsulation is achieved by making the
Product and quantity attributes private.

Each CartItem instance is initialized
with a Product object and a corresponding quantity.

The class includes methods to increment
and decrement the quantity of the cart item.

The getTotalPrice() method calculates
the total price of the cart item by multiplying
the price of the associated product with its quantity.

 */

public class CartItem {
   private Product product;
   private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //methods
    public void incrementQuantity() {
        quantity++;
    }

    public void decrementQuantity() {
        quantity--;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return String.format("Product: %s | Quantity: %d", product.toString(), quantity);
    }
}
