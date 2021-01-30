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
            height: 500px;
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
            width: 48%;
            height:60%; 
            overflow:auto;
            
        }
        .right{
            float: right;
            width: 48%;
            height : 60%;
            overflow:auto;
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
                <h2>Chọn Dịch vụ</h2>
                <br>

                <div>
                    <form action="" class="form" method="POST">
                        <div class="form-group">
                            <input type="text" name="keyword" id="inputService" required autocomplete="off" value="Nhập tên dịch vụ/phụ tùng">
                        </div>
                        <br>
                        <input type="hidden" value="searchService" name="action">
                        <input type="submit" value="Tìm kiếm">    
                    </form>
                </div>

                <div class="left">
                    <p style="text-align: left">DS dịch vụ</p>
                    <table style="width: 95%">
                        <tr>
                            <th>ID</th>
                            <th>Tên</th>
                            <th>Mô tả</th>
                            <th>Giá</th>


                            <th>Thao Tác</th>
                        </tr>
                        <c:forEach var="service" items="${listServices}">
                            <tr>
                                <td>${service.id}</td>
                                <td>${service.name}</td>
                                <td>${service.description}</td>
                                <td>${service.price}</td>

                                <td>
                                    <a href="chon-dich-vu?id=<c:out value='${service.id}'/>" onclick="return confirm('Thêm?')">
                                        Thêm
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>

                </div>
                <div class="right">
                    <p style="text-align: left">DS phụ tùng</p>
                    <table style="width: 95%">
                        <tr>
                            <th>ID</th>
                            <th>Tên</th>
                            <th>Mô tả</th>
                            <th>Số lượng còn</th>
                            <th>Giá</th>
                            <th>Thao Tác</th>
                        </tr>
                        <c:forEach var="accessary" items="${listAccessaries}">
                            <tr>
                                <td>${accessary.id}</td>
                                <td>${accessary.name}</td>
                                <td>${accessary.description}</td>
                                <td>${accessary.remainAmount}</td>
                                <td>${accessary.price}</td>
                                <td>
                                    <a href="chon-phu-tung?id=<c:out value='${accessary.id}'/>" onclick="return confirm('Thêm?')">
                                        Thêm
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>

                </div>
<!--                <div position: fixed;left: 200px;bottom: 50px>
                    <select name="sl" id="SL">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </select>-->
                    <span style="position: fixed;left: 520px;bottom: 50px;color: red;text-align: center">${requestScope.message}</span>
                </div>
                <a style="position: fixed;left: 200px;bottom: 50px;" href="nhan-xe/khach-hang"><button>Quay lại</button></a>
                <a style="position: fixed;right: 200px;bottom: 50px;" href="nhan-vien-ki-thuat"><button>Tiếp theo</button></a>
            </div>
        </div>
    </body>
</html>