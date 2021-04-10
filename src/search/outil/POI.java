package search.outil;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.dom4j.DocumentException;

import search.EncryUtil;
import search.QRCodeGenerate;
import search.commonUtil;
import search.dataTableCorrespond;
import search.variableStatic;


public class POI {


	
	/**
	 * 文件数据替换
	 * @author 23  *
	 */
	    
	    public static  Map<String, Object> getDataMap() {
	    	Map<String, Object> data = new HashMap<>();
	    	
	    	return data;
	    }
	    
	    public static  Map<String, Object> getPicMap() {
	    	Map<String, Object> pic = new HashMap<>();
	    	
	    	
	    	return pic;
	    }
	    
//	    从文件中拿到字段的加密数据对应 Channel 1 华研 Channel 2 赛斯 Channel 3 接口 Channel 4 文档打印
	    public static Map<String,String> GetDataCorrespondFromFile(String filepath,int Channel) throws IOException{
	    	
	    	Map<String, String> data = new HashMap<>();
	    	File file = new File (filepath);
	    	InputStream in = new BufferedInputStream(new FileInputStream(file));
	    	InputStreamReader ir = new InputStreamReader(in,"utf-8");
	    	BufferedReader br= new BufferedReader(ir);
	    	String line = "";
	    	while ((line=br.readLine())!=null) {
	    		String[] str = line.split(",");
	    		data.put(EncryUtil.decrypt(str[0]),EncryUtil.decrypt(str[Channel]));
	    	}
	    	
	    	return data;
	    }
	    
//	    从文件中拿到字段的非加密数据写入到文件中并加密
	    public static void writeDataCorrespondFromFile(String filepath,String outputpath) throws IOException{
	    	
	    	Map<String, String> data = new HashMap<>();
	    	File file = new File (filepath);
	    	File fout = new File (outputpath);
	    	InputStream in = new BufferedInputStream(new FileInputStream(file));
	    	FileOutputStream fos = new FileOutputStream(fout);
	    	InputStreamReader ir = new InputStreamReader(in,"utf-8");
	    	BufferedReader br= new BufferedReader(ir);
	    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	    	String line = "";
	    	while ((line=br.readLine())!=null) {
	    		String[] str = line.split(",");
	    		String result = "";
	    		for (int i=0;i<str.length;i++) {
	    			result = result+ EncryUtil.encrypt(str[i]);
	    			if (i!=str.length-1) {
	    				result = result+",";
	    			}
	    		}
	    		bw.write(result); 
	    		bw.newLine(); 
	    	}
	    	bw.close();
	    	br.close();
	    }
	    
//	    生成二维码，用于支持扫码
	    public static void createQrCode() throws Exception {
	    	
	    	String msg = "";
	    	String key = "qwrwrww十多个";
  		   	MD5 mt= new MD5(key, "utf-8");
	    	for (int i=0;i<variableStatic.qrfileds.length;i++) {
	    		if (i<variableStatic.qrfileds.length-1)
	    		{
//	    			System.out.println(variableStatic.qrfileds[i]);
	    			String strtemp = (String)commonUtil.resultMap.get(variableStatic.qrfileds[i]);
	    			if (strtemp!=null)
	    			{
	    				msg = msg +mt.encode(strtemp)+ ";";
	    			}else {
	    				msg = msg + ";";
	    			}	
	    		}
	    		else {
	    			String strtemp = (String)commonUtil.resultMap.get(variableStatic.qrfileds[i]);
	    			if (strtemp!=null)
	    			{
	    				msg = msg +mt.encode(strtemp);
	    			}
	    		}
	    	}
//	    	System.out.println(msg);
	    	QRCodeGenerate.writeQrCode(msg);
	    }
	    
//	    解析二维码数据,并生成指定的resultmap
	    public static void getQrCodeMsg(String msg) throws Exception {
	    	String key = "qwrwrww十多个";
  		   	MD5 mt= new MD5(key, "utf-8");
	    	String [] a = msg.split(";");
	    	for (int i =0;i< a.length;i++) {
	    		commonUtil.resultMap.put(variableStatic.qrfileds[i], mt.decode(a[i]));
	    	}
	    }
	    
//	    测试数据生成器
	    public static Map<String, Object> Test()
	    {
	    	Map<String, Object> data = new HashMap<>();
	    	data.put("${brand}", "解放牌");
	    	data.put("${owner}", "潞城市承昌通商贸有限公司hahahahahahhAHAHAH");
	    	data.put("${XH}", "CA4256P1K2T1E5A80");
	    	data.put("${usage}", "");
	    	data.put("${SYXZ}", "F");
	    	data.put("${DLYSZH}", "14048109468");
	    	data.put("${CLCCRQ}", "2018/2/26 00:00:00");
	    	data.put("${CCDJRQ}", "2018/3/5 00:00:00");
	    	data.put("${platType}", "01");
	    	data.put("${factoryName}", "");
	    	data.put("${posite}", "2,3");
	    	data.put("${crosght}", "25000");
	    	data.put("${fuelType}", "B");
	    	data.put("${PL}", "");
	    	data.put("${engineModel}", "WP10H400E50");
	    	data.put("${FDJH}", "3618A004089");
	    	data.put("${power}", "294");
	    	data.put("${vin}", "LFWSRURH0JAD05273");
	    	data.put("${vehicleType}", "CA4256P1K2T1E5A80");
	    	data.put("${ZBZL}", "8415");
	    	data.put("${ZGCS}", "280");
	    	data.put("${cwkc}", "6675");
	    	data.put("${cwkk}", "2490");
	    	data.put("${cwkg}", "3290");
	    	data.put("${hxnbcd}", "1000");
	    	data.put("${hxnbkd}", "1000");
	    	data.put("${hxnbgd}", "1000");
	    	data.put("${ZKRS}", "2");
	    	data.put("${ZS}", "3");
	    	data.put("${ZJ}", "4500");
	    	data.put("${CSYS}", "E");
	    	data.put("${vin}", "ABLKSDJOIR798156748");
	    	data.put("${GCJK}","国产");
	    	data.put("${hdzzl}","3000");
	    	data.put("${sfzmhm}","140481199712230413");
	    	data.put("${LTGG}","KB123456");
	    	return data;
	    }
	    
//	    通过key来找到MAP数据结构的值
		public static String getKeyByValue(Map map, Object value) {  
        String keys="";  
        Iterator it = map.entrySet().iterator();  
        while (it.hasNext()) {  
            Map.Entry entry = (Entry) it.next();  
            Object obj = entry.getValue();  
            if (obj != null && obj.equals(value)) {  
                keys=(String) entry.getKey();  
            }  
        }  
        return keys;  
        }  
		
//	    将三通道数据进行处理和融合, 通过Authority 来判断权限
	    public static Map<String, Object> GetDataFromThreeChannel(int Authority) throws Exception{
	    	
//	    	拿到数据对应仓库，也就是字段对应
	    	Map<String, String> data_field_HY = GetDataCorrespondFromFile ("resource/file/数据库字段对应加密.txt",1);
	    	Map<String, String> data_field_SAISI = GetDataCorrespondFromFile ("resource/file/数据库字段对应加密.txt",2);
	    	Map<String, String> data_field_INTERFACE = GetDataCorrespondFromFile ("resource/file/数据库字段对应加密.txt",3);
	    	Map<String, String> data_field_DY = GetDataCorrespondFromFile ("resource/file/数据库字段对应加密.txt",4);
	    	
	    	String PZHM = commonUtil.PZHM_COMMMON;
	    	String HPZL = commonUtil.HPZL_COMMMON;
	    	String CLSBDH = commonUtil.CLSBDH_COMMMON;
	
//	    	拿到是哪个接口的数据
//	    	首先尝试拿到华燕数据库的数据
	    	HashMap<String,String> result_map_data_HY = ChannelGetDataFromDatabaseHY.extractInfoFromDatabase(ChannelGetDataFromDatabaseHY.fileds_list,ChannelGetDataFromDatabaseHY.table_name,PZHM,HPZL);
	    	commonUtil.areaPrint("成功从接口一中拿到数据");
	    	Map<String,Object> result_final = new HashMap<String,Object>();
//			拿到用户的权限频道
//	    	如果是 只使用华研数据
	    	if (Authority==1){
//	    		遍历图，判断 是否为null，为null，则返回null，不为null，则返回数值
	    		for (Map.Entry<String,String> entry: data_field_DY.entrySet()) {
	    			String data_temp = result_map_data_HY.get(data_field_HY.get(entry.getKey()));
	    			if (data_temp!=null) {
	    				result_final.put(entry.getValue(), data_temp);
	    			}else
	    			{
	    				result_final.put(entry.getValue(), "");
	    			}
	    		}
	    		commonUtil.log.printInfo("成功从HY中调出数据，使用单通道数据！");
	    	}
//	    	如果是 三通道数据都使用
	    	else if (Authority ==2){
		    	HashMap<String,String> result_map_data_SAISI = ChannelGetDataFromDatabaseSIS.extractInfoFromDatabase(ChannelGetDataFromDatabaseSIS.fileds_list, ChannelGetDataFromDatabaseSIS.table_name, PZHM);
		    	commonUtil.areaPrint("成功从接口二中拿到数据");
		    	HashMap<String,String> result_map_data_Interface = ChannelGetDataFromInterface.exportDataFromInterface(PZHM,HPZL,CLSBDH,commonUtil.dwjgdm_URL);
		    	commonUtil.areaPrint("成功从接口三中拿到数据");
//	    		以接口数据作为基础数据
	    		for (Map.Entry<String,String> entry: data_field_DY.entrySet()) {
	    			String data_temp = result_map_data_Interface.get(data_field_INTERFACE.get(entry.getKey()));
	    			if (data_temp!=null) {
	    				result_final.put(entry.getValue(), data_temp);
	    			}else
	    			{
	    				result_final.put(entry.getValue(), "");
	    			}
	    		}
	    		commonUtil.log.printInfo("成功从接口中调出数据，使用多通道数据！");
//	    		以赛斯数据库作为补充数据	
	    		for (Entry<String, String> entry: data_field_DY.entrySet()) {
//	    			System.out.println(result_final.get(entry.getValue()));
	    			if (result_final.get(entry.getValue()).equals(""))
	    			{
	    				String data_temp = result_map_data_SAISI.get(data_field_SAISI.get(entry.getKey()));
		    			if (data_temp!=null) {
		    				result_final.put(entry.getValue(), data_temp);
		    			}	
	    			}
	    		}	
	    		commonUtil.log.printInfo("成功从赛斯中调出数据，使用多通道数据！");
//	    		以华研数据库作为第二补充数据
	    		for (Entry<String, String> entry: data_field_DY.entrySet()) {
//	    			System.out.println(entry.getValue());
//	    			System.out.println(result_final.get(entry.getValue()));
//	    			System.out.println(result_final.get(entry.getValue()).equals(""));
	    			if (result_final.get(entry.getValue()).equals(""))
	    			{
//	    				System.out.println(data_field_HY.get(entry.getKey()));
	    				String data_temp = result_map_data_HY.get(data_field_HY.get(entry.getKey()));
//	    				System.out.println(data_temp);
		    			if (data_temp!=null) {
		    				result_final.put(entry.getValue(), data_temp);
		    			}
	    			}
	    		}
	    		commonUtil.log.printInfo("成功从华燕中调出数据，使用多通道数据！");
	    		commonUtil.areaPrint("成功从华燕中调出数据，使用多通道数据！");
//	    		打印数据值，并在log中打印出相关数据，用于进行数据值 判断 最后要把此代码注释掉，不可放在release版本中
	    		commonUtil.log.printInfo("导出数据信息如下:");
	    		String str = "";
	    		for (Map.Entry<String,Object> entry :result_final.entrySet()) {
	    			str = str + entry.getValue()+" - ";
					System.out.println(entry.getKey()+" : "+entry.getValue());
				}
	    		commonUtil.log.printInfo(str);
	    		
	    	}else
	    	{
	    		commonUtil.log.printErr("GetDataFromThreeChannel 数据有误，请检查。");
	    		System.out.println("GetDataFromThreeChannel 数据有误，请检查。");
	    		System.exit(0);
	    	}

	    		return result_final;
	    }
	    
//	    将resultMap中数据 覆盖到 word表中，生成指定的文件
	    
	    public static void exportData(Map<String, Object> data_field,String filename) throws Exception {
	    	
	        Map<String, Object> data = data_field;
	        Map<String, Object> pic =  new HashMap<>();
	        List<List<String[]>> tabledataList = new ArrayList<>();
	        pic.put("${qrcode}", "resource/output/QR_CODE.JPG");
	        getWord(data, tabledataList, pic,filename);
	        
	    }
//	    打印
	    
//	    public static boolean prinData(String filename) throws Exception {
//	    	File file = new File ("resource/output/"+filename+".pdf");
//	        if (printChannel.printpdf(file)) {
//	        	return true;
//	        } 
//	        return false;
//	    }	    
	    
	    public static void main(String[] args) throws Exception {
	    	
//	    	测试数据
	    	writeDataCorrespondFromFile("resource/file/数据库字段对应.txt","resource/file/数据库字段对应加密.txt");
//	        Map<String, String> data = new HashMap<>();
//	        data = GetDataCorrespondFromFile("resource/file/数据库字段对应加密.txt",4);
//	        System.out.println(data.get("车辆所有人"));
//	        System.out.println(data.get("号牌号码"));
//	        System.out.println(data.get("发动机型号"));
//	        System.out.println(data.get("发动机号"));
	    	
	    	
//	        Map<String, Object> data = new HashMap<>();
//	        Map<String, Object> pic = new HashMap<>();

//	        data.put("${usage}", "1200");
//	        data.put("${SYXZ}", "自用车");
//	        data.put("${DLYSZH}", "1233466564");
//	        data.put("${yp}", "1997");
//	        data.put("${mp}", "12");
//	        data.put("${dp}", "23");
//	        data.put("${yr}", "1997");
//	        data.put("${mr}", "12");
//	        data.put("${dr}", "23");
//	        data.put("${yi}", "1997");
//	        data.put("${mi}", "12");
//	        data.put("${di}", "23");
//	        data.put("${ZXZSL}", "1");
//	        data.put("${ZCZD}", "是");
//	        data.put("${KQXG}", "是");
//	        data.put("${SFSQ}", "是");
//	        data.put("${tel}", "150221191321219");
//	        data.put("${postcode}", "047500");
//	        data.put("${owner}", "李璐君");
//	        data.put("${CLCCRQ}", "李璐君123");
//	        data.put("${CCDJRQ}", "1997年12月23号");
//	        data.put("${JYRQ}", "李璐君");
//	        data.put("${platnum}", "晋DLQ718");
//	        data.put("${vehicleType}", "大型车");
//	        
//	        
//	        data.put("${vin}", "ggd1343423435");
//	        data.put("${factoryName}", "奔驰生产");
//	        data.put("${QDXS}", "大型车");
//	        data.put("${CPXH}", "大型车");
//	        data.put("${DPXH}", "大型车");
//	        data.put("${LTGG}", "大型车");
//	        data.put("${ZZL}", "大型车");
//	        data.put("${ZBZL}", "大型车");
//	        data.put("${LTSL}", "大型车");
//	        data.put("${FDJXH}", "大型车");
//	        data.put("${RLZL}", "大型车");
//	        data.put("${ZGCS}", "大型车");
//	        data.put("${WKCC}", "大型车");
//	        data.put("${ZGCS}", "大型车");
//	        data.put("${HXLBCC}", "大型车");
//	        data.put("${JXLJZZXH}", "大型车");
//	        data.put("${ZXZSL}", "大型车");
//	        data.put("${ZGCS}", "大型车");
//	        data.put("${HXLBCKG}", "大型车");
//	        data.put("${FDJXH}", "大型车");
//	        data.put("${CPXH}", "大型车");
//	        data.put("${ZKRS}", "大型车");
//	        data.put("${DPXH}", "大型车");
//	        data.put("${RLZL}", "大型车");
//	        data.put("${HXLBCKG}", "大型车");
//	        data.put("${QDXS}", "大型车");
//	        data.put("${CPXH}", "大型车");
//	        data.put("${JXLJZZXH}", "大型车");
//	        data.put("${CPMC}", "大型车");
//	        data.put("${WKCC}", "大型车");
//	        data.put("${GCZGCS}", "大型车");
//	        data.put("${WKCC}", "大型车");
//	        data.put("${HXLBNCC}", "大型车");
//	        
//	        data.put("${today}", "大型车");
//	        data.put("${CLXH}", "大型车");
//	        data.put("${PPXH}", "大型车");
//	        data.put("${WXCC}", "大型车");;
//	        data.put("${FDJXH}", "大型车");
//	        data.put("${DPXH}", "大型车");
//	        data.put("${QDXS}", "大型车");
//	        data.put("${LTGG}", "大型车");
//	        data.put("${QYZZDCZZL}", "大型车");
//	        data.put("${ZTGCZZL}", "大型车");
////	        data.put("${HXLBNCC}", "大型车");
////	        data.put("${HXLBNCC}", "大型车");
////	        data.put("${HXLBNCC}", "大型车");
////	        data.put("${HXLBNCC}", "大型车");
//	                
//	       
//	        // 列表(List)是对象的有序集合
//	        List<List<String[]>> tabledataList = new ArrayList<>();
//	        getWord(data, tabledataList, pic);
	    }
	    
	    	// 
	    public static void getWord(Map<String, Object> data, List<List<String[]>> tabledataList, Map<String, Object> picmap, String filename)
	            throws Exception {
	    	
	    	OpSqliteDB db = new OpSqliteDB("DatabaseName.db");
	    	db.readPicture(filename, filename+ variableStatic.fileDoxNameTail);
	    	String i= variableStatic.filePathRoot + filename+ variableStatic.fileDoxNameTail;
	    	String o= variableStatic.outPutPathRoot + filename + variableStatic.fileDoxNameTail;
//	    	System.out.println(i);
//	    	System.out.println(o);
//	    	String i= variableStatic.filePathRoot_ORI + filename+ variableStatic.fileDoxNameTail;
//	    	String o= variableStatic.outPutPathRoot + filename + variableStatic.fileDoxNameTail;
			try (
	        		FileInputStream is = new FileInputStream(i);
	        		XWPFDocument document = new XWPFDocument(is)
	        	) 
	        {
	            // 替换掉表格之外的文本(仅限文本)
	            changeText(document, data);

	            // 替换表格内的文本对象
	            changeTableText(document, data);

	            // 替换图片
	            changePic(document, picmap);

//	             替换表格内的图片对象
	            changeTablePic(document, picmap);

	            long time = System.currentTimeMillis();// 获取系统时间
	            System.out.println(time); // 打印时间
	            // 使用try和catch关键字捕获异常
	            try (FileOutputStream out = new FileOutputStream(o)) {
	                document.write(out);
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
//			File file = new File(i);
//			System.out.println(i);
//			if(file.exists()) {
//				file.delete();
//				System.out.println("删除成功");
//			}
	    }

	    /**
	     * 替换段落文本
	     * @param document docx解析对象
	     * @param textMap 需要替换的信息集合
	     *
	     */
	    public static void changeText(XWPFDocument document, Map<String, Object> textMap) {
	        // 获取段落集合
	        // 返回包含页眉或页脚文本的段落
	        List<XWPFParagraph> paragraphs = document.getParagraphs();
	        // 增强型for循环语句，前面一个为声明语句，后一个为表达式
	        for (XWPFParagraph paragraph : paragraphs) {
	            // 判断此段落是否需要替换
	            String text = paragraph.getText();// 检索文档中的所有文本
	            if (checkText(text)) {
	                List<XWPFRun> runs = paragraph.getRuns();
	                for (XWPFRun run : runs) {
	                    // 替换模板原来位置
//	                	System.out.println(run.toString());
	                    Object ob = changeValue(run.toString(), textMap);
	                    if (ob instanceof String) {
	                        if (textMap.containsKey(run.toString())) {
	                            run.setText((String) ob, 0);
	                        }
	                    }
	                }
	            }
	        }
	    }

	    /* 检查文本中是否包含指定的字符(此处为“$”)，并返回值 */
	    public static boolean checkText(String text) {
	        boolean check = false;
	        if (text.contains("$")) {
	            check = true;
	        }
	        return check;
	    }

	    /**
	     * 替换图片
	     * @param document
	     * @param textMap
	     * @throws Exception
	     */

	    public static void changePic(XWPFDocument document, Map<String, Object> textMap) throws Exception {
	        // 获取段落集合
	        List<XWPFParagraph> paragraphs = document.getParagraphs();

	        for (XWPFParagraph paragraph : paragraphs) {
	            // 判断此段落是否需要替换
	            String text = paragraph.getText();
	            if (checkText(text)) {
	                List<XWPFRun> runs = paragraph.getRuns();
	                for (XWPFRun run : runs) {
	                    // 替换模板原来位置
	                    Object ob = changeValue(run.toString(), textMap);
	                    if (ob instanceof String) {
	                        if (textMap.containsKey(run.toString())) {
	                            run.setText("", 0);
	                            try (FileInputStream is = new FileInputStream((String) ob)) {
	                                run.addPicture(is, XWPFDocument.PICTURE_TYPE_PNG, (String) ob, Units.toEMU(380),
	                                        Units.toEMU(380));
	                            }
	                        }
	                    }
	                }
	            }
	        }
	    }

	    public static void changeTableText(XWPFDocument document, Map<String, Object> data) {
	        // 获取文件的表格
	        List<XWPFTable> tableList = document.getTables();

	        // 循环所有需要进行替换的文本，进行替换
	        for (int i = 0; i < tableList.size(); i++) {
	            XWPFTable table = tableList.get(i);
	            if (checkText(table.getText())) {
	                List<XWPFTableRow> rows = table.getRows();
	                // 遍历表格，并替换模板
	                eachTable(document, rows, data);
	            }
	        }
	    }

	    public static void changeTablePic(XWPFDocument document, Map<String, Object> pic) throws Exception {
	        List<XWPFTable> tableList = document.getTables();

	        // 循环所有需要替换的文本，进行替换
	        for (int i = 0; i < tableList.size(); i++) {
	            XWPFTable table = tableList.get(i);
	            if (checkText(table.getText())) {
	                List<XWPFTableRow> rows = table.getRows();
//	                System.out.println("简单表格替换：" + rows);
	                // 遍历表格，并替换模板
	                eachTablePic(document, rows, pic);
	            }
	        }
	    }

	    public static void eachTablePic(XWPFDocument document, List<XWPFTableRow> rows, Map<String, Object> pic)
	            throws Exception {
	        for (XWPFTableRow row : rows) {
	            List<XWPFTableCell> cells = row.getTableCells();
	            for (XWPFTableCell cell : cells) {
	                // 判断单元格是否需要替换
	                if (checkText(cell.getText())) {
	                    List<XWPFParagraph> paragraphs = cell.getParagraphs();
	                    for (XWPFParagraph paragraph : paragraphs) {
	                        List<XWPFRun> runs = paragraph.getRuns();
	                        for (XWPFRun run : runs) {
	                            Object ob = changeValue(run.toString(), pic);
	                            if (ob instanceof String) {
//	                                System.out.println("run" + "‘" + run.toString() + "‘");
	                                if (pic.containsKey(run.toString())) {
//	                                    System.out.println("run" + run.toString() + "替换为" + ob);
	                                    run.setText("", 0);
	                                    try (FileInputStream is = new FileInputStream((String) ob)) {
	                                        run.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, (String) ob, Units.toEMU(1000),
	                                                Units.toEMU(1000));
	                                    }
	                                } else {
//	                                    System.out.println("‘" + run.toString() + "‘ 不匹配");
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	        }
	    }

	    public static Object changeValue(String value, Map<String, Object> textMap) {
	        Set<Map.Entry<String, Object>> textSets = textMap.entrySet();
	        Object valu = "";
	        for (Map.Entry<String, Object> textSet : textSets) {
	            // 匹配模板与替换值 格式${key}
	            String key = textSet.getKey();
	            if (value.contains(key)) {
	                valu = textSet.getValue();
	            }
	        }
	        return valu;
	    }
	    // 对 表中每个单元格数据 进行 批量填充
	    public static void eachTable(XWPFDocument document, List<XWPFTableRow> rows, Map<String, Object> textMap) {
	        for (XWPFTableRow row : rows) {
	            List<XWPFTableCell> cells = row.getTableCells();
	            for (XWPFTableCell cell : cells) {
	                // 判断单元格是否需要替换
//		            System.out.println("-------------------------");
//		            System.out.println(cell.getText());
//		            System.out.println(cell.getText().length());
//	                System.out.println("-------------------------");
	                if (checkText(cell.getText())) {
	                    // System.out.println("cell:" + cell.getText());
	                    List<XWPFParagraph> paragraphs = cell.getParagraphs();
//	                    System.out.println(paragraphs.size());
	                    for (XWPFParagraph paragraph : paragraphs) {
	                        List<XWPFRun> runs = paragraph.getRuns();
	                        for (XWPFRun run : runs) {
	                            Object ob = changeValue(run.toString(), textMap);
	                            if (ob instanceof String) {
	                            	
//	                                System.out.println("run:" + "||" + run.toString() + "||");
	                                if (textMap.containsKey(run.toString())) {
//	                                    System.out.println("run:" + run.toString() + "替换为" + ob);
//	                                	System.out.println(run.toString());
	                                    run.setText((String) ob, 0);
	                                } else {
//	                                	System.out.println(run.toString());
//	                                    System.out.println("||" + run.toString() + "||不匹配");
	                                }
//	                                System.out.println();
	                            }
	                        }
	                    }
	                }

	            }
	        }
	    }
	}

