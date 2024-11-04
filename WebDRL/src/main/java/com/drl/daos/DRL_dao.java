package com.drl.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.drl.models.DRL;
import com.drl.models.HK_NK;
import com.drl.models.Khoa_Hoc;
import com.drl.models.Lop;
import com.drl.models.Sinh_Vien;
import com.drl.models.Tieu_Chi;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class DRL_dao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //lay DRL theo mã sv
    public List<DRL> getDRL_by_SinhVienID(String id) {
        List<DRL> drlList = new ArrayList<>();
        String query = "SELECT * FROM DRL WHERE Sinh_VienID = ?";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                DRL drl = new DRL(rs.getInt("ID"),
                        rs.getInt("diemSV"),
                        rs.getInt("diemCS"),
                        rs.getInt("diemCV"),
                        rs.getInt("status"),
                        rs.getString("Sinh_VienID"),
                        rs.getInt("HK_NKID"));
                drlList.add(drl);
            }
        } catch (SQLException e) {
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
        return drlList;
    }

    public List<DRL> getAllDRL_SV_HK(String sinhVienId, int hkNkId) {
        List<DRL> drlList = new ArrayList<>();
        String query = "SELECT * FROM DRL WHERE Sinh_VienID = ? AND HK_NKID = ?";

        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, sinhVienId);
            ps.setInt(2, hkNkId);
            rs = ps.executeQuery();

            while (rs.next()) {
                DRL drl = new DRL(
                        rs.getInt("ID"),
                        rs.getInt("diemSV"),
                        rs.getInt("diemCS"),
                        rs.getInt("diemCV"),
                        rs.getInt("status"),
                        rs.getString("Sinh_VienID"),
                        rs.getInt("HK_NKID"),
                        rs.getInt("Tieu_ChiId")
                );
                drlList.add(drl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return drlList;
    }

    public List<DRL> getDRL_by_SinhVienID_HK(String id) {
        List<DRL> drlList = new ArrayList<>();
        String query = "SELECT HK_NKID, SUM(diemSV) AS totalDiemSV, SUM(diemCS) AS totalDiemCS, "
                + "SUM(diemCV) AS totalDiemCV, Sinh_VienID "
                + "FROM DRL WHERE Sinh_VienID = ? GROUP BY HK_NKID, Sinh_VienID";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                DRL drl = new DRL(
                        0, // Giả định ID không cần thiết vì chúng ta đang nhóm
                        rs.getInt("totalDiemSV"),
                        rs.getInt("totalDiemCS"),
                        rs.getInt("totalDiemCV"),
                        0, // Giả định status không cần thiết vì không có trong truy vấn
                        rs.getString("Sinh_VienID"),
                        rs.getInt("HK_NKID")
                );
                drlList.add(drl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return drlList;
    }

    public static List<DRL> getAllDRL() throws InterruptedException, ExecutionException {
        List<DRL> drlList = new ArrayList<>();
        String query = "SELECT * FROM DRL"; // Truy vấn để lấy tất cả các bản ghi
        try (Connection conn = DBConnect.getConnection(); PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int diemSV = rs.getInt("diemSV");
                if (rs.wasNull()) {
                    diemSV = 0; // Nếu diemSV là NULL, gán bằng 0
                }
                int diemCS = rs.getInt("diemCS");
                if (rs.wasNull()) {
                    diemCS = 0; // Nếu diemCS là NULL, gán bằng 0
                }
                int diemCV = rs.getInt("diemCV");
                if (rs.wasNull()) {
                    diemCV = 0; // Nếu diemCV là NULL, gán bằng 0
                }
                DRL drl = new DRL(
                        rs.getInt("ID"),
                        diemSV,
                        diemCS,
                        diemCV,
                        rs.getInt("status"),
                        rs.getString("Sinh_VienID"),
                        rs.getInt("HK_NKID")
                );

                drlList.add(drl);
            }
        } catch (SQLException e) {
            // In ra lỗi nếu có

        }
        return drlList;
    }

    public static DRL getDRLOne(String sinhVienId, int hkNkID) throws InterruptedException, ExecutionException {
        // Khởi tạo các biến tổng điểm
        int totalDiemSV = 0;
        int totalDiemCS = 0;
        int totalDiemCV = 0;

        new DRL_dao();
		// Lấy danh sách DRL từ cơ sở dữ liệu
        ArrayList<DRL> dsDRL = (ArrayList<DRL>) DRL_dao.getAllDRL(); // Giả sử phương thức này lấy tất cả DRL từ DB

        // Duyệt qua danh sách DRL
        for (DRL drl : dsDRL) {
            // Kiểm tra xem DRL có thuộc sinh viên và học kỳ được chỉ định không
            if (drl.getSinhVienID().equals(sinhVienId) && drl.getHkNkID() == hkNkID) {
                // Cộng dồn các điểm tương ứng
                totalDiemSV += drl.getDiemSV();
                totalDiemCS += drl.getDiemCS();
                totalDiemCV += drl.getDiemCV();
            }
        }

        // Tạo một đối tượng DRL mới để trả về tổng điểm
        DRL totalDRL = new DRL();
        totalDRL.setSinhVienID(sinhVienId);
        totalDRL.setHkNkID(hkNkID);
        totalDRL.setDiemSV(totalDiemSV);
        totalDRL.setDiemCS(totalDiemCS);
        totalDRL.setDiemCV(totalDiemCV);

        return totalDRL;
    }

    public void updateScoresToZero(String sinhVienId, int hkNkId) {
        String sql = "UPDATE DRL SET diemSV = 0, diemCS = 0, diemCV = 0 WHERE sinh_VienID = ? AND hk_NkID = ?";

        try (Connection conn22 = DBConnect.getConnection(); // Thay thế bằng phương thức lấy kết nối của bạn
                 PreparedStatement pstmt = conn22.prepareStatement(sql)) {

            pstmt.setString(1, sinhVienId);  // Set giá trị cho sinhVienID
            pstmt.setInt(2, hkNkId);         // Set giá trị cho hkNkID

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cập nhật điểm về 0 thành công.");
            } else {
                System.out.println("Không tìm thấy bản ghi để cập nhật.");
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ theo nhu cầu của bạn

        }
    }

    public static List<DRL> getAllDRLWithTotal(int hkid) throws InterruptedException, ExecutionException {
        List<DRL> drlTotalList = new ArrayList<>();

        // Lấy tất cả sinh viên và DRL một lần duy nhất
        ArrayList<Sinh_Vien> dsSV = (ArrayList<Sinh_Vien>) new Sinh_Vien_dao().getAllSV();
        ArrayList<HK_NK> dsHK = (ArrayList<HK_NK>) new HK_NK_dao().getAllHK_NK();
        ArrayList<DRL> dsDRL = (ArrayList<DRL>) DRL_dao.getAllDRL();

        for (HK_NK hk : dsHK) {
            for (Sinh_Vien sv : dsSV) {
                int diem1 = 0, diem2 = 0, diem3 = 0;
                int status = 1;
                boolean flag = false;

                for (DRL drl : dsDRL) {
                    if (drl.getHkNkID() == hkid && drl.getSinhVienID().equals(sv.getId()) && drl.getHkNkID() == hk.getId()) {
                        diem1 += drl.getDiemSV();
                        diem2 += drl.getDiemCS();
                        diem3 += drl.getDiemCV();
                        status = drl.getStatus();
                        flag = true;
                    }
                }

                if (flag) {
                    DRL drl = new DRL();
                    drl.setSinhVienID(sv.getId());
                    drl.setDiemCS(diem2);
                    drl.setDiemCV(diem3);
                    drl.setDiemSV(diem1);
                    drl.setStatus(status);
                    drl.setHkNkID(hk.getId());
                    drlTotalList.add(drl);
                }
            }
        }

        return drlTotalList;
    }

    public void updateStatus(int status, String sinhVienId, int hkNkId) {
        String sql = "UPDATE DRL SET status = ? WHERE sinh_VienID = ? AND hk_NkID = ?";

        try (Connection c2 = DBConnect.getConnection(); // Thay thế bằng phương thức lấy kết nối của bạn
                 PreparedStatement pstmt = c2.prepareStatement(sql)) {

            pstmt.setInt(1, status);         // Set giá trị cho status
            pstmt.setString(2, sinhVienId);  // Set giá trị cho sinhVienID
            pstmt.setInt(3, hkNkId);         // Set giá trị cho hkNkID

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cập nhật status thành công.");
            } else {
                System.out.println("Không tìm thấy bản ghi để cập nhật.");
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ theo nhu cầu của bạn

        }
    }

    public static List<DRL> getAllDRLWithTotal_Lop(int hkid, String lop) throws InterruptedException, ExecutionException {
        List<DRL> drlTotalList = new ArrayList<>();

        // Lấy tất cả sinh viên và DRL một lần duy nhất
        ArrayList<Sinh_Vien> dsSV = (ArrayList<Sinh_Vien>) new Sinh_Vien_dao().getAllSV();
        ArrayList<HK_NK> dsHK = (ArrayList<HK_NK>) new HK_NK_dao().getAllHK_NK();
        ArrayList<DRL> dsDRL = (ArrayList<DRL>) DRL_dao.getAllDRL();

        // Ánh xạ sinh viên theo lớp để giảm truy vấn trong vòng lặp
        Map<String, Sinh_Vien> sinhVienLopMap = dsSV.stream()
                .filter(sv -> sv.getLopID().equals(lop))
                .collect(Collectors.toMap(Sinh_Vien::getId, sv -> sv));

        for (HK_NK hk : dsHK) {
            for (Sinh_Vien sv : dsSV) {
                if (!sinhVienLopMap.containsKey(sv.getId())) {
                    continue;
                }

                int diem1 = 0, diem2 = 0, diem3 = 0;
                int status = 1;
                boolean flag = false;

                for (DRL drl : dsDRL) {
                    if (drl.getHkNkID() == hkid && drl.getSinhVienID().equals(sv.getId()) && drl.getHkNkID() == hk.getId()) {
                        diem1 += drl.getDiemSV();
                        diem2 += drl.getDiemCS();
                        diem3 += drl.getDiemCV();
                        status = drl.getStatus();
                        flag = true;
                    }
                }

                if (flag) {
                    DRL drl = new DRL();
                    drl.setSinhVienID(sv.getId());
                    drl.setDiemCS(diem2);
                    drl.setDiemCV(diem3);
                    drl.setDiemSV(diem1);
                    drl.setStatus(status);
                    drl.setHkNkID(hk.getId());
                    drlTotalList.add(drl);
                }
            }
        }

        return drlTotalList;
    }

    public static List<DRL> getAllDRLWithTotal_Khoa(int hkid, String khoa) throws InterruptedException, ExecutionException {
        List<DRL> drlTotalList = new ArrayList<>();

        // Lấy tất cả sinh viên và DRL một lần duy nhất
        ArrayList<Sinh_Vien> dsSV = (ArrayList<Sinh_Vien>) new Sinh_Vien_dao().getAllSV();
        ArrayList<DRL> dsDRL = (ArrayList<DRL>) DRL_dao.getAllDRL();
        ArrayList<Lop> dsLop = (ArrayList<Lop>) new Lop_dao().getAllLop();

        // Ánh xạ lớp theo khoa
        Map<String, Lop> lopKhoaMap = dsLop.stream()
                .filter(l -> l.getKhoaID().equals(khoa))
                .collect(Collectors.toMap(Lop::getId, lop -> lop));

        // Map để lưu tổng điểm cho mỗi SinhVienID và HkNkID
        Map<String, DRL> drlMap = new HashMap<>();

        for (Sinh_Vien sv : dsSV) {
            // Bỏ qua nếu sinh viên không thuộc khoa yêu cầu
            if (!lopKhoaMap.containsKey(sv.getLopID())) {
                continue;
            }

            for (DRL drl : dsDRL) {
                if (drl.getHkNkID() == hkid && drl.getSinhVienID().equals(sv.getId())) {
                    // Khóa cho Map là sự kết hợp giữa SinhVienID và HkNkID
                    String key = sv.getId() + "-" + hkid;

                    // Kiểm tra xem đã có dữ liệu cho khóa này chưa
                    DRL drlTotal = drlMap.getOrDefault(key, new DRL());

                    // Nếu là đối tượng mới, thiết lập các giá trị ban đầu
                    if (drlTotal.getSinhVienID() == null) {
                        drlTotal.setSinhVienID(sv.getId());
                        drlTotal.setHkNkID(hkid);
                        drlTotal.setDiemCS(0);
                        drlTotal.setDiemCV(0);
                        drlTotal.setDiemSV(0);
                        drlTotal.setStatus(drl.getStatus());
                    }

                    // Cộng dồn điểm
                    drlTotal.setDiemCS(drlTotal.getDiemCS() + drl.getDiemCS());
                    drlTotal.setDiemCV(drlTotal.getDiemCV() + drl.getDiemCV());
                    drlTotal.setDiemSV(drlTotal.getDiemSV() + drl.getDiemSV());

                    // Cập nhật lại Map
                    drlMap.put(key, drlTotal);
                }
            }
        }

        // Chuyển đổi Map thành List kết quả
        drlTotalList.addAll(drlMap.values());

        return drlTotalList;
    }

    //lay drl theo HK_NKID
    public List<DRL> getDRL_by_HK_NKID(int hkNkID) {
        List<DRL> drlList = new ArrayList<>();
        String query = "SELECT * FROM DRL WHERE HK_NKID = ?";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, hkNkID);
            rs = ps.executeQuery();
            while (rs.next()) {
                DRL drl = new DRL(rs.getInt("ID"),
                        rs.getInt("diemSV"),
                        rs.getInt("diemCS"),
                        rs.getInt("diemCV"),
                        rs.getInt("status"),
                        rs.getString("Sinh_VienID"),
                        rs.getInt("HK_NKID"));
                drlList.add(drl);
            }
        } catch (SQLException e) {
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
        return drlList;
    }

    //lay DRL theo status
    public List<DRL> getDRL_by_status(int status) {
        List<DRL> drlList = new ArrayList<>();
        String query = "SELECT * FROM DRL WHERE status = ?";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, status);
            rs = ps.executeQuery();
            while (rs.next()) {
                DRL drl = new DRL(rs.getInt("ID"),
                        rs.getInt("diemSV"),
                        rs.getInt("diemCS"),
                        rs.getInt("diemCV"),
                        rs.getInt("status"),
                        rs.getString("Sinh_VienID"),
                        rs.getInt("HK_NKID"));
                drlList.add(drl);
            }
        } catch (SQLException e) {
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
        return drlList;
    }

    //lay drl theo id
    public DRL getDRL_by_ID(int id) {
        DRL drl = null;
        String query = "SELECT * FROM DRL WHERE ID = ?";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                drl = new DRL(rs.getInt("ID"),
                        rs.getInt("diemSV"),
                        rs.getInt("diemCS"),
                        rs.getInt("diemCV"),
                        rs.getInt("status"),
                        rs.getString("Sinh_VienID"),
                        rs.getInt("HK_NKID"));
            }
        } catch (SQLException e) {
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
        return drl;
    }

    public void addDRLwithHK(HK_NK hk) {
        Sinh_Vien_dao sinhVienDao = new Sinh_Vien_dao();
        Lop_dao lopDao = new Lop_dao();
        Khoa_Hoc_dao khoaHocDao = new Khoa_Hoc_dao();
        Tieu_Chi_dao tieuChiDao = new Tieu_Chi_dao();

        ArrayList<Sinh_Vien> dsSV = (ArrayList<Sinh_Vien>) sinhVienDao.getAllSV();
        ArrayList<Tieu_Chi> dsTc = (ArrayList<Tieu_Chi>) tieuChiDao.getAllTieuChi();

        Map<String, Lop> lopMap = new HashMap<>();
        Map<Integer, Khoa_Hoc> khoaHocMap = new HashMap<>();

        String[] parts = hk.getNienKhoa().split("-");
        int namBD = Integer.parseInt(parts[0]);
        int namKT = Integer.parseInt(parts[1]);

        for (Sinh_Vien sv : dsSV) {

            Lop lop = lopMap.computeIfAbsent(sv.getLopID(), lopDao::getLop_by_ID);

            Khoa_Hoc kh = khoaHocMap.computeIfAbsent(lop.getKhoaHocID(), khoaHocDao::getKhoaHoc_by_ID);

            if (kh.getNamBD() <= namBD && kh.getNamKT() >= namKT) {
                for (Tieu_Chi tc : dsTc) {
                    DRL drl = new DRL();
                    drl.setHkNkID(hk.getId());
                    drl.setSinhVienID(sv.getId());
                    drl.setStatus(5);
                    drl.setTieu_ChiId(tc.getId());
                    drl.setDiemCS(0);
                    drl.setDiemCV(0);
                    drl.setDiemSV(0);
                    addDRL(drl);  // Lưu DRL vào cơ sở dữ liệu
                }
            }
        }
    }

    public void addDRLwithTC(Tieu_Chi tc, HK_NK hk) {
        Sinh_Vien_dao sinhVienDao = new Sinh_Vien_dao();
        Lop_dao lopDao = new Lop_dao();
        Khoa_Hoc_dao khoaHocDao = new Khoa_Hoc_dao();

        ArrayList<Sinh_Vien> dsSV = (ArrayList<Sinh_Vien>) sinhVienDao.getAllSV();

        Map<String, Lop> lopMap = new HashMap<>();
        Map<Integer, Khoa_Hoc> khoaHocMap = new HashMap<>();

        String[] parts = hk.getNienKhoa().split("-");
        int namBD = Integer.parseInt(parts[0]);
        int namKT = Integer.parseInt(parts[1]);

        for (Sinh_Vien sv : dsSV) {

            Lop lop = lopMap.computeIfAbsent(sv.getLopID(), lopDao::getLop_by_ID);

            Khoa_Hoc kh = khoaHocMap.computeIfAbsent(lop.getKhoaHocID(), khoaHocDao::getKhoaHoc_by_ID);

            if (kh.getNamBD() <= namBD && kh.getNamKT() >= namKT) {
                DRL drl = new DRL();
                drl.setHkNkID(hk.getId());
                drl.setSinhVienID(sv.getId());
                drl.setStatus(5);
                drl.setTieu_ChiId(tc.getId());
                drl.setDiemCS(0);
                drl.setDiemCV(0);
                drl.setDiemSV(0);
                addDRL(drl);  // Lưu DRL vào cơ sở dữ liệu

            }
        }
    }

    //them drl
    public boolean addDRL(DRL drl) {
        String query = "INSERT INTO DRL (diemSV, diemCS, diemCV, status, Sinh_VienID, HK_NKID, Tieu_ChiId) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, drl.getDiemSV());
            ps.setInt(2, drl.getDiemCS());
            ps.setInt(3, drl.getDiemCV());
            ps.setInt(4, drl.getStatus());
            ps.setString(5, drl.getSinhVienID());
            ps.setInt(6, drl.getHkNkID());
            ps.setInt(7, drl.getTieu_ChiId());
            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
    }

    //cập nhật thông tin ( không cập nhật điểm )
    public boolean updateDRL(DRL drl) {
        String query = "UPDATE DRL SET Sinh_VienID = ?, HK_NKID = ?, status = ? WHERE ID = ?";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, drl.getSinhVienID());
            ps.setInt(2, drl.getHkNkID());
            ps.setInt(3, drl.getStatus());
            ps.setInt(4, drl.getId());

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
    }

    public boolean updateDiemSV(int drlId, int diemSV) {
        String query = "UPDATE DRL SET diemSV = ? WHERE ID = ?";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, diemSV);
            ps.setInt(2, drlId);

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0; // Trả về true nếu có ít nhất 1 dòng được cập nhật
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean updateDiemCS(int drlId, int diemCS) {
        String query = "UPDATE DRL SET diemCS = ? WHERE ID = ?";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, diemCS);
            ps.setInt(2, drlId);

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0; // Trả về true nếu có ít nhất 1 dòng được cập nhật
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public boolean updateDiemCV(int drlId, int diemCV) {
        String query = "UPDATE DRL SET diemCV = ? WHERE ID = ?";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, diemCV);
            ps.setInt(2, drlId);

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0; // Trả về true nếu có ít nhất 1 dòng được cập nhật
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //xóa drl
    public boolean deleteDRL(int id) {
        String query = "DELETE FROM DRL WHERE ID = ?";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
    }

}
//te@@
