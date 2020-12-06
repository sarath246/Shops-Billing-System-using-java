package Basic.Admin;

import java.awt.EventQueue;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;

import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import Basic.Bill;
import Basic.Shop_products;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Purchase {

	private JFrame frame;
	private JTable table_1;
	private JComboBox cmp_items;
	private JSpinner spinner;
	private JLabel btn_clear;
	private JLabel txt_msg;
	private JLabel txt_quantity;
	private JTextField txt_price;
	private JTextField txt_total3;
	private JLabel btn_bill;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Purchase window = new Purchase();
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
	public Purchase() {
		initialize();
	}
	
	
	private void ItemList() {
	
		
		String item="";
		
		
		try {
			
			
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Shop_bill","root","");
			
			
			   String sel="select item_name from tbl_item ";
			   PreparedStatement pst=conn.prepareStatement(sel);
			   ResultSet rs=pst.executeQuery();
		    
			   
		    while(rs.next()) {
		    	
		    	
		    	item=rs.getString("item_name");
		    	cmp_items.addItem(item);
		    	
		    	
		    }
			
		    
		} catch (Exception e) {
			
			
			System.out.println("This is ItemList=="+e.getMessage());
		
			
		}
		
	}
	
	
	private void Table2() {
		
		
		String price="";
		
		
		try {
		
			
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Shop_bill","root","");
			
			   
			   String selQry="select item_name,purch_quantity,total from tbl_purchase where purch_status='0'";
			   PreparedStatement pst=conn.prepareStatement(selQry);
			   ResultSet rk=pst.executeQuery();
			
			   
			   table_1.setModel(DbUtils.resultSetToTableModel(rk));
			   
			   
			   String selQry2="select price from tbl_purchase where purch_status='0'";
			   ResultSet rkk=pst.executeQuery(selQry2);
			
			   
			while(rkk.next()) {
				
				
				price=rkk.getString("price");
				
				
			}			
			
			
		} catch (Exception e) {
			
			
			System.out.println(e);
		
		
		}
	}
	
	
	private void Table3() {
	
		
		try {
		
			
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Shop_bill","root","");
			
			   
		       String sel="select item_name,purch_quantity,price from tbl_purchhistory where purch_status='0'";
			   PreparedStatement pst=conn.prepareStatement(sel);
			   ResultSet rk=pst.executeQuery();
			
			   
		} catch (Exception e) {
			
			
			   System.out.println("Table3(Methode)err=="+" "+e);
			
			
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(300, 100, 1381, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	    cmp_items = new JComboBox();
	    cmp_items.setModel(new DefaultComboBoxModel(new String[] {"(default)"}));
	    cmp_items.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    cmp_items.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		
	    		
	    		String cmp=cmp_items.getSelectedItem().toString();
	    		String item="",price="";
	    		
	    		
	    		try {
	    		
	    			
	    			   Class.forName("com.mysql.jdbc.Driver");
					   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Shop_bill","root","");
					 
					   
					   String sel="select * from tbl_item where item_name='"+cmp+"'";
					   PreparedStatement pst=conn.prepareStatement(sel);
					   ResultSet rs=pst.executeQuery();
					 
					   
					   while(rs.next()) {
						
						   
					    	item=rs.getString("quantity");
					    	txt_quantity.setText(item);
					    	price=rs.getString("price");
					    	txt_price.setText(price);
					    
					   
					   }
					
					   
				} catch (Exception e) {
					
					
					System.out.println("ComboBox(cmp_items)"+" "+e);
					
					
				}
	    		
	    	}
	    });
	    cmp_items.setToolTipText("Select an item");
		cmp_items.setBounds(573, 235, 258, 46);
		frame.getContentPane().add(cmp_items);

		
	    spinner = new JSpinner();
	    spinner.addChangeListener(new ChangeListener() {
	    	public void stateChanged(ChangeEvent arg0) {
	    		
	    		
	    			float total;
	    			float cmp2=Float.parseFloat(spinner.getValue().toString());
	    			float price2=Float.parseFloat(txt_price.getText());
	    			int i=0;
	    		
	    		
	    		if (cmp2==0) {
				
	    			
	    			txt_total3.setText(String.valueOf(i));
				
	    		
	    		}else {
	    		
	    			
	    			total=cmp2 * price2;
	    			String tol=String.valueOf(total);
	    			txt_total3.setText(tol);
				
	    		
	    		}
	    	}
	    });
	    spinner.addKeyListener(new KeyAdapter() {
	    	
	    });
	    spinner.setToolTipText("Select no of items");
		spinner.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spinner.setBounds(861, 235, 79, 46);
		frame.getContentPane().add(spinner);
		ItemList();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.BLACK);
		scrollPane.setBounds(1025, 213, 326, 509);
		frame.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		table_1.setRowHeight(58);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
		});
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table_1.setForeground(Color.WHITE);
		table_1.setBackground(Color.BLACK);
		scrollPane.setViewportView(table_1);
		Table2();		//by calling Table2 methode for display table data
		
		
		JLabel btn_add2 = new JLabel("ADD");
		btn_add2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
		
				
				btn_add2.setBackground(Color.LIGHT_GRAY);
				btn_add2.setBorder(new LineBorder(Color.BLACK,2));
				btn_add2.setForeground(Color.BLACK);
			
			
			}
			@Override
			public void mouseExited(MouseEvent e) {
			
				
				btn_add2.setBackground(Color.BLACK);
				btn_add2.setBorder(new LineBorder(Color.WHITE));
				btn_add2.setForeground(Color.WHITE);
			
			
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			
				
				String val=cmp_items.getSelectedItem().toString();
				String type="",price="",exp="",quantity="";
				int quant;
				String total=txt_total3.getText();
				quant=(int) spinner.getValue();
				
				
				try {
				
					
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Shop_bill","root","");
						Statement stmt=conn.createStatement();
					   
						
					    String sel="select * from tbl_item where item_name='"+val+"'";
						PreparedStatement pst=conn.prepareStatement(sel);
					    ResultSet rs=pst.executeQuery();
					    
					    
					    while (rs.next()) {
						
					    	
							type=rs.getString("type_name");
							price=rs.getString("price");
							quantity=rs.getString("quantity");
							exp=rs.getString("exp_date");
						
					    }
					    
					    
					   String insert="insert into tbl_purchase(item_name,item_type,price,quantity,exp_date,purch_quantity,total)"
					   		
							   		+ "values('"+val+"','"+type+"','"+price+"','"+quantity+"','"+exp+"','"+quant+"','"+total+"')";
					   
					   
					   stmt.executeUpdate(insert);
					   
					   
					   String insert2="insert into tbl_purchhistory(item_name,item_type,price,quantity,exp_date,purch_quantity)"
					   				+ "values('"+val+"','"+type+"','"+price+"','"+quantity+"','"+exp+"','"+quant+"')";
					   
					   
					   stmt.executeUpdate(insert2);
					   
					   
					   String insert3="insert into tbl_history(item_name,item_type,price,quantity,exp_date,purch_quantity)"
					   			
							   		+ "values('"+val+"','"+type+"','"+price+"','"+quantity+"','"+exp+"','"+quant+"')";
					   
					   
					   stmt.executeUpdate(insert3);
					   
					   
					   Table2();
					   txt_msg.setText("Success");
						
					   
				} catch (Exception exc) {
					
					
					System.out.println("This is insert query=="+exc);
				
				
				}
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
				
				
				btn_add2.setBackground(Color.BLACK);
			
			
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			
				
				btn_add2.setBackground(Color.LIGHT_GRAY);
			
			
			}
		});
		btn_add2.setBorder(new LineBorder(Color.WHITE));
		btn_add2.setOpaque(true);
		btn_add2.setHorizontalAlignment(SwingConstants.CENTER);
		btn_add2.setBackground(Color.BLACK);
		btn_add2.setForeground(Color.WHITE);
		btn_add2.setBounds(656, 628, 113, 55);
		frame.getContentPane().add(btn_add2);
		
		JLabel btn_submit = new JLabel("");
		btn_submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				
				String sel="",item="",upQry;
				
				
				try {
				
					
					   	Class.forName("com.mysql.jdbc.Driver");
					   	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Shop_bill","root","");
					   	Statement stmt=conn.createStatement();
					 
					   
					   	String del="delete from tbl_purchase where purch_status='1'";
					   	PreparedStatement pst=conn.prepareStatement(del);
					   	pst.executeUpdate(del);
					   
					   
					    sel="select * from tbl_purchase where purch_status='0'";
						PreparedStatement pssst=conn.prepareStatement(sel);
					    ResultSet rsss=pssst.executeQuery();
					    
					    
					    while (rsss.next()) {
					    
					    	
							item=rsss.getString("item_name");
						
					    }
					    
					    
					    for (int i = 0; i <=item.length() ;i++) {
						
					    	
					    	Object m=table_1.getValueAt(i, 0);
					    	String mn=String.valueOf(m);
							
					    	
					   upQry="update tbl_purchase set purch_status='1' where  item_name='"+mn+"'";
					   stmt.executeUpdate(upQry);
					   
					   
					    }
					   
					    
				} catch (Exception e1) {
					
					
					System.out.println("This is update query=="+e1);
				
					
				}
				
				
				 finally {
				
					 
					 	String it="",it2="",upQry2="",upQry3="";
					 	int min=0;
					
					 
					 try {
						 
						   	Class.forName("com.mysql.jdbc.Driver");
						   	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Shop_bill","root","");
						   	Statement stmt=conn.createStatement();
						   
						   
						    for (int i = 0; i < table_1.getColumnCount(); i++) {
						    	
							    
							    	for (int j = 0; j < table_1.getRowCount(); j++) {
							
							    		
							    		Object obj2=table_1.getValueAt(i,j);
								    	
								    	
								    	sel="select quantity,purch_quantity from tbl_purchhistory where item_name='"+obj2+"'";
										PreparedStatement pst=conn.prepareStatement(sel);
									    ResultSet rss=pst.executeQuery();
									    
									    
									    while(rss.next()) {
									    
									    	
									    	it=rss.getString("quantity");
									    	System.out.println("\n");
									    	it2=rss.getString("purch_quantity");
									    	
									    	
									    	int itInt=Integer.parseInt(it);
									    	int it2Int=Integer.parseInt(it2);
									    	
									    	
									    	min=itInt-it2Int;			//AvailableQuantity - PurchaseQuantity in the Database
									    	
									    	
									    	upQry2="update tbl_purchhistory set min='"+min+"' where  item_name='"+obj2+"'";
											stmt.executeUpdate(upQry2);
											
											
											upQry3="update tbl_item set quantity='"+min+"' where  item_name='"+obj2+"'";
											stmt.executeUpdate(upQry3);
									    	
											
										    txt_price.setText(null);
										    txt_total3.setText(null);
										    txt_quantity.setText(null);
										    Table2();		//Calling Table2() methode from the top
									    
									    
									    }break;
									
							    	}
				
							}
						
						    
					} catch (Exception e2) {
						
						
						System.out.println("btn_Submit-finally block"+" "+e);
						
						
					}
					 
						
					}
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				btn_submit.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				
				btn_submit.setBackground(Color.DARK_GRAY);
			}
		});
		btn_submit.setBorder(new LineBorder(new Color(255, 255, 255)));
		btn_submit.setOpaque(true);
		btn_submit.setBackground(Color.DARK_GRAY);
		btn_submit.setForeground(Color.WHITE);
		btn_submit.setHorizontalAlignment(SwingConstants.CENTER);
		btn_submit.setBounds(1268, 144, 70, 55);
		frame.getContentPane().add(btn_submit);
		
		Image imgSubmit=new ImageIcon(this.getClass().getResource("/tickGreen.png")).getImage();
		btn_submit.setIcon(new ImageIcon(imgSubmit));
		
		JLabel btn_delete = new JLabel("");
		btn_delete.setToolTipText("Delete");
		btn_delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				
				try {
				
					
					   Class.forName("com.mysql.jdbc.Driver");
					   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Shop_bill","root","");
					
					   
					   int row=table_1.getSelectedRow();
					
					   
					   Object ji= table_1.getModel().getValueAt(row, 0);
						
						   
					   String del="delete from tbl_purchase where item_name='"+ji+"'";
					   PreparedStatement pst=conn.prepareStatement(del);
					   pst.executeUpdate(del);
					
					   
					   JOptionPane.showMessageDialog(null, "Delete success");
					   Table2();		//Calling Table2() methode from the top
					   
					   
				} catch (Exception ex) {
					
					
					System.out.println("btn_delete-err="+" "+ex);
					JOptionPane.showMessageDialog(null, "Please select a row");
				
				
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				btn_delete.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				
				btn_delete.setBackground(Color.DARK_GRAY);
			}
		});
		btn_delete.setBorder(new LineBorder(new Color(255, 255, 255)));
		btn_delete.setOpaque(true);
		btn_delete.setBackground(Color.DARK_GRAY);
		btn_delete.setHorizontalAlignment(SwingConstants.CENTER);
		btn_delete.setForeground(Color.WHITE);
		btn_delete.setBounds(1091, 163, 40, 37);

		
		Image imgDelete=new ImageIcon(this.getClass().getResource("/deleteIcon.png")).getImage();
		btn_delete.setIcon(new ImageIcon(imgDelete));
		
		
		frame.getContentPane().add(btn_delete);
		
		btn_clear = new JLabel("");
		btn_clear.setToolTipText("Clear table");
		btn_clear.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				btn_clear.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				
				btn_clear.setBackground(Color.DARK_GRAY);
			}
		});
		btn_clear.setBorder(new LineBorder(new Color(255, 255, 255)));
		btn_clear.setOpaque(true);
		btn_clear.setBackground(Color.DARK_GRAY);
		btn_clear.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_clear.setForeground(Color.WHITE);
		btn_clear.setHorizontalAlignment(SwingConstants.CENTER);
		btn_clear.setBounds(1025, 163, 40, 37);
		frame.getContentPane().add(btn_clear);
		
		Image imgClear=new ImageIcon(this.getClass().getResource("/clearAll.png")).getImage();
		btn_clear.setIcon(new ImageIcon(imgClear));
		
		txt_msg = new JLabel("");
		txt_msg.setForeground(Color.GREEN);
		txt_msg.setBounds(451, 33, 180, 28);
		frame.getContentPane().add(txt_msg);
		
		JLabel txt_sale = new JLabel("Sale");
		txt_sale.setFont(new Font("Gabriola", Font.PLAIN, 48));
		txt_sale.setHorizontalAlignment(SwingConstants.CENTER);
		txt_sale.setForeground(Color.WHITE);
		txt_sale.setBounds(163, 432, 168, 55);
		frame.getContentPane().add(txt_sale);
		
		JLabel txt_welcome = new JLabel("Welcome");
		txt_welcome.setFont(new Font("Gabriola", Font.PLAIN, 48));
		txt_welcome.setHorizontalAlignment(SwingConstants.CENTER);
		txt_welcome.setForeground(Color.WHITE);
		txt_welcome.setBounds(114, 286, 271, 55);
		frame.getContentPane().add(txt_welcome);
		
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
		btn_close.setBounds(12, 13, 113, 37);
		frame.getContentPane().add(btn_close);
		
		JLabel txt_body = new JLabel("");
		txt_body.setOpaque(true);
		txt_body.setBackground(Color.BLACK);
		txt_body.setBorder(new LineBorder(Color.WHITE));
		txt_body.setBounds(0, 0, 541, 801);
		frame.getContentPane().add(txt_body);
		
		txt_quantity = new JLabel("");
		txt_quantity.setOpaque(true);
		txt_quantity.setBackground(Color.WHITE);
		txt_quantity.setHorizontalAlignment(SwingConstants.CENTER);
		txt_quantity.setForeground(Color.BLACK);
		txt_quantity.setBounds(573, 363, 101, 46);
		frame.getContentPane().add(txt_quantity);
		
		JLabel qty = new JLabel("Quantity");
		qty.setForeground(Color.WHITE);
		qty.setBounds(861, 201, 77, 16);
		frame.getContentPane().add(qty);
		
		float[] dashingPattern1 = {2f, 2f};
		Stroke stroke1 = new BasicStroke(2f, BasicStroke.CAP_BUTT,
		        BasicStroke.JOIN_MITER, 1.0f, dashingPattern1, 0.0f);
		
		JLabel txt_date = new JLabel("");
		txt_date.setBounds(1513, 310, 151, 28);
		frame.getContentPane().add(txt_date);
		Table3();
		
		JLabel txt_net = new JLabel("");
		txt_net.setBounds(1605, 671, 95, 23);
		frame.getContentPane().add(txt_net);
		
		JLabel txt_total = new JLabel("");
		txt_total.setBounds(1610, 724, 85, 33);
		frame.getContentPane().add(txt_total);
		
		JLabel price = new JLabel("Price ");
		price.setForeground(Color.WHITE);
		price.setBounds(736, 328, 40, 22);
		frame.getContentPane().add(price);
		
		JLabel total = new JLabel("Total ");
		total.setForeground(Color.WHITE);
		total.setBounds(573, 452, 40, 23);
		frame.getContentPane().add(total);
		
		txt_price = new JTextField();
		txt_price.setHorizontalAlignment(SwingConstants.CENTER);
		txt_price.setBounds(736, 363, 95, 46);
		frame.getContentPane().add(txt_price);
		txt_price.setColumns(10);
		txt_price.setEditable(false);
		int k=0;
		txt_price.setText(String.valueOf(k));
		
		txt_total3 = new JTextField();
		txt_total3.setHorizontalAlignment(SwingConstants.CENTER);
		txt_total3.setBounds(573, 494, 113, 37);
		frame.getContentPane().add(txt_total3);
		txt_total3.setColumns(10);
		txt_total3.setEditable(false);
		int j=0;
		txt_total3.setText(String.valueOf(j));
		
		JLabel stock = new JLabel("Stock ");
		stock.setForeground(Color.WHITE);
		stock.setBounds(573, 331, 56, 16);
		frame.getContentPane().add(stock);
		
		JLabel item = new JLabel("Item");
		item.setForeground(Color.WHITE);
		item.setBounds(573, 201, 94, 16);
		frame.getContentPane().add(item);
		
		JButton btn_getBill = new JButton("Get bill");
		btn_getBill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Bill.main(null);
				frame.getContentPane().setBackground(Color.LIGHT_GRAY);
				txt_total3.setVisible(false);
				txt_body.setVisible(false);
				txt_sale.setVisible(false);
				txt_welcome.setVisible(false);
				btn_close.setVisible(false);
				btn_add2.setVisible(false);
				btn_delete.setVisible(false);
				btn_getBill.setVisible(false);
				btn_submit.setVisible(false);
				btn_bill.setVisible(false);
				btn_clear.setVisible(false);
				cmp_items.setVisible(false);
				spinner.setVisible(false);
//				item.setVisible(false);
//				qty.setVisible(false);
//				price.setVisible(false);
//				total.setVisible(false);
//				stock.setVisible(false);
//				btn_clear.setVisible(false);
//				table_1.setVisible(false);
			}
		});
		btn_getBill.setBounds(812, 707, 128, 37);
		frame.getContentPane().add(btn_getBill);
		
	}
}
