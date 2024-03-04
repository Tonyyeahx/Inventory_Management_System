public interface InventoryInterface { // Should add quantity go in here?
                                      // Should public be here?
    public int getInventoryID();

    public int getStoreID();

    public int getProductID();

    public float getSellPrice();

    public int getQuantity();

    public float getDiscount();

    public String getLastOrderDate();

    public int getOrderQuantity();

    public boolean isValidDate(String date);

    public void setDiscount(float Discount);
}