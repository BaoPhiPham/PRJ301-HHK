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
        <title>Cart</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    </head>

    <body>
        <jsp:include page="Menu.jsp"></jsp:include>

            <div class="shopping-cart">
                <div class="container py-5">
                    <div class="row">
                        <div class="col-lg-12 p-5 bg-white rounded shadow-sm">

                            <!-- Bảng giỏ hàng -->
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th class="border-0 bg-light">Product</th>
                                            <th class="border-0 bg-light">Price</th>
                                            <th class="border-0 bg-light">Quantity</th>
                                            <th class="border-0 bg-light">Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="item" items="${cart}">
                                        <tr>
                                            <td>
                                                <div class="p-2">
                                                    <img src="${item.productImage}" alt="" width="70" class="img-fluid rounded shadow-sm">
                                                    <div class="ml-3 d-inline-block align-middle">
                                                        <h5 class="mb-0"><a href="#" class="text-dark">${item.productName}</a></h5>
                                                    </div>
                                                </div>
                                            </td>
                                            <td class="align-middle"><strong>${item.unitPrice} $</strong></td>
                                            <td class="align-middle">
                                                <form action="updateCart" method="post" class="d-inline">
                                                    <input type="hidden" name="productID" value="${item.productID}">
                                                    <button type="submit" name="action" value="decrease" class="btn btn-sm btn-outline-secondary">-</button>
                                                </form>
                                                <strong>${item.quantity}</strong>
                                                <form action="updateCart" method="post" class="d-inline">
                                                    <input type="hidden" name="productID" value="${item.productID}">
                                                    <button type="submit" name="action" value="increase" class="btn btn-sm btn-outline-secondary">+</button>
                                                </form>
                                            </td>
                                            <td class="align-middle">
                                                <form action="removeFromCart" method="post">
                                                    <input type="hidden" name="productID" value="${item.productID}">
                                                    <button type="submit" class="btn btn-danger">Delete</button>
                                                </form>
                                            </td>
                                        </tr> 
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <!-- Hiển thị tổng tiền -->
                <div class="row py-5 p-4 bg-white rounded shadow-sm">
                    <div class="col-lg-6">
                        <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Bill</div>
                        <div class="p-4">
                            <ul class="list-unstyled mb-4">
                                <li class="d-flex justify-content-between py-3 border-bottom">
                                    <strong class="text-muted">Total money</strong>
                                    <strong>${sessionScope.cartTotal} $</strong>
                                </li>
                                <li class="d-flex justify-content-between py-3 border-bottom">
                                    <strong class="text-muted">Total: </strong>
                                    <h5 class="font-weight-bold">${sessionScope.cartTotal} VND</h5>
                                </li>
                            </ul>
                            <a href="buy" class="btn btn-dark rounded-pill py-2 btn-block">Purchase</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

    </body>
</html>
