package search;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class MainControl extends JFrame {

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
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	
	private boolean isClickedDY = true;
	private boolean isClickedSM = false;
	private boolean isClickedPZ = false;
	private boolean isClickedGY = false;
	
	public static void main(String args[]) {
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
	
	public void setOnClicked(int i) {
		switch(i){
	    case 0 :
	       this.DY.setForeground(Color.GREEN);
	       this.PZ.setForeground(Color.WHITE);
	       this.GY.setForeground(Color.WHITE);
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
	       this.PZ.setForeground(Color.WHITE);
	       this.GY.setForeground(Color.WHITE);
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
	       this.PZ.setForeground(Color.GREEN);
	       this.GY.setForeground(Color.WHITE);
	       this.SM.setForeground(Color.WHITE);
	   	   this.isClickedDY = false;
	   	   this.isClickedSM = false;
	   	   this.isClickedPZ = true;
	   	   this.isClickedGY = false;
	       this.DIS.setText("系统配置");     	
	       break;
	    case 3 :
	       this.DY.setForeground(Color.WHITE);
	       this.PZ.setForeground(Color.WHITE);
	       this.GY.setForeground(Color.GREEN);
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
	 */
	public MainControl() {
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
				lblNewLabel_4.setForeground(Color.green);
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
				lblNewLabel_4_1.setForeground(Color.green);
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
				lblNewLabel_4_2.setForeground(Color.green);
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
				lblNewLabel_4_6.setForeground(Color.green);
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
				lblNewLabel_4_7.setForeground(Color.green);
			}
		});
		lblNewLabel_4_7.setForeground(Color.WHITE);
		lblNewLabel_4_7.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		lblNewLabel_4_7.setBounds(371, 0, 108, 40);
		panel_1.add(lblNewLabel_4_7);
		
		JLabel lblNewLabel_4_8 = new JLabel("补充信息表");
		lblNewLabel_4_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_4_8.setForeground(Color.green);
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
				lblNewLabel_4_1_2.setForeground(Color.green);
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
				lblNewLabel_4_1_2_1.setForeground(Color.green);
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
				lblNewLabel_4_1_2_1_1.setForeground(Color.green);
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
				lblNewLabel_4_1_2_1_1_1.setForeground(Color.green);
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
		lblNewLabel_3.setBounds(32, 0, 156, 26);
		panel_2.add(lblNewLabel_3);
		
		txtd = new JTextField();
		txtd.setForeground(Color.DARK_GRAY);
		txtd.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		txtd.setText("晋D");
		txtd.setBounds(32, 25, 156, 35);
		panel_2.add(txtd);
		txtd.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("车辆识别代号 后四位");
		lblNewLabel_3_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_3_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(32, 70, 156, 26);
		panel_2.add(lblNewLabel_3_1);
		
		textField = new JTextField();
		textField.setForeground(Color.DARK_GRAY);
		textField.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		textField.setColumns(10);
		textField.setBounds(32, 98, 156, 35);
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
		textField_1.setBounds(32, 165, 156, 35);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("139");
		textField_2.setForeground(Color.DARK_GRAY);
		textField_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(32, 236, 156, 35);
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
		textField_3.setBounds(32, 303, 156, 35);
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
		comboBox_3.setBounds(32, 373, 156, 35);
		panel_2.add(comboBox_3);
		
		JButton btnNewButton_1 = new JButton("数据提取");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				extractDataToPublicStr();
			}
		});
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(new Color(241, 57, 83));
		btnNewButton_1.setBounds(290, 412, 180, 60);
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
		textField_7.setBounds(32, 437, 156, 35);
		panel_2.add(textField_7);
		
		JLabel lblNewLabel_3_3_3_2 = new JLabel("缸数");
		lblNewLabel_3_3_3_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_3_3_3_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_3_3_3_2.setBounds(302, 0, 142, 26);
		panel_2.add(lblNewLabel_3_3_3_2);
		
		comboBox_3_1 = new JComboBox();
		comboBox_3_1.setModel(new DefaultComboBoxModel(new String[] {"4", "6"}));
		comboBox_3_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		comboBox_3_1.setEditable(true);
		comboBox_3_1.setBackground(Color.WHITE);
		comboBox_3_1.setBounds(302, 25, 156, 35);
		panel_2.add(comboBox_3_1);
		
		JLabel lblNewLabel_3_3_3_2_1 = new JLabel("进气方式");
		lblNewLabel_3_3_3_2_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_3_3_3_2_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_3_3_3_2_1.setBounds(302, 70, 142, 26);
		panel_2.add(lblNewLabel_3_3_3_2_1);
		
		comboBox_3_1_1 = new JComboBox();
		comboBox_3_1_1.setModel(new DefaultComboBoxModel(new String[] {"自然吸气", "涡轮增压"}));
		comboBox_3_1_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		comboBox_3_1_1.setEditable(true);
		comboBox_3_1_1.setBackground(Color.WHITE);
		comboBox_3_1_1.setBounds(302, 95, 156, 35);
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
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setOpaque(true);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBackground(new Color(241, 57, 83));
		btnNewButton_1_1.setBounds(585, 412, 180, 60);
		panel_2.add(btnNewButton_1_1);
		
		textField_4 = new JTextField();
		textField_4.setBackground(SystemColor.textHighlight);
		textField_4.setBounds(216, 0, 12, 472);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBackground(SystemColor.textHighlight);
		textField_8.setBounds(531, 0, 12, 478);
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
		qrcode.add(textField_11);
		
		JButton btnNewButton_1_1_1 = new JButton("系统检测");
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
		
		JButton btnNewButton_1_1_1_2 = new JButton("扫码录入");
		btnNewButton_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		DY.setForeground(Color.WHITE);
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
		
		PZ = new JLabel("   系统配置");
		PZ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setOnClicked(2);
			}
		});
		PZ.setIcon(new ImageIcon(MainControl.class.getResource("/resources/设 置.png")));
		PZ.setHorizontalAlignment(SwingConstants.CENTER);
		PZ.setForeground(Color.WHITE);
		PZ.setFont(new Font("Microsoft YaHei", Font.BOLD, 25));
		PZ.setBounds(0, 214, 244, 62);
		leftPanel.add(PZ);
		
		GY = new JLabel("   关于我们");
		GY.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setOnClicked(3);
			}
		});
		GY.setIcon(new ImageIcon(MainControl.class.getResource("/resources/我的--关于我们.png")));
		GY.setHorizontalAlignment(SwingConstants.CENTER);
		GY.setForeground(Color.WHITE);
		GY.setFont(new Font("Microsoft YaHei", Font.BOLD, 25));
		GY.setBounds(0, 286, 244, 62);
		leftPanel.add(GY);
		
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
		lblNewLabel_1.setText(commonUtil.COMPANY_NAME);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 40));
		lblNewLabel_1.setBounds(264, 25, 780, 54);
		topPanel.add(lblNewLabel_1);

	}
	
//	This method is used to Set All the Static String
	public void extractDataToPublicStr() {

		commonUtil.PZHM = this.txtd.getText();
		commonUtil.CLSBDH = this.textField.getText();
		commonUtil.XXDZ = this.textField_1.getText();
		commonUtil.DH = this.textField_2.getText();
		commonUtil.XZQH = this.comboBox_3.getToolTipText();
		commonUtil.LJXSLC = this.textField_3.getText();
		commonUtil.EDZS = this.textField_7.getText();
		commonUtil.GS = this.comboBox_3_1.getEditor().getItem().toString();
		commonUtil.JQFS = this.comboBox_3_1_1.getEditor().getItem().toString();
		commonUtil.SFSSSQ = this.rdbtnNewRadioButton.isSelected();
		commonUtil.SFDKZ = this.rdbtnNewRadioButton_1.isSelected();
		commonUtil.SFKQXG = this.rdbtnNewRadioButton_2.isSelected();
		commonUtil.JXLJZZXH = this.textField_5.getText();
		commonUtil.DBCLBH = this.textField_6.getText();
		commonUtil.ZGCS = this.textField_9.getText();
		commonUtil.LTSL = this.comboBox_3_1_1_1.getEditor().getItem().toString();
		commonUtil.BSQXS = this.comboBox_3_1_1_2.getEditor().getItem().toString();
		commonUtil.ZXZSL = this.comboBox_3_1_1_3.getEditor().getItem().toString();
	
	}
}
