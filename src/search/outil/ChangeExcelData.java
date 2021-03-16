package search.outil;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ChangeExcelData {

	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException {
        String path = "人工检验表";
        String outPath = "resource/output/人工检验表.xlsx";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("platnum", "晋DLQ718");
        params.put("vehicleType", "小型汽车");
        params.put("usage", "135666");
        params.put("SYXZ", "自用车");
        params.put("DLYSZH", "213243242341144657");
        params.put("CLCCRQ", "2019年1月15日");
        params.put("CCDJRQ", "2019年1月15日");
        params.put("JYRQ", "2019年1月15日");
        params.put("SFSQ", "否");
        params.put("ZXZSL", "2");
        params.put("ZCZD", "否");
        params.put("KQXG", "否");
        params.put("owner", "中中中中中中中中中中中中中中中中中中中中中中中中中");
        params.put("tel", "1502211919292929292992");
        params.put("postcode", "047500");

        new ChangeExcelData().replaceExcel(path,params);
    }

	public static boolean exportDataXls(Map<String, Object> params,String filename) throws InvalidFormatException, IOException {

	     new ChangeExcelData().replaceExcel(filename,params);
	     return true;
	}
	
//	注意 在此内部 的 param 中的 属性值 不包含 ${}
    @SuppressWarnings("deprecation")
    
	public void replaceExcel(String filename, Map params) throws IOException, InvalidFormatException {
		String inPath = "resource/file/"+filename+".xlsx";
	    String outPath = "resource/output/"+filename+".xlsx";
	    System.out.println(inPath);
	    System.out.println(outPath);
        InputStream is = new FileInputStream(new File(inPath));
        Workbook wb = WorkbookFactory.create(is);
        Sheet sheet = wb.getSheet(filename);//获取Excel的工作表sheet，下标从0开始。
        int trLength = sheet.getLastRowNum();//获取Excel的行数
        for (int i = 0; i < trLength; i++) {
            Row row = sheet.getRow(i);//获取Excel的行，下标从0开始
            if (row == null) {//若行为空，则遍历下一行
                continue;
            }
            int minColIx = row.getFirstCellNum();
            int maxColIx = row.getLastCellNum();
            for (int colIx = minColIx; colIx < maxColIx; colIx++) {
                Cell cell = row.getCell(colIx);//获取指定单元格，单元格从左到右下标从0开始
                String runText = "4134234324";
                if (cell!=null)
                {
                	cell.setCellType(CellType.STRING);
	                runText = cell.getStringCellValue();
	                if (runText.equals("")){
	                    continue;
	                }
                }
                if(cell==null || cell.getStringCellValue()==null) {
                    continue;
                }
                
                Matcher matcher = this.matcher(runText);
                if (matcher.find()) {
                    while ((matcher = this.matcher(runText)).find()) {
                        runText = matcher.replaceFirst(String.valueOf(params.get(matcher.group(1))));
                    }
                    cell.setCellValue(runText.toString());
                }
            }
        }
        OutputStream out = new FileOutputStream(new File(outPath));
        wb.write(out);
        is.close();
        out.close();
    }

    /**
     * 正则匹配字符串
     * @param str
     * @return
     */
    private Matcher matcher(String str) {
//        Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
    	Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }

}
