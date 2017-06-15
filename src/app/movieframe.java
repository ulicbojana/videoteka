package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class movieframe extends JFrame {

	private JPanel contentPane;
	private JTextField movieTitle;
	private JTable tableMovie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					movieframe frame = new movieframe();
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
	public movieframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MOVIES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(149, 11, 71, 14);
		contentPane.add(lblNewLabel);
		
		movieTitle = new JTextField();
		movieTitle.setBounds(131, 47, 348, 20);
		contentPane.add(movieTitle);
		movieTitle.setColumns(10);
		
		JButton deleteBtn = new JButton("DELETE");
		deleteBtn.setBounds(52, 287, 89, 23);
		contentPane.add(deleteBtn);
		
		JButton createBtn = new JButton("CREATE");
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		createBtn.setBounds(277, 287, 89, 23);
		contentPane.add(createBtn);
		
		JButton updateBtn = new JButton("UPDATE");
		updateBtn.setBounds(487, 287, 89, 23);
		contentPane.add(updateBtn);
		
		JLabel lblMovieName = new JLabel("MOVIE NAME");
		lblMovieName.setBounds(52, 50, 77, 14);
		contentPane.add(lblMovieName);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 599, 196);
		contentPane.add(scrollPane);
		
		tableMovie = new JTable();
		scrollPane.setViewportView(tableMovie);
		
		JButton searchBtn = new JButton("SEARCH");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mt = movieTitle.getText();
				TableModel tblModel = new DefaultTableModel(moviesUpiti.getVrste("", mt), moviesUpiti.getKolone("", mt));
				tableMovie.setModel(tblModel);
				scrollPane.setViewportView(tableMovie);
			}
		});
		searchBtn.setBounds(520, 46, 89, 23);
		contentPane.add(searchBtn);
	}
}
