
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quên mật khẩu</title>
    <link rel="stylesheet" href="css/login.css">
</head>

<body>
    <div class="container" id="container">
        <div class="form-container sign-in-container">
            <form action="input_code">
                <img class = "logo_ptit" src="images/logo_ptit.png" alt="logo_ptit" srcset="">
                <h1 class = "login">Nhập tên tài khoản<span class = "PTIT"> </span></h1>

                <span class = "uncorrect_pass" >${message}</span> <!--Tên đăng nhập không tồn tại trên hệ thống!-->
                <input style="margin-bottom: 30px; "type="text" name = "account_id" placeholder="Tên tài khoản" />
                <button>Gửi</button>
            </form>
        </div>
        <div class="overlay-container" style="background-image: url('images/dangnhap.jpg')">

        </div>
    </div>
</body>

</html>
