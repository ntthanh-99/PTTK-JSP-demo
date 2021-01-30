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
        <title>Chọn Dịch vụ</title>
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
                <h2>Phiếu nhận xe</h2>
                <br>
                <div class="left">
                    <h3>Khách hàng:</h3>
                    <label>ID: ${customer.id}</label> <br>
                    <label>Họ tên: ${customer.name}</label> <br>
                    <label>Địa chỉ: ${customer.address}</label> <br>
                    <label>SDT: ${customer.phone}</label> <br>
                    <label>Email: ${customer.email}</label> 
                </div>
                <div class="right">
                    <h3>Nhân viên kĩ thuật:</h3>
                    <label>ID: ${technicalStaff.id}</label> <br>
                    <label>Họ tên: ${technicalStaff.name}</label> <br>
                    <br>
                    <br>
                    <br>
                </div>
                <br>
                <br>
                <h3>DS dịch vụ:</h3>
                <table style="width: 70%" align="center">
                    <tr>
                        <th>ID</th>
                        <th>Tên</th>
                        <th>Mô tả</th>
                        <th>Giá</th>
                        <th>SL</th>
                    </tr>
                    <c:forEach var="serviceUsed" items="${listServiceUseds}">
                        <tr>
                            <td>${serviceUsed.service.id}</td>
                            <td>${serviceUsed.service.name}</td>
                            <td>${serviceUsed.service.description}</td>
                            <td>${serviceUsed.service.price}</td>
                            <td>${serviceUsed.amount}</td>
                        </tr>
                    </c:forEach>
                    <c:forEach var="accessaryUsed" items="${listAccessaryUseds}">
                        <tr>
                            <td>${accessaryUsed.accessary.id}</td>
                            <td>${accessaryUsed.accessary.name}</td>
                            <td>${accessaryUsed.accessary.description}</td>
                            <td>${accessaryUsed.accessary.price}</td>
                            <td>${accessaryUsed.amount}</td>
                        </tr>
                    </c:forEach>
                </table>
                <br>
                <p>Thành tiền:${tongtien}</p>
                <a style="left: 200px;bottom: 50px;" href="nhan-xe/khach-hang"><button>Quay lại</button></a>
                <a style="right: 200px;bottom: 50px;" href="xac-nhan"><button onclick="return confirm('Lưu vào CSDL?')">Tạo hóa đơn</button></a>
            </div>
        </div>
    </body>
</html>