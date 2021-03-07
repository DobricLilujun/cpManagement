package search.outil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import search.DBConection;
import search.commonUtil;
import search.variableStatic;

public class ChannelGetDataFromDatabaseHY {
	
	public static String DataBase_ip = "";
	public static String DataBase_name = "";
	public static String DataBase_username = "";
	public static String DataBase_password = "";
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
		DataBase_ip = commonUtil.DataBase_ip_HY_COMMMON;
		DataBase_name = commonUtil.DataBase_name_HY_COMMMON;
		DataBase_username = commonUtil.DataBase_username_HY_COMMMON;
		DataBase_password = commonUtil.DataBase_password_HY_COMMMON;
		DBConection db = new DBConection(DataBase_ip,DataBase_name,DataBase_username,DataBase_password);
		HashMap<String,String> result_map = new HashMap<String, String>();
		sql = SQLGen(fields,table_name,CPH,PZLBStr);
		try {
			stmt = (Statement) db.conn.createStatement();
			rs = (ResultSet)stmt.executeQuery(sql);
			while(rs.next())
			{
				for (String s: fields) {
					System.out.println(s+" : " +rs.getString(s));
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
		 HashMap<String,String> result_map = extractInfoFromDatabase(fileds_list,table_name,"新D456987",variableStatic.pzlb[0]);
		 System.out.println(variableStatic.pzlb[1]);
		 
		 System.out.println(result_map.get("CPH"));
		 
	}

}
