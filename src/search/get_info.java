package search;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class get_info 
{
	LinkedList<String> result = new LinkedList<String>();
	static String cname;
	static String ctype;
	static String cnum;
	boolean isRun =false;
	public LinkedList<String> get(String s1,String s2,int flag,String conn1)
	{
		DBConection db = new DBConection(flag,conn1);
		ResultSet rs = null;
		Statement stmt = null;
		String sql="";
		
		if(flag==0)
		{
			
//			sql = "select DW,MakeDate,CPH,DJDate,DPH,PZLBStr,KilomCount,CLLBXStr,FDJH,FDJXH,changPH,XingHao,PaiLiang,EDGLRPM,EDGL,ZCZL,ZBZL,SYXZStr from CarInfo where CPH='"+s1+"'and PZLBStr ='"+s2+"';";
			sql = "select Car_ID from CarInfo where Car_CPH='"+s1+"'and Car_PZLBStr ='"+s2+"';";
			try {
				stmt = (Statement) db.conn.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				rs = (ResultSet)stmt.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				while(rs.next())
				{
					result.add(rs.getString("DW"));
					result.add(rs.getString("MakeDate").substring(0,10));
					result.add(rs.getString("CPH"));
					result.add(rs.getString("DJDate").substring(0,10));
					result.add(rs.getString("DPH"));
					result.add(rs.getString("PZLBStr"));
					result.add(rs.getString("KilomCount"));
					result.add(rs.getString("CLLBXStr"));
					result.add(rs.getString("FDJH"));
					result.add(rs.getString("FDJXH"));
					result.add(rs.getString("changPH"));
					result.add(rs.getString("XingHao"));
					result.add(rs.getString("PaiLiang"));
					result.add(rs.getString("EDGLRPM"));
					result.add(rs.getString("EDGL"));
					result.add(rs.getString("ZCZL"));
					result.add(rs.getString("ZBZL"));
					result.add(rs.getString("SYXZStr"));
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			};
			try {
				rs.close();
				db.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(flag==1)
		{
			sql = "select DW,MakeDate,CPH,DJDate,DPH,PZLBStr,KilomCount,CLLBXStr,FDJH,FDJXH,changPH,XingHao,PaiLiang,EDGLRPM,EDGL,ZCZL,ZBZL,ZKRS,ZCCD,ZCKD,ZCGD,QDXS,QDLLTGG,JIANCBGDBH from CarInfo where CPH='"+s1+"'and PZLBStr ='"+s2+"';";
			try {
				stmt = (Statement) db.conn.createStatement();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
			try {
				rs = (ResultSet)stmt.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				while(rs.next())
				{
					result.add(rs.getString("DW"));
					result.add(rs.getString("MakeDate").substring(0,10));
					result.add(rs.getString("CPH"));
					result.add(rs.getString("DJDate").substring(0,10));
					result.add(rs.getString("DPH"));
					result.add(rs.getString("PZLBStr"));
					result.add(rs.getString("KilomCount"));
					result.add(rs.getString("CLLBXStr"));
					result.add(rs.getString("FDJH"));
					result.add(rs.getString("FDJXH"));
					result.add(rs.getString("changPH"));
					result.add(rs.getString("XingHao"));
					result.add(rs.getString("PaiLiang"));
					result.add(rs.getString("EDGLRPM"));
					result.add(rs.getString("EDGL"));
					result.add(rs.getString("ZCZL"));
					result.add(rs.getString("ZBZL"));
					result.add(rs.getString("ZKRS"));
					result.add(rs.getString("ZCCD"));
					result.add(rs.getString("ZCKD"));
					result.add(rs.getString("ZCGD"));
					result.add(rs.getString("QDXS"));
					result.add(rs.getString("QDLLTGG"));
					result.add(rs.getString("JIANCBGDBH"));
					
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			};
			try {
				rs.close();
				db.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("The flag is wrong!");
		}
		return result;
	
	}


}