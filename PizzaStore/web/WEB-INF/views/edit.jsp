<%-- 
    Document   : home
    Created on : Mar 17, 2025, 12:38:09 PM
    Author     : PhamBaoPhi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit page</title>
        <link href="${pageContext.request.contextPath}/assets/css/style-edit.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="container">
            <h2>Edit Page</h2>
            <form action="${pageContext.request.contextPath}/manager?action=edit" method="post">
                <div class="form-group"  style="display: none">
                    <label>ID</label>
                    <input name="productId" type="number" value="${pDetail.getproductID()}" readonly>
                </div>
                <div class="form-group">
                    <label>Name</label>
                    <input  name="name" type="text" value="${pDetail.getproductName()}" >
                </div>
                <div class="form-group">
                    <label>Supplier</label>
                    <select name="supplierId" required>
                        <c:forEach items="${requestScope.listSupplier}" var="s">
                            <option value="${s.getSupplierID()}">${s.getCompanyName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>Category</label>
                    <select name="categoryId" required>
                        <c:forEach items="${requestScope.listCategory}" var="c">
                            <option value="${c.getCategoryID()}">${c.getCategoryName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>Quantity</label>
                    <input  name="quantity" type="number" value="${pDetail.getquantityPerUnit()}">
                </div>
                <div class="form-group">
                    <label>Price</label>
                    <input name="price" type="number" value="${pDetail.getunitPrice()}">
                </div>
                <div class="form-group">
                    <label>Image URL</label>
                    <input name="image" type="text" value="${pDetail.getproductImage()}">
                </div>
                <div class="form-group">
                    <label>Description</label>
                    <input name="description" type="text" value="${pDetail.getDescription()}">
                </div>
                <button type="submit" class="btn btn-save">Save</button>
                <button type="button" class="btn btn-cancel" onclick="window.history.back()">Cancel</button>
            </form>
        </div>
    </body>
</html>
