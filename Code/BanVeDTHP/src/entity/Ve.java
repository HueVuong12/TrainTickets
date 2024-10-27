package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Ve {
	private String maVe;
	private ChuyenTau chuyenTau;
	private Toa toa;
	private Ghe soGhe;
	private KhachHang khachHang;
	private LocalDate ngayDi;
	private LocalTime gioDi;
	private Ga gaDi;
	private Ga gaDen;
	private String khuyenMai;
	private String hang;
	private boolean trangThai;
	private ChiTietHoaDon chiTiet;
	
	public Ve(String maVe, ChuyenTau chuyenTau, Toa toa, Ghe soGhe, KhachHang khachHang, LocalDate ngayDi, LocalTime gioDi,
			Ga gaDi,Ga gaDen, String hang, String khuyenMai,boolean trangThai, ChiTietHoaDon chiTiet) {
		super();
		this.setMaVe(maVe);
		this.setChuyenTau(chuyenTau);
		this.setToa(toa);
		this.setSoGhe(soGhe);
		this.setKhachHang(khachHang);
		this.ngayDi = chuyenTau.getNgayDi();
		this.gioDi = chuyenTau.getGioDi();
		this.setGaDen(gaDen);
		this.setGaDi(gaDi);
		this.setTrangThai(trangThai);
		this.setChiTiet(chiTiet);
	}

	public Ve(String maVe) {
		super();
		this.maVe = maVe;
	}

	public String getMaVe() {
		return maVe;
	}

	public void setMaVe(String maVe) {
		String ktMaVe = "^VE\\d{2}\\d{2}\\d{2}\\d{4}$";
		if (maVe.matches(ktMaVe))
			this.maVe = maVe;
		else
			throw new IllegalArgumentException("Mã vé không hợp lệ! Mã vé có dạng VE + 6 số chỉ ngày tháng năm + 4 số chỉ số thứ tự ");
	}

	public ChuyenTau getChuyenTau() {
		return chuyenTau;
	}

	public void setChuyenTau(ChuyenTau chuyenTau) {
		this.chuyenTau = chuyenTau;
		//Kiểm tra tồn tại
	}

	public Toa getToa() {
		return toa;
	}

	public void setToa(Toa toa) {
		this.toa = toa;
		//Kiểm tra tồn tại
	}

	public Ghe getSoGhe() {
		return soGhe;
	}

	public void setSoGhe(Ghe soGhe) {
		this.soGhe = soGhe;
		//Kiểm tra tồn tại
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
		//Kiểm tra tồn tại
}

	public LocalDate getNgayDi() {
		return ngayDi;
	}

	public LocalTime getGioDi() {
		return gioDi;
	}
	public Ga getGaDi() {
		return gaDi;
	}

	public void setGaDi(Ga gaDi) {
		this.gaDi = gaDi;
		//Kiểm tra tồn tại
	}
	public String getKhuyenMai() {
		return khuyenMai;
	}
	public void setKhuyenMai(String khuyenMai) {
		this.khuyenMai = khuyenMai;
		//Kiểm tra tồn tại
	}
	public String getHang() {
		return hang;
	}
	public void setHang(String hang) {
		this.hang = hang;
		//Kiểm tra tồn tại
	}
	public Ga getGaDen() {
		return gaDen;
	}

	public void setGaDen(Ga gaDen) {
		this.gaDen = gaDen;
		//Kiểm tra tồn tại
}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public ChiTietHoaDon getChiTiet() {
		return chiTiet;
	}

	public void setChiTiet(ChiTietHoaDon chiTiet) {
		this.chiTiet = chiTiet;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maVe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ve other = (Ve) obj;
		return Objects.equals(maVe, other.maVe);
	}
	

	@Override
	public String toString() {
		return "Ve [maVe=" + maVe + ", chuyenTau=" + chuyenTau + ", toa=" + toa + ", soGhe=" + soGhe + ", khachHang="
				+ khachHang + ", ngayDi=" + ngayDi + ", gioDi=" + gioDi + ", gaDi=" + gaDi + ", gaDen=" + gaDen
				+ ", khuyenMai=" + khuyenMai + ", hang=" + hang + ", trangThai=" + trangThai + ", chiTiet=" + chiTiet
				+ "]";
	}

	public float tinhTiGia() {
		float tiGia = 0;
		if (hang.equalsIgnoreCase("Ghe mem"))
			tiGia += 1;
		else if (hang.equalsIgnoreCase("Giuong nam"))
			tiGia += 1.2;
		else
			tiGia += 1.8;
		if (khuyenMai.equalsIgnoreCase("Sinh vien"))
			tiGia += -0.1;
		else if (khuyenMai.equalsIgnoreCase("Nguoi lon"))
			tiGia += 0;
		else if (khuyenMai.equalsIgnoreCase("Nguoi lon tuoi"))
			tiGia += -0.15;
		else if (khuyenMai.equalsIgnoreCase("Tre em 6 den 10 tuoi"))
			tiGia += -0.25;
		else tiGia = 0;
		return tiGia;
	}
	
	public float tinhGiaVe() {
		int quangDuong = Math.abs(gaDen.getChiSoKm()-836);
		
		if (quangDuong <= 50)
			return quangDuong*2000*tinhTiGia();
		else if (quangDuong <= 400)
			return quangDuong*800*tinhTiGia();
		return quangDuong*600*tinhTiGia();
	}
	
	public boolean xuatVe() {
		LocalDate ngayHienTai = LocalDate.now();
		LocalTime gioHienTai = LocalTime.now();
		
		if (ngayHienTai.isBefore(ngayDi) && gioHienTai.isBefore(gioDi)) {
			setTrangThai(false);
			return true;
		}
		return false;
	}
	
	public boolean datVe() {
		if (gaDen.isTrangThai())
			return true;
		return false;
	}
	
	public boolean doiVe() {
	    LocalDateTime now = LocalDateTime.now();
	    LocalDateTime thoiGianDi = LocalDateTime.of(ngayDi, gioDi);
	    
	    if (now.isBefore(thoiGianDi.minusHours(24))) {
	        setTrangThai(false);
	        return true;
	    }
	    return false;
	}
	
	public boolean hoanVe(Boolean isTapThe) {
	    LocalDateTime now = LocalDateTime.now();
	    LocalDateTime thoiGianDi = LocalDateTime.of(ngayDi, gioDi);
	    
	    if (isTapThe) {
	    	if (now.isBefore(thoiGianDi.minusHours(72)))
	    		return true;
	    } else {
	    	if (now.isBefore(thoiGianDi.minusHours(24)))
	    		return true;
	    }
	    return false;
	}
}
