package search.outil;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.rmi.RemoteException;
import java.util.HashMap;

import org.apache.axis.AxisFault;
import org.apache.axis.client.Service;
import org.dom4j.DocumentException;

import search.commonUtil;
import search.variableStatic;

public class ChannelGetDataFromInterface {
//	public static String url="http://172.6.46.2/jcxws/TmriOutNewAccess.asmx?wsdl";
//	public static String jkxlh = "7D1A09090106170400158195E6FCF3E2F28C8AF3828AE6FB868FDEC7D5C2D18CD3D0CFDEB9ABCBBED2B5CEF1CFB5CDB3";
//	public static String jkdh =  "18C49";
//	public static String cjsbdh = "510101199001011234";
//	public static String zdbs = "172.6.46.103";
	public static String url="";
	public static String jkxlh = "";
	public static String jkdh =  "";
	public static String cjsbdh = "";
	public static String zdbs = "";
	
	public ChannelGetDataFromInterface() {
	super();
	}
	
	public static TmriJaxRpcOutNewAccessSoapStub stub = null;
	
	private static void ensureStub() throws MalformedURLException, AxisFault{
		if(stub==null){
			String webserviceURL = url;
			URL url = new URL(webserviceURL);
			Service service = new Service();
			stub = new TmriJaxRpcOutNewAccessSoapStub(url, service);
		}
	}
	
	public static  HashMap<String, String>  exportDataFromInterface(String hphm, String hpzl, String clsbdh,String jyjgbh) throws MalformedURLException, RemoteException, FileNotFoundException, DocumentException
	{
		url= commonUtil.url_interface;
		jkxlh = commonUtil.jkxlh_interface;
		jkdh =  commonUtil.jkdh_interface;
		cjsbdh = commonUtil.cjsbdh_interface;
		zdbs = commonUtil.zdbs_interface;
		ensureStub();
		String result = "";
//		转变 为sis号牌种类
		String hpzl_sis = "";
		for (int i=0;i<variableStatic.types.length;i++) {
			if (hpzl.equals(variableStatic.types[i][1])) {
				hpzl_sis = variableStatic.types[i][0];
				break;
			}
		}
		
		String encrptXmlDoc ="<?xml version=\"1.0\" encoding=\"GBK\"?>\n<root>"
				+"\n<QueryCondition>\n<hphm>"
				+hphm+"</hphm>\n<hpzl>"
				+hpzl_sis+"</hpzl>\n<clsbdh>"
				+clsbdh+"</clsbdh>\n<jyjgbh>"
				+commonUtil.dwjgdm_URL+"</jyjgbh>\n</QueryCondition>\n</root>";
		
		
		TmriJaxRpcOutNewAccessLocator services = new TmriJaxRpcOutNewAccessLocator();
		result=stub.queryObjectOutNew("18",jkxlh,jkdh,cjsbdh,commonUtil.dwjgdm,"","","",zdbs,encrptXmlDoc);
//		System.out.println(result);
		try{
			result = URLDecoder.decode(result, "utf-8");
			FileWriter fw = null;
			try {
				//创建字符输出流对象，负责向文件内写入
				fw = new FileWriter(commonUtil.OUTPUT_XML_FILE_PAHT);
				//将str里面的内容读取到fw所指定的文件中
				fw.write(result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(fw!=null){
					try {
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
//		System.out.println("机动车检验过程开始信息:"+result);

		HashMap<String, String> map_result = XMLUtility.readStringXml(commonUtil.OUTPUT_XML_FILE_PAHT);
		
		return map_result;
	}
//	Obsolete
	public String doWrite() throws Exception{
			this.ensureStub();
			String result = "";
			String encrptXmlDoc ="<?xml version=\"1.0\" encoding=\"GBK\"?>\n<root>"
					+"\n<QueryCondition>\n<hphm>晋DUF109</hphm>\n<hpzl>02</hpzl>\n<clsbdh>"
					+"8993</clsbdh>\n<jyjgbh>1400000149</jyjgbh>\n</QueryCondition>\n</root>";
			System.out.println(encrptXmlDoc);
			String jkxlh = 
	"7D1A09090106170400158195E6FCF3E2F28C8AF3828AE6FB868FDEC7D5C2D18CD3D0CFDEB9ABCBBED2B5CEF1CFB5CDB3";
			
			TmriJaxRpcOutNewAccessLocator services = new TmriJaxRpcOutNewAccessLocator();
			System.out.println(stub);
			result=stub.queryObjectOutNew("18", jkxlh, "18C49", "510101199001011234","001400000149","","","","172.6.46.103",encrptXmlDoc);
//			result=stub.queryObjectOutNew("18",jkxlh,jkdh,cjsbdh,dwjgdm,"","","",zdbs,encrptXmlDoc);
			try{
				result = URLDecoder.decode(result, "utf-8");
			}catch(Exception ex){
				ex.printStackTrace();
			}
			System.out.println("机动车检验过程开始信息:"+result);
			return result;
		}
	
	  public static void main(String[] args) throws Exception 
    { 
	  HashMap<String,String> result_map = exportDataFromInterface("晋DY5882","01","3782",commonUtil.dwjgdm_URL);
	  System.out.println(result_map.get("hphm"));
//	  ChannelGetDataFromInterface c = new ChannelGetDataFromInterface();
//	  c.doWrite();
    } 

}
