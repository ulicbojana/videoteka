package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class userUnos extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldFN;
	private JTextField textFieldLN;
	private JTextField textFieldAddress;
	private JTextField textFieldTel;
	private JTextField textFieldJMBG;
	private JTextField textFieldDate;
	private JTextField textFieldUN;
	private JTextField textFieldPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userUnos frame = new userUnos();
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
	public userUnos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserUnos = new JLabel("USER UNOS");
		lblUserUnos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserUnos.setBounds(34, 26, 173, 26);
		contentPane.add(lblUserUnos);
		
		JLabel lblFN = new JLabel("FIRST NAME");
		lblFN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFN.setBounds(42, 82, 118, 26);
		contentPane.add(lblFN);
		
		textFieldFN = new JTextField();
		textFieldFN.setBounds(137, 86, 252, 20);
		contentPane.add(textFieldFN);
		textFieldFN.setColumns(10);
		
		JLabel lblLastName = new JLabel("LAST NAME");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLastName.setBounds(42, 119, 118, 26);
		contentPane.add(lblLastName);
		
		textFieldLN = new JTextField();
		textFieldLN.setColumns(10);
		textFieldLN.setBounds(137, 119, 252, 20);
		contentPane.add(textFieldLN);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAddress.setBounds(42, 156, 118, 26);
		contentPane.add(lblAddress);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(137, 156, 252, 20);
		contentPane.add(textFieldAddress);
		
		JLabel lblTek = new JLabel("TEL NUMBER");
		lblTek.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTek.setBounds(42, 193, 118, 26);
		contentPane.add(lblTek);
		
		textFieldTel = new JTextField();
		textFieldTel.setColumns(10);
		textFieldTel.setBounds(137, 193, 252, 20);
		contentPane.add(textFieldTel);
		
		JLabel lblJmbg = new JLabel("JMBG");
		lblJmbg.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblJmbg.setBounds(42, 230, 118, 26);
		contentPane.add(lblJmbg);
		
		textFieldJMBG = new JTextField();
		textFieldJMBG.setColumns(10);
		textFieldJMBG.setBounds(137, 234, 252, 20);
		contentPane.add(textFieldJMBG);
		
		JLabel lblDateJoined = new JLabel("DATE JOINED");
		lblDateJoined.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateJoined.setBounds(42, 267, 118, 26);
		contentPane.add(lblDateJoined);
		
		textFieldDate = new JTextField();
		textFieldDate.setColumns(10);
		textFieldDate.setBounds(137, 271, 252, 20);
		contentPane.add(textFieldDate);
		
		JLabel lblActive = new JLabel("ACTIVE");
		lblActive.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblActive.setBounds(42, 376, 118, 26);
		contentPane.add(lblActive);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(137, 376, 97, 23);
		contentPane.add(checkBox);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fn=textFieldFN.getText();
				String ln=textFieldLN.getText();
				String addr=textFieldAddress.getText();
				String tel=textFieldTel.getText();
				String jmbg=textFieldJMBG.getText();
				String date=textFieldDate.getText();
				String un=textFieldUN.getText();
				String pass=textFieldPass.getText();
				boolean active=checkBox.isSelected();
				
				String rezultat = userUpiti.unos(fn, ln, addr, tel, jmbg, date, un, pass, active);
				System.out.println(rezultat);
			}
		});
		btnSave.setBounds(42, 458, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(300, 458, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(42, 304, 118, 26);
		contentPane.add(lblUsername);
		
		textFieldUN = new JTextField();
		textFieldUN.setColumns(10);
		textFieldUN.setBounds(137, 308, 252, 20);
		contentPane.add(textFieldUN);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(42, 339, 118, 26);
		contentPane.add(lblPassword);
		
		textFieldPass = new JTextField();
		textFieldPass.setColumns(10);
		textFieldPass.setBounds(137, 345, 252, 20);
		contentPane.add(textFieldPass);
	}
}
