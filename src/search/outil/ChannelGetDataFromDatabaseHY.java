package search.outil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import search.DBConection;
import search.variableStatic;

public class ChannelGetDataFromDatabaseHY {
	
	public static String DataBase_ip = "172.6.46.225";
	public static String DataBase_name = "newgajck_38900";
	public static String DataBase_username = "sa";
	public static String DataBase_password = "svrcomputer";
	public static String[] fileds_list = 
		{"DW","MakeDate","CPH","DJDate","DPH","PZLBStr",
		"KilomCount","CLLBXStr","FDJH","FDJXH","changPH",
		"XingHao","PaiLiang","EDGLRPM","EDGL","ZCZL",
		"ZBZL","ZKRS","ZCCD","ZCKD","ZCGD","QDXS","JCLSH","JCMaxNum","DLYSZH","SYXZStr"};
	public static String table_name = "CarDetInfo";
	
	public static ResultSet rs = null;
	public static Statement stmt = null;
	public static String sql="";
	
	public static String SQLGen (String [] fields, String table_name, String CPH, String PZLBStr) {
		String SQL = "select ";
		for (String s: fields) {
			SQL+= (s+",");
		}
		SQL = SQL.substring(0, SQL.length()-1);
		SQL = SQL + " ";
		SQL+= ("from "+ table_name) + " where CPH = '" + CPH + "' and PZLBStr = '"+ PZLBStr +"' order by JCMaxNum desc;";
		return SQL;
	}
	
	
	public static HashMap<String,String> extractInfoFromDatabase(String [] fields, String table_name, String CPH, String PZLBStr) throws ClassNotFoundException, SQLException
	{
		DBConection db = new DBConection(DataBase_ip,DataBase_name,DataBase_username,DataBase_password);
		HashMap<String,String> result_map = new HashMap<String, String>();
		sql = SQLGen(fields,table_name,CPH,PZLBStr);
		try {
			stmt = (Statement) db.conn.createStatement();
			rs = (ResultSet)stmt.executeQuery(sql);
			while(rs.next())
			{
				for (String s: fields) {
					System.out.println(rs.getString(s));
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
		 HashMap<String,String> result_map = extractInfoFromDatabase(fileds_list,table_name,"晋DZ211",variableStatic.pzlb[6]);
		 System.out.println(variableStatic.pzlb[1]);
		 
		 System.out.println(result_map.get("CPH"));
		 
	}

}
