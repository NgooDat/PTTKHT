<%@page import="java.util.UUID"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.drl.models.Thong_Bao"%>
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
                                        <div class=" hkti">
                                            <h1 class="hktt">
                                                Học kỳ hiện tại:

                                            </h1>
                                            <div class="sewrap">
                                                <select class="sel"  onchange="if (this.value &&
                                                                confirm('Bạn có chắc chắn muốn chuyển đổi học kỳ?')) {
                                                            location = this.value;
                                                        }">
                                                    <%
                                                        try {
                                                            // Lấy danh sách khoa từ request
                                                            ArrayList<HK_NK> hkList = (ArrayList<HK_NK>) request.getAttribute("hkNkList");
                                                            HK_NK hk = (HK_NK) request.getAttribute("hkNk");

                                                            // Kiểm tra nếu hkList không null
                                                            if (hkList != null) {
                                                                // Lặp qua danh sách từ phần tử thứ hkList.size() - 4 đến cuối
                                                                for (int i = hkList.size() - 6; i < hkList.size(); i++) {
                                                                    HK_NK t = hkList.get(i);

                                                                    // Thiết lập thuộc tính "selected" nếu id của t trùng với id của hk
                                                                    String selected = (t.getId() == hk.getId()) ? "selected" : "";
                                                    %>
                                                    <option value="school_tkb?hk=<%= t.getId()%>" <%= selected%>><%= t.getHocKy()%> <%= t.getNienKhoa()%></option>
                                                    <%
                                                                }
                                                            }
                                                        } catch (Exception e) {
                                                            e.printStackTrace();
                                                        }
                                                    %>
                                                </select>

                                            </div>
                                        </div>
                                        <form class="form-table" action="">
                                            <div class="main-table-title-wrap">
                                                <h1 class="main-table-title">Khóa học

                                                </h1>
                                                <div class="main-table-button"> <!--Thêm xóa sửa balabala-->
                                                    <form action="school_tkb" method="post">
                                                        <input name="kh" type="hidden" value="snull">
                                                        <button class="button button-add">
                                                            <svg class="edit-icon-add" viewBox="0 0 24 24">
                                                            <path class="edit-icon-add-path" d="M8 12H16" />
                                                            <path class="edit-icon-add-path" d="M12 16V8" />
                                                            <path class="edit-icon-add-path"
                                                                  d="M9 22H15C20 22 22 20 22 15V9C22 4 20 2 15 2H9C4 2 2 4 2 9V15C2 20 4 22 9 22Z" />
                                                            </svg>
                                                            <span class="add-span">Thêm</span>
                                                        </button>
                                                    </form>
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
                                                                    <%= j++%> 
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


                                <div class="main-top-right table_tb">
                                    <div class="main-table-wrap ">
                                        <form id="updateForm" action="school_tkb" method="post" >
                                            <div class="main-table-title-wrap">
                                                <h1 class="main-table-title">Tùy chỉnh thời hạn nộp

                                                </h1>
                                                <div class="main-table-button"> <!--Thêm xóa sửa balabala-->
                                    
                                                    <button type="button" onclick="validateDates()" class="button width button-add login_form_button">

                                                        <span class="add-span">Cập nhật</span></button>
                                                </div>
                                            </div>


                                            <%
                                                Thong_Bao tb = (Thong_Bao) request.getAttribute("thongbao");
                                                // Định dạng ngày để hiển thị
                                                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                                                String ngayBD = tb.getNgayBD() != null ? dateFormat.format(tb.getNgayBD()) : "";
                                                String ngayKT_SV = tb.getNgayKT_SV() != null ? dateFormat.format(tb.getNgayKT_SV()) : "";
                                                String ngayKT_CS = tb.getNgayKT_CS() != null ? dateFormat.format(tb.getNgayKT_CS()) : "";
                                                String ngayKT_CV = tb.getNgayKT_CV() != null ? dateFormat.format(tb.getNgayKT_CV()) : "";
                                                String ngayKT_Khoa = tb.getNgayKT_Khoa() != null ? dateFormat.format(tb.getNgayKT_Khoa()) : "";
                                            %>
                                            <div class="time-wrap">
                                                <div class="time-items">
                                                    <label class="label-iteam">Ngày bắt đầu: </label>
                                                    <input value="<%= ngayBD%>" name="date1" id="startDate" class="input-item" type="date">
                                                </div>
                                                <div class="time-items">
                                                    <label class="label-iteam">Hạn nộp của sinh viên:</label>
                                                    <input value="<%= ngayKT_SV%>" name="date2" id="studentDeadline" class="input-item" type="date">
                                                </div>
                                                <div class="time-items">
                                                    <label class="label-iteam">Hạn nộp của ban cán sự: </label>
                                                    <input value="<%= ngayKT_CS%>" name="date3" id="classRepDeadline" class="input-item" type="date">
                                                </div>
                                                <div class="time-items">
                                                    <label class="label-iteam">Hạn nộp của cố vấn học tập:</label>
                                                    <input value="<%= ngayKT_CV%>" name="date4" id="advisorDeadline" class="input-item" type="date">
                                                </div>
                                                <div class="time-items">
                                                    <label class="label-iteam">Hạn nộp của khoa:</label>
                                                    <input value="<%= ngayKT_Khoa%>" name="date5" id="departmentDeadline" class="input-item" type="date">
                                                </div>
                                            </div>



                                            <script>
                                                function validateDates() {
                                                    const today = new Date().toISOString().split('T')[0];
                                                    const inputs = document.querySelectorAll('.input-item');

                                                    // Kiểm tra nếu bất kỳ ô nào trống
                                                    let isAnyEmpty = false;
                                                    inputs.forEach(input => {
                                                        if (!input.value) {
                                                            isAnyEmpty = true;
                                                        }
                                                    });

                                                    if (isAnyEmpty) {
                                                        alert("Vui lòng nhập đầy đủ các ngày!");
                                                        return;
                                                    }

                                                    // Kiểm tra nếu bất kỳ ngày nào nhỏ hơn ngày hiện tại
                                                    for (let input of inputs) {
                                                        if (input.value && input.value < today) {
                                                            alert("Không được dùng ngày của quá khứ!");
                                                            return;
                                                        }
                                                    }

                                                    // Kiểm tra nếu ngày sau phải lớn hơn hoặc bằng ngày trước
                                                    for (let i = 1; i < inputs.length; i++) {
                                                        if (inputs[i].value && inputs[i - 1].value && inputs[i].value < inputs[i - 1].value) {
                                                            alert("Ngày tiếp theo phải sau ngày trước!");
                                                            return;
                                                        }
                                                    }

                                                    // Xác nhận nếu các ngày hợp lệ
                                                    confirm("Tất cả các ngày đã nhập hợp lệ. Bạn có chắc chắn muốn lưu?");
                                                }
                                            </script>



                                            <style>
                                                .time-items{
                                                    margin: 0!important;
                                                    padding: 12px 30px!important;
                                                    height: auto!important;
                                                }
                                            </style>
                                    </div>
                                    </form>


                                </div>
                            </div>
                        </div>

                    </div>


                </div>


            </div>

        </div>
    </div>
    <script>
        function validateDates() {
            const today = new Date().toISOString().split('T')[0];
            const inputs = document.querySelectorAll('.input-item');

            // Kiểm tra nếu bất kỳ ô nào trống
            let isAnyEmpty = false;
            inputs.forEach(input => {
                if (!input.value) {
                    isAnyEmpty = true;
                }
            });

            if (isAnyEmpty) {
                alert("Vui lòng nhập đầy đủ các ngày!");
                return false;
            }

            // Kiểm tra nếu bất kỳ ngày nào nhỏ hơn ngày hiện tại
            for (let input of inputs) {
                if (input.value && input.value < today) {
                    alert("Không được dùng ngày của quá khứ!");
                    return false;
                }
            }

            // Kiểm tra nếu ngày sau phải lớn hơn hoặc bằng ngày trước
            for (let i = 1; i < inputs.length; i++) {
                if (inputs[i].value && inputs[i - 1].value && inputs[i].value < inputs[i - 1].value) {
                    alert("Ngày tiếp theo phải sau ngày trước!");
                    return false;
                }
            }

            // Xác nhận nếu các ngày hợp lệ
            if (confirm("Tất cả các ngày đã nhập hợp lệ. Bạn có chắc chắn muốn lưu?")) {
                document.getElementById("updateForm").submit();
            } else {
                return false;
            }
        }
    </script>
    <style>
        .main-top{
            height: auto;
        }

        .special{
            background: #0866ff;
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

        .sewrap {
            flex-grow: 1;
            padding: 8px 8px;
        }

        .time-wrap{
            display: flex;
            flex-wrap: wrap;
            margin-bottom: 18px;
        }

        .label-iteam{
            margin-left: 12px;
            width: 180px;
        }

        .time-items{
            align-items: center;
            width: 100%;
            height: 40px;
            margin: 12px 30px;
            display: flex;
        }



        .input-item{
            border-radius: 5px;
            height: 40px;
            flex-grow: 1;
            margin: 0px 8px;
            padding: 0;
            padding: 14px;
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

    </style>
    <style>
        a.button {
            border-radius: 10px;
            border: 1px solid rgba(0, 0, 0, 0.125);
            cursor: pointer !important;
        }
        button.button {
            border-radius: 10px;
            border: 1px solid rgba(0, 0, 0, 0.125);
            cursor: pointer !important;
        }
    </style>

    <script>
    </script>
    <!--Footter-->
</div>
<%
    // Kiểm tra xem biến "check" có tồn tại và có giá trị true hay không
    if (request.getAttribute("check") != null && (Boolean) request.getAttribute("check")) {
        boolean isRequestSuccessful = (Boolean) request.getAttribute("check");
        String show = (String) request.getAttribute("show");
%>

<script type="text/javascript">
    // Truyền giá trị của biến từ Java vào JavaScript
    var isRequestSuccessful = <%= isRequestSuccessful%>;
    // Kiểm tra biến và hiển thị confirm nếu giá trị là true
    if (isRequestSuccessful) {
        var userConfirmed = confirm("<%= show%>");
        if (userConfirmed) {
            console.log("Người dùng đã chọn tiếp tục.");
            // Thực hiện các hành động tiếp theo ở đây
        } else {
            console.log("Người dùng đã chọn hủy.");
            // Thực hiện các hành động khi người dùng chọn hủy
        }
    }
</script>

<%
    }
%>


</body>

</html>