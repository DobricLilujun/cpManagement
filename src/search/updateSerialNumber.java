package search;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import search.outil.OpSqliteDB;

public class updateSerialNumber {

	public static void main(String args[]) throws Exception {
		
		OpSqliteDB db = new OpSqliteDB("DatabaseName.db");
		Protection.readValue_NoEncrypt("conf.properties", "browserString");
	    db.update("jkxlh_interface", Protection.readValue_NoEncrypt("conf.properties", "jkxlh_interface"));
	    
	    
	}
}
