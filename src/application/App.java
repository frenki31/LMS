package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.IOP.Codec;

import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.security.KeyStore.PrivateKeyEntry;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Rectangle;
import java.awt.TextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JToolBar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;

public class App extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JLabel message = new JLabel("");
	PreparedStatement state;
	ResultSet rs;
	private JLabel message1 = new JLabel("");
	private JTextField edition1 = new JTextField();
	private JTextField school1 = new JTextField();
	private JTextField year1 = new JTextField();
	private JTextField semester1 = new JTextField();
	private JDateChooser dateChooser = new JDateChooser();
	private JTextField id2;
	private JTextField fname2;
	private JTextField lname2;
	private JTextField code2;
	private JTextField title2;
	private JTextField author2;
	private JTextField page2;
	private JTextField price2;
	private JTextField edition2;
	private JTextField school2;
	private JTextField year2;
	private JTextField semester2;
	private JTextField date2;
	private JDateChooser dateChooser_1 = new JDateChooser();
	private JTable table;
	Desktop browser;
	private JTextField id1 = new JTextField();
	private JTextField fname1 = new JTextField();
	private JTextField lname1 = new JTextField();
	private JTextField code1 = new JTextField();
	private JTextField title1 = new JTextField();
	private JTextField author1 = new JTextField();
	private JTextField page1 = new JTextField();
	private JTextField price1 = new JTextField();
	private JTextField fname = new JTextField();
	private JTextField id = new JTextField();
	private JTextField lname = new JTextField();
	private JTextField title = new JTextField();
	private JTextField code = new JTextField();
	private JTextField author = new JTextField();
	private JTextField price = new JTextField();
	private JTextField page = new JTextField();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
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
	public App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 900, 600);
		
		browser = Desktop.getDesktop();
		Read read = new Read();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?") == 0) {
				setVisible(false);
				Signin signin = new Signin();
				signin.setVisible(true);
				}
			}
		});
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnFile.add(mntmNew);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		mnFile.add(mntmLogout);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\78541238_2417106161938068_8137533415990755328_n.png"));
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		JMenuItem mntmRunAsAdmin = new JMenuItem("Run as admin");
		mntmRunAsAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminLog adminLog = new AdminLog();
				adminLog.setVisible(true);
			}
		});
		mnFile.add(mntmRunAsAdmin);
		
		JMenu mnEdit = new JMenu("Help");
		menuBar.add(mnEdit);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\52258632_770486749989853_6643440857808633856_n.png"));
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(6);
			}
		});
		mnEdit.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(139, 69, 19));
		panel_1.setBounds(0, 0, 255, 541);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel Home = new JPanel();
		Home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Home.setBackground(new Color(204, 153, 102));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				Home.setBackground(new Color(136,69,19));
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				Home.setBackground(new Color(204, 102, 51));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Home.setBackground(new Color(204, 153, 102));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
			tabbedPane.setSelectedIndex(0);
			}
		});
		Home.setBackground(new Color(139, 69, 19));
		Home.setBounds(0, 170, 255, 50);
		panel_1.add(Home);
		Home.setLayout(null);
		
		JLabel lblHome = new JLabel("HOME");
		lblHome.setForeground(Color.WHITE);
		lblHome.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblHome.setBounds(90, 5, 148, 38);
		Home.add(lblHome);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\48385622_214683232666270_1258589202010865664_n.png"));
		lblNewLabel_1.setBounds(42, 5, 38, 38);
		Home.add(lblNewLabel_1);
		
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
		Stats.setBounds(0, 220, 255, 50);
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
		
		JPanel Get = new JPanel();
		Get.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Get.setBackground(new Color(204, 153, 102));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				Get.setBackground(new Color(136,69,19));
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				Get.setBackground(new Color(204, 102, 51));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Get.setBackground(new Color(204, 153, 102));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		Get.setBackground(new Color(139, 69, 19));
		Get.setBounds(0, 270, 255, 50);
		panel_1.add(Get);
		Get.setLayout(null);
		
		JLabel lblGetBook = new JLabel("GET BOOK");
		lblGetBook.setForeground(Color.WHITE);
		lblGetBook.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblGetBook.setBounds(89, 5, 148, 38);
		Get.add(lblGetBook);
		
		JLabel label_27 = new JLabel("");
		label_27.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\49575777_394017558000677_6351156389011783680_n.png"));
		label_27.setBounds(41, 5, 38, 38);
		Get.add(label_27);
		
		JPanel Return = new JPanel();
		Return.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Return.setBackground(new Color(204, 153, 102));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				Return.setBackground(new Color(136,69,19));
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				Return.setBackground(new Color(204, 102, 51));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Return.setBackground(new Color(204, 153, 102));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabbedPane.setSelectedIndex(5);
			}
		});
		Return.setBackground(new Color(139, 69, 19));
		Return.setBounds(0, 370, 255, 50);
		panel_1.add(Return);
		Return.setLayout(null);
		
		JLabel lblReturnBook = new JLabel("RETURN BOOK");
		lblReturnBook.setForeground(Color.WHITE);
		lblReturnBook.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblReturnBook.setBounds(90, 5, 148, 38);
		Return.add(lblReturnBook);
		
		JLabel label_29 = new JLabel("");
		label_29.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\50553597_748012245565359_1439260699283947520_n.png"));
		label_29.setBounds(42, 5, 38, 38);
		Return.add(label_29);
		
		JPanel About = new JPanel();
		About.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				About.setBackground(new Color(204, 153, 102));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				About.setBackground(new Color(136,69,19));
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				About.setBackground(new Color(204, 102, 51));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				About.setBackground(new Color(204, 153, 102));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabbedPane.setSelectedIndex(6);
			}
		});
		About.setBackground(new Color(139, 69, 19));
		About.setBounds(0, 420, 255, 50);
		panel_1.add(About);
		About.setLayout(null);
		
		JLabel lblAboutUs = new JLabel("ABOUT US");
		lblAboutUs.setForeground(Color.WHITE);
		lblAboutUs.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblAboutUs.setBounds(91, 5, 148, 38);
		About.add(lblAboutUs);
		
		JLabel label_30 = new JLabel("");
		label_30.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\147079735_468457117870774_6844142523160007106_n.png"));
		label_30.setBounds(43, 5, 38, 38);
		About.add(label_30);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\read-book-learn-library-study-canva-photo-can-reuse-300x147.png"));
		label.setBounds(27, 11, 205, 128);
		panel_1.add(label);
		
		JPanel Come = new JPanel();
		Come.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent arg0) {
			Come.setBackground(new Color(204, 153, 102));
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			Come.setBackground(new Color(136,69,19));
		}
		@Override
		public void mousePressed(MouseEvent arg0) {
			Come.setBackground(new Color(204, 102, 51));
		}
		@Override
		public void mouseReleased(MouseEvent arg0) {
			Come.setBackground(new Color(204, 153, 102));
		}
		@Override
		public void mouseClicked(MouseEvent arg0) {
			tabbedPane.setSelectedIndex(7);
		}
	});
		Come.setLayout(null);
		Come.setBackground(new Color(139, 69, 19));
		Come.setBounds(0, 470, 255, 50);
		panel_1.add(Come);
		
		JLabel lblComingSoon = new JLabel("COMING SOON");
		lblComingSoon.setForeground(Color.WHITE);
		lblComingSoon.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblComingSoon.setBounds(91, 5, 164, 33);
		Come.add(lblComingSoon);
		
		JLabel lblNewLabel_2 = new JLabel("...");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_2.setBounds(43, -6, 38, 39);
		Come.add(lblNewLabel_2);
		
		JPanel READ = new JPanel();
		READ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				READ.setBackground(new Color(204, 153, 102));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				READ.setBackground(new Color(136,69,19));
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				READ.setBackground(new Color(204, 102, 51));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				READ.setBackground(new Color(204, 153, 102));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				read.setVisible(true);
			}
		});
		READ.setLayout(null);
		READ.setBackground(new Color(139, 69, 19));
		READ.setBounds(0, 320, 255, 50);
		panel_1.add(READ);
		
		JLabel lblReadBook = new JLabel("READ BOOK");
		lblReadBook.setForeground(Color.WHITE);
		lblReadBook.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblReadBook.setBounds(90, 5, 148, 38);
		READ.add(lblReadBook);
		
		JLabel label_28 = new JLabel("");
		label_28.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\49065401_599763573801184_3723141861380980736_n.png"));
		label_28.setBounds(42, 5, 38, 38);
		READ.add(label_28);
		
		tabbedPane.setBackground(new Color(204, 153, 102));
		tabbedPane.setBounds(252, -25, 632, 568);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(204, 153, 102));
		scrollPane.setBorder(null);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(204, 153, 102));
		panel_7.setPreferredSize(new Dimension(2010, 541));
		scrollPane.setViewportView(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblBestBooksFor = new JLabel("Best Books for You");
		panel_7.add(lblBestBooksFor);
		lblBestBooksFor.setBounds(new Rectangle(45, 30, 353, 50));
		lblBestBooksFor.setFont(new Font("Century Gothic", Font.BOLD, 40));
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(4);
				String sql = "select * from existingbook where book_code = 1";
				try {
					state = (PreparedStatement) myConnection.getConnection().prepareStatement(sql);
					rs = state.executeQuery();
					if(rs.next()) {
						code1.setText(rs.getString(1));
						title1.setText(rs.getString(2));
						author1.setText(rs.getString(3));
						edition1.setText(rs.getString(4));
						price1.setText(rs.getString(5));
						page1.setText(rs.getString(6));
						rs.close();
						state.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						rs.close();
						state.close();
					} catch (Exception e2) {
					}
				}
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\faust-184.jpg"));
		button.setBounds(45, 100, 270, 330);
		panel_7.add(button);
		
		JLabel lblFaustByGoethe = new JLabel("Faust by Goethe");
		lblFaustByGoethe.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblFaustByGoethe.setHorizontalAlignment(SwingConstants.CENTER);
		lblFaustByGoethe.setBounds(45, 441, 270, 30);
		panel_7.add(lblFaustByGoethe);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
				String sql = "select * from existingbook where book_code = 2";
				try {
					state = (PreparedStatement) myConnection.getConnection().prepareStatement(sql);
					rs = state.executeQuery();
					if(rs.next()) {
						code1.setText(rs.getString(1));
						title1.setText(rs.getString(2));
						author1.setText(rs.getString(3));
						edition1.setText(rs.getString(4));
						price1.setText(rs.getString(5));
						page1.setText(rs.getString(6));
						rs.close();
						state.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}finally {
					try {
						rs.close();
						state.close();
					} catch (Exception e2) {
					}
				}
			}
		});
		button_1.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\L\u2019\u00C9tranger_(Camus_novel).jpg"));
		button_1.setBounds(375, 100, 270, 330);
		panel_7.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
				String sql = "select * from existingbook where book_code = 3";
				try {
					state = (PreparedStatement) myConnection.getConnection().prepareStatement(sql);
					rs = state.executeQuery();
					if(rs.next()) {
						code1.setText(rs.getString(1));
						title1.setText(rs.getString(2));
						author1.setText(rs.getString(3));
						edition1.setText(rs.getString(4));
						price1.setText(rs.getString(5));
						page1.setText(rs.getString(6));
						rs.close();
						state.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}finally {
					try {
						rs.close();
						state.close();
					} catch (Exception e2) {
					}
				}
			}
		});
		button_2.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\notre-dame-de-paris-544090.jpg"));
		button_2.setBounds(705, 100, 270, 330);
		panel_7.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
				String sql = "select * from existingbook where book_code = 4";
				try {
					state = (PreparedStatement) myConnection.getConnection().prepareStatement(sql);
					rs = state.executeQuery();
					if(rs.next()) {
						code1.setText(rs.getString(1));
						title1.setText(rs.getString(2));
						author1.setText(rs.getString(3));
						edition1.setText(rs.getString(4));
						price1.setText(rs.getString(5));
						page1.setText(rs.getString(6));
						rs.close();
						state.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}finally {
					try {
						rs.close();
						state.close();
					} catch (Exception e2) {
					}
				}
			}
		});
		button_3.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\290-metamorphosis.jpg"));
		button_3.setBounds(1035, 100, 270, 330);
		panel_7.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
				String sql = "select * from existingbook where book_code = 5";
				try {
					state = (PreparedStatement) myConnection.getConnection().prepareStatement(sql);
					rs = state.executeQuery();
					if(rs.next()) {
						code1.setText(rs.getString(1));
						title1.setText(rs.getString(2));
						author1.setText(rs.getString(3));
						edition1.setText(rs.getString(4));
						price1.setText(rs.getString(5));
						page1.setText(rs.getString(6));
						rs.close();
						state.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}finally {
					try {
						rs.close();
						state.close();
					} catch (Exception e2) {
					}
				}
			}
		});
		button_4.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\A1aDb5U5myL.jpg"));
		button_4.setBounds(1365, 100, 270, 330);
		panel_7.add(button_4);
		
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			tabbedPane.setSelectedIndex(1);	
			}
		});
		btnAdd.setFont(new Font("Century Gothic", Font.BOLD, 60));
		btnAdd.setBounds(1695, 100, 270, 330);
		panel_7.add(btnAdd);
		
		JLabel lblTheStrangerBy = new JLabel("The Stranger by Albert Camus");
		lblTheStrangerBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheStrangerBy.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblTheStrangerBy.setBounds(375, 441, 270, 30);
		panel_7.add(lblTheStrangerBy);
	
		JLabel lblTheCathedralOf = new JLabel("The Cathedral of Paris by Victor Hugo");
		lblTheCathedralOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheCathedralOf.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblTheCathedralOf.setBounds(700, 441, 275, 30);
		panel_7.add(lblTheCathedralOf);
		
		JLabel lblTheMetamor = new JLabel("The metamorphosis by Franz Kafka");
		lblTheMetamor.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheMetamor.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblTheMetamor.setBounds(1035, 441, 270, 30);
		panel_7.add(lblTheMetamor);
		
		JLabel lblWarAndPeace = new JLabel("War and Peace by Leo Tolstoy");
		lblWarAndPeace.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarAndPeace.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblWarAndPeace.setBounds(1365, 441, 270, 30);
		panel_7.add(lblWarAndPeace);
		
		JLabel lblSuggestAB = new JLabel("Suggest a book");
		lblSuggestAB.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuggestAB.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblSuggestAB.setBounds(1695, 441, 270, 30);
		panel_7.add(lblSuggestAB);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(2010, 541));
		panel.setBackground(new Color(204, 153, 102));
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Code:");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel.setBounds(116, 65, 145, 30);
		panel.add(lblNewLabel);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblTitle.setBounds(116, 130, 145, 30);
		panel.add(lblTitle);
		
		JLabel lblEdition = new JLabel("Edition:");
		lblEdition.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblEdition.setBounds(116, 260, 145, 30);
		panel.add(lblEdition);
		
		JLabel lblPublisher = new JLabel("Author:");
		lblPublisher.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblPublisher.setBounds(116, 195, 145, 30);
		panel.add(lblPublisher);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblPrice.setBounds(116, 325, 145, 30);
		panel.add(lblPrice);
		
		JLabel lblNumberOfPages = new JLabel("Number of pages:");
		lblNumberOfPages.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNumberOfPages.setBounds(116, 390, 145, 30);
		panel.add(lblNumberOfPages);
		
		code.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String string = "^(?=.*[0-9]).{1,4}$";
				Pattern pt = Pattern.compile(string);
				Matcher match = pt.matcher(code.getText());
				if(!match.matches()) {
					message.setText("Enter a valid book code");
				}
				else {
					message.setText(null);
				}
			}
		});
		code.setBounds(271, 65, 237, 27);
		panel.add(code);
		code.setColumns(10);
		
		title.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
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
		title.setBounds(271, 130, 237, 27);
		panel.add(title);
		
		author.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
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
		author.setBounds(271, 195, 237, 27);
		panel.add(author);
		
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
		price.setBounds(271, 325, 237, 27);
		panel.add(price);
		
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
		page.setBounds(271, 390, 237, 27);
		panel.add(page);
		
		JComboBox edition = new JComboBox();
		edition.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		edition.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		edition.setBounds(271, 260, 237, 27);
		panel.add(edition);
		
		JButton add = new JButton("ADD");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(title.getText().trim().isEmpty() ||author.getText().trim().isEmpty() || price.getText().trim().isEmpty() || page.getText().trim().isEmpty()) {
				message.setText("Please fill all the blanks");
				}
				else {
				try {
					String sql = "insert into newbook (book_code, title,author,edition,price,page) values(?,?,?,?,?,?)";
					state = (PreparedStatement) myConnection.getConnection().prepareStatement(sql);
					state.setString(1, code.getText());
					state.setString(2, title.getText());
					state.setString(3,author.getText());
					state.setString(4, (String) edition.getSelectedItem());
					state.setString(5, price.getText());
					state.setString(6, page.getText());
					state.execute();
					JOptionPane.showMessageDialog(null, "New book suggested");
					code.setText("");
					title.setText("");
					author.setText("");
					price.setText("");
					page.setText("");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Choose another code for your book");
				}
				}
			}
		});
		add.setForeground(Color.WHITE);
		add.setFont(new Font("Century Gothic", Font.BOLD, 15));
		add.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		add.setBackground(new Color(102, 51, 0));
		add.setBounds(117, 470, 170, 32);
		panel.add(add);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnBack.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		btnBack.setBackground(new Color(102, 51, 0));
		btnBack.setBounds(338, 470, 170, 32);
		panel.add(btnBack);
		
		message.setForeground(new Color(204, 0, 0));
		message.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		message.setBounds(116, 430, 392, 28);
		panel.add(message);
		
		JLabel NewBook1 = new JLabel("Suggest New Book");
		NewBook1.setFont(new Font("Century Gothic", Font.BOLD, 30));
		NewBook1.setBounds(25, 10, 442, 43);
		panel.add(NewBook1);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(204, 153, 102));
		tabbedPane.addTab("New tab", null, panel_8, null);
		panel_8.setLayout(null);
		
		table = new JTable();
		table.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		panel_8.setLayout(null);
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
		table.setBounds(10, 46, 607, 375);
		panel_8.add(table);
		
		JLabel label_22 = new JLabel("");
		label_22.setBorder(new TitledBorder(null, "Library Books", TitledBorder.LEADING, TitledBorder.TOP, new Font("Century Gothic", Font.PLAIN, 25), new Color(0, 0, 0)));
		label_22.setBounds(0, 11, 627, 425);
		panel_8.add(label_22);
		
		JButton btnViewAllThe = new JButton("View all the books");
		btnViewAllThe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table1();
			}
		});
		btnViewAllThe.setForeground(Color.WHITE);
		btnViewAllThe.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnViewAllThe.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		btnViewAllThe.setBackground(new Color(102, 51, 0));
		btnViewAllThe.setBounds(10, 447, 204, 32);
		panel_8.add(btnViewAllThe);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 153, 102));
		tabbedPane.addTab("New tab", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblStudentId = new JLabel("Student ID:");
		lblStudentId.setBounds(117, 61, 88, 30);
		lblStudentId.setFont(new Font("Century Gothic", Font.BOLD, 15));
		panel_3.add(lblStudentId);
		
		JLabel lblName = new JLabel("First Name:");
		lblName.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblName.setBounds(117, 127, 145, 30);
		panel_3.add(lblName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblLastName.setBounds(117, 192, 145, 30);
		panel_3.add(lblLastName);
		
		JLabel lblUniversity = new JLabel("University:");
		lblUniversity.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblUniversity.setBounds(117, 256, 145, 30);
		panel_3.add(lblUniversity);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblYear.setBounds(117, 319, 145, 30);
		panel_3.add(lblYear);
		
		JLabel lblSemester = new JLabel("Semester:");
		lblSemester.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblSemester.setBounds(117, 390, 145, 30);
		panel_3.add(lblSemester);
		
		id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String string = "^(?=.*[0-9]).{0,3}$";
				Pattern pt = Pattern.compile(string);
				Matcher match = pt.matcher(id.getText());
				if(!match.matches()) {
					message1.setText("Enter a valid student ID");
				}
				else {
					message1.setText(null);
				}
			}
		});
		id.setColumns(10);
		id.setBounds(259, 65, 237, 27);
		panel_3.add(id);
		
		fname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String string = "^(?=.*[A-Z])(?=.*[a-z]).{2,20}$";
				Pattern pt = Pattern.compile(string);
				Matcher match = pt.matcher(fname.getText());
				if(!match.matches()) {
					message1.setText("Enter your real first name");
				}
				else {
					message1.setText(null);
				}
			}
		});
		fname.setColumns(10);
		fname.setBounds(259, 130, 237, 27);
		panel_3.add(fname);
		
		lname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String string = "^(?=.*[A-Z])(?=.*[a-z]).{2,20}$";
				Pattern pt = Pattern.compile(string);
				Matcher match = pt.matcher(lname.getText());
				if(!match.matches()) {
					message1.setText("Enter your real last name");
				}
				else {
					message1.setText(null);
				}
			}
		});
		lname.setColumns(10);
		lname.setBounds(259, 195, 237, 27);
		panel_3.add(lname);
		
		JComboBox school = new JComboBox();
		school.setModel(new DefaultComboBoxModel(new String[] {"Univeristy of Tirana", "Aldent University", "Epoka University", "New York University,Tirana", "Canadian Institute of Technology"}));
		school.setBounds(259, 260, 237, 27);
		panel_3.add(school);
		
		JComboBox year = new JComboBox();
		year.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		year.setBounds(259, 322, 237, 27);
		panel_3.add(year);
		
		JComboBox semester = new JComboBox();
		semester.setModel(new DefaultComboBoxModel(new String[] {"1", "2","3","4","5","6"}));
		semester.setBounds(259, 390, 237, 27);
		panel_3.add(semester);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(fname.getText().trim().isEmpty() ||lname.getText().trim().isEmpty() || id.getText().trim().isEmpty()) {
					message1.setText("Please fill all the blanks");
					}
					else {
					try {
						String sql = "insert into newstudent (student_id,firstname,lastname,school,year,semester) values(?,?,?,?,?,?)";
						state = (PreparedStatement) myConnection.getConnection().prepareStatement(sql);
						state.setString(1, id.getText());
						state.setString(2, fname.getText());
						state.setString(3, lname.getText());
						state.setString(4, (String) school.getSelectedItem());
						state.setString(5, (String) year.getSelectedItem());
						state.setString(6, (String) semester.getSelectedItem());
						state.execute();
						JOptionPane.showMessageDialog(null, "New student registered");
						fname.setText("");
						lname.setText("");
						id.setText("");
						tabbedPane.setSelectedIndex(4);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "This ID is taken. Choose another one");
					}
					}
			}
		});
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnRegister.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		btnRegister.setBackground(new Color(102, 51, 0));
		btnRegister.setBounds(117, 470, 155, 32);
		panel_3.add(btnRegister);
		
		JButton btnBack1 = new JButton("Back");
		btnBack1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(4);
 			}
		});
		btnBack1.setForeground(Color.WHITE);
		btnBack1.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnBack1.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		btnBack1.setBackground(new Color(102, 51, 0));
		btnBack1.setBounds(341, 470, 155, 32);
		panel_3.add(btnBack1);
		
		message1.setForeground(new Color(204, 0, 0));
		message1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		message1.setBounds(117, 431, 379, 28);
		panel_3.add(message1);
		
		JLabel newstudent = new JLabel("New Student");
		newstudent.setFont(new Font("Century Gothic", Font.BOLD, 30));
		newstudent.setBounds(25, 10, 442, 43);
		panel_3.add(newstudent);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(204, 153, 102));
		tabbedPane.addTab("New tab", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel label1 = new JLabel("Student ID:");
		label1.setBounds(340, 45, 77, 30);
		label1.setFont(new Font("Century Gothic", Font.BOLD, 15));
		panel_4.add(label1);
		
		id1.setColumns(10);
		id1.setBounds(432, 45, 170, 27);
		panel_4.add(id1);
		
		fname1.setEditable(false);
		fname1.setColumns(10);
		fname1.setBounds(432, 105, 170, 27);
		panel_4.add(fname1);
		
		lname1.setEditable(false);
		lname1.setColumns(10);
		lname1.setBounds(432, 165, 170, 27);
		panel_4.add(lname1);
		
		code1.setColumns(10);
		code1.setBounds(130, 45, 170, 27);
		panel_4.add(code1);
		
		title1.setEditable(false);
		title1.setColumns(10);
		title1.setBounds(130, 105, 170, 27);
		panel_4.add(title1);
		
		author1.setEditable(false);
		author1.setColumns(10);
		author1.setBounds(130, 165, 170, 27);
		panel_4.add(author1);
		
		page1.setEditable(false);
		page1.setColumns(10);
		page1.setBounds(130, 345, 170, 27);
		panel_4.add(page1);
		
		price1.setEditable(false);
		price1.setColumns(10);
		price1.setBounds(130, 285, 170, 27);
		panel_4.add(price1);
		
		JLabel label_1 = new JLabel("First Name:");
		label_1.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_1.setBounds(340, 105, 91, 30);
		panel_4.add(label_1);
		
		JLabel label_2 = new JLabel("Last Name:");
		label_2.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_2.setBounds(340, 165, 145, 30);
		panel_4.add(label_2);
		
		JLabel label_3 = new JLabel("University:");
		label_3.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_3.setBounds(340, 225, 145, 30);
		panel_4.add(label_3);
		
		JLabel label_4 = new JLabel("Year:");
		label_4.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_4.setBounds(340, 285, 145, 30);
		panel_4.add(label_4);
		
		JLabel label_5 = new JLabel("Semester:");
		label_5.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_5.setBounds(340, 345, 145, 30);
		panel_4.add(label_5);
		
		JLabel label_6 = new JLabel("Book Code:");
		label_6.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_6.setBounds(20, 45, 100, 30);
		panel_4.add(label_6);
		
		JLabel label_7 = new JLabel("Title:");
		label_7.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_7.setBounds(20, 105, 145, 30);
		panel_4.add(label_7);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblAuthor.setBounds(20, 165, 145, 30);
		panel_4.add(lblAuthor);
		
		JLabel Edition = new JLabel("Edition:");
		Edition.setFont(new Font("Century Gothic", Font.BOLD, 15));
		Edition.setBounds(20, 225, 145, 30);
		panel_4.add(Edition);
		
		JLabel Price = new JLabel("Price:");
		Price.setFont(new Font("Century Gothic", Font.BOLD, 15));
		Price.setBounds(20, 285, 145, 30);
		panel_4.add(Price);
		
		JLabel NumberOfPages = new JLabel("No. of pages:");
		NumberOfPages.setFont(new Font("Century Gothic", Font.BOLD, 15));
		NumberOfPages.setBounds(20, 345, 145, 30);
		panel_4.add(NumberOfPages);
		
		JButton btnNewButton_1 = new JButton("Search Student ID");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\52258632_770486749989853_6643440857808633856_n.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = "select * from newstudent where student_id= '"+id1.getText()+"'";
				try {
					state = (PreparedStatement) myConnection.getConnection().prepareStatement(query);
					rs = state.executeQuery();
					if(rs.next()) {
						fname1.setText(rs.getString(2));
						lname1.setText(rs.getString(3));
						school1.setText(rs.getString(4));
						year1.setText(rs.getString(5));
						semester1.setText(rs.getString(6));
						rs.close();
						state.close();
					}
					else {
						JOptionPane.showMessageDialog(null, "Student is not registered");
						id1.setText("");
						fname1.setText("");
						lname1.setText("");
						school1.setText("");
						year1.setText("");
						semester1.setText("");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						rs.close();
						state.close();
					} catch (Exception e2) {
					}
				}
				
			}
		});
		btnNewButton_1.setBounds(340, 393, 262, 27);
		panel_4.add(btnNewButton_1);
		
		JLabel lblDateOf = new JLabel("Date of  issuance:");
		lblDateOf.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblDateOf.setBounds(268, 446, 170, 30);
		panel_4.add(lblDateOf);
		
		JLabel label_8 = new JLabel("");
		label_8.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Book Details", TitledBorder.LEADING, TitledBorder.TOP, new Font("Century Gothic", Font.PLAIN, 25), new Color(0, 0, 0)));
		label_8.setBounds(0, 0, 312, 435);
		panel_4.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Student Details", TitledBorder.LEADING, TitledBorder.TOP, new Font("Century Gothic", Font.PLAIN, 25), new Color(0, 0, 0)));
		label_9.setBounds(317, 0, 312, 435);
		panel_4.add(label_9);
		
		JButton btnGet = new JButton("GET");
		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = "insert into get (book_code,title,author,edition,price,page,student_id,firstname,lastname,school,year,semester,date) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				state = (PreparedStatement) myConnection.getConnection().prepareStatement(query);
				state.setString(1, code1.getText());
				state.setString(2, title1.getText());
				state.setString(3, author1.getText());
				state.setString(4, edition1.getText());
				state.setString(5, price1.getText());
				state.setString(6, page1.getText());
				state.setString(7, id1.getText());
				state.setString(8, fname1.getText());
				state.setString(9, lname1.getText());
				state.setString(10, school1.getText());
				state.setString(11, year1.getText());
				state.setString(12, semester1.getText());
				state.setString(13, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());
				state.execute();
				JOptionPane.showMessageDialog(null, "You got the book. Enjoy reading it!");
				code1.setText("");
				title1.setText("");
				author1.setText("");
				edition1.setText("");
				price1.setText("");
				page1.setText("");
				id1.setText("");
				fname1.setText("");
				lname1.setText("");
				school1.setText("");
				year1.setText("");
				semester1.setText("");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"This book is already issed. It must be returned so you can get it");
				code1.setText("");
				title1.setText("");
				author1.setText("");
				edition1.setText("");
				price1.setText("");
				page1.setText("");
				id1.setText("");
				fname1.setText("");
				lname1.setText("");
				school1.setText("");
				year1.setText("");
				semester1.setText("");
			}
			}
		});
		btnGet.setForeground(Color.WHITE);
		btnGet.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnGet.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		btnGet.setBackground(new Color(102, 51, 0));
		btnGet.setBounds(268, 487, 160, 32);
		panel_4.add(btnGet);
		
		JButton btnBack11 = new JButton("Back");
		btnBack11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnBack11.setForeground(Color.WHITE);
		btnBack11.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnBack11.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		btnBack11.setBackground(new Color(102, 51, 0));
		btnBack11.setBounds(442, 487, 160, 32);
		panel_4.add(btnBack11);
		
		edition1.setEditable(false);
		edition1.setColumns(10);
		edition1.setBounds(130, 225, 170, 27);
		panel_4.add(edition1);
		
		school1.setEditable(false);
		school1.setColumns(10);
		school1.setBounds(432, 225, 170, 27);
		panel_4.add(school1);
		
		year1.setEditable(false);
		year1.setColumns(10);
		year1.setBounds(432, 285, 170, 27);
		panel_4.add(year1);
		
		semester1.setEditable(false);
		semester1.setColumns(10);
		semester1.setBounds(432, 345, 170, 27);
		panel_4.add(semester1);
		
		dateChooser.setBounds(432, 450, 170, 25);
		panel_4.add(dateChooser);
		
		JLabel lblNoStudentAccount = new JLabel("No student account?");
		lblNoStudentAccount.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblNoStudentAccount.setBounds(39, 449, 180, 22);
		panel_4.add(lblNoStudentAccount);
		
		JLabel lblClickHere = new JLabel("<html><u>Click here</u></html>");
		lblClickHere.setForeground(new Color(0, 0, 0));
		lblClickHere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabbedPane.setSelectedIndex(3);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblClickHere.setForeground(new Color(0,0,102));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblClickHere.setForeground(new Color(0,0,0));
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				lblClickHere.setForeground(new Color(0,51,204));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				lblClickHere.setForeground(new Color(0,0,0));
			}
		});
		lblClickHere.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblClickHere.setBounds(88, 476, 77, 20);
		panel_4.add(lblClickHere);
		
		JButton btnSearchBookCode = new JButton("Search Book Code");
		btnSearchBookCode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = "select * from existingbook where book_code='"+code1.getText()+"'";
				try {
					state = (PreparedStatement) myConnection.getConnection().prepareStatement(sql);
					rs = state.executeQuery();
					if(rs.next()) {
						title1.setText(rs.getString(2));
						author1.setText(rs.getString(3));
						edition1.setText(rs.getString(4));
						price1.setText(rs.getString(5));
						page1.setText(rs.getString(6));
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSearchBookCode.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\52258632_770486749989853_6643440857808633856_n.png"));
		btnSearchBookCode.setBounds(20, 395, 280, 27);
		panel_4.add(btnSearchBookCode);
		
		panel_5 = new JPanel();
		panel_5.setBackground(new Color(204, 153, 102));
		tabbedPane.addTab("New tab", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel label_10 = new JLabel("Student ID:");
		label_10.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_10.setBounds(340, 45, 77, 30);
		panel_5.add(label_10);
		
		id2 = new JTextField();
		id2.setColumns(10);
		id2.setBounds(432, 45, 170, 27);
		panel_5.add(id2);
		
		fname2 = new JTextField();
		fname2.setEditable(false);
		fname2.setColumns(10);
		fname2.setBounds(432, 105, 170, 27);
		panel_5.add(fname2);
		
		lname2 = new JTextField();
		lname2.setEditable(false);
		lname2.setColumns(10);
		lname2.setBounds(432, 165, 170, 27);
		panel_5.add(lname2);
		
		code2 = new JTextField();
		code2.setEditable(false);
		code2.setColumns(10);
		code2.setBounds(130, 45, 170, 27);
		panel_5.add(code2);
		
		title2 = new JTextField();
		title2.setEditable(false);
		title2.setColumns(10);
		title2.setBounds(130, 105, 170, 27);
		panel_5.add(title2);
		
		author2 = new JTextField();
		author2.setEditable(false);
		author2.setColumns(10);
		author2.setBounds(130, 165, 170, 27);
		panel_5.add(author2);
		
		page2 = new JTextField();
		page2.setEditable(false);
		page2.setColumns(10);
		page2.setBounds(130, 345, 170, 27);
		panel_5.add(page2);
		
		price2 = new JTextField();
		price2.setEditable(false);
		price2.setColumns(10);
		price2.setBounds(130, 285, 170, 27);
		panel_5.add(price2);
		
		JLabel label_11 = new JLabel("First Name:");
		label_11.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_11.setBounds(340, 105, 91, 30);
		panel_5.add(label_11);
		
		JLabel label_12 = new JLabel("Last Name:");
		label_12.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_12.setBounds(340, 165, 145, 30);
		panel_5.add(label_12);
		
		JLabel label_13 = new JLabel("University:");
		label_13.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_13.setBounds(340, 225, 145, 30);
		panel_5.add(label_13);
		
		JLabel label_14 = new JLabel("Year:");
		label_14.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_14.setBounds(340, 285, 145, 30);
		panel_5.add(label_14);
		
		JLabel label_15 = new JLabel("Semester:");
		label_15.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_15.setBounds(340, 345, 145, 30);
		panel_5.add(label_15);
		
		JLabel label_16 = new JLabel("Book Code:");
		label_16.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_16.setBounds(20, 45, 100, 30);
		panel_5.add(label_16);
		
		JLabel label_17 = new JLabel("Title:");
		label_17.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_17.setBounds(20, 105, 145, 30);
		panel_5.add(label_17);
		
		JLabel label_18 = new JLabel("Author:");
		label_18.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_18.setBounds(20, 165, 145, 30);
		panel_5.add(label_18);
		
		JLabel label_19 = new JLabel("Edition:");
		label_19.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_19.setBounds(20, 225, 145, 30);
		panel_5.add(label_19);
		
		JLabel label_20 = new JLabel("Price:");
		label_20.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_20.setBounds(20, 285, 145, 30);
		panel_5.add(label_20);
		
		JLabel label_21 = new JLabel("No. of pages:");
		label_21.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_21.setBounds(20, 345, 145, 30);
		panel_5.add(label_21);
		
		JButton button_6 = new JButton("Search Student ID");
		button_6.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\52258632_770486749989853_6643440857808633856_n.png"));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "select * from get where student_id= ?";
		        try {
					state = (PreparedStatement) myConnection.getConnection().prepareStatement(query);
					state.setString(1, id2.getText());
					rs= state.executeQuery();
					if(rs.next()) {
					code2.setText(rs.getString(1));
					title2.setText(rs.getString(2));
					author2.setText(rs.getString(3));
					edition2.setText(rs.getString(4));
					price2.setText(rs.getString(5));
					page2.setText(rs.getString(6));
					fname2.setText(rs.getString(8));
					lname2.setText(rs.getString(9));
					school2.setText(rs.getString(10));
					year2.setText(rs.getString(11));
					semester2.setText(rs.getString(12));
					date2.setText(rs.getString(13));
					rs.close();
					state.close();
					}
					else {
						JOptionPane.showMessageDialog(null, "The student with this ID hasn't issued any book");
						code2.setText("");
						title2.setText("");
						author2.setText("");
						edition2.setText("");
						price2.setText("");
						page2.setText("");
						id2.setText("");
						fname2.setText("");
						lname2.setText("");
						school2.setText("");
						year2.setText("");
						semester2.setText("");
						date2.setText("");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
					code2.setText("");
					title2.setText("");
					author2.setText("");
					edition2.setText("");
					price2.setText("");
					page2.setText("");
					id2.setText("");
					fname2.setText("");
					lname2.setText("");
					school2.setText("");
					year2.setText("");
					semester2.setText("");
					date2.setText("");
				}finally {
					try {
						rs.close();
						state.close();
					}catch (Exception e1) {
						System.out.println(e1);
					}
				}
			}
		});
		button_6.setBounds(340, 405, 262, 27);
		panel_5.add(button_6);
		
		JLabel lblDateOfReturn = new JLabel("Date of  return:");
		lblDateOfReturn.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblDateOfReturn.setBounds(130, 456, 170, 30);
		panel_5.add(lblDateOfReturn);
		
		JLabel label_24 = new JLabel("");
		label_24.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Return Details", TitledBorder.LEADING, TitledBorder.TOP, new Font("Century Gothic", Font.PLAIN, 25), new Color(0, 0, 0)));
		label_24.setBounds(0, 0, 629, 449);
		panel_5.add(label_24);
		
		JButton btnReturn = new JButton("RETURN");
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				try {
					String query = "delete from get where get.student_id= ?";
					state = (PreparedStatement) myConnection.getConnection().prepareStatement(query);
					state.setString(1, id2.getText());
					state.execute();
				} catch (SQLException e) {
				e.printStackTrace();
				}
			}
		});
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "INSERT INTO `return`(`book_code`, `title`, `author`, `edition`, `price`, `page`, `student_id`, `firstname`, `lastname`, `school`, `year`, `semester`, `issue`, `return`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					state = (PreparedStatement) myConnection.getConnection().prepareStatement(sql);
					state.setString(1, code2.getText());
					state.setString(2, title2.getText());
					state.setString(3, author2.getText());
					state.setString(4, edition2.getText());
					state.setString(5, price2.getText());
					state.setString(6, page2.getText());
					state.setString(7, id2.getText());
					state.setString(8, fname2.getText());
					state.setString(9, lname2.getText());
					state.setString(10, school2.getText());
					state.setString(11, year2.getText());
					state.setString(12, semester2.getText());
					state.setString(13, date2.getText());
					state.setString(14, ((JTextField) dateChooser_1.getDateEditor().getUiComponent()).getText());
					state.execute();
					JOptionPane.showMessageDialog(null, "Thank you for returning the book! You can choose anoother one");
					code2.setText("");
					title2.setText("");
					author2.setText("");
					edition2.setText("");
					price2.setText("");
					page2.setText("");
					id2.setText("");
					fname2.setText("");
					lname2.setText("");
					school2.setText("");
					year2.setText("");
					semester2.setText("");
					date2.setText("");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnReturn.setForeground(Color.WHITE);
		btnReturn.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnReturn.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		btnReturn.setBackground(new Color(102, 51, 0));
		btnReturn.setBounds(130, 497, 170, 32);
		panel_5.add(btnReturn);
		
		JButton button_8 = new JButton("Back");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		button_8.setForeground(Color.WHITE);
		button_8.setFont(new Font("Century Gothic", Font.BOLD, 15));
		button_8.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		button_8.setBackground(new Color(102, 51, 0));
		button_8.setBounds(329, 497, 170, 32);
		panel_5.add(button_8);
		
		edition2 = new JTextField();
		edition2.setEditable(false);
		edition2.setColumns(10);
		edition2.setBounds(130, 225, 170, 27);
		panel_5.add(edition2);
		
		school2 = new JTextField();
		school2.setEditable(false);
		school2.setColumns(10);
		school2.setBounds(432, 225, 170, 27);
		panel_5.add(school2);
		
		year2 = new JTextField();
		year2.setEditable(false);
		year2.setColumns(10);
		year2.setBounds(432, 285, 170, 27);
		panel_5.add(year2);
		
		semester2 = new JTextField();
		semester2.setEditable(false);
		semester2.setColumns(10);
		semester2.setBounds(432, 345, 170, 27);
		panel_5.add(semester2);
		
		dateChooser_1.setBounds(296, 460, 203, 25);
		panel_5.add(dateChooser_1);
		
		JLabel lblDOfIssue = new JLabel("Date of issue:");
		lblDOfIssue.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblDOfIssue.setBounds(20, 405, 145, 30);
		panel_5.add(lblDOfIssue);
		
		date2 = new JTextField();
		date2.setEditable(false);
		date2.setColumns(10);
		date2.setBounds(130, 405, 170, 27);
		panel_5.add(date2);
		
		panel_6 = new JPanel();
		panel_6.setBackground(new Color(204, 153, 102));
		tabbedPane.addTab("New tab", null, panel_6, null);
		panel_6.setLayout(null);
		
		JLabel lblReadLearn = new JLabel("Read & Learn Online Library");
		lblReadLearn.setFont(new Font("Century Gothic", Font.BOLD, 23));
		lblReadLearn.setBounds(282, 68, 306, 30);
		panel_6.add(lblReadLearn);
		
		JLabel lblVersion = new JLabel("Version: 1.03");
		lblVersion.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblVersion.setBounds(367, 107, 106, 22);
		panel_6.add(lblVersion);
		
		JLabel lblCopyright = new JLabel("Copyright @ 2020");
		lblCopyright.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblCopyright.setBounds(354, 140, 215, 22);
		panel_6.add(lblCopyright);
		
		JLabel lblContactFrenkimucagmialcom = new JLabel("<html>frenki.muca@cit.edu.al<br/>klajdi.janku@cit.edu.al<br/>mateo.kurdari@cit.edu.al\r\n<html/>\r\n");
		lblContactFrenkimucagmialcom.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblContactFrenkimucagmialcom.setBounds(403, 278, 195, 85);
		panel_6.add(lblContactFrenkimucagmialcom);
		
		JLabel lblContact = new JLabel("Contact:");
		lblContact.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblContact.setBounds(269, 287, 77, 22);
		panel_6.add(lblContact);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:\r\n");
		lblPhoneNumber.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblPhoneNumber.setBounds(269, 374, 128, 22);
		panel_6.add(lblPhoneNumber);
		
		JLabel label_25 = new JLabel("<html>(+355)68 00 00 001<br>(+4)23 90 532");
		label_25.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		label_25.setBounds(403, 374, 146, 44);
		panel_6.add(label_25);
		
		JLabel label_31 = new JLabel("");
		label_31.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\photo-1580537659466-0a9bfa916a54.jpg"));
		label_31.setBounds(10, 68, 250, 375);
		panel_6.add(label_31);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(null);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		tabbedPane.addTab("New tab", null, scrollPane_1, null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setPreferredSize(new Dimension(2010, 541));
		panel_9.setBackground(new Color(204, 153, 102));
		scrollPane_1.setViewportView(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblnew = new JLabel("New Books Coming Soon");
		panel_9.add(lblnew);
		lblnew.setBounds(new Rectangle(45, 30, 489, 50));
		lblnew.setFont(new Font("Century Gothic", Font.BOLD, 40));
		
		JButton button1 = new JButton("");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				browser.browse(new URI("https://www.amazon.com/Just-As-Am-Cicely-Tyson/dp/0062931067/ref=zg_bsnr_books_2/147-7399962-9606549?_encoding=UTF8&psc=1&refRID=YPK918N8Z9T2JZBFSNW0"));
			} catch (IOException | URISyntaxException e) {
				JOptionPane.showMessageDialog(null, e);
			}
			}
		});
		button1.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\81FeR-7X-WL.jpg"));
		button1.setBounds(45, 100, 270, 330);
		panel_9.add(button1);
		
		JLabel lbl1 = new JLabel("Just as I am by Cicely Tyson");
		lbl1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setBounds(45, 441, 270, 30);
		panel_9.add(lbl1);
		
		JButton button2 = new JButton("");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					browser.browse(new URI("https://www.amazon.com/Think-Again-Power-Knowing-What/dp/1984878107/ref=zg_bsnr_books_3/147-7399962-9606549?_encoding=UTF8&psc=1&refRID=YPK918N8Z9T2JZBFSNW0"));
				} catch (IOException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button2.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\41bChkOa4zL.jpg"));
		button2.setBounds(375, 100, 270, 330);
		panel_9.add(button2);
		
		JButton button3 = new JButton("");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					browser.browse(new URI("https://www.amazon.com/Four-Winds-Novel-Kristin-Hannah/dp/1250178606/ref=zg_bsnr_books_1/147-7399962-9606549?_encoding=UTF8&psc=1&refRID=YPK918N8Z9T2JZBFSNW0"));
				} catch (IOException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button3.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\91NKthYHyZL.jpg"));
		button3.setBounds(705, 100, 270, 330);
		panel_9.add(button3);
		
		JButton button4 = new JButton("");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					browser.browse(new URI("https://www.amazon.com/Send-Me-novel-Lauren-Fox/dp/1101947802/ref=zg_bsnr_books_20/147-7399962-9606549?_encoding=UTF8&psc=1&refRID=YPK918N8Z9T2JZBFSNW0"));
				} catch (IOException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button4.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\915dD-QYGVL.jpg"));
		button4.setBounds(1035, 100, 270, 330);
		panel_9.add(button4);
		
		JButton button5 = new JButton("");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					browser.browse(new URI("https://www.amazon.com/Four-Hundred-Souls-Community-1619-2019/dp/0593134044/ref=zg_bsnr_books_4/147-7399962-9606549?_encoding=UTF8&psc=1&refRID=YPK918N8Z9T2JZBFSNW0"));
				} catch (IOException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button5.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\A1gPZeIf8eL.jpg"));
		button5.setBounds(1365, 100, 270, 330);
		panel_9.add(button5);
				
		JLabel lbl2 = new JLabel("Think again by Adam Grant");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lbl2.setBounds(375, 441, 270, 30);
		panel_9.add(lbl2);
	
		JLabel lbl3 = new JLabel("The Four Winds by Kristin Hannah");
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lbl3.setBounds(700, 441, 275, 30);
		panel_9.add(lbl3);
		
		JLabel lbl4 = new JLabel("Send For Me by Lauren Fox");
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lbl4.setBounds(1035, 441, 270, 30);
		panel_9.add(lbl4);
		
		JLabel lbl5 = new JLabel("Four Houndred Souls by Ibram Kendi");
		lbl5 .setHorizontalAlignment(SwingConstants.CENTER);
		lbl5 .setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lbl5 .setBounds(1360, 441, 280, 30);
		panel_9.add(lbl5);
		
		JButton button6 = new JButton("");
		button6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					browser.browse(new URI("https://www.amazon.com/Sanatorium-Novel-Sarah-Pearse/dp/0593296672/ref=zg_bsnr_books_6/147-7399962-9606549?_encoding=UTF8&psc=1&refRID=YPK918N8Z9T2JZBFSNW0"));
				} catch (IOException | URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button6.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\A15DxzWbR4L.jpg"));
		button6.setBounds(1695, 100, 270, 330);
		panel_9.add(button6);
		
		JLabel lblTheSanatoriumBy = new JLabel("The Sanatorium by Sarah Pearse");
		lblTheSanatoriumBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheSanatoriumBy.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblTheSanatoriumBy.setBounds(1695, 441, 270, 30);
		panel_9.add(lblTheSanatoriumBy);
	}
	public void table1(){
		try {
		String sql = "select * from existingbook";
		state = (PreparedStatement) myConnection.getConnection().prepareStatement(sql);
		rs = state.executeQuery();
		DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
		tableModel.setRowCount(1);
		while(rs.next()) {
			Object object[] = {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)};
            tableModel.addRow(object);  		
		}
	}catch (Exception e) {
	System.out.println(e);
	}
	}
	}
