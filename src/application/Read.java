package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.naming.spi.DirStateFactory.Result;
import javax.sound.midi.Soundbank;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Read extends JFrame {

	private JPanel contentPane;
	private JTextField student;
	private JTextField book;
	PreparedStatement state;
	ResultSet rs;
	Desktop top;
    int xx,xy;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Read frame = new Read();
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
	public Read() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 153, 102));
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
				
				Read.this.setLocation(x - xx, y -xy);
			}
		});
		
		top = Desktop.getDesktop();
		JLabel lblEnterYourStudent = new JLabel("Enter your student ID:");
		lblEnterYourStudent.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblEnterYourStudent.setBounds(40, 48, 170, 22);
		contentPane.add(lblEnterYourStudent);
		
		JLabel lblBook = new JLabel("Book:");
		lblBook.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblBook.setBounds(40, 106, 47, 22);
		contentPane.add(lblBook);
		
		student = new JTextField();
		student.setFont(new Font("Tahoma", Font.PLAIN, 13));
		student.setBounds(234, 48, 170, 27);
		contentPane.add(student);
		student.setColumns(10);
		
		book = new JTextField();
		book.setEditable(false);
		book.setFont(new Font("Tahoma", Font.PLAIN, 13));
		book.setColumns(10);
		book.setBounds(234, 101, 170, 27);
		contentPane.add(book);
		
		JButton btnRead = new JButton("Read");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql = "Select * from get where student_id = ?";
				try {
					state = (PreparedStatement) myConnection.getConnection().prepareStatement(sql);
					state.setString(1,student.getText());
					rs = state.executeQuery();
					if(rs.next()) {
						book.setText(rs.getString(2));
						if(rs.getString(2).equals("Faust")) {
							try {
								top.browse(new URI("https://www.aub.edu.lb/fas/CVSP/Documents/Fall%202017-2018/Fall%202017-2018/Goethe,%20Faust.pdf"));
							} catch (IOException | URISyntaxException e) {
								e.printStackTrace();
							}
						}
						else if(rs.getString(2).equals("The Stranger")) {
							try {
								top.browse(new URI("https://www.slps.org/site/handlers/filedownload.ashx?moduleinstanceid=27607&dataid=78367&FileName=The%20Stranger%20-%20Albert%20Camus.pdf"));
							} catch (IOException | URISyntaxException e) {
								e.printStackTrace();
							}
						}
						else if (rs.getString(2).equals("The Cathedral of Paris")) {
							try {
								top.browse(new URI("file:///C:/Users/user/Downloads/notre_dame_de_paris.pdf"));
							} catch (IOException | URISyntaxException e) {
								e.printStackTrace();
							}
						}
						else if(rs.getString(2).equals("The metamorphosis")) {
							try {
								top.browse(new URI("https://www.sas.upenn.edu/~cavitch/pdf-library/Kafka_Metamorphosis.pdf"));
							} catch (IOException | URISyntaxException e) {
								e.printStackTrace();
							}
						}
						else if(rs.getString(2).equals("War and Peace")) {
							try {
								top.browse(new URI("file:///C:/Users/user/Downloads/War%20and%20Peace%20(Leo%20Tolstoy).pdf"));
							} catch (IOException | URISyntaxException e) {
								e.printStackTrace();
							}
						}
						setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "Student is not registered");
					}
				}catch (Exception e) {
					System.out.println(e);
				}finally {
					try {
						state.close();
						rs.close();
					} catch (Exception e) {
						
				}
				}
			}
		});
		btnRead.setForeground(Color.WHITE);
	    btnRead.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnRead.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		btnRead.setBackground(new Color(102, 51, 0));
		btnRead.setBounds(40, 220, 159, 32);
		contentPane.add(btnRead);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnBack.setBorder(new LineBorder(new Color(102, 0, 0), 1, true));
		btnBack.setBackground(new Color(102, 51, 0));
		btnBack.setBounds(234, 220, 159, 32);
		contentPane.add(btnBack);
		}
}
