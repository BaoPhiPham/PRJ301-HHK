/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Account;
import entity.Category;
import entity.Product;
import java.sql.SQLException;
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
                + "		ON p.CategoryID = c.CategoryID \n";
        // Tạo đối tượng PrepareStatement:
        try {
            statement = connection.prepareStatement(sql);
            //Thực thi câu lệnh:
            resultSet = statement.executeQuery();//trả về cái bảng kết quả như SQL
            while (resultSet.next()) {
                String productID = resultSet.getString("ProductID").trim();
                String productName = resultSet.getString("ProductName").trim();
                String supplierID = resultSet.getString("SupplierID").trim();
                String categoryName = resultSet.getString("CategoryName").trim();
                String categoryID = resultSet.getString("CategoryID").trim();
                int quantityPerUnit = resultSet.getInt("QuantityPerUnit");
                double unitPrice = resultSet.getDouble("UnitPrice");
                String description = resultSet.getString("Description").trim();
                String productImage = resultSet.getString("ProductImage").trim();
                Product p = new Product(productID, productName, supplierID,
                        categoryID, quantityPerUnit, unitPrice,
                        description, categoryName, productImage);
                listFound.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listFound;
    }

    //lấy về danh sách các category của Product:
    public List<Category> getAllCaterogy() {
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
            System.out.println(e.getMessage());
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
                + "  WHERE p.CategoryID = ?";

        try {
            // Tạo đối tượng PrepareStatement:
            statement = connection.prepareStatement(sql);
            // Set parameter ( optional )
            caID = caID.toUpperCase();
            statement.setString(1, caID);
            //Thực thi câu lệnh:
            resultSet = statement.executeQuery();//trả về cái bảng kết quả như SQL
            while (resultSet.next()) {
                String productID = resultSet.getString("ProductID").trim();
                String productName = resultSet.getString("ProductName").trim();
                String supplierID = resultSet.getString("SupplierID").trim();
                String categoryName = resultSet.getString("CategoryName").trim();
                String categoryID = resultSet.getString("CategoryID").trim();
                int quantityPerUnit = resultSet.getInt("QuantityPerUnit");
                double unitPrice = resultSet.getDouble("UnitPrice");
                String description = resultSet.getString("Description").trim();
                String productImage = resultSet.getString("ProductImage").trim();
                Product p = new Product(productID, productName, supplierID,
                        categoryID, quantityPerUnit, unitPrice,
                        description, categoryName, productImage);
                listFound.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
                + "  ORDER BY ProductID desc";
        Product p = null;
        try {
            // Tạo đối tượng PrepareStatement:
            statement = connection.prepareStatement(sql);
            //Thực thi câu lệnh:
            resultSet = statement.executeQuery();//trả về cái bảng kết quả như SQL
            while (resultSet.next()) {
                String productID = resultSet.getString("ProductID").trim();
                String productName = resultSet.getString("ProductName").trim();
                String supplierID = resultSet.getString("SupplierID").trim();
                String categoryName = resultSet.getString("CategoryName").trim();
                String categoryID = resultSet.getString("CategoryID").trim();
                int quantityPerUnit = resultSet.getInt("QuantityPerUnit");
                double unitPrice = resultSet.getDouble("UnitPrice");
                String description = resultSet.getString("Description").trim();
                String productImage = resultSet.getString("ProductImage").trim();
                p = new Product(productID, productName, supplierID,
                        categoryID, quantityPerUnit, unitPrice,
                        description, categoryName, productImage);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return p;
    }

    //lấy về danh sách các Product theo ID:
    public Product getProductById(String id) {
        Product p = null;
        // connect with DB:
        connection = getConnection();
        //chuẩn bị câu lệnh SQL:
        String sql = "  SELECT p.*, c.CategoryName\n"
                + "  FROM [PizzaStoreDB].[dbo].[Products] p \n"
                + "		LEFT JOIN [PizzaStoreDB].[dbo].[Categories] c \n"
                + "		ON p.CategoryID = c.CategoryID \n"
                + "  WHERE p.ProductID = ?";

        try {
            // Tạo đối tượng PrepareStatement:
            statement = connection.prepareStatement(sql);
            // Set parameter ( optional )
            id = id.toUpperCase();
            statement.setString(1, id);
            //Thực thi câu lệnh:
            resultSet = statement.executeQuery();//trả về cái bảng kết quả như SQL
            while (resultSet.next()) {
                String productID = resultSet.getString("ProductID").trim();
                String productName = resultSet.getString("ProductName").trim();
                String supplierID = resultSet.getString("SupplierID").trim();
                String categoryName = resultSet.getString("CategoryName").trim();
                String categoryID = resultSet.getString("CategoryID").trim();
                int quantityPerUnit = resultSet.getInt("QuantityPerUnit");
                double unitPrice = resultSet.getDouble("UnitPrice");
                String description = resultSet.getString("Description").trim();
                String productImage = resultSet.getString("ProductImage").trim();
                p = new Product(productID, productName, supplierID,
                        categoryID, quantityPerUnit, unitPrice,
                        description, categoryName, productImage);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
                + "WHERE p.ProductName LIKE ? ";

        try {
            // Tạo đối tượng PrepareStatement:
            statement = connection.prepareStatement(sql);
            // Set parameter ( optional )
            // Set tham số SQL
            statement.setString(1, "%" + name + "%");
            //Thực thi câu lệnh:
            resultSet = statement.executeQuery();//trả về cái bảng kết quả như SQL
            while (resultSet.next()) {
                String productID = resultSet.getString("ProductID").trim();
                String productName = resultSet.getString("ProductName").trim();
                String supplierID = resultSet.getString("SupplierID").trim();
                String categoryName = resultSet.getString("CategoryName").trim();
                String categoryID = resultSet.getString("CategoryID").trim();
                int quantityPerUnit = resultSet.getInt("QuantityPerUnit");
                double unitPrice = resultSet.getDouble("UnitPrice");
                String description = resultSet.getString("Description").trim();
                String productImage = resultSet.getString("ProductImage").trim();
                Product p = new Product(productID, productName, supplierID,
                        categoryID, quantityPerUnit, unitPrice,
                        description, categoryName, productImage);
                listFound.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
                + "WHERE p.UnitPrice = ?";

        try {
            // Tạo đối tượng PrepareStatement:
            statement = connection.prepareStatement(sql);
            // Set parameter ( optional )
            // Set tham số SQL
            statement.setDouble(1, price);
            //Thực thi câu lệnh:
            resultSet = statement.executeQuery();//trả về cái bảng kết quả như SQL
            while (resultSet.next()) {
                String productID = resultSet.getString("ProductID").trim();
                String productName = resultSet.getString("ProductName").trim();
                String supplierID = resultSet.getString("SupplierID").trim();
                String categoryName = resultSet.getString("CategoryName").trim();
                String categoryID = resultSet.getString("CategoryID").trim();
                int quantityPerUnit = resultSet.getInt("QuantityPerUnit");
                double unitPrice = resultSet.getDouble("UnitPrice");
                String description = resultSet.getString("Description").trim();
                String productImage = resultSet.getString("ProductImage").trim();
                Product p = new Product(productID, productName, supplierID,
                        categoryID, quantityPerUnit, unitPrice,
                        description, categoryName, productImage);
                listFound.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
//        for (Product p : dao.getAllProduct()) {
//            System.out.println(p);
//        }
//        
//        for (Category c : dao.getAllCaterogy()) {
//            System.out.println(c);
//        }

//        for (Product p : dao.getProductByCategory("cat03")) {
//            System.out.println(p);
//        }
//        System.out.println(dao.searchByName("pizza"));
//        System.out.println(dao.searchByPrice(12.99000));
        System.out.println(dao.login("admin", "Admin@123"));

    }
}
