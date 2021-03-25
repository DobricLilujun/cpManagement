package search;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GenerateActivationCode extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateActivationCode frame = new GenerateActivationCode();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GenerateActivationCode() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("用户名");
		lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 18));
		lblNewLabel.setBounds(38, 25, 66, 20);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(132, 24, 178, 24);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("密码");
		lblNewLabel_1.setFont(new Font("SimSun", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(38, 59, 66, 20);
		contentPane.add(lblNewLabel_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(132, 58, 178, 24);
		contentPane.add(textArea_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("公司名");
		lblNewLabel_1_1.setFont(new Font("SimSun", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(38, 93, 66, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setBounds(132, 92, 178, 24);
		contentPane.add(textArea_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("硬盘号");
		lblNewLabel_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(38, 123, 66, 20);
		contentPane.add(lblNewLabel_1_1_1);
		
		JTextArea textArea_1_1_1 = new JTextArea();
		textArea_1_1_1.setBounds(132, 122, 178, 24);
		contentPane.add(textArea_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("计算机名");
		lblNewLabel_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1.setBounds(38, 157, 84, 20);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JTextArea textArea_1_1_1_1 = new JTextArea();
		textArea_1_1_1_1.setBounds(132, 156, 178, 24);
		contentPane.add(textArea_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("激活天数");
		lblNewLabel_1_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1_1.setBounds(38, 195, 84, 20);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JTextArea textArea_1_1_1_1_1 = new JTextArea();
		textArea_1_1_1_1_1.setBounds(132, 194, 178, 24);
		contentPane.add(textArea_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("激活权限");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1_1_1.setBounds(38, 229, 84, 20);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		JTextArea textArea_1_1_1_1_1_1 = new JTextArea();
		textArea_1_1_1_1_1_1.setBounds(132, 228, 178, 24);
		contentPane.add(textArea_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("激活日期");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(38, 270, 84, 20);
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JTextArea textArea_1_1_1_1_1_1_1 = new JTextArea();
		textArea_1_1_1_1_1_1_1.setBounds(132, 269, 178, 24);
		contentPane.add(textArea_1_1_1_1_1_1_1);
		
		JTextArea textArea_1_1_1_1_1_1_1_1 = new JTextArea();
		textArea_1_1_1_1_1_1_1_1.setBounds(91, 315, 340, 24);
		contentPane.add(textArea_1_1_1_1_1_1_1_1);
		
		JButton btnNewButton = new JButton("生成");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a1 = textArea.getText();
				String a2 = textArea_1.getText();
				String a3 = textArea_1_1.getText();
				String a4 = textArea_1_1_1.getText();
				String a5 = textArea_1_1_1_1.getText();
				String a6 = textArea_1_1_1_1_1.getText();
				String a7 = textArea_1_1_1_1_1_1.getText();
				String a8 = textArea_1_1_1_1_1_1_1.getText();
				String code = EncryUtil.encrypt(a1+","+a2+","+a3+","+a4+","+a5+","+a6+","+a7+","+a8);
				textArea_1_1_1_1_1_1_1_1.setText(code);
			}
		});
		btnNewButton.setBounds(371, 53, 60, 215);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("激活码");
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("SimSun", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(21, 316, 60, 20);
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1_1);
	}
}
