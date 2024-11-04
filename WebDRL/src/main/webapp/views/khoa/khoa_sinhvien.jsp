<%@page import="java.util.UUID"%>
<%@page import="com.drl.daos.Khoa_dao"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.drl.daos.Tai_Khoan_dao"%>
<%@page import="com.drl.models.Tai_Khoan"%>
<%@page import="com.drl.models.Khoa"%>
<%@page import="com.drl.daos.Lop_dao"%>
<%@page import="com.drl.models.Lop"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.drl.models.Sinh_Vien"%>
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
                                <a href = "khoa_home" class="login_form_line menu-item-link" data-target="table_home">
                                    <svg class="icon_item" fill="none" viewBox="0 0 24 24">
                                    <path d="m8.91003 19.9201 6.51997-6.52c.77-.77.77-2.03 0-2.8l-6.51997-6.52002"
                                          stroke="#292d32" stroke-linecap="round" stroke-linejoin="round"
                                          stroke-miterlimit="10" stroke-width="1.5" />
                                    </svg>Trang chủ
                                </a>
                            </li>

                            <li class="menu_item">
                                <a href = "khoa_lop" class="login_form_line menu-item-link" data-target="table_class">
                                    <svg class="icon_item" fill="none" viewBox="0 0 24 24">
                                    <path d="m8.91003 19.9201 6.51997-6.52c.77-.77.77-2.03 0-2.8l-6.51997-6.52002"
                                          stroke="#292d32" stroke-linecap="round" stroke-linejoin="round"
                                          stroke-miterlimit="10" stroke-width="1.5" />
                                    </svg>Lớp
                                </a>
                            </li>
                            <li class="menu_item">
                                <a href = "khoa_giangvien"  class="login_form_line menu-item-link" data-target="table_covan">
                                    <svg class="icon_item" fill="none" viewBox="0 0 24 24">
                                    <path d="m8.91003 19.9201 6.51997-6.52c.77-.77.77-2.03 0-2.8l-6.51997-6.52002"
                                          stroke="#292d32" stroke-linecap="round" stroke-linejoin="round"
                                          stroke-miterlimit="10" stroke-width="1.5" />
                                    </svg>Cố vấn
                                </a>
                            </li>
                            <li class="menu_item">
                                <a href = "khoa_sinhvien" class="login_form_line menu-item-link" data-target="table_sinhvien">
                                    <svg class="icon_item" fill="none" viewBox="0 0 24 24">
                                    <path d="m8.91003 19.9201 6.51997-6.52c.77-.77.77-2.03 0-2.8l-6.51997-6.52002"
                                          stroke="#292d32" stroke-linecap="round" stroke-linejoin="round"
                                          stroke-miterlimit="10" stroke-width="1.5" />
                                    </svg>Sinh viên
                                </a>
                            </li>
                            <li class="menu_item">
                                <a href = "khoa_drl" class="login_form_line menu-item-link" data-target="table_drl">
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

                    <!--Sinh viên-->
                    <div class="main_content_home table_class_home table_sinhvien">
                        <div class="main_title_wrap">
                            <div class="title_icon">
                                <div>
                                    <h5 class="main-title ">
                                        <svg class="icon-title-main icon-trans" version="1.1" id="_x32_"
                                             viewBox="0 0 512 512" xml:space="preserve">
                                        <style type="text/css">
                                            .st0 {
                                                fill: #fff;
                                            }
                                        </style>
                                        <g>
                                        <path class="st0"
                                              d="M65.84,98.563l80.867,37.22v48.028h218.582v-48.028l33.424-15.38v85.07c-5.423,0.776-9.606,5.458-9.606,11.087   c0,4.899,3.166,9.146,7.717,10.621l-8.216,54.239c-0.252,1.646,0.225,3.315,1.318,4.581c1.089,1.258,2.665,1.98,4.319,1.98h29.963   c1.654,0,3.23-0.722,4.328-1.988c1.081-1.266,1.557-2.927,1.308-4.573l-8.216-54.239c4.552-1.475,7.715-5.722,7.715-10.621   c0-5.629-4.183-10.31-9.606-11.087v-94.751l26.426-12.158c2.982-1.382,4.909-4.394,4.909-7.671c0-3.284-1.927-6.297-4.91-7.663   L273.855,3.913C268.213,1.32,262.205,0,255.998,0c-6.207,0-12.213,1.32-17.851,3.913L65.842,83.229   c-2.985,1.374-4.915,4.379-4.915,7.663C60.927,94.169,62.855,97.181,65.84,98.563z" />
                                        <path class="st0"
                                              d="M410.518,413.569l-77.193-31.537c-12.284-5.644-20.221-18.028-20.221-31.553v-11.366   c0-5.225,0.862-10.365,2.331-14.852c0.423-0.567,42.372-57.127,48.202-112.88l0.182-1.755H148.175l0.184,1.755   c5.842,55.753,47.777,112.313,47.972,112.445c1.702,4.93,2.566,10.07,2.566,15.287v11.366c0,13.517-7.941,25.9-20.165,31.522   L101.43,413.6c-18.408,8.455-31.562,25.396-35.21,45.481L62.127,512h387.748l-4.109-53.082   C442.119,438.988,428.965,422.047,410.518,413.569z" />
                                        </g>
                                        </svg><span class="title-text margin_title2">Sinh viên
                                        </span>

                                    </h5>
                                </div>
                            </div>
                        </div>
                        <div class="main-table-wrap">

                            <div class="main-table-title-wrap">
                                <h1 class="main-table-title">Danh sách sinh viên

                                </h1>
                                <div class="main-table-button"> <!--Thêm xóa sửa balabala-->
                                    <%
                                        String selectedKhoaId = (String)session.getAttribute("username");
                                        String selected;
                                    %>
                                    <select style="display:none"disabled id="khoaSelect" onchange="if (this.value) {
                                                location = this.value;
                                            }">
                                        <option value="" >Chọn khoa</option>
                                        <%
                                            // Lấy danh sách khoa từ request
                                            ArrayList<Khoa> khoaList = (ArrayList<Khoa>) request.getAttribute("khoaList");

                                            // Kiểm tra nếu khoaList không null
                                            if (khoaList != null) {
                                                for (Khoa khoa : khoaList) {
                                                    selected = (khoa.getId().equals(selectedKhoaId)) ? "selected" : "";
                                        %>
                                        <option value="khoa_sinhvien?khoaId=<%=khoa.getId()%>" <%= selected%>><%=khoa.getTen()%></option>
                                        <%
                                                }
                                            }
                                        %>
                                    </select>
                                    <%
                                        String selectedLopId = (String) request.getAttribute("lopSelect");
                                        String selectedLopId2 = (String) request.getAttribute("lopSelect");
                                    %>
                                    <select id="khoaSelect" onchange="if (this.value) {
                                                location = this.value;
                                            }">
                                        <option value="">Chọn lớp</option>
                                        <%
                                            // Lấy danh sách khoa từ request
                                            ArrayList<Lop> lopList = (ArrayList<Lop>) request.getAttribute("lopSelectList");

                                            // Kiểm tra nếu khoaList không null
                                            if (lopList != null) {
                                                for (Lop lop : lopList) {
                                                    selected = (lop.getId().equals(selectedLopId)) ? "selected" : "";
                                        %>
                                        <option value="khoa_sinhvien?khoaId=<%=selectedKhoaId%>&lopId=<%=lop.getId()%>" <%= selected%>><%=lop.getTen()%></option>
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
                                            MSSV
                                        </li>
                                        <li class="table-header-item width_3 padding-title">
                                            Họ và tên
                                        </li>
                                        <li class="table-header-item width_4">
                                            Lớp
                                        </li>
                                        <li class="table-header-item width_5">
                                            Chức vụ
                                        </li>
                                        <li class="table-header-item width_6">
                                            Trạng thái
                                        </li>
                                        <li class="table-header-item width_7">
                                            Thao tác
                                        </li>
                                    </ul>
                                </li>
                                <!--dùng vòng lặp-->
                                <li class="table-content-wrap">
                                <li id="original-div8" class="main-table-item">
                                    <%
                                        int i = 1;
                                        Object obj = request.getAttribute("svList");
                                        lopList = (ArrayList<Lop>) request.getAttribute("lopList");
                                        ArrayList<Tai_Khoan> taiKhoanList = (ArrayList<Tai_Khoan>) request.getAttribute("dstk");

                                        // Tạo HashMap cho tra cứu nhanh tài khoản
                                        Map<String, Tai_Khoan> taiKhoanMap = new HashMap<>();
                                        for (Tai_Khoan tk : taiKhoanList) {
                                            taiKhoanMap.put(tk.getEmail(), tk);
                                        }

                                        // Tạo HashMap cho tra cứu nhanh khoaId dựa trên lopId
                                        Map<String, String> lopKhoaMap = new HashMap<>();
                                        for (Lop lop : lopList) {
                                            lopKhoaMap.put(lop.getId(), lop.getKhoaID());
                                        }

                                        if (obj instanceof ArrayList<?>) {
                                            ArrayList<?> svList = (ArrayList<?>) obj;

                                            if (svList != null && !svList.isEmpty()) {
                                                // Sử dụng StringBuilder để lưu trữ HTML
                                                StringBuilder htmlOutput = new StringBuilder();
                                                for (Object o : svList) {
                                                    if (o instanceof Sinh_Vien) {
                                                        Sinh_Vien sv = (Sinh_Vien) o;

                                                        // Lấy khoaId nhanh từ map
                                                        String khoaId = lopKhoaMap.get(sv.getLopID());

                                                        // Bắt đầu xây dựng HTML cho sinh viên
                                                        htmlOutput.append("<form action=\"\" method=\"get\">")
                                                                .append("<ul id=\"wrap").append(i).append("\" class=\"table-header-list\">")
                                                                .append("<input name=\"id-save\" value=\"").append(sv.getId()).append("\" type=\"hidden\">")
                                                                .append("<input name=\"lopId\" value=\"").append(selectedLopId).append("\" type=\"hidden\">")
                                                                .append("<input name=\"khoaId\" value=\"").append(selectedKhoaId).append("\" type=\"hidden\">")
                                                                .append("<input name=\"wrap\" value=\"wrap").append(i).append("\" type=\"hidden\">")
                                                                .append("<li class=\"table-header-item table-item-content width_1\">")
                                                                .append("<span class=\"button none-button width_1 width_text\">").append(i).append("</span>")
                                                                .append("</li>")
                                                                .append("<li class=\"table-header-item table-item-content width_2\">")
                                                                .append("<span class=\"button none-button width_2 width_text\">").append(sv.getId()).append("</span>")
                                                                .append("</li>")
                                                                .append("<li class=\"table-header-item table-item-content width_3 padding-title\">")
                                                                .append("<input name=\"gv-name\" class=\"button none-button width_3 width_text\" value=\"").append(sv.getHoTen()).append("\">")
                                                                .append("</li>")
                                                                .append("<li class=\"table-header-item table-item-content width_4\">")
                                                                .append("<select name=\"gv-lop\" class=\"select-covan\">");

                                                        // Tạo option cho danh sách lớp
                                                        if (lopList != null) {
                                                            for (Lop lop : lopList) {
                                                                selected = (lop.getId().equals(sv.getLopID())) ? "selected" : "";
                                                                htmlOutput.append("<option value=\"").append(lop.getId()).append("\" ").append(selected).append(">")
                                                                        .append(lop.getTen()).append("</option>");
                                                            }
                                                        }

                                                        htmlOutput.append("</select>")
                                                                .append("</li>")
                                                                .append("<li class=\"table-header-item table-item-content width_5\">")
                                                                .append("<select name=\"gv-cv\" style=\"text-align: center; min-width: 0\" class=\"select-covan\">");

                                                        // Sử dụng HashMap để lấy tài khoản
                                                        Tai_Khoan tkt = taiKhoanMap.get(sv.getId());
                                                        if (tkt != null) {
                                                            String selectedClassPresident = (tkt.getRulesID() == 4) ? "selected" : "";
                                                            String selectedStudent = (tkt.getRulesID() != 4) ? "selected" : "";
                                                            htmlOutput.append("<option value=\"1\" ").append(selectedClassPresident).append(">Lớp trưởng</option>")
                                                                    .append("<option value=\"2\" ").append(selectedStudent).append(">Sinh viên</option>");
                                                        }

                                                        htmlOutput.append("</select>")
                                                                .append("</li>");

                                                        // Kiểm tra trạng thái tài khoản
                                                        String status = (tkt != null && tkt.getStatus() == 1) ? "background: #42b72a" : "background: #f70d28";

                                                        htmlOutput.append("<li class=\"table-header-item table-item-content width_5\" style=\"justify-content: center\">")
                                                                .append("<a style=\"").append(status).append("; border-radius: 50%\" href=\"khoa_sinhvien")
                                                                .append("?khoaId=").append(selectedKhoaId)
                                                                .append("&lopId=").append(selectedLopId)
                                                                .append("&wrap=wrap").append(i)
                                                                .append("&lock=").append(sv.getId()).append("&opt=").append(selectedKhoaId)
                                                                .append("\" onclick=\"confirmLink(event, 'Xác nhận khóa/mở tài khoản này?')\" class=\"button button-lock\">")
                                                                .append("<svg class=\"edit_icon\" viewBox=\"0 0 24 24\"><path class=\"edit-icon-path\" d=\"M12 14.5V16.5M7 10.0288C7.47142 10 8.05259 10 8.8 10H15.2C15.9474 10 16.5286 10 17 10.0288M7 10.0288C6.41168 10.0647 5.99429 10.1455 5.63803 10.327C5.07354 10.6146 4.6146 11.0735 4.32698 11.638C4 12.2798 4 13.1198 4 14.8V16.2C4 17.8802 4 18.7202 4.32698 19.362C4.6146 19.9265 5.07354 20.3854 5.63803 20.673C6.27976 21 7.11984 21 8.8 21H15.2C16.8802 21 17.7202 21 18.362 20.673C18.9265 20.3854 19.3854 19.9265 19.673 19.362C20 18.7202 20 17.8802 20 16.2V14.8C20 13.1198 20 12.2798 19.673 11.638C19.3854 11.0735 18.9265 10.6146 18.362 10.327C18.0057 10.1455 17.5883 10.0647 17 10.0288M7 10.0288V8C7 5.23858 9.23858 3 12 3C14.7614 3 17 5.23858 17 8V10.0288\" /></svg>")
                                                                .append("</a>")
                                                                .append("</li>")
                                                                .append("<li class=\"table-header-item table-item-content width_7\">")
                                                                .append("<a href=\"khoa-sv?id=").append(sv.getId()).append("\" style=\"margin: 0px 4px; background: #dd5600\" class=\"button button-edit special\">")
                                                                .append("<svg class=\"edit_icon\" viewBox=\"0 0 24 24\"><path class=\"edit-icon-path\" d=\"M16.6725 16.6412L21 21M19 11C19 15.4183 15.4183 19 11 19C6.58172 19 3 15.4183 3 11C3 6.58172 6.58172 3 11 3C15.4183 3 19 6.58172 19 11Z\" /></svg>Xem</a>")
                                                                .append("<button onclick=\"confirmLink(event, 'Xác nhận lưu thông tin?')\" class=\"button button-edit\">")
                                                                .append("<svg class=\"save-icon\" version=\"1.1\" id=\"Layer_1\" viewBox=\"0 0 492.308 492.308\" xml:space=\"preserve\">")
                                                                .append("<g><g><path d=\"M330.784,0H32.264v300.611v64.514v127.183h427.779V129.255L330.784,0z M336.553,33.615l89.874,89.871h-89.874V33.615z M51.957,320.303h146l-53.548-53.548l17.769-17.769l83.885,83.88l-83.885,83.885l-17.769-17.774l53.548-53.543h-146V320.303z M440.351,472.615H51.957v-107.49h98.462l-33.856,33.851l45.615,45.62l111.731-111.731L162.178,221.139l-45.615,45.615l33.856,33.856H51.957V19.692h264.904v123.486h123.49V472.615z\"/></g></g>")
                                                                .append("</svg>Lưu</button>")
                                                                .append("<a href=\"khoa_sinhvien?wrap=wrap").append(i-1)
                                                                .append("&del=").append(sv.getId())
                                                                .append("&khoaId=").append(selectedKhoaId)
                                                                .append("&lopId=").append(selectedLopId)
                                                                .append("\" onclick=\"confirmLink(event, 'Xác nhận xóa sinh viên này?')\" class=\"button button-delete\">")
                                                                .append("<svg class=\"edit_icon\" viewBox=\"0 0 24 24\"><path class=\"edit-icon-path\" d=\"M10 11V17\" /><path class=\"edit-icon-path\" d=\"M14 11V17\" /><path class=\"edit-icon-path\" d=\"M4 7H20\" /><path class=\"edit-icon-path\" d=\"M6 7H12H18V18C18 19.6569 16.6569 21 15 21H9C7.34315 21 6 19.6569 6 18V7Z\" /><path class=\"edit-icon-path\" d=\"M9 5C9 3.89543 9.89543 3 11 3H13C14.1046 3 15 3.89543 15 5V7H9V5Z\" /></svg>Xóa</a>")
                                                                .append("</li>")
                                                                .append("</ul></form>");

                                                        i++;
                                                    }
                                                }

                                                // Ghi ra HTML cuối cùng
                                                out.print(htmlOutput.toString());
                                            }
                                        }
                                    %>

                                    <form id="open" style="display:none" action="khoa_sinhvien" method="get" onsubmit="return validateForm()">
                                        <ul  id ="wrap<%=i%>" class="table-header-list">
                                            <input name="wrap" value="wrap<%=i%>" type="hidden">
                                            <li class="table-header-item table-item-content width_1">
                                                <span class="button none-button width_1 width_text"><%= i%></span>
                                            </li>
                                            <li class="table-header-item table-item-content width_2">
                                                <input id="maKhoa" name="msv" class="button none-button width_2 width_text" placeholder="Mã sinh viên">
                                            </li>
                                            <li class="table-header-item table-item-content width_3 padding-title">
                                                <input id="tenKhoa" name ="hoten" class="button none-button width_3 width_text" placeholder="Họ và tên">
                                            </li>
                                            <li class="table-header-item table-item-content width_4">
                                                <select  name ="lopsv" class="select-covan">
                                                    <%
                                                        lopList = (ArrayList<Lop>) request.getAttribute("lopList");

                                                        // Kiểm tra nếu khoaList không null
                                                        if (lopList != null) {
                                                            for (Lop lop : lopList) {

                                                    %>
                                                    <option value="<%=lop.getId()%>"><%=lop.getTen()%></option>
                                                    <%
                                                            }
                                                        }
                                                    %>
                                                </select>
                                            </li>
                                            <li class="table-header-item table-item-content width_5">
                                                <select name="chucvu" style="text-align: center; min-width: 0"name ="gv-khoa" class="select-covan">

                                                    <option value="a" >Lớp trưởng</option>
                                                    <option value="b">Sinh viên</option>
                                                </select>
                                            </li>


                                            <li class="table-header-item table-item-content width_5" style="justify-content: center">

                                                <a  style="background: #42b72a; border-radius: 50%" 
                                                    class="button button-lock">
                                                    <svg class="edit_icon" viewBox="0 0 24 24">
                                                    <path class="edit-icon-path"
                                                          d="M12 14.5V16.5M7 10.0288C7.47142 10 8.05259 10 8.8 10H15.2C15.9474 10 16.5286 10 17 10.0288M7 10.0288C6.41168 10.0647 5.99429 10.1455 5.63803 10.327C5.07354 10.6146 4.6146 11.0735 4.32698 11.638C4 12.2798 4 13.1198 4 14.8V16.2C4 17.8802 4 18.7202 4.32698 19.362C4.6146 19.9265 5.07354 20.3854 5.63803 20.673C6.27976 21 7.11984 21 8.8 21H15.2C16.8802 21 17.7202 21 18.362 20.673C18.9265 20.3854 19.3854 19.9265 19.673 19.362C20 18.7202 20 17.8802 20 16.2V14.8C20 13.1198 20 12.2798 19.673 11.638C19.3854 11.0735 18.9265 10.6146 18.362 10.327C18.0057 10.1455 17.5883 10.0647 17 10.0288M7 10.0288V8C7 5.23858 9.23858 3 12 3C14.7614 3 17 5.23858 17 8V10.0288" />
                                                    </svg>

                                                </a>

                                            </li>
                                            <li class="table-header-item table-item-content width_7">

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
                                                <a href="khoa_sinhvien?wrap=wrap<%=i%>" 
                                                   onclick="confirmLink(event, 'Xác nhận xóa giảng viên này?')" class="button button-delete">
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
                                <li id="my-template8">

                                </li>

                            </ul>


                        </div>
                    </div>

                </div>

            </div>

        </div>
        <%                                            String wrap = request.getParameter("wrap");
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
                openElement.style.display = "block";

                // Cuộn đến phần tử
                openElement.scrollIntoView({behavior: "smooth", block: "start"});
                // Lấy input bên trong và đặt focus để hiển thị con trỏ
                const inputElement = openElement.querySelector("input");
                inputElement.focus();
            }

            function validateForm() {
                const maKhoa = document.getElementById("maKhoa").value.trim();
                const tenKhoa = document.getElementById("tenKhoa").value.trim();


                if (maKhoa === "" || tenKhoa === "") {
                    alert("Vui lòng nhập đầy đủ thông tin.");
                    return false; // Ngăn form gửi
                }
                confirmLink(event, 'Xác nhận thêm?');
                return true; // Cho phép gửi form nếu tất cả các ô đã được điền
            }
            function validateForm2() {
                // Lấy tất cả các input trong form
                const inputs = document.querySelectorAll("input[type='text'], input[type='date']");

                // Kiểm tra từng input
                for (let input of inputs) {
                    if (input.value.trim() === "") {
                        alert("Vui lòng nhập đủ thông tin.");
                        return false; // Ngăn form gửi nếu bất kỳ input nào trống
                    }
                }

                return true; // Cho phép gửi form nếu tất cả các ô đã được điền
            }




        </script>
        <style>
            .special{
                background: #0866ff;
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



    </body>

</html>
