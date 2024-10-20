<%@page import="com.drl.daos.Khoa_dao"%>
<%@page import="com.drl.models.Khoa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.drl.models.Giang_Vien"%>
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
                <a href="#back-to-top" class="jscroll-to-top_link"></i></a>
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
                                        class="account_name">N21DCAT006</span></a>
                            </li>
                            <li class="account_item ">
                                <a class="login_form_line login_form_line_second">Họ & tên: <span class="account_name">Ngô
                                        Ngọc Minh Châu</span></a>
                            </li>
                            <li>
                                <a
                                    href="https://www.facebook.com/people/Ch%C3%A2u-Ng%C3%B4/pfbid0oi51UWstqAApJpwRwYoWwZTQc8CNP3LYvPXXe3E3gqtddVNPscRFDQH8LrK2Nfz9l/">
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
                        </ul>



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

                    <!--Cố vấn-->
                    <div class="main_content_home table_class_home table_covan">
                        <div class="main_title_wrap">
                            <div class="title_icon">
                                <div>
                                    <h5 class="main-title">
                                        <svg class="icon-title-main fill" version="1.1" id="Layer_1"
                                             viewBox="0 0 512.001 512.001" xml:space="preserve">
                                        <g>
                                        <g>
                                        <g>
                                        <path
                                            d="M167.331,277.436c-3.694,2.138-4.406,7.163-1.388,10.181l85.499,85.499c2.52,2.52,6.603,2.52,9.123,0l85.499-85.499     c3.018-3.018,2.304-8.043-1.388-10.181C289.939,245.762,222.163,245.706,167.331,277.436z" />
                                        <path
                                            d="M377.312,301.682c-2.54-2.379-6.518-2.304-8.979,0.156L265.125,405.046c-5.04,5.038-13.206,5.038-18.247,0     L143.67,301.838c-2.46-2.46-6.438-2.535-8.979-0.156c-34.619,32.427-56.286,78.522-56.286,129.585v61.38     c0,10.688,8.665,19.353,19.353,19.353h316.485c10.688,0,19.353-8.665,19.353-19.353v-61.38     C433.597,380.204,411.931,334.109,377.312,301.682z" />
                                        <path
                                            d="M156.128,238.41c8.766,0,190.985,0,199.749,0c10.688,0,19.353-8.665,19.353-19.353v-99.875c0-0.001,0-0.001,0-0.003     c0-59.951-44.512-109.95-102.162-118.001h0.001C200.133-8.925,136.775,47.24,136.775,119.179c0,0.001,0,0.001,0,0.003v99.875     C136.775,229.745,145.438,238.41,156.128,238.41z M194.516,67.249c28.69,48.508,88.914,70.303,142.006,51.506     c0.001,0.141,0.001,0.283,0.001,0.424c0,44.4-36.122,80.521-80.521,80.521c-44.4,0-80.522-36.122-80.522-80.521     C175.481,99.842,182.474,81.523,194.516,67.249z" />
                                        </g>
                                        </g>
                                        </g>
                                        </svg><span class="title-text margin_title2">Cố vấn
                                        </span>

                                    </h5>
                                </div>
                            </div>
                        </div>
                        <div class="main-table-wrap">
                            <form class="form-table" action="">
                                <div class="main-table-title-wrap">
                                    <h1 class="main-table-title">Danh sách các cố vấn

                                    </h1>
                                    <div class="main-table-button"> <!--Thêm xóa sửa balabala-->
                                        <select id="mySelect" autofocus">
                                            <c:forEach var="khoa" items="${khoaList}">
                                                <option value="${khoa.id}">
                                                <a class="option-link" href="#"><c:out value="${khoa.ten}"/></a>
                                                </option>
                                            </c:forEach>
                                        </select>
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
                                                Mã cố vấn
                                            </li>
                                            <li class="table-header-item width_3 padding-title">
                                                Tên cố vấn
                                            </li>
                                            <li class="table-header-item width_4 padding-title">
                                                Khoa
                                            </li>
                                            <li class="table-header-item width_5">
                                                Trạng thái
                                            </li>
                                            <li class="table-header-item width_6">
                                                Thao tác
                                            </li>
                                        </ul>
                                    </li>
                                    <!--dùng vòng lặp-->
                                    <div class="table-content-wrap">
                                        <li id="original-div6" class="main-table-item">
                                            <%
                                                int i =1;
                                                ArrayList<Giang_Vien> gvList = (ArrayList<Giang_Vien>) request.getAttribute("gvList");
                                                if (gvList != null) {
                                                    for (Giang_Vien gv : gvList) {
                                            %>
                                            <ul class="table-header-list">
                                                <li class="table-header-item table-item-content width_1">
                                                    <span class="button none-button width_1 width_text"><%= i %></span>
                                                </li>
                                                <li class="table-header-item table-item-content width_2">
                                                    <span class="button none-button width_2 width_text"><%=gv.getId()%></span>
                                                </li>
                                                <li class="table-header-item table-item-content width_3 padding-title">
                                                    <span class="button none-button width_3 width_text"><%=gv.getHoTen()%></span>
                                                </li>
                                                <li class="table-header-item table-item-content width_4 padding-title">
                                                    <%
                                                        Khoa khoa = new Khoa_dao().getKhoa_by_ID(gv.getKhoaID());
                                                        %>
                                                    <span class="button none-button width_4 width_text"><%=khoa.getTen()%></span>
                                                </li>
                                                <li class="table-header-item table-item-content width_5">
                                                    <%
                                                        String status = "Đã khóa";
                                                        if(khoa.getStatus() == 1){
                                                            status = "Hoạt động";
                                                        }
                                                        
                                                        %>
                                                    <span class="button none-button width_5 width_text"><%= status %></span>
                                                </li>
                                                <li class="table-header-item table-item-content width_6">
                                                    <a href="" class="button button-lock">
                                                        <svg class="edit_icon" viewBox="0 0 24 24">
                                                        <path class="edit-icon-path"
                                                              d="M12 14.5V16.5M7 10.0288C7.47142 10 8.05259 10 8.8 10H15.2C15.9474 10 16.5286 10 17 10.0288M7 10.0288C6.41168 10.0647 5.99429 10.1455 5.63803 10.327C5.07354 10.6146 4.6146 11.0735 4.32698 11.638C4 12.2798 4 13.1198 4 14.8V16.2C4 17.8802 4 18.7202 4.32698 19.362C4.6146 19.9265 5.07354 20.3854 5.63803 20.673C6.27976 21 7.11984 21 8.8 21H15.2C16.8802 21 17.7202 21 18.362 20.673C18.9265 20.3854 19.3854 19.9265 19.673 19.362C20 18.7202 20 17.8802 20 16.2V14.8C20 13.1198 20 12.2798 19.673 11.638C19.3854 11.0735 18.9265 10.6146 18.362 10.327C18.0057 10.1455 17.5883 10.0647 17 10.0288M7 10.0288V8C7 5.23858 9.23858 3 12 3C14.7614 3 17 5.23858 17 8V10.0288" />
                                                        </svg>
                                                        Khóa/Mở
                                                    </a>
                                                    <a href="" class="button button-edit">
                                                        <svg class="edit_icon" viewBox="0 0 24 24">
                                                        <path class="edit-icon-path" d=" M16.6725 16.6412L21 21M19 11C19 15.4183 15.4183 19 11
                                                              19C6.58172 19 3 15.4183 3 11C3 6.58172 6.58172 3 11 3C15.4183 3 19
                                                              6.58172 19 11Z" />
                                                        </svg>
                                                        Xem
                                                    </a>
                                                    <a href="" class="button button-delete">
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
                                            <%
                                                    }
                                                }
                                            %>
                                        </li>

                                    </div>

                                </ul>
                            </form>

                        </div>
                    </div>
                </div>
            </div>


            <!--Footter-->
        </div>

    </body>

</html>
