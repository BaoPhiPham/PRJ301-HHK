<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
        <link href="css/manager.css" rel="stylesheet" type="text/css">
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 20px;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
            .container {
                background: white;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
                width: 400px;
            }
            h2 {
                text-align: center;
                margin-bottom: 20px;
            }
            .form-group {
                margin-bottom: 15px;
            }
            .form-group label {
                display: block;
                font-weight: bold;
            }
            .form-group input {
                width: 100%;
                padding: 8px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }
            .btn {
                width: 100%;
                padding: 10px;
                border: none;
                border-radius: 4px;
                background: #28a745;
                color: white;
                cursor: pointer;
                font-size: 16px;
            }
            .btn:hover {
                background: #218838;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Add Product</h2>
            <form action="add" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label>ID</label>
                    <input name="id" type="number" required>
                </div>
                <div class="form-group">
                    <label>Name</label>
                    <input name="name" type="text" required>
                </div>
                <div class="form-group">
                    <label>SupplierID</label>
                    <input name="supplierId" type="number" required>
                </div>
                <div class="form-group">
                    <label>CategoryID</label>
                    <input name="categoryId" type="number" required>
                </div>
                <div class="form-group">
                    <label>Quantity</label>
                    <input name="quantity" type="number" required>
                </div>
                <div class="form-group">
                    <label>Price</label>
                    <input name="price" type="text" required>
                </div>
                <div class="form-group">
                    <label>Image URL</label>
                    <input name="image" type="file" required>
                </div>
                <button type="submit" class="btn">Add</button>
                <button type="button" class="btn" onclick="window.history.back()"
                        style="background-color: red;margin-top: 20px">Cancel</button>
            </form>
        </div>
    </body>
</html>
