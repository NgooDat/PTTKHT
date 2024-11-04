package com.drl.models;

import java.util.Date;

public class Thong_Bao {

    private int id;
    private Date ngayBD;
    private Date ngayKT_SV;
    private Date ngayKT_CS;
    private Date ngayKT_CV;
    private Date ngayKT_Khoa;
    private int hkNkID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public Date getNgayKT_SV() {
        return ngayKT_SV;
    }

    public void setNgayKT_SV(Date ngayKT_SV) {
        this.ngayKT_SV = ngayKT_SV;
    }

    public Date getNgayKT_CS() {
        return ngayKT_CS;
    }

    public void setNgayKT_CS(Date ngayKT_CS) {
        this.ngayKT_CS = ngayKT_CS;
    }

    public Date getNgayKT_CV() {
        return ngayKT_CV;
    }

    public void setNgayKT_CV(Date ngayKT_CV) {
        this.ngayKT_CV = ngayKT_CV;
    }

    public Date getNgayKT_Khoa() {
        return ngayKT_Khoa;
    }

    public void setNgayKT_Khoa(Date ngayKT_Khoa) {
        this.ngayKT_Khoa = ngayKT_Khoa;
    }

    public int getHkNkID() {
        return hkNkID;
    }

    public void setHkNkID(int hkNkID) {
        this.hkNkID = hkNkID;
    }

	public Thong_Bao() {
		super();
	}

	public Thong_Bao(int id, Date ngayBD, Date ngayKT_SV, Date ngayKT_CS, Date ngayKT_CV, Date ngayKT_Khoa,
			int hkNkID) {
		super();
		this.id = id;
		this.ngayBD = ngayBD;
		this.ngayKT_SV = ngayKT_SV;
		this.ngayKT_CS = ngayKT_CS;
		this.ngayKT_CV = ngayKT_CV;
		this.ngayKT_Khoa = ngayKT_Khoa;
		this.hkNkID = hkNkID;
	}

	public Thong_Bao(Date ngayBD, Date ngayKT_SV, Date ngayKT_CS, Date ngayKT_CV, Date ngayKT_Khoa, int hkNkID) {
		super();
		this.ngayBD = ngayBD;
		this.ngayKT_SV = ngayKT_SV;
		this.ngayKT_CS = ngayKT_CS;
		this.ngayKT_CV = ngayKT_CV;
		this.ngayKT_Khoa = ngayKT_Khoa;
		this.hkNkID = hkNkID;
	}

}
