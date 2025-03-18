<%-- 
    Document   : left
    Created on : Mar 17, 2025, 10:31:54 PM
    Author     : PhamBaoPhi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<aside>
    <div class="category-container">
        <button class="category-btn"><i class="fas fa-bars"></i> CATEGORIES</button>
        <div class="category-dropdown">
            <ul>
                <c:forEach items="${requestScope.listCategory}" var="c">
                    <li>
                        <a href="category?cid=${c.getCategoryID()}">${c.getCategoryName()}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="latest-product">
        <h3>LATEST PRODUCT</h3>
        <c:if test="${not empty newPro}">
            <img src="${newPro.getproductImage()}" alt="${newPro.getproductName()}">
            <h3>
                <a href="detail?pid=${newPro.getproductID()}" title="View Product">
                    ${newPro.getproductName()} 
                </a>
            </h3><br>
            <p><strong>Category:</strong> ${newPro.getCategoryName()}</p><br>
            <button class="add-btn">Add Pizza</button><br>
        </c:if>

        <p>Try our latest product.<br>Especially delicious.</p>
        <strong><span>$${newPro.getunitPrice()}</span></strong>
    </div>
</aside>
