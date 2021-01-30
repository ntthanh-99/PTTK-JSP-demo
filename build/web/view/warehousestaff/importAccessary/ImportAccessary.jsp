<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%> <%@ taglib prefix="c"
         uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Nhập phụ tùng</title>
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
	<div align="center">
            <h2>Nhập phụ tùng</h2>
            <form method="post" action="<c:url value=''/>" >
		<table>
                    <tr>
			<td>ID:</td>
                        <td>${accessary.id}</td>
        		<td><input type="hidden" name="id" value="<c:out value='${accessary.id}' />" /></td>
                    </tr>
                    <tr>
                    <td>Tên:</td>
                    <td>${accessary.name}</td>
                    </tr>
                    <tr>
                        <td>Số lượng:</td>
                            <td><input type="text" name="soluong" required="true" /></td>
			</tr>
                    <tr>
                        <td>Giá nhập:</td>
			<td><input type="text" name="gianhap" required="true" /></td>
                    </tr>
                    <tr>
                    <input type="hidden" value="importAccessary" name="action">
                    </tr>
                    <tr>
                    <td></td>
                    <td><input type="submit" value="Nhập" onclick="return confirm('Nhập?')"></td>
                    </tr>
		</table>
            </form>
                    <br>
	</div>
                <span style="color: red;text-align: center">${requestScope.message}</span>
                <a style="position: fixed;left: 200px;bottom: 50px;" href="phu-tung"><button>Nhập tiếp</button></a>
                <a style="position: fixed;right: 200px;bottom: 50px;" href="hoa-don-nhap"><button>Tạo hóa đơn</button></a>
    </div>
</body>
</html>