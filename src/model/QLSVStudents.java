package model;

import java.util.Date;
import java.util.Objects;

public class QLSVStudents {
     private String ID;
     private String name;
     private String lop;
     private Date ngaysinh;
     private boolean gioitinh;
     private String quequan;
	public QLSVStudents() {
	}
	public QLSVStudents(String iD, String name, String lop, Date ngaysinh, boolean gioitinh, String quequan) {
		ID = iD;
		this.name = name;
		this.lop = lop;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.quequan = quequan;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public boolean isGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getQuequan() {
		return quequan;
	}
	public void setQuequan(String quequan) {
		this.quequan = quequan;
	}
	@Override
	public String toString() {
		return "qlsvstudents [ID=" + ID + ", name=" + name + ", lop=" + lop + ", ngaysinh=" + ngaysinh + ", gioitinh="
				+ gioitinh + ", quequan=" + quequan + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(ID, gioitinh, lop, name, ngaysinh, quequan);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QLSVStudents other = (QLSVStudents) obj;
		return Objects.equals(ID, other.ID) && gioitinh == other.gioitinh && Objects.equals(lop, other.lop)
				&& Objects.equals(name, other.name) && Objects.equals(ngaysinh, other.ngaysinh)
				&& Objects.equals(quequan, other.quequan);
	}
    
}
