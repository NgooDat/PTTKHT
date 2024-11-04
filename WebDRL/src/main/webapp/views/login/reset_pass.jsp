<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đổi mật khẩu</title>
    <link rel="stylesheet" href="css/login.css">
    <script src="script2.js"></script>
</head>

<body>
    <div class="container" id="container">
        <div class="form-container sign-in-container">
            <form action="reset-pass" method="post">
                <input type="hidden" name="allow" value="<%=(String)session.getAttribute("allow")%>">
                <input type="hidden" name="mail" value="<%=request.getParameter("mail")%>">
                <img class = "logo_ptit" src="images/logo_ptit.png" alt="logo_ptit">
                <h1 class = "login">Đổi mật khẩu</h1><span class = "PTIT"> </span>
                <!--<div class="social-container">
                    <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                    <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                    <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
                </div>-->
                <span class = "uncorrect_pass" >${message}</span> <!---->
                <input name="pass1" type="password" placeholder="Nhập mật khẩu mới" />
                <input name="pass2" style="margin-bottom: 30px;" type="password" placeholder="Xác nhận mật khẩu" />
                <button>Xác nhận</button>
            </form>
        </div>
        <div class="overlay-container" style="background-image: url('images/dangnhap.jpg')">

        </div>
    </div>
</body>

</html>
