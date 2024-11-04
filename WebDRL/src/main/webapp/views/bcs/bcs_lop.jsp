<%@page import="java.util.UUID"%>
<%@page import="com.drl.models.Thong_Bao"%>
<%@page import="com.drl.daos.Lop_dao"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.drl.models.Lop"%>
<%@page import="com.drl.models.Khoa"%>
<%@page import="com.drl.daos.Sinh_Vien_dao"%>
<%@page import="com.drl.models.Sinh_Vien"%>
<%@page import="com.drl.models.DRL"%>
<%@page import="com.drl.daos.DRL_dao"%>
<%@page import="com.drl.models.Giang_Vien"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.drl.daos.DRL_dao" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                    <!--Duyệt điểm-->
                    <div class="main_content_home table_class_home table_drl">
                        <div class="main_title_wrap">
                            <div class="title_icon">
                                <div>
                                    <h5 class="main-title">
                                        <svg class="icon-title-main icon-trans" viewBox="0 0 64 64" stroke-width="5"
                                             stroke="#fff" fill="none">
                                        <path
                                            d="M55.5,23.9V53.5a2,2,0,0,1-2,2h-43a2,2,0,0,1-2-2v-43a2,2,0,0,1,2-2H41.64" />
                                        <path
                                            d="M19.48,38.77l-.64,5.59a.84.84,0,0,0,.92.93l5.56-.64a.87.87,0,0,0,.5-.24L54.9,15.22a1.66,1.66,0,0,0,0-2.35L51.15,9.1a1.67,1.67,0,0,0-2.36,0L19.71,38.28A.83.83,0,0,0,19.48,38.77Z" />
                                        <line x1="44.87" y1="13.04" x2="50.9" y2="19.24" />
                                        </svg><span class="title-text margin_title2">Duyệt điểm
                                        </span>

                                    </h5>
                                </div>

                            </div>
                        </div>
                        <div class="main-table-wrap">
                            <form class="form-table" action="">
                                <div class="main-table-title-wrap">
                                    <h1 class="main-table-title">Danh sách cần duyệt

                                    </h1>
                                    <div class="main-table-button"> <!--Thêm xóa sửa balabala-->

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
                                                Điểm cá nhân
                                            </li>
                                            <li class="table-header-item width_5">
                                                Điểm cán sự
                                            </li>
                                            <li class="table-header-item width_6">
                                                Điểm cố vấn
                                            </li>
                                            <li class="table-header-item width_7">
                                                Thao tác
                                            </li>
                                        </ul>
                                    </li>
                                    <!--dùng vòng lặp-->
                                    <li class="table-content-wrap">
                                        <div id="original-div9" class="main-table-item">
                                            <%
                                                int i = 1;
                                                // Lấy danh sách DRL từ request attribute hoặc trực tiếp gọi hàm
                                                Object obj = request.getAttribute("drlList");
                                                if (obj instanceof List<?>) {
                                                    List<?> drlList = (List<?>) obj;
                                                    if (drlList != null && !drlList.isEmpty()) {
                                                        // Lấy tất cả sinh viên một lần và lưu vào map
                                                        Map<String, Sinh_Vien> svMap = new HashMap<String, Sinh_Vien>();
                                                        List<Sinh_Vien> allSV = new Sinh_Vien_dao().getAllSV(); // Giả sử phương thức này tồn tại
                                                        for (Sinh_Vien sv : allSV) {
                                                            svMap.put(sv.getId(), sv);
                                                        }

                                                        StringBuilder htmlOutput = new StringBuilder();
                                                        for (Object o : drlList) {
                                                            if (o instanceof DRL) {
                                                                DRL drl = (DRL) o;
                                                                Sinh_Vien sv = svMap.get(drl.getSinhVienID()); // Lấy sinh viên từ map
                                                                String name = (sv != null) ? sv.getHoTen() : "Không tìm thấy sinh viên"; // Xử lý trường hợp sinh viên không tồn tại

                                                                // Bắt đầu hiển thị dữ liệu
                                                                htmlOutput.append("<ul id=\"wrap").append(i).append("\" class=\"table-header-list\">");

                                                                htmlOutput.append("<li class=\"table-header-item table-item-content width_1\"><span class=\"button none-button width_1 width_text\">").append(i).append("</span></li>");
                                                                htmlOutput.append("<li class=\"table-header-item table-item-content width_2\"><span class=\"button none-button width_2 width_text\">").append(drl.getSinhVienID()).append("</span></li>");
                                                                htmlOutput.append("<li class=\"table-header-item table-item-content width_3 padding-title\"><span class=\"button none-button width_3 width_text\">").append(name).append("</span></li>");
                                                                htmlOutput.append("<li class=\"table-header-item table-item-content width_4\"><span class=\"button none-button width_4 width_text\">").append(drl.getDiemSV()).append("</span></li>");
                                                                htmlOutput.append("<li class=\"table-header-item table-item-content width_5\"><span class=\"button none-button width_5 width_text\">").append(drl.getDiemCS()).append("</span></li>");
                                                                htmlOutput.append("<li class=\"table-header-item table-item-content width_6\"><span class=\"button none-button width_5 width_text\">").append(drl.getDiemCV()).append("</span></li>");

                                                                int status = drl.getStatus();
                                                                htmlOutput.append("<li class=\"table-header-item table-item-content width_7\">");
                                                                if (status < 5) {
                                                                    htmlOutput.append("<a onclick=\"return kiemTraThoiGian()\" href=\"bcs-chamdiem?id=")
                                                                            .append(drl.getSinhVienID())
                                                                            .append("&idlop=")
                                                                            .append(tesv.getLopID())
                                                                            .append("&hk=")
                                                                            .append(drl.getHkNkID())
                                                                            .append("&wrapId=wrap")
                                                                            .append(i)
                                                                            .append("\" class=\"button button-edit\">Chấm điểm</a>");

                                                                } else if (status == 5) {
                                                                    htmlOutput.append("Đã duyệt");
                                                                }
                                                                htmlOutput.append("</li>");
                                                                htmlOutput.append("</ul>");

                                                                i++;
                                                            }
                                                        }

                                                        // Xuất toàn bộ HTML đã tạo
                                                        out.print(htmlOutput.toString());
                                                    }
                                                }
                                            %>

                                        </div>

                                    </li>


                                </ul>
                            </form>

                        </div>
                    </div>

                </div>
            </div>

        </div>
        <%
            Thong_Bao tb = (Thong_Bao) request.getAttribute("thongbao");
            java.util.Date ngayBD = tb.getNgayKT_SV();
            java.util.Date ngayKT_SV = tb.getNgayKT_CS();
            java.util.Date ngayHienTai = new java.util.Date();

            // Kiểm tra ngày hiện tại có nằm trong khoảng [ngayBD, ngayKT_SV] không, bao gồm cả 2 ngày biên
            boolean trongThoiGian = ngayHienTai.after(ngayBD) && !ngayHienTai.after(ngayKT_SV);
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
        </script>


        <%
            String wrap = (String) request.getAttribute("wrap");
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
        </script>

    </body>

</html>
