
package DAO;

import Context.DBconnection;
import Entity.Account;

import Entity.Category;
import Entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author My ASUS
 */
public class DAO {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conn = null;
    
    public List<Product> getAllProduct(){
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM Products";
        try {
            conn = new DBconnection().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    
    public List<Category> getAllCategory(){
        List<Category> list = new ArrayList<>();
        String query = "SELECT * FROM Categories";
        try {
            conn = new DBconnection().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Product getLastest() {
        String query = "SELECT TOP 1 * FROM Products\n"
                + "ORDER BY ProductID DESC";
        try {
            conn = new DBconnection().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Product> getProductByCategoryID(String categoryID){
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM Products\n"
                +"WHERE categoryID= ?";
        try {
            conn = new DBconnection().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, categoryID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Product getProductByID(String id){
        
        String query = "SELECT * FROM Products\n"
                +"WHERE ProductID= ?";
        try {
            conn = new DBconnection().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public List<Product> search(String txtSearch){
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM Products\n"
                +"WHERE ProductName LIKE ?";
        try {
            conn = new DBconnection().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,"%"+ txtSearch+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Account login(String user, String pass) {
        String query = "SELECT * FROM Account\n"
                + "WHERE UserName = ? and Password =?";
        try {
            conn = new DBconnection().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Account checkAccountExist(String user,String fullname) {
        String query = "SELECT * FROM Account\n"
                + "WHERE UserName = ? OR FullName = ?";
        try {
            conn = new DBconnection().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, fullname);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void signup(String user,String pass,String fullname){
        String query = "INSERT INTO Account(AccountID, UserName, Password, FullName, Type)\n"
                +"VALUES((SELECT COALESCE(MAX(AccountID), 0) + 1 FROM Account), ?, ?, ?, 2)";
        try {
            conn = new DBconnection().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, fullname);
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    public void deleteProduct(String productID){
        String query = "DELETE FROM Products\n"
                +"Where ProductID = ?";
        try {
            conn = new DBconnection().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, productID );
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public boolean addProduct(int id, String name, int supplierId, int categoryId,
             int quantity, int price, String image) {
        String query = "INSERT INTO Products (ProductID, ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, ProductImage)\n"
                + "VALUES(?,?,?,?,?,?,?)";
        
        try {
            conn = new DBconnection().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, supplierId);
            ps.setInt(4, categoryId);
            ps.setInt(5, quantity);
            ps.setInt(6, price);
            ps.setString(7, image);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
     
     
     public boolean editProduct(String name, int supplierId, int categoryId,
            int quantity, int price, String image, int id) {
        String query = "UPDATE Products\n"
                + "SET ProductName = ?,\n"
                + "    SupplierID = ?,\n"
                + "    CategoryID = ?,\n"
                + "    QuantityPerUnit = ?,\n"
                + "    UnitPrice = ?,\n"
                + "    ProductImage = ?\n"
                + "WHERE ProductID = ?";
        
        try {
            conn = new DBconnection().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, supplierId);
            ps.setInt(3, categoryId);
            ps.setInt(4, quantity);
            ps.setInt(5, price);
            ps.setString(6, image);
            ps.setInt(7, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
