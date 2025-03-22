
package Entity;


public class Category {
    private int categoryID;
    private String categoryName;
    private String Description;

    public Category() {
    }

    public Category(int categoryID, String categoryName, String Description) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.Description = Description;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return "Category{" + "categoryID=" + categoryID + ", categoryName=" + categoryName + ", Description=" + Description + '}';
    }
    
}
