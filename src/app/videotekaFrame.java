package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;

public class videotekaFrame {

	private JFrame frame;
	private JTextField idMovie;
	private JTable table;
	private JTextField idActor;
	private JTextField idUser;
	private JTextField title;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					videotekaFrame window = new videotekaFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public videotekaFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 729, 412);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 713, 81);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Movies");
		lblNewLabel.setBounds(21, 11, 53, 23);
		panel.add(lblNewLabel);
		
		idMovie = new JTextField();
		idMovie.setBounds(73, 12, 86, 20);
		panel.add(idMovie);
		idMovie.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 79, 713, 274);
		frame.getContentPane().add(scrollPane);
		
		JButton btnMovie = new JButton("OK");
		btnMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idMov = idMovie.getText();
//				TableModel tblModel = new DefaultTableModel(upiti.getVrste(idMov, "movie", ""), upiti.getKolone(idMov, "movie", ""));
//				table.setModel(tblModel);
//				scrollPane.setViewportView(table);
			}
		});
		btnMovie.setBounds(165, 11, 67, 23);
		panel.add(btnMovie);
		
		JLabel lblNewLabel_1 = new JLabel("Actor");
		lblNewLabel_1.setBounds(252, 13, 103, 19);
		panel.add(lblNewLabel_1);
		
		idActor = new JTextField();
		idActor.setBounds(292, 12, 86, 20);
		panel.add(idActor);
		idActor.setColumns(10);
		
		JButton btnActor = new JButton("OK");
		btnActor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idAct = idActor.getText();
//				TableModel tblModel = new DefaultTableModel(upiti.getVrste(idAct, "actor", ""), upiti.getKolone(idAct, "actor", ""));
//				table.setModel(tblModel);
//				scrollPane.setViewportView(table);
			}
		});
		btnActor.setBounds(388, 11, 89, 23);
		panel.add(btnActor);
		
		JLabel lblNewLabel_2 = new JLabel("User");
		lblNewLabel_2.setBounds(494, 15, 46, 14);
		panel.add(lblNewLabel_2);
		
		idUser = new JTextField();
		idUser.setBounds(527, 12, 86, 20);
		panel.add(idUser);
		idUser.setColumns(10);
		
		JButton btnUser = new JButton("OK");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idUse = idUser.getText();
//				TableModel tblModel = new DefaultTableModel(upiti.getVrste(idUse, "user", ""), upiti.getKolone(idUse, "user", ""));
//				table.setModel(tblModel);
//				scrollPane.setViewportView(table);
			}
		});
		btnUser.setBounds(624, 11, 89, 23);
		panel.add(btnUser);
		
		JLabel lblNewLabel_3 = new JLabel("Title");
		lblNewLabel_3.setBounds(21, 56, 46, 14);
		panel.add(lblNewLabel_3);
		
		title = new JTextField();
		title.setBounds(73, 45, 86, 20);
		panel.add(title);
		title.setColumns(10);
		
		JButton btnTitle = new JButton("OK");
		btnTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titles = title.getText();
//				TableModel tblModel = new DefaultTableModel(upiti.getVrste("", "movie", titles), upiti.getKolone("", "movie", titles));
//				table.setModel(tblModel);
//				scrollPane.setViewportView(table);
			}
		});
		btnTitle.setBounds(165, 45, 67, 23);
		panel.add(btnTitle);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmMovies = new JMenuItem("Movies");
		mnFile.add(mntmMovies);
	}
}
