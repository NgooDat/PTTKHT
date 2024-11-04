package com.drl.models;

import java.util.Date;

public class Sinh_Vien {

    private String id;
    private String hoTen;
    private String gioiTinh;
    private Date ngaySinh;
    private String sdt;
    private String diaChi;
    private String email;
    private String queQuan;
    private String lopID;
    private int taiKhoanID;

    public Sinh_Vien() {
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getLopID() {
        return lopID;
    }

    public void setLopID(String lopID) {
        this.lopID = lopID;
    }

    public int getTaiKhoanID() {
        return taiKhoanID;
    }

    public void setTaiKhoanID(int taiKhoanID) {
        this.taiKhoanID = taiKhoanID;
    }

    public Sinh_Vien(String id, String hoTen, String gioiTinh, Date ngaySinh, String sdt, String diaChi, String email,
            String queQuan, String lopID, int taiKhoanID) {
        super();
        this.id = id;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.email = email;
        this.queQuan = queQuan;
        this.lopID = lopID;
        this.taiKhoanID = taiKhoanID;
    }

}
