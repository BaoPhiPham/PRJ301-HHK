<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Employee</title>
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
            .form-group input, .form-group textarea {
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
                cursor: pointer;
                font-size: 16px;
            }
            .btn-save {
                background: #28a745;
                color: white;
            }
            .btn-save:hover {
                background: #218838;
            }
            .btn-cancel {
                background: red;
                color: white;
                margin-top: 10px;
            }
            .btn-cancel:hover {
                background: darkred;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Edit Employee</h2>
            <form action="edit" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label>ID</label>
                    <input name="id" type="number" value="${detail.productID}" readonly>
                </div>
                <div class="form-group">
                    <label>Name</label>
                    <input  name="name" type="text" value="${detail.productName}" >
                </div>
                <div class="form-group">
                    <label>SupplierID</label>
                    <input  name="supplierId" type="number" value="${detail.supplierID}" >
                </div>
                <div class="form-group">
                    <label>CategoryID</label>
                    <input  name="categoryId" type="number" value="${detail.categoryID}">
                </div>
                <div class="form-group">
                    <label>Quantity</label>
                    <input  name="quantity" type="number" value="${detail.quantityPerUnit}">
                </div>
                <div class="form-group">
                    <label>Price</label>
                    <input name="price" type="text" value="${detail.unitPrice}">
                </div>
                
                
                <div class="form-group">
                    <label>Image URL</label>
                    <input name="image" type="file" value="${detail.productImage}">
                </div>
                <button type="submit" class="btn btn-save">Save</button>
                <button type="button" class="btn btn-cancel" onclick="window.history.back()">Cancel</button>
            </form>
        </div>
    </body>
</html>
