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

                    <h3>Nhà cung cấp:</h3>
                    <label>ID: ${supplierStat.id}</label> <br>
                    <label>Họ tên: ${supplierStat.name}</label> <br>
                    <label>Mô tả: ${supplierStat.description}</label> <br>
                    <label>Địa chỉ: ${supplierStat.address}</label> <br>
                    <label>SDT: ${supplierStat.phone}</label> <br>
                    <label>Tổng lượng nhập: ${supplierStat.amount}</label> <br>
                    <label>Tổng chi phí: ${supplierStat.income}</label> <br>
                </div>

                <div class="result">

                    <table >
                        <tr>
                            <th>Mã</th>
                            <th>Chi phí</th>
                            <th>Ngày tạo</th>
                            <th>Thao Tác</th>
                        </tr>
                        <c:forEach var="billAccessary" items="${listBillAccessaries}">
                            <tr>
                                <td>${billAccessary.id}</td>
                                <td>${billAccessary.total}</td>
                                <td>${billAccessary.createdDate}</td>

                                <td>
                                    <a href="chon-hoa-don?id=<c:out value='${billAccessary.id}'/>">
                                        Chọn
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <span style="float: left;color: red;text-align: center">${requestScope.message}</span>
                </div>

            </div>
        </div>
    </body>
</html>