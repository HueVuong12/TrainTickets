package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.TaiKhoan;
import entity.NhanVien;

public class TaiKhoan_DAO {

	ArrayList<TaiKhoan> dsTaiKhoan;

	public TaiKhoan_DAO() {
		dsTaiKhoan = new ArrayList<TaiKhoan>();
	}

	public ArrayList<TaiKhoan> docTuBang() {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "SELECT * FROM TaiKhoan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maTaiKhoan = rs.getString("maTaiKhoan");
				String matKhau = rs.getString("matKhau");
				int phanQuyen = rs.getInt("phanQuyen");
				String maNV = rs.getString("nhanVien");

				// Sử dụng constructor copy
				NhanVien nhanVien = new NhanVien(maNV);

				TaiKhoan taiKhoan = new TaiKhoan(maTaiKhoan, matKhau, phanQuyen, nhanVien);
				dsTaiKhoan.add(taiKhoan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsTaiKhoan;
	}

	public boolean create(TaiKhoan tk) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("INSERT INTO TaiKhoan VALUES(?, ?, ?, ?)");
			stmt.setString(1, tk.getMaTaiKhoan());
			stmt.setString(2, tk.getMatKhau());
			stmt.setInt(3, tk.getPhanQuyen());
			stmt.setString(4, tk.getNhanVien().getMaNV()); // Lấy mã nhân viên từ đối tượng NhanVien

			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n > 0;
	}

	public boolean update(TaiKhoan tk) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"UPDATE TaiKhoan SET matKhau = ?, phanQuyen = ?, nhanVien = ? WHERE maTaiKhoan = ?");
			stmt.setString(1, tk.getMatKhau());
			stmt.setInt(2, tk.getPhanQuyen());
			stmt.setString(3, tk.getNhanVien().getMaNV()); // Lấy mã nhân viên từ đối tượng NhanVien
			stmt.setString(4, tk.getMaTaiKhoan());

			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n > 0;
	}

	public boolean delete(String maTaiKhoan) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("DELETE FROM TaiKhoan WHERE maTaiKhoan = ?");
			stmt.setString(1, maTaiKhoan);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n > 0;
	}

	public TaiKhoan getTaiKhoanTheoMaTK(String maTaiKhoan) {
		TaiKhoan taiKhoan = null;

		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;

		try {
			String sql = "SELECT * FROM TaiKhoan WHERE maTaiKhoan = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maTaiKhoan);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String matKhau = rs.getString("matKhau");
				int phanQuyen = rs.getInt("phanQuyen");
				String maNV = rs.getString("nhanVien");

				// Sử dụng constructor copy
				NhanVien nhanVien = new NhanVien(maNV);

				taiKhoan = new TaiKhoan(maTaiKhoan, matKhau, phanQuyen, nhanVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return taiKhoan;
	}

	public void reset() {
		dsTaiKhoan.removeAll(dsTaiKhoan);
	}

	////////// Toan
	public ArrayList<TaiKhoan> getListQL() {
		try {
			Connection con = ConnectDB.getInstance().getConnection(); // Lấy kết nối CSDL
			String sql = "SELECT * FROM TaiKhoan WHERE phanQuyen = ?";
			PreparedStatement stmt = con.prepareStatement(sql); // Khởi tạo PreparedStatement với câu truy vấn
			stmt.setInt(1, 1); // Thiết lập giá trị cho tham số phanQuyen

			ResultSet rs = stmt.executeQuery(); // Thực thi truy vấn

			while (rs.next()) {
				String maDangNhap = rs.getString("maDangNhap");
				String matKhau = rs.getString("matKhau");
				int phanQuyen = rs.getInt("phanQuyen");
				String maNV = rs.getString("nhanVien");

				// Sử dụng constructor copy
                NhanVien nhanVien = new NhanVien(maNV);

				TaiKhoan taiKhoan = new TaiKhoan(maDangNhap, matKhau, phanQuyen, nhanVien);
				dsTaiKhoan.add(taiKhoan); // Thêm tài khoản vào danh sách
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsTaiKhoan; // Trả về danh sách tài khoản
	}

	public ArrayList<TaiKhoan> getLisNV() {
		try {
			Connection con = ConnectDB.getInstance().getConnection(); // Lấy kết nối CSDL
			String sql = "SELECT * FROM TaiKhoan WHERE phanQuyen = ?";
			PreparedStatement stmt = con.prepareStatement(sql); // Khởi tạo PreparedStatement với câu truy vấn
			stmt.setInt(1, 2); // Thiết lập giá trị cho tham số phanQuyen

			ResultSet rs = stmt.executeQuery(); // Thực thi truy vấn

			while (rs.next()) {
				String maDangNhap = rs.getString("maDangNhap");
				String matKhau = rs.getString("matKhau");
				int phanQuyen = rs.getInt("phanQuyen");
				String maNV = rs.getString("nhanVien");

				// Sử dụng constructor copy
                NhanVien nhanVien = new NhanVien(maNV);

				TaiKhoan taiKhoan = new TaiKhoan(maDangNhap, matKhau, phanQuyen, nhanVien);
				dsTaiKhoan.add(taiKhoan); // Thêm tài khoản vào danh sách
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsTaiKhoan; // Trả về danh sách tài khoản
	}
}
