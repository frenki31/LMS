package application;
	
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.mysql.jdbc.PreparedStatement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextField code;
	private JTextField title;
	private JTextField author;
	private JTextField price;
	private JTextField page;
	PreparedStatement ps;
	ResultSet rs;
	private JLabel message;
	private JTable table;
	private JTable table_1;
	private JTable table1 = new JTable();
	private JTable table2 = new JTable();
	private JTable table_2;
	private JTextField studId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 900, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnBack = new JMenu("File");
		menuBar.add(mnBack);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				AdminLog adminLog = new AdminLog();
				adminLog.setVisible(true);
			}
		});
		mnBack.add(mntmLogout);
		
		JMenuItem mntmExit = new JMenuItem("Run as student");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				App app = new App();
				app.setVisible(true);
			}
		});
		mnBack.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(139, 69, 19));
		panel_1.setBounds(0, 0, 255, 541);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel Books = new JPanel();
		Books.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Books.setBackground(new Color(204, 153, 102));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				Books.setBackground(new Color(136,69,19));
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				Books.setBackground(new Color(204, 102, 51));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Books.setBackground(new Color(204, 153, 102));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
			tabbedPane.setSelectedIndex(0);
			}
		});
		Books.setBackground(new Color(139, 69, 19));
		Books.setBounds(0, 190, 255, 50);
		panel_1.add(Books);
		Books.setLayout(null);
		
		JLabel lblHome = new JLabel("BOOKS");
		lblHome.setForeground(Color.WHITE);
		lblHome.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblHome.setBounds(90, 5, 148, 38);
		Books.add(lblHome);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\48385622_214683232666270_1258589202010865664_n.png"));
		lblNewLabel_1.setBounds(42, 5, 38, 38);
		Books.add(lblNewLabel_1);
		
		JPanel Stats = new JPanel();
		Stats.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Stats.setBackground(new Color(204, 153, 102));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				Stats.setBackground(new Color(136,69,19));
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				Stats.setBackground(new Color(204, 102, 51));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Stats.setBackground(new Color(204, 153, 102));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		Stats.setBackground(new Color(139, 69, 19));
		Stats.setBounds(0, 240, 255, 50);
		panel_1.add(Stats);
		Stats.setLayout(null);
		
		JLabel lblStatistics = new JLabel("STATISTICS");
		lblStatistics.setForeground(Color.WHITE);
		lblStatistics.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblStatistics.setBounds(90, 5, 148, 33);
		Stats.add(lblStatistics);
		
		JLabel label_26 = new JLabel("");
		label_26.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\147203207_3002376279985686_2742615821845602784_n.png"));
		label_26.setBounds(36, 5, 44, 38);
		Stats.add(label_26);
		
		JPanel Students = new JPanel();
		Students.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Students.setBackground(new Color(204, 153, 102));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				Students.setBackground(new Color(136,69,19));
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				Students.setBackground(new Color(204, 102, 51));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Students.setBackground(new Color(204, 153, 102));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		Students.setBackground(new Color(139, 69, 19));
		Students.setBounds(0, 290, 255, 50);
		panel_1.add(Students);
		Students.setLayout(null);
		
		JLabel lblGetBook = new JLabel("STUDENTS");
		lblGetBook.setForeground(Color.WHITE);
		lblGetBook.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblGetBook.setBounds(89, 5, 148, 38);
		Students.add(lblGetBook);
		
		JLabel label_27 = new JLabel("");
		label_27.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\49575777_394017558000677_6351156389011783680_n.png"));
		label_27.setBounds(41, 5, 38, 38);
		Students.add(label_27);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\53333246_367963507376755_7415617853837017088_n.png"));
		label.setBounds(50, 9, 150, 150);
		panel_1.add(label);
		
		tabbedPane.setBounds(252, -25, 632, 568);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(1100, 541));
		panel_2.setBackground(new Color(204, 153, 102));
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_1 = new JLabel("Book Code:");
		label_1.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_1.setBounds(15, 70, 145, 30);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Title:");
		label_2.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_2.setBounds(15, 130, 145, 30);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("Edition:");
		label_3.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_3.setBounds(15, 250, 145, 30);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Author:");
		label_4.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_4.setBounds(15, 190, 145, 30);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("Price:");
		label_5.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_5.setBounds(15, 310, 145, 30);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("Number of pages:");
		label_6.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_6.setBounds(15, 370, 145, 30);
		panel_2.add(label_6);
		
		code = new JTextField();
		code.setColumns(10);
		code.setBounds(152, 70, 230, 27);
		panel_2.add(code);
		
		title = new JTextField();
		title.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String string = "^(?=.*[A-Z])(?=.*[a-z]).{2,30}$";
				Pattern pt = Pattern.compile(string);
				Matcher match = pt.matcher(title.getText());
				if(!match.matches()) {
					message.setText("Enter a real book");
				}
				else {
					message.setText(null);
				}
			
			}
		});
		title.setColumns(10);
		title.setBounds(152, 130, 230, 27);
		panel_2.add(title);
	
		author = new JTextField();
		author.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String string = "^(?=.*[A-Z])(?=.*[a-z]).{2,30}$";
				Pattern pt = Pattern.compile(string);
				Matcher match = pt.matcher(author.getText());
				if(!match.matches()) {
					message.setText("Name the real author of the book");
				}
				else {
					message.setText(null);
				}
			
			}
		});
		author.setColumns(10);
		author.setBounds(152, 190, 230, 27);
		panel_2.add(author);
		
		
		price = new JTextField();
		price.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String string = "^(?=.*[0-9]).{2,5}$";
				Pattern pt = Pattern.compile(string);
				Matcher match = pt.matcher(price.getText());
				if(!match.matches()) {
					message.setText("Price should be a numeric value");
				}
				else {
					message.setText(null);
				}
			}
		});
		price.setColumns(10);
		price.setBounds(152, 310, 230, 27);
		panel_2.add(price);
		
		page = new JTextField();
		page.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String string = "^(?=.*[0-9]).{2,5}$";
				Pattern pt = Pattern.compile(string);
				Matcher match = pt.matcher(page.getText());
				if(!match.matches()) {
					message.setText("Enter a numeric value for pages");
				}
				else {
					message.setText(null);
				}
			}
		});
		page.setColumns(10);
		page.setBounds(152, 370, 230, 27);
		panel_2.add(page);
		
		JComboBox edition = new JComboBox();
		edition.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		edition.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		edition.setBounds(152, 250, 230, 27);
		panel_2.add(edition);
		
		JButton button = new JButton("ADD");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(title.getText().trim().isEmpty() ||author.getText().trim().isEmpty() || price.getText().trim().isEmpty() || page.getText().trim().isEmpty()) {
					message.setText("Please fill all the blanks");
					}
					else {
				String sql = "insert into existingbook (book_code,title,author,edition,price,page) values(?,?,?,?,?,?)";
				try {
				ps = (PreparedStatement) myConnection.getConnection().prepareStatement(sql);
				ps.setString(1, code.getText());
				ps.setString(2, title.getText());
				ps.setString(3, author.getText());
				ps.setString(4, (String)edition.getSelectedItem());
				ps.setString(5, price.getText());
				ps.setString(6, page.getText());
				ps.execute();
				JOptionPane.showMessageDialog(null, "Book added successfully");
				code.setText("");
				title.setText("");
				author.setText("");
				price.setText("");
				page.setText("");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
					}
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Century Gothic", Font.BOLD, 15));
		button.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		button.setBackground(new Color(102, 51, 0));
		button.setBounds(15, 445, 170, 32);
		panel_2.add(button);
		
		JButton btnview = new JButton("Refresh tables");
		btnview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table1();
				table2();
			}
		});
		btnview.setForeground(Color.WHITE);
		btnview.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnview.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		btnview.setBackground(new Color(102, 51, 0));
		btnview.setBounds(212, 445, 170, 32);
		panel_2.add(btnview);
		
		message = new JLabel("");
		message.setForeground(new Color(204, 0, 0));
		message.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		message.setBounds(15, 406, 367, 28);
		panel_2.add(message);
		
		JLabel lblAddNewBook = new JLabel("Add New Book");
		lblAddNewBook.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblAddNewBook.setBounds(10, 11, 442, 43);
		panel_2.add(lblAddNewBook);
		
		table = new JTable();
		table.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		panel_2.setLayout(null);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Book Code", "Title", "Author", "Edition", "Price", "Nr. of pages"},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Book Code", "Title", "Author", "Edition", "Price", "Number of pages"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(56);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(37);
		table.getColumnModel().getColumn(4).setPreferredWidth(34);
		table.getColumnModel().getColumn(5).setPreferredWidth(65);
		table.setRowHeight(25);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(437, 34, 600, 200);
		panel_2.add(table);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		table_1.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
			}
		});
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Book Code", "Title", "Author", "Edition", "Price", "Nr of pages"},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Book Code", "Title", "Author", "Edition", "Price", "Number of pages"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(57);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(80);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(39);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(34);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(63);
		table_1.setRowHeight(25);
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		table_1.setBounds(437, 277, 600, 200);
		panel_2.add(table_1);
		
		JLabel label_7 = new JLabel("");
		label_7.setBorder(new TitledBorder(null, "Library Books", TitledBorder.LEADING, TitledBorder.TOP, new Font("Century Gothic", Font.PLAIN, 25), new Color(0, 0, 0)));
		label_7.setBounds(424, 0, 625, 243);
		panel_2.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setBorder(new TitledBorder(null, "Books Suggested", TitledBorder.LEADING, TitledBorder.TOP, new Font("Century Gothic", Font.PLAIN, 25), new Color(0, 0, 0)));
		label_8.setBounds(424, 244, 625, 243);
		panel_2.add(label_8);
		
		JButton btnUpdateBook = new JButton("Update Book");
		btnUpdateBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "update existingbook set title=?,author=?,edition=?,price=?,page=? where book_code='"+code.getText()+"'";
				try {
					ps = (PreparedStatement) myConnection.getConnection().prepareStatement(sql);
					ps.setString(1, title.getText());
					ps.setString(2, author.getText());
					ps.setString(3, (String) edition.getSelectedItem());
					ps.setString(4, price.getText());
					ps.setString(5, page.getText());
					ps.execute();
					JOptionPane.showMessageDialog(null, "Book Updated!");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnUpdateBook.setForeground(Color.WHITE);
		btnUpdateBook.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnUpdateBook.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		btnUpdateBook.setBackground(new Color(102, 51, 0));
		btnUpdateBook.setBounds(15, 488, 170, 32);
		panel_2.add(btnUpdateBook);
		
		JButton btnDeleteSuggestion = new JButton("Delete Suggestion");
		btnDeleteSuggestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql= "delete from newbook where book_code='"+code.getText()+"'";
				try {
					ps = (PreparedStatement) myConnection.getConnection().prepareStatement(sql);
					ps.execute();
					JOptionPane.showMessageDialog(null, "Suggested book is deleted");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDeleteSuggestion.setForeground(Color.WHITE);
		btnDeleteSuggestion.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnDeleteSuggestion.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		btnDeleteSuggestion.setBackground(new Color(102, 51, 0));
		btnDeleteSuggestion.setBounds(212, 488, 170, 32);
		panel_2.add(btnDeleteSuggestion);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 102));
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{"Student ID", "First Name", "Last Name", "University", "Year", "Semester"},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Student ID", "First Name", "Last Name", "University", "Year", "Semester"
			}
		));
		table_2.getColumnModel().getColumn(0).setPreferredWidth(57);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(97);
		table_2.getColumnModel().getColumn(4).setPreferredWidth(30);
		table_2.getColumnModel().getColumn(5).setPreferredWidth(51);
		table_2.setRowHeight(25);
		table_2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		table_2.setColumnSelectionAllowed(true);
		table_2.setCellSelectionEnabled(true);
		table_2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_2.setBounds(10, 124, 607, 349);
		panel.add(table_2);
		
		JLabel lblLibraryStudentRegister = new JLabel("Library Student Register");
		lblLibraryStudentRegister.setFont(new Font("Century Gothic", Font.BOLD, 35));
		lblLibraryStudentRegister.setBounds(10, 21, 607, 59);
		panel.add(lblLibraryStudentRegister);
		
		JButton button_1 = new JButton("View table information");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql = "Select * from newstudent";
				try {
					ps = (PreparedStatement) myConnection.getConnection().prepareStatement(sql);
				rs = ps.executeQuery();
				DefaultTableModel tableModel = (DefaultTableModel) table_2.getModel();
				tableModel.setRowCount(1);
				while (rs.next()) {
					Object array[] = {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6)};
					tableModel.addRow(array);
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Century Gothic", Font.BOLD, 15));
		button_1.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		button_1.setBackground(new Color(102, 51, 0));
		button_1.setBounds(10, 484, 204, 32);
		panel.add(button_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql = "delete from newstudent where student_id=?";
				try {
					ps = (PreparedStatement) myConnection.getConnection().prepareStatement(sql);
					ps.setString(1, studId.getText());
					ps.execute();
					JOptionPane.showMessageDialog(null, "Deleted successfully");
					studId.setText("");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnDelete.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		btnDelete.setBackground(new Color(102, 51, 0));
		btnDelete.setBounds(240, 484, 204, 32);
		panel.add(btnDelete);
		
		JLabel lblStudentId = new JLabel("Student ID:");
		lblStudentId.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblStudentId.setBounds(10, 91, 93, 22);
		panel.add(lblStudentId);
		
		studId = new JTextField();
		studId.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		studId.setBounds(101, 91, 114, 22);
		panel.add(studId);
		studId.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		tabbedPane.addTab("New tab", null, scrollPane_1, null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(1100, 541));
		panel_3.setBackground(new Color(204, 153, 102));
		scrollPane_1.setViewportView(panel_3);
		
		table1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		panel_3.setLayout(null);
		table1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Book Code", "Title", "Author", "Edition", "Price", "Nr. of pages", "Student ID", "First Name", "Last Name", "University", "Year", "Semester", "Date of issue"},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Book Code", "Title", "Author", "Edition", "Price", "Number of pages", "Student ID", "First Name", "Last Name", "University", "Year", "Semester", "Date of issue"
			}
		));
		table1.getColumnModel().getColumn(0).setPreferredWidth(56);
		table1.getColumnModel().getColumn(1).setPreferredWidth(80);
		table1.getColumnModel().getColumn(2).setPreferredWidth(80);
		table1.getColumnModel().getColumn(3).setPreferredWidth(37);
		table1.getColumnModel().getColumn(4).setPreferredWidth(34);
		table1.getColumnModel().getColumn(5).setPreferredWidth(65);
		table1.getColumnModel().getColumn(6).setPreferredWidth(58);
		table1.getColumnModel().getColumn(10).setPreferredWidth(28);
		table1.getColumnModel().getColumn(11).setPreferredWidth(51);
		table1.getColumnModel().getColumn(12).setPreferredWidth(66);
		table1.setRowHeight(25);
		table1.setColumnSelectionAllowed(true);
		table1.setCellSelectionEnabled(true);
		table1.setBounds(10, 32, 975, 200);
		panel_3.add(table1);
		
		table2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		table2.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
			}
		});
		table2.setModel(new DefaultTableModel(
			new Object[][] {
				{"Book Code", "Title", "Author", "Edition", "Price", "Nr of pages", "Student ID", "First Name", "Last Name", "University", "Year", "Semester", "Date of issue", "Date of return"},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Book Code", "Title", "Author", "Edition", "Price", "Number of pages", "Student ID", "First Name", "Last Name", "University", "Year", "Semester", "Date of issue", "Date of return"
			}
		));
		table2.getColumnModel().getColumn(0).setPreferredWidth(57);
		table2.getColumnModel().getColumn(1).setPreferredWidth(80);
		table2.getColumnModel().getColumn(3).setPreferredWidth(39);
		table2.getColumnModel().getColumn(4).setPreferredWidth(34);
		table2.getColumnModel().getColumn(5).setPreferredWidth(63);
		table2.getColumnModel().getColumn(6).setPreferredWidth(58);
		table2.getColumnModel().getColumn(10).setPreferredWidth(33);
		table2.getColumnModel().getColumn(11).setPreferredWidth(54);
		table2.setRowHeight(25);
		table2.setColumnSelectionAllowed(true);
		table2.setCellSelectionEnabled(true);
		table2.setBounds(10, 278, 1050, 200);
		panel_3.add(table2);
		
		JLabel label_22 = new JLabel("");
		label_22.setBorder(new TitledBorder(null, "Issued Books Details", TitledBorder.LEADING, TitledBorder.TOP, new Font("Century Gothic", Font.PLAIN, 25), new Color(0, 0, 0)));
		label_22.setBounds(0, 0, 995, 243);
		panel_3.add(label_22);
		
		JLabel label_23 = new JLabel("");
		label_23.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Returned Books Details", TitledBorder.LEADING, TitledBorder.TOP, new Font("Century Gothic", Font.PLAIN, 25), new Color(0, 0, 0)));
		label_23.setBounds(0, 243, 1070, 246);
		panel_3.add(label_23);
		
		JButton button_5 = new JButton("View table information");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table3();
				table4();
			}
		});
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Century Gothic", Font.BOLD, 15));
		button_5.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		button_5.setBackground(new Color(102, 51, 0));
		button_5.setBounds(10, 498, 204, 32);
		panel_3.add(button_5);
	}
	public void table1() {
		String sql = "select * from existingbook";
		try {
			ps=(PreparedStatement) myConnection.getConnection().prepareStatement(sql);
		    rs = ps.executeQuery();
		    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		    tableModel.setRowCount(1);
		    while(rs.next()) {
		    	Object array[]= {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)};
		    	tableModel.addRow(array);
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void table2() {
		String sql = "select * from newbook";
		try {
			ps=(PreparedStatement) myConnection.getConnection().prepareStatement(sql);
		    rs = ps.executeQuery();
		    DefaultTableModel tableModel = (DefaultTableModel) table_1.getModel();
		    tableModel.setRowCount(1);
		    while(rs.next()) {
		    	Object array[]= {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)};
		    	tableModel.addRow(array);
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void table3(){
		try {
		String sql = "select * from get";
		ps = (PreparedStatement) myConnection.getConnection().prepareStatement(sql);
		rs = ps.executeQuery();
		DefaultTableModel tableModel = (DefaultTableModel)table1.getModel();
		tableModel.setRowCount(1);
		while(rs.next()) {
			Object object[] = {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getInt(11),rs.getInt(12),rs.getString(13)};
            tableModel.addRow(object);  		
		}
	}catch (Exception e) {
	System.out.println(e);
	}
	}
	public void table4(){
		try {
		String query = "SELECT * FROM `return`";
		ps = (PreparedStatement) myConnection.getConnection().prepareStatement(query);
		rs = ps.executeQuery();
		DefaultTableModel tableModel = (DefaultTableModel)table2.getModel();
		tableModel.setRowCount(1);
		while(rs.next()) {
			Object object[] = {rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12),rs.getInt(13),rs.getString(14),rs.getString(15)};
            tableModel.addRow(object);  		
		}
	}catch (Exception e) {
	System.out.println(e);
	}
	}
}
