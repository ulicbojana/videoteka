package app;
import java.sql.*;

public class connection {
	
	public connection(){
		
		
	}
	
	public static Connection conn=null;
	
	public static Connection vratiKonekciju(){
		return conn;
	}
	
	public static void zatvoriKonekciju(){
		try{
			conn.close();
			
		}
		catch (SQLException e ) {
			System.out.println("Nisam uspeo da zatvorim konekciju");
		    e.printStackTrace();
		}
	}
	
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/videoteka","root","rastko1");
		}
		catch (Exception e) {
			System.out.println("ne radi baza");
			e.printStackTrace();
		}
	}

}
