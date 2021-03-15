package search;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import search.outil.OpSqliteDB;

public class updateConfigAndDataBase {

	public static void main(String args[]) throws Exception {
		
		String s = Protection.getSerialNumber("C");
		String computerName = Protection.getComputerName();
		BufferedWriter out = new BufferedWriter(new FileWriter("result.txt"));
        out.write(s);
        out.write("\n");
        out.write(computerName);
        out.close();
		Protection.writeProperties("key_HD", Protection.getSerialNumber("C"));
		Protection.writeProperties("computerName", Protection.getComputerName());
		Protection.writeProperties("last_activation_date", "2021-03-04");   
		OpSqliteDB db = new OpSqliteDB("DatabaseName.db");
		
		db.update("date_limit", "2021-03-07");
		Protection.readValue_NoEncrypt("conf.properties", "browserString");
//	    db.update("browserString", "D:\\360 浏览器\\360se6\\Application\\360se.exe");
//	    db.update("DataBase_ip_HY_COMMMON", "172.6.46.225");
//	    db.update("DataBase_username_HY_COMMMON", "sa");
//	    db.update("DataBase_password_HY_COMMMON", "svrcomputer");
//	    db.update("DataBase_ip_SIS_COMMMON", "172.6.46.2");
//	    db.update("DataBase_name_SIS_COMMMON", "jcxdb");
//	    db.update("DataBase_username_SIS_COMMMON", "sa");
//	    db.update("DataBase_password_SIS_COMMMON", "sync877472.");
//	    db.update("url_interface", "http://172.6.46.2/jcxws/TmriOutNewAccess.asmx?wsdl");
//	    db.update("jkxlh_interface", "7D1A09090106170400158195E6FCF3E2F28C8AF3828AE6FB868FDEC7D5C2D18CD3D0CFDEB9ABCBBED2B5CEF1CFB5CDB3");
//	    db.update("jkdh_interface", "18C49");
//	    db.update("cjsbdh_interface", "510101199001011234");
//	    db.update("zdbs_interface", "172.6.46.103");
	    
	    db.update("browserString", Protection.readValue_NoEncrypt("conf.properties", "browserString"));
	    db.update("DataBase_name_HY_COMMMON", Protection.readValue_NoEncrypt("conf.properties", "DataBase_name_HY_COMMMON"));
	    db.update("DataBase_ip_HY_COMMMON", Protection.readValue_NoEncrypt("conf.properties", "DataBase_ip_HY_COMMMON"));
	    db.update("DataBase_username_HY_COMMMON", Protection.readValue_NoEncrypt("conf.properties", "DataBase_username_HY_COMMMON"));
	    db.update("DataBase_password_HY_COMMMON", Protection.readValue_NoEncrypt("conf.properties", "DataBase_password_HY_COMMMON"));
	    db.update("DataBase_ip_SIS_COMMMON", Protection.readValue_NoEncrypt("conf.properties", "DataBase_ip_SIS_COMMMON"));
	    db.update("DataBase_name_SIS_COMMMON", Protection.readValue_NoEncrypt("conf.properties", "DataBase_name_SIS_COMMMON"));
	    db.update("DataBase_username_SIS_COMMMON", Protection.readValue_NoEncrypt("conf.properties", "DataBase_username_SIS_COMMMON"));
	    db.update("DataBase_password_SIS_COMMMON", Protection.readValue_NoEncrypt("conf.properties", "DataBase_password_SIS_COMMMON"));
	    db.update("url_interface", Protection.readValue_NoEncrypt("conf.properties", "url_interface"));
	    db.update("jkxlh_interface", Protection.readValue_NoEncrypt("conf.properties", "jkxlh_interface"));
	    db.update("jkdh_interface", Protection.readValue_NoEncrypt("conf.properties", "jkdh_interface"));
	    db.update("cjsbdh_interface", Protection.readValue_NoEncrypt("conf.properties", "cjsbdh_interface"));
	    db.update("zdbs_interface", Protection.readValue_NoEncrypt("conf.properties", "zdbs_interface"));
	    db.update("dwjgdm", Protection.readValue_NoEncrypt("conf.properties", "dwjgdm"));
	    db.update("dwjgdm_URL", Protection.readValue_NoEncrypt("conf.properties", "dwjgdm_URL"));
	    
	    
	}
}
