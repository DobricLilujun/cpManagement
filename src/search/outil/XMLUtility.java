package search.outil;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLUtility {
	
//  通过文件路径生成 HashMap
    public static HashMap<String, String> readStringXml(String filepath) throws DocumentException, FileNotFoundException {
    	  HashMap<String, String> map = new HashMap<>();
    	  SAXReader reader = new SAXReader();
    	  reader.setEncoding("UTF-8");
    	  FileInputStream in = new FileInputStream(new File(filepath));
    	  Document document = reader.read(in,"GBK");
    	  document.setXMLEncoding("GBK");
    	  Element root = document.getRootElement();
    	  Element bodyelement = root.element("body");
    	  List<Element> childElements = bodyelement.elements();
    	  
    	  for (Element child : childElements) {

	    	   List<Element> elementList = child.elements();
	    	   for (Element ele : elementList) {
	    		   map.put(ele.getName(),ele.getText());
	    	   }
    	  }
    	  return map;
        }
    
//   打印MAP的值
    public static void print(HashMap<String, String> map) {
    	for(Entry<String, String> entry : map.entrySet()){
    	    String mapKey = entry.getKey();
    	    String mapValue = entry.getValue();
    	    System.out.println(mapKey+":"+mapValue);
    	}
    }
	 public static void main(String[] args) throws DocumentException, FileNotFoundException 
	 {
		 String filepath = "resource/output/result.xml";
		 HashMap<String, String> map = readStringXml(filepath);
		 print (map);

	 }
}
