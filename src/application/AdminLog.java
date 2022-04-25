package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLog extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private JLabel message;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLog frame = new AdminLog();
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
	public AdminLog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 153, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(204, 153, 102));
		panel.setBounds(300, 260, 300, 40);
		contentPane.add(panel);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(txtUsername.getText().equals("Username")) {
					txtUsername.setText("");
				}
				else {
					txtUsername.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().equals("")) {
					txtUsername.setText("Username");
				}
				else {
					txtUsername.selectAll();
				}
			}
		});
		txtUsername.setText("Username");
		txtUsername.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		txtUsername.setColumns(10);
		txtUsername.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtUsername.setBackground(new Color(204, 153, 102));
		txtUsername.setBounds(50, 5, 240, 27);
		panel.add(txtUsername);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\108003960_735506757199645_4838703568523846670_n.png"));
		label.setBounds(10, 5, 30, 30);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(204, 153, 102));
		panel_1.setBounds(300, 340, 300, 40);
		contentPane.add(panel_1);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setEchoChar((char)0);
		pwdPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(pwdPassword.getText().equals("Password")) {
				pwdPassword.setEchoChar('●');
				pwdPassword.setText("");
			}
				else {
					pwdPassword.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(pwdPassword.getText().equals("")) {
					pwdPassword.setText("Password");
					pwdPassword.setEchoChar((char)0);
				}
				else {
					pwdPassword.selectAll();
				}
			}
		});
		pwdPassword.setText("Password");
		pwdPassword.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		pwdPassword.setColumns(10);
		pwdPassword.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		pwdPassword.setBackground(new Color(204, 153, 102));
		pwdPassword.setBounds(50, 7, 240, 25);
		panel_1.add(pwdPassword);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\48420605_461743121021463_8816441078312861696_n.png"));
		label_1.setBounds(10, 5, 30, 30);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\53333246_367963507376755_7415617853837017088_n.png"));
		label_2.setBounds(375, 100, 150, 150);
		contentPane.add(label_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "ADMINISTRATOR", TitledBorder.CENTER, TitledBorder.TOP, new Font("Century Gothic", Font.PLAIN, 25), new Color(255, 255, 255)));
		lblNewLabel.setBounds(282, 70, 334, 417);
		contentPane.add(lblNewLabel);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtUsername.getText().equals("Frenki")&& pwdPassword.getText().equals("frenki123") 
						|| txtUsername.getText().equals("Kevin")&& pwdPassword.getText().equals("kevinkostandini") 
						|| txtUsername.getText().equals("Elvis")&& pwdPassword.getText().equals("barjami123")) {
					message.setText("");
					JOptionPane.showMessageDialog(null, "Welcome back " + txtUsername.getText());
					setVisible(false);
					Admin admin = new Admin();
					admin.setVisible(true);
				}
				else if(txtUsername.getText().equals("")|| txtUsername.getText().equals("Username")||pwdPassword.getText().equals("")||pwdPassword.getText().equals("Password")) {
					message.setText("Please put your information");
				}
				else {
					message.setText("Username and password don't match");
				}
			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnLogin.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		btnLogin.setBackground(new Color(102, 51, 0));
		btnLogin.setBounds(300, 440, 139, 32);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pwdPassword.setText("");
				txtUsername.setText("");
			}
		});
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnReset.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		btnReset.setBackground(new Color(102, 51, 0));
		btnReset.setBounds(461, 440, 139, 32);
		contentPane.add(btnReset);
		
		message = new JLabel("");
		message.setForeground(new Color(220, 20, 60));
		message.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		message.setBounds(300, 395, 300, 26);
		contentPane.add(message);
	}
}
