package entity;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class HoaDon {
	private String maHoaDon;
	private LocalDateTime ngayLapHoaDon;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private ChiTietHoaDon chiTiet;
	private Boolean daHoanVe = false;
	private Boolean daHoanTien = false;

	public HoaDon(String maHoaDon, LocalDateTime ngayLapHoaDon, NhanVien nhanVien, KhachHang khachHang,
			ChiTietHoaDon chiTiet, Boolean daHoanVe, Boolean daHoanTien) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.chiTiet = chiTiet;
		this.daHoanVe = daHoanVe;
		this.daHoanTien = daHoanTien;
	}

	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		String ktMaHoaDon = "^\\d{2}\\d{2}\\d{2}NV\\d{3}\\d{5}$";
		if (ktMaHoaDon.matches(ktMaHoaDon))
			this.maHoaDon = maHoaDon;
		else
			throw new IllegalArgumentException("Mã hóa đơn không hợp lệ!");
	}

	public LocalDateTime getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}

	public void setNgayLapHoaDon(LocalDateTime ngayLapHoaDon) {
		if (ngayLapHoaDon.toLocalDate().isEqual(LocalDate.now()))
			this.ngayLapHoaDon = ngayLapHoaDon;
		else
			throw new IllegalArgumentException("Ngày lập hóa đơn phải là ngày hiện tại!");
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
		//Kiểm tra tồn tại
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
		//Kiểm tra tồn tại
	}

	public ChiTietHoaDon getChiTiet() {
		return chiTiet;
	}

	public void setChiTiet(ChiTietHoaDon chiTiet) {
		this.chiTiet = chiTiet;
		//Kiểm tra tồn tại
	}

	public Boolean getDaHoanVe() {
		return daHoanVe;
	}

	public void setDaHoanVe(Boolean daHoanVe) {
		this.daHoanVe = daHoanVe;
	}

	public Boolean getDaHoanTien() {
		return daHoanTien;
	}

	public void setDaHoanTien(Boolean daHoanTien) {
		this.daHoanTien = daHoanTien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLapHoaDon=" + ngayLapHoaDon + ", nhanVien=" + nhanVien
				+ ", khachHang=" + khachHang + ", chiTiet=" + chiTiet + ", daHoanVe=" + daHoanVe + ", daHoanTien="
				+ daHoanTien + "]";
	}

	public float tongTien() {
		return this.chiTiet.tinhTien();
	}
	
	public float tinhTienHoan() {
		int size = this.chiTiet.getDsVe().size();
		long thoiGian = Duration.between(chiTiet.getDsVe().get(0).getGioDi(), LocalTime.now()).toHours();
		if (size == 1) {
			if (thoiGian >= 24)
				return chiTiet.tinhTien()*0.9f;
			else if (thoiGian >= 4)
				return chiTiet.tinhTien()*0.8f;
		} else {
			if (thoiGian >= 72)
				return chiTiet.tinhTien()*0.9f;
			else if (thoiGian >= 24)
				return chiTiet.tinhTien()*0.8f; 
		}
		return 0;
	}
}
