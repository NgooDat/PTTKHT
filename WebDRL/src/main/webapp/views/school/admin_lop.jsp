<%@page import="java.util.UUID"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.concurrent.ExecutionException"%>
<%@page import="com.drl.tools.ThreadPool"%>
<%@page import="java.util.concurrent.Future"%>
<%@page import="com.drl.daos.Khoa_Hoc_dao"%>
<%@page import="com.drl.models.Khoa_Hoc"%>
<%@page import="com.drl.daos.Giang_Vien_dao"%>
<%@page import="com.drl.models.Giang_Vien"%>
<%@page import="com.drl.daos.Khoa_dao"%>
<%@page import="com.drl.models.Lop"%>
<%@page import="com.drl.models.Khoa"%>
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

    <body
        class="home page-template ">

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

                                <a class="login_form_line login_form_line_second">Username: <span class="account_name"><%= session.getAttribute("username")%></span></a>
                            </li>
                            <li>
                                <a
                                    href="logout">
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
                                <a href = "school_home" class="login_form_line menu-item-link" data-target="table_home">
                                    <svg class="icon_item" fill="none" viewBox="0 0 24 24">
                                    <path d="m8.91003 19.9201 6.51997-6.52c.77-.77.77-2.03 0-2.8l-6.51997-6.52002"
                                          stroke="#292d32" stroke-linecap="round" stroke-linejoin="round"
                                          stroke-miterlimit="10" stroke-width="1.5" />
                                    </svg>Trang chủ
                                </a>
                            </li>
                            <li class="menu_item">
                                <a href = "school_khoa" class="login_form_line menu-item-link" data-target="table_khoa">
                                    <svg class="icon_item" fill="none" viewBox="0 0 24 24">
                                    <path d="m8.91003 19.9201 6.51997-6.52c.77-.77.77-2.03 0-2.8l-6.51997-6.52002"
                                          stroke="#292d32" stroke-linecap="round" stroke-linejoin="round"
                                          stroke-miterlimit="10" stroke-width="1.5" />
                                    </svg>Khoa
                                </a>
                            </li>
                            <li class="menu_item">
                                <a href = "school_tkb" class="login_form_line menu-item-link" data-target="table_tkb">
                                    <svg class="icon_item" fill="none" viewBox="0 0 24 24">
                                    <path d="m8.91003 19.9201 6.51997-6.52c.77-.77.77-2.03 0-2.8l-6.51997-6.52002"
                                          stroke="#292d32" stroke-linecap="round" stroke-linejoin="round"
                                          stroke-miterlimit="10" stroke-width="1.5" />
                                    </svg>Thời gian biểu
                                </a>
                            </li>
                            <li class="menu_item">
                                <a href = "school_lop" class="login_form_line menu-item-link" data-target="table_class">
                                    <svg class="icon_item" fill="none" viewBox="0 0 24 24">
                                    <path d="m8.91003 19.9201 6.51997-6.52c.77-.77.77-2.03 0-2.8l-6.51997-6.52002"
                                          stroke="#292d32" stroke-linecap="round" stroke-linejoin="round"
                                          stroke-miterlimit="10" stroke-width="1.5" />
                                    </svg>Lớp
                                </a>
                            </li>
                            <li class="menu_item">
                                <a href = "school_giangvien"  class="login_form_line menu-item-link" data-target="table_covan">
                                    <svg class="icon_item" fill="none" viewBox="0 0 24 24">
                                    <path d="m8.91003 19.9201 6.51997-6.52c.77-.77.77-2.03 0-2.8l-6.51997-6.52002"
                                          stroke="#292d32" stroke-linecap="round" stroke-linejoin="round"
                                          stroke-miterlimit="10" stroke-width="1.5" />
                                    </svg>Cố vấn
                                </a>
                            </li>
                            <li class="menu_item">
                                <a href = "school_tieuchi" class="login_form_line menu-item-link" data-target="table_tieuchi">
                                    <svg class="icon_item" fill="none" viewBox="0 0 24 24">
                                    <path d="m8.91003 19.9201 6.51997-6.52c.77-.77.77-2.03 0-2.8l-6.51997-6.52002"
                                          stroke="#292d32" stroke-linecap="round" stroke-linejoin="round"
                                          stroke-miterlimit="10" stroke-width="1.5" />
                                    </svg>Tiêu chí
                                </a>
                            </li>
                            <li class="menu_item">
                                <a href = "school_sinhvien" class="login_form_line menu-item-link" data-target="table_sinhvien">
                                    <svg class="icon_item" fill="none" viewBox="0 0 24 24">
                                    <path d="m8.91003 19.9201 6.51997-6.52c.77-.77.77-2.03 0-2.8l-6.51997-6.52002"
                                          stroke="#292d32" stroke-linecap="round" stroke-linejoin="round"
                                          stroke-miterlimit="10" stroke-width="1.5" />
                                    </svg>Sinh viên
                                </a>
                            </li>
                            <li class="menu_item">
                                <a href = "school_drl" class="login_form_line menu-item-link" data-target="table_drl">
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

                    <!--Lớp-->
                    <div class="main_content_home table_class_home table_class">
                        <div class="main_title_wrap">
                            <div class="title_icon">
                                <div>
                                    <h5 class="main-title">
                                        <svg xmlns="http://www.w3.org/2000/svg"class="icon-title-main fill" version="1.1" id="_x32_" viewBox="0 0 512 512"
                                             xml:space="preserve">
                                        <style type="text/css">
                                            .st0 {
                                                fill: #fff;
                                            }
                                        </style>
                                        <g>
                                        <path class="st0 icon-title-path"
                                              d="M81.44,116.972c23.206,0,42.007-18.817,42.007-42.008c0-23.215-18.801-42.016-42.007-42.016   c-23.216,0-42.016,18.801-42.016,42.016C39.424,98.155,58.224,116.972,81.44,116.972z" />
                                        <path class="st0 icon-title-path"
                                              d="M224.166,245.037c0-0.856-0.142-1.673-0.251-2.498l62.748-45.541c3.942-2.867,4.83-8.411,1.963-12.362   c-1.664-2.285-4.342-3.652-7.17-3.652c-1.877,0-3.667,0.589-5.191,1.689l-62.874,45.636c-2.341-1.068-4.909-1.704-7.65-1.704   h-34.178l-8.294-47.222c-4.555-23.811-14.112-42.51-34.468-42.51h-86.3C22.146,136.873,0,159.019,0,179.383v141.203   c0,10.178,8.246,18.432,18.424,18.432c5.011,0,0,0,12.864,0l7.005,120.424c0,10.83,8.788,19.61,19.618,19.61   c8.12,0,28.398,0,39.228,0c10.83,0,19.61-8.78,19.61-19.61l9.204-238.53h0.463l5.27,23.269c1.744,11.097,11.293,19.28,22.524,19.28   h51.534C215.92,263.461,224.166,255.215,224.166,245.037z M68.026,218.861v-67.123h24.126v67.123l-12.817,15.118L68.026,218.861z" />
                                        <polygon class="st0 icon-title-path"
                                                 points="190.326,47.47 190.326,200.869 214.452,200.869 214.452,71.595 487.874,71.595 487.874,302.131    214.452,302.131 214.452,273.113 190.326,273.113 190.326,326.256 512,326.256 512,47.47  " />
                                        <path class="st0 icon-title-path"
                                              d="M311.81,388.597c0-18.801-15.235-34.029-34.028-34.029c-18.801,0-34.036,15.228-34.036,34.029   c0,18.785,15.235,34.028,34.036,34.028C296.574,422.625,311.81,407.381,311.81,388.597z" />
                                        <path class="st0 icon-title-path"
                                              d="M277.781,440.853c-24.259,0-44.866,15.919-52.782,38.199h105.565   C322.648,456.771,302.04,440.853,277.781,440.853z" />
                                        <path class="st0 icon-title-path"
                                              d="M458.573,388.597c0-18.801-15.235-34.029-34.028-34.029c-18.801,0-34.036,15.228-34.036,34.029   c0,18.785,15.235,34.028,34.036,34.028C443.338,422.625,458.573,407.381,458.573,388.597z" />
                                        <path class="st0 icon-title-path"
                                              d="M424.545,440.853c-24.259,0-44.866,15.919-52.783,38.199h105.565   C469.411,456.771,448.804,440.853,424.545,440.853z" />
                                        </g>
                                        </svg><span class="title-text margin_title2">Lớp
                                        </span>

                                    </h5>
                                </div>
                            </div>
                        </div>
                        <div class="main-table-wrap">
                            <div class="main-table-title-wrap">
                                <h1 class="main-table-title">Danh sách các lớp

                                </h1>
                                <div style="display:flex" class="main-table-button"> <!--Thêm xóa sửa balabala-->
                                    <div style="transform: translateY(-2px)" class="select-title"><span>Chọn khoa: </span></div>
                                    <%
                                        String selectedKhoaId = (String) request.getAttribute("khoaSelect");
                                        String selected = ("allKhoa".equals(selectedKhoaId)) ? "selected" : "";
                                    %>
                                    <select id="khoaSelect" onchange="if (this.value) {
                                                location = this.value;
                                            }">
                                        <option value="school_lop?khoaId=allKhoa" <%= selected%>>Tất cả</option>
                                        <%
                                            // Lấy danh sách khoa từ request
                                            ArrayList<Khoa> khoaList = (ArrayList<Khoa>) request.getAttribute("khoaList");

                                            // Kiểm tra nếu khoaList không null
                                            if (khoaList != null) {
                                                for (Khoa khoa : khoaList) {
                                                    selected = (khoa.getId().equals(selectedKhoaId)) ? "selected" : "";
                                        %>
                                        <option value="school_lop?khoaId=<%=khoa.getId()%>" <%= selected%>><%=khoa.getTen()%></option>
                                        <%
                                                }
                                            }
                                        %>
                                    </select>


                                    <button onclick="showContent()" class="button button-add">
                                        <svg class="edit-icon-add" viewBox="0 0 24 24">
                                        <path class="edit-icon-add-path" d="M8 12H16" />
                                        <path class="edit-icon-add-path" d="M12 16V8" />
                                        <path class="edit-icon-add-path"
                                              d="M9 22H15C20 22 22 20 22 15V9C22 4 20 2 15 2H9C4 2 2 4 2 9V15C2 20 4 22 9 22Z" />
                                        </svg>
                                        <span class="add-span">Thêm</span>
                                    </button>

                                </div>
                                <div class="message-wrap-table" >
                                    <span class="span-message">${message}</span>
                                </div>
                            </div>

                            <ul class="main-table">
                                <li class="main-table-header">
                                    <ul class="table-header-list table-title">
                                        <li class="table-header-item width_1">
                                            STT
                                        </li>
                                        <li class="table-header-item width_2">
                                            Lớp
                                        </li>
                                        <li class="table-header-item width_3 padding-title">
                                            Khoa
                                        </li>
                                        <li class="table-header-item width_4 padding-title">
                                            Cố vấn
                                        </li>

                                        <li class="table-header-item width_5">
                                            Khóa học
                                        </li>
                                        <li class="table-header-item width_6">
                                            Thao tác
                                        </li>
                                    </ul>
                                </li>
                                <!--dùng vòng lặp-->
                                <li class="table-content-wrap">

                                <li id="original-div5" class="main-table-item">

                                    <%
                                        int i = 1;
                                        Object obj = request.getAttribute("lopList");
                                        if (obj instanceof ArrayList<?>) {
                                            ArrayList<?> lopList = (ArrayList<?>) obj;
                                            if (lopList != null && !lopList.isEmpty()) {
                                                for (Object o : lopList) {
                                                    if (o instanceof Lop) {
                                                        Lop lop = (Lop) o;

                                    %>
                                    <form action="school_lop" method="get">
                                        <ul id ="wrap<%=i%>" class="table-header-list">
                                            <input name="option2" value="<%=selectedKhoaId%>" type="hidden">
                                            <input name="lopcu" value="<%=lop.getId()%>" type="hidden">
                                            <input name="wrap" value="wrap<%=i%>" type="hidden">
                                            <input name="tenlopcu" value="<%=lop.getTen()%>" type="hidden">
                                            <li class="table-header-item table-item-content width_1">
                                                <span class="button none-button width_1 width_text"><%= i%></span>
                                            </li>
                                            <li class="table-header-item table-item-content width_2">
                                                <input name="lopid" class="button none-button width_2 width_text" value="<%= lop.getTen()%>">
                                            </li>
                                            <li class="table-header-item table-item-content width_3 padding-title">
                                                <select  name ="khoamoi" class="select-covan" onchange="if (this.value) {
                                                            location = this.value;
                                                        }">
                                                    <%
                                                        String idlop = request.getParameter("idlop");
                                                        Khoa kh_se;
                                                        if (idlop != null && idlop.equals(lop.getId())) {
                                                            kh_se = (Khoa) request.getAttribute("khse");
                                                        } else {
                                                            kh_se = new Khoa_dao().getKhoa_by_ID(lop.getKhoaID());
                                                        }

                                                        // Lấy danh sách khoa từ request
                                                        ArrayList<Khoa> khoaL = (ArrayList<Khoa>) request.getAttribute("khoaList");

                                                        // Kiểm tra nếu khoaList không null
                                                        if (khoaL != null) {
                                                            for (Khoa k : khoaL) {
                                                                selected = (k.getId().equals(kh_se.getId())) ? "selected" : "";
                                                    %>
                                                    <option value="school_lop?wrap=wrap<%=i%>&option=<%=selectedKhoaId%>&ido=<%=lop.getKhoaID()%>&idse=<%=k.getId()%>&idlop=<%=lop.getId()%>" <%= selected%> >  <%= k.getTen()%>
                                                    </option>
                                                    <%
                                                            }
                                                        }
                                                    %>
                                                </select>
                                            </li>
                                            <li class="table-header-item table-item-content width_4 padding-title">

                                                <select name="gvmoi" class="select-covan" >
                                                    <%
                                                        // Lấy danh sách khoa từ request
                                                        ArrayList<Giang_Vien> gvList = null;
                                                        if (idlop != null) {
                                                            if (idlop.equals(lop.getId())) {
                                                                gvList = (ArrayList<Giang_Vien>) request.getAttribute("lopse");
                                                            } else {
                                                                gvList = (ArrayList<Giang_Vien>) request.getAttribute("lopol");
                                                            }

                                                        } else {
                                                            gvList = (ArrayList<Giang_Vien>) new Giang_Vien_dao().getGiangVien_by_KhoaID(lop.getKhoaID());
                                                        }

                                                        // Kiểm tra nếu khoaList không null
                                                        if (gvList != null) {
                                                            for (Giang_Vien g : gvList) {
                                                                selected = (lop.getGiangVienID().equals(g.getId())) ? "selected" : "";
                                                    %>
                                                    <option value="<%=g.getId()%>" <%= selected%>>  <%= g.getId().toUpperCase()%> - <%=g.getHoTen()%>
                                                    </option>
                                                    <%
                                                            }
                                                        }
                                                    %>
                                                </select>
                                            </li>
                                            <li class="table-header-item table-item-content width_5">
                                                <select name="khoahocmoi" class="select-covan">
                                                    <%
                                                        // Lấy danh sách khoa từ request
                                                        ArrayList<Khoa_Hoc> khList = (ArrayList<Khoa_Hoc>) request.getAttribute("khList");

                                                        // Kiểm tra nếu khoaList không null
                                                        if (khList != null) {
                                                            for (Khoa_Hoc kh : khList) {
                                                                selected = (kh.getId() == lop.getKhoaHocID()) ? "selected" : "";
                                                    %>
                                                    <option value="<%=kh.getId()%>" <%= selected%>>  <%= kh.getNamBD()%>-<%=kh.getNamKT()%>
                                                    </option>
                                                    <%
                                                            }
                                                        }
                                                    %>
                                                </select>
                                            </li>
                                            <li class="table-header-item table-item-content width_6">
                                                <button onclick="confirmLink(event, 'Xác nhận lưu?')" class="button button-edit">
                                                    <svg class="save-icon"  version="1.1" id="Layer_1" viewBox="0 0 492.308 492.308" xml:space="preserve">
                                                    <g>
                                                    <g>
                                                    <path d="M330.784,0H32.264v300.611v64.514v127.183h427.779V129.255L330.784,0z M336.553,33.615l89.874,89.871h-89.874V33.615z     M51.957,320.303h146l-53.548-53.548l17.769-17.769l83.885,83.88l-83.885,83.885l-17.769-17.774l53.548-53.543h-146V320.303z     M440.351,472.615H51.957v-107.49h98.462l-33.856,33.851l45.615,45.62l111.731-111.731L162.178,221.139l-45.615,45.615    l33.856,33.856H51.957V19.692h264.904v123.486h123.49V472.615z"/>
                                                    </g>
                                                    </g>
                                                    </svg>
                                                    Lưu
                                                </button>
                                                <a href="school_lop?wrap=wrap<%=i%>&del=<%=lop.getId()%>" onclick="confirmLink(event, 'Xác nhận xóa?')" class="button button-delete">
                                                    <svg class="edit_icon" viewBox="0 0 24 24">
                                                    <path class="edit-icon-path" d="M10 11V17" />
                                                    <path class="edit-icon-path" d="M14 11V17" />
                                                    <path class="edit-icon-path" d="M4 7H20" />
                                                    <path class="edit-icon-path"
                                                          d="M6 7H12H18V18C18 19.6569 16.6569 21 15 21H9C7.34315 21 6 19.6569 6 18V7Z" />
                                                    <path class="edit-icon-path"
                                                          d="M9 5C9 3.89543 9.89543 3 11 3H13C14.1046 3 15 3.89543 15 5V7H9V5Z" />
                                                    </svg>
                                                    Xóa
                                                </a>
                                            </li>
                                        </ul>
                                    </form>
                                    <%                                                            i++;
                                                    }
                                                }
                                            }
                                        }

                                    %>
                                    <form  action="school_lop" method="get"  onsubmit="return validateForm()">
                                        <ul id="open" style="display:none" class="table-header-list">
                                            <input name="wrap" value="wrap<%=i%>" type="hidden">
                                            <input name="addlop" value="addlop" type="hidden">
                                            <li class="table-header-item table-item-content width_1">
                                                <span class="button none-button width_1 width_text"><%= i%></span>
                                            </li>
                                            <li class="table-header-item table-item-content width_2">
                                                <input name="lopid_add" id="maKhoaKhoa" class="button none-button width_2 width_text" placehoder="Lớp....">
                                            </li>
                                            <li class="table-header-item table-item-content width_3 padding-title">
                                                <select  name ="khoamoiadd" class="select-covan" >
                                                    <%

                                                        // Lấy danh sách khoa từ request
                                                        ArrayList<Khoa> khoaL = (ArrayList<Khoa>) request.getAttribute("khoaList");

                                                        // Kiểm tra nếu khoaList không null
                                                        if (khoaL != null) {
                                                            for (Khoa k : khoaL) {
                                                    %>
                                                    <option value="<%=k.getId()%>"><%=k.getTen()%>  
                                                    </option>
                                                    <%
                                                            }
                                                        }
                                                    %>
                                                </select>
                                            </li>
                                            <li class="table-header-item table-item-content width_4 padding-title">

                                                <select name="gvmoiadd" class="select-covan" >
                                                    <%
                                                        // Lấy danh sách khoa từ request
                                                        ArrayList<Giang_Vien> gvList = (ArrayList<Giang_Vien>) new Giang_Vien_dao().getAllGiangVien();

                                                        // Kiểm tra nếu khoaList không null
                                                        if (gvList != null) {
                                                            for (Giang_Vien g : gvList) {
                                                    %>
                                                    <option value="<%=g.getId()%>">  <%= g.getId().toUpperCase()%> - <%=g.getHoTen()%>
                                                    </option>
                                                    <%
                                                            }
                                                        }
                                                    %>
                                                </select>
                                            </li>
                                            <li class="table-header-item table-item-content width_5">
                                                <select name="khoahocmoiadd" class="select-covan">
                                                    <%
                                                        // Lấy danh sách khoa từ request
                                                        ArrayList<Khoa_Hoc> khList = (ArrayList<Khoa_Hoc>) request.getAttribute("khList");

                                                        // Kiểm tra nếu khoaList không null
                                                        if (khList != null) {
                                                            for (Khoa_Hoc kh : khList) {
                                                    %>
                                                    <option value="<%=kh.getId()%>">  <%= kh.getNamBD()%>-<%=kh.getNamKT()%>
                                                    </option>
                                                    <%
                                                            }
                                                        }
                                                    %>
                                                </select>
                                            </li>
                                            <li class="table-header-item table-item-content width_6">
                                                <button class="button button-edit">
                                                    <svg class="save-icon"  version="1.1" id="Layer_1" viewBox="0 0 492.308 492.308" xml:space="preserve">
                                                    <g>
                                                    <g>
                                                    <path d="M330.784,0H32.264v300.611v64.514v127.183h427.779V129.255L330.784,0z M336.553,33.615l89.874,89.871h-89.874V33.615z     M51.957,320.303h146l-53.548-53.548l17.769-17.769l83.885,83.88l-83.885,83.885l-17.769-17.774l53.548-53.543h-146V320.303z     M440.351,472.615H51.957v-107.49h98.462l-33.856,33.851l45.615,45.62l111.731-111.731L162.178,221.139l-45.615,45.615    l33.856,33.856H51.957V19.692h264.904v123.486h123.49V472.615z"/>
                                                    </g>
                                                    </g>
                                                    </svg>
                                                    Lưu
                                                </button>
                                                <a href="school_lop" onclick="confirmLink(event, 'Xác nhận thoát?')" class="button button-delete">
                                                    <svg style="transform: translateY(3px)" viewBox="0 0 24 24" width="16" fill="#fff"
                                                         height="16">
                                                    <path d="m0 0h24v24h-24z" fill="none" />
                                                    <path class="icon-path"
                                                          d="m5 22a1 1 0 0 1 -1-1v-18a1 1 0 0 1 1-1h14a1 1 0 0 1 1 1v3h-2v-2h-12v16h12v-2h2v3a1 1 0 0 1 -1 1zm13-6v-3h-7v-2h7v-3l5 4z" />
                                                    </svg>
                                                    Thoát
                                                </a>
                                            </li>
                                        </ul>
                                    </form>
                                </li>


                                <li id="my-template5">

                                </li>

                            </ul>

                        </div>
                    </div>

                </div>
            </div>
            <%
                String wrap = request.getParameter("wrap");
            %>
            <script>
                // JavaScript để cuộn đến vùng select với id từ biến wrap
                document.addEventListener("DOMContentLoaded", function () {
                    var selectElement = document.getElementById("<%= wrap%>");
                    if (selectElement) {
                        selectElement.scrollIntoView({behavior: "smooth", block: "center"});
                        selectElement.style.border = "1px solid black"; // Đổi viền thành đỏ
                    }
                });
            </script>
            <%%>


            <script>
                function confirmLink(event, message) {
                    // Hiển thị hộp thoại xác nhận với chuỗi message tùy chỉnh
                    const confirmed = confirm(message);

                    // Nếu người dùng chọn "No", ngăn chặn điều hướng
                    if (!confirmed) {
                        event.preventDefault();
                    }
                }

                function showContent() {
                    // Hiển thị thẻ ul
                    const openElement = document.querySelector("#open");
                    openElement.style.display = "flex";

                    // Cuộn đến phần tử
                    openElement.scrollIntoView({behavior: "smooth", block: "start"});
                    // Lấy input bên trong và đặt focus để hiển thị con trỏ
                    const inputElement = openElement.querySelector("input");
                    inputElement.focus();
                }

                function validateForm() {
                    const maKhoa = document.getElementById("maKhoaKhoa").value.trim();


                    if (maKhoa === "") {
                        alert("Vui lòng nhập đầy đủ thông tin.");
                        return false; // Ngăn form gửi
                    }
                    confirmLink(event, 'Xác nhận thêm?');
                    return true; // Cho phép gửi form nếu tất cả các ô đã được điền
                }
            </script>
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
            </style>S


            <!--Footter-->
        </div>

    </body>

</html>
