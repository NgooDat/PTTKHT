<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="css/login.css">
</head>

<body>
    <div class="container" id="container">
        <div class="form-container sign-in-container">
            <form action="ktra_dangnhap" method ="post">
                <img class = "logo_ptit" src="images/logo_ptit.png" alt="logo_ptit">
                <h1 class = "login">Đăng nhập PTIT<span class = "PTIT"> </span></h1>
                <%
                    String message = request.getParameter("message");
                    if(message == null){
                        message = "";
                    }
                %>
                <span class = "uncorrect_pass" ><%=message%></span> <!--Tài khoản hoặc mật khẩu không đúng!-->
                <input type="text" name = "username" placeholder="Tên đăng nhập" value="${username}"/>
                <input type="password" name="password" placeholder="Mật khẩu" value="${password}"/>
                <a href="forget-pass">Quên mật khẩu?</a>
                <button>Đăng nhập</button>
            </form>
        </div>
        <div class="overlay-container" style="background-image: url('images/dangnhap.jpg')">

        </div>
    </div>
</body>

</html>
