package search.outil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.swing.JFileChooser;

public class printChannel {
	
	
	public static void main(String[] args) throws FileNotFoundException, PrintException 
	{
//		 JFileChooser fileChooser = new JFileChooser(); // 创建打印作业
//		 int state = fileChooser.showOpenDialog(null);
			 File file = new File("resource/output/人工检验表.docx"); // 获取选择的文件
			// 构建打印请求属性集
			 HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
			 // 设置打印格式，因为未确定类型，所以选择autosense
			 DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
			 // 查找所有的可用的打印服务
			 PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
			 // 定位默认的打印服务
			 PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
			 // 显示打印对话框
			 PrintService service = ServiceUI.printDialog(null, 200, 200,printService, defaultService, flavor, pras);
			 System.out.println(service.toString());
			 if (service != null)
			 {
                try {
                    DocPrintJob job = service.createPrintJob(); // 创建打印作业
                    FileInputStream fis = new FileInputStream(file); // 构造待打印的文件流
                    DocAttributeSet das = new HashDocAttributeSet();
                    Doc doc = new SimpleDoc(fis, flavor, das);
                    job.print(doc, pras);
                } catch (Exception e) {
                    e.printStackTrace();
                }
			 }
	 }
}

