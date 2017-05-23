package app;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.mysql.jdbc.ResultSetMetaData;

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
	
	public static Vector getKolone(String ID, String baza, String naziv){
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
	
	public static Vector getVrste(String ID, String baza, String naziv){
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

}

