<%-- 
    Document   : footer
    Created on : Oct 31, 2020, 11:32:42 PM
    Author     : Tien Thanh
--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ page import="java.util.*" %>
        <%
        // initialize the current year that's used in the
        // copyright notice
        GregorianCalendar currentDate = new GregorianCalendar();
        int currentYear = currentDate.get(Calendar.YEAR);
        %>
        <p><small>
                &copy; Copyright <%= currentYear %> Nguyen Tien Thanh - B17DCCN569
        </small></p>
        
    </body>
</html>
