package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;

public class userframe extends JFrame {
	

	private JPanel contentPane;
	private JTextField textFieldFN;
	private JTable tableUser;
	private JTextField textFieldLN;
	private JTextField jmbgField;
	private JTextField idField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userframe frame = new userframe();
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
	public userframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USER");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(149, -2, 71, 14);
		contentPane.add(lblNewLabel);
		
		textFieldFN = new JTextField();
		textFieldFN.setBounds(131, 23, 134, 20);
		contentPane.add(textFieldFN);
		textFieldFN.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 859, 218);
		contentPane.add(scrollPane);
		
		tableUser = new JTable();
		scrollPane.setViewportView(tableUser);
		
		JButton deleteBtn = new JButton("DELETE");
		deleteBtn.setBounds(50, 307, 89, 23);
		contentPane.add(deleteBtn);
		
		JButton createBtn = new JButton("CREATE");
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		createBtn.setBounds(412, 307, 89, 23);
		contentPane.add(createBtn);
		
		JButton updateBtn = new JButton("UPDATE");
		updateBtn.setBounds(780, 307, 89, 23);
		contentPane.add(updateBtn);
		
		JLabel lblFirstName = new JLabel("FIRST NAME");
		lblFirstName.setBounds(52, 26, 77, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("LAST NAME");
		lblLastName.setBounds(52, 51, 77, 14);
		contentPane.add(lblLastName);
		
		textFieldLN = new JTextField();
		textFieldLN.setBounds(131, 48, 134, 20);
		contentPane.add(textFieldLN);
		textFieldLN.setColumns(10);
		
		JLabel lblJmbg = new JLabel("JMBG");
		lblJmbg.setBounds(412, 26, 48, 14);
		contentPane.add(lblJmbg);
		
		jmbgField = new JTextField();
		jmbgField.setBounds(460, 23, 198, 20);
		contentPane.add(jmbgField);
		jmbgField.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(412, 51, 46, 14);
		contentPane.add(lblId);
		
		idField = new JTextField();
		idField.setBounds(460, 48, 96, 20);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JButton btnSeatch = new JButton("SEARCH");
		btnSeatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fn = textFieldFN.getText();
				String ln = textFieldLN.getText();
				String jmbg=jmbgField.getText();
				String id=idField.getText();
				TableModel tblModel = new DefaultTableModel(userUpiti.getVrste(jmbg,fn,ln,id), userUpiti.getKolone(jmbg,fn,ln,id));
				tableUser.setModel(tblModel);
				scrollPane.setViewportView(tableUser);
			}
		});
		btnSeatch.setBounds(780, 47, 89, 23);
		contentPane.add(btnSeatch);
	}
}
