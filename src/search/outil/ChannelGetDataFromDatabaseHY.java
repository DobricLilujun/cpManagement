package search.outil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.swing.JOptionPane;

import search.DBConection;
import search.commonUtil;
import search.variableStatic;

public class ChannelGetDataFromDatabaseHY {
	
	public static String DataBase_ip = "";
	public static String DataBase_name = "";
	public static String DataBase_username = "";
	public static String DataBase_password = "";
	
//	在这里 增加 华研数据库的查询字段
	public static String[] fileds_list = 
		{"DW","MakeDate","CPH","DJDate","DPH","PZLBStr",
		"KilomCount","CLLBXStr","FDJH","FDJXH","changPH",
		"XingHao","PaiLiang","EDGLRPM","EDGL","ZCZL",
		"ZBZL","ZKRS","ZCCD","ZCKD","ZCGD","QDXS","JCLSH","JCMaxNum","DLYSZH","SYXZStr"};
	
	public static String table_name = "CarDetInfo";
	public static ResultSet rs = null;
	public static Statement stmt = null;
	public static String sql="";
	
//	在这里 用于生成 指定的SQL
	public static String SQLGen (String [] fields, String table_name, String CPH, String PZLBStr) {
		String SQL = "select ";
		for (String s: fields) {SQL+= (s+",");}
		SQL = SQL.substring(0, SQL.length()-1);
		SQL = SQL + " ";
		SQL+= ("from "+ table_name) + " where CPH = '" + CPH + "' and PZLBStr = '"+ PZLBStr +"' order by JCMaxNum desc;";
		return SQL;
	}
	
//  通过访问华研数据库来进行数据库的导出 来进行 数据库导出
	public static HashMap<String,String> extractInfoFromDatabase(String [] fields, String table_name, String CPH, String PZLBStr) throws Exception
	{
//		将 数据库中所读出的一些华研数据库的参数，并进行一些参数的初始化 该初始化已经迁移到MainControl中
//		commonUtil.DataBase_ip_HY_COMMMON = OpSqliteDB.search("DataBase_ip_HY_COMMMON");
//		commonUtil.DataBase_name_HY_COMMMON = OpSqliteDB.search("DataBase_name_HY_COMMMON");
//		commonUtil.DataBase_username_HY_COMMMON = OpSqliteDB.search("DataBase_username_HY_COMMMON");
//		commonUtil.DataBase_password_HY_COMMMON = OpSqliteDB.search("DataBase_password_HY_COMMMON");
		
		DataBase_ip = commonUtil.DataBase_ip_HY_COMMMON;
		DataBase_name = commonUtil.DataBase_name_HY_COMMMON;
		DataBase_username = commonUtil.DataBase_username_HY_COMMMON;
		DataBase_password = commonUtil.DataBase_password_HY_COMMMON;
		
		DBConection db = new DBConection(DataBase_ip,DataBase_name,DataBase_username,DataBase_password);
		HashMap<String,String> result_map = new HashMap<String, String>();
//		连接数据库后 对数据进行查询
		sql = SQLGen(fields,table_name,CPH,PZLBStr);
		int searchDataTimes = 0;     // 记录查询的有效数据数
		try {
			stmt = (Statement) db.conn.createStatement();
			rs = (ResultSet)stmt.executeQuery(sql);
			while(rs.next())
			{
				for (String s: fields) {
					System.out.println(s+" : " +rs.getString(s));
					if (!s.equals("")) {
						searchDataTimes++;
					}
					result_map.put(s, rs.getString(s));
				}	
			}
			commonUtil.log.printInfo("成功从华燕数据库中提取出:"+searchDataTimes+"个有效数据; "+"总查询字段数为:"+searchDataTimes+"个。");
		} catch (SQLException e) {
//		连接数据库出现问题后，查询不停止
			commonUtil.log.printErr("华燕数据库连接：IP="+DataBase_ip+" DBName=" +DataBase_name+ "出现问题！");
			commonUtil.log.printErr("连接华燕数据库出现错误，请检查连接是否正常,提示如下方代码所示：");
			commonUtil.log.printErr(e.toString());
			commonUtil.log.printErr("可通过PING "+DataBase_ip+ "进行尝试");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "HY数据库调取错误，请检查！");
		}
		rs.close();
		db.close();
		return result_map;
	}
	
	 public static void main(String[] args) throws Exception {
		
//		 数据库加载器
		 HashMap<String,String> result_map = extractInfoFromDatabase(fileds_list,table_name,"新D456987",variableStatic.pzlb[0]);
		 System.out.println(variableStatic.pzlb[1]);
		 
		 System.out.println(result_map.get("CPH"));
		 
	}

}
