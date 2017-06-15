package app;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class actorUpiti {
	
	public static Vector getKolone( String fn, String ln, String id, String mov){
		Vector columnNames = new Vector();
		try {
			columnNames.clear();
			String sqlNaredba = "";
			if(!fn.equals("") || !ln.equals("") || !id.equals("")){
				sqlNaredba = "SELECT first_name, last_name, id FROM actor WHERE first_name ='" + fn + "' or last_name = '" + ln + "'or id = '" + id + "'";
			}else if(!mov.equals("")){
				sqlNaredba = "select a.first_name, a.last_name from actor as a join actor_movie as am join" +	
						" (select id, title from movie where title = '" + mov + "') as m where am.id_movie = m.id and am.id_actor = a.id";
			}else{
				sqlNaredba ="SELECT * FROM actor";		
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
	
	public static Vector getVrste( String fn, String ln, String id, String mov){
		Vector rowData = new Vector();
		try {
			rowData.clear();
			String sqlNaredba = "";
			if(!fn.equals("") || !ln.equals("") || !id.equals("")){
				sqlNaredba = "SELECT  first_name, last_name, id FROM actor WHERE first_name ='" + fn + "' or last_name='" + ln + "'or id = '" + id + "'";
			}else if(!mov.equals("")){
				sqlNaredba = "select a.first_name, a.last_name from actor as a join actor_movie as am join" +	
						" (select id, title from movie where title = '" + mov + "') as m where am.id_movie = m.id and am.id_actor = a.id";
			}else{
				sqlNaredba ="SELECT * FROM actor";
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
	

}
