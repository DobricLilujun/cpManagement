package search.outil;

import java.awt.Color;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;


public class POI {


	
	/**
	 * 文件数据替换
	 * @author 23  *
	 */
	    public static String file_path = "resource//file//FullInspection2.docx";
	    public static String images_path = "resource//file//FullInspection2.docx";
	    public static String output_path = "resource//output//FullInspection2.docx";
	    public static String config_path = "resource//config//field.properties";
	    
	    public static  Map<String, Object> getDataMap() {
	    	Map<String, Object> data = new HashMap<>();
	    	
	    	return data;
	    }
	    
	    public static  Map<String, Object> getPicMap() {
	    	Map<String, Object> pic = new HashMap<>();
	    	
	    	
	    	return pic;
	    }
	    
	    public static void main(String[] args) throws Exception {
	        Map<String, Object> data = new HashMap<>();
	        Map<String, Object> pic = new HashMap<>();
	        data.put("${owner}", "成功更改数据");
	        data.put("${tel}", "15022119139");
	        data.put("${brand}", "品牌");
	        data.put("${address}", "山西");
	        data.put("${owner}", "成功更改数据");
	        data.put("${mi}", "12");
	        data.put("${di}", "23");
	        data.put("${yi}", "2021");
	        pic.put("${qrcode}", "resource//images//Capture.JPG");
	        
	        System.out.println(pic.containsKey("${qrcode}"));
	        System.out.println(data.containsKey("${owner}"));
	        System.out.println(data.containsKey("${yi}"));
	        // 列表(List)是对象的有序集合
	        List<List<String[]>> tabledataList = new ArrayList<>();
	        getWord(data, tabledataList, pic);
	    }
	    
	    	// 
	    public static void getWord(Map<String, Object> data, List<List<String[]>> tabledataList, Map<String, Object> picmap)
	            throws Exception {
	        try (
	        		FileInputStream is = new FileInputStream(file_path);
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
	            try (FileOutputStream out = new FileOutputStream(output_path)) {
	                document.write(out);
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
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
//	            System.out.println("-------------------------");
//	            System.out.println(text);
//	            System.out.println("-------------------------");
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
	                                run.addPicture(is, XWPFDocument.PICTURE_TYPE_PNG, (String) ob, Units.toEMU(100),
	                                        Units.toEMU(100));
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
	                                    System.out.println("run" + run.toString() + "替换为" + ob);
	                                    run.setText("", 0);
	                                    try (FileInputStream is = new FileInputStream((String) ob)) {
	                                        run.addPicture(is, XWPFDocument.PICTURE_TYPE_PNG, (String) ob, Units.toEMU(1000),
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
	                    System.out.println(paragraphs.size());
	                    for (XWPFParagraph paragraph : paragraphs) {
	                        List<XWPFRun> runs = paragraph.getRuns();
	                        for (XWPFRun run : runs) {
	                            Object ob = changeValue(run.toString(), textMap);
	                            if (ob instanceof String) {
	                            	
//	                                System.out.println("run:" + "‘" + run.toString() + "‘");
	                                if (textMap.containsKey(run.toString())) {
//	                                    System.out.println("run:" + run.toString() + "替换为" + ob);
//	                                	System.out.println(run.toString());
	                                    run.setText((String) ob, 0);
	                                } else {
//	                                	System.out.println(run.toString());
//	                                    System.out.println("--" + run.toString() + "--不匹配");
	                                }
	                            }
	                        }
	                    }
	                }

	            }
	        }
	    }
	}

