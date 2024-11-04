<%@page import="java.util.UUID"%>
<%@page import="com.drl.models.Thong_Bao"%>
<%@page import="com.drl.models.Sinh_Vien"%>
<%@page import="com.drl.daos.Sinh_Vien_dao"%>
<%@page import="com.drl.daos.Tieu_Chi_dao"%>
<%@page import="com.drl.models.DRL"%>
<%@page import="com.drl.models.Tieu_Chi"%>
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
                                        class="account_name"><%=session.getAttribute("username")%></span></a>
                            </li>
                            <li class="account_item ">

                                <a class="login_form_line login_form_line_second">Họ và tên: <span class="account_name">
                                        <%= session.getAttribute("name")%>
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
                                <a href="bcs-tkb" class="login_form_line menu-item-link" data-target="table_home">
                                    <svg class="icon_item" fill="none" viewBox="0 0 24 24">
                                    <path d="m8.91003 19.9201 6.51997-6.52c.77-.77.77-2.03 0-2.8l-6.51997-6.52002"
                                          stroke="#292d32" stroke-linecap="round" stroke-linejoin="round"
                                          stroke-miterlimit="10" stroke-width="1.5" />
                                    </svg>Thời gian nộp
                                </a>
                            </li>
                            <li class="menu_item">
                                <a href="bcs-home?id=<%=session.getAttribute("username")%>" class="login_form_line menu-item-link" data-target="table_home">
                                    <svg class="icon_item" fill="none" viewBox="0 0 24 24">
                                    <path d="m8.91003 19.9201 6.51997-6.52c.77-.77.77-2.03 0-2.8l-6.51997-6.52002"
                                          stroke="#292d32" stroke-linecap="round" stroke-linejoin="round"
                                          stroke-miterlimit="10" stroke-width="1.5" />
                                    </svg>Thông tin cá nhân
                                </a>
                            </li>
                            <li class="menu_item">
                                <a href="bcs-drl?id=<%=session.getAttribute("username")%>" class="login_form_line menu-item-link" data-target="table_khoa">
                                    <svg class="icon_item" fill="none" viewBox="0 0 24 24">
                                    <path d="m8.91003 19.9201 6.51997-6.52c.77-.77.77-2.03 0-2.8l-6.51997-6.52002"
                                          stroke="#292d32" stroke-linecap="round" stroke-linejoin="round"
                                          stroke-miterlimit="10" stroke-width="1.5" />
                                    </svg>Điểm của bạn
                                </a>
                            </li>
                            <li class="menu_item">
                                <a href="bcs-check?id=<%=session.getAttribute("username")%>" class="login_form_line menu-item-link" data-target="table_tkb">
                                    <svg class="icon_item" fill="none" viewBox="0 0 24 24">
                                    <path d="m8.91003 19.9201 6.51997-6.52c.77-.77.77-2.03 0-2.8l-6.51997-6.52002"
                                          stroke="#292d32" stroke-linecap="round" stroke-linejoin="round"
                                          stroke-miterlimit="10" stroke-width="1.5" />
                                    </svg>Đánh giá điểm bản thân
                                </a>
                            </li>
                            <li class="menu_item">
                                <%
                                    Sinh_Vien tesv = new Sinh_Vien_dao().getSinhVienById((String) session.getAttribute("username"));
                                %>
                                <a href="bcs-lop?id=<%=tesv.getLopID()%>" class="login_form_line menu-item-link" data-target="table_class">
                                    <svg class="icon_item" fill="none" viewBox="0 0 24 24">
                                    <path d="m8.91003 19.9201 6.51997-6.52c.77-.77.77-2.03 0-2.8l-6.51997-6.52002"
                                          stroke="#292d32" stroke-linecap="round" stroke-linejoin="round"
                                          stroke-miterlimit="10" stroke-width="1.5" />
                                    </svg>Đánh giá điểm của lớp
                                </a>
                            </li>

                        </ul>
                    </div>
                </div>

                <div class="main_content">

                    <!--Tiêu chí-->
                    <div class="main_content_home table_class_home table_tieuchi">
                        <div class="main_title_wrap">
                            <div class="title_icon">
                                <div>
                                    <h5 class="main-title">
                                        <svg class="icon-title-main fill" version="1.1" id="_x32_" viewBox="0 0 512 512"
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
                            <form action="bcs-check" method = "post">
                                <input name="iddsave" value="abc" type="hidden">
                                <input name="id" value="<%=request.getParameter("id")%>" type="hidden">
                                <div class="main-table-title-wrap">
                                    <h1 class="main-table-title">Đánh giá điểm

                                    </h1>
                                    <div class="main-table-button"> <!--Thêm xóa sửa balabala-->
                                        <button onclick="return kiemTraThoiGian()" class="button button-add">
                                            <svg class="edit-icon-add" viewBox="0 0 24 24">
                                            <path class="edit-icon-add-path" d="M8 12H16" />
                                            <path class="edit-icon-add-path" d="M12 16V8" />
                                            <path class="edit-icon-add-path"
                                                  d="M9 22H15C20 22 22 20 22 15V9C22 4 20 2 15 2H9C4 2 2 4 2 9V15C2 20 4 22 9 22Z" />
                                            </svg>
                                            <span class="add-span">Lưu</span></button>
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
                                            <li class="table-header-item width_2 padding-title">
                                                Nội dung tiêu chí
                                            </li>
                                            <li class="table-header-item width_3">
                                                Điểm
                                            </li>
                                            <li class="table-header-item width_4">
                                                Thao tác
                                            </li>
                                        </ul>
                                    </li>
                                    <!--dùng vòng lặp-->
                                    <li class="table-content-wrap">
                                    <li id="original-div7" class="main-table-item">
                                        <%
                                            int i = 1;
                                            Object obj = request.getAttribute("drlList");
                                            if (obj instanceof ArrayList<?>) {
                                                ArrayList<?> tieuchi = (ArrayList<?>) obj;

                                                if (tieuchi != null && !tieuchi.isEmpty()) {
                                                    for (Object o : tieuchi) {
                                                        if (o instanceof DRL) {

                                                            DRL tc = (DRL) o;
                                                            Tieu_Chi t = new Tieu_Chi_dao().getTieuChi_by_id(tc.getTieu_ChiId());

                                        %>

                                        <ul class="table-header-list">


                                            <li class="table-header-item table-item-content width_1">
                                                <span class="button none-button width_1 width_text"><%=i++%></span>
                                            </li>
                                            <li class="table-header-item table-item-content width_2 padding-title">
                                                <span name ="noidung"  class="button none-button width_2 width_text" ><%=t.getNoiDung()%></span>
                                            </li>
                                            <li class="table-header-item table-item-content width_3">
                                                <span name ="diem"  class="button none-button width_3 width_text"><%=t.getTongDiem()%></span>

                                            </li>
                                            <li class="table-header-item table-item-content width_4">
                                                <select name="<%=tc.getId()%>" class="select-width" style="width: 100%; text-align: center">
                                                    <%
                                                        int max = t.getTongDiem();
                                                        int min = 0;

                                                        // Kiểm tra nếu max < 0, đặt min thành max và max thành 0
                                                        if (max < 0) {
                                                            min = max;
                                                            max = 0;
                                                        }

                                                        for (int k = min; k <= max; k++) {
                                                    %>
                                                    <option value="<%= k%>" <%= (k == tc.getDiemSV()) ? "selected" : ""%>><%= k%></option>
                                                    <%
                                                        }
                                                    %>
                                                </select>

                                            </li>
                                        </ul>

                                        <%
                                                        }
                                                    }
                                                }
                                            }

                                        %>
                                    </li>
                                    <li id="my-template7">

                                    </li>
                                </ul>
                            </form>
                        </div>
                    </div>

                </div>
                <%                        Thong_Bao tb = (Thong_Bao) request.getAttribute("thongbao");
                    java.util.Date ngayBD = tb.getNgayBD();
                    java.util.Date ngayKT_SV = tb.getNgayKT_SV();
                    java.util.Date ngayHienTai = new java.util.Date();

                    // Kiểm tra ngày hiện tại có nằm trong khoảng [ngayBD, ngayKT_SV] không, bao gồm cả 2 ngày biên
                    boolean trongThoiGian = !ngayHienTai.before(ngayBD) && !ngayHienTai.after(ngayKT_SV);
                %>
                <script>



                    var trongThoiGian = <%= trongThoiGian%>;

                    function kiemTraThoiGian() {
                        if (!trongThoiGian) {
                            alert("Không trong thời gian xét duyệt");
                            return false; // Ngăn hành động của button
                        }

                        // Nếu trong thời gian hợp lệ, yêu cầu xác nhận từ người dùng
                        return confirm("Bạn có chắc chắn muốn thực hiện hành động này?");
                    }
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
            </div>

        </div>
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

    </body>

</html>
