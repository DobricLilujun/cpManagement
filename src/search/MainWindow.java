package search;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Vector;
import java.awt.event.ActionEvent;

import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import javax.swing.JTable;
import javax.swing.JTextArea;

public class MainWindow 
{
	private JFrame frame;
	private static JComboBox<String> ComboBox;
	private static JComboBox<String> ComboBox_table;
	private static JLabel label;
	private static JPanel panel1;
	private static JPanel panel2;
	private static JScrollPane scrollPane;
	private static JTextArea textArea;
	private static JTextField textField2;
	private static JTextField textField3;
	private static JTextField textField4;
	private static JTextField textField5;
	private static JTextField textField6;
	private static JTextField textField7;
	private static JTextField textField8;
	public static String s1;
	public static String s2;
	public static String address;
	public static String number;
	public static String postcode;
	public static String pailiang;
	public static String gangshu;
	public static String fadongjixinghao;
	public static int flag;
	public LinkedList<String> result;
	public String path = null;
	public static String conn1=null;
	public static reptile re;
//	public static String company_name="";

	public static void main(String[] args) throws UnknownHostException
	{
		re =new reptile("http://www.cnblogs.com/tankxiao");
		if (Protection.Test_available()==true)
		{
		InetAddress addr = InetAddress.getLocalHost();   
		String host_read = "";  
		File directory =new File("");
		String url_test = directory.getAbsolutePath()+"\\url_test.txt";
		
//		String name_test = directory.getAbsolutePath()+"\\name_test.txt";
//		File file1=new File(name_test);
//		
//		try 
//		{
//			if(file1.exists())
//			{
//				InputStreamReader reader = new InputStreamReader(  
//	                    new FileInputStream(file1)); // 建立一个输入流对象reader  
//	            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
//	           
//	            company_name = br.readLine();  
//			}
//		} catch (IOException e) 
//		{
//		e.printStackTrace();
//		}
		File file=new File(url_test);
		try 
		{
			if(file.exists())
			{
				InputStreamReader reader1 = new InputStreamReader(  
	                    new FileInputStream(file)); // 建立一个输入流对象reader  
	            @SuppressWarnings("resource")
				BufferedReader br1 = new BufferedReader(reader1); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
	           
	            conn1 = br1.readLine();  
			}
		} catch (IOException e) 
		{
		e.printStackTrace();
		}
		String test = directory.getAbsolutePath()+"\\test.txt";
		
		File file2=new File(test);
		//定义文件路径
		int flag=0;
		String hostName=addr.getHostName().toString();
		
		try 
		{
			if(file2.exists())
			{
				
				InputStreamReader reader = new InputStreamReader(  
	            new FileInputStream(file2)); // 建立一个输入流对象reader  
	            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
	           
	            host_read = br.readLine();  
			}
		} catch (IOException e) 
		{
		e.printStackTrace();
		}
		if ((host_read.equals(hostName))||(flag==1))
		{	
		//GUI窗口主函数
			try
			{
				MainWindow window = new MainWindow();
				window.frame.setVisible(true);
				Thread.sleep(2000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		}
	}

	public MainWindow() throws IOException
	{
		initialize();
	}

	private void initialize() throws IOException
	{
		//新建窗口并设置基本信息
		frame = new JFrame();
		frame.setSize(1400,400);
	    frame.setLocation(300, 150);
	    frame.setTitle("数据库导出软件");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setIconImage((new ImageIcon("figure1.png")).getImage());
	    
	    //加载软件基本信息和数据
	    load();
	    File f  = new File(".");
	    try {
			path = f.getCanonicalPath();
		} catch (IOException e3) 
	    {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		JButton button = new JButton("导出综检数据");
		button.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					get_info Get = new get_info();
//					print Doc =new print();
					s1=textField2.getText().toString();
					s2=(String)ComboBox.getSelectedItem();
					address=textField3.getText().toString();
					number=textField4.getText().toString();
					postcode=textField5.getText().toString();
					pailiang = textField6.getText().toString();
					gangshu = textField7.getText().toString();
					fadongjixinghao = textField8.getText().toString();
					if(ComboBox_table.getSelectedIndex()==0)
					{
						flag=0;
						result = Get.get(s1,s2,flag,conn1);
						LinkedList<String> origin = new LinkedList<String>()
						{{
							add("DW");
							add("MakeDate");
							add("CPH");
							add("DJDate");
							add("DPH");
							add("PZLBStr");
							add("KilomCount");
							add("CLLBXStr");
							add("FDJH");
							add("FDJXH");
							add("changPH");
							add("XingHao");
							add("PaiLiang");
							add("EDGLRPM");
							add("EDGL");
							add("ZCZL");
							add("ZBZL");
							add("SYXZStr");
						}};
						result.add(address);
						result.add(number);
						result.add(postcode);
						result.add(pailiang);
						result.add(gangshu);
						result.add(fadongjixinghao);
						origin.add("address");
						origin.add("number");
						origin.add("postcode");
						origin.add("pailiang");
						origin.add("gangshu");
						origin.add("fadongjixinghao");
						String name = "打印表安";
						export_info(origin,result,name);
					}
					else if(ComboBox_table.getSelectedIndex()==1)
					{
						flag=1;
						result = Get.get(s1,s2,flag,conn1);
						LinkedList<String> origin = new LinkedList<String>()
						{
						private static final long serialVersionUID = 1L;
						{
							add("DW");
							add("MakeDate");
							add("CPH");
							add("DJDate");
							add("DPH");
							add("PZLBStr");
							add("KilomCount");
							add("CLLBXStr");
							add("FDJH");
							add("FDJXH");
							add("changPH");
							add("XingHao");
							add("PaiLiang");
							add("EDGLRPM");
							add("EDGL");
							add("ZCZL");
							add("ZBZL");
							add("ZKRS");
							add("ZCCD");
							add("ZCKD");
							add("ZCGD");
							add("QDXS");
							add("QDLLTGG");
							add("JIANCBGDBH");
						}};
						if(result.size()!=0)
						{
						result.add(result.size()-1,address);
						result.add(result.size()-1,number);
						result.add(result.size()-1,postcode);
						result.add(result.size()-1,pailiang);
						result.add(result.size()-1,gangshu);
						result.add(result.size()-1,fadongjixinghao);
						}
						origin.add(origin.size()-1,"address");
						origin.add(origin.size()-1,"number");
						origin.add(origin.size()-1,"postcode");
						origin.add(origin.size()-1,"pailiang");
						origin.add(origin.size()-1,"gangshu");
						origin.add(origin.size()-1,"fadongjixinghao");
						String name = "打印表综";
						export_info(origin,result,name);
					}
					else
					{
						System.exit(0);
					}
					String time_now_string = Protection.readValue("count.properties", "time_now"); 
			    	int now =Integer.parseInt(time_now_string);
					now = now + 1;
					time_now_string = String.valueOf(now);
					Protection.writeProperties("time_now",time_now_string);
				}
			}
		);
		JButton button_export_ecologie = new JButton("导出环保数据");
		button_export_ecologie.addActionListener(
		
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try {
							re.export_ecologie_data();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
		);
        panel1.setBackground(Color.RED);
        panel1.add(ComboBox_table);
        panel1.add(ComboBox);
        panel1.add(textField2);
        panel1.add(textField3);
        panel1.add(textField4);
        panel1.add(textField5);
        panel1.add(textField6);
        panel1.add(textField7);
        panel1.add(textField8);
        panel1.add(button);
        panel1.add(button_export_ecologie);
        frame.add(label);
        frame.add(panel2);
        // 下面这里就需要定位处理
        frame.add(panel1, BorderLayout.SOUTH);
        frame.add(label,BorderLayout.NORTH);
        frame.setSize(1350,400);
        frame.setLocation(150, 150);
        frame.setTitle("数据库导出软件");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
	}
	
	private static void load() throws IOException
 	{
 		label = new JLabel(new ImageIcon("figure1.png"));
        panel1 = new JPanel();
        panel2 = new JPanel();
        String enumeration[] = {"大型汽车","小型汽车","外籍汽车","两、三轮摩托车","轻便摩托车","农用运输车","挂车","教练汽车","警用汽车","大型新能源汽车","小型新能源汽车"};
        String table[] = {"安检数据导出","综检数据导出"};
        ComboBox_table  = new JComboBox<String>(table);
        ComboBox_table.setFont(new Font("汉真广标", Font.BOLD, 15));
        ComboBox  = new JComboBox<String>(enumeration);
        ComboBox.setFont(new Font("汉真广标", Font.BOLD, 15));
        textField2 = new JTextField("晋D",10);
        textField2.setFont(new Font("汉真广标", Font.BOLD, 15));
        textField3 = new JTextField("山西省潞城市",25);
        textField3.setFont(new Font("汉真广标", Font.BOLD, 11));
        textField4 = new JTextField("139",11);
        textField4.setFont(new Font("汉真广标", Font.BOLD, 11));
        textField5 = new JTextField("047500",6);
        textField5.setFont(new Font("汉真广标", Font.BOLD, 11));
        
        textField6 = new JTextField("排量",4);
        textField6.setFont(new Font("汉真广标", Font.BOLD, 11));
        textField7 = new JTextField("缸数",4);
        textField7.setFont(new Font("汉真广标", Font.BOLD, 11));
        textField8 = new JTextField("发动机型号",6);
        textField8.setFont(new Font("汉真广标", Font.BOLD, 11));

 	}
	public void export_info(LinkedList<String> origin, LinkedList<String> result,String name)
	{
	    // 声明一个工作薄
	    HSSFWorkbook wb = new HSSFWorkbook();
	    //声明一个单子并命名
	    HSSFSheet sheet = wb.createSheet("name");
	    //给单子名称一个长度
	    sheet.setDefaultColumnWidth((short)25);
	    // 生成一个样式 
	    HSSFCellStyle style = wb.createCellStyle();
	    //创建第一行（也可以称为表头）
	    HSSFRow row = sheet.createRow(0);
	    //样式字体居中
//	    style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	    //给表头第一行一次创建单元格
	    HSSFCell cell ;
	    for(int i=0;i<origin.size();i++)
	    {
	    	cell=row.createCell((short)i);
	    	cell.setCellValue(origin.get(i));
	    	cell.setCellStyle(style);
	    }
	    row = sheet.createRow(1);
	    for(int i=0;i<result.size();i++)
	    {
	    	row.createCell(i).setCellValue(result.get(i));
	    }  
	    String path = null;
	    File f  = new File(".");
	    try {
			path = f.getCanonicalPath();
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	   
	    System.out.println(path);
	    path = path+"\\"+name+".xls";
	    System.out.println(path);
	    try 
	      {
	        //默认导出到E盘下
	        FileOutputStream out = new FileOutputStream(path);
	        wb.write(out);
	        out.close();
	        JOptionPane.showMessageDialog(null, "成功导出数据!");
	    } catch (FileNotFoundException e) 
	           {
	        JOptionPane.showMessageDialog(null, "另一个程序正在使用此文件，进程无法访问，导出失败!");
	        e.printStackTrace();
	    } catch (IOException e) 
	           {
	        JOptionPane.showMessageDialog(null, "导出失败!");
	        e.printStackTrace();
	    }
	}

}


