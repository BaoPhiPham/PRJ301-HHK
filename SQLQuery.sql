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