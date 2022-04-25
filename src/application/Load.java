package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;

import javax.swing.JProgressBar;
import java.awt.Color;

import javax.security.auth.login.AppConfigurationEntry;
import javax.swing.ImageIcon;

public class Load extends JFrame implements Runnable{

	private JPanel contentPane;
	int xx,xy;
	Connection connect;
	int x = 0;
	Thread th;
	private JProgressBar progressBar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Load frame = new Load();
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
	public void Loading() {
		setVisible(false);
		th.start();
	}
	public void run() {
		try {
			for(int i=1; i<=200; i++) {
				x=x+1;
			int m = progressBar.getMaximum();
			int v = progressBar.getValue();
			if(v<m) {
				progressBar.setValue(progressBar.getValue()+1);
			}
			else {
				i=201;
				setVisible(false);
				App app = new App();
				app.setVisible(true);
			}Thread.sleep(40);
			}
		}catch (Exception e) {
		System.out.println(e);
		}
	}
	public Load() {
		th= new Thread((Runnable)this);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 600, 400);
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
				
				Load.this.setLocation(x - xx, y -xy);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 102));
		panel.setBounds(0, 0, 600, 400);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblReadLearn = new JLabel("Read & Learn Library 1.03");
		lblReadLearn.setBounds(140, 23, 331, 32);
		panel.add(lblReadLearn);
		lblReadLearn.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblReadLearn.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label = new JLabel("");
		label.setBounds(108, 23, 400, 300);
		panel.add(label);
		label.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\application\\images\\unnamed.gif"));
		
		JLabel lblPleaseWait = new JLabel("Please Wait...");
		lblPleaseWait.setBounds(268, 344, 87, 17);
		panel.add(lblPleaseWait);
		lblPleaseWait.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblPleaseWait.setHorizontalAlignment(SwingConstants.CENTER);
		
		progressBar = new JProgressBar();
		progressBar.setBackground(new Color(255, 255, 255));
		progressBar.setBounds(140, 317, 338, 25);
		panel.add(progressBar);
		progressBar.setFont(new Font("Century Gothic", Font.BOLD, 12));
		progressBar.setForeground(new Color(0, 0, 0));
		progressBar.setStringPainted(true);
	}
}
