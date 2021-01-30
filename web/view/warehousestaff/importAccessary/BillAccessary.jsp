<%@page import="java.util.ArrayList"%>
<%@page import="model.AccessaryUsed"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Hóa Đơn Nhập</title>
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
            height: available;
            width: 80%;
            background-color: #f2f2f2;
            margin: auto;
            text-align: center;

        }
        h2{
            display: inline-block;
        }
        .left{
            float: left;
            width: 50%;
            height:40%; 

        }
        .right{
            float: right;
            width: 50%;
            height : 40%;
           
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
                <h2>Hóa đơn nhập phụ tùng</h2>
                <br>
              
                    <h3>Nhà cung cấp:</h3>
                    <label>ID: ${supplier.id}</label> <br>
                    <label>Họ tên: ${supplier.name}</label> <br>
                    <label>Mô tả: ${supplier.description}</label> <br>
                    <label>Địa chỉ: ${supplier.address}</label> <br>
                    <label>SDT: ${supplier.phone}</label> 
                <br>
                <br>
                <h3>DS Phụ tùng nhập:</h3>
                <table style="width: 70%" align="center">
                    <tr>
                        <th>ID</th>
                        <th>Tên</th>
                        <th>Mô tả</th>
                        <th>Số lượng nhập</th>
                        <th>Giá nhập</th>
                    </tr>
                    <c:forEach var="importAccesary" items="${listImportAccessaries}">
                        <tr>
                            <td>${importAccesary.accessary.id}</td>
                            <td>${importAccesary.accessary.name}</td>
                            <td>${importAccesary.accessary.description}</td>
                            <td>${importAccesary.amount}</td>
                            <td>${importAccesary.priceImport}</td>
                        </tr>
                    </c:forEach>
                </table>
                <br>
                <p>Thành tiền:${tongtien}</p>
                <a style="left: 200px;bottom: 50px;" href="nhan-xe/khach-hang"><button>Quay lại</button></a>
                <a style="right: 200px;bottom: 50px;" href="xac-nhan"><button onclick="return confirm('Lưu vào CSDL?')">Xác nhận</button></a>
            </div>
        </div>
    </body>
</html>