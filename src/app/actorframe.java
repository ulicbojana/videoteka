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

public class actorframe extends JFrame {
	

	private JPanel contentPane;
	private JTextField textFieldAFN;
	private JTable tableActor;
	private JTextField textFieldALN;
	private JTextField idField;
	private JTextField textFieldMovie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					actorframe frame = new actorframe();
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
	public actorframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblActor = new JLabel("ACTOR");
		lblActor.setHorizontalAlignment(SwingConstants.CENTER);
		lblActor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblActor.setBounds(149, -2, 71, 14);
		contentPane.add(lblActor);
		
		textFieldAFN = new JTextField();
		textFieldAFN.setBounds(131, 23, 134, 20);
		contentPane.add(textFieldAFN);
		textFieldAFN.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 859, 218);
		contentPane.add(scrollPane);
		
		tableActor = new JTable();
		scrollPane.setViewportView(tableActor);
		
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
		
		JLabel lblFirstNameActor = new JLabel("FIRST NAME");
		lblFirstNameActor.setBounds(52, 26, 77, 14);
		contentPane.add(lblFirstNameActor);
		
		JLabel lblLastNameActor = new JLabel("LAST NAME");
		lblLastNameActor.setBounds(52, 51, 77, 14);
		contentPane.add(lblLastNameActor);
		
		textFieldALN = new JTextField();
		textFieldALN.setBounds(131, 48, 134, 20);
		contentPane.add(textFieldALN);
		textFieldALN.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(412, 51, 46, 14);
		contentPane.add(lblId);
		
		idField = new JTextField();
		idField.setBounds(460, 48, 96, 20);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JLabel lblMovie = new JLabel("MOVIE");
		lblMovie.setBounds(396, 26, 46, 14);
		contentPane.add(lblMovie);
		
		textFieldMovie = new JTextField();
		textFieldMovie.setBounds(459, 23, 237, 20);
		contentPane.add(textFieldMovie);
		textFieldMovie.setColumns(10);
		
		JButton btnSeatch = new JButton("SEARCH");
		btnSeatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fn = textFieldAFN.getText();
				String ln = textFieldALN.getText();
				String mov = textFieldMovie.getText();
				
				String id=idField.getText();
				TableModel tblModel = new DefaultTableModel(actorUpiti.getVrste(fn,ln,id,mov), actorUpiti.getKolone(fn,ln,id,mov));
				tableActor.setModel(tblModel);
				scrollPane.setViewportView(tableActor);
			}
		});
		btnSeatch.setBounds(780, 47, 89, 23);
		contentPane.add(btnSeatch);
	}
}
