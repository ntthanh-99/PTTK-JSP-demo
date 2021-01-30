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
                <h2>Chọn Nhân viên kĩ thuật</h2>
                <br>
                <table align="center">
                        <tr>
                            <th>ID</th>
                            <th>Họ Tên</th>
                            <th>Địa chỉ</th>
                            <th>SDT</th>
                            <th>Thao Tác</th>
                        </tr>
                        <c:forEach var="technicalStaff" items="${listTechnicalStaffs}">
                            <tr>
                                <td>${technicalStaff.id}</td>
                                <td>${technicalStaff.name}</td>
                                <td>${technicalStaff.address}</td>
                                <td>${technicalStaff.phone}</td>
                                <td>
                                    <a href="chon-nhan-vien?id=<c:out value='${technicalStaff.id}'/>">
                                        Chọn
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <span style="float: left;color: red;text-align: center">${requestScope.message}</span>
                </div>
                <a style="position: fixed;left: 200px;bottom: 50px;" href="/nhan-xe/dich-vu"><button>Quay lại</button></a>
            </div>
    </body>
</html>