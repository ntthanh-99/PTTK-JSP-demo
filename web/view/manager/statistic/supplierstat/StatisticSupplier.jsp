<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Chọn Nhân viên kĩ thuật</title>
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
                <h2>Danh sách nhà cung cấp</h2>
                <br>
                <table align="center">
                        <tr>
                            <th>ID</th>
                            <th>Tên</th>
                            <th>Mô tả</th>
                            <th>Địa chỉ</th>
                            <th>SDT</th>
                            <th>SL đã nhập</th>
                            <th>Chi phí</th>
                            <th>Thao Tác</th>
                        </tr>
                        <c:forEach var="supplierStat" items="${listSupplierStats}">
                            <tr>
                                <td>${supplierStat.id}</td>
                                <td>${supplierStat.name}</td>
                                <td>${supplierStat.description}</td>
                                <td>${supplierStat.address}</td>
                                <td>${supplierStat.phone}</td>
                                <td>${supplierStat.amount}</td>
                                <td>${supplierStat.income}</td>
                                <td>
                                    <a href="chon-nha-cung-cap?id=<c:out value='${supplierStat.id}'/>">
                                        Chi tiết
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <span style="float: left;color: red;text-align: center">${requestScope.message}</span>
                </div>
            </div>
    </body>
</html>