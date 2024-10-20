<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Xác nhận tài khoản</title>
    <link rel="stylesheet" href="css/login.css">
    <script src="script2.js"></script>
</head>

<body>
    <div class="container" id="container">
        <div class="form-container sign-in-container">
            <form action="reset_pass">
                <img class = "logo_ptit" src="images/logo_ptit.png" alt="logo_ptit" srcset="">
                <h1 style = "font-size: small;"class = "login">Nhập mã xác nhận gồm 6 chữ số được gửi tới email khôi phục của bạ!<span class = "PTIT"> </span></h1>
                <!--<div class="social-container">
                    <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                    <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                    <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
                </div>-->
            <span class = "uncorrect_pass" >Mã xác nhận không chính xác!</span> <!--Mã xác nhận không chính xác-->
                <input style="margin-bottom: 30px; "type="text" placeholder="Nhập mã xác nhận" />
                <button>Gửi</button>
            </form>
        </div>
        <div class="overlay-container" style="background-image: url('images/dangnhap.jpg')">

        </div>
    </div>
</body>

</html>
