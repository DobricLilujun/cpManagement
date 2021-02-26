package search;
//#include <QtSql>
//import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;


//  obsolete
public class DBConection 
{
		
//		private static String URL;
//	    private static final String NAME="sa";
//	    private static final String PASSWORD="svrcomputer";
	    public Connection conn;
//	   public DBConection (int flag,String conn1)
//        {
//           
//            try {
//            	if((flag==0))
//            	{
//            		
////            		URL= conn1;
//            		URL= "jdbc:jtds:sqlserver://"+conn1+";DatabaseName=HBJCDB2019";
//            		
//            	}
//            	else
//            	{
////            		System.out.println("URL:"+URL);
//            		URL="jdbc:jtds:sqlserver://"+conn1+";DatabaseName=newgajck_18565";
////            		URL= conn1;
//            	}
//                Class.forName("net.sourceforge.jtds.jdbc.Driver");
//                conn = DriverManager.getConnection(URL,NAME,PASSWORD);
//                if(!conn.isClosed())
//                {
//                	System.out.println("Succeeded connecting to the Database!"); 
//                }
//            }
//                catch(ClassNotFoundException e)
//                {   
//                //数据库驱动类异常处理
//                  System.out.println("Sorry,can`t find the Driver!");   
//                	e.printStackTrace();   
//                }
//	             catch (SQLException e)
//	             {
//	                System.out.println("SQL操作错误");
//	                e.printStackTrace();
//	            }
//	             catch (Exception e) 
//            	{
//	                e.printStackTrace();
//	            } 
//            
//     
//        }
	   public void close()
        {
        	try
        	{
        		this.conn.close();
        	}catch(Exception e)
        	{
        		e.printStackTrace();
        	}
        }
	   
// 	   通过一套标准来启动JDBC
	   public DBConection (String DataBase_ip, String DataBase_name,String DataBase_username,String DataBase_password) throws ClassNotFoundException, SQLException
	   {
		   String URL= "jdbc:jtds:sqlserver://"+DataBase_ip+";DatabaseName="+DataBase_name;
		   Class.forName("net.sourceforge.jtds.jdbc.Driver");
           conn = DriverManager.getConnection(URL,DataBase_username,DataBase_password);
           if(!conn.isClosed())
           {
           	System.out.println("Succeeded connecting to the Database!"); 
           }
	   }

	public DBConection(int flag, String conn1) {
		// TODO Auto-generated constructor stub
	}
	   
}