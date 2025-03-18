SELECT *
  FROM [PizzaStoreDB].[dbo].[Products]
  WHERE CategoryID = 'CAT03'

  SELECT p.*, c.CategoryName
  FROM [PizzaStoreDB].[dbo].[Products] p 
		LEFT JOIN [PizzaStoreDB].[dbo].[Categories] c 
		on p.CategoryID = c.CategoryID 
--  WHERE p.CategoryID = 'CAT03'

  SELECT top 1 p.*, c.CategoryName
  FROM [PizzaStoreDB].[dbo].[Products] p 
		  LEFT JOIN [PizzaStoreDB].[dbo].[Categories] c 
		  on p.CategoryID = c.CategoryID 
  ORDER BY ProductID desc

    SELECT p.*, c.CategoryName
  FROM [PizzaStoreDB].[dbo].[Products] p 
		LEFT JOIN [PizzaStoreDB].[dbo].[Categories] c 
		on p.CategoryID = c.CategoryID 
 WHERE p.ProductName = '%%'

     SELECT p.*, c.CategoryName
  FROM [PizzaStoreDB].[dbo].[Products] p 
		LEFT JOIN [PizzaStoreDB].[dbo].[Categories] c 
		on p.CategoryID = c.CategoryID 
 WHERE p.UnitPrice = ?

 SELECT * FROM Account WHERE UserName = ? AND Password = ?

 SELECT p.*, c.CategoryName 
                   FROM [PizzaStoreDB].[dbo].[Products] p 
                   LEFT JOIN [PizzaStoreDB].[dbo].[Categories] c 
                   ON p.CategoryID = c.CategoryID 
                   WHERE 1=1

SELECT * FROM Account
SELECT * FROM Products
SELECT * FROM Cart


INSERT INTO Account (UserName, Password, FullName) VALUES
('admin4', 'Admin@123', 'Pizza Store Admin')

USE [PizzaStoreDB]
GO

UPDATE [dbo].[Products]
   SET [Sale] = 0
 WHERE ProductID = 1

 USE [PizzaStoreDB]
GO

SELECT * FROM Categories
SELECT * FROM Suppliers
SELECT * FROM Products
UPDATE [dbo].[Products]
   SET [ProductName] = ''
      ,[UnitPrice] = 0
      ,[Description] = ''
      ,[ProductImage] = ''
 WHERE ProductID = 3
GO

SELECT * FROM Products
SELECT * FROM Account
SELECT * FROM Cart
SELECT ca.*, p.ProductName, p.ProductImage, p.UnitPrice 
FROM Cart ca LEFT JOIN Products p
	on ca.ProductID = p.ProductID
WHERE ca.AccountID = 2

USE [PizzaStoreDB]
GO

UPDATE [dbo].[Cart]
   SET [Quantity] = [Quantity] + 1
 WHERE CartID = 1


DELETE FROM [dbo].[Cart]
      WHERE CartID = ?
GO
USE [PizzaStoreDB]
GO

INSERT INTO [dbo].[Cart]
           ([AccountID]
           ,[ProductID]
           ,[Quantity])
     VALUES(?, ?, ?)
GO





