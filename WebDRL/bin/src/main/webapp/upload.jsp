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
            window.location.href = 'index.jsp';
        }
    </script>
    <body>
        <h1>
            <%
                out.print("Đăng thất bại!");
                %>
        </h1>
        <button onclick="redirectToServlet()">Quay lại</button>
    </body>
</html>
