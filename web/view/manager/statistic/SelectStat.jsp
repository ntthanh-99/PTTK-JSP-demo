<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%> <%@ taglib prefix="c"
         uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chọn loại thống kê</title>
    <link rel="stylesheet" type="text/css" th:href="@{styles.css}" />
</head>
<style>
    header { /* width 100% so với wrapper (wrapper là thẻ cha) */
        height: 70px;
        width: 80%;
        background-color: cyan; /* màu nền */
        text-align: center;
        margin: auto;
        margin-bottom: 10px;
    }

    .container {
        height: 400px;
        width: 80%;
        background-color: #f2f2f2;
        margin: auto;
        text-align: center;
    }

    h2 {
        display: inline-block;
    }
</style>
<body>
    <header>
        <h2>Hệ thống Quản lí Gara ô tô</h2>
    </header>
    <div class="container">
     
            <h2>Nhập thời gian</h2>
            <form method="post" action="<c:url value='thong-ke'/>" >
                <table align="center"> 
                    <tr>
                        <td>Thời gian bắt đầu:</td>
                        <td><input type="text" name="startTime" required="true" /></td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="action" value="SupplierStat" /></td>
                    </tr>
                    <tr>
                        <td>Thời gian kết thúc:</td>
                        <td><input type="text" name="endTime" required="true" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Thống kê"></td>
                    </tr>
                    
                </table>
            </form>
    </div>
</body>
</html>