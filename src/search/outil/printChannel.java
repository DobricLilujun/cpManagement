package search.outil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.print.PrintService;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.Sides;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfDocumentBase;
import com.spire.xls.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPrintable;
import org.apache.pdfbox.printing.Scaling;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterJob;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;

public class printChannel {
	
    static final int wdDoNotSaveChanges = 0;// 不保存待定的更改。
    static final int wdFormatPDF = 17;// word转PDF 格式
    static final String root = System.getProperty("user.dir");
    
	public static boolean word2pdf(String source, String target) {
        System.out.println("Word转PDF开始启动...");
        System.out.println(root);
        source = root + source;
        target = root + target;

        long start = System.currentTimeMillis();
        ActiveXComponent app = null;
        try {
            app = new ActiveXComponent("Word.Application");
            app.setProperty("Visible", false);
            Dispatch docs = app.getProperty("Documents").toDispatch();
            System.out.println("打开文档：" + source);
            Dispatch doc = Dispatch.call(docs, "Open", source, false, true).toDispatch();
            System.out.println("转换文档到PDF：" + target);
            File tofile = new File(target);
            if (tofile.exists()) {
                tofile.delete();
            }
            Dispatch.call(doc, "SaveAs", target, wdFormatPDF);
            Dispatch.call(doc, "Close", false);
            long end = System.currentTimeMillis();
            System.out.println("转换完成，用时：" + (end - start) + "ms");
            File file = new File(source);
    		if(file.exists()) {
    			file.delete();
    			System.out.println("删除成功");
    		}
            return true;
        } catch (Exception e) {
            System.out.println("Word转PDF出错：" + e.getMessage());
            return false;
        } finally {
            if (app != null) {
                app.invoke("Quit", wdDoNotSaveChanges);
            }
        }

    }
	
//	public static void printpdf() throws IOException, PrinterException {
////		PrintService printer = PrintServiceLookup.lookupDefaultPrintService();
////		PDDocument doc = PDDocument.load(new File("resource/output/人工检验表.pdf"));
//		 PdfDocument pdf = new PdfDocument();
//			pdf.getPages().add();
//			pdf.getPages().removeAt(0);
//			
//	        pdf.loadFromFile("resource/output/人工检验表.pdf");
//			pdf.getPages().add();
//			pdf.getPages().removeAt(2);
//
//	        PrinterJob loPrinterJob = PrinterJob.getPrinterJob();
//
//	        PageFormat loPageFormat  = loPrinterJob.defaultPage();
//
//	        Paper loPaper = loPageFormat.getPaper();
//
//	        //删除默认页边距
//
//	        loPaper.setImageableArea(0,0,loPageFormat.getWidth(),loPageFormat.getHeight());
//
//	        //设置打印份数
//
//	        loPrinterJob.setCopies(1);
////	        loPrinterJob.set
//
//	        loPageFormat.setPaper(loPaper);
//
//	        loPrinterJob.setPrintable(pdf,loPageFormat);
//
//	        try {
//
//	            loPrinterJob.print();
//
//	        } catch (PrinterException e) {
//
//	            e.printStackTrace();
//
//	        }
//	}
	public static boolean printpdf(File file) throws Exception {
        PDDocument document = null;
        try {
            document = PDDocument.load(file);
            PrinterJob printJob = PrinterJob.getPrinterJob();
            printJob.setJobName(file.getName());
                // 查找并设置打印机
                //获得本台电脑连接的所有打印机
            PrintService[] printServices = PrinterJob.lookupPrintServices();  

            if(printServices == null || printServices.length == 0) {
                System.out.print("打印失败，未找到可用打印机，请检查。");
                return false;
            }
            //设置纸张及缩放
            PDFPrintable pdfPrintable = new PDFPrintable(document, Scaling.SHRINK_TO_FIT);
            //设置多页打印
            Book book = new Book();
            PageFormat pageFormat =  printJob.defaultPage();
            Paper loPaper = pageFormat.getPaper();
            loPaper.setImageableArea(0,0,pageFormat.getWidth(),pageFormat.getHeight());
            //设置打印方向
            pageFormat.setOrientation(PageFormat.PORTRAIT);//纵向
            pageFormat.setPaper(loPaper);
//            System.out.println(file.getName());
            if (file.getName().substring(0, 7).equals("性能检测判定表")) {
            	pageFormat.setOrientation(PageFormat.LANDSCAPE);
            }
//            paper.setSize(width, height);
//            pageFormat.setPaper();//设置纸张
            book.append(pdfPrintable, pageFormat, document.getNumberOfPages());
//            System.out.println(document.getNumberOfPages());
            printJob.setPageable(book);
            printJob.setCopies(1);//设置打印份数
//            printJob.setPageable(new PDFPageable(document));
            //添加打印属性
            HashPrintRequestAttributeSet pars = new HashPrintRequestAttributeSet();
            pars.add(Sides.DUPLEX); //设置单双页
            printJob.print(pars);
            return true;
        }finally {
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
//	将 xlsx 转为 pdf 使用spire
	public static boolean xlsx2pdf(String filename) throws FileNotFoundException {
		 Workbook wb = new Workbook();
		 wb.loadFromFile("resource\\output\\"+filename+".xls");
		 System.out.println( wb.getWorksheets().getCount());
		 Worksheet worksheet = wb.getWorksheets().get(0);
//		 worksheet.getPageSetup().setFirstPageNumber(1);
		 worksheet.getPageSetup().setPaperSize(PaperSizeType.PaperA4);
//		 worksheet
//		 worksheet.getPageSetup().setFitToPagesTall(1);
//		 worksheet.getPageSetup().setFitToPagesWide(1);
		 wb.getConverterSetting().setSheetFitToPage(true);
		 
//		 wb.getConverterSetting().setSheetFitToWidth(true);
//		 wb.getConverterSetting().set
//		 wb.saveToFile("resource\\output\\"+filename+".pdf",FileFormat.PDF);
		 worksheet.saveToPdf("resource\\output\\"+filename+".pdf");
	     return true;
	}
	
//	专为打人工检验表和汽车排放外检表而设计
	public static void printSpecify_1() throws FileNotFoundException {
		xlsx2pdf("人工检验表1");
		xlsx2pdf("人工检验表2");
		FileInputStream stream1 = new FileInputStream(new File("resource/output/人工检验表1.pdf"));
	    FileInputStream stream2 = new FileInputStream(new File("resource/output/人工检验表2.pdf"));
	    InputStream[] streams = new FileInputStream[]{stream1, stream2};
	    PdfDocumentBase doc = PdfDocument.mergeFiles(streams);
	    doc.save("resource/output/人工检验表.pdf");
        doc.close();
       
	}
	
	public static void printSpecify_2() throws FileNotFoundException {
		xlsx2pdf("汽车排放外检表1");
		xlsx2pdf("汽车排放外检表2");
		FileInputStream stream3 = new FileInputStream(new File("resource/output/汽车排放外检表1.pdf"));
	    FileInputStream stream4 = new FileInputStream(new File("resource/output/汽车排放外检表2.pdf"));
	    InputStream[] streams_ = new FileInputStream[]{stream3, stream4};
	    PdfDocumentBase doc1 = PdfDocument.mergeFiles(streams_);
	    doc1.save("resource/output/汽车排放外检表.pdf");
        doc1.close();
	}
	
//	public static boolean printXlsx(String filename) {
//		
//	}
	
//	public static boolean printDoc(String filename) throws Exception {
//		
//		if (word2pdf("\\resource\\output\\"+filename+".docx","\\resource\\output\\"+filename+".pdf")) {
//			File f = new File ("resource/output/"+filename+".pdf");
//			printChannel.PDFprint(f);
//			return true;
//		}
//		return false;
//	}
	public static void main(String[] args) throws Exception 
	{
//		printpdf();
//		word2pdf("\\resource\\file\\人工检验表.docx","\\resource\\output\\人工检验表.pdf");
//		File f = new File ("resource/output/人工检验表.pdf");
//		printChannel.PDFprint(f);
//		xlsx2pdf("人工检验表1");
//		xlsx2pdf("人工检验表2");
//		xlsx2pdf("牵引车辆表");
//		xlsx2pdf("客车表");
//		xlsx2pdf("挂车表");
//		xlsx2pdf("载货汽车表");
//		xlsx2pdf("汽车排放外检表");
//		xlsx2pdf("性能检测判定表");
//		xlsx2pdf("牌证申请表");
//		xlsx2pdf("委托书");
//		补充表
		
//		FileInputStream stream1 = new FileInputStream(new File("resource/output/人工检验表1.pdf"));
//	    FileInputStream stream2 = new FileInputStream(new File("resource/output/人工检验表2.pdf"));
//	    InputStream[] streams = new FileInputStream[]{stream1, stream2};
//	    PdfDocumentBase doc = PdfDocument.mergeFiles(streams);
//	    doc.save("resource/output/人工检验表.pdf");
//        doc.close();
		
//		printxls("resource/output/人工检验表.xlsx");
	}
}

