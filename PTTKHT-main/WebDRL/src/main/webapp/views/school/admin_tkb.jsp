<%@page import="com.drl.models.Khoa_Hoc"%>
<%@page import="com.drl.models.HK_NK"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

<body class="home page-template ">
    <div class = "configm-wrap">
        <div class="configm-main">
            <div class="configm-close"><h3>x</h3></div>
            <h3 class="configm-title">Xác nhận thao tác?</h3>
            <div class="yes-no">
                <button class="button button-yes">Yes</button>
                <button class="button button-no">No</button>
            </div>

        </div>

    </div>

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
                                                <img class='jeg_logo_img' src="images/logoptithcm.png"
                                                    alt="logoptithcm">

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
        <script>
            // Lấy phần tử của các nút và hộp thoại
            const configmWrap = document.querySelector('.configm-wrap');
            const buttonNo = document.querySelector('.button-no');
            const closeButton = document.querySelector('.configm-close');

            // Hàm đóng hộp thoại (ẩn nó đi)
            function closeDialog() {
                configmWrap.style.display = 'none';
            }

            // Gắn sự kiện click cho nút "No" và nút "x"
            buttonNo.addEventListener('click', closeDialog);
            closeButton.addEventListener('click', closeDialog);

        </script>

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
                        <a href="#" class="forget_pass"> Đổi mật khẩu?</a>
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
                                    <svg class="icon-title-main fill" version="1.0" id="Layer_1" viewBox="0 0 24 24"
                                        enable-background="new 0 0 24 24" xml:space="preserve">
                                        <g>
                                            <path class="round"
                                                d="M21,13.6V4.5C21,3.7,20.3,3,19.5,3H17V1.5C17,0.7,16.3,0,15.5,0h-1C13.7,0,13,0.7,13,1.5V3H8V1.5C8,0.7,7.3,0,6.5,0h-1   C4.7,0,4,0.7,4,1.5V3H1.5C0.7,3,0,3.7,0,4.5v16C0,21.3,0.7,22,1.5,22h12.8c1,1.2,2.5,2,4.2,2c3,0,5.5-2.5,5.5-5.5   C24,16.4,22.8,14.5,21,13.6z M13.6,16H11v-4h4v2.3C14.4,14.7,14,15.3,13.6,16z M6,16v-4h4v4H6z M10,17v4H6v-4H10z M15,7v4h-4V7H15z    M10,11H6V7h4V11z M5,11H1V7h4V11z M5,12v4H1v-4H5z M16,12h4v1.2c-0.5-0.1-1-0.2-1.5-0.2c-0.9,0-1.7,0.2-2.5,0.6V12z M20,11h-4V7h4   V11z M14,1.5C14,1.2,14.2,1,14.5,1h1C15.8,1,16,1.2,16,1.5v2C16,3.8,15.8,4,15.5,4h-1C14.2,4,14,3.8,14,3.5V1.5z M5,1.5   C5,1.2,5.2,1,5.5,1h1C6.8,1,7,1.2,7,1.5v2C7,3.8,6.8,4,6.5,4h-1C5.2,4,5,3.8,5,3.5V1.5z M1.5,4h2.6c0.2,0.6,0.8,1,1.4,1h1   c0.7,0,1.2-0.4,1.4-1h5.2c0.2,0.6,0.8,1,1.4,1h1c0.7,0,1.2-0.4,1.4-1h2.6C19.8,4,20,4.2,20,4.5V6H1V4.5C1,4.2,1.2,4,1.5,4z M1,20.5   V17h4v4H1.5C1.2,21,1,20.8,1,20.5z M11,21v-4h2.2c-0.1,0.5-0.2,1-0.2,1.5c0,0.9,0.2,1.7,0.6,2.5H11z M18.5,23C16,23,14,21,14,18.5   s2-4.5,4.5-4.5s4.5,2,4.5,4.5S21,23,18.5,23z" />
                                            <g>
                                                <path class="round"
                                                    d="M17.5,21c-0.1,0-0.3-0.1-0.4-0.1l-2-2c-0.2-0.2-0.2-0.5,0-0.7s0.5-0.2,0.7,0l1.6,1.6l2.7-3.5c0.2-0.2,0.5-0.3,0.7-0.1    c0.2,0.2,0.3,0.5,0.1,0.7l-3,4C17.8,20.9,17.7,21,17.5,21C17.5,21,17.5,21,17.5,21z" />
                                            </g>
                                        </g>
                                    </svg>
                                    <span class="title-text">Thời gian
                                        biểu học kỳ
                                    </span>

                                </h5>
                            </div>
                        </div>
                    </div>
                    <div class="tkb">
                        <div class="main-top right">
                            <div class="main-top-left">
                                <div class="main-table-wrap table_khoahoc">
                                    <form class="form-table" action="">
                                        <div class="main-table-title-wrap">
                                            <h1 class="main-table-title">Khóa học

                                            </h1>
                                            <div class="main-table-button"> <!--Thêm xóa sửa balabala-->
                                                <a class="button button-add">
                                                    <svg class="edit-icon-add" viewBox="0 0 24 24">
                                                        <path class="edit-icon-add-path" d="M8 12H16" />
                                                        <path class="edit-icon-add-path" d="M12 16V8" />
                                                        <path class="edit-icon-add-path"
                                                            d="M9 22H15C20 22 22 20 22 15V9C22 4 20 2 15 2H9C4 2 2 4 2 9V15C2 20 4 22 9 22Z" />
                                                    </svg>
                                                    <span class="add-span">Thêm</span>
                                                </a>
                                            </div>
                                        </div>

                                        <ul class="main-table">
                                            <li class="main-table-header">

                                                <ul class="table-header-list table-title">
                                                    <li class="table-header-item width_1">
                                                        STT
                                                    </li>
                                                    <li class="table-header-item width_2">
                                                        Năm bắt đầu
                                                    </li>
                                                    <li class="table-header-item width_3">
                                                        Năm kết thúc
                                                    </li>

                                                </ul>
                                            </li>
                                            <!--dùng vòng lặp-->
                                            <div class="table-content-wrap2">

                                                <li id="original-div2" class="main-table-item">
                                                    <%
                                                        int j = 1;
                                                        // Lấy danh sách KhoaHoc từ request attribute hoặc trực tiếp gọi hàm
                                                        Object obj2 = request.getAttribute("khoaHocList");
                                                        if (obj2 instanceof ArrayList<?>) {
                                                            ArrayList<?> khoaHocList = (ArrayList<?>) obj2;
                                                            if (khoaHocList != null && !khoaHocList.isEmpty()) {
                                                                for (Object o : khoaHocList) {
                                                                    if (o instanceof Khoa_Hoc) {
                                                                        Khoa_Hoc khoaHoc = (Khoa_Hoc) o;

                                                                        // Bắt đầu hiển thị dữ liệu
                                                    %>

                                                    <ul class="table-header-list">
                                                        <li class="table-header-item table-item-content width_1">
                                                            <span class="button none-button width_1 width_text">
                                                                <%= j++ %>
                                                            </span>
                                                        </li>
                                                        <li class="table-header-item table-item-content width_2">
                                                            <span class="button none-button width_2 width_text">
                                                                <%=khoaHoc.getNamBD()%>
                                                            </span>
                                                        </li>
                                                        <li class="table-header-item table-item-content width_3">
                                                            <span class="button none-button width_3 width_text">
                                                                <%=khoaHoc.getNamKT()%>
                                                            </span>
                                                        </li>

                                                    </ul>
                                                            <%
                                                                       }
                                                                   }
                                                               }
                                                           }
                                                       %>

                                                </li>
                                                <li id="my-template2">

                                                </li>
                                            </div>

                                        </ul>
                                    </form>

                                </div>
                            </div>

                        </div>

                        <div class="main-top left">

                            <div class="main-top-right table_hocky ">
                                <div class="main-table-wrap ">
                                    <div class="main-table-title-wrap">
                                        <h1 class="main-table-title">Học kỳ hiện tại
                                            

                                        </h1>
                                        

                                    </div>
                                    <div class ="hkbutton">
                                        <div>
                                            <input class="hk" type="radio" id="hk1" name="hk" value="1" />
                                            <label for="hk1">I 2024-2025</label>
                                        </div>
                                        <div>
                                            <input class="hk" type="radio" id="hk2" name="hk" value="2" checked />
                                            <label for="hk2">II 2024-2025</label>
                                        </div>
                                        <div>
                                            <input class="hk" type="radio" id="hk3" name="hk" value="3" />
                                            <label for="hk3">I 2025-2026</label>
                                        </div>

                                            
                                    </div>

                                </div>
                            </div>

                            <div class="main-top-right table_tb">
                                <div class="main-table-wrap ">
                                    <div class="main-table-title-wrap">
                                        <h1 class="main-table-title">Tùy chỉnh thời hạn nộp

                                        </h1>
                                        <div class="main-table-button"> <!--Thêm xóa sửa balabala-->
                                            <a class="button button-add">
                                                <svg class="edit-icon-add" viewBox="0 0 24 24">
                                                    <path class="edit-icon-add-path" d="M8 12H16" />
                                                    <path class="edit-icon-add-path" d="M12 16V8" />
                                                    <path class="edit-icon-add-path"
                                                        d="M9 22H15C20 22 22 20 22 15V9C22 4 20 2 15 2H9C4 2 2 4 2 9V15C2 20 4 22 9 22Z" />
                                                </svg>
                                                <span class="add-span">Thêm</span>
                                            </a>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>


                </div>

            </div>
        </div>

        <script>
        </script>
        <!--Footter-->
    </div>
    

</body>

</html>