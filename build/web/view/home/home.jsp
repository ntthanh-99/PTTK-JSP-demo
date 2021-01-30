<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%> <%@ taglib prefix="c"
         uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Trang chủ</title>
    </head>
    <style>
        header {
            /* width 100% so với wrapper (wrapper là thẻ cha) */
            height: 70px;
            width: 80%;
            background-color: #56ccf2; /* màu nền */
            text-align: center;
            margin: auto; /* căn giữa */
            margin-bottom: 10px; /*khoảng cách với phần tử sau 10 px */
        }
        .container {
            height: 80%;
            width: 80%;
            background-color: #f2f2f2;
            margin: auto;
            text-align: center;
        }
        .login{
            height: 40px;
            width: 90%;
            text-align: right;
        }
        .footer{
            height: 10%;
            text-align: center;
            font-size: 14px;
        }
        h2 {
            display: inline-block;
        }
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #56ccf2;
        }

        li {
            float: left;
        }

        li a, .dropbtn {
            display: inline-block;

            color:black;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover, .dropdown:hover .dropbtn {
            background-color: #56CCF2;
        }

        li.dropdown {
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #56ccf2;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
        }

        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            text-align: left;
        }

        .dropdown-content a:hover {background-color: #f1f1f1;}

        .dropdown:hover .dropdown-content {
            display: block;
        }
        
    </style>
    <body>
        <div style="">
            <header>
                <h2>Hệ thống Quản lí Gara ô tô</h2>
            </header>
            
            <div class="login">
                <input style="height: 20px" type="text" name="keyword">
                <button><a href="/tim-kiem"><img src="<c:url value="/resource/images/icon_search.png"></c:url>" alt="search"></a></button>
                <button style="background-color: white"><a href="<%=request.getContextPath()%>/dang-nhap"><img style="height: 25px;width: 25px" src="<c:url value="/resource/images/login.png"></c:url>" alt="login" ></a></button>
            </div>
            
            <div class="container">
                <ul>
                    <li><a href="#">Trang chủ</a></li>
                    <li class="dropdown">
                        <a href="javascript:void(0)" class="dropbtn">Quản lí</a>
                        <div class="dropdown-content">
                            <a href="<%=request.getContextPath()%>/nhan-vien">Quản lí nhân viên</a>
                            <a href="<%=request.getContextPath()%>/khach-hang">Quản lí khách hàng</a>
                            <a href="<%=request.getContextPath()%>/dich-vu">Quản lí dịch vụ</a>
                            <a href="<%=request.getContextPath()%>/phu-tung">Quản lí phụ tùng</a>

                        </div>
                    </li>

                    <li class="dropdown">
                        <a href="javascript:void(0)" class="dropbtn">QL Bán hàng</a>
                        <div class="dropdown-content">
                            <a href="<%=request.getContextPath()%>/dat-lich">Đặt lịch</a>
                            <a href="<%=request.getContextPath()%>/nhan-xe">Nhận xe vào sửa</a>
                            <a href="<%=request.getContextPath()%>/thanh-toan">Thanh toán</a>

                        </div>
                    </li>
                    <li class="dropdown">
                        <a href="javascript:void(0)" class="dropbtn">QL Kho</a>
                        <div class="dropdown-content">
                            <a href="<%=request.getContextPath()%>/nhap-phu-tung">Nhập phụ tùng</a>
                            <a href="<%=request.getContextPath()%>/nha-cung-cap">QL nhà cung cấp</a>
                        </div>
                    </li>
                    <li class="dropdown">
                        <a href="javascript:void(0)" class="dropbtn">Xem thống kê</a>
                        <div class="dropdown-content">
                            <a href="<%=request.getContextPath()%>/thong-ke/nha-cung-cap">Thống kê nhà cung cấp</a>
                            <a href="<%=request.getContextPath()%>/thong-ke/khach-hang">Thống kê khách hàng</a>
                            <a href="<%=request.getContextPath()%>/thong-ke/dich-vu">Thống kê dịch vụ</a>
                            <a href="<%=request.getContextPath()%>/thong-ke/phu-tung">Thống kê phụ tùng</a>
                        </div>
                    </li>
                 
                    <li><a href="<%=request.getContextPath()%>/lien-he">Liên hệ</a></li>
                       
                </ul>
            </div>
                    <div>
                        
                    </div>
            <div class="footer">
                <p>Chúng tôi luôn nổ lực đem đến bạn những dịch vụ tốt nhất</p>
            </div>
        </div>
    </body>
</html>
