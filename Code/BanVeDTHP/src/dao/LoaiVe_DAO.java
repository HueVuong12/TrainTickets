package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LoaiVe;
import entity.LoaiVe;

public class LoaiVe_DAO {
	
	ArrayList<LoaiVe> dsLoaiVe;
	
	public LoaiVe_DAO(){ 
		dsLoaiVe = new ArrayList<LoaiVe>();  
	}
	
	public ArrayList<LoaiVe> docTuBang()  { 
	    try { 
	    	Connection con = ConnectDB.getInstance().getConnection(); 
	    	String sql = "Select * from LoaiVe"; 
	    	Statement statement = con.createStatement(); 
	    	// Thực thi câu lệnh SQL trả về đối tượng ResultSet. 
	    	ResultSet rs = statement.executeQuery(sql); 
	    	// Duyệt trên kết quả trả về. 
	    	while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp. 
	    		String maLoai = rs.getString("maLoai"); 
	    		String hang = rs.getNString("hang"); 
	    		String loai = rs.getNString("loai");

	    		LoaiVe loaiVe = new LoaiVe(maLoai, hang, loai);
	    		
	    		dsLoaiVe.add(loaiVe);
	       } 
	    } catch (SQLException e) { 
	    	e.printStackTrace(); 
	       // Đóng kết nối 
	    } 
	    return dsLoaiVe; 
	}
	
	public boolean create(LoaiVe p) { 
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null; 
		int n = 0; 
		try { 
			stmt = con.prepareStatement("insert into LoaiVe values(?, ?, ?)"); 
			stmt.setString(1,p.getMaLoai());
			stmt.setNString(2,p.getHang());
			stmt.setNString(3,p.getLoai());
			
			n = stmt.executeUpdate();
		} catch (SQLException e) { 
			e.printStackTrace(); 
		}
		
		return n > 0;
	} 
	//U: Update 
	public boolean update(LoaiVe p) { 
		Connection con = ConnectDB.getInstance().getConnection(); 
		PreparedStatement stmt = null; 
		int n = 0; 
		try { 
			stmt = con.prepareStatement("update LoaiVe set hang = ?, loai = ? where maLoai = ?"); 
			stmt.setNString(1,p.getHang());
			stmt.setNString(2,p.getLoai());
		     
		    n = stmt.executeUpdate(); 
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
		
		return n > 0;
	} 
		   
//	//D: Delete 
//	public boolean delete(String maLoai) { 
//		Connection con = ConnectDB.getInstance().getConnection(); 
//		PreparedStatement stmt = null; 
//		int n = 0; 
//		try { 
//			stmt = con.prepareStatement("delete from LoaiVe where maLoai = ?"); 
//		    stmt.setString(1, maLoai); 
//		    n = stmt.executeUpdate(); 
//		} catch (SQLException e) { 
//			e.printStackTrace(); 
//		} 
//		
//		return n > 0;
//	}
	
	public LoaiVe getLoaiVeByTen(String tenLoaiVe){
		LoaiVe LoaiVe = null;
		
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = ConnectDB.getConnection();
			String sql = "SELECT * FROM LoaiVe WHERE [hang] = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, tenLoaiVe);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String maLoai = rs.getString("maLoai"); 
	    		String hang = rs.getNString("hang"); 
	    		String loai = rs.getNString("loai");
	        	LoaiVe = new LoaiVe(maLoai, hang, loai);
						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return LoaiVe;
	}
	
	public LoaiVe getLoaiVeTheoMaLoaiVe(String maLoaiVe){
		LoaiVe LoaiVe = null;
		
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = ConnectDB.getConnection();
			String sql = "SELECT * FROM LoaiVe WHERE [maLoai] = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maLoaiVe);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String maLoai = rs.getString("maLoai"); 
	    		String hang = rs.getNString("hang"); 
	    		String loai = rs.getNString("loai"); 
				LoaiVe=new LoaiVe(maLoai, hang, loai);
						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return LoaiVe;
	}
	
	
	public void reset() {
		dsLoaiVe.removeAll(dsLoaiVe);
	}
}