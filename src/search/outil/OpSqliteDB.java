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

public class OpSqliteDB {

   Connection c;
   Statement stmt;

   /**
    * 连接到一个现有的数据库。如果数据库不存在， 那么它就会被创建，最后将返回一个数据库对象。
    */
    OpSqliteDB(String databaseName) {
       try {
           File file = new File("");
           String filePath = file.getCanonicalPath();
           String DbPath = filePath+ "\\resource\\database\\sqlite\\"+ databaseName;
           Class.forName("org.sqlite.JDBC");
           c = DriverManager.getConnection("jdbc:sqlite:"+DbPath);
           System.out.println("Opened database successfully");
           stmt = c.createStatement();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   
   public void after() {
       try {
           stmt.close();
           c.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }

   public void createTable() throws SQLException {
       String sql = "CREATE TABLE WORDTable " 
                   + "(ID TEXT PRIMARY KEY NOT NULL,"
                   + " CONTENT BLOB NOT NULL)";
       stmt.executeUpdate(sql);
   }

   public void insert() throws SQLException {
       c.setAutoCommit(false);
       StringBuffer sb = new StringBuffer();
       sb.append("INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
               + "VALUES (1, 'Paul', 32, 'California', 20000.00 );\n");
       sb.append("INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " 
               + "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );\n");
       sb.append("INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
               + "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );\n");
       sb.append("INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
               + "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );");
       stmt.executeUpdate(sb.toString());
       c.commit();
   }

   public void select() throws SQLException {
       ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY;");
       while (rs.next()) {
          int id = rs.getInt("id");
          String name = rs.getString("name");
          int age = rs.getInt("age");
          String address = rs.getString("address");
          float salary = rs.getFloat("salary");
          System.out.println("ID = " + id);
          System.out.println("NAME = " + name);
          System.out.println("AGE = " + age);
          System.out.println("ADDRESS = " + address);
          System.out.println("SALARY = " + salary);
          System.out.println("--------");
       }
       rs.close();
   }

   public void update() throws SQLException {
       c.setAutoCommit(false);
       String sql = "UPDATE COMPANY set SALARY = 25000.00 where ID=1;";
       stmt.executeUpdate(sql);
       c.commit();

       ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY;");
       while (rs.next()) {
          int id = rs.getInt("id");
          String name = rs.getString("name");
          int age = rs.getInt("age");
          String address = rs.getString("address");
          float salary = rs.getFloat("salary");
          System.out.println("ID = " + id);
          System.out.println("NAME = " + name);
          System.out.println("AGE = " + age);
          System.out.println("ADDRESS = " + address);
          System.out.println("SALARY = " + salary);
          System.out.println("--------");
       }
       rs.close();
   }

   public void delete() throws SQLException {
       c.setAutoCommit(false);
       String sql = "DELETE from COMPANY where ID=2;";
       stmt.executeUpdate(sql);
       c.commit();

       ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY;");
       while (rs.next()) {
          int id = rs.getInt("id");
          String name = rs.getString("name");
          int age = rs.getInt("age");
          String address = rs.getString("address");
          float salary = rs.getFloat("salary");
          System.out.println("ID = " + id);
          System.out.println("NAME = " + name);
          System.out.println("AGE = " + age);
          System.out.println("ADDRESS = " + address);
          System.out.println("SALARY = " + salary);
          System.out.println("--------");
       }
       rs.close();
   }
   
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
   
   /**
    * Connect to the test.db database
    *
    * @return the Connection object
    */

   
   /**
    * Update picture for a specific material
    *
    * @param materialId
    * @param filename
    */
   public void updatePicture(String ID, String filename) {
       // update sql
	   String insertSQL = "INSERT INTO WORDTable VALUES(?,?)";
       String updateSQL = "UPDATE WORDTable "
               + "SET CONTENT = ? "
               + "WHERE ID=?";

       try (
               PreparedStatement pstmt_UPDATE = c.prepareStatement(updateSQL);
               PreparedStatement pstmt_INSERT = c.prepareStatement(insertSQL);
    		   ) {

           // set parameters
    	   pstmt_UPDATE.setBytes(1, readFile(filename));
    	   pstmt_UPDATE.setString(2, ID);
    	   pstmt_INSERT.setString(2, "");
    	   pstmt_INSERT.setString(1, ID);


    	   pstmt_INSERT.executeUpdate();
    	   pstmt_UPDATE.executeUpdate();
           System.out.println("Stored the file in the BLOB column.");

       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }
   }
   
   /**
    * read the picture file and insert into the material master table
    *
    * @param materialId
    * @param filename
    */
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
//	   OpSqliteDB db = new OpSqliteDB("DatabaseName.db");
//	   db.createTable();
//	   db.after();
	   OpSqliteDB app = new OpSqliteDB("DatabaseName.db");
//        app.updatePicture("委托书", "resource\\file\\委托书.docx");
//        app.updatePicture("人工检验表", "resource\\file\\人工检验表.docx");
//        app.updatePicture("汽车排放外检表", "resource\\file\\汽车排放外检表.docx");
//        app.updatePicture("牌证申请表", "resource\\file\\牌证申请表.docx");
//        app.updatePicture("补充申请表","resource\\file\\补充申请表.docx");
//        app.updatePicture("载货汽车表", "resource\\file\\载货汽车表.docx");
//        app.updatePicture("牵引车辆表", "resource\\file\\牵引车辆表.docx");
//        app.updatePicture("客车表", "resource\\file\\客车表.docx");
//        app.updatePicture("挂车表", "resource\\file\\挂车表.docx");
//        app.updatePicture("性能检测判定表", "resource\\file\\性能检测判定表.docx");
        app.readPicture("客车表","客车表.docx");
   }

}