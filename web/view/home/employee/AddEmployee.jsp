<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Thêm nhân viên</title>
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
        

    </style>
    <body>
        <div>
            <header>
                <h2>Hệ thống Quản lí Gara ô tô</h2>
            </header>

            <div class="container">
                <h2>Thêm nhân viên</h2>
                <br>
                <div>
                    <form method="POST" action="">
                    <table align="center">
                        <tr>
                            <td>Username:</td>
                            <td> <input type="text" name="username"> </td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td> <input type="text" name="password"> </td>
                        </tr>
                        <tr>
                            <td>Họ tên:</td>
                            <td> <input type="text" name="name"> </td>
                        </tr>
                        <tr>
                            <td>Chức vụ:</td>
                            <td> <input type="text" name="position"> </td>
                        </tr>
                        <tr>
                            <td>Địa chỉ:</td>
                            <td> <input type="text" name="address"> </td>
                        </tr>
                        <tr>
                            <td>Số điện thoại:</td>
                            <td> <input type="text" name="phone"> </td>
                        </tr>
                        <tr>
                            <td> <input type="hidden" name="action" value="add"> </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td> <input type="submit" value="Thêm"> </td>
                        </tr>
                    </table>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>