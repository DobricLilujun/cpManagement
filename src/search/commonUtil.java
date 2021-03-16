package search;

import java.util.HashMap;
import java.util.Map;

import search.outil.OpSqliteDB;

public class commonUtil {
	
	public static String COMPANY_NAME = "潞城市鑫达财会服务有限公司";
	public static String OUTPUT_XML_FILE_PAHT = "resource/output/result.xml";
	public static logSystem log ;
//	输入数据信息
	public static String PZHM_COMMMON = "";
	public static String PZLB_COMMMON = "";
	public static String HPZL_COMMMON = "";
	public static String CLSBDH_COMMMON = "";
	
//	数据库加密信息
//	华燕数据库
	public static String DataBase_ip_HY_COMMMON = "";
	public static String DataBase_name_HY_COMMMON = "";
	public static String DataBase_username_HY_COMMMON = "";
	public static String DataBase_password_HY_COMMMON = "";
//	赛斯数据库
	public static String DataBase_ip_SIS_COMMMON = "";
	public static String DataBase_name_SIS_COMMMON = "";
	public static String DataBase_username_SIS_COMMMON = "";
	public static String DataBase_password_SIS_COMMMON = "";
//	赛斯接口数据库
	public static String url_interface="";
	public static String jkxlh_interface = "";
	public static String jkdh_interface =  "";
	public static String cjsbdh_interface = "";
	public static String zdbs_interface = "";
	
	
//	用户鉴权信息
	
	public static String SoftwareUserName = "";
	public static String CompanyName = "";
	public static String SoftwarePassword = "";
	public static String HardDiskSerialName = "";
	public static String ComputerName = "";
	
//	public static String ComputerName = "";
	
	
	public static String XXDZ = "";
	public static String DH = "";
	public static String XZQH = "";
	public static String LJXSLC = "";
	public static String EDZS = "";
	public static String GS = "";
	public static String JQFS = "";
	public static boolean SFSSSQ = false;  //是否全时四驱
	public static boolean SFDKZ = false;   //是否驻车制动
	public static boolean SFKQXG = false;  //是否配备空气悬挂
	public static String JXLJZZXH = "";
	public static String DBCLBH = "";
	public static String ZGCS = "";
	public static String LTSL = "";
	public static String BSQXS = "";
	public static String ZXZSL = "";
	public static String CLSCCJ = "";
	public static String LTGGXH = "";
	public static boolean WTSisClicked = false;
	public static boolean RGJYBisClicked = false;
	public static boolean QCPFWJBisClicked = false;
	public static boolean PZSQBisClicked = false;
	public static boolean BCXXBisClicked = false;
	public static boolean ZHQCisClicked = false;
	public static boolean QYCLisClicked = false;
	public static boolean KCisClicked = false;
	public static boolean GCisClicked = false;
	public static boolean XNJCPDisClicked = false;
	public static boolean SFDTisClicked = true;
	
	public static Map<String, Object> resultMap = new HashMap<>();
	public static Map<String, Object> resultMap_excel = new HashMap<>();
	public static reptile_test rep = null;
	public static String HPZL = "";
	public static String qrCodeData = "";
	public static String dwjgdm = "";
	public static String dwjgdm_URL = "";
	public static String authority = ""; 
	
	public static int  ifPrint[] = {0,0,0,0,0,0,0,0,0,0};
	public static String QrString = "";
	public static String browserString = "";
	public static String url = "http://172.32.250.11:8090/jc/yt/loginout/login.yt";
	public static String PortNum = "COM7";
	public static String SCR = "";
	public static String CUIHUA_XINGHAO = "";
	public static String QUDONG_XINGSHI = "";
	
	public static String DateToFormat(String data) {
		 if (data.contains("/"))
		 {
			 String b[] = data.split(" ");
			 String c[] = b[0].split("/");
			 return(c[0]+ "年"+c[1]+ "月"+c[2]+ "日");
		 }
		 else if (data.contains("-")) {
			 String b[] = data.split(" ");
			 String c[] = b[0].split("-");
			 return(c[0]+ "年"+c[1]+ "月"+c[2]+ "日");
		 }else {
			 return "";
		 }
		
	}
	
//	该函数主要将数据 从 map 转出到 mapExcel中
	public static void MapToMapExcel() {
		for (Map.Entry<String,Object> entry :commonUtil.resultMap.entrySet()) {
			commonUtil.resultMap_excel.put(entry.getKey().substring(2,entry.getKey().length()-1), entry.getValue());
		}
	}
}
