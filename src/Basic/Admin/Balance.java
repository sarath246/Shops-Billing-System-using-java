package Basic.Admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Basic.Logout_screen;
import Basic.Shop_products;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Balance {

	private JFrame frame;
	private JTable table;
	private JTextField txt_search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Balance window = new Balance();
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
	public Balance() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void Bal() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/shop_bill","root","");
			Statement stmt=conn.createStatement();
			
			String sel="select item_name,min from tbl_purchhistory";
			ResultSet rs=stmt.executeQuery(sel);
			System.out.println(sel);
	    	
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(300, 100, 1381, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel btn_close = new JLabel("Close");
		btn_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				DashBoard.main(null);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				btn_close.setBackground(Color.RED);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				btn_close.setBackground(Color.BLACK);
			}
		});
		btn_close.setOpaque(true);
		btn_close.setBackground(Color.GRAY);
		btn_close.setHorizontalAlignment(SwingConstants.CENTER);
		btn_close.setForeground(Color.WHITE);
		btn_close.setBounds(12, 13, 123, 43);
		frame.getContentPane().add(btn_close);
		
		JLabel lblNewLabel_6 = new JLabel("BALANCE");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Gabriola", Font.BOLD, 50));
		
		lblNewLabel_6.setOpaque(true);
		lblNewLabel_6.setBackground(Color.BLACK);
		lblNewLabel_6.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_6.setBounds(0, 0, 541, 803);
		frame.getContentPane().add(lblNewLabel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(653, 98, 581, 641);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setRowHeight(48);
		table.setForeground(Color.WHITE);
		table.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportView(table);
		
		txt_search = new JTextField();
		txt_search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				String search=txt_search.getText();
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/shop_bill","root","");
					Statement stmt=conn.createStatement();
					
					if (search.isEmpty()) {
						Bal();
					}else {
					
					String sel="select item_name,min from tbl_purchhistory where item_name='"+search+"' ";
					ResultSet rs=stmt.executeQuery(sel);
					System.out.println(sel);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					}
				} catch (Exception e) {
					System.out.println(e);
				}
				
			}
		});
		txt_search.setBounds(653, 42, 221, 43);
		frame.getContentPane().add(txt_search);
		txt_search.setColumns(10);
		
		JButton button = new JButton("New button");
		button.setBounds(136, 539, 97, 25);
		frame.getContentPane().add(button);
		Bal();
		
	}
}
