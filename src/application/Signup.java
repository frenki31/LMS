package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.annotation.processing.Messager;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseMotionAdapter;
import java.net.URL;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.event.KeyAdapter;

public class Signup extends JFrame {

	private JPanel contentPane;
	private JTextField firstname;
	private JButton SignupButton;
	private JPanel LastName;
	private JTextField lastname;
	private JPanel Email;
	private JTextField email;
	private JPanel Username;
	private JTextField username;
	private JPanel Pass;
	private JPasswordField pass;
	private JPanel Reenter;
	private JPasswordField reenter;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_5;
	private JLabel label_6;
	int xx,xy,x;
	private JLabel lblNewLabel_1;
	private JLabel lblLastName;
	private JLabel lblEmail;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel message;
	private JLabel lblNewLabel_3;
	boolean checkUser;
	private JLabel login_label;
	private JButton resetbtn;
	ResultSet result;
	PreparedStatement state;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	public Signup() {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Public\\Pictures\\Sample Pictures\\photo-1511649475669-e288648b2339.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 153, 102));
		contentPane.setForeground(UIManager.getColor("Button.background"));
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				xy=e.getY();
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x= e.getXOnScreen();
				int y =e.getYOnScreen();
				
				Signup.this.setLocation(x - xx, y -xy);
			}
		});
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Name = new JPanel();
		Name.setBackground(new Color(204, 153, 102));
		Name.setBounds(450, 98, 300, 40);
		contentPane.add(Name);
		Name.setLayout(null);
		
		firstname = new JTextField();
		firstname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String string = "^(?=.*[A-Z])(?=.*[a-z]).{3,30}$";
				Pattern pt= Pattern.compile(string);
				Matcher match = pt.matcher(firstname.getText());
				if(!match.matches()) {
					message.setText("Enter a correct first name");
				}
				else {
					message.setText(null);
				}
			}
		});
		firstname.setBackground(new Color(204, 153, 102));
		firstname.setBounds(50, 5, 240, 25);
		firstname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		Name.add(firstname);
		firstname.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		firstname.setColumns(10);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\108003960_735506757199645_4838703568523846670_n.png"));
		label.setBounds(10, 5, 30, 30);
		Name.add(label);
		
		JButton SignupButton = new JButton("Sign up");
		SignupButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}
		});
		SignupButton.setForeground(new Color(255, 255, 255));
		SignupButton.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		SignupButton.setBackground(new Color(102, 51, 0));
		SignupButton.setFont(new Font("Century Gothic", Font.BOLD, 15));
		SignupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(firstname.getText().trim().isEmpty() || lastname.getText().trim().isEmpty() || email.getText().trim().isEmpty()
						|| username.getText().trim().isEmpty() || pass.getText().trim().isEmpty() || reenter.getText().trim().isEmpty()) {
					message.setText("Fill in all the blanks");
				}
				else if (!pass.getText().equals(reenter.getText())) {
					message.setText("Passwords don't match");
				}
				else {
				 try {
					String query = "INSERT INTO `signup`(`firstname`, `lastname`, `email`, `username`, `pass`) VALUES (?,?,?,?,?)";
					state = (PreparedStatement) myConnection.getConnection().prepareStatement(query);
					state.setString(1, firstname.getText());
					state.setString(2, lastname.getText());
					state.setString(3, email.getText());
					state.setString(4, username.getText());
					state.setString(5, pass.getText());
					state.executeUpdate();
					JOptionPane.showMessageDialog(null, "Account created successfully");
					setVisible(false);
					Signin login = new Signin();
					login.setVisible(true);
				 }catch(Exception e1) {
					 System.out.println(e1);
				 }
				}
			}

		});
		

		SignupButton.setBounds(460, 510, 139, 32);
		contentPane.add(SignupButton);
		
		LastName = new JPanel();
		LastName.setBackground(new Color(204, 153, 102));
		LastName.setLayout(null);
		LastName.setBounds(450, 160, 300, 40);
		contentPane.add(LastName);
		
		lastname = new JTextField();
		lastname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String string = "^(?=.*[A-Z])(?=.*[a-z]).{3,30}$";
				Pattern pt= Pattern.compile(string);
				Matcher match = pt.matcher(lastname.getText());
				if(!match.matches()) {
					message.setText("Enter a correct last name");
				}
				else {
					message.setText(null);
				}
			}
		});
		lastname.setBackground(new Color(204, 153, 102));
		lastname.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lastname.setColumns(10);
		lastname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lastname.setBounds(50, 7, 240, 25);
		LastName.add(lastname);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\108003960_735506757199645_4838703568523846670_n.png"));
		label_1.setBounds(10, 5, 30, 30);
		LastName.add(label_1);
		
		Email = new JPanel();
		Email.setBackground(new Color(204, 153, 102));
		Email.setLayout(null);
		Email.setBounds(450, 222, 300, 40);
		contentPane.add(Email);
		
		email = new JTextField();
		email.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String string = "^(?=.*[a-z])(?=.*[0-9]).{5,20}[@](?=.*[a-zA-Z]).{4,10}[.](?=.*[a-zA-Z]).{2,5}$";
				Pattern pt= Pattern.compile(string);
				Matcher match = pt.matcher(email.getText());
				if(!match.matches()) {
					message.setText("Enter a valid email");
				}
				else {
					message.setText(null);
				}
			}
		});
		email.setBackground(new Color(204, 153, 102));
		email.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		email.setColumns(10);
		email.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		email.setBounds(50, 7, 240, 25);
		Email.add(email);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\48397959_223377095229673_8640273678883356672_n.png"));
		label_2.setBounds(10, 5, 30, 30);
		Email.add(label_2);
		
		Username = new JPanel();
		Username.setBackground(new Color(204, 153, 102));
		Username.setLayout(null);
		Username.setBounds(450, 284, 300, 40);
		contentPane.add(Username);
		
		username = new JTextField();
		username.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String string = "^(?=.*[a-z])(?=.*[0-9]).{3,30}$";
				Pattern pt= Pattern.compile(string);
				Matcher match = pt.matcher(username.getText());
				if(!match.matches()) {
					message.setText("Enter a correct username");
				}
				else {
					message.setText(null);
				}
			}
		});
		username.setBackground(new Color(204, 153, 102));
		username.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		username.setColumns(10);
		username.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		username.setBounds(50, 7, 240, 25);
		Username.add(username);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\108003960_735506757199645_4838703568523846670_n.png"));
		label_3.setBounds(10, 5, 30, 30);
		Username.add(label_3);
		
		Pass = new JPanel();
		Pass.setBorder(null);
		Pass.setBackground(new Color(204, 153, 102));
		Pass.setLayout(null);
		Pass.setBounds(450, 346, 300, 40);
		contentPane.add(Pass);
		
		pass = new JPasswordField();
		pass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String string = "^(?=.*[a-zA-Z0-9])(?=.*[@#$%^&-+=]).{8,30}$";
				Pattern pt= Pattern.compile(string);
				Matcher match = pt.matcher(pass.getText());
				if(!match.matches()) {
					message.setText("Password must be more secure");
				}
				else {
					message.setText(null);
				}
			}
		});
		pass.setBackground(new Color(204, 153, 102));
		pass.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		pass.setColumns(10);
		pass.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		pass.setBounds(50, 7, 240, 25);
		Pass.add(pass);
		
		label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\48420605_461743121021463_8816441078312861696_n.png"));
		label_5.setBounds(10, 5, 30, 30);
		Pass.add(label_5);
		
		Reenter = new JPanel();
		Reenter.setBackground(new Color(204, 153, 102));
		Reenter.setLayout(null);
		Reenter.setBounds(450, 408, 300, 40);
		contentPane.add(Reenter);
		
		reenter = new JPasswordField();
		reenter.setBackground(new Color(204, 153, 102));
		
		reenter.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		reenter.setColumns(10);
		reenter.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		reenter.setBounds(50, 7, 240, 25);
		Reenter.add(reenter);
		
		label_6 = new JLabel("");
		label_6.setBackground(UIManager.getColor("Button.background"));
		label_6.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\147048068_1388566898189621_8016397777441539760_n.png"));
		label_6.setBounds(10, 5, 30, 30);
		Reenter.add(label_6);
		
		lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1.setBounds(460, 79, 290, 20);
		contentPane.add(lblNewLabel_1);
		
		lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblLastName.setBounds(460, 142, 290, 20);
		contentPane.add(lblLastName);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblEmail.setBounds(460, 205, 290, 20);
		contentPane.add(lblEmail);
		
		lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblNewLabel_2.setBounds(460, 266, 290, 20);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblNewLabel_4.setBounds(460, 329, 290, 20);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Retype Password");
		lblNewLabel_5.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblNewLabel_5.setBounds(460, 390, 290, 20);
		contentPane.add(lblNewLabel_5);
		
		message = new JLabel("");
		message.setVerticalAlignment(SwingConstants.TOP);
		message.setBorder(null);
		message.setForeground(new Color(204, 0, 0));
		message.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		message.setBounds(460, 472, 300, 27);
		contentPane.add(message);
		
		lblNewLabel_3 = new JLabel("Sign Up");
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblNewLabel_3.setBounds(460, 30, 289, 38);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("<html>Already have <br/>an account?<html/>\r\n");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 23));
		lblNewLabel.setBounds(44, 35, 173, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_6 = new JLabel("<html>If you already have <br/>an account click <br/>the button below...<html/>");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6.setVerticalTextPosition(SwingConstants.TOP);
		lblNewLabel_6.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel_6.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblNewLabel_6.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblNewLabel_6.setBounds(44, 110, 182, 74);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setForeground(new Color(255, 255, 0));
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(new LineBorder(new Color(255, 255, 0), 2, true));
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Signin log= new Signin();
				log.setVisible(true);
			}
		});
		btnNewButton.setBounds(44, 195, 154, 27);
		contentPane.add(btnNewButton);
		
		login_label = new JLabel("");
		login_label.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\photo-1555116505-38ab61800975.jpg"));
		login_label.setBounds(0, 0, 400, 600);
		contentPane.add(login_label);
		
		JLabel x = new JLabel("x");
		x.setVerticalAlignment(SwingConstants.TOP);
		x.setOpaque(true);
		x.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				x.setBackground(new Color(255, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				x.setBackground(new Color(204, 0, 0));
			}
		});
		x.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		x.setForeground(new Color(255, 255, 255));
		x.setBackground(new Color(204, 0, 0));
		x.setHorizontalAlignment(SwingConstants.CENTER);
		x.setFont(new Font("Century Gothic", Font.BOLD, 15));
		x.setBounds(755, 0, 45, 22);
		contentPane.add(x);
		
		resetbtn = new JButton("Reset");
		resetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				firstname.setText(null);
				lastname.setText(null);
				username.setText(null);
				email.setText(null);
				pass.setText(null);
				reenter.setText(null);
				message.setText(null);
			}
		});
		resetbtn.setForeground(Color.WHITE);
		resetbtn.setFont(new Font("Century Gothic", Font.BOLD, 15));
		resetbtn.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		resetbtn.setBackground(new Color(102, 51, 0));
		resetbtn.setBounds(611, 510, 139, 32);
		contentPane.add(resetbtn);
		
		JCheckBox chckbxShowPassword = new JCheckBox("Show password");
		chckbxShowPassword.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		chckbxShowPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(chckbxShowPassword.isSelected()) {
					pass.setEchoChar((char)0);
					reenter.setEchoChar((char)0);
				}
				else {
					pass.setEchoChar('●');
					reenter.setEchoChar('●');
				}
			}
		});
		chckbxShowPassword.setBackground(new Color(204, 153, 102));
		chckbxShowPassword.setBounds(630, 442, 120, 23);
		contentPane.add(chckbxShowPassword);
	}
}

