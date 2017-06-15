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

public class moviesUnos extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTitle;
	private JTextField textFieldPrice;
	private JTextField textFieldLeasted;
	private JTextField textFieldCopies;
	private JTextField textFieldGenre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					moviesUnos frame = new moviesUnos();
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
	public moviesUnos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblmoviesUnos = new JLabel("MOVIES UNOS");
		lblmoviesUnos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblmoviesUnos.setBounds(32, 32, 116, 28);
		contentPane.add(lblmoviesUnos);
		
		JLabel lblTitle = new JLabel("TITLE");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitle.setBounds(32, 88, 97, 28);
		contentPane.add(lblTitle);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setBounds(139, 93, 283, 20);
		contentPane.add(textFieldTitle);
		textFieldTitle.setColumns(10);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrice.setBounds(32, 127, 97, 28);
		contentPane.add(lblPrice);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(139, 132, 283, 20);
		contentPane.add(textFieldPrice);
		
		JLabel lblLeasted = new JLabel("LEASTED");
		lblLeasted.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLeasted.setBounds(32, 166, 97, 28);
		contentPane.add(lblLeasted);
		
		textFieldLeasted = new JTextField();
		textFieldLeasted.setColumns(10);
		textFieldLeasted.setBounds(139, 171, 283, 20);
		contentPane.add(textFieldLeasted);
		
		JLabel lblCopies = new JLabel("COPIES");
		lblCopies.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCopies.setBounds(32, 205, 97, 28);
		contentPane.add(lblCopies);
		
		textFieldCopies = new JTextField();
		textFieldCopies.setColumns(10);
		textFieldCopies.setBounds(139, 210, 283, 20);
		contentPane.add(textFieldCopies);
		
		JLabel lblGenre = new JLabel("GENRE");
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGenre.setBounds(32, 244, 97, 28);
		contentPane.add(lblGenre);
		
		textFieldGenre = new JTextField();
		textFieldGenre.setColumns(10);
		textFieldGenre.setBounds(139, 249, 283, 20);
		contentPane.add(textFieldGenre);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setBounds(32, 328, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnCance = new JButton("CANCEL");
		btnCance.setBounds(333, 328, 89, 23);
		contentPane.add(btnCance);
	}

}
