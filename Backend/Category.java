public class Category implements CategoryInterface {
    private int CategoryID;
    private String CategoryName;

    public Category(int id, String name) {
        CategoryID = id;
        CategoryName = name;
    }

    public int getID() {
        return CategoryID;
    }

    public String getName() {
        return CategoryName;
    }

}