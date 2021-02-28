package search.outil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import search.DBConection;
import search.variableStatic;

public class ChannelGetDataFromDatabaseSIS {
	
	public static String DataBase_ip = "172.6.46.2";
	public static String DataBase_name = "jcxdb";
	public static String DataBase_username = "sa";
	public static String DataBase_password = "sync877472.";
	public static String[] fileds_list = 
		{"CLSBDH","HPZL","HPHM","FDJH","CSYS","SYXZ",
		"CCDJRQ","JYRQ","JYYXQZ","BXZZRQ","RLZL",
		"GL","ZS","ZJ","QLJ","HLJ",
		"ZZL","ZBZL","CCRQ","QDXS","ZCZS","ZCZW","ZZS",
		"CLPP1","CLXH","SYR","CLLX","CWKC","CWKK","CWKG","CLYT"};

	public static String table_name = "jcxdb.dbo.J_VEH_INFO";
	
	public static ResultSet rs = null;
	public static Statement stmt = null;
	public static String sql="";
	
	public static String SQLGen (String [] fields, String table_name, String CPH) {
		String SQL = "select TOP 1";
		for (String s: fields) {
			SQL+= (s+",");
		}
		SQL = SQL.substring(0, SQL.length()-1);
		SQL = SQL + " ";
		SQL+= (" from "+ table_name) + " where HPHM  = '" + CPH +"' ORDER BY JYRQ desc;";
		return SQL;
	}
	
	
	public static HashMap<String,String> extractInfoFromDatabase(String [] fields, String table_name, String CPH) throws ClassNotFoundException, SQLException
	{
		DBConection db = new DBConection(DataBase_ip,DataBase_name,DataBase_username,DataBase_password);
		HashMap<String,String> result_map = new HashMap<String, String>();
		sql = SQLGen(fields,table_name,CPH);
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
		 HashMap<String,String> result_map = extractInfoFromDatabase(fileds_list,table_name,"晋DLQ718");
		 System.out.println(result_map.get("HPHM"));
		 
	}

}
