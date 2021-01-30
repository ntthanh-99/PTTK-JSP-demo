<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Tìm kiếm Khách Hàng</title>
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
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        } 
        th, td {
            padding: 15px;
        } 
        th {
            text-align: center;
        } 

    </style>
    <body>
        <div>
            <header>
                <h2>Hệ thống Quản lí Gara ô tô</h2>
            </header>

            <div class="container">
                <h2>Tìm kiếm Khách hàng</h2>
                <br>
            
                <div>

                    <table align="center">
                        <tr>
                            <th>Mã</th>
                            <th>Họ Tên</th>
                            <th>Chức vụ</th>
                            <th>Địa chỉ</th>
                            <th>SDT</th>
                            <th>Thao Tác</th>
                        </tr>
                        <c:forEach var="employee" items="${listEmployee}">
                            <tr>
                                <td>${employee.id}</td>
                                <td>${employee.name}</td>
                                <td>${employee.position}</td>
                                <td>${employee.address}</td>
                                <td>${employee.phone}</td>
                                <td>
                                    <a href="sua?id=<c:out value='${employee.id}'/>">
                                        Sửa
                                    </a>
                                    <a href="xoa?id=<c:out value='${employee.id}'/>">
                                        Xóa
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>