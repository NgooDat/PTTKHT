<%-- 
    Document   : index
    Created on : Sep 19, 2024, 1:31:41 PM
    Author     : Dat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script type="text/javascript">
        function redirectToServlet() {
            // Chuyển hướng đến servlet /redirect
            window.location.href = 'upload.jsp';
        }
    </script>
    <body>
        <h1>
            <%
                out.print("Bạn muốn đăng ảnh lên?");
                %>
        </h1>
        <button onclick="redirectToServlet()">Upload</button>
    </body>
</html>
