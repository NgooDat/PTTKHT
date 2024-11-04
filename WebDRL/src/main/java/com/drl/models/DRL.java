package com.drl.models;

public class DRL {

    private int id;
    private int diemSV;
    private int diemCS;
    private int diemCV;
    private int status;
    private String sinhVienID;
    private int hkNkID;

    private int Tieu_ChiId;

    public int getTieu_ChiId() {
        return Tieu_ChiId;
    }

    public void setTieu_ChiId(int Tieu_ChiId) {
        this.Tieu_ChiId = Tieu_ChiId;
    }

    public DRL(int diemSV, int diemCS, int diemCV, int status, String sinhVienID, int hkNkID) {
        super();
        this.diemSV = diemSV;
        this.diemCS = diemCS;
        this.diemCV = diemCV;
        this.status = status;
        this.sinhVienID = sinhVienID;
        this.hkNkID = hkNkID;
    }

    public DRL(int id, int diemSV, int diemCS, int diemCV, int status, String sinhVienID, int hkNkID) {
        super();
        this.id = id;
        this.diemSV = diemSV;
        this.diemCS = diemCS;
        this.diemCV = diemCV;
        this.status = status;
        this.sinhVienID = sinhVienID;
        this.hkNkID = hkNkID;
    }
    
    public DRL(int id, int diemSV, int diemCS, int diemCV, int status, String sinhVienID, int hkNkID, int Tieu_ChiId) {
        super();
        this.id = id;
        this.diemSV = diemSV;
        this.diemCS = diemCS;
        this.diemCV = diemCV;
        this.status = status;
        this.sinhVienID = sinhVienID;
        this.hkNkID = hkNkID;
        this.Tieu_ChiId = Tieu_ChiId;
    }

    public DRL() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiemSV() {
        return diemSV;
    }

    public void setDiemSV(int diemSV) {
        this.diemSV = diemSV;
    }

    public int getDiemCS() {
        return diemCS;
    }

    public void setDiemCS(int diemCS) {
        this.diemCS = diemCS;
    }

    public int getDiemCV() {
        return diemCV;
    }

    public void setDiemCV(int diemCV) {
        this.diemCV = diemCV;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSinhVienID() {
        return sinhVienID;
    }

    public void setSinhVienID(String sinhVienID) {
        this.sinhVienID = sinhVienID;
    }

    public int getHkNkID() {
        return hkNkID;
    }

    public void setHkNkID(int hkNkID) {
        this.hkNkID = hkNkID;
    }
}
