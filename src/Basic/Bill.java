package Basic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;

import Basic.Admin.Purchase;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Bill {

	private JFrame frame;
	private JLabel txt_total;
	private JTextField txt_pay;
	private JTextField txt_balance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill window = new Bill();
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
	public Bill() {
		initialize();
		Total();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void Total() {
		
		try {
			
			  Class.forName("com.mysql.jdbc.Driver");
			   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Shop_bill","root","");
			   Statement stmt=conn.createStatement();
			   
			   String sel="select total from tbl_purchase where purch_status='1'";
			   ResultSet rs=stmt.executeQuery(sel);
			   while (rs.next()) {
				
				   String total=rs.getString("total");
				   txt_total.setText(total);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(800, 200, 402, 534);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GET BILL");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(34, 13, 313, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Total");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(72, 100, 105, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		txt_total = new JLabel("");
		txt_total.setOpaque(true);
		txt_total.setHorizontalAlignment(SwingConstants.CENTER);
		txt_total.setForeground(Color.WHITE);
		txt_total.setBounds(208, 100, 97, 39);
		frame.getContentPane().add(txt_total);
		
		JLabel btn_cancel = new JLabel("Cancel");
		btn_cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Purchase.main(null);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				btn_cancel.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				btn_cancel.setBackground(Color.BLACK);
			}
		});
		btn_cancel.setOpaque(true);
		btn_cancel.setBackground(Color.BLACK);
		btn_cancel.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		btn_cancel.setHorizontalAlignment(SwingConstants.CENTER);
		btn_cancel.setForeground(Color.WHITE);
		btn_cancel.setBounds(193, 386, 112, 39);
		frame.getContentPane().add(btn_cancel);
		
		JLabel btn_bill = new JLabel("GET");
		btn_bill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				btn_bill.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				btn_bill.setBackground(Color.BLACK);
			}
		});
		btn_bill.setOpaque(true);
		btn_bill.setHorizontalAlignment(SwingConstants.CENTER);
		btn_bill.setForeground(Color.WHITE);
		btn_bill.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		btn_bill.setBackground(Color.BLACK);
		btn_bill.setBounds(72, 386, 119, 39);
		frame.getContentPane().add(btn_bill);
		
		txt_pay = new JTextField();
		txt_pay.setHorizontalAlignment(SwingConstants.CENTER);
		txt_pay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				String total=txt_total.getText();
				String pay=txt_pay.getText();
				float total2=Float.valueOf(total);
				float pay2=Float.valueOf(pay);
				float bal;
				int i=0;
				txt_balance.setText(String.valueOf(i));
				
				bal=pay2 - total2;
				txt_balance.setText(String.valueOf(bal));
				 
				}
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		txt_pay.setBounds(72, 243, 112, 39);
		frame.getContentPane().add(txt_pay);
		txt_pay.setColumns(10);
		
		txt_balance = new JTextField();
		txt_balance.setHorizontalAlignment(SwingConstants.CENTER);
		txt_balance.setBounds(208, 243, 97, 39);
		frame.getContentPane().add(txt_balance);
		txt_balance.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Pay");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(72, 206, 68, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Bal");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(208, 206, 68, 16);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
