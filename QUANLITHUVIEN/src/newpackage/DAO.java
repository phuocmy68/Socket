package newpackage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

    private Connection conn;

    public DAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-93EV3P7B\\SQLEXPRESS:1433; databaseName = TEST; user =sa; password=123456789;encrypt=true;trustServerCertificate=true;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean addstudent(Students s) {
        String sql = "INSERT INTO Table_1(MSV, Name, Date_of_birth, Class)"
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,s.getMSV());
            ps.setString(2, s.getHoten());
            ps.setString(3, s.getNgaysinh());
            ps.setString(4, s.getLop());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean update(Students s) {
        String sql = "UPDATE Table_1 SET Name = ?, Date_of_birth =?, Class=? WHERE MSV=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1,s.getHoten());
            ps.setString(2, s.getNgaysinh());
            ps.setString(3, s.getLop());
            ps.setString(4, s.getMSV());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(Students s) {
        String sql = " DELETE FROM Table_1 WHERE MSV=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMSV());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<Students> getList() {
        ArrayList<Students> list = new ArrayList<>();
        String sql = "SELECT*FROM Table_1";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Students st = new Students();
                st.setMSV(rs.getString("MSV"));
                st.setHoten(rs.getString("Name"));
                st.setNgaysinh(rs.getString("Date_of_birth"));
                st.setLop(rs.getString("Class"));
                
                list.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    

    public static void main(String[] args) {
        new DAO();
    }

    public ArrayList<Students> search(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}