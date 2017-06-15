package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.sql.ResultSetMetaData;

public class upiti {
	
	public static Vector vratiFilmove(){
		Vector res=new Vector();
		PreparedStatement pstmt=null;
		try{
			pstmt=connection.vratiKonekciju().prepareStatement("select * from movie");
			ResultSet rs=pstmt.executeQuery();
			Vector temp=null;
			
			while(rs.next()){
				temp=new Vector();
				temp.add(new Integer(rs.getInt(1)));
				temp.add(rs.getString(2));
				temp.add(rs.getString(6));
				res.add(temp);
			}
			rs.close();
			pstmt.close();
		}catch(Exception e){
			System.out.println("Desila se neka greska.");
			e.printStackTrace();
		} finally {
			try{
				if(pstmt != null){
					pstmt.close();
				}
				return res;
			}catch(Exception e){
				System.out.println("Nesto puklo");
				e.printStackTrace();
				return null;
			}
		}
	}
	public static Vector vratiGlumce(String id){
		Vector res=new Vector();
		PreparedStatement pstmt=null;
		String upit ;
		if(id.equals("")){
			upit="select * from actor";
		}else{
			upit="select * from actor where id='" + id + "'";
		}
		
		try{
			pstmt=connection.vratiKonekciju().prepareStatement(upit);
			ResultSet rs=pstmt.executeQuery();
			Vector temp=null;
			
			while(rs.next()){
				temp=new Vector();
				temp.add(new Integer(rs.getInt(1)));
				temp.add(rs.getString(2));
				temp.add(rs.getString(3));
				res.add(temp);
			}
			rs.close();
			pstmt.close();
		}catch(Exception e){
			System.out.println("Desila se neka greska.");
			e.printStackTrace();
		} finally {
			try{
				if(pstmt != null){
					pstmt.close();
				}
				System.out.println(res);
				return res;
			}catch(Exception e){
				System.out.println("Nesto puklo");
				e.printStackTrace();
				return null;
			}
		}
	}
	
	
	
	public static Vector getKolone(String ID, String baza, String naziv, String fn, String ln){
		Vector columnNames = new Vector();
		try {
			columnNames.clear();
			String sqlNaredba = "";
			if(ID.equals("") && naziv.equals("")){
				sqlNaredba="SELECT * FROM " + baza;
			}else if(!ID.equals("")){
				sqlNaredba="SELECT * FROM " + baza + " WHERE id= '" + ID + "'";
			}else if(!naziv.equals("")){
				sqlNaredba="SELECT * FROM " + baza + " WHERE title like '%" + naziv + "%'";
			}else if(!fn.equals("") || !ln.equals("")){
				sqlNaredba = "SELECT * FROM " + baza + " WHERE first_name like '%" + fn + "%' or last_name like '%" + ln + "%'";
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
	
	public static Vector getVrste(String ID, String baza, String naziv, String fn, String ln){
		Vector rowData = new Vector();
		try {
			rowData.clear();
			String sqlNaredba = "";
			if(ID.equals("") && naziv.equals("")){
				sqlNaredba="SELECT * FROM " + baza;
			}else if(!ID.equals("")){
				sqlNaredba="SELECT * FROM " + baza + " WHERE id= '" + ID + "'";
			}else if(!naziv.equals("")){
				sqlNaredba="SELECT * FROM " + baza + " WHERE title like '%" + naziv + "%'";
			}else if(!fn.equals("") || !ln.equals("")){
				sqlNaredba = "SELECT * FROM " + baza + " WHERE first_name like '%" + fn + "%' or last_name like '%" + ln + "%'";
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
	
	public static boolean loginCheck(String username, String password){
//		boolean logovan = false;
////		String naredba = "SELECT username, password FROM user WHERE username ='" + username + "' AND password ='" + password + "'";
//		String naredba = "SELECT (username, password) FROM user WHERE (username = ? and password = ?)";
//		try {
//			
//			PreparedStatement ps = connection.vratiKonekciju().prepareStatement(naredba);
//			ps.setString(1, username);
//			ps.setString(2, password);
////			ps.executeQuery();
//			ResultSet rs = ps.executeQuery();
//			
//			String logovanUser = rs.getString(1);
//			String logovanPass = rs.getString(2);
//			
//			if(logovanUser.equals(username) && logovanPass.equals(password)){
//				logovan = true;
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return logovan;
		
		String logovanUsername = "pera.peric";
		String logovanPassword = "pera.peric";
		
		if(logovanUsername.equals(username)){
			if(logovanPassword.equals(password)){
				return true;
			}
		}
		return false;
	}

}

