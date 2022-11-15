package search;  
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.io.InputStreamReader;  
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Protection 
{
    static String profilepath="count.properties"; 
    /** 
    * 采用静态方法 
    */ 
    private static Properties props = new Properties(); 
    static 
    { 
        try { 
            props.load(new FileInputStream(profilepath)); 
        } catch (FileNotFoundException e) { 
            e.printStackTrace(); 
            System.exit(-1); 
        } catch (IOException e) {        
            System.exit(-1); 
        } 
    } 
 
    /** 
    * 读取属性文件中相应键的值 
    * @param key 
    *            主键 
    * @return String 
    */ 
    public static String getKeyValue(String key) 
    { 
        return props.getProperty(key); 
    } 
 
    /** 
    * 根据主键key读取主键的值value 
    * @param filePath 属性文件路径 
    * @param key 键名 
    */ 
    public static String readValue(String filePath, String key) 
    { 
        Properties props = new Properties(); 
        try { 
            InputStream in = new BufferedInputStream(new FileInputStream( 
                    filePath)); 
            props.load(in); 
            String value_unencrypt = props.getProperty(key);
            String value = EncryUtil.decrypt(value_unencrypt);
//            System.out.println(key +"键的值是："+ value); 
            return value; 
        } catch (Exception e) { 
            e.printStackTrace(); 
            return null; 
        } 
    } 
    
    public static String readValue_NoEncrypt(String filePath, String key) 
    { 
        Properties props = new Properties(); 
        try { 
            InputStream in = new BufferedInputStream(new FileInputStream( 
                    filePath)); 
            props.load(in); 
            String value_unencrypt =  new String( props.getProperty(key).getBytes("ISO8859-1"), "UTF-8");
//            System.out.println(key +"键的值是："+ value_unencrypt); 
            return value_unencrypt; 
        } catch (Exception e) { 
            e.printStackTrace(); 
            return null; 
        } 
    } 
    
    /** 
    * 更新（或插入）一对properties信息(主键及其键值) 
    * 如果该主键已经存在，更新该主键的值； 
    * 如果该主键不存在，则插件一对键值。 
    * @param keyname 键名 
    * @param keyvalue 键值 
    */ 
    public static void writeProperties(String keyname,String keyvalue) {        
        try { 
            // 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。 
            // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。 
            OutputStream fos = new FileOutputStream(profilepath); 
            String keyvalueEncript = EncryUtil.encrypt(keyvalue);
            props.setProperty(keyname, keyvalueEncript); 
            // 以适合使用 load 方法加载到 Properties 表中的格式， 
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流 
            props.store(fos, "Update '" + keyname + "' value"); 
        } catch (IOException e) { 
            System.err.println("属性文件更新错误"); 
        } 
    } 
 
    /** 
    * 更新properties文件的键值对 
    * 如果该主键已经存在，更新该主键的值； 
    * 如果该主键不存在，则插件一对键值。 
    * @param keyname 键名 
    * @param keyvalue 键值 
    */ 
    public static void updateProperties(String keyname,String keyvalue) { 
        try { 
            props.load(new FileInputStream(profilepath)); 
            // 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。 
            // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。 
            OutputStream fos = new FileOutputStream(profilepath);            
            props.setProperty(keyname, keyvalue); 
            // 以适合使用 load 方法加载到 Properties 表中的格式， 
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流 
            props.store(fos, "Update '" + keyname + "' value"); 
        } catch (IOException e) { 
            System.err.println("属性文件更新错误"); 
        } 
    } 
    //测试代码 

    //拿到指定盘符的硬盘序列号 初始版
    public static String getHdSerialInfo() {
        String line = "";
        String HdSerial = "";//定义变量 硬盘序列号
        try {
         Process proces = Runtime.getRuntime().exec("cmd /c dir c:");//获取命令行参数
         BufferedReader buffreader = new BufferedReader(new InputStreamReader(proces.getInputStream(),"gbk"));
         while ((line = buffreader.readLine()) != null) {
          if (line.indexOf("卷的序列号是 ") != -1) {  //读取参数并获取硬盘序列号
        	  HdSerial = line.substring(line.indexOf("卷的序列号是 ") + "卷的序列号是 ".length(), line.length());
           break;
          }
         }
        } catch (IOException e) {
         e.printStackTrace();
        }
        return HdSerial;
       }
//    拿到指定盘符的硬盘序列号 进阶版
    public static String getSerialNumber(String drive) {
	  String result = "";
	    try {
	      File file = File.createTempFile("realhowto",".vbs");
	      file.deleteOnExit();
	      FileWriter fw = new java.io.FileWriter(file);

	      String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n"
	                  +"Set colDrives = objFSO.Drives\n"
	                  +"Set objDrive = colDrives.item(\"" + drive + "\")\n"
	                  +"Wscript.Echo objDrive.SerialNumber";  // see note
	      fw.write(vbs);
	      fw.close();
	      Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
	      BufferedReader input =
	        new BufferedReader
	          (new InputStreamReader(p.getInputStream()));
	      String line;
	      while ((line = input.readLine()) != null) {
	         result += line;
	      }
	      input.close();
	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }
	    return result.trim();
	  }
    public static String getComputerName() {
    	String hostname = "Unknown";
        try
        {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
        }
        catch (UnknownHostException ex)
        {
            System.out.println("Hostname can not be resolved");
        }
        return hostname;
    }
    
    @SuppressWarnings("unused")
	private static Boolean desDecode(String str) {
		String t = EncryUtil.decrypt(str);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String nowDate = format.format(date);
		Integer result = EncryUtil.compareDate(t, nowDate);
		if (result == -1) {
			return false;
		}
		return true;
	}
	static ArrayList<String> getValuesFromKey(String key){
    	ArrayList<String> values = new ArrayList<>();
    	String tt[] =key.split(",");
	    for (String s : tt) {
//	    	System.out.println(s);
	    	values.add(s);
	    }
	    return values;
    }
    
    public static class GUI_login extends JFrame 
	{
	private static final long serialVersionUID = 1L;
		public static boolean s1= false;
		public GUI_login() 
		{
			setSize(400, 400);
			// 设置标题
			setTitle("超过限制使用次数，请付费！");
			// 绝对布局
			setLayout(null);
			// 定义一个容器
			Container c = getContentPane();
			// 创建"用户名:"标签
			JLabel jl1 = new JLabel("用户名：");
			// 创建文本框
			final JTextField jtf1 = new JTextField();
			// 创建"密码:"标签
			JLabel jl2 = new JLabel("激活码:");
			// 创建密码框
			final JPasswordField jpf1 = new JPasswordField();
			// 设置密码字符为*
			jpf1.setEchoChar('*');
			// 创建"提交"按钮
			JButton jb1 = new JButton("提交");
			// 创建"重置"按钮
			JButton jb2 = new JButton("重置");
			// 当用户名为"mr",密码为"mrsoft"时点击"提交"按钮弹出"登录成功"提示对话框
			jb1.addActionListener(new ActionListener() 
			{

				@SuppressWarnings("deprecation")
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					// TODO Auto-generated method stub
					Calendar calendar = new GregorianCalendar();


			        

					DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date date = new Date();
			        calendar.setTime(date);
					String nowDate = format.format(date);
//						System.out.println("TODAY IS : " + nowDate);
//						System.out.println("用户名是 : " + jtf1.getText());		
					String activation_code_month = nowDate+nowDate;
					String activation_code_year = jtf1.getText()+nowDate;
//						System.out.println("activation_code_year : " + activation_code_year);
//						System.out.println("activation_code_month : " + activation_code_month);
					String password_year = EncryUtil.encrypt(activation_code_year);
					String password_month = EncryUtil.encrypt(activation_code_month);
//						System.out.println("password_year : " + password_year);
//						System.out.println("password_month : " + password_month);
//						System.out.println("password : " + jpf1.getText());
					if (password_year.equals(jpf1.getText())) 
					{
						JOptionPane.showMessageDialog(null, "欢迎购买本公司的软件,你们已经拥有1年的使用权！");
						s1 = true;
				        calendar.add(Calendar.YEAR, 1);
				        date = calendar.getTime();
				        String NewDate = format.format(date);
				        NewDate = EncryUtil.encrypt(NewDate);
	    				updateProperties("date_limit",NewDate);
	    				System.exit(0);
					} 
					else if (password_month.equals(jpf1.getText())) 
					{
						JOptionPane.showMessageDialog(null, "欢迎购买本公司的软件,你们已经拥有1个月的使用权！");
						s1 = true;
				        calendar.add(Calendar.MONTH, 1);
				        date = calendar.getTime();
				        String NewDate = format.format(date);
				        NewDate = EncryUtil.encrypt(NewDate);
				        updateProperties("date_limit",NewDate);
	    				System.exit(0);
					} 
					else 
					{
						JOptionPane.showMessageDialog(null, "错误,激活失败！");
						jtf1.setText("");
						jpf1.setText("");
					}
				}
			});
			// 实现"重置"按钮功能
			jb2.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					jtf1.setText("");
					jpf1.setText("");
				}
			});
			// 将各组件添加到容器中
			c.add(jl1);
			c.add(jtf1);
			c.add(jl2);
			c.add(jpf1);
			c.add(jb1);
			c.add(jb2);
			// 设置各组件的位置以及大小
			jl1.setBounds(10, 20, 90, 30);
			jtf1.setBounds(60, 20, 210, 30);
			jl2.setBounds(25, 60, 90, 30);
			jpf1.setBounds(60, 60, 210, 30);
			jb1.setBounds(80, 100, 70, 35);
			jb2.setBounds(150, 100, 70, 35);
			// 设置窗体大小、关闭方式、不可拉伸
			setLocation(550, 300);
			setSize(300, 200);
			setVisible(true);
			setResizable(true);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}

	    //测试代码 
	    public static void main(String[] args) throws UnsupportedEncodingException 
	    { 
//	    	System.out.println(EncryUtil.encrypt("LCAB,123456,"+"LUCHENGANBAO"+",-1662024723,LAPTOP-LRQIVD86,30,2,2021-03-16"));	   
//	    	writeProperties("computerName", "DESKTOP-FCU40H2");
//	    	System.out.println(getSerialNumber("C"));	
//	    	System.out.println(getComputerName());
	    } 

}
}
	
