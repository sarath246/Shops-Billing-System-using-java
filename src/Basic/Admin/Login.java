package Basic.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JTextField txt_uname;
	@SuppressWarnings("unused")
	private JRadioButton rdo_admin;
	private JRadioButton rdo_cashier;
	private JTextField txt_psw;
	private JLabel txt_alert1;
	private JLabel txt_alert2;
	private JLabel lblNewLabel_3;
	private JLabel txt_img;
	private JLabel txt_img3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(500, 200, 820, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign in");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Gabriola", Font.PLAIN, 48));
		lblNewLabel.setBounds(66, 278, 200, 59);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(398, 135, 67, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(398, 240, 67, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		txt_uname = new JTextField();
		txt_uname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				txt_alert1.setVisible(false);
			}
		});
		txt_uname.setHorizontalAlignment(SwingConstants.CENTER);
		txt_uname.setBounds(526, 127, 175, 35);
		frame.getContentPane().add(txt_uname);
		txt_uname.setColumns(10);
		
		txt_psw = new JTextField();
		txt_psw.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				txt_alert2.setVisible(false);
			}
		});
		txt_psw.setHorizontalAlignment(SwingConstants.CENTER);
		txt_psw.setBounds(526, 232, 175, 35);
		frame.getContentPane().add(txt_psw);
		txt_psw.setColumns(10);
		
		JLabel btn_cancel = new JLabel("Cancel");
		btn_cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				System.exit(0);
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				btn_cancel.setBackground(Color.LIGHT_GRAY);
				btn_cancel.setBorder(new LineBorder(Color.BLACK));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				
				btn_cancel.setBackground(Color.BLACK);
				btn_cancel.setBorder(new LineBorder(Color.WHITE));
			}
		});
		btn_cancel.setBorder(new LineBorder(Color.WHITE));
		btn_cancel.setOpaque(true);
		btn_cancel.setBackground(Color.BLACK);
		btn_cancel.setForeground(Color.WHITE);
		btn_cancel.setHorizontalAlignment(SwingConstants.CENTER);
		btn_cancel.setBounds(431, 381, 108, 33);
		frame.getContentPane().add(btn_cancel);
		
		JLabel btn_login = new JLabel("Login");
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String uname=txt_uname.getText();
				String psw=txt_psw.getText();
				
	
				try {
					
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/shop_bill","root","");
					Statement stmt=conn.createStatement();
				
					String sel="";
					
					sel="select * from tbl_admin where admin_uname='"+uname+"' and admin_psw='"+psw+"'";
					ResultSet rs=stmt.executeQuery(sel);
					
					if (uname.isEmpty() && psw.isEmpty()) {
						
						txt_alert1.setVisible(true);
						txt_alert2.setVisible(true);
					
					}else if(rs.next()) {
						
						 
						  String username=rs.getString("admin_uname");
						  String password=rs.getString("admin_psw");
								
				   		  System.out.println(username);
					      System.out.println(password);
									
						  DashBoard.main(null);
									
						}
					else {
							JOptionPane.showMessageDialog(null, "Login failed");
						}
					
				
					
				} 
				catch (Exception e) {
					System.out.println(e);
				}
				
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				btn_login.setBackground(Color.LIGHT_GRAY);
				btn_login.setBorder(new LineBorder(Color.BLACK));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				
				btn_login.setBackground(Color.BLACK);
				btn_login.setBorder(new LineBorder(Color.WHITE));
			}
		});
		btn_login.setBorder(new LineBorder(Color.WHITE));
		btn_login.setOpaque(true);
		btn_login.setBackground(Color.BLACK);
		btn_login.setForeground(Color.WHITE);
		btn_login.setHorizontalAlignment(SwingConstants.CENTER);
		btn_login.setBounds(551, 381, 108, 33);
		frame.getContentPane().add(btn_login);
		
	    txt_alert1 = new JLabel("Please enter");
		txt_alert1.setForeground(Color.RED);
		txt_alert1.setBounds(526, 162, 140, 16);
		frame.getContentPane().add(txt_alert1);
		txt_alert1.setVisible(false);
		
	    txt_alert2 = new JLabel("Please enter");
		txt_alert2.setForeground(Color.RED);
		txt_alert2.setBounds(526, 267, 140, 16);
		frame.getContentPane().add(txt_alert2);
		
		txt_img = new JLabel("");
		txt_img.setBounds(102, 127, 164, 132);
		frame.getContentPane().add(txt_img);
		Image img=new ImageIcon(this.getClass().getResource("/avatar3.png")).getImage();
		txt_img.setIcon(new ImageIcon(img));
		
		txt_alert2.setVisible(false);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_3.setBounds(12, 13, 328, 455);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel txt_img2 = new JLabel("");
		txt_img2.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_img2.setBounds(464, 127, 56, 35);
		frame.getContentPane().add(txt_img2);
		Image img2=new ImageIcon(this.getClass().getResource("/user1.png")).getImage();
		txt_img2.setIcon(new ImageIcon(img2));
		
		txt_img3 = new JLabel("");
		txt_img3.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_img3.setBounds(464, 232, 56, 35);
		frame.getContentPane().add(txt_img3);
		Image img3=new ImageIcon(this.getClass().getResource("/password3.png")).getImage();
		txt_img3.setIcon(new ImageIcon(img3));
	}
	}
