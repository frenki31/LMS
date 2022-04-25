package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.security.interfaces.RSAKey;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Forgot extends JFrame {

	private JPanel contentPane;
	int xx,xy;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField username;
	private JTextField email;
	private JPasswordField pass;
	PreparedStatement state;
	ResultSet result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forgot frame = new Forgot();
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
	public Forgot() {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Public\\Pictures\\Sample Pictures\\photo-1511649475669-e288648b2339.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 600, 400);
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
				
				Forgot.this.setLocation(x - xx, y -xy);
			}
		});
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 102));
		panel.setBounds(0, 0, 600, 400);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblFirstName.setBounds(126, 118, 99, 26);
		panel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblLastName.setBounds(126, 173, 99, 26);
		panel.add(lblLastName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblUsername.setBounds(126, 65, 99, 26);
		panel.add(lblUsername);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblEmail.setBounds(126, 230, 99, 26);
		panel.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblPassword.setBounds(126, 285, 99, 26);
		panel.add(lblPassword);
		
		firstname = new JTextField();
		firstname.setEditable(false);
		firstname.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		firstname.setColumns(10);
		firstname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		firstname.setBackground(new Color(204, 153, 102));
		firstname.setBounds(235, 120, 240, 25);
		panel.add(firstname);
		
		lastname = new JTextField();
		lastname.setEditable(false);
		lastname.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lastname.setColumns(10);
		lastname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lastname.setBackground(new Color(204, 153, 102));
		lastname.setBounds(235, 175, 240, 25);
		panel.add(lastname);
		
		username = new JTextField();
		username.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		username.setColumns(10);
		username.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		username.setBackground(new Color(204, 153, 102));
		username.setBounds(235, 65, 240, 25);
		panel.add(username);
		
		email = new JTextField();
		email.setEditable(false);
		email.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		email.setColumns(10);
		email.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		email.setBackground(new Color(204, 153, 102));
		email.setBounds(235, 230, 240, 25);
		panel.add(email);
		
		pass = new JPasswordField();
		pass.setEchoChar((char)0);
		pass.setEditable(false);
		pass.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		pass.setColumns(10);
		pass.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		pass.setBackground(new Color(204, 153, 102));
		pass.setBounds(235, 285, 240, 25);
		panel.add(pass);
		
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
		x.setBounds(555, 0, 45, 22);
		panel.add(x);
		
		JButton search = new JButton("Search");
		search.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\94238473_878418885914025_7904436963787145216_n.png"));
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = username.getText();
				String sql = "SELECT * FROM `signup` WHERE `username` = '"+user+"'";
				try {
					state = (PreparedStatement) myConnection.getConnection().prepareStatement(sql);
					result = state.executeQuery();
					if(result.next()) {
						firstname.setText(result.getString(2));
						lastname.setText(result.getString(3));
						email.setText(result.getString(4));
						pass.setText(result.getString(6));
						state.close();
						result.close();
					}
					else {
						JOptionPane.showMessageDialog(null, "Incorrect username");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}finally {
					try {
						state.close();
						result.close();
					}catch (Exception e1) {
						System.out.println(e1);
					}
				}
			}
		});
		search.setForeground(Color.WHITE);
		search.setFont(new Font("Century Gothic", Font.BOLD, 15));
		search.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		search.setBackground(new Color(102, 51, 0));
		search.setBounds(126, 334, 170, 32);
		panel.add(search);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Signin log = new Signin();
				log.setVisible(true);
			}
		});
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Century Gothic", Font.BOLD, 15));
		back.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		back.setBackground(new Color(102, 51, 0));
		back.setBounds(305, 334, 170, 32);
		panel.add(back);

	}
}
