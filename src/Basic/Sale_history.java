package Basic;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Basic.Admin.Change_psw;
import Basic.Admin.DashBoard;
import Basic.Admin.Login;
import Basic.Admin.Purchase;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.KeyEvent;

public class Sale_history {

	private JFrame frame;
	private JTable table;
	private JTextField txt_search;
	private JLabel btn_cancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sale_history window = new Sale_history();
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
	public Sale_history() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void List() {
	
		
		try {
		
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/shop_bill","root","");
			Statement stmt=conn.createStatement();
			
			
			String sel="select pid,item_name,item_type,price,quantity,exp_date,purch_quantity from tbl_history";
			ResultSet rs=stmt.executeQuery(sel);
			
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		} catch (Exception e) {
			
			
			System.out.println("List methos="+" "+e);
		
		}
		
	}
	
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(0, 0, 2000, 1370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(588, 102, 1304, 686);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table.setRowHeight(48);
		table.setForeground(Color.WHITE);
		table.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportView(table);
		
		JLabel btn_delete = new JLabel("");
		btn_delete.setBorder(new LineBorder(Color.WHITE));
		btn_delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				try {
				
					
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/shop_bill","root","");
					
						
						int tables=table.getSelectedRow();
						Object value= (table.getModel().getValueAt(tables, 0));
					
					
						String del="delete from tbl_history where pid='"+value+"'";
						PreparedStatement pst=conn.prepareStatement(del);
						pst.executeUpdate(del);
						JOptionPane.showMessageDialog(null, value+" "+"Deleted");
						List();				//Calling List() methode from the top
						
						
				} catch (Exception e) {
					
					
						JOptionPane.showMessageDialog(null, "Please select a row");
				
				}
				
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				
				btn_delete.setBackground(Color.LIGHT_GRAY);
			
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
			
				
				btn_delete.setBackground(Color.BLACK);
			
			}
		});
		btn_delete.setOpaque(true);
		btn_delete.setBackground(Color.BLACK);
		btn_delete.setHorizontalAlignment(SwingConstants.CENTER);
		btn_delete.setForeground(Color.WHITE);
		btn_delete.setBounds(638, 25, 61, 47);
		frame.getContentPane().add(btn_delete);
		
		Image imgDelete=new ImageIcon(this.getClass().getResource("/deleteIcon.png")).getImage();
		btn_delete.setIcon(new ImageIcon(imgDelete));
		
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
						
						
						List();
					
					
					}else {
					
						
						String sel="select item_name,min from tbl_purchhistory where item_name='"+search+"' ";
						ResultSet rs=stmt.executeQuery(sel);
						
						
						table.setModel(DbUtils.resultSetToTableModel(rs));
					
						
					}
					
				} catch (Exception e) {
					
					
						System.out.println(e);
				
				}
				
			}
			
		});
		txt_search.setBounds(385, 25, 241, 47);
		frame.getContentPane().add(txt_search);
		txt_search.setColumns(10);
		
		btn_cancel = new JLabel("Cancel");
		btn_cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				DashBoard.main(null);
			
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				btn_cancel.setBackground(Color.RED);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				btn_cancel.setBackground(Color.BLACK);
			}
		});
		btn_cancel.setOpaque(true);
		btn_cancel.setBackground(Color.GRAY);
		btn_cancel.setHorizontalAlignment(SwingConstants.CENTER);
		btn_cancel.setForeground(Color.WHITE);
		btn_cancel.setBounds(12, 25, 121, 37);
		frame.getContentPane().add(btn_cancel);
		List();			//Calling List() methode from top
		
	}
}
