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
        <title>Home Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link href="${pageContext.request.contextPath}/assets/css/style-home.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>

            <main>
            <jsp:include page="left.jsp"></jsp:include>

                <section class="product-list">
                    <h2>Pizza Menu</h2>
                    <div class="products">
                    <c:forEach items="${requestScope.listProduct}" var="p">
                        <div class="product-card">
                            <img src="${p.getproductImage()}" alt="${p.getproductName()}">
                            <h3>
                                <a href="detail?pid=${p.getproductID()}" title="View Product">${p.getproductName()} </a>
                                <span>$${p.getunitPrice()}</span>
                            </h3>
                            <p><strong>Category:</strong> ${p.getCategoryName()}</p>
                            <button class="add-btn">Add Pizza</button>
                        </div>
                    </c:forEach>
                </div>
            </section>
        </main>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>

