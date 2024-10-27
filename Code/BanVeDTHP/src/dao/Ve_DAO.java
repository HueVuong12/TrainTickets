package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChuyenTau;
import entity.ChiTietHoaDon;
import entity.Ga;
import entity.Ghe;
import entity.KhachHang;
import entity.Toa;
import entity.Ve;

public class Ve_DAO {

	ArrayList<Ve> dsVe;

	public Ve_DAO() {
		dsVe = new ArrayList<>();
	}

	// Phương thức đọc tất cả các vé từ bảng Ve
	public ArrayList<Ve> docTuBang() {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "SELECT * FROM Ve";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String maVe = rs.getString("maVe");
				String maTau = rs.getString("tau");
				String maToa = rs.getString("toa");
				int soGhe = rs.getInt("soGhe");
				String maKH = rs.getString("khachHang");
				LocalDate ngayDi = rs.getDate("ngayDi").toLocalDate();
				LocalTime gioDi = rs.getTime("gioDi").toLocalTime();
				String maGaDi = rs.getString("gaDi");
				String maGaDen = rs.getString("gaDen");
				String hang = rs.getString("hang");
				String khuyenMai = rs.getString("khuyenMai");
				boolean trangThai = rs.getBoolean("trangThai");
				String maChiTiet = rs.getString("chiTiet");

				// Sử dụng constructor copy để tạo đối tượng
				ChuyenTau tau = new ChuyenTau(maTau);
				Toa toa = new Toa(maToa);
				Ghe ghe = new Ghe(soGhe, toa);
				KhachHang khachHang = new KhachHang(maKH);
				Ga gaDi = new Ga(maGaDi);
				Ga gaDen = new Ga(maGaDen);
				ChiTietHoaDon chiTiet = new ChiTietHoaDon(maChiTiet);

				// Tạo đối tượng Ve
				Ve ve = new Ve(maVe, tau, toa, ghe, khachHang, ngayDi, gioDi, gaDi, gaDen, hang, khuyenMai, trangThai,
						chiTiet);
				dsVe.add(ve);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsVe;
	}

	// Phương thức tạo mới một vé trong bảng Ve
	public boolean create(Ve ve) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("INSERT INTO Ve VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, ve.getMaVe());
			stmt.setString(2, ve.getChuyenTau().getMaTau());
			stmt.setString(3, ve.getToa().getMaToa());
			stmt.setInt(4, ve.getSoGhe().getSoGhe());
			stmt.setString(5, ve.getKhachHang().getMaKH());
			stmt.setDate(6, java.sql.Date.valueOf(ve.getNgayDi()));
			stmt.setTime(7, java.sql.Time.valueOf(ve.getGioDi()));
			stmt.setString(8, ve.getGaDi().getMaGa());
			stmt.setString(9, ve.getGaDen().getMaGa());
			stmt.setString(10, ve.getHang());
			stmt.setString(11, ve.getKhuyenMai());
			stmt.setBoolean(12, ve.isTrangThai());
			stmt.setString(13, ve.getChiTiet().getMaChiTiet());

			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	// Phương thức cập nhật thông tin của một vé
	public boolean update(Ve ve) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"UPDATE Ve SET tau = ?, toa = ?, soGhe = ?, khachHang = ?, ngayDi = ?, gioDi = ?, gaDi = ?, gaDen = ?, hang = ?, khuyenMai = ?,trangThai = ?, chiTiet = ? WHERE maVe = ?");
			stmt.setString(1, ve.getChuyenTau().getMaTau());
			stmt.setString(2, ve.getToa().getMaToa());
			stmt.setInt(3, ve.getSoGhe().getSoGhe());
			stmt.setString(4, ve.getKhachHang().getMaKH());
			stmt.setDate(5, java.sql.Date.valueOf(ve.getNgayDi()));
			stmt.setTime(6, java.sql.Time.valueOf(ve.getGioDi()));
			stmt.setString(7, ve.getGaDi().getMaGa());
			stmt.setString(8, ve.getGaDen().getMaGa());
			stmt.setString(9, ve.getHang());
			stmt.setString(10, ve.getKhuyenMai());
			stmt.setBoolean(11, ve.isTrangThai());
			stmt.setString(12, ve.getChiTiet().getMaChiTiet());
			stmt.setString(13, ve.getMaVe());

			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	// Phương thức xóa một vé
	public boolean delete(String maVe) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("DELETE FROM Ve WHERE maVe = ?");
			stmt.setString(1, maVe);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	// Phương thức lấy vé theo mã vé
	public Ve getVeTheoMaVe(String maVe) {
		Ve ve = null;
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "SELECT * FROM Ve WHERE maVe = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maVe);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String maVe1 = rs.getString("maVe");
				String maTau = rs.getString("tau");
				String maToa = rs.getString("toa");
				int soGhe = rs.getInt("soGhe");
				String maKH = rs.getString("khachHang");
				LocalDate ngayDi = rs.getDate("ngayDi").toLocalDate();
				LocalTime gioDi = rs.getTime("gioDi").toLocalTime();
				String maGaDi = rs.getString("gaDi");
				String maGaDen = rs.getString("gaDen");
				String hang = rs.getString("hang");
				String khuyenMai = rs.getString("khuyenMai");
				boolean trangThai = rs.getBoolean("trangThai");
				String maChiTiet = rs.getString("chiTiet");

				// Sử dụng constructor copy để tạo đối tượng
				ChuyenTau tau = new ChuyenTau(maTau);
				Toa toa = new Toa(maToa);
				Ghe ghe = new Ghe(soGhe, toa);
				KhachHang khachHang = new KhachHang(maKH);
				Ga gaDi = new Ga(maGaDi);
				Ga gaDen = new Ga(maGaDen);
				ChiTietHoaDon chiTiet = new ChiTietHoaDon(maChiTiet);
				// Tạo đối tượng Ve
				ve = new Ve(maVe1, tau, toa, ghe, khachHang, ngayDi, gioDi, gaDi, gaDen, hang, khuyenMai, trangThai,
						chiTiet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ve;
	}

	// Phương thức lấy vé theo mã vé
	public ArrayList<Ve> getDsVeTheoMaChiTiet(String maChiTiet) {
		ArrayList<Ve> ds = new ArrayList<Ve>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "SELECT * FROM Ve WHERE chiTiet = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maChiTiet);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String maVe1 = rs.getString("maVe");
				String maTau = rs.getString("tau");
				String maToa = rs.getString("toa");
				int soGhe = rs.getInt("soGhe");
				String maKH = rs.getString("khachHang");
				LocalDate ngayDi = rs.getDate("ngayDi").toLocalDate();
				LocalTime gioDi = rs.getTime("gioDi").toLocalTime();
				String maGaDi = rs.getString("gaDi");
				String maGaDen = rs.getString("gaDen");
				String hang = rs.getString("hang");
				String khuyenMai = rs.getString("khuyenMai");
				boolean trangThai = rs.getBoolean("trangThai");
				String maChiTiet1 = rs.getString("chiTiet");

				// Sử dụng constructor copy để tạo đối tượng
				ChuyenTau tau = new ChuyenTau(maTau);
				Toa toa = new Toa(maToa);
				Ghe ghe = new Ghe(soGhe, toa);
				KhachHang khachHang = new KhachHang(maKH);
				Ga gaDi = new Ga(maGaDi);
				Ga gaDen = new Ga(maGaDen);
				ChiTietHoaDon chiTiet = new ChiTietHoaDon(maChiTiet);

				// Tạo đối tượng Ve
				Ve ve = new Ve(maVe1, tau, toa, ghe, khachHang, ngayDi, gioDi, gaDi, gaDen, hang, khuyenMai, trangThai,
						chiTiet);
				ds.add(ve);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}

	public void reset() {
		dsVe.removeAll(dsVe);
	}
}
