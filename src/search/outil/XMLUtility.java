package search.outil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import search.commonUtil;

public class XMLUtility {
	
//  通过文件路径生成 HashMap
    public static HashMap<String, String> readStringXml(String filepath) throws DocumentException, FileNotFoundException {
    	  HashMap<String, String> map = new HashMap<>();
    	  SAXReader reader = new SAXReader();
    	  reader.setEncoding("GBK");
    	  FileInputStream in = new FileInputStream(new File(filepath));
    	  Document document = reader.read(in,"UTF-8");
    	  document.setXMLEncoding("GBK");
    	  Element root = document.getRootElement();
    	  if (root.elements().size()==1) {
    		  Element headelement = root.element("head");
    		  List<Element> contentList = headelement.elements();
//    		  JOptionPane.showMessageDialog(null, "调取接口数据错误，错误内容:"+contentList.get(1).getText());
    		  commonUtil.log.printErr("调取接口数据失败，错误内容为："+contentList.get(1).getText());
    	  }
    	  else if(root.elements().size()==2) {
    		  int infoTimes = 0;
        	  Element bodyelement = root.element("body");
        	  List<Element> childElements = bodyelement.elements();
        	  for (Element child : childElements) {
    	    	   List<Element> elementList = child.elements();
    	    	   for (Element ele : elementList) {
    	    		   map.put(ele.getName(),ele.getText());
    	    		   infoTimes++;
    	    	   }
        	  }
    		  commonUtil.log.printInfo("成功调取数据接口！调取"+infoTimes+"个数据元素！");
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
