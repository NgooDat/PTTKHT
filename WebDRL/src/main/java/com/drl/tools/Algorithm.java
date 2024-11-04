package com.drl.tools;

public class Algorithm {

    public static String getIdseValue(String url) {
        // Kiểm tra xem chuỗi có chứa "&idse=" không
        int startIndex = url.indexOf("&idse=");
        if (startIndex != -1) {
            // Tính toán vị trí bắt đầu của giá trị idse
            startIndex += "&idse=".length();

            // Tìm vị trí kết thúc của giá trị idse
            int endIndex = url.indexOf("&idlop=", startIndex);
            if (endIndex != -1) {
                // Trả về giá trị idse
                return url.substring(startIndex, endIndex);
            }
        }
        return null; // Nếu không tìm thấy, trả về null
    }

    public static String getUsernameFromEmail(String email) {
        if (email == null || !email.contains("@")) {
            return null; // Trả về null nếu email không hợp lệ
        }
        return email.substring(0, email.indexOf("@"));
    }

}
