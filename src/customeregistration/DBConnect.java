
package customeregistration;

import java.sql.*;

public class DBConnect {

    Connection conn = null;
     
     
    public Connection connect() {
        String url = "jdbc:sqlite:C://sqllite//software.db";
        
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());    
        }
        return conn;
    }
 
    
    
    public Connection disconnect() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    
    
    public boolean check_username(String username){
       boolean control;
        try{
       Statement stat = conn.createStatement();
        String SelectQuery = "SELECT* FROM register where username  ='" + username+ "' ";
        ResultSet rs = stat.executeQuery(SelectQuery);
        if(rs.next() == true){
            control = true;
        }
        else 
            control = false;
        }
        catch(SQLException ee){
            control = false;
        }
        finally {
            disconnect();
        }
    
        return control;
        }
    
    
    
    
    public boolean Register(String name, String surname , String username, String gender, String address,
                            String city, String country, String phone, String email, int day, String month,
                            int year, String state, String maiden, String passport, String occ, String bio)
    {
        try {
        String SQLStatement = "INSERT INTO register VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement p = conn.prepareStatement(SQLStatement);
        p.setString(1, name);
        p.setString(2, surname);
        p.setString(3, username);
        p.setString(4, gender);
        p.setString(5, address);
        p.setString(6, city);
        p.setString(7, country);
        p.setString(8, phone);
        p.setString(9, email);
        p.setInt(10, day);
        p.setString(11, month);
        p.setInt(12, year);
        p.setString(13, state);
        p.setString(14, maiden);
        p.setString(15, passport);
        p.setString(16, occ);
        p.setString(17, bio);
        
        
        p.executeUpdate();
        return true;
     }
        catch(SQLException ee)
        {
            System.out.println("An Error has Occured");
            return false;
        }
        finally{
            disconnect();
        }
        
    }
      
    
}
   
