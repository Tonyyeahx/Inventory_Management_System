public class Inventory implements InventoryInterface {
    private int InventoryID;
    private int StoreID;
    private int ProductID;
    private float SellPrice;
    private int Quantity;
    private float Discount = 1.0;
    private String LastOrderDate;
    private int OrderQuantity;

    public Inventory(int InventoryID, int StoreID, int ProductID, float SellPrice, int Quantity,
            String LastOrderDate, int OrderQuantity) {
        this.InventoryID = id;
        this.StoreID = StoreID;
        this.ProductID = ProductID;
        this.SellPrice = SellPrice;
        this.Quantity = Quantity;
        if (isValidDate(LastOrderDate)) {
            this.LastOrderDate = LastOrderDate;
        } else {
            System.out.println("Please enter valid date in the form: \"month-day-year\"");
        }
        this.LastOrderDate = LastOrderDate;
        this.OrderQuantity = OrderQuantity;
    }

    // Getter methods
    public int getInventoryID() {
        return InventoryID;
    }

    public int getStoreID() {
        return StoreID;
    }

    public int getProductID() {
        return ProductID;
    }

    public float getSellPrice() {
        return SellPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public float getDiscount() {
        return Discount;
    }

    public String getLastOrderDate() {
        return LastOrderDate;
    }

    public int getOrderQuantity() {
        return OrderQuantity;
    }

    public boolean isValidDate(String date) {
        try {
            if (LastOrderDate.length() == 10) { // Formatted as 01/10/2024
                String[] parts = LastOrderDate.split("-");
                int month = (int) parts[0];
                int day = (int) parts[1];
                int year = (int) parts[2];
                if (LastOrderDate.length() == 10) { // Formatted as 01/10/2024
                    if (month > 12 || month < 0) {
                        return false;
                    }
                    if (day < 0 | day > 31) {
                        return false;
                    }
                    if (year < 1000 || year > 10000) {
                        return false;
                    }
                    return true;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public void setDiscount(float Discount) {
        this.Discount = Discount;
    }

}