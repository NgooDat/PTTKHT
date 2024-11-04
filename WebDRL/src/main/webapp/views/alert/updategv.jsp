<%@page import="java.util.UUID"%>
<%@page import="com.drl.daos.Tai_Khoan_dao"%>
<%@page import="com.drl.models.Tai_Khoan"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.drl.daos.Khoa_dao"%>
<%@page import="com.drl.models.Khoa"%>
<%@page import="com.drl.models.Giang_Vien"%>
<%@page import="com.drl.daos.Giang_Vien_dao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html class="no-js" lang="vi">

    <head>
        <link rel='dns-prefetch' href='//fonts.googleapis.com' />
        <link rel='preconnect' href='https://fonts.gstatic.com' />
        <link rel="stylesheet" href="css/text.css">
        <link rel="stylesheet" href="css/style.css">
        <meta charset="UTF-8">
        <link rel="shortcut icon" href="images/logo_ptit.ico" type="image/x-icon">
        <title>PTITHCM</title>
    </head>

    <body class="home page-template ">


        <!--Header-->
        <div class="jeg_ad jeg_ad_top jnews_header_top_ads">
            <div class='ads-wrapper  '></div>
        </div>
        <div class="jeg_viewport">


            <div class="jeg_header_wrapper">
                <div class="jeg_header_instagram_wrapper">
                </div>
                <div class="jeg_header normal">
                    <div class="jeg_topbar jeg_container jeg_navbar_wrapper normal">
                        <div class="container">
                            <div class="jeg_nav_row">

                                <div class="jeg_nav_col jeg_nav_left  jeg_nav_grow">
                                    <div class="item_wrap jeg_nav_alignleft">
                                        <div class="jeg_nav_item">
                                        </div>
                                    </div>
                                </div>


                                <div class="jeg_nav_col jeg_nav_center  jeg_nav_normal">
                                    <div class="item_wrap jeg_nav_aligncenter">
                                        <!-- Button -->
                                        <div class="jeg_nav_item jeg_button_2">
                                            <a href="https://www.facebook.com/profile.php?id=100007451926088"
                                               class="btn round " target="_blank">
                                                @Copyright - bản quyền thuộc về abc-xyz </a>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="jeg_midbar jeg_container jeg_navbar_wrapper normal">
                        <div class="container">
                            <div class="jeg_nav_row">

                                <div class="jeg_nav_col jeg_nav_left jeg_nav_normal">
                                    <div class="item_wrap jeg_nav_aligncenter">
                                        <div class="jeg_nav_item jeg_logo jeg_desktop_logo">
                                            <h1 class="site-title">
                                                <a href="#" style="padding: 2px 0px 2px 0px;">
                                                    <img class='jeg_logo_img' src="images/logoptithcm.png" alt="logoptithcm">

                                                </a>
                                            </h1>
                                        </div>
                                    </div>
                                </div>
                                <!--<div class="jeg_nav_col jeg_nav_right jeg_nav_normal">
                                        <div class="item_wrap jeg_nav_aligncenter">
                                            <div class="jeg_nav_item jeg_button_1">
                                                <a href="#" class="btn outline " target="">
                                                    Hotline: 19008198xx </a>
                                            </div>
                                        </div>
                                    </div>-->

                            </div>
                        </div>
                    </div>
                    <div style="height: 0px"
                         class="jeg_bottombar jeg_navbar jeg_container jeg_navbar_wrapper  jeg_navbar_shadow jeg_navbar_dark">

                    </div>
                </div>
            </div>

            <div class="jeg_header_sticky">
            </div>


            <div class="jscroll-to-top">
                <a href="#back-to-top" class="jscroll-to-top_link"></a>
            </div>
        </div>

        <!--Body-->
        <div class="jeg_ad jeg_ad_top jnews_header_top_ads">

            <div class="container container_body">

                <div class="login_form_menu">
                    <div class="login_form">
                        <a class="login_form_title login_form_line">
                            <svg class="icon_title" viewBox="0 0 24 24">
                            <path d="m0 0h24v24h-24z" fill="#fff" opacity="0" />
                            <g class="icon_title_color">
                            <path d="m12 11a4 4 0 1 0 -4-4 4 4 0 0 0 4 4z" />
                            <path d="m18 21a1 1 0 0 0 1-1 7 7 0 0 0 -14 0 1 1 0 0 0 1 1z" />
                            </g>
                            </svg>
                            Đăng nhập
                        </a>
                        <ul class="account_list">
                            <li class="account_item account_item_undeline">
                                <a class="login_form_line" style="margin-top: 8px;">Tài khoản: <span
                                        class="account_name">Nhà trường</span></a>
                            </li>
                            <li class="account_item ">

                                <a class="login_form_line login_form_line_second">Username: <span class="account_name">
                                        <%= session.getAttribute("username")%>
                                    </span></a>
                            </li>
                            <li>
                                <a href="logout">
                                    <button class="login_form_button">
                                        <span>
                                            <svg style="transform: translateY(1px)" viewBox="0 0 24 24" width="18"
                                                 height="18">
                                            <path d="m0 0h24v24h-24z" fill="none" />
                                            <path class="icon-path"
                                                  d="m5 22a1 1 0 0 1 -1-1v-18a1 1 0 0 1 1-1h14a1 1 0 0 1 1 1v3h-2v-2h-12v16h12v-2h2v3a1 1 0 0 1 -1 1zm13-6v-3h-7v-2h7v-3l5 4z" />
                                            </svg>
                                        </span>
                                        <span class="log_out_icon">Đăng xuất</span>
                                    </button>
                                </a>
                        </ul>
                        <div class="login_form_line login_form_last">
                            <%
                                String token = UUID.randomUUID().toString();
                                session.setAttribute("token", token);
                            %>
                            <a href="forget-pass?token=<%=token%>" class="forget_pass"> Đổi mật khẩu?</a>
                        </div>




                    </div>
                    <div class="login_form menu">
                        <a class="login_form_title login_form_line">
                            <svg class="icon_title" viewBox="0 0 16 16" class="bi bi-gear-fill" fill="currentColor">
                            <path fill-rule="evenodd"
                                  d="M9.405 1.05c-.413-1.4-2.397-1.4-2.81 0l-.1.34a1.464 1.464 0 0 1-2.105.872l-.31-.17c-1.283-.698-2.686.705-1.987 1.987l.169.311c.446.82.023 1.841-.872 2.105l-.34.1c-1.4.413-1.4 2.397 0 2.81l.34.1a1.464 1.464 0 0 1 .872 2.105l-.17.31c-.698 1.283.705 2.686 1.987 1.987l.311-.169a1.464 1.464 0 0 1 2.105.872l.1.34c.413 1.4 2.397 1.4 2.81 0l.1-.34a1.464 1.464 0 0 1 2.105-.872l.31.17c1.283.698 2.686-.705 1.987-1.987l-.169-.311a1.464 1.464 0 0 1 .872-2.105l.34-.1c1.4-.413 1.4-2.397 0-2.81l-.34-.1a1.464 1.464 0 0 1-.872-2.105l.17-.31c.698-1.283-.705-2.686-1.987-1.987l-.311.169a1.464 1.464 0 0 1-2.105-.872l-.1-.34zM8 10.93a2.929 2.929 0 1 0 0-5.86 2.929 2.929 0 0 0 0 5.858z" />
                            </svg>
                            Tính năng
                        </a>
                        <ul class="menu_list">

                            <li class="menu_item">
                                <a href="school_home" class="login_form_line menu-item-link" data-target="table_home">
                                    <svg class="icon_item" fill="none" viewBox="0 0 24 24">
                                    <path d="m8.91003 19.9201 6.51997-6.52c.77-.77.77-2.03 0-2.8l-6.51997-6.52002"
                                          stroke="#292d32" stroke-linecap="round" stroke-linejoin="round"
                                          stroke-miterlimit="10" stroke-width="1.5" />
                                    </svg>Trang chủ
                                </a>
                            </li>
                            <li class="menu_item">
                                <a href="school_khoa" class="login_form_line menu-item-link" data-target="table_khoa">
                                    <svg class="icon_item" fill="none" viewBox="0 0 24 24">
                                    <path d="m8.91003 19.9201 6.51997-6.52c.77-.77.77-2.03 0-2.8l-6.51997-6.52002"
                                          stroke="#292d32" stroke-linecap="round" stroke-linejoin="round"
                                          stroke-miterlimit="10" stroke-width="1.5" />
                                    </svg>Khoa
                                </a>
                            </li>
                            <li class="menu_item">
                                <a href="school_tkb" class="login_form_line menu-item-link" data-target="table_tkb">
                                    <svg class="icon_item" fill="none" viewBox="0 0 24 24">
                                    <path d="m8.91003 19.9201 6.51997-6.52c.77-.77.77-2.03 0-2.8l-6.51997-6.52002"
                                          stroke="#292d32" stroke-linecap="round" stroke-linejoin="round"
                                          stroke-miterlimit="10" stroke-width="1.5" />
                                    </svg>Thời gian biểu
                                </a>
                            </li>
                            <li class="menu_item">
                                <a href="school_lop" class="login_form_line menu-item-link" data-target="table_class">
                                    <svg class="icon_item" fill="none" viewBox="0 0 24 24">
                                    <path d="m8.91003 19.9201 6.51997-6.52c.77-.77.77-2.03 0-2.8l-6.51997-6.52002"
                                          stroke="#292d32" stroke-linecap="round" stroke-linejoin="round"
                                          stroke-miterlimit="10" stroke-width="1.5" />
                                    </svg>Lớp
                                </a>
                            </li>
                            <li class="menu_item">

                                <a href="school_giangvien" class="login_form_line menu-item-link" data-target="table_covan">
                                    <svg class="icon_item" fill="none" viewBox="0 0 24 24">
                                    <path d="m8.91003 19.9201 6.51997-6.52c.77-.77.77-2.03 0-2.8l-6.51997-6.52002"
                                          stroke="#292d32" stroke-linecap="round" stroke-linejoin="round"
                                          stroke-miterlimit="10" stroke-width="1.5" />
                                    </svg>Cố vấn
                                </a>
                            </li>
                            <li class="menu_item">
                                <a href="school_tieuchi" class="login_form_line menu-item-link" data-target="table_tieuchi">
                                    <svg class="icon_item" fill="none" viewBox="0 0 24 24">
                                    <path d="m8.91003 19.9201 6.51997-6.52c.77-.77.77-2.03 0-2.8l-6.51997-6.52002"
                                          stroke="#292d32" stroke-linecap="round" stroke-linejoin="round"
                                          stroke-miterlimit="10" stroke-width="1.5" />
                                    </svg>Tiêu chí
                                </a>
                            </li>
                            <li class="menu_item">
                                <a href="school_sinhvien" class="login_form_line menu-item-link"
                                   data-target="table_sinhvien">
                                    <svg class="icon_item" fill="none" viewBox="0 0 24 24">
                                    <path d="m8.91003 19.9201 6.51997-6.52c.77-.77.77-2.03 0-2.8l-6.51997-6.52002"
                                          stroke="#292d32" stroke-linecap="round" stroke-linejoin="round"
                                          stroke-miterlimit="10" stroke-width="1.5" />
                                    </svg>Sinh viên
                                </a>
                            </li>
                            <li class="menu_item">
                                <a href="school_drl" class="login_form_line menu-item-link" data-target="table_drl">
                                    <svg class="icon_item" fill="none" viewBox="0 0 24 24">
                                    <path d="m8.91003 19.9201 6.51997-6.52c.77-.77.77-2.03 0-2.8l-6.51997-6.52002"
                                          stroke="#292d32" stroke-linecap="round" stroke-linejoin="round"
                                          stroke-miterlimit="10" stroke-width="1.5" />
                                    </svg>Duyệt điểm
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="main_content">

                    <!--Thời gian biểu-->
                    <div class="main_content_home table_class_home table_tkb">
                        <div class="main_title_wrap">
                            <div class="title_icon">
                                <div>
                                    <h5 class="main-title">
                                        <svg height="24px" width="24px" version="1.1" id="_x32_" viewBox="0 0 512 512"
                                             xml:space="preserve">
                                        <style type="text/css">
                                            .st0 {
                                                fill: #fff;
                                            }
                                        </style>
                                        <g>
                                        <path class="st0"
                                              d="M458.159,404.216c-18.93-33.65-49.934-71.764-100.409-93.431c-28.868,20.196-63.938,32.087-101.745,32.087   c-37.828,0-72.898-11.89-101.767-32.087c-50.474,21.667-81.479,59.782-100.398,93.431C28.731,448.848,48.417,512,91.842,512   c43.426,0,164.164,0,164.164,0s120.726,0,164.153,0C463.583,512,483.269,448.848,458.159,404.216z" />
                                        <path class="st0"
                                              d="M256.005,300.641c74.144,0,134.231-60.108,134.231-134.242v-32.158C390.236,60.108,330.149,0,256.005,0   c-74.155,0-134.252,60.108-134.252,134.242V166.4C121.753,240.533,181.851,300.641,256.005,300.641z" />
                                        </g>
                                        </svg>
                                        <span class="title-text">Thông tin cá nhân
                                        </span>

                                    </h5>
                                </div>
                            </div>
                        </div>
                        <div class="tkb">
                            <div class="main-top-right table_tb">
                                <form action="updategv" method="post">
                                    <div class="main-table-wrap ">
                                        <div class="main-table-title-wrap">
                                            <h1 class="main-table-title">Thông tin cá nhân

                                            </h1>
                                            <button onclick="confirmLink(event, 'Xác nhận lưu?')" class="button button-add">
                                                
                                                <span class="add-span">Cập nhật</span></button>

                                        </div>

                                        <%
                                            Giang_Vien gv = (Giang_Vien) request.getAttribute("gv");
                                        %>

                                        <div class="time-wrap wrappp">
                                            <div class="time-items item">
                                                <div class="labellabel">
                                                    <label class="label-iteam label2">ID: </label>
                                                </div>
                                                <input style="background: #eee" name="idaccount" class="input-item item" readonly type="text" value="<%=gv.getId()%>">
                                            </div>
                                            <div class="time-items item">
                                                <div class="labellabel">
                                                    <label class="label-iteam label2">Khoa: </label>
                                                </div>
                                                <%
                                                    Khoa kh = new Khoa_dao().getKhoa_by_ID(gv.getKhoaID());
                                                %>
                                                <input style="background: #eee" class="input-item item" type="text" readonly value="<%=kh.getTen()%>">
                                            </div>
                                            <div class="time-items item">
                                                <div class="labellabel">
                                                    <label class="label-iteam label2">Họ tên: </label>
                                                </div>
                                                <input name="hoTen" accept-charset="UTF-8" class="input-item item" type="text" placeholder="Họ và tên" value="<%=gv.getHoTen()%>">
                                            </div>
                                            <div class="time-items item">
                                                <div class="labellabel">
                                                    <label class="label-iteam label2">Giới tính: </label>
                                                </div>
                                                <select name="sex" class="input-item item" style="height: 100%">
                                                    <%
                                                        String nam, nu;
                                                        if (gv.getGioiTinh().equals("Nam")) {
                                                            nam = "selected";
                                                            nu = "";
                                                        } else {
                                                            nam = "";
                                                            nu = "selected";
                                                        }
                                                    %>
                                                    <option value="1"<%=nam%>>
                                                        Nam
                                                    </option>
                                                    <option value="2"<%=nu%>>
                                                        Nữ
                                                    </option>
                                                </select>
                                            </div>
                                            <div class="time-items item">
                                                <div class="labellabel">
                                                    <%
                                                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                                                        String ngayBD = gv.getNgaySinh() != null ? dateFormat.format(gv.getNgaySinh()) : "";
                                                    %>

                                                    <label class="label-iteam label2">Ngày sinh: </label>
                                                </div>
                                                <input name="birth" class="input-item item" type="date" value="<%=ngayBD%>">
                                            </div>
                                            <div class="time-items item">
                                                <div class="labellabel">
                                                    <label class="label-iteam label2">SĐT: </label>
                                                </div>
                                                <input name="phone" class="input-item item" type="text" placeholder="Số điện thoại" value="<%=gv.getSdt()%>">
                                            </div>
                                            <div class="time-items item">
                                                <div class="labellabel">
                                                    <label class="label-iteam label2">Mật khẩu: </label>
                                                </div>
                                                <%
                                                    Tai_Khoan tk = new Tai_Khoan_dao().getTaiKhoan_by_email(gv.getId());
                                                %>

                                                <input name="pass" class="input-item item" type="password" placeholder="Mật khẩu" value="<%=tk.getPassword()%>">
                                            </div>
                                            <div class="time-items item mail">
                                                <label class="label-iteam item2">Email:</label>
                                                <input style="background: #eee" class="input-item" type="text" readonly value="<%=gv.getEmail()%>">
                                            </div>
                                            <div class="time-items item2">
                                                <label class="label-iteam item2">Địa chỉ:</label>
                                                <input name="add" class="input-item"  accept-charset="UTF-8" type="text" value="<%=gv.getDiaChi()%>">
                                            </div>
                                            <div class="time-items item2 last">
                                                <label class="label-iteam item2">Quê quán:</label>
                                                <input name="add2" class="input-item" type="text" accept-charset="UTF-8" value="<%=gv.getQueQuan()%>">
                                            </div>
                                        </div>



                                    </div>
                                </form>
                            </div>


                        </div>

                    </div>


                </div>


            </div>

        </div>
    </div>
    <style>
        .time-items.item{
            width: 33.33333%!important;
            padding: 16px 0px;
        }

        .input-item.item{
            width: 70%;
        }

        .labellabel{
            width: 30%;
        }

        .time-wrap.wrappp{
            padding: 0 12px;
            margin-bottom: 40px;
        }



        .time-items.mail {
            width: 66.666667%!important;
        }

        .time-items.item2{
            width: 100%!important;
            justify-content: center;
        }

        .time-items.mail{
            width: 66.666667%;
        }

        .label-iteam.item2{
            width: 60px;
        }

        .item2.last{
            border-bottom: 1px dashed var(--red-background);
        }
        .hkti {
            display: flex;
            padding: 24px 0px;
            justify-content: space-between;
            align-items: center;
            border-bottom: 1px dotted var(--red-background)
        }

        .hktt {
            color: var(--gray--color);
            opacity: 0.9;
            margin: 0;
            font-size: 16px;
            margin: 0px 12px;
        }

        .left .table_tb {
            height: 100% !important;
        }

        .edit1{
            transform: translateY(12px)!important;
        }

        .edit2{
            transform: translateY(7px);
        }

        .sewrap {
            flex-grow: 1;
            padding: 8px 8px;
        }

        .time-wrap{
            display: flex;
            flex-wrap: wrap;
        }

        .label-iteam{
            margin-left: 12px;
            width: 180px;
        }

        .time-items{
            align-items: center;
            margin: 0;
            padding: 12px 30px !important;
            display: flex;
            height: auto!important;
            border-top: 1px dashed var(--red-background);
        }



        .input-item{
            border-radius: 5px;
            height: 40px;
            flex-grow: 1;
            margin: 0px 8px;
            padding: 0;
            padding: 0px 14px ;
            border: 1px solid var(--gray--color);
        }

        .input-item:focus-visible{
            border: 1px solid var(--gray--color)!important;
        }

        .main-top {
            display: flex;
        }

        .sel{
            border-radius: 5px;
            height: 40px;
            width: 100%;
            margin: 0;
            padding: 0;
            border: 1px solid var(--gray--color);
        }

        .sel:focus{
            border: 1px solid var(--gray--color);
        }


        .special{
            background: #0866ff;
        }
    </style>
    <script>
        function confirmLink(event, message) {
            // Hiển thị hộp thoại xác nhận với chuỗi message tùy chỉnh
            const confirmed = confirm(message);

            // Nếu người dùng chọn "No", ngăn chặn điều hướng
            if (!confirmed) {
                event.preventDefault();
            }
        }
    </script>
    <!--Footter-->
</div>


</body>

</html>
