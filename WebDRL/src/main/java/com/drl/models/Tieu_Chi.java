package com.drl.models;

public class Tieu_Chi {
	 private int id;
	    private String noiDung;
	    private int tongDiem;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNoiDung() {
			return noiDung;
		}
		public void setNoiDung(String noiDung) {
			this.noiDung = noiDung;
		}
		public int getTongDiem() {
			return tongDiem;
		}
		public void setTongDiem(int tongDiem) {
			this.tongDiem = tongDiem;
		}
		public Tieu_Chi() {
			super();
		}
		public Tieu_Chi(int id, String noiDung, int tongDiem) {
			super();
			this.id = id;
			this.noiDung = noiDung;
			this.tongDiem = tongDiem;
		}
		public Tieu_Chi(String noiDung, int tongDiem) {
			super();
			this.noiDung = noiDung;
			this.tongDiem = tongDiem;
		}
		
	    
}
