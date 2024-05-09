package model;

import java.util.ArrayList;
import java.util.Objects;

public class Tinh {
    private String tentinh;
    
	public Tinh() {
	}
    
	public Tinh(String tentinh) {
		this.tentinh = tentinh;
	}

	public String getTentinh() {
		return tentinh;
	}

	public void setTentinh(String tentinh) {
		this.tentinh = tentinh;
	}

	public static ArrayList<Tinh> luugiatritinh(){
		   String []arr_tinh= {
	    		   "An Giang",
				   "Bà Rịa – Vũng Tàu",
				   "Bạc Liêu",
				   "Bắc Giang",
				   "Bến Tre",
				   "Bình Dương",
				   "Bình Phước",
				   "Bình Thuận",
				   "Cà Mau",
				   "Cao Bằng",
				   "Cần Thơ",
				   "Đà Nẵng",
				   "Đắk Lắk",
				   "Đắk Nông",
				   "Điện Biên",
				   "Đồng Nai",
				   "Đồng Tháp",
				   "Gia Lai",
				   "Hà Giang",
				   "Hà Nam",
				   "Hà Nội",
				   "Hà Tĩnh",
				   "Hải Dương",
				   "Hải Phòng",
				   "Hậu Giang",
				   "Hòa Bình",
				   "Thành phố Hồ Chí Minh",
				   "Hưng Yên",
				   "Khánh Hòa",
				   "Kiên Giang",
				   "Kon Tum",
				   "Lai Châu",
				   "Lạng Sơn",
				   "Lào Cai",
				   "Lâm Đồng",
				   "Long An",
				   "Nam Định",
				   "Nghệ An",
				   "Ninh Bình",
				   "Ninh Thuận",
				   "Phú Thọ",
				   "Phú Yên",
				   "Quảng Bình",
				   "Quảng Nam",
				   "Quảng Ngãi",
				   "Quảng Ninh",
				   "Quảng Trị",
				   "Sóc Trăng",
				   "Sơn La",
				   "Tây Ninh",
				   "Thái Bình",
				   "Thái Nguyên",
				   "Thanh Hóa",
				   "Thừa Thiên Huế",
				   "Tiền Giang",
				   "Trà Vinh",
				   "Tuyên Quang",
				   "Vĩnh Long",
				   "Vĩnh Phúc",
				   "Yên Bái"
		   };
		   
		   ArrayList<Tinh> listtinh=new ArrayList<Tinh>();
		   for (String tentinh : arr_tinh) {
			Tinh t=new Tinh(tentinh);
			listtinh.add(t);
		}
		   return listtinh;
	   }

}
