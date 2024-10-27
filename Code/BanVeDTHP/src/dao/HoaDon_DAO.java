package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class HoaDon_DAO {
	ArrayList<HoaDon> dsHoaDon;

	public HoaDon_DAO() {
		dsHoaDon = new ArrayList<HoaDon>();
	}

	public ArrayList<HoaDon> docTuBang() {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from HoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHoaDon = rs.getString("maHoaDon");
				LocalDateTime ngayLapHoaDon = rs.getTimestamp("ngayLapHoaDon").toLocalDateTime();
				String maNV = rs.getString("maNV");
				String maKH = rs.getString("maKH");
				String maChiTiet = rs.getString("chiTiet");
				boolean daHoanVe = rs.getBoolean("daHoanVe");
				boolean daHoanTien = rs.getBoolean("daHoanTien");

				// Sử dụng constructor copy
				NhanVien nhanVien = new NhanVien(maNV);
				KhachHang khachHang = new KhachHang(maKH);
				ChiTietHoaDon chiTiet = new ChiTietHoaDon(maChiTiet);
				HoaDon hoaDon = new HoaDon(maHoaDon, ngayLapHoaDon, nhanVien, khachHang, chiTiet, daHoanVe, daHoanTien);
				dsHoaDon.add(hoaDon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHoaDon;
	}

	public boolean create(HoaDon HoaDon) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into HoaDon values(?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, HoaDon.getMaHoaDon());
			stmt.setObject(2, HoaDon.getNgayLapHoaDon());
			stmt.setString(3, HoaDon.getNhanVien().getMaNV());
			stmt.setString(4, HoaDon.getKhachHang().getMaKH());
			stmt.setString(5, HoaDon.getChiTiet().getMaChiTiet());
			stmt.setBoolean(6, HoaDon.getDaHoanVe());
			stmt.setBoolean(7, HoaDon.getDaHoanTien());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n > 0;
	}

	public boolean update(HoaDon HoaDon) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"update HoaDon set ngayLapHoaDon = ?, nhanVien = ?, khachHang = ?, chiTiet = ?, daHoanVe = ?, daHoanTien = ?, where maHoaDon = ?");
			stmt.setString(7, HoaDon.getMaHoaDon());
			stmt.setObject(1, HoaDon.getNgayLapHoaDon());
			stmt.setString(2, HoaDon.getNhanVien().getMaNV());
			stmt.setString(3, HoaDon.getKhachHang().getMaKH());
			stmt.setString(4, HoaDon.getChiTiet().getMaChiTiet());
			stmt.setBoolean(5, HoaDon.getDaHoanVe());
			stmt.setBoolean(6, HoaDon.getDaHoanTien());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n > 0;
	}

	public boolean delete(String maHoaDon) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from HoaDon where maHoaDon = ?");
			stmt.setString(1, maHoaDon);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n > 0;
	}

	public HoaDon getHoaDonTheoMaHoaDon(String maHoaDon) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		HoaDon hoaDon = null;
		try {
			String sql = "Select * from HoaDon where maHoaDon = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maHoaDon);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				LocalDateTime ngayLapHoaDon = rs.getTimestamp("ngayLapHoaDon").toLocalDateTime();
				String maNV = rs.getString("maNV");
				String maKH = rs.getString("maKH");
				String maChiTiet = rs.getString("chiTiet");
				boolean daHoanVe = rs.getBoolean("daHoanVe");
				boolean daHoanTien = rs.getBoolean("daHoanTien");

				// Sử dụng constructor copy
				NhanVien nhanVien = new NhanVien(maNV);
				KhachHang khachHang = new KhachHang(maKH);
				ChiTietHoaDon chiTiet = new ChiTietHoaDon(maChiTiet);
				hoaDon = new HoaDon(maHoaDon, ngayLapHoaDon, nhanVien, khachHang, chiTiet, daHoanVe, daHoanTien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hoaDon;
	}

	public void reset() {
		dsHoaDon.removeAll(dsHoaDon);
	}
}
