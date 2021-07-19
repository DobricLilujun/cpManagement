package search.outil;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import search.commonUtil;
import search.variableStatic;


public class OpSqliteDB {

   Connection c;
   Statement stmt;
   ResultSet rs;

   /**
    * 连接到一个现有的数据库。如果数据库不存在， 那么它就会被创建，最后将返回一个数据库对象。
    */
    public OpSqliteDB(String databaseName) {
       try {
           File file = new File("");
           String filePath = file.getCanonicalPath();
           String DbPath = filePath+ "\\resource\\database\\sqlite\\"+ databaseName;
           Class.forName("org.sqlite.JDBC");
           c = DriverManager.getConnection("jdbc:sqlite:"+DbPath);
//         System.out.println("Opened database successfully");
           stmt = c.createStatement();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
//   关闭数据库信息
   public void after() {
       try {
           stmt.close();
           c.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
   
// 插入 一条 加密数据
   public static void insertCarData () throws Exception {
	   SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
	   String nowDate=df.format(new Date());//格式化当前日期
	   String key = "qwrwrww十多个";
	   MD5 mt= new MD5(key, "utf-8");
	   OpSqliteDB db = new OpSqliteDB("DatabaseName.db");
	   String sql = "INSERT INTO UserTable VALUES(null,";
	   sql = sql + "'"+mt.encode(nowDate) + "',";

	   for (int i=0; i< variableStatic.qrfileds.length;i++)
       { 
		   String strtemp = (String)commonUtil.resultMap.get(variableStatic.qrfileds[i]);
			if (strtemp!=null)
			{
				sql += "'"+mt.encode(strtemp)+"',";
			}else {
				sql += "'"+"',";
			}
       }
	   sql = sql.substring(0,sql.length()-1)+")";
	   System.out.println(sql);
       try (
    		   PreparedStatement pstmt_UPDATE = db.c.prepareStatement(sql);
    	   ) 
       {
    	   pstmt_UPDATE.executeUpdate();
           System.out.println("成功插入数据库中一条数据");
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }
	   db.after();  
   }
   
//   判断是否符合用户的要求
   public static boolean verifyIsOkForUser() throws Exception {
	   String key = "qwrwrww十多个";
	   MD5 mt= new MD5(key, "utf-8");
	   OpSqliteDB db = new OpSqliteDB("DatabaseName.db");
	   String sql = "SELECT * FROM UserTable order by id desc limit 1";
	   try {
			db.rs = (ResultSet)db.stmt.executeQuery(sql);
			while(db.rs.next())
			{
				 Date now_date = new Date();
				 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
				 String nowDate=df.format(now_date);//格式化当前日期
			     String data = mt.decode(db.rs.getString("TDATE"));
			     Date last_date = df.parse(data);
			     int i = now_date.compareTo(last_date);
//			     System.out.println(data);
			     if (i>0) {
			    	 commonUtil.log.printInfo("检验反破解成功！");
			    	 db.after();
			    	 return true;
			     }
			     else {
			    	 commonUtil.log.printInfo("检验反破解失败！");
			    	 commonUtil.log.printErr ("检验反破解失败！");
			    	 db.after();
			    	 return false;
			     }
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	   
		return false;
   }
//   根据车牌号和 车辆类型去查询
   public static HashMap<String,String> queryCardata (String hphm) throws Exception {
	   String key = "qwrwrww十多个";
	   MD5 mt= new MD5(key, "utf-8");
	   OpSqliteDB db = new OpSqliteDB("DatabaseName.db");
	   String sql = "SELECT * FROM UserTable WHERE platnum = '" + mt.encode(hphm) +"' order by id limit 1";
	   System.out.println(sql);
	   db.stmt.executeUpdate(sql);
	   HashMap<String,String> result_map = new HashMap<String, String>();
		try {
			db.rs = (ResultSet)db.stmt.executeQuery(sql);
			while(db.rs.next())
			{
				for (String s: variableStatic.qrfileds) {
//					System.out.println(s);
					if (s.equals("${qdxs}")) {break;}
//					System.out.println(m	t.decode(db.rs.getString(s.substring(2,s.length()-1))));
					result_map.put(s, mt.decode(db.rs.getString(s.substring(2,s.length()-1))));
				}
				result_map.put("TDATE", db.rs.getString("TDATE"));
			}
//			System.out.println(mt.decode(result_map.get("TDATE")));
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		db.after();
		return result_map;
   }
   
// 在数据库中更新数据  
   public static void update(String attr,String content) throws Exception {
	   String key = "qwrwrww十多个";
	   MD5 mt= new MD5(key, "utf-8");
	   OpSqliteDB db = new OpSqliteDB("DatabaseName.db");
	   String sql = "update ConfigTable SET CONTENT ='" +mt.encode(content) + "' WHERE ID = '" + mt.encode(attr) + "';";
	   db.stmt.executeUpdate(sql);
	   db.after();
   }
//   判断读取数据是否正确
   public static boolean IsCorrect() throws Exception {
	   String result = "";
	   String key = "qwrwrww十多个";
	   MD5 mt= new MD5(key, "utf-8");
	   OpSqliteDB db = new OpSqliteDB("DatabaseName.db");
	   String sql = "select TDATE FROM UserTable order by TDATE limit 1;";
	   db.stmt.executeUpdate(sql);
		try {
			db.rs = (ResultSet)db.stmt.executeQuery(sql);
			while(db.rs.next())
			{
				result = mt.decode(db.rs.getString("TDATE"));
				System.out.println(result);
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	   db.after();
	   return false;
   }
// 在数据库中查询数据  
   public static String search(String attr) throws Exception {
	   String result = "";
	   String key = "qwrwrww十多个";
	   MD5 mt= new MD5(key, "utf-8");
	   OpSqliteDB db = new OpSqliteDB("DatabaseName.db");
	   String sql = "SELECT * FROM ConfigTable WHERE ID = '" + mt.encode(attr) + "';";
	   db.stmt.executeUpdate(sql);
		try {
			db.rs = (ResultSet)db.stmt.executeQuery(sql);
			while(db.rs.next())
			{
				result = mt.decode(db.rs.getString("CONTENT"));
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		db.after();
		return result;
   }
   
//   在数据库中插入数据 
   public static void insert(String attr, String content) throws Exception {
	   String result = "";
	   String key = "qwrwrww十多个";
	   MD5 mt= new MD5(key, "utf-8");
	   OpSqliteDB db = new OpSqliteDB("DatabaseName.db");
	   String sql = "INSERT INTO ConfigTable VALUES ('"+ mt.encode(attr)+"','"+mt.encode(content)+"');";
//	   System.out.println(sql);
	   db.stmt.executeUpdate(sql);
	   db.after();
   }
   
   
// 在数据库中删除数据 
   public static void delete(String attr) throws Exception {
	   String result = "";
	   String key = "qwrwrww十多个";
	   MD5 mt= new MD5(key, "utf-8");
	   OpSqliteDB db = new OpSqliteDB("DatabaseName.db");
	   String sql = "DELETE FROM ConfigTable where  ID = '"+ mt.encode(attr)+"';";
//	   System.out.println(sql);
	   db.stmt.executeUpdate(sql);
	   db.after();
   }
// TD means 1 query time date 精确到时分秒
   
//   创建数据表
   public void createTable() throws SQLException {
       String sql = "CREATE TABLE UserTable " 
                   + "(id integer PRIMARY KEY autoincrement, TDATE TEXT NOT NULL,";
       for (int i=0; i< variableStatic.qrfileds.length;i++)
       {
    	   sql = sql+  variableStatic.qrfileds[i].substring(2,variableStatic.qrfileds[i].length()-1)+" TEXT,";
       }
       sql = sql.substring(0,sql.length()-1)+");";
       System.out.println(sql);
       stmt.executeUpdate(sql);
       
   }
   
//   public void createTable() throws SQLException {
//       String sql = "CREATE TABLE ConfigTable " 
//                   + "(ID TEXT PRIMARY KEY, CONTENT TEXT NOT NULL)";
////       System.out.println(sql);
//       stmt.executeUpdate(sql);
//   }
//   
//   public void createTable() throws SQLException {
//       String sql = "CREATE TABLE UserTable2 " 
//                   + "(TDATE TEXT PRIMARY KEY NOT NULL,";
//       for (int i=0; i< variableStatic.qrfileds.length;i++)
//       {
//    	   sql = sql+  variableStatic.qrfileds[i].substring(2,variableStatic.qrfileds[i].length()-1)+" TEXT,";
//       }
//       sql = sql.substring(0,sql.length()-1)+");";
//       System.out.println(sql);
//       stmt.executeUpdate(sql);
//   }
// 在数据库中进行查询
   public void select() throws SQLException {
       ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY;");
       while (rs.next()) {
          int id = rs.getInt("id");
          String name = rs.getString("name");
          int age = rs.getInt("age");
          String address = rs.getString("address");
          float salary = rs.getFloat("salary");
//          System.out.println("ID = " + id);
//          System.out.println("NAME = " + name);
//          System.out.println("AGE = " + age);
//          System.out.println("ADDRESS = " + address);
//          System.out.println("SALARY = " + salary);
//          System.out.println("--------");
       }
   }


//   public void delete() throws SQLException {
//       c.setAutoCommit(false);
//       String sql = "DELETE from COMPANY where ID=2;";
//       stmt.executeUpdate(sql);
//       c.commit();
//
//       ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY;");
//       while (rs.next()) {
//          int id = rs.getInt("id");
//          String name = rs.getString("name");
//          int age = rs.getInt("age");
//          String address = rs.getString("address");
//          float salary = rs.getFloat("salary");
////          System.out.println("ID = " + id);
////          System.out.println("NAME = " + name);
////          System.out.println("AGE = " + age);
////          System.out.println("ADDRESS = " + address);
////          System.out.println("SALARY = " + salary);
////          System.out.println("--------");
//       }
//   }
   
   /**
    * Read the file and returns the byte array
    * @param file
    * @return the bytes of the file
    */
   private byte[] readFile(String file) {
       ByteArrayOutputStream bos = null;
       try {
           File f = new File(file);
           FileInputStream fis = new FileInputStream(f);
           byte[] buffer = new byte[1024];
           bos = new ByteArrayOutputStream();
           System.out.println(file);
           for (int len; (len = fis.read(buffer)) != -1;) {
               bos.write(buffer, 0, len);
           }
       } catch (FileNotFoundException e) {
           System.err.println(e.getMessage());
       } catch (IOException e2) {
           System.err.println(e2.getMessage());
       }
       return bos != null ? bos.toByteArray() : null;
   }
   

//  更新指定的文件到数据库
   public void updatePicture(String ID, String filename) {
       // update sql
//	   String insertSQL = "INSERT INTO WORDTable VALUES(?,?)";
       String updateSQL = "UPDATE WORDTable "
               + "SET CONTENT = ? "
               + "WHERE ID=?";

       try (
               PreparedStatement pstmt_UPDATE = c.prepareStatement(updateSQL);
//               PreparedStatement pstmt_INSERT = c.prepareStatement(insertSQL);
    		   ) {

           // set parameters
    	   pstmt_UPDATE.setBytes(1, readFile(filename));
    	   pstmt_UPDATE.setString(2, ID);
//    	   pstmt_INSERT.setString(2, "");
//    	   pstmt_INSERT.setString(1, ID);


//    	   pstmt_INSERT.executeUpdate();
    	   pstmt_UPDATE.executeUpdate();
           System.out.println("Stored the file in the BLOB column.");

       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }
   }
   
// 读取数据库文件
   public void readPicture(	String ID, String filename) {
       // update sql
       String selectSQL = "SELECT CONTENT FROM WORDTable WHERE ID=?";
       ResultSet rs = null;
       FileOutputStream fos = null;
       PreparedStatement pstmt = null;

       try {
           pstmt = c.prepareStatement(selectSQL);
           pstmt.setString(1, ID);
           rs = pstmt.executeQuery();

           // write binary stream into file
           File file = new File("resource\\temp\\"+filename);
           fos = new FileOutputStream(file);

           System.out.println("Writing BLOB to file " + file.getAbsolutePath());
           while (rs.next()) {
               InputStream input = rs.getBinaryStream("CONTENT");
               byte[] buffer = new byte[1024];
               while (input.read(buffer) > 0) {
                   fos.write(buffer);
               }
           }
       } catch (SQLException | IOException e) {
           System.out.println(e.getMessage());
       } finally {
           try {
               if (rs != null) {
                   rs.close();
               }
               if (pstmt != null) {
                   pstmt.close();
               }

               if (c != null) {
                   c.close();
               }
               if (fos != null) {
                   fos.close();
               }

           } catch (SQLException | IOException e) {
               System.out.println(e.getMessage());
           }
       }
   }
   
   public static void main(String[] args) throws Exception 
   { 
//	   OpSqliteDB.queryCardata("晋D4207","挂车");
//	   OpSqliteDB.verifyIsOkForUser();
//	   OpSqliteDB db = new OpSqliteDB("DatabaseName.db");
//	   OpSqliteDB.IsCorrect();
//	   db.createTable();
//	   db.delete("DataBase_ip_HY_COMMMON");
//	   db.delete("cpName");
//	   db.insert("cpName", "长治市汽车检测有限公司");
//	   System.out.println(search("cpName"));
//	   db.insert("browserString", "D:\\360 浏览器\\360se6\\Application\\360se.exe");
//	   db.update("date_limit", "2021-03-07");
//	   db.update("date_limit", "2021-03-07");
//	   db.update("authority", "2");
//	   db.insert("dwjgdm", "001400000149");
//	   db.insert("dwjgdm_URL", "1400000149");
//	   db.insert("DataBase_password_HY_COMMMON", "svrcomputer");
//	   db.insert("DataBase_ip_SIS_COMMMON", "172.6.46.2");
//	   db.insert("DataBase_name_SIS_COMMMON", "jcxdb");
//	   db.insert("DataBase_username_SIS_COMMMON", "sa");
//	   db.insert("DataBase_password_SIS_COMMMON", "sync877472.");
//	   
//	   db.insert("url_interface", "http://172.6.46.2/jcxws/TmriOutNewAccess.asmx?wsdl");
//	   db.insert("jkxlh_interface", "7D1A09090106170400158195E6FCF3E2F28C8AF3828AE6FB868FDEC7D5C2D18CD3D0CFDEB9ABCBBED2B5CEF1CFB5CDB3");
//	   db.insert("jkdh_interface", "18C49");
//	   db.insert("cjsbdh_interface", "510101199001011234");
//	   db.insert("zdbs_interface", "172.6.46.103"); 
	   
	   
//	   db.after();
	   OpSqliteDB app = new OpSqliteDB("DatabaseName.db");
//	   app.createTable();
//        app.updatePicture("xls委托书", "resource\\file\\委托书.xlsx");
//        app.updatePicture("xls人工检验表1", "resource\\file\\人工检验表1.xlsx");
//        app.updatePicture("xls人工检验表2", "resource\\file\\人工检验表2.xlsx");
//        app.updatePicture("xls汽车排放外检表", "resource\\file\\汽车排放外检表.xlsx");
//        app.updatePicture("xls牌证申请表", "resource\\file\\牌证申请表.xlsx");
////      app.updatePicture("xls补充申请表","resource\\file\\补充申请表.docx");
//        app.updatePicture("xls载货汽车表", "resource\\file\\载货汽车表.xlsx");
//        app.updatePicture("xls牵引车辆表", "resource\\file\\牵引车辆表.xlsx");
//        app.updatePicture("xls客车表", "resource\\file\\客车表.xlsx");
//        app.updatePicture("xls挂车表", "resource\\file\\挂车表.xlsx");
//        app.updatePicture("xls性能检测判定表", "resource\\file\\性能检测判定表.xlsx");
//        app.updatePicture("补充申请表","resource\\file\\补充申请表.docx");
        
        app.updatePicture("xls委托书", "resource\\file\\委托书.xls");
        app.updatePicture("xls人工检验表1", "resource\\file\\人工检验表1.xls");
        app.updatePicture("xls人工检验表2", "resource\\file\\人工检验表2.xls");
        app.updatePicture("xls汽车排放外检表", "resource\\file\\汽车排放外检表.xls");
        app.updatePicture("xls牌证申请表", "resource\\file\\牌证申请表.xls");
//      app.updatePicture("xls补充申请表","resource\\file\\补充申请表.docx");
        app.updatePicture("xls载货汽车表", "resource\\file\\载货汽车表.xls");
        app.updatePicture("xls牵引车辆表", "resource\\file\\牵引车辆表.xls");
        app.updatePicture("xls客车表", "resource\\file\\客车表.xls");
        app.updatePicture("xls挂车表", "resource\\file\\挂车表.xls");
        app.updatePicture("xls性能检测判定表", "resource\\file\\性能检测判定表.xls");
        app.updatePicture("补充申请表","resource\\file\\补充申请表.docx");
//        app.readPicture("客车表","客车表.docx");
//     app.updatePicture("委托书", "resource\\file\\委托书.docx");
//     app.updatePicture("人工检验表", "resource\\file\\人工检验表.docx");
//     app.updatePicture("汽车排放外检表", "resource\\file\\汽车排放外检表.docx");
//     app.updatePicture("牌证申请表", "resource\\file\\牌证申请表.docx");
//     app.updatePicture("补充申请表","resource\\file\\补充申请表.docx");
//     app.updatePicture("载货汽车表", "resource\\file\\载货汽车表.docx");
//     app.updatePicture("牵引车辆表", "resource\\file\\牵引车辆表.docx");
//     app.updatePicture("客车表", "resource\\file\\客车表.docx");
//       app.updatePicture("挂车表", "resource\\file\\挂车表.docx");
//       app.updatePicture("性能检测判定表", "resource\\file\\性能检测判定表.docx");
   }
}