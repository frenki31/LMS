package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.ComponentOrientation;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.border.SoftBevelBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class Signin extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField pass;
	int xx,xy;
	private JLabel message;
	ResultSet result;
	PreparedStatement state;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signin frame = new Signin();
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
	public Signin() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
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
				
				Signin.this.setLocation(x - xx, y -xy);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 102));
		panel.setBounds(0, 0, 800, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDontHaveAn = new JLabel("<html>Don't have an <br/>account yet?<html/>\r\n");
		lblDontHaveAn.setForeground(Color.WHITE);
		lblDontHaveAn.setFont(new Font("Century Gothic", Font.BOLD, 23));
		lblDontHaveAn.setBounds(427, 35, 196, 60);
		panel.add(lblDontHaveAn);
		
		JLabel lblifYouDont = new JLabel("<html>If you don't have an <br/>account click the<br/> button below...<html/>");
		lblifYouDont.setForeground(Color.WHITE);
		lblifYouDont.setVerticalTextPosition(SwingConstants.TOP);
		lblifYouDont.setVerticalAlignment(SwingConstants.TOP);
		lblifYouDont.setHorizontalTextPosition(SwingConstants.LEFT);
		lblifYouDont.setHorizontalAlignment(SwingConstants.LEFT);
		lblifYouDont.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblifYouDont.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblifYouDont.setAlignmentY(0.0f);
		lblifYouDont.setBounds(427, 106, 196, 87);
		panel.add(lblifYouDont);
		
		JButton button = new JButton("SIGN UP");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Signup signup = new Signup();
				signup.setVisible(true);
			}
		});
		button.setOpaque(false);
		button.setForeground(Color.YELLOW);
		button.setFont(new Font("Century Gothic", Font.BOLD, 15));
		button.setContentAreaFilled(false);
		button.setBorder(new LineBorder(new Color(255, 255, 0), 2, true));
		button.setBounds(427, 193, 154, 27);
		panel.add(button);
		
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
		panel.add(x);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\photo-1555116505-38ab61800975.jpg"));
		lblNewLabel.setBounds(400, 0, 400, 600);
		panel.add(lblNewLabel);
		
		JLabel lblSignIn = new JLabel("Sign In");
		lblSignIn.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblSignIn.setBounds(59, 83, 290, 38);
		panel.add(lblSignIn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(204, 153, 102));
		panel_1.setBounds(49, 153, 300, 40);
		panel.add(panel_1);
		
		username = new JTextField();
		username.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		username.setColumns(10);
		username.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		username.setBackground(new Color(204, 153, 102));
		username.setBounds(50, 7, 240, 25);
		panel_1.add(username);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\108003960_735506757199645_4838703568523846670_n.png"));
		label_1.setBounds(10, 5, 30, 30);
		panel_1.add(label_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(204, 153, 102));
		panel_2.setBounds(49, 226, 300, 40);
		panel.add(panel_2);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		pass.setColumns(10);
		pass.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		pass.setBackground(new Color(204, 153, 102));
		pass.setBounds(50, 7, 240, 25);
		panel_2.add(pass);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\48420605_461743121021463_8816441078312861696_n.png"));
		label_2.setBounds(10, 5, 30, 30);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("Username");
		label_3.setFont(new Font("Century Gothic", Font.BOLD, 13));
		label_3.setBounds(59, 132, 290, 20);
		panel.add(label_3);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblPassword.setBounds(59, 204, 290, 20);
		panel.add(lblPassword);
		
		JButton loginbtn = new JButton("Login");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (username.getText().trim().isEmpty() && pass.getText().trim().isEmpty()) {
					message.setText("Invalid username and password");
				}
				else if (username.getText().trim().isEmpty()) {
					message.setText("Incorrect username");
				}
				else if(pass.getText().trim().isEmpty()) {
					message.setText("Enter your password");
				}
				else {
				String query = "SELECT * FROM `signup` WHERE `username` = ? and `pass` = ?";
				try {
			    state= (PreparedStatement) myConnection.getConnection().prepareStatement(query);
			    state.setString(1, username.getText());
			    state.setString(2, pass.getText());
			    result = state.executeQuery();
			    if (result.next()) {
			    	result.close();
			    	state.close();
			        setVisible(false);
			    	Load load = new Load();
			    	load.Loading();
			    	load.setVisible(true);
			    }
			    else {
			    	message.setText("Incorrect Username or Password");
			    }
				}catch(Exception e1) {
					 JOptionPane.showMessageDialog(null, e1);
				}finally {
				try {
					result.close();
					state.close();
				} catch (Exception e) {
				}
				}
				}
			}
		});
		loginbtn.setForeground(Color.WHITE);
		loginbtn.setFont(new Font("Century Gothic", Font.BOLD, 15));
		loginbtn.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		loginbtn.setBackground(new Color(102, 51, 0));
		loginbtn.setBounds(59, 326, 142, 32);
		panel.add(loginbtn);
		
		message = new JLabel("");
		message.setForeground(new Color(204, 0, 0));
		message.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		message.setBorder(null);
		message.setBounds(59, 288, 290, 27);
		panel.add(message);
		
		JButton resetbtn = new JButton("Reset");
		resetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				username.setText(null);
				pass.setText(null);
			}
		});
		resetbtn.setForeground(Color.WHITE);
		resetbtn.setFont(new Font("Century Gothic", Font.BOLD, 15));
		resetbtn.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		resetbtn.setBackground(new Color(102, 51, 0));
		resetbtn.setBounds(207, 326, 142, 32);
		panel.add(resetbtn);
		
		JLabel lblForgotYourPassword = new JLabel("Forgot your password?");
		lblForgotYourPassword.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblForgotYourPassword.setBounds(59, 369, 171, 27);
		panel.add(lblForgotYourPassword);
		
		JLabel lblClickHere = new JLabel("<html><u>Click here...</u></html>");
		lblClickHere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				Forgot forgot = new Forgot();
				forgot.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblClickHere.setForeground(new Color(25,25,112));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblClickHere.setForeground(new Color(0,0,0));
			}
		});
		lblClickHere.setForeground(new Color(0, 0, 0));
		lblClickHere.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblClickHere.setBounds(220, 369, 120, 27);
		panel.add(lblClickHere);
		
		JCheckBox chckbxShowPassword = new JCheckBox("Show password");
		chckbxShowPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(chckbxShowPassword.isSelected()) {
					pass.setEchoChar((char)0);
				}
				else {
					pass.setEchoChar('●');
				}
			}
		});
		chckbxShowPassword.setBackground(new Color(204, 153, 102));
		chckbxShowPassword.setBounds(229, 263, 120, 23);
		panel.add(chckbxShowPassword);
	}
	}

