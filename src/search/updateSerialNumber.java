package search;

import search.outil.OpSqliteDB;

public class updateSerialNumber {

	public static void main(String args[]) throws Exception {
		Protection.readValue_NoEncrypt("conf.properties", "browserString");
		OpSqliteDB.update_data("jkxlh_interface", Protection.readValue_NoEncrypt("conf.properties", "jkxlh_interface"));
	    
	    
	}
}
