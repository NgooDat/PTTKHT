package com.drl.models;

import java.util.Date;

public class Giang_Vien {

    private String id;
    private String hoTen;
    private String gioiTinh;
    private Date ngaySinh;
    private String sdt;
    private String email;
    private String diaChi;
    private String queQuan;
    private int taiKhoanID;
    private String khoaID;

    public Giang_Vien() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public int getTaiKhoanID() {
        return taiKhoanID;
    }

    public void setTaiKhoanID(int taiKhoanID) {
        this.taiKhoanID = taiKhoanID;
    }

    public String getKhoaID() {
        return khoaID;
    }

    public void setKhoaID(String khoaID) {
        this.khoaID = khoaID;
    }

    public Giang_Vien(String id, String hoTen, String gioiTinh, Date ngaySinh, String sdt, String email, String diaChi,
            String queQuan, int taiKhoanID, String khoaID) {
        super();
        this.id = id;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.queQuan = queQuan;
        this.taiKhoanID = taiKhoanID;
        this.khoaID = khoaID;
    }

}
