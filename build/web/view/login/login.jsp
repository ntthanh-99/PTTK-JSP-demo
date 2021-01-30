<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<style>
    header{  /* width 100% so với wrapper (wrapper là thẻ cha) */
    height: 70px;
    width: 80%;
    background-color: cyan; /* màu nền */
    text-align: center;
    margin: auto; /* căn giữa */
    margin-bottom: 10px; /*khoảng cách với phần tử sau 10 px */
}
    .container{
        height: 270px;
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
    <div style="">
    <header>
            <h2>Hệ thống Quản lí Gara ô tô</h2>
    </header>
        
    <div class="container">
        <h2>Đăng nhập</h2>
        <br>
        <span style="color: red">${requestScope.message}</span>

        <form action="" class="form" method="POST">
            <div class="form-group">
                <label for="username">Tài khoản:</label>
                <input type="text" name="username" id="inputUser" required autocomplete="off">
            </div>
            <br>
            <div class="form-group">
                <label for="password">Mật khẩu:&nbsp;</label>
                <input type="password" name="password" id="inputPass" required autocomplete="off">
            </div>
            <br>
            <input type="hidden" value="login" name="action">
            <input type="submit" value="Đăng nhập">    
        </form>
        
        <p>Nếu bạn không có tài khoản: <a href="<%=request.getContextPath()%>/dang-ky">Đăng ký</a></p>
        <p>Nếu bạn quên mật khẩu: <a href="<%=request.getContextPath()%>/quen-mat-khau">Quên mật khậu</a></p>
    </div>
    </div>
</body>
</html>