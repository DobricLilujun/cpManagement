package search.outil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.swing.JOptionPane;

import search.DBConection;
import search.commonUtil;
import search.variableStatic;

public class ChannelGetDataFromDatabaseSIS {
	
//	public static String DataBase_ip = "172.6.46.2";
//	public static String DataBase_name = "jcxdb";
//	public static String DataBase_username = "sa";
//	public static String DataBase_password = "sync877472.";
	public static String DataBase_ip = "";
	public static String DataBase_name = "";
	public static String DataBase_username = "";
	public static String DataBase_password = "";
	
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
	
	
	public static HashMap<String,String> extractInfoFromDatabase(String [] fields, String table_name, String CPH) throws Exception
	{
		DataBase_ip = commonUtil.DataBase_ip_SIS_COMMMON;
		DataBase_name = commonUtil.DataBase_name_SIS_COMMMON;
		DataBase_username = commonUtil.DataBase_username_SIS_COMMMON;
		DataBase_password = commonUtil.DataBase_password_SIS_COMMMON;
		
		DBConection db = new DBConection(DataBase_ip,DataBase_name,DataBase_username,DataBase_password);
		HashMap<String,String> result_map = new HashMap<String, String>();
		sql = SQLGen(fields,table_name,CPH);
		int searchDataTimes = 0; 
		try {
			stmt = (Statement) db.conn.createStatement();
			rs = (ResultSet)stmt.executeQuery(sql);
			while(rs.next())
			{
				for (String s: fields) {
					if (!s.equals("")) {
						searchDataTimes++;
					}
					result_map.put(s, rs.getString(s));
				}	
			}
			commonUtil.log.printInfo("成功从赛斯数据库中提取出:"+searchDataTimes+"个有效数据; "+"总查询字段数为:"+searchDataTimes+"个。");
		} catch (SQLException e) 
		{
			commonUtil.log.printErr("赛斯数据库连接：IP="+DataBase_ip+" DBName=" +DataBase_name+ "出现问题！");
			commonUtil.log.printErr("连接赛斯数据库出现错误，请检查连接是否正常,提示如下方代码所示：");
			commonUtil.log.printErr(e.toString());
			commonUtil.log.printErr("可通过PING "+DataBase_ip+ "进行尝试");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "SIS数据库调取错误，请检查！");
		}
		rs.close();
		db.close();
		return result_map;
	}
	
	 public static void main(String[] args) throws Exception {
		
//		 数据库加载器
		 HashMap<String,String> result_map = extractInfoFromDatabase(fileds_list,table_name,"晋DLQ718");
		 System.out.println(result_map.get("HPHM"));
		 
	}

}
