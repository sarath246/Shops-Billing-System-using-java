package Basic.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ToolTipUI;

import Basic.Logout_screen;
import Basic.Shop_products;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

public class Change_psw {

	private JFrame frame;
	private JTextField txt_cpsw;
	private JTextField txt_npsw;
	private JTextField txt_conpsw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Change_psw window = new Change_psw();
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
	public Change_psw() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(800, 200, 408, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel txt_alert1 = new JLabel("");
		txt_alert1.setToolTipText("Field required");
		txt_alert1.setForeground(Color.RED);
		txt_alert1.setBounds(312, 122, 29, 32);
		frame.getContentPane().add(txt_alert1);
		Image imges=new ImageIcon(this.getClass().getResource("/error.png")).getImage();
		txt_alert1.setIcon(new ImageIcon(imges));
		txt_alert1.setVisible(false);
		
		JLabel txt_alert2 = new JLabel("");
		txt_alert2.setToolTipText("Field required");
		txt_alert2.setForeground(Color.RED);
		txt_alert2.setBounds(312, 225, 36, 32);
		frame.getContentPane().add(txt_alert2);
		Image img=new ImageIcon(this.getClass().getResource("/error.png")).getImage();
		txt_alert2.setIcon(new ImageIcon(img));
		txt_alert2.setVisible(false);
		
		JLabel txt_alert3 = new JLabel("");
		txt_alert3.setToolTipText("Field required");
		txt_alert3.setHorizontalAlignment(SwingConstants.LEFT);
		txt_alert3.setForeground(Color.RED);
		txt_alert3.setBounds(312, 328, 36, 32);
		frame.getContentPane().add(txt_alert3);
		Image imge=new ImageIcon(this.getClass().getResource("/error.png")).getImage();
		txt_alert3.setIcon(new ImageIcon(imge));
		txt_alert3.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("CHANGE PASSWORD");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(31, 13, 305, 32);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Gabriola", Font.PLAIN, 38));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Current password");
		lblNewLabel_1.setBounds(86, 84, 125, 16);
		lblNewLabel_1.setForeground(Color.WHITE);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New password\r\n");
		lblNewLabel_2.setBounds(86, 187, 135, 16);
		lblNewLabel_2.setForeground(Color.WHITE);
		frame.getContentPane().add(lblNewLabel_2);
		
		txt_cpsw = new JTextField();
		txt_cpsw.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				txt_alert1.setVisible(false);
				
			}
		});
		txt_cpsw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			}
		});
		txt_cpsw.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_cpsw.setForeground(Color.WHITE);
		txt_cpsw.setBackground(Color.BLACK);
		txt_cpsw.setBounds(86, 113, 225, 41);
		txt_cpsw.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(txt_cpsw);
		txt_cpsw.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm password");
		lblNewLabel_3.setBounds(86, 290, 143, 16);
		lblNewLabel_3.setForeground(Color.WHITE);
		frame.getContentPane().add(lblNewLabel_3);
		
		txt_npsw = new JTextField();
		txt_npsw.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				txt_alert2.setVisible(false);
				
			}
		});
		txt_npsw.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_npsw.setForeground(Color.WHITE);
		txt_npsw.setBackground(Color.BLACK);
		txt_npsw.setBounds(86, 216, 225, 41);
		txt_npsw.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(txt_npsw);
		txt_npsw.setColumns(10);
		
		txt_conpsw = new JTextField();
		txt_conpsw.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				txt_alert3.setVisible(false);
				
			}
		});
		
		JLabel btn_reset = new JLabel("");
		btn_reset.setToolTipText("Reset");
		btn_reset.setBounds(323, 0, 58, 59);
		btn_reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				txt_cpsw.setText(null);
				txt_npsw.setText(null);
				txt_conpsw.setText(null);
				
			}
			
		});
		btn_reset.setBorder(new LineBorder(new Color(255, 255, 255), 0, true));
		btn_reset.setBackground(Color.BLACK);
		btn_reset.setForeground(Color.WHITE);
		btn_reset.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(btn_reset);
		txt_conpsw.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_conpsw.setForeground(Color.WHITE);
		txt_conpsw.setBackground(Color.BLACK);
		txt_conpsw.setBounds(86, 319, 225, 41);
		txt_conpsw.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(txt_conpsw);
		txt_conpsw.setColumns(10);
		Image img3=new ImageIcon(this.getClass().getResource("/reseticon.png")).getImage();
		btn_reset.setIcon(new ImageIcon(img3));
		
		JLabel btn_change = new JLabel("Change");
		btn_change.setBounds(212, 416, 99, 41);
		btn_change.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String current=txt_cpsw.getText();
				String newpsw=txt_npsw.getText();
				String confirm=txt_conpsw.getText();
				
				try {
					
					     Class.forName("com.mysql.jdbc.Driver");
					     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/shop_bill","root","");
					     Statement stmt=conn.createStatement();
					     
					     String s="",sel="",psw="";
					     
					     sel="select * from tbl_admin";
					     ResultSet rs=stmt.executeQuery(sel);
					     if (rs.next()) {
						
					    	 psw=rs.getString("admin_psw");
						     System.out.println(psw);
					    	 
						}
					     
					     
					     if (current.isEmpty()) {
							
					    	 txt_alert1.setVisible(true);
					    	 
						}else if (newpsw.isEmpty()) {
							
							txt_alert2.setVisible(true);
							
						}else if (confirm.isEmpty()) {
							
							txt_alert3.setVisible(true);
							
						}else if(current.equals(psw)) {
					    	 
					     
					     if (newpsw.equals(confirm)) {
					    	 
					    	 
					    	 String upquery="update tbl_admin set admin_psw='"+confirm+"'";
						     boolean b=stmt.execute(upquery);
						     
						     if(b==true)
						     {
						    	 s="success";
						     }else {
						    	 s="failed";
						     }
						       System.out.println(s);
						       System.out.println(upquery);
						       
						       JOptionPane.showMessageDialog(null, "Password has been changed");
						       
						}else {
	
							JOptionPane.showMessageDialog(null, "password missmatch "+(newpsw+" and "+confirm));
	
						}
					     }else {
					    	 
					    	 JOptionPane.showMessageDialog(null, "Current password is not currect");
					     
					     }
					     
					    
					
				} catch (Exception e2) {
						System.out.println(e2);
				}
				
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				btn_change.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				btn_change.setBackground(Color.BLACK);
			}
		});
		btn_change.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		btn_change.setOpaque(true);
		btn_change.setBackground(Color.BLACK);
		btn_change.setForeground(Color.WHITE);
		btn_change.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(btn_change);
		
		JLabel btn_calcel = new JLabel("Cancel");
		btn_calcel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DashBoard.main(null);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				btn_calcel.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				btn_calcel.setBackground(Color.BLACK);
			}
		});
		btn_calcel.setOpaque(true);
		btn_calcel.setBackground(Color.BLACK);
		btn_calcel.setForeground(Color.WHITE);
		btn_calcel.setHorizontalAlignment(SwingConstants.CENTER);
		btn_calcel.setBounds(86, 416, 99, 41);
		frame.getContentPane().add(btn_calcel);
		
	}
}
