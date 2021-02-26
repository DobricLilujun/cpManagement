package search.outil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import search.DBConection;
import search.variableStatic;

public class ChannelGetDataFromDatabaseHY {
	
	public static String DataBase_ip = "192.168.49.109";
	public static String DataBase_name = "newgajck_38900";
	public static String DataBase_username = "sa";
	public static String DataBase_password = "newgajck_18565";
	public static String[] fileds_list = 
		{"DW","MakeDate","CPH","DJDate","DPH","PZLBStr",
		"KilomCount","CLLBXStr","FDJH","FDJXH","changPH",
		"XingHao","PaiLiang","EDGLRPM","EDGL","ZCZL",
		"ZBZL","ZKRS","ZCCD","ZCKD","ZCGD","QDXS","QDLLTGG","JIANCBGDBH"};
	public static String table_name = "CarDetInfo";
	
	public static ResultSet rs = null;
	public static Statement stmt = null;
	public static String sql="";
	
	public static String SQLGen (String [] fields, String table_name, String CPH, String PZLBStr) {
		String SQL = "select";
		for (String s: fields) {
			SQL+= (s+",");
		}
		SQL.substring(0, SQL.length());
		SQL+= ("from"+ table_name) + "where CPH = '" + CPH + "' and PZLBStr = '"+ PZLBStr +"';";
		return SQL;
	}
	
	
	public static HashMap<String,String> extractInfoFromDatabase(String [] fields, String table_name, String CPH, String PZLBStr) throws ClassNotFoundException, SQLException
	{
		DBConection db = new DBConection(DataBase_ip,DataBase_name,DataBase_username,DataBase_password);
		HashMap<String,String> result_map = new HashMap<String, String>();
		String SQL = SQLGen(fields,table_name,CPH,PZLBStr);
		try {
			stmt = (Statement) db.conn.createStatement();
			rs = (ResultSet)stmt.executeQuery(sql);
			while(rs.next())
			{
				for (String s: fields) {
					result_map.put(s, rs.getString(s));
				}	
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		rs.close();
		db.close();
		return result_map;
	}
	
	 public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		 数据库加载器
		 HashMap<String,String> result_map = extractInfoFromDatabase(fileds_list,table_name,"晋DLQ718",variableStatic.pzlb[0]);
		 System.out.println(result_map.get("CPH"));
		 
	}

}
