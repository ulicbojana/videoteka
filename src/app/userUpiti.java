package app;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import com.mysql.jdbc.PreparedStatement;

public class userUpiti {
	
	public static Vector getKolone(String jmbg, String fn, String ln, String id){
		Vector columnNames = new Vector();
		try {
			columnNames.clear();
			String sqlNaredba = "";
			if(!fn.equals("") || !ln.equals("") || !jmbg.equals("") || !id.equals("")){
				sqlNaredba = "SELECT first_name, last_name, jmbg, id FROM user WHERE first_name ='" + fn + "' or last_name = '" + ln + "' or jmbg ='" + jmbg + "'or id = '" + id + "'";
			}else{
				sqlNaredba ="SELECT * FROM user";		
			}
			Statement stmt= connection.vratiKonekciju().createStatement();
			ResultSet rset=stmt.executeQuery(sqlNaredba);
			ResultSetMetaData rsmd=(ResultSetMetaData) rset.getMetaData();
			
			int columCount=rsmd.getColumnCount();
			String columName;
			for(int i=1;i<=columCount;i++){
				columName=rsmd.getColumnName(i);
				columnNames.addElement(columName);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return columnNames;
	}
	
	public static Vector getVrste(String jmbg, String fn, String ln, String id){
		Vector rowData = new Vector();
		try {
			rowData.clear();
			String sqlNaredba = "";
			if(!fn.equals("") || !ln.equals("") || !jmbg.equals("") || !id.equals("")){
				sqlNaredba = "SELECT first_name, last_name, jmbg, id FROM user WHERE first_name ='" + fn + "' or last_name='" + ln + "' or jmbg ='" + jmbg + "'or id = '" + id + "'";
			}else{
				sqlNaredba ="SELECT * FROM user";
			}
			Statement stmt= connection.vratiKonekciju().createStatement();
			ResultSet rset=stmt.executeQuery(sqlNaredba);
			ResultSetMetaData rsmd=(ResultSetMetaData) rset.getMetaData();
			
			int columCount =rsmd.getColumnCount();
			String columName;
		while(rset.next()){
			Vector row=new Vector();
			for(int i=1;i<=columCount;i++){
				String columnTypeName=rsmd.getColumnTypeName(i);
				if(columnTypeName.equals("VARCHAR")){
					row.addElement(rset.getString(i));
				}
				else if(columnTypeName.equals("INT")){
					row.addElement(new Integer(rset.getInt(i)));
				}else if(columnTypeName.equals("DATETIME")){
					row.addElement(rset.getString(i));
				}else if(columnTypeName.equals("TINYINT")){
					if(rset.getInt(i) == 0){
						row.addElement(new String("No"));
					}else{
						row.addElement(new String("Yes"));
					}
				}
			}
			
			rowData.addElement(row);
		}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowData;
	}
	
        public static String unos(String fn, String ln, String addr, String tel,String jmbg,String date,String un, String pass, boolean active){
        	
//        	DateFormat formatiraj = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
//        	java.util.Date formatiran = null;
//			try {
//				formatiran = (java.util.Date) formatiraj.parse(date);
//			} catch (ParseException e1) {
//				e1.printStackTrace();
//			}
        	
        	boolean actives = false;
        	if(active){
        		actives = true;
        	}
        	
        	String res = "uneo u bazu";
        	
        	try {
				connection.vratiKonekciju().setAutoCommit(false);
				java.sql.PreparedStatement ps= connection.vratiKonekciju().
						prepareStatement("INSERT INTO user (first_name, last_name, tel_number, adress, jmbg, date_joined, active, username, password) values (?,?,?,?,?,?,?,?,?)");
				ps.setString(1, fn);
				ps.setString(2, ln);
				ps.setString(3, tel);
				ps.setString(4, addr);
				ps.setString(5, jmbg);
				ps.setDate(6, null);
				ps.setBoolean(7, false);
				ps.setString(8, un);
				ps.setString(9, pass);
				
				//izvrsi upit
				ps.executeUpdate();
				
				//uradi commit
				connection.vratiKonekciju().commit();
				
			} catch (SQLException e) {
				e.printStackTrace();
				res = "Nisam uneo u bazu!";
				try {
					connection.vratiKonekciju().rollback();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
        	return res;
        	
        }
}
