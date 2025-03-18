/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Account;
import entity.CartItem;
import entity.Category;
import entity.Product;
import entity.Supplier;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PhamBaoPhi
 */
public class DAO extends DBContext {

    public DAO() {
    }

    //lấy về danh sách các Product:
    public List<Product> getAllProduct() {
        List<Product> listFound = new ArrayList<>();
        // connect with DB:
        connection = getConnection();
        //chuẩn bị câu lệnh SQL:
        String sql = "  SELECT p.*, c.CategoryName\n"
                + "  FROM [PizzaStoreDB].[dbo].[Products] p \n"
                + "		LEFT JOIN [PizzaStoreDB].[dbo].[Categories] c \n"
                + "		ON p.CategoryID = c.CategoryID \n"
                + "  WHERE p.Sale = 1";
        // Tạo đối tượng PrepareStatement:
        try {
            statement = connection.prepareStatement(sql);
            //Thực thi câu lệnh:
            resultSet = statement.executeQuery();//trả về cái bảng kết quả như SQL
            while (resultSet.next()) {
                int productID = resultSet.getInt("ProductID");
                String productName = resultSet.getString("ProductName").trim();
                String supplierID = resultSet.getString("SupplierID").trim();
                String categoryName = resultSet.getString("CategoryName").trim();
                String categoryID = resultSet.getString("CategoryID").trim();
                int quantityPerUnit = resultSet.getInt("QuantityPerUnit");
                double unitPrice = resultSet.getDouble("UnitPrice");
                String description = resultSet.getString("Description").trim();
                String productImage = resultSet.getString("ProductImage").trim();
                int sale = resultSet.getInt("Sale");
                Product p = new Product(productID, productName, supplierID,
                        categoryID, quantityPerUnit, unitPrice,
                        description, categoryName, productImage);
                listFound.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listFound;
    }

    //lấy về danh sách các category của Product:
    public List<Category> getAllCateries() {
        List<Category> listFound = new ArrayList<>();
        // connect with DB:
        connection = getConnection();
        //chuẩn bị câu lệnh SQL:
        String sql = "SELECT * FROM [dbo].[Categories]";
        // Tạo đối tượng PrepareStatement:
        try {
            statement = connection.prepareStatement(sql);
            //Thực thi câu lệnh:
            resultSet = statement.executeQuery();//trả về cái bảng kết quả như SQL
            while (resultSet.next()) {
                String categoryID = resultSet.getString("CategoryID").trim();
                String categoryName = resultSet.getString("CategoryName").trim();
                String description = resultSet.getString("Description").trim();
                Category c = new Category(categoryID, categoryName, description);
                listFound.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listFound;
    }

    //get all Supllier
    public List<Supplier> getAllSupplier() {
        List<Supplier> listFound = new ArrayList<>();
        // connect with DB:
        connection = getConnection();
        //chuẩn bị câu lệnh SQL:
        String sql = "SELECT * FROM Suppliers";
        // Tạo đối tượng PrepareStatement:
        try {
            statement = connection.prepareStatement(sql);
            //Thực thi câu lệnh:
            resultSet = statement.executeQuery();//trả về cái bảng kết quả như SQL
            while (resultSet.next()) {
                String supplierID = resultSet.getString("SupplierID").trim();
                String companyName = resultSet.getString("CompanyName").trim();
                String address = resultSet.getString("Address").trim();
                String phone = resultSet.getString("Phone").trim();
                Supplier s = new Supplier(supplierID, companyName, address, phone);
                listFound.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listFound;
    }

    //lấy về danh sách các Product theo Category:
    public List<Product> getProductByCategory(String caID) {
        List<Product> listFound = new ArrayList<>();
        // connect with DB:
        connection = getConnection();
        //chuẩn bị câu lệnh SQL:
        String sql = "  SELECT p.*, c.CategoryName\n"
                + "  FROM [PizzaStoreDB].[dbo].[Products] p \n"
                + "		LEFT JOIN [PizzaStoreDB].[dbo].[Categories] c \n"
                + "		ON p.CategoryID = c.CategoryID \n"
                + "  WHERE p.CategoryID = ?  AND p.Sale = 1";

        try {
            // Tạo đối tượng PrepareStatement:
            statement = connection.prepareStatement(sql);
            // Set parameter ( optional )
            caID = caID.toUpperCase();
            statement.setString(1, caID);
            //Thực thi câu lệnh:
            resultSet = statement.executeQuery();//trả về cái bảng kết quả như SQL
            while (resultSet.next()) {
                int productID = resultSet.getInt("ProductID");
                String productName = resultSet.getString("ProductName").trim();
                String supplierID = resultSet.getString("SupplierID").trim();
                String categoryName = resultSet.getString("CategoryName").trim();
                String categoryID = resultSet.getString("CategoryID").trim();
                int quantityPerUnit = resultSet.getInt("QuantityPerUnit");
                double unitPrice = resultSet.getDouble("UnitPrice");
                String description = resultSet.getString("Description").trim();
                String productImage = resultSet.getString("ProductImage").trim();
                int sale = resultSet.getInt("Sale");
                Product p = new Product(productID, productName, supplierID,
                        categoryID, quantityPerUnit, unitPrice,
                        description, categoryName, productImage);
                listFound.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listFound;
    }

    public Product getNewProduct() {
        // connect with DB:
        connection = getConnection();
        //chuẩn bị câu lệnh SQL:
        String sql = "  SELECT top 1 p.*, c.CategoryName\n"
                + "  FROM [PizzaStoreDB].[dbo].[Products] p \n"
                + "		  LEFT JOIN [PizzaStoreDB].[dbo].[Categories] c \n"
                + "		  on p.CategoryID = c.CategoryID \n"
                + "  WHERE p.Sale = 1"
                + "  ORDER BY ProductID desc";
        Product p = null;
        try {
            // Tạo đối tượng PrepareStatement:
            statement = connection.prepareStatement(sql);
            //Thực thi câu lệnh:
            resultSet = statement.executeQuery();//trả về cái bảng kết quả như SQL
            while (resultSet.next()) {
                int productID = resultSet.getInt("ProductID");
                String productName = resultSet.getString("ProductName").trim();
                String supplierID = resultSet.getString("SupplierID").trim();
                String categoryName = resultSet.getString("CategoryName").trim();
                String categoryID = resultSet.getString("CategoryID").trim();
                int quantityPerUnit = resultSet.getInt("QuantityPerUnit");
                double unitPrice = resultSet.getDouble("UnitPrice");
                String description = resultSet.getString("Description").trim();
                String productImage = resultSet.getString("ProductImage").trim();
                int sale = resultSet.getInt("Sale");
                p = new Product(productID, productName, supplierID,
                        categoryID, quantityPerUnit, unitPrice,
                        description, categoryName, productImage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    //lấy về Product theo ID:
    public Product getProductById(int id) {
        Product p = null;
        // connect with DB:
        connection = getConnection();
        //chuẩn bị câu lệnh SQL:
        String sql = "  SELECT p.*, c.CategoryName\n"
                + "  FROM [PizzaStoreDB].[dbo].[Products] p \n"
                + "		LEFT JOIN [PizzaStoreDB].[dbo].[Categories] c \n"
                + "		ON p.CategoryID = c.CategoryID \n"
                + "  WHERE p.ProductID = ? AND p.Sale = 1";

        try {
            // Tạo đối tượng PrepareStatement:
            statement = connection.prepareStatement(sql);
            // Set parameter ( optional )
            statement.setObject(1, id);
            //Thực thi câu lệnh:
            resultSet = statement.executeQuery();//trả về cái bảng kết quả như SQL
            while (resultSet.next()) {
                int productID = resultSet.getInt("ProductID");
                String productName = resultSet.getString("ProductName").trim();
                String supplierID = resultSet.getString("SupplierID").trim();
                String categoryName = resultSet.getString("CategoryName").trim();
                String categoryID = resultSet.getString("CategoryID").trim();
                int quantityPerUnit = resultSet.getInt("QuantityPerUnit");
                double unitPrice = resultSet.getDouble("UnitPrice");
                String description = resultSet.getString("Description").trim();
                String productImage = resultSet.getString("ProductImage").trim();
                int sale = resultSet.getInt("Sale");
                p = new Product(productID, productName, supplierID,
                        categoryID, quantityPerUnit, unitPrice,
                        description, categoryName, productImage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    //Search product by name:
    public List<Product> searchByName(String name) {
        List<Product> listFound = new ArrayList<>();
        // connect with DB:
        connection = getConnection();
        // Xây dựng SQL động
        String sql = "SELECT p.*, c.CategoryName "
                + "FROM [PizzaStoreDB].[dbo].[Products] p "
                + "LEFT JOIN [PizzaStoreDB].[dbo].[Categories] c "
                + "ON p.CategoryID = c.CategoryID "
                + "WHERE p.ProductName LIKE ?  AND p.Sale = 1";

        try {
            // Tạo đối tượng PrepareStatement:
            statement = connection.prepareStatement(sql);
            // Set parameter ( optional )
            // Set tham số SQL
            statement.setString(1, "%" + name + "%");
            //Thực thi câu lệnh:
            resultSet = statement.executeQuery();//trả về cái bảng kết quả như SQL
            while (resultSet.next()) {
                int productID = resultSet.getInt("ProductID");
                String productName = resultSet.getString("ProductName").trim();
                String supplierID = resultSet.getString("SupplierID").trim();
                String categoryName = resultSet.getString("CategoryName").trim();
                String categoryID = resultSet.getString("CategoryID").trim();
                int quantityPerUnit = resultSet.getInt("QuantityPerUnit");
                double unitPrice = resultSet.getDouble("UnitPrice");
                String description = resultSet.getString("Description").trim();
                String productImage = resultSet.getString("ProductImage").trim();
                int sale = resultSet.getInt("Sale");
                Product p = new Product(productID, productName, supplierID,
                        categoryID, quantityPerUnit, unitPrice,
                        description, categoryName, productImage);
                listFound.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listFound;
    }

    //Search product by price:
    public List<Product> searchByPrice(Double price) {
        List<Product> listFound = new ArrayList<>();
        // connect with DB:
        connection = getConnection();
        // Xây dựng SQL động
        String sql = "SELECT p.*, c.CategoryName "
                + "FROM [PizzaStoreDB].[dbo].[Products] p "
                + "LEFT JOIN [PizzaStoreDB].[dbo].[Categories] c "
                + "ON p.CategoryID = c.CategoryID "
                + "WHERE p.UnitPrice = ?  AND p.Sale = 1";

        try {
            // Tạo đối tượng PrepareStatement:
            statement = connection.prepareStatement(sql);
            // Set parameter ( optional )
            // Set tham số SQL
            statement.setDouble(1, price);
            //Thực thi câu lệnh:
            resultSet = statement.executeQuery();//trả về cái bảng kết quả như SQL
            while (resultSet.next()) {
                int productID = resultSet.getInt("ProductID");
                String productName = resultSet.getString("ProductName").trim();
                String supplierID = resultSet.getString("SupplierID").trim();
                String categoryName = resultSet.getString("CategoryName").trim();
                String categoryID = resultSet.getString("CategoryID").trim();
                int quantityPerUnit = resultSet.getInt("QuantityPerUnit");
                double unitPrice = resultSet.getDouble("UnitPrice");
                String description = resultSet.getString("Description").trim();
                String productImage = resultSet.getString("ProductImage").trim();
                int sale = resultSet.getInt("Sale");
                Product p = new Product(productID, productName, supplierID,
                        categoryID, quantityPerUnit, unitPrice,
                        description, categoryName, productImage);
                listFound.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listFound;
    }

    public Account login(String username, String password) {
        // connect with DB:
        connection = getConnection();
        // Xây dựng SQL động
        String sql = " SELECT * FROM Account WHERE UserName = ? AND Password = ?";
        try {
            // Tạo đối tượng PrepareStatement:
            statement = connection.prepareStatement(sql);
            // Set parameter ( optional )
            // Set tham số SQL
            statement.setString(1, username);
            statement.setString(2, password);
            //Thực thi câu lệnh:
            resultSet = statement.executeQuery();
            // trả về kết quả:lặp qua từng dòng 1 để trích account
            while (resultSet.next()) {
                int accountID = resultSet.getInt("AccountID");
                String userName = resultSet.getString("UserName").trim();
                String pass = resultSet.getString("Password").trim();
                String fullName = resultSet.getString("FullName").trim();
                int type = resultSet.getInt("Type");
                Account ac = new Account(accountID, userName, pass, fullName, type);
                return ac;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public Account checkAccountExist(String username) {
        // connect with DB:
        connection = getConnection();
        // Xây dựng SQL động
        String sql = " SELECT * FROM Account WHERE UserName = ?";
        try {
            // Tạo đối tượng PrepareStatement:
            statement = connection.prepareStatement(sql);
            // Set parameter ( optional )
            // Set tham số SQL
            statement.setString(1, username);
            //Thực thi câu lệnh:
            resultSet = statement.executeQuery();
            // trả về kết quả:lặp qua từng dòng 1 để trích account
            while (resultSet.next()) {
                int accountID = resultSet.getInt("AccountID");
                String userName = resultSet.getString("UserName").trim();
                String pass = resultSet.getString("Password").trim();
                String fullName = resultSet.getString("FullName").trim();
                int type = resultSet.getInt("Type");
                Account ac = new Account(accountID, userName, pass, fullName, type);
                return ac;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void signUp(String username, String password, String fullName) {
        // connect with DB:
        connection = getConnection();
        // Xây dựng SQL
        String sql = "INSERT INTO Account(UserName, Password, FullName) VALUES\n"
                + "(?, ?, ?)";
        try {
            // Tạo đối tượng PrepareStatement:
            statement = connection.prepareStatement(sql);
            // Set parameter ( optional )
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, fullName);
            //Thực thi câu lệnh:
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //hàm xóa sản phẩm:
    public void deleteProductByID(int id) {
        // connect with DB:
        connection = getConnection();
        // Xây dựng SQL
        String sql = "UPDATE [dbo].[Products]\n"
                + "   SET [Sale] = 0\n"
                + " WHERE ProductID = ?";
        try {
            // Tạo đối tượng PrepareStatement:
            statement = connection.prepareStatement(sql);
            // Set parameter ( optional )
            statement.setObject(1, id);
            //Thực thi câu lệnh:
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //hàm thêm sản phẩm:
    public void addNewProduct(Product p) {
        // connect with DB:
        connection = getConnection();
        // Xây dựng SQL
        String sql = "INSERT INTO Products (ProductName, SupplierID, CategoryID, "
                + "QuantityPerUnit, UnitPrice, Description, ProductImage) VALUES\n"
                + "(?, ?, ?, ?, ?, ?, ?)";
        try {
            // Tạo đối tượng PrepareStatement:
            statement = connection.prepareStatement(sql);
            // Set parameter ( optional )
            statement.setObject(1, p.getproductName());
            statement.setObject(2, p.getsupplierID());
            statement.setObject(3, p.getcategoryID());
            statement.setObject(4, p.getquantityPerUnit());
            statement.setObject(5, p.getunitPrice());
            statement.setObject(6, p.getDescription());
            statement.setObject(7, p.getproductImage());
            //Thực thi câu lệnh:
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //hàm thêm sản phẩm:
    public void updateProduct(Product p) {
        // connect with DB:
        connection = getConnection();
        // Xây dựng SQL
        String sql = "UPDATE [dbo].[Products]\n"
                + "   SET [ProductName] = ?\n"
                + "      ,[SupplierID] = ?\n"
                + "      ,[CategoryID] = ?\n"
                + "      ,[QuantityPerUnit] = ?\n"
                + "      ,[UnitPrice] = ?\n"
                + "      ,[Description] = ?\n"
                + "      ,[ProductImage] = ?\n"
                + " WHERE ProductID = ?";
        try {
            // Tạo đối tượng PrepareStatement:
            statement = connection.prepareStatement(sql);
            // Set parameter ( optional )
            statement.setObject(1, p.getproductName());
            statement.setObject(2, p.getsupplierID());
            statement.setObject(3, p.getcategoryID());
            statement.setObject(4, p.getquantityPerUnit());
            statement.setObject(5, p.getunitPrice());
            statement.setObject(6, p.getDescription());
            statement.setObject(7, p.getproductImage());
            statement.setObject(8, p.getproductID());
            //Thực thi câu lệnh:
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //getAllProductInCartByID
    public List<CartItem> getAllProductInCartByID(int id) {
        List<CartItem> listFound = new ArrayList<>();
        // connect with DB:
        connection = getConnection();
        //chuẩn bị câu lệnh SQL:
        String sql = "SELECT ca.*, p.ProductName, p.ProductImage, p.UnitPrice \n"
                + "FROM Cart ca LEFT JOIN Products p\n"
                + "	on ca.ProductID = p.ProductID\n"
                + "WHERE ca.AccountID = ?";
        // Tạo đối tượng PrepareStatement:
        try {
            statement = connection.prepareStatement(sql);
            // Set parameter ( optional )
            statement.setObject(1, id);
            //Thực thi câu lệnh:
            resultSet = statement.executeQuery();//trả về cái bảng kết quả như SQL
            while (resultSet.next()) {
                int idCart = resultSet.getInt("CartID");
                int accountId = resultSet.getInt("AccountID");
                int productId = resultSet.getInt("ProductID");
                int quantity = resultSet.getInt("Quantity");
                String productName = resultSet.getString("ProductName");
                String productImage = resultSet.getString("ProductImage");
                double priceOnOne = resultSet.getDouble("UnitPrice");
                double total = quantity * priceOnOne;
                Timestamp timestamp = resultSet.getTimestamp("AddedDate");
                LocalDateTime addedDate = timestamp.toLocalDateTime(); // Chuyển về LocalDateTime
                CartItem item = new CartItem(idCart, accountId, productId,
                        quantity, productName, productImage, total, addedDate);
                listFound.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listFound;
    }

    //remove item cart:
    public void removeCartItem(int id) {
        // connect with DB:
        connection = getConnection();
        // Xây dựng SQL
        String sql = "DELETE FROM [dbo].[Cart]\n"
                + "      WHERE CartID = ?";
        try {
            // Tạo đối tượng PrepareStatement:
            statement = connection.prepareStatement(sql);
            // Set parameter ( optional )
            statement.setObject(1, id);
            //Thực thi câu lệnh:
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //decreaseProduct in cart:
    public void decreaseProductInCart(int id) {
        // connect with DB:
        connection = getConnection();
        // Xây dựng SQL
        String sql = "UPDATE [dbo].[Cart]\n"
                + "   SET [Quantity] = [Quantity] - 1\n"
                + " WHERE CartID = ?";
        try {
            // Tạo đối tượng PrepareStatement:
            statement = connection.prepareStatement(sql);
            // Set parameter ( optional )
            statement.setObject(1, id);
            //Thực thi câu lệnh:
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //increase Product in cart:
    public void increaseProductInCart(int id) {
        // connect with DB:
        connection = getConnection();
        // Xây dựng SQL
        String sql = "UPDATE [dbo].[Cart]\n"
                + "   SET [Quantity] = [Quantity] + 1\n"
                + " WHERE CartID = ?";
        try {
            // Tạo đối tượng PrepareStatement:
            statement = connection.prepareStatement(sql);
            // Set parameter ( optional )
            statement.setObject(1, id);
            //Thực thi câu lệnh:
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //add Product in cart:
    public void addItemToCart(int idAccount, int productID, int quantity) {
        // connect with DB:
        connection = getConnection();
        // Xây dựng SQL
        String sql = "INSERT INTO [dbo].[Cart]\n"
                + "           ([AccountID]\n"
                + "           ,[ProductID]\n"
                + "           ,[Quantity])\n"
                + "     VALUES(?, ?, ?)";
        try {
            // Tạo đối tượng PrepareStatement:
            statement = connection.prepareStatement(sql);
            // Set parameter ( optional )
            statement.setObject(1, idAccount);
            statement.setObject(2, productID);
            statement.setObject(3, quantity);
            //Thực thi câu lệnh:
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
//        for (Product p : dao.getAllProduct()) {
//            System.out.println(p);
//        }

//        for (Category c : dao.getAllCateries()) {
//            System.out.println(c);
//        }
//        for (Product p : dao.getProductByCategory("cat03")) {
//            System.out.println(p);
//        }
//        System.out.println(dao.searchByName("pizza"));
//        System.out.println(dao.searchByPrice(12.99000));
//        System.out.println(dao.login("admin", "Admin@123"));
//        dao.deleteProductByID(6);
//        for (Supplier s : dao.getAllSupplier()) {
//            System.out.println(s);
//        }
//        for (CartItem c : dao.getAllProductInCartByID(2)) {
//            System.out.println(c);
//        }
//        dao.signUp("abc", "123", "a");
//dao.removeCartItem(4);
//dao.decreaseProductInCart(2);
//dao.addItemToCart(1,2,4);
    }
}
