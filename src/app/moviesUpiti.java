package app;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class moviesUpiti {
	
	public static Vector getKolone(String ID, String naziv){
		Vector columnNames = new Vector();
		try {
			columnNames.clear();
			String sqlNaredba = "";
			if(ID.equals("") && naziv.equals("")){
				sqlNaredba="SELECT * FROM movie";
			}else if(!ID.equals("")){
				sqlNaredba="SELECT * FROM movie WHERE id= '" + ID + "'";
			}else if(!naziv.equals("")){
				sqlNaredba="SELECT * FROM movie WHERE title like '%" + naziv + "%'";
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
	
	public static Vector getVrste(String ID,  String naziv){
		Vector rowData = new Vector();
		try {
			rowData.clear();
			String sqlNaredba = "";
			if(ID.equals("") && naziv.equals("")){
				sqlNaredba="SELECT * FROM movie" ;
			}else if(!ID.equals("")){
				sqlNaredba="SELECT * FROM movie WHERE id= '" + ID + "'";
			}else if(!naziv.equals("")){
				sqlNaredba="SELECT * FROM movie WHERE title like '%" + naziv + "%'";
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
