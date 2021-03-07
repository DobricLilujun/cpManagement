package search;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.bytebuddy.asm.Advice.This;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Canvas;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import search.Protection;
import search.outil.OpSqliteDB;

import javax.swing.JPasswordField;
import search.MainControl;
public class juiWindows extends JFrame implements variableStatic{

	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JLabel infoLabel;
	public String username ;
	public String password ;
	public String cpName ;
	public String Activationkey;
	public String lastActivationDate;
	public DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	public String date_limit = Protection.readValue(profilepath, "date_limit"); 
	public String date_start = Protection.readValue(profilepath, "date_start");
	public String key_HD = Protection.readValue(profilepath, "key_HD");
	public String key_com = Protection.readValue(profilepath, "key_com");
	public String Config = Protection.readValue(profilepath, "Config");
	public String authority = Protection.readValue(profilepath, "authority");
	public String Activation = Protection.readValue(profilepath, "Activation"); 
	public Date date = new Date();
	public String nowDate = format.format(date);
    public Calendar   calendar   =   new   GregorianCalendar(); 
    public static juiWindows frame ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new juiWindows();
					Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize();
					Dimension frameSize = frame.getSize();
					frame.setLocation((displaySize.width - frameSize.width) / 2, (displaySize.height - frameSize.height) / 2);
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public juiWindows() throws Exception {
		
		// 读取基本配置数据
	    calendar.setTime(date);
	    	
		setTitle("鑫达 软件");
		setIconImage(Toolkit.getDefaultToolkit().getImage(juiWindows.class.getResource("/resources/car.png")));
		setForeground(Color.WHITE);
		setFont(new Font("Times New Roman", Font.BOLD, 22));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1068, 758);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(1,6,25));
		panel.setBounds(0, 0, 604, 763);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(2, 5, 600, 600);
		lblNewLabel_1.setIcon(new ImageIcon(juiWindows.class.getResource("/resources/icon.jpg")));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("严谨 科学 数字 智能 ");
		lblNewLabel_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 48));
		lblNewLabel_2.setBounds(90, 646, 466, 64);
		lblNewLabel_2.setForeground(Color.WHITE);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("登录 SIGN UP");
		btnNewButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				username = textField.getText();
				password = passwordField.getText();
				cpName   = textField_2.getText();
				Protection.writeProperties("cpName", cpName);
				commonUtil.COMPANY_NAME = cpName;
				Activationkey   = textField_3.getText();
				lastActivationDate = Protection.readValue(profilepath, "last_activation_date");
				Protection.writeProperties("username", username);
				Protection.writeProperties("password", password);
				Protection.writeProperties("cpName", cpName);
				
//				如果处于激活状态，直接进入使用界面
				try {
					if (Test_available())
					{
						MainControl.initWindows();
						frame.setVisible(false);
						
					}
//				如果处在非激活状态，直接开始激活
					else
					{
//					如果成功激活，更新一些基本字段
						try {
							if (activate()) {
								JOptionPane.showMessageDialog(null,"激活成功,请重新点击登录","温馨提示",JOptionPane.PLAIN_MESSAGE);
								infoLabel.setText("激活状态");
								infoLabel.setForeground(Color.green);

							}
//					如果没有成功激活，那么提示说 激活秘钥不正确，请重新激活。
							else {
								JOptionPane.showMessageDialog(null,"激活秘钥失败，请重新输入","温馨提示",JOptionPane.PLAIN_MESSAGE);
							}
						} catch (HeadlessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
			}
		});
		btnNewButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		btnNewButton.setOpaque(true);
		btnNewButton.setBackground(new Color(241, 57, 83));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBounds(665, 679, 172, 42);
		btnNewButton.setBorderPainted(false);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("用户名 USERNAME");
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel.setBounds(665, 151, 154, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("密码    PASSWORD");
		lblPassword.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblPassword.setBounds(665, 267, 154, 29);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(665, 190, 352, 42);
		textField.setText(Protection.readValue(profilepath, "username"));
		contentPane.add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(665, 230, 352, 2);
		contentPane.add(separator);
		
		JLabel lblActivationKey = new JLabel("所在公司 COMPANY");
		lblActivationKey.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblActivationKey.setBounds(665, 390, 192, 29);
		contentPane.add(lblActivationKey);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setText(Protection.readValue(profilepath, "cpName"));
		textField_2.setBounds(665, 429, 352, 42);
		contentPane.add(textField_2);
		
		JLabel lblActivationKey_1 = new JLabel("激活码   ACTIVATION KEY");
		lblActivationKey_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblActivationKey_1.setBounds(665, 520, 192, 29);
		contentPane.add(lblActivationKey_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(665, 559, 352, 42);
		if(Config.equals("IN ACTIVATION")) {
			textField_3.setEditable(false);
		}
		contentPane.add(textField_3);
		
		JButton btnExit = new JButton("退出 EXIT");

		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setOpaque(true);
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		btnExit.setBorderPainted(false);
		btnExit.setBackground(new Color(241, 57, 83));
		btnExit.setBounds(847, 679, 172, 42);
		contentPane.add(btnExit);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(665, 306, 352, 42);
		passwordField.setText(Protection.readValue(profilepath, "password"));
		contentPane.add(passwordField);
		
		infoLabel = new JLabel("激活状态");
		infoLabel.setForeground(Color.GREEN);
		infoLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 27));
		infoLabel.setBounds(817, 38, 201, 29);
		contentPane.add(infoLabel);
		Test_available();
	}
	
//	用于 使用权限过期后 判断激活方式
	public boolean activate() throws Exception {
			System.out.println(EncryUtil.decrypt(Activationkey));
    		System.out.println(EncryUtil.decrypt(Activationkey));
    		Activationkey = textField_3.getText();
    		ArrayList<String> values = Protection.getValuesFromKey(EncryUtil.decrypt(Activationkey));
    		
//    		对输入的激活码进行判定 
    		boolean isOkay = false;  // 标志激活是否成功
    		System.out.println(values.size());
//    		首先激活码 需要满足 用户+密码+公司+硬盘序列号+电脑名+允许时长+权限+激活当前时间 期位初次激活码
    		if (values.size()==8)
    		{
//    			对激活码的各个字段进行遍历,判断激活码是否复合要求
//    			判断字段是否符合，如符合，读取上次激活时间，然后将当天激活时间和上次激活时间进行对比，如果相等，说明多次激活。
        		if ((values.get(0).equals(this.username))
        			&&(values.get(1).equals(this.password))
        			&&(values.get(2).equals(this.cpName)
        			&&(values.get(3).equals(Protection.getSerialNumber("C")))
        			&&(values.get(4).equals(Protection.getComputerName()))
        			&&(values.get(7).equals(nowDate))
        			&&(!nowDate.equals(lastActivationDate))
        			)) 
        			
        		{
        			Protection.writeProperties("date_start",nowDate);
        			int duration = Integer.parseInt(values.get(5));
        			calendar.add(calendar.DATE,duration);
        			Date dateNew=calendar.getTime(); 
        			String dateNewStr = format.format(dateNew);
//        			将有效日期写入到对应的日期
        			Protection.writeProperties("date_limit", dateNewStr);
        			Protection.writeProperties("cpName", this.cpName);
//        			对于authority,填入authority中
        			Protection.writeProperties("authority", values.get(6));
        			OpSqliteDB.update("authority",values.get(6));
        			OpSqliteDB.search("authority");
        			JOptionPane.showMessageDialog(null,"成功激活软件，你有额外"+values.get(5)+"天的使用权！","温馨提示",JOptionPane.PLAIN_MESSAGE);
        			JOptionPane.showMessageDialog(null,"您的权限是"+values.get(6)+"！","温馨提示",JOptionPane.PLAIN_MESSAGE);
        			OpSqliteDB.update("date_limit",dateNewStr);
        			JOptionPane.showMessageDialog(null,"您的使用权限期至"+dateNewStr+"","温馨提示",JOptionPane.PLAIN_MESSAGE);
        			Protection.writeProperties("Config", "IN ACTIVATION");
        			textField_3.setEditable(false);
        			
        			return true;
        		}
    		}

    	return false;
	}
	
    public boolean Test_available() throws Exception
    { 
//    property 文件加密 以及 日期检错 机制
		Integer result = EncryUtil.compareDate(date_limit, nowDate);
		Integer result_Database = EncryUtil.compareDate(OpSqliteDB.search("date_limit"), nowDate);
//		如果日期在截止日期之前
		if ((result ==1)&&(result_Database==1)) {
			textField_3.setEditable(false);
			infoLabel.setText("激活状态");
			infoLabel.setForeground(Color.GREEN);
			return true;
		}else {
			Protection.writeProperties("Config", "NOT IN ACTIVATION");
			JOptionPane.showMessageDialog(null,"您的软件已经到期，请通过输入激活码激活！","温馨提示",JOptionPane.PLAIN_MESSAGE);
			textField_3.setEditable(true);
			infoLabel.setText("未激活状态");
			infoLabel.setForeground(Color.RED);
			return false;
		}

    } 
}
