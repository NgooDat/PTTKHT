<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="images/logo_ptit.ico" type="image/x-icon">
        <title>Thông báo!</title>
        
        <script type="text/javascript">
            window.onload = function() {

                // Hộp thoại xác nhận tự động hiển thị khi tải trang
                if (confirm("Đổi mật khẩu thành công!?")) {
                    window.location.href = "login"; // Đường dẫn đến trang đăng nhập
                }
            };
        </script>
        
        <style>
            body, html {
                height: 100%;
                margin: 0;
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                text-align: center;
            }
            img {
                height: 50%;
            }
        </style>
    </head>
    <body>
        
    </body>
</html>
