<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Chọn Khách Hàng</title>
    </head>
    <style>
        header{  /* width 100% so với wrapper (wrapper là thẻ cha) */
            height: 70px;
            width: 80%;
            background-color:#56ccf2; /* màu nền */
            text-align: center;
            margin: auto; /* căn giữa */
            margin-bottom: 10px; /*khoảng cách với phần tử sau 10 px */
        }
        .container{
            height: 500px;
            width: 80%;
            background-color: #f2f2f2;
            margin: auto;
            text-align: center;

        }
        h2{
            display: inline-block;
        }
        .search{
            float: left;
            width: 30%;
            

        }
        .result{
            float: right;
            width: 70%;

        }
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        } 
        th, td {
            padding: 15px;
        } 
        th {
            text-align: left;
        } 

    </style>
    <body>
        <div>
            <header>
                <h2>Hệ thống Quản lí Gara ô tô</h2>
            </header>

            <div class="container">
                <h2>Chọn Khách hàng</h2>
                <br>

                <div class="search">
                    <form action="" class="form" method="POST">
                        <div class="form-group">
                            <input type="text" name="keyword" id="inputUser" required autocomplete="off" value="Nhập tên khách hàng">
                        </div>
                        <br>
                        <input type="hidden" value="searchCustomer" name="action">
                        <input type="submit" value="Tìm kiếm">    
                    </form>
                </div>

                <div class="result">

                    <table >
                        <tr>
                            <th>Mã</th>
                            <th>Họ Tên</th>
                            <th>Địa chỉ</th>
                            <th>Email</th>
                            <th>SDT</th>
                            <th>Thao Tác</th>
                        </tr>
                        <c:forEach var="customer" items="${listCustomer}">
                            <tr>
                                <td>${customer.id}</td>
                                <td>${customer.name}</td>
                                <td>${customer.address}</td>
                                <td>${customer.email}</td>
                                <td>${customer.phone}</td>
                                <td>
                                    <a href="chon-khach-hang?id=<c:out value='${customer.id}'/>">
                                        Chọn
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <span style="float: left;color: red;text-align: center">${requestScope.message}</span>
                </div>
                
                <a style="position: fixed;left: 200px;bottom: 50px;" href="/khach-hang/them-moi"><button>Thêm mới khách hàng</button></a>
            </div>
        </div>
    </body>
</html>