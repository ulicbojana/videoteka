package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class actorUnos extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldFNActor;
	private JTextField textFieldLNActor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					actorUnos frame = new actorUnos();
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
	public actorUnos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ACTOR UNOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(29, 25, 103, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblFirstName = new JLabel("FIRST NAME");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFirstName.setBounds(29, 81, 78, 25);
		contentPane.add(lblFirstName);
		
		textFieldFNActor = new JTextField();
		textFieldFNActor.setBounds(134, 84, 231, 20);
		contentPane.add(textFieldFNActor);
		textFieldFNActor.setColumns(10);
		
		JLabel lblLastName = new JLabel("LAST NAME");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLastName.setBounds(29, 140, 78, 25);
		contentPane.add(lblLastName);
		
		textFieldLNActor = new JTextField();
		textFieldLNActor.setColumns(10);
		textFieldLNActor.setBounds(134, 143, 231, 20);
		contentPane.add(textFieldLNActor);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setBounds(43, 280, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(276, 280, 89, 23);
		contentPane.add(btnCancel);
	}

}
