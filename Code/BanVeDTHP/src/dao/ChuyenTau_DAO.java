package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChuyenTau;
import entity.Ga;
import entity.Toa;

public class ChuyenTau_DAO {
	ArrayList<ChuyenTau> dsChuyenTau;
	Ga_DAO ga_Dao = new Ga_DAO();
	Toa_DAO toa_Dao = new Toa_DAO();
    
    public ChuyenTau_DAO(){ 
        dsChuyenTau = new ArrayList<ChuyenTau>();  
    }
    
    public ArrayList<ChuyenTau> docTuBang()  { 
        try { 
            Connection con = ConnectDB.getInstance().getConnection(); 
            String sql = "Select * from ChuyenTau"; 
            Statement statement = con.createStatement(); 
            ResultSet rs = statement.executeQuery(sql); 
            while (rs.next()) { 
                String maTau = rs.getString("maTau");
                String gaDi = rs.getString("gaDi");
                String gaDen = rs.getString("gaDen");
                LocalDate ngayDi = rs.getDate("ngayDi").toLocalDate();
                LocalTime gioDi = rs.getTime("gioDi").toLocalTime();
                Ga gaDi1 = ga_Dao.getGaTheoMaGa(gaDi);
                Ga gaDen1 = ga_Dao.getGaTheoMaGa(gaDen);
                ArrayList<Toa> dsToa = toa_Dao.getDsToaTheoMaTau(maTau);
                ArrayList<Ga> tramDung = ga_Dao.getDsTramDung(maTau);
                ChuyenTau chuyenTau = new ChuyenTau(maTau, gaDi1,gaDen1, tramDung, ngayDi,gioDi, dsToa);
                dsChuyenTau.add(chuyenTau);
           } 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
        return dsChuyenTau; 
    }
        
    public boolean create(ChuyenTau chuyenTau) { 
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null; 
        int n = 0; 
        try { 
            stmt = con.prepareStatement("insert into ChuyenTau values(?, ?, ?, ?, ?)"); 
            stmt.setString(1, chuyenTau.getMaTau());
            stmt.setString(2, chuyenTau.getGaDi().getMaGa());
            stmt.setString(3, chuyenTau.getGaDen().getMaGa());
            stmt.setObject(4, chuyenTau.getNgayDi());
            stmt.setObject(5, chuyenTau.getGioDi());      
            n = stmt.executeUpdate();
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
        
        return n > 0;
    } 
    
    public boolean update(ChuyenTau chuyenTau) { 
        Connection con = ConnectDB.getInstance().getConnection(); 
        PreparedStatement stmt = null; 
        int n = 0; 
        try { 
            stmt = con.prepareStatement("update ChuyenTau set gaDi = ?, gaDen = ?, ngayDi = ?, gioDi = ? where maTau = ?"); 
            stmt.setString(1, chuyenTau.getGaDi().getMaGa());
            stmt.setString(2, chuyenTau.getGaDen().getMaGa());
            stmt.setObject(3, chuyenTau.getNgayDi());
            stmt.setObject(4, chuyenTau.getGioDi()); 
            stmt.setString(5, chuyenTau.getMaTau());
            n = stmt.executeUpdate(); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
        
        return n > 0;
    } 
           
    public boolean delete(String maTau) { 
        Connection con = ConnectDB.getInstance().getConnection(); 
        PreparedStatement stmt = null; 
        int n = 0; 
        try { 
            stmt = con.prepareStatement("delete from ChuyenTau where maTau = ?"); 
            stmt.setString(1, maTau); 
            n = stmt.executeUpdate(); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
        
        return n > 0;
    }

    public ChuyenTau getChuyenTauTheoMaTau(String maTau) { 
        Connection con = ConnectDB.getInstance().getConnection(); 
        PreparedStatement stmt = null; 
        ChuyenTau chuyenTau = null;
        try {       
            String sql = "Select * from ChuyenTau where maTau = ?"; 
            stmt = con.prepareStatement(sql); 
            stmt.setString(1, maTau); 
            ResultSet rs = stmt.executeQuery(); 
            while (rs.next()) {
            	String maTau1 = rs.getString("maTau");
                String gaDi = rs.getString("gaDi");
                String gaDen = rs.getString("gaDen");
                LocalDate ngayDi = rs.getDate("ngayDi").toLocalDate();
                LocalTime gioDi = rs.getTime("gioDi").toLocalTime();
                Ga gaDi1 = ga_Dao.getGaTheoMaGa(gaDi);
                Ga gaDen1 = ga_Dao.getGaTheoMaGa(gaDen);
                ArrayList<Toa> dsToa = toa_Dao.getDsToaTheoMaTau(maTau);
                ArrayList<Ga> tramDung = ga_Dao.getDsTramDung(maTau);
                chuyenTau = new ChuyenTau(maTau1, gaDi1,gaDen1, tramDung, ngayDi,gioDi, dsToa);
              
            } 
        } catch (SQLException e) { 
            e.printStackTrace();     
        } 
        
        return chuyenTau; 
    } 

    public void reset() {
        dsChuyenTau.removeAll(dsChuyenTau);
    }
}
