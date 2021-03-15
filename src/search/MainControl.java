package search;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.dom4j.DocumentException;

import search.outil.ChangeExcelData;
import search.outil.OpSqliteDB;
import search.outil.POI;
import search.outil.SerialRead;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.CardLayout;
import javax.swing.JList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.Box;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class MainControl extends JFrame implements variableStatic{

	private JPanel contentPane;
	private JTextField txtd;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_7;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_4;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_11;
	private JTextField textField_10;
	private JLabel DY;
	private JLabel PZ;
	private JLabel SM;
	private JLabel GY;
	private JLabel DIS;
	private JPanel panel_1;
	private Panel panel_2;
	private JPanel qrcode ;
	private JPanel menuShowPanel;
	private JComboBox comboBox_3;
	private JComboBox comboBox_3_1;
	private JComboBox comboBox_3_1_1;
	private JComboBox comboBox_3_1_1_1;
	private JComboBox comboBox_3_1_1_2;
	private JComboBox comboBox_3_1_1_3;
	private JComboBox comboBox;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	
	
	private boolean isClickedDY = true;
	private boolean isClickedSM = false;
	private boolean isClickedPZ = false;
	private boolean isClickedGY = false;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField txtWpscr;
	
	public static void main(String args[]) throws IOException {
		commonUtil.log = new logSystem();
		initWindows();
	} 
	/**
	 * Launch the application.
	 * @return 
	 */
	public static void initWindows() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainControl frame = new MainControl();
					Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize();
					Dimension frameSize = frame.getSize();
//					frame.setUndecorated(true);
					frame.setLocation((displaySize.width - frameSize.width) / 2, (displaySize.height - frameSize.height) / 2);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
//	用于指定菜单栏
	public void setOnClicked(int i) {
		switch(i){
	    case 0 :
	       this.DY.setForeground(Color.GREEN);
//	       this.PZ.setForeground(Color.WHITE);
//	       this.GY.setForeground(Color.WHITE);
	       this.SM.setForeground(Color.WHITE);
	       this.DIS.setText("一键打印");
	   	   this.isClickedDY = true;
	   	   this.isClickedSM = false;
	   	   this.isClickedPZ = false;
	   	   this.isClickedGY = false;
	       menuShowPanel.setVisible(true);
	       qrcode.setVisible(false);
	       break;
	    case 1 :
	       this.DY.setForeground(Color.WHITE);
//	       this.PZ.setForeground(Color.WHITE);
//	       this.GY.setForeground(Color.WHITE);
	       this.SM.setForeground(Color.GREEN);
	       this.DIS.setText("扫码输入");
	   	   this.isClickedDY = false;
	   	   this.isClickedSM = true;
	   	   this.isClickedPZ = false;
	   	   this.isClickedGY = false;
	       menuShowPanel.setVisible(false);
	       qrcode.setVisible(true);
	       break;    
	    case 2 :
	       this.DY.setForeground(Color.WHITE);
//	       this.PZ.setForeground(Color.GREEN);
//	       this.GY.setForeground(Color.WHITE);
	       this.SM.setForeground(Color.WHITE);
	   	   this.isClickedDY = false;
	   	   this.isClickedSM = false;
	   	   this.isClickedPZ = true;
	   	   this.isClickedGY = false;
	       this.DIS.setText("系统配置");     	
	       break;
	    case 3 :
	       this.DY.setForeground(Color.WHITE);
//	       this.PZ.setForeground(Color.WHITE);
//	       this.GY.setForeground(Color.GREEN);
	       this.SM.setForeground(Color.WHITE);
	   	   this.isClickedDY = false;
	   	   this.isClickedSM = false;
	   	   this.isClickedPZ = false;
	   	   this.isClickedGY = true;
	       this.DIS.setText("关于我们");	    	
	       break;
	}
		
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public MainControl() throws Exception {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1039, 754);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuShowPanel = new JPanel();
		menuShowPanel.setBackground(Color.WHITE);
		menuShowPanel.setBounds(241, 160, 794, 571);
		contentPane.add(menuShowPanel);
		menuShowPanel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.text);
		panel_1.setBackground(new Color(108,127,144));
		panel_1.setBounds(0, 0, 794, 82);
		menuShowPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("委托书");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!commonUtil.WTSisClicked) {
					lblNewLabel_4.setForeground(Color.green);
					commonUtil.ifPrint[0] = 1;
					commonUtil.WTSisClicked = true;
				}else {
					lblNewLabel_4.setForeground(Color.white);
					commonUtil.WTSisClicked = false;
					commonUtil.ifPrint[0] = 0;
				}
				
			}
			
		});
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		lblNewLabel_4.setBounds(10, 0, 75, 40);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("载货汽车表");
		lblNewLabel_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!commonUtil.ZHQCisClicked) {
					lblNewLabel_4_1.setForeground(Color.green);
					commonUtil.ifPrint[5] = 1;
					commonUtil.ZHQCisClicked = true;
				}else {
					lblNewLabel_4_1.setForeground(Color.white);
					commonUtil.ifPrint[5] = 0;
					commonUtil.ZHQCisClicked = false;
				}
			}
		});
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		lblNewLabel_4_1.setBounds(10, 42, 108, 40);
		panel_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("人工检验表");
		lblNewLabel_4_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!commonUtil.RGJYBisClicked) {
					lblNewLabel_4_2.setForeground(Color.green);
					commonUtil.ifPrint[1] = 1;
					commonUtil.RGJYBisClicked = true;
				}else {
					lblNewLabel_4_2.setForeground(Color.white);
					commonUtil.RGJYBisClicked = false;
					commonUtil.ifPrint[1] = 0;
				}
				
			}
		});
		lblNewLabel_4_2.setForeground(Color.WHITE);
		lblNewLabel_4_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		lblNewLabel_4_2.setBounds(91, 0, 108, 40);
		panel_1.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_6 = new JLabel("汽车排放外检表");
		lblNewLabel_4_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!commonUtil.QCPFWJBisClicked) {
					lblNewLabel_4_6.setForeground(Color.green);
					commonUtil.QCPFWJBisClicked = true;
					commonUtil.ifPrint[2] = 1;
				}else {
					lblNewLabel_4_6.setForeground(Color.white);
					commonUtil.QCPFWJBisClicked = false;
					commonUtil.ifPrint[2] = 0;
				}
			}
		});
		lblNewLabel_4_6.setForeground(Color.WHITE);
		lblNewLabel_4_6.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		lblNewLabel_4_6.setBounds(209, 0, 152, 40);
		panel_1.add(lblNewLabel_4_6);
		
		JLabel lblNewLabel_4_7 = new JLabel("牌证申请表");
		lblNewLabel_4_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (!commonUtil.PZSQBisClicked) {
					lblNewLabel_4_7.setForeground(Color.green);
					commonUtil.PZSQBisClicked = true;
					commonUtil.ifPrint[3] = 1;
				}else {
					lblNewLabel_4_7.setForeground(Color.white);
					commonUtil.PZSQBisClicked = false;
					commonUtil.ifPrint[3] = 0;
				}
			}
		});
		lblNewLabel_4_7.setForeground(Color.WHITE);
		lblNewLabel_4_7.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		lblNewLabel_4_7.setBounds(371, 0, 108, 40);
		panel_1.add(lblNewLabel_4_7);
		
		JLabel lblNewLabel_4_8 = new JLabel("补充申请表");
		lblNewLabel_4_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!commonUtil.BCXXBisClicked) {
					lblNewLabel_4_8.setForeground(Color.green);
					commonUtil.ifPrint[4] = 1;
					commonUtil.BCXXBisClicked = true;
				}else {
					lblNewLabel_4_8.setForeground(Color.white);
					commonUtil.BCXXBisClicked = false;
					commonUtil.ifPrint[4] = 0;
				}
			}
		});
		lblNewLabel_4_8.setForeground(Color.WHITE);
		lblNewLabel_4_8.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		lblNewLabel_4_8.setBounds(489, 0, 152, 40);
		panel_1.add(lblNewLabel_4_8);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("牵引车辆表");
		lblNewLabel_4_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!commonUtil.QYCLisClicked) {
					lblNewLabel_4_1_2.setForeground(Color.green);
					commonUtil.ifPrint[6] = 1;
					commonUtil.QYCLisClicked = true;
				}else {
					lblNewLabel_4_1_2.setForeground(Color.white);
					commonUtil.ifPrint[6] = 0;
					commonUtil.QYCLisClicked = false;
				}
			}
		});
		lblNewLabel_4_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_1_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		lblNewLabel_4_1_2.setBounds(128, 42, 108, 40);
		panel_1.add(lblNewLabel_4_1_2);
		
		JLabel lblNewLabel_4_1_2_1 = new JLabel("客车表");
		lblNewLabel_4_1_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!commonUtil.KCisClicked) {
					lblNewLabel_4_1_2_1.setForeground(Color.green);
					commonUtil.ifPrint[7] = 1;
					commonUtil.KCisClicked = true;
				}else {
					lblNewLabel_4_1_2_1.setForeground(Color.white);
					commonUtil.ifPrint[7] = 0;
					commonUtil.KCisClicked = false;
				}
			}
		});
		lblNewLabel_4_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_2_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		lblNewLabel_4_1_2_1.setBounds(246, 42, 75, 40);
		panel_1.add(lblNewLabel_4_1_2_1);
		
		JLabel lblNewLabel_4_1_2_1_1 = new JLabel("挂车表");
		lblNewLabel_4_1_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!commonUtil.GCisClicked) {
					lblNewLabel_4_1_2_1_1.setForeground(Color.green);
					commonUtil.ifPrint[8] = 1;
					commonUtil.GCisClicked = true;
				}else {
					lblNewLabel_4_1_2_1_1.setForeground(Color.white);
					commonUtil.ifPrint[8] = 0;
					commonUtil.GCisClicked = false;
				}
			}
		});
		lblNewLabel_4_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_2_1_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		lblNewLabel_4_1_2_1_1.setBounds(326, 42, 68, 40);
		panel_1.add(lblNewLabel_4_1_2_1_1);
		
		JLabel lblNewLabel_4_1_2_1_1_1 = new JLabel("性能检测判定表");
		lblNewLabel_4_1_2_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!commonUtil.XNJCPDisClicked) {
					lblNewLabel_4_1_2_1_1_1.setForeground(Color.green);
					commonUtil.ifPrint[9] = 1;
					commonUtil.XNJCPDisClicked = true;
				}else {
					lblNewLabel_4_1_2_1_1_1.setForeground(Color.white);
					commonUtil.ifPrint[9] = 0;
					commonUtil.XNJCPDisClicked = false;
				}
			}
		});
		lblNewLabel_4_1_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_2_1_1_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		lblNewLabel_4_1_2_1_1_1.setBounds(400, 42, 152, 40);
		panel_1.add(lblNewLabel_4_1_2_1_1_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-10, 0, 794, 2);
		panel_1.add(separator_1);
		
		panel_2 = new Panel();
		panel_2.setForeground(Color.DARK_GRAY);
		panel_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 83, 791, 478);
		menuShowPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("牌照号码");
		lblNewLabel_3.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_3.setForeground(SystemColor.textHighlight);
		lblNewLabel_3.setBounds(32, 0, 66, 26);
		panel_2.add(lblNewLabel_3);
		
		txtd = new JTextField();
		txtd.setForeground(Color.DARK_GRAY);
		txtd.setFont(new Font("Microsoft YaHei", Font.BOLD, 10));
		txtd.setText("晋D");
		txtd.setBounds(32, 25, 66, 35);
		panel_2.add(txtd);
		txtd.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("车架号 四位");
		lblNewLabel_3_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_3_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(32, 70, 81, 26);
		panel_2.add(lblNewLabel_3_1);
		
		textField = new JTextField();
		textField.setForeground(Color.DARK_GRAY);
		textField.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		textField.setColumns(10);
		textField.setBounds(32, 98, 66, 35);
		panel_2.add(textField);
		
		JLabel lblNewLabel_3_2 = new JLabel("详细地址");
		lblNewLabel_3_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_3_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_3_2.setBounds(32, 143, 156, 26);
		panel_2.add(lblNewLabel_3_2);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.DARK_GRAY);
		textField_1.setText("山西省长治市");
		textField_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(32, 165, 174, 35);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("139");
		textField_2.setForeground(Color.DARK_GRAY);
		textField_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(32, 236, 174, 35);
		panel_2.add(textField_2);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("电话");
		lblNewLabel_3_2_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_3_2_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_3_2_1.setBounds(32, 210, 156, 26);
		panel_2.add(lblNewLabel_3_2_1);
		
		textField_3 = new JTextField();
		textField_3.setText("047500");
		textField_3.setForeground(Color.DARK_GRAY);
		textField_3.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(32, 303, 174, 35);
		panel_2.add(textField_3);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("行政区划");
		lblNewLabel_3_2_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_3_2_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_3_2_2.setBounds(32, 281, 156, 26);
		panel_2.add(lblNewLabel_3_2_2);
		
		JLabel lblNewLabel_3_3_3 = new JLabel("累计行驶里程");
		lblNewLabel_3_3_3.setForeground(SystemColor.textHighlight);
		lblNewLabel_3_3_3.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_3_3_3.setBounds(32, 348, 142, 26);
		panel_2.add(lblNewLabel_3_3_3);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"3000", "3500", "4000", "4500", "5000"}));
		comboBox_3.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		comboBox_3.setEditable(true);
		comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setBounds(32, 373, 174, 35);
		panel_2.add(comboBox_3);
		
		JButton btnNewButton_1 = new JButton("数据提取");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {

					if (OpSqliteDB.verifyIsOkForUser()) {
					try {
//					从UI中拿到参数
						extracextractDataFromUI();
//					从通道中拿到具体有用参数
						commonUtil.resultMap = POI.Test();
//						String authority = OpSqliteDB.search("authority");
//						System.out.println("------"+authority+"-------");
//						commonUtil.resultMap = POI.GetDataFromThreeChannel(Integer.valueOf(authority));
//					对参数中的数据进行更新
						extractDataToPublicStr();
//					创建 QRCODE 图片
						POI.createQrCode();
//						for (Map.Entry<String,Object> entry :commonUtil.resultMap.entrySet()) {
//							System.out.println(entry.getKey()+" : "+entry.getValue());
//						}
//					在本地数据库中插入该数据
						OpSqliteDB.insertCarData();
						JOptionPane.showMessageDialog(null, "导出数据成功!");
//						OpSqliteDB.insertCarData();
//					在本地数据库中查询该数据
//					OpSqliteDB.queryCardata((String)commonUtil.resultMap.get("${platnum}"), (String)commonUtil.resultMap.get("${platType}"));
					
//					for (String table:tables) {
//						POI.exportData(commonUtil.resultMap, table);
//					}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						commonUtil.log.printErr("导出数据出现问题，请解决！");
						commonUtil.log.printErr(e1.toString());
						e1.printStackTrace();
					}
				}
					else {
						JOptionPane.showMessageDialog(null, "导出数据失败，因为您更改了日期!");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(new Color(241, 57, 83));
		btnNewButton_1.setBounds(553, 412, 101, 60);
		panel_2.add(btnNewButton_1);
		
		JLabel lblNewLabel_3_3_3_1 = new JLabel("额定转速");
		lblNewLabel_3_3_3_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_3_3_3_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_3_3_3_1.setBounds(32, 412, 142, 26);
		panel_2.add(lblNewLabel_3_3_3_1);
		
		textField_7 = new JTextField();
		textField_7.setText("4000");
		textField_7.setForeground(Color.DARK_GRAY);
		textField_7.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		textField_7.setColumns(10);
		textField_7.setBounds(32, 437, 174, 35);
		panel_2.add(textField_7);
		
		JLabel lblNewLabel_3_3_3_2 = new JLabel("缸数");
		lblNewLabel_3_3_3_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_3_3_3_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_3_3_3_2.setBounds(279, 0, 86, 26);
		panel_2.add(lblNewLabel_3_3_3_2);
		
		comboBox_3_1 = new JComboBox();
		comboBox_3_1.setModel(new DefaultComboBoxModel(new String[] {"4", "6"}));
		comboBox_3_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		comboBox_3_1.setEditable(true);
		comboBox_3_1.setBackground(Color.WHITE);
		comboBox_3_1.setBounds(279, 25, 98, 35);
		panel_2.add(comboBox_3_1);
		
		JLabel lblNewLabel_3_3_3_2_1 = new JLabel("进气方式");
		lblNewLabel_3_3_3_2_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_3_3_3_2_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_3_3_3_2_1.setBounds(390, 0, 102, 26);
		panel_2.add(lblNewLabel_3_3_3_2_1);
		
		comboBox_3_1_1 = new JComboBox();
		comboBox_3_1_1.setModel(new DefaultComboBoxModel(new String[] {"自然吸气", "涡轮增压"}));
		comboBox_3_1_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		comboBox_3_1_1.setEditable(true);
		comboBox_3_1_1.setBackground(Color.WHITE);
		comboBox_3_1_1.setBounds(390, 25, 102, 35);
		panel_2.add(comboBox_3_1_1);
		
		JLabel lblNewLabel_3_2_3 = new JLabel("机械连接装置型号");
		lblNewLabel_3_2_3.setForeground(SystemColor.textHighlight);
		lblNewLabel_3_2_3.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_3_2_3.setBounds(585, 0, 156, 26);
		panel_2.add(lblNewLabel_3_2_3);
		
		textField_5 = new JTextField();
		textField_5.setForeground(Color.DARK_GRAY);
		textField_5.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(585, 22, 156, 35);
		panel_2.add(textField_5);
		
		JLabel lblNewLabel_3_3_3_2_1_1 = new JLabel("轮胎数量");
		lblNewLabel_3_3_3_2_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_3_3_3_2_1_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_3_3_3_2_1_1.setBounds(585, 201, 142, 26);
		panel_2.add(lblNewLabel_3_3_3_2_1_1);
		
		comboBox_3_1_1_1 = new JComboBox();
		comboBox_3_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"2/2", "2/2/4", "2/4/4", "2/2/4/4"}));
		comboBox_3_1_1_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		comboBox_3_1_1_1.setEditable(true);
		comboBox_3_1_1_1.setBackground(Color.WHITE);
		comboBox_3_1_1_1.setBounds(585, 226, 156, 35);
		panel_2.add(comboBox_3_1_1_1);
		
		JLabel lblNewLabel_3_3_3_2_1_2 = new JLabel("变速器型式");
		lblNewLabel_3_3_3_2_1_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_3_3_3_2_1_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_3_3_3_2_1_2.setBounds(585, 272, 142, 26);
		panel_2.add(lblNewLabel_3_3_3_2_1_2);
		
		comboBox_3_1_1_2 = new JComboBox();
		comboBox_3_1_1_2.setModel(new DefaultComboBoxModel(new String[] {"手动", "自动", "手自一体"}));
		comboBox_3_1_1_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		comboBox_3_1_1_2.setEditable(true);
		comboBox_3_1_1_2.setBackground(Color.WHITE);
		comboBox_3_1_1_2.setBounds(585, 297, 156, 35);
		panel_2.add(comboBox_3_1_1_2);
		
		JLabel lblNewLabel_3_3_3_2_1_3 = new JLabel("转向轴数量");
		lblNewLabel_3_3_3_2_1_3.setForeground(SystemColor.textHighlight);
		lblNewLabel_3_3_3_2_1_3.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_3_3_3_2_1_3.setBounds(585, 342, 142, 26);
		panel_2.add(lblNewLabel_3_3_3_2_1_3);
		
		comboBox_3_1_1_3 = new JComboBox();
		comboBox_3_1_1_3.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		comboBox_3_1_1_3.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		comboBox_3_1_1_3.setEditable(true);
		comboBox_3_1_1_3.setBackground(Color.WHITE);
		comboBox_3_1_1_3.setBounds(585, 367, 156, 35);
		panel_2.add(comboBox_3_1_1_3);
		
		JLabel lblNewLabel_3_2_1_1 = new JLabel("达标车辆编号");
		lblNewLabel_3_2_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_3_2_1_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_3_2_1_1.setBounds(585, 67, 156, 26);
		panel_2.add(lblNewLabel_3_2_1_1);
		
		textField_6 = new JTextField();
		textField_6.setForeground(Color.DARK_GRAY);
		textField_6.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		textField_6.setColumns(10);
		textField_6.setBounds(585, 93, 156, 35);
		panel_2.add(textField_6);
		
		rdbtnNewRadioButton = new JRadioButton("是否全时适时四驱");
		rdbtnNewRadioButton.setBackground(SystemColor.text);
		rdbtnNewRadioButton.setForeground(SystemColor.textHighlight);
		rdbtnNewRadioButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		rdbtnNewRadioButton.setBounds(290, 177, 156, 23);
		panel_2.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_3_2_4 = new JLabel("安全性能检验");
		lblNewLabel_3_2_4.setForeground(SystemColor.textHighlight);
		lblNewLabel_3_2_4.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_3_2_4.setBounds(302, 145, 156, 26);
		panel_2.add(lblNewLabel_3_2_4);
		
		rdbtnNewRadioButton_1 = new JRadioButton("驻车制动是否使用电控制");
		rdbtnNewRadioButton_1.setForeground(SystemColor.textHighlight);
		rdbtnNewRadioButton_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1.setBounds(290, 214, 218, 23);
		panel_2.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("是否配备空气悬挂");
		rdbtnNewRadioButton_2.setForeground(SystemColor.textHighlight);
		rdbtnNewRadioButton_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		rdbtnNewRadioButton_2.setBackground(Color.WHITE);
		rdbtnNewRadioButton_2.setBounds(290, 248, 156, 23);
		panel_2.add(rdbtnNewRadioButton_2);
		
		JButton btnNewButton_1_1 = new JButton("快速打印");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					for (int i=0; i<variableStatic.tables.length;i++) {
						if (commonUtil.ifPrint[i]==1) {
							ChangeExcelData.exportDataXls(commonUtil.resultMap,variableStatic.tables[i]);
							POI.exportData(commonUtil.resultMap,variableStatic.tables[i]);
						}
					}
					for (int i=0; i<variableStatic.tables.length;i++) {
						if (commonUtil.ifPrint[i]==1) {
							POI.prinData(variableStatic.tables[i]);
						}
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setOpaque(true);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBackground(new Color(241, 57, 83));
		btnNewButton_1_1.setBounds(680, 412, 101, 60);
		panel_2.add(btnNewButton_1_1);
		
		textField_4 = new JTextField();
		textField_4.setBackground(SystemColor.textHighlight);
		textField_4.setBounds(245, 0, 12, 472);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBackground(SystemColor.textHighlight);
		textField_8.setBounds(514, 0, 12, 478);
		panel_2.add(textField_8);
		
		JLabel lblNewLabel_3_2_1_1_1 = new JLabel("最高车速");
		lblNewLabel_3_2_1_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_3_2_1_1_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_3_2_1_1_1.setBounds(585, 138, 156, 26);
		panel_2.add(lblNewLabel_3_2_1_1_1);
		
		textField_9 = new JTextField();
		textField_9.setText("250");
		textField_9.setForeground(Color.DARK_GRAY);
		textField_9.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		textField_9.setColumns(10);
		textField_9.setBounds(585, 164, 156, 35);
		panel_2.add(textField_9);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("车辆生产厂家");
		lblNewLabel_3_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_3_1_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_3_1_1.setBounds(302, 332, 156, 26);
		panel_2.add(lblNewLabel_3_1_1);
		
		textField_12 = new JTextField();
		textField_12.setForeground(Color.DARK_GRAY);
		textField_12.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		textField_12.setColumns(10);
		textField_12.setBounds(302, 360, 156, 35);
		panel_2.add(textField_12);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("轮胎规格型号");
		lblNewLabel_3_1_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_3_1_1_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_3_1_1_1.setBounds(302, 405, 156, 26);
		panel_2.add(lblNewLabel_3_1_1_1);
		
		textField_13 = new JTextField();
		textField_13.setForeground(Color.DARK_GRAY);
		textField_13.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		textField_13.setColumns(10);
		textField_13.setBounds(302, 433, 156, 35);
		panel_2.add(textField_13);
		
		JLabel lblNewLabel_3_3_3_2_1_4 = new JLabel("新车请输入以下字段");
		lblNewLabel_3_3_3_2_1_4.setForeground(Color.RED);
		lblNewLabel_3_3_3_2_1_4.setFont(new Font("Microsoft YaHei", Font.BOLD, 23));
		lblNewLabel_3_3_3_2_1_4.setBounds(267, 296, 223, 26);
		panel_2.add(lblNewLabel_3_3_3_2_1_4);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"大型汽车", "小型汽车", "外籍汽车", "两、三轮摩托车", "轻便摩托车", "农用运输车", "挂车", "教练汽车", "警用汽车", "大型新能源汽车", "小型新能源汽车", "  "}));
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(108, 25, 98, 35);
		panel_2.add(comboBox);
		
		JLabel lblNewLabel_3_3 = new JLabel("号牌种类");
		lblNewLabel_3_3.setForeground(SystemColor.textHighlight);
		lblNewLabel_3_3.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_3_3.setBounds(108, 0, 66, 26);
		panel_2.add(lblNewLabel_3_3);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("是否当天");
		rdbtnNewRadioButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(commonUtil.SFDTisClicked) {
					commonUtil.SFDTisClicked =false;
					textField_14.setEditable(true);
				}else {
					commonUtil.SFDTisClicked =true;
					textField_14.setEditable(false);
				}
			}
		});
		rdbtnNewRadioButton_3.setSelected(true);
		rdbtnNewRadioButton_3.setForeground(SystemColor.textHighlight);
		rdbtnNewRadioButton_3.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		rdbtnNewRadioButton_3.setBackground(Color.WHITE);
		rdbtnNewRadioButton_3.setBounds(119, 72, 87, 23);
		panel_2.add(rdbtnNewRadioButton_3);
		
		textField_14 = new JTextField();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String nowDate = format.format(date);
		textField_14.setForeground(Color.DARK_GRAY);
		textField_14.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		textField_14.setColumns(10);
		textField_14.setBounds(108, 98, 98, 35);
		textField_14.setText(nowDate);
		textField_14.setEditable(false);
		panel_2.add(textField_14);
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel("驱动形式");
		lblNewLabel_3_1_1_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_3_1_1_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_3_1_1_2.setBounds(279, 70, 86, 26);
		panel_2.add(lblNewLabel_3_1_1_2);
		
		JComboBox comboBox_3_1_2 = new JComboBox();
		comboBox_3_1_2.setModel(new DefaultComboBoxModel(new String[] {"前驱", "后驱", "全时四驱"}));
		comboBox_3_1_2.setToolTipText("");
		comboBox_3_1_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		comboBox_3_1_2.setEditable(true);
		comboBox_3_1_2.setBackground(Color.WHITE);
		comboBox_3_1_2.setBounds(279, 98, 98, 35);
		panel_2.add(comboBox_3_1_2);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("催化转化器型号");
		lblNewLabel_3_1_1_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_3_1_1_1_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_3_1_1_1_1.setBounds(390, 70, 118, 26);
		panel_2.add(lblNewLabel_3_1_1_1_1);
		
		txtWpscr = new JTextField();
		txtWpscr.setForeground(Color.DARK_GRAY);
		txtWpscr.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		txtWpscr.setColumns(10);
		txtWpscr.setBounds(390, 98, 102, 35);
		panel_2.add(txtWpscr);
		
		qrcode = new JPanel();
		qrcode.setBackground(SystemColor.text);
		qrcode.setForeground(SystemColor.windowBorder);
		qrcode.setBounds(241, 160, 794, 566);
		contentPane.add(qrcode);
		qrcode.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("网页网址");
		lblNewLabel_5.setForeground(SystemColor.textHighlight);
		lblNewLabel_5.setBackground(SystemColor.textHighlightText);
		lblNewLabel_5.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		lblNewLabel_5.setBounds(29, 47, 200, 44);
		qrcode.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("打印机端口号");
		lblNewLabel_5_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_5_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		lblNewLabel_5_1.setBackground(Color.WHITE);
		lblNewLabel_5_1.setBounds(29, 172, 200, 44);
		qrcode.add(lblNewLabel_5_1);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		textField_11.setColumns(10);
		textField_11.setBounds(29, 226, 634, 44);
		textField_11.setText(EncryUtil.decrypt(Protection.getKeyValue("PortNum")));

		qrcode.add(textField_11);
		
		JButton btnNewButton_1_1_1 = new JButton("系统检测");
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					commonUtil.browserString = OpSqliteDB.search("browserString");
					commonUtil.url = textField_10.getText();
					commonUtil.rep =new reptile_test(commonUtil.url);
					Protection.writeProperties("url", commonUtil.url);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					commonUtil.rep.startBrowser(commonUtil.rep.e_driver);
					JOptionPane.showMessageDialog(null, "成功打开360浏览器，请在该浏览器中进行登录哦！");
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
						e.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_1.setOpaque(true);
		btnNewButton_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		btnNewButton_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1.setBackground(new Color(241, 57, 83));
		btnNewButton_1_1_1.setBounds(29, 395, 310, 60);
		qrcode.add(btnNewButton_1_1_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(29, 115, 634, 44);
		qrcode.add(textField_10);
		textField_10.setText(EncryUtil.decrypt(Protection.getKeyValue("url")));
		
		JButton btnNewButton_1_1_1_2 = new JButton("扫码录入");
		btnNewButton_1_1_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {

					commonUtil.PortNum = textField_11.getText();
					SerialRead.ScanOpen(commonUtil.PortNum);
					Protection.writeProperties("PortNum", commonUtil.PortNum);
					JOptionPane.showMessageDialog(null, "成功打开扫描仪，请在需要的时候扫描并开始进行自动输入！");
//					ifAutoComplete
//					commonUtil.rep.get_combox(commonUtil.rep.e_driver);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnNewButton_1_1_1_2.setOpaque(true);
		btnNewButton_1_1_1_2.setForeground(Color.WHITE);
		btnNewButton_1_1_1_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		btnNewButton_1_1_1_2.setBorderPainted(false);
		btnNewButton_1_1_1_2.setBackground(new Color(241, 57, 83));
		btnNewButton_1_1_1_2.setBounds(397, 395, 310, 60);
		qrcode.add(btnNewButton_1_1_1_2);
		

		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(new Color(108,127,144));
		leftPanel.setBounds(-1, 103, 242, 619);
		contentPane.add(leftPanel);
		leftPanel.setLayout(null);
		
		DY = new JLabel("   一键打印");
		DY.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setOnClicked(0);
			}
		});
		DY.setIcon(new ImageIcon(MainControl.class.getResource("/resources/打印机.png")));
		DY.setHorizontalAlignment(SwingConstants.CENTER);
		DY.setForeground(Color.green);
		DY.setFont(new Font("Microsoft YaHei", Font.BOLD, 25));
		DY.setBounds(0, 72, 244, 62);
		leftPanel.add(DY);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 57, 244, 2);
		leftPanel.add(separator);
		
		SM = new JLabel("   扫码输入");
		SM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setOnClicked(1);
			}
		});
		SM.setIcon(new ImageIcon(MainControl.class.getResource("/resources/键盘.png")));
		SM.setHorizontalAlignment(SwingConstants.CENTER);
		SM.setForeground(Color.WHITE);
		SM.setFont(new Font("Microsoft YaHei", Font.BOLD, 25));
		SM.setBounds(0, 141, 244, 62);
		leftPanel.add(SM);
		
//		PZ = new JLabel("   系统配置");
//		PZ.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				setOnClicked(2);
//			}
//		});
//		PZ.setIcon(new ImageIcon(MainControl.class.getResource("/resources/设 置.png")));
//		PZ.setHorizontalAlignment(SwingConstants.CENTER);
//		PZ.setForeground(Color.WHITE);
//		PZ.setFont(new Font("Microsoft YaHei", Font.BOLD, 25));
//		PZ.setBounds(0, 214, 244, 62);
//		leftPanel.add(PZ);
//		
//		GY = new JLabel("   关于我们");
//		GY.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				setOnClicked(3);
//			}
//		});
//		GY.setIcon(new ImageIcon(MainControl.class.getResource("/resources/我的--关于我们.png")));
//		GY.setHorizontalAlignment(SwingConstants.CENTER);
//		GY.setForeground(Color.WHITE);
//		GY.setFont(new Font("Microsoft YaHei", Font.BOLD, 25));
//		GY.setBounds(0, 286, 244, 62);
//		leftPanel.add(GY);
		
		JLabel lblNewLabel_2 = new JLabel("WELCOME");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Algerian", Font.BOLD, 35));
		lblNewLabel_2.setBounds(0, 0, 244, 62);
		leftPanel.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(108,127,144));
		panel.setBounds(241, 102, 794, 64);
		contentPane.add(panel);
		
		DIS = new JLabel("一键打印");
		DIS.setHorizontalAlignment(SwingConstants.CENTER);
		DIS.setForeground(Color.WHITE);
		DIS.setFont(new Font("Microsoft YaHei", Font.BOLD, 35));
		panel.add(DIS);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(28,150,213));
		topPanel.setBounds(0, 0, 1035, 105);
		contentPane.add(topPanel);
		topPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainControl.class.getResource("/resources/标志.jpg")));
		lblNewLabel.setBounds(65, 0, 102, 101);
		topPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" 欢迎您！");
		lblNewLabel_1.setText(OpSqliteDB.search("cpName"));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("SimSun", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_1.setBounds(264, 25, 780, 54);
		topPanel.add(lblNewLabel_1);

	}
//	这个主要用于生成 QRcode所需要的加密字符串使用
	
	public String exportStringFromMap() {
		String a = null;
		return a;
	}
	
	public void extracextractDataFromUI() throws Exception {
		
		commonUtil.PZHM_COMMMON = this.txtd.getText();
		commonUtil.CLSBDH_COMMMON = this.textField.getText();
		commonUtil.XXDZ = this.textField_1.getText();
		commonUtil.DH = this.textField_2.getText();
		commonUtil.LJXSLC = this.comboBox_3.getEditor().getItem().toString();
		commonUtil.XZQH = this.textField_3.getText();
		commonUtil.EDZS = this.textField_7.getText();
		commonUtil.GS = this.comboBox_3_1.getEditor().getItem().toString();
		commonUtil.JQFS = this.comboBox_3_1_1.getEditor().getItem().toString();
		commonUtil.SFSSSQ = this.rdbtnNewRadioButton.isSelected();
		commonUtil.SFDKZ = this.rdbtnNewRadioButton_1.isSelected();
		commonUtil.SFKQXG = this.rdbtnNewRadioButton_2.isSelected();
		commonUtil.CLSCCJ = this.textField_12.getText();
		commonUtil.LTGGXH = this.textField_13.getText();
		commonUtil.JXLJZZXH = this.textField_5.getText();
		commonUtil.DBCLBH = this.textField_6.getText();
		commonUtil.ZGCS = this.textField_9.getText();
		commonUtil.LTSL = this.comboBox_3_1_1_1.getEditor().getItem().toString();
		commonUtil.BSQXS = this.comboBox_3_1_1_2.getEditor().getItem().toString();
		commonUtil.ZXZSL = this.comboBox_3_1_1_3.getEditor().getItem().toString();
		commonUtil.HPZL_COMMMON = this.comboBox.getSelectedItem().toString();
		
//		华燕数据库
		commonUtil.DataBase_ip_HY_COMMMON = OpSqliteDB.search("DataBase_ip_HY_COMMMON");
		commonUtil.DataBase_name_HY_COMMMON = OpSqliteDB.search("DataBase_name_HY_COMMMON");
		commonUtil.DataBase_username_HY_COMMMON = OpSqliteDB.search("DataBase_username_HY_COMMMON");
		commonUtil.DataBase_password_HY_COMMMON = OpSqliteDB.search("DataBase_password_HY_COMMMON");
		
//		赛斯数据库
		
		commonUtil.DataBase_ip_SIS_COMMMON = OpSqliteDB.search("DataBase_ip_SIS_COMMMON");
		commonUtil.DataBase_name_SIS_COMMMON =  OpSqliteDB.search("DataBase_name_SIS_COMMMON");
		commonUtil.DataBase_username_SIS_COMMMON = OpSqliteDB.search("DataBase_username_SIS_COMMMON");
		commonUtil.DataBase_password_SIS_COMMMON = OpSqliteDB.search("DataBase_password_SIS_COMMMON");
//		赛斯接口数据库
		commonUtil.url_interface=OpSqliteDB.search("url_interface");
		commonUtil.jkxlh_interface = OpSqliteDB.search("jkxlh_interface");
		commonUtil.jkdh_interface =  OpSqliteDB.search("jkdh_interface");
		commonUtil.cjsbdh_interface =OpSqliteDB.search("cjsbdh_interface");
		commonUtil.zdbs_interface = OpSqliteDB.search("zdbs_interface");
		commonUtil.dwjgdm = OpSqliteDB.search("dwjgdm");
		commonUtil.dwjgdm_URL = OpSqliteDB.search("dwjgdm_URL");


	}
//	This method is used to Set All the Static String
	public void extractDataToPublicStr() {

		commonUtil.resultMap.put("${platnum}",commonUtil.PZHM_COMMMON);
		commonUtil.resultMap.put("${address}",commonUtil.XXDZ);
		commonUtil.resultMap.put("${tel}",commonUtil.DH);
		commonUtil.resultMap.put("${postcode}",commonUtil.XZQH);
		commonUtil.resultMap.put("${usage}", commonUtil.LJXSLC);
		commonUtil.resultMap.put("${ratepeed}",commonUtil.EDZS);
		commonUtil.resultMap.put("${numOfCylinder}",commonUtil.GS);
		commonUtil.resultMap.put("${airSupethod}",commonUtil.JQFS);
		
		
//		三个是否
		if (commonUtil.SFSSSQ) {
			commonUtil.resultMap.put("${SFSQ}","是");
		}else {
			commonUtil.resultMap.put("${SFSQ}","否");
		}
		if (commonUtil.SFDKZ) {
			commonUtil.resultMap.put("${ZCZD}","是");
		}else {
			commonUtil.resultMap.put("${ZCZD}","否");
		}
		if (commonUtil.SFKQXG) {
			commonUtil.resultMap.put("${KQXG}","是");
		}else {
			commonUtil.resultMap.put("${KQXG}","否");
		}
		
//		车辆生产企业 如果数据库为空 ，调用输入字段
		String fac = (String) commonUtil.resultMap.get("${factoryName}");
		if (fac.equals("")) {
			commonUtil.resultMap.put("${factoryName}",commonUtil.CLSCCJ);
		}

//		commonUtil.resultMap.put("${LTGG}",commonUtil.LTGGXH);
		commonUtil.resultMap.put("${JXLJZZXH}",commonUtil.JXLJZZXH);
//		commonUtil.resultMap.put("${LTGG}",commonUtil.LTGGXH);
		commonUtil.resultMap.put("${DBCLBH}",commonUtil.DBCLBH);
		commonUtil.resultMap.put("${ZGCS}", commonUtil.ZGCS);
		commonUtil.resultMap.put("${LTSL}", commonUtil.LTSL);
		commonUtil.resultMap.put("${transimissionType}", commonUtil.BSQXS);
		commonUtil.resultMap.put("${ZXZSL}", commonUtil.ZXZSL);
		
//		当天的日期 年 月 日 以及将数据中所需要的两个日期格式化一下,并解决特殊的数据查询不到的问题
		if (commonUtil.SFDTisClicked) {
			Calendar cal=Calendar.getInstance();
			int y = cal.get(Calendar.YEAR);   
			int m = cal.get(Calendar.MONTH)+1;   
			int d = cal.get(Calendar.DATE);  
			commonUtil.resultMap.put("${today}",y+ "年"+m+ "月"+d+ "日");
			commonUtil.resultMap.put("${JYRQ}",y+ "年"+m+ "月"+d+ "日");

		}else {
			String inputDate = textField_14.getText();
			commonUtil.resultMap.put("${today}",commonUtil.DateToFormat(inputDate));
			commonUtil.resultMap.put("${JYRQ}",commonUtil.DateToFormat(inputDate));
		}
		
		commonUtil.resultMap.put("${CLCCRQ}",commonUtil.DateToFormat((String)commonUtil.resultMap.get("${CLCCRQ}")));
		commonUtil.resultMap.put("${CCDJRQ}",commonUtil.DateToFormat((String)commonUtil.resultMap.get("${CCDJRQ}")));

//	    基准质量= 整备质量 +100
		commonUtil.resultMap.put("${JZZZ}",String.valueOf((Integer.parseInt((String)commonUtil.resultMap.get("${ZBZL}"))+100)));
		
//      车外扩长 * 车外扩宽 * 车外扩高
		commonUtil.resultMap.put("${WXCC}",commonUtil.resultMap.get("${cwkc}") + " × " + commonUtil.resultMap.get("${cwkk}") + " × "+ commonUtil.resultMap.get("${cwkg}"));
				
//      货箱栏板尺寸长 * 货箱栏板尺寸宽 * 货箱栏板尺寸高	
		commonUtil.resultMap.put("${HXLBNCC}",commonUtil.resultMap.get("${hxnbcd}") + " × " + commonUtil.resultMap.get("${hxnbkd}") + " × "+ commonUtil.resultMap.get("${hxnbgd}"));

//		号牌种类 数字转中文
		for (int i=0;i<variableStatic.types.length;i++) {
			if (commonUtil.resultMap.get("${platType}").equals(variableStatic.types[i][0])) {
				commonUtil.resultMap.put("${platType}",variableStatic.types[i][1]);
				break;
			}
		}
		
//		车身颜色转 中文
		for (int i=0;i<variableStatic.typeColor_Site.length;i++) {
			if (commonUtil.resultMap.get("${CSYS}").equals(variableStatic.typeColor_Site[i][0])) {
				commonUtil.resultMap.put("${CSYS}",variableStatic.typeColor_Site[i][1]);
			}
		}
		
//		驱动形式 转中文 转华燕数据库
		for (int i=0; i< variableStatic.QDXS.length;i++) {
			if (commonUtil.resultMap.get("${posite}").equals(variableStatic.QDXS[i][0])) {
				commonUtil.resultMap.put("${posite}",variableStatic.QDXS[i][1] );
			}
		}
		
//		使用性质 转中文
		for (int i=0;i<variableStatic.SYXZTypes.length;i++) {
			if (commonUtil.resultMap.get("${SYXZ}").equals(variableStatic.SYXZTypes[i][0])) {
				commonUtil.resultMap.put("${CSYS}",variableStatic.SYXZTypes[i][1]);
			}
		}
//		燃料类型 转中文 燃油形式 转义
		for (int i=0;i<variableStatic.rlzlTables.length;i++) {
			String fuelType = ((String)commonUtil.resultMap.get("${fuelType}"));
			if (fuelType.equals(variableStatic.rlzlTables[i][0])) 
			{
				commonUtil.resultMap.put("${fuelType}",variableStatic.rlzlTables[i][1]);
				if ((fuelType.equals("A"))||(fuelType.equals("E"))) {
					commonUtil.resultMap.put("${fuelSupplyMethod}","闭环电喷");
				}
				else if ((fuelType.equals("B")))
				{
					commonUtil.resultMap.put("${fuelSupplyMethod}","高压共轨");
				}
				else {
					commonUtil.resultMap.put("${fuelSupplyMethod}","");
				}

				break;
			}
		}
		
//		排量 四舍五入
		String num = (String)commonUtil.resultMap.get("${PL}");
		if (!num.equals(""))
		{
			double n = Double.valueOf(num)/1000.0;
			n = Math.round(n * 10) * 0.1d;
			String str = String.format("%.1f", n);
			commonUtil.resultMap.put("${PL}",str+"");
		}
		
//		使用性质
		String syxz = (String)commonUtil.resultMap.get("${SYXZ}");
		for (int i=0;i<variableStatic.SYXZTypes.length;i++) {
			if (syxz.equals(variableStatic.SYXZTypes[i][0])) {
				commonUtil.resultMap.put("${SYXZ}",(String)variableStatic.SYXZTypes[i][1]);
				break;
			}
		}
		
		
//		车辆类型
		String cllx = (String)commonUtil.resultMap.get("${vehicleType}");
		for (int i=0;i<variableStatic.CLLXTypes.length;i++) {
			if (cllx.equals(variableStatic.CLLXTypes[i][0])) {
				commonUtil.resultMap.put("${vehicleType}",(String)variableStatic.CLLXTypes[i][1]);
				break;
			}
		}
//		网页页面上一些额外数据
		
	}
}
