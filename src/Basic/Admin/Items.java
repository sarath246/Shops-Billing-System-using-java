package Basic.Admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import Basic.Logout_screen;
import Basic.Shop_products;
import net.proteanit.sql.DbUtils;
import javax.swing.DefaultComboBoxModel;

public class Items {

	private JFrame frame;
	private JTextField txt_item;
	private JComboBox<String> cmp_type;
	private JTextField txt_price;
	private JTextField txt_tax;
	private JTextField txt_net;
	private JTable table_1;
	private JTextField txt_discount;
	private JTextField txt_search;
	private JTextField txt_gst;
	private JLabel txt_error;
	private JLabel btn_update;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Items window = new Items();
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
	
	
	public Items() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	
	
		private void FillCombo() {
			
			
			try {
				
				
				   		Class.forName("com.mysql.jdbc.Driver");
				   		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Shop_bill","root","");
				   		Statement stmt=conn.createStatement();
				   
				   		
				   		String sel="select * from tbl_type";
				   		ResultSet rs=stmt.executeQuery(sel);
				   		cmp_type.addItem("-----Type-----");
				
				   
				   while (rs.next()) {
					
					   
					   	String datas=rs.getString("type_name");
					   	System.out.println(datas);
					   	cmp_type.addItem(datas);
					   	cmp_type.getSelectedItem();
					   	cmp_type.setVisible(true);
					   
					   
				}
				   
				
			} catch (Exception e) {
				
				
				System.err.println(e);
		
			
			}
			
			
		}
		
		
		private void Table() {
			
			
			try {
				
				
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Shop_bill","root","");
				  Statement stmt=conn.createStatement();
		
				  
				  String sel="select * from tbl_item";
				  ResultSet rs=stmt.executeQuery(sel);
				 
				  
				  table_1.setModel(DbUtils.resultSetToTableModel(rs));
				  
				  
			} catch (Exception e) {
				
				
				  JOptionPane.showMessageDialog(null, e);
			
			
			}
			
		}
		

		/**
		 * Initialize the contents of the frame.
		 */
		
		
		private void initialize() {
			
			
			frame = new JFrame();
			frame.getContentPane().setBackground(Color.DARK_GRAY);
			frame.getContentPane().setForeground(new Color(0, 100, 0));
			frame.setBounds(0, 0, 1930, 1040);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			Image img3=new ImageIcon(this.getClass().getResource("/tick.png")).getImage();
			
			JLabel txt_itemmsg = new JLabel("");
			txt_itemmsg.setHorizontalAlignment(SwingConstants.RIGHT);
			txt_itemmsg.setForeground(Color.RED);
			txt_itemmsg.setBounds(217, 603, 45, 36);
			frame.getContentPane().add(txt_itemmsg);
			Image imges=new ImageIcon(this.getClass().getResource("/error.png")).getImage();
			txt_itemmsg.setIcon(new ImageIcon(imges));
			txt_itemmsg.setVisible(false);
			
			JLabel txt_pricemsg = new JLabel("");
			txt_pricemsg.setHorizontalAlignment(SwingConstants.RIGHT);
			txt_pricemsg.setForeground(Color.RED);
			txt_pricemsg.setBounds(716, 607, 45, 32);
			frame.getContentPane().add(txt_pricemsg);
			Image imges3=new ImageIcon(this.getClass().getResource("/error.png")).getImage();
			txt_pricemsg.setIcon(new ImageIcon(imges3));
			txt_pricemsg.setVisible(false);
			
			JLabel txt_typemsg = new JLabel("");
			txt_typemsg.setBounds(322, 247, 140, 16);
			frame.getContentPane().add(txt_typemsg);
			
			JLabel lblNewLabel_5 = new JLabel("Quantity");
			lblNewLabel_5.setForeground(Color.WHITE);
			lblNewLabel_5.setBounds(1294, 570, 56, 16);
			frame.getContentPane().add(lblNewLabel_5);
			
			JSpinner spinner = new JSpinner();
			spinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
			spinner.setBounds(1294, 603, 89, 36);
			frame.getContentPane().add(spinner);
			
			JSpinner spinner_5 = new JSpinner();
			spinner_5.setToolTipText("Month");
			spinner_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
			spinner_5.setModel(new SpinnerListModel(new String[] {"January", "Frebruary", "March", "April", "May", "June", "July", "Augast", "September", "October", "November", "December"}));
			spinner_5.setBounds(1068, 710, 89, 28);
			frame.getContentPane().add(spinner_5);
			
			JSpinner spinner_3 = new JSpinner();
			spinner_3.setToolTipText("Day");
			spinner_3.setModel(new SpinnerNumberModel(1, null, 31, 1));
			spinner_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
			spinner_3.setBounds(1012, 710, 55, 28);
			frame.getContentPane().add(spinner_3);
			
			JSpinner spinner_4 = new JSpinner();
			spinner_4.setToolTipText("Year");
			spinner_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
			spinner_4.setModel(new SpinnerNumberModel(new Integer(1999), null, null, new Integer(1)));
			spinner_4.setBounds(1157, 710, 83, 28);
			frame.getContentPane().add(spinner_4);
			
			JLabel lblNewLabel_1 = new JLabel("Item *\r\n");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBounds(263, 570, 53, 16);
			frame.getContentPane().add(lblNewLabel_1);
			
			txt_item = new JTextField();
			txt_item.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					
					
					txt_itemmsg.setVisible(false);
				
				
				}
			});
			txt_item.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
				}
			});
			txt_item.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
			txt_item.setHorizontalAlignment(SwingConstants.CENTER);
			txt_item.setBounds(263, 603, 186, 41);
			frame.getContentPane().add(txt_item);
			txt_item.setColumns(10);
			
		    cmp_type = new JComboBox();
		    cmp_type.setToolTipText("Select a type");
		    cmp_type.setFont(new Font("Tahoma", Font.PLAIN, 20));
		    
		    
		    FillCombo();		//Filling combobox by calling FillCombo methode
			
			
			cmp_type.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
			cmp_type.setBounds(484, 603, 186, 41);
			frame.getContentPane().add(cmp_type);
			
			txt_price = new JTextField();
			txt_price.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					
					
					txt_pricemsg.setVisible(false);
				
				
				}
			});
			txt_price.setHorizontalAlignment(SwingConstants.CENTER);
			txt_price.setBounds(761, 603, 171, 36);
			frame.getContentPane().add(txt_price);
			txt_price.setColumns(10);
			
			JLabel lblNewLabel_7 = new JLabel("Tax");
			lblNewLabel_7.setForeground(Color.WHITE);
			lblNewLabel_7.setBounds(507, 675, 56, 16);
			frame.getContentPane().add(lblNewLabel_7);
			
			txt_tax = new JTextField();
			txt_tax.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txt_tax.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.BLACK));
			txt_tax.setHorizontalAlignment(SwingConstants.CENTER);
			txt_tax.setBounds(507, 704, 99, 41);
			frame.getContentPane().add(txt_tax);
			txt_tax.setColumns(10);
			
			JLabel btn_add2 = new JLabel("Add");
			btn_add2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					
					try {

						
							String item=txt_item.getText().toUpperCase();
							String type=cmp_type.getSelectedItem().toString();
							String price=txt_price.getText();
							int quant=(int)spinner.getValue();
							int day=(int) spinner_3.getValue();
							String month=(String) spinner_5.getValue();
							int year=(int) spinner_4.getValue();
							String date=day+" "+month+" "+year;
							String tax=txt_tax.getText();
							float total;
							String net=txt_net.getText();
							float price2=Float.parseFloat(price);
							float net2=Float.parseFloat(net);
							String disct=txt_discount.getText();
							float disct2=Float.parseFloat(disct);
						
						
						    Class.forName("com.mysql.jdbc.Driver");
						    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Shop_bill","root","");
						    Statement stmt=conn.createStatement();
						   
						   
						    total=(((net2 - price2) * 100)/ price2);						//Calculate GST(total)
						   
						   
						    String ins="insert into tbl_item(item_name,type_name,price,quantity,exp_date,item_tax,item_gst,net_price,discount)"
						   
								      + "values('"+item+"','"+type+"','"+price+"','"+quant+"','"+date+"','"+tax+"','"+total+"','"+net+"','"+disct2+"')";
						   
						   
						    stmt.executeUpdate(ins);
						    JOptionPane.showMessageDialog(null, "Data saved");
						   
						   
						    txt_item.setText(null);
						    txt_price.setText(null);
						    txt_net.setText(null);
						    txt_tax.setText(null);
						    txt_gst.setText(null);
						    txt_discount.setText(null);
						    Table();
						   
						   
					} catch (Exception e) {
						
						
							System.err.println(e);
						
						
							String item=txt_item.getText();
							String price=txt_price.getText();
							String tax=txt_tax.getText();
							String net=txt_net.getText();
						
						
						 if (item.isEmpty()) {
							 
								
							   		txt_itemmsg.setVisible(true);
							 
							   
							   }else if (price.isEmpty()) {
								   
								   
								   	txt_pricemsg.setVisible(true);
							
							   
							   }else if (tax.isEmpty()) {
								
								   
								   	txt_tax.setVisible(true);
							
							   
							   }else if (net.isEmpty()) {
								
								   
								   	txt_net.setVisible(true);
							
							   
							   }
						
					}
					
					
				}
				@Override
				public void mousePressed(MouseEvent arg0) {
				
					
					btn_add2.setBackground(Color.LIGHT_GRAY);
				
					
				}
				@Override
				public void mouseReleased(MouseEvent arg0) {
				
					
					btn_add2.setBackground(Color.BLACK);
				
					
				}
				
			});
			btn_add2.setBorder(new LineBorder(Color.WHITE));
			btn_add2.setOpaque(true);
			btn_add2.setBackground(Color.BLACK);
			btn_add2.setForeground(Color.WHITE);
			btn_add2.setHorizontalAlignment(SwingConstants.CENTER);
			btn_add2.setBounds(656, 874, 140, 41);
			frame.getContentPane().add(btn_add2);
			btn_add2.setEnabled(true);
			
			JLabel btn_reset = new JLabel("Reset");
			btn_reset.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					
					txt_item.setText(null);
					txt_discount.setText(null);
					txt_gst.setText(null);
					txt_net.setText(null);
					txt_price.setText(null);
					txt_search.setText(null);
					txt_tax.setText(null);
					Table();
					
					
				}
				@Override
				public void mousePressed(MouseEvent arg0) {
					
					
					btn_reset.setBackground(Color.LIGHT_GRAY);
				
					
				}
				@Override
				public void mouseReleased(MouseEvent arg0) {
					
					
					btn_reset.setBackground(Color.BLACK);
				
				
				}
				
			});
			btn_reset.setBorder(new LineBorder(Color.WHITE));
			btn_reset.setOpaque(true);
			btn_reset.setBackground(Color.BLACK);
			btn_reset.setForeground(Color.WHITE);
			btn_reset.setHorizontalAlignment(SwingConstants.CENTER);
			btn_reset.setBounds(883, 874, 128, 41);
			frame.getContentPane().add(btn_reset);
			
			JLabel lblNew = new JLabel("ITEMS ");
			lblNew.setForeground(Color.WHITE);
			lblNew.setFont(new Font("Gabriola", Font.PLAIN, 38));
			lblNew.setHorizontalAlignment(SwingConstants.CENTER);
			lblNew.setBounds(777, 25, 332, 37);
			frame.getContentPane().add(lblNew);
			
			JLabel lblNewLabel_2 = new JLabel("Price");
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setBounds(761, 570, 56, 16);
			frame.getContentPane().add(lblNewLabel_2);
			
			JLabel lblNewLabel_2_1 = new JLabel("Net price");
			lblNewLabel_2_1.setForeground(Color.WHITE);
			lblNewLabel_2_1.setBounds(1012, 570, 56, 16);
			frame.getContentPane().add(lblNewLabel_2_1);
			
			txt_net = new JTextField();
			txt_net.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					
					
						String price=txt_price.getText();
						float total;
						String net=txt_net.getText();
						float price2=Float.parseFloat(price);
						float net2=Float.parseFloat(net);
					
				    
					try {
						
						
						total=(((net2 - price2) * 100)/ price2);
						String tol=String.valueOf(total);
						txt_gst.setText(tol);
						
						
					} catch (Exception e) {
						
						
						System.out.println(e);
					
					
					}
					
				}
			});
			txt_net.setHorizontalAlignment(SwingConstants.CENTER);
			txt_net.setColumns(10);
			txt_net.setBounds(1012, 603, 156, 36);
			frame.getContentPane().add(txt_net);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(118, 159, 1693, 366);
			frame.getContentPane().add(scrollPane_1);
			
			table_1 = new JTable();
			table_1.addMouseListener(new MouseAdapter() {
				@SuppressWarnings("deprecation")
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					
					String sel="",item="",tax="",net="",price="",qty="",gst="";
					
					
					btn_add2.setVisible(false);
					btn_update.setVisible(true);
					
					
					try {
						
						
							Class.forName("com.mysql.jdbc.Driver");
							Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/shop_bill","root","");
							Statement stmtt=conn.createStatement();
						
							
							//Take table row values
							
							
							int tables=table_1.getSelectedRow();
							Object value= (table_1.getModel().getValueAt(tables, 0));
						
							
							sel="select * from tbl_item where item_id='"+value+"'";
							ResultSet rs=stmtt.executeQuery(sel);
						
							
						while(rs.next()) {
							
							
							item=rs.getString("item_name");
							tax=rs.getString("item_tax");
							net=rs.getString("net_price");
							price=rs.getString("price");
							qty=rs.getString("discount");
							gst=rs.getString("item_gst");
							txt_item.setText(item);
							txt_tax.setText(tax);
							txt_net.setText(net);
							txt_price.setText(price);
							txt_discount.setText(qty);
							txt_gst.setText(gst);
					
						
						}
						
						
					} catch (Exception e) {
						
						
						System.out.println(e);
						
						
					}
					
				}

			});
			table_1.setRowHeight(48);
			table_1.setForeground(Color.WHITE);
			table_1.setBackground(Color.BLACK);
			Table();
			scrollPane_1.setViewportView(table_1);
			
			JLabel txt_next = new JLabel("");
			txt_next.setToolTipText("Refresh");
			txt_next.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					
					txt_discount.setText(null);
					txt_gst.setText(null);
					txt_item.setText(null);
					txt_net.setText(null);
					txt_price.setText(null);
					txt_search.setText(null);
					txt_tax.setText(null);
					Table();
					btn_add2.setVisible(true);
					btn_update.setVisible(false);
					txt_itemmsg.setVisible(false);
					txt_pricemsg.setVisible(false);
					txt_typemsg.setVisible(false);
					
					
				}
			});
			txt_next.setHorizontalAlignment(SwingConstants.CENTER);
			txt_next.setBounds(1817, 13, 83, 69);
			frame.getContentPane().add(txt_next);
			Image imges4=new ImageIcon(this.getClass().getResource("/reseticon.png")).getImage();
			txt_next.setIcon(new ImageIcon(imges4));
			
			JLabel txt_netmsg = new JLabel("");
			txt_netmsg.setHorizontalAlignment(SwingConstants.RIGHT);
			txt_netmsg.setBounds(966, 605, 45, 34);
			frame.getContentPane().add(txt_netmsg);
			Image imges5=new ImageIcon(this.getClass().getResource("/error.png")).getImage();
			txt_netmsg.setIcon(new ImageIcon(imges5));
			txt_netmsg.setVisible(false);
			
			JLabel txt_taxmsg = new JLabel("");
			txt_taxmsg.setHorizontalAlignment(SwingConstants.RIGHT);
			txt_taxmsg.setBounds(462, 704, 45, 34);
			frame.getContentPane().add(txt_taxmsg);
			Image imges6=new ImageIcon(this.getClass().getResource("/error.png")).getImage();
			txt_taxmsg.setIcon(new ImageIcon(imges6));
			
			txt_discount = new JTextField();
			txt_discount.setHorizontalAlignment(SwingConstants.CENTER);
			txt_discount.setColumns(10);
			txt_discount.setBounds(761, 706, 156, 36);
			frame.getContentPane().add(txt_discount);
			
			JLabel dvs = new JLabel("Discount");
			dvs.setForeground(Color.WHITE);
			dvs.setBounds(761, 675, 56, 16);
			frame.getContentPane().add(dvs);
			
			JLabel btn_reset2 = new JLabel("");
			btn_reset2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					
				  Reset_screen.main(null);
				
				
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
				
					
					btn_reset2.setBackground(Color.LIGHT_GRAY);
					btn_reset2.setBorder(new LineBorder(Color.BLACK,2));
				
				
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
				
					
					btn_reset2.setBackground(Color.BLACK);
					btn_reset2.setBorder(new LineBorder(Color.WHITE));
				
				}
				@Override
				public void mousePressed(MouseEvent arg0) {
					
					
					btn_reset2.setBackground(Color.BLACK);
				
				
				}
				@Override
				public void mouseReleased(MouseEvent arg0) {
				
					
					btn_reset2.setBackground(Color.lightGray);
				
				
				}
				
			});
			btn_reset2.setOpaque(true);
			btn_reset2.setHorizontalAlignment(SwingConstants.CENTER);
			btn_reset2.setForeground(Color.WHITE);
			btn_reset2.setBorder(new LineBorder(Color.WHITE));
			btn_reset2.setBackground(Color.BLACK);
			btn_reset2.setBounds(407, 94, 55, 41);
			frame.getContentPane().add(btn_reset2);
			
			Image imgClear=new ImageIcon(this.getClass().getResource("/clearAll.png")).getImage();
			btn_reset2.setIcon(new ImageIcon(imgClear));
			    
			JLabel btn_delete = new JLabel("");
			btn_delete.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					
					btn_add2.setVisible(true);
					btn_update.setVisible(false);
					txt_discount.setText(null);
					txt_gst.setText(null);
					txt_item.setText(null);
					txt_net.setText(null);
					txt_price.setText(null);
					txt_search.setText(null);
					txt_tax.setText(null);
					
					
					try {
						
						
							Class.forName("com.mysql.jdbc.Driver");
							Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/shop_bill","root","");
						
						
							int selectedRow=table_1.getSelectedRow();
							Object valueOfItem= (table_1.getModel().getValueAt(selectedRow, 0));
							JOptionPane.showMessageDialog(null, valueOfItem);
						
							
							String delQry="delete from tbl_item where item_id='"+valueOfItem+"'";
							PreparedStatement pst=conn.prepareStatement(delQry);
							pst.executeUpdate(delQry);
							JOptionPane.showMessageDialog(null, valueOfItem+" "+"Deleted");
							
							
							Table();   			//Refresh table 
							
							
					} catch (Exception e) {
					
						
							System.out.println(e);
							JOptionPane.showMessageDialog(null, "Please select a row");
							Table();
							
					}
					
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					
					
					btn_delete.setBackground(Color.LIGHT_GRAY);
					btn_delete.setBorder(new LineBorder(Color.BLACK,2));
				
				
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
				
					
					btn_delete.setBackground(Color.BLACK);
					btn_delete.setBorder(new LineBorder(Color.WHITE));
				
				
				}
				@Override
				public void mousePressed(MouseEvent arg0) {
				
					
					btn_delete.setBackground(Color.BLACK);
				
				
				}
				@Override
				public void mouseReleased(MouseEvent arg0) {
				
					
					btn_delete.setBackground(Color.lightGray);
				
				
				}
			});
			btn_delete.setOpaque(true);
			btn_delete.setHorizontalAlignment(SwingConstants.CENTER);
			btn_delete.setForeground(Color.WHITE);
			btn_delete.setBorder(new LineBorder(Color.WHITE));
			btn_delete.setBackground(Color.BLACK);
			btn_delete.setBounds(339, 94, 56, 41);
			frame.getContentPane().add(btn_delete);
			
			Image imgDelete=new ImageIcon(this.getClass().getResource("/deleteIcon.png")).getImage();
			btn_delete.setIcon(new ImageIcon(imgDelete));
			
			btn_update = new JLabel("Update");
			btn_update.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
						
					
							btn_add2.setVisible(true);
							btn_update.setVisible(false);
					
					
					try {
					
						
							String upqry="";
							String item=txt_item.getText().toUpperCase();
							String type=cmp_type.getSelectedItem().toString();
							String price=txt_price.getText();
						    int quant=(int)spinner.getValue();
						    int day=(int) spinner_3.getValue();
						    String month=(String) spinner_5.getValue();
						    int year=(int) spinner_4.getValue();
						    String date=day+" "+month+" "+year;
						    String tax=txt_tax.getText();
						    float total;
						    String net=txt_net.getText();
						    float price2=Float.parseFloat(price);
						    float net2=Float.parseFloat(net);
						    String disct=txt_discount.getText();
						    String gst=txt_gst.getText();
							
						    
							Class.forName("com.mysql.jdbc.Driver");
							Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/shop_bill","root","");
							Statement stmtt=conn.createStatement();
							
							
							int tables=table_1.getSelectedRow();
							Object value= (table_1.getModel().getValueAt(tables, 0));
							
							
							upqry="update tbl_item set item_name='"+item+"',type_name='"+type+"',item_tax='"+tax+"',net_price='"+net2+"',price='"+price2+"',"
										
								  + "item_gst='"+gst+"',discount='"+disct+"' where item_id='"+value+"'";
							
							
							stmtt.executeUpdate(upqry);
							Table();
							
							
							txt_item.setText(null);
							txt_net.setText(null);
							txt_tax.setText(null);
							txt_price.setText(null);
							txt_discount.setText(null);
							txt_gst.setText(null);
						
					
					} catch (Exception e) {
						
						
							JOptionPane.showMessageDialog(null, "Please select a row");
						
					}
					
				}
				@Override
				public void mousePressed(MouseEvent arg0) {
				
					
					btn_update.setBackground(Color.BLACK);
				
				
				}
				@Override
				public void mouseReleased(MouseEvent arg0) {
				
					
					btn_update.setBackground(Color.lightGray);
				
				
				}
			});
			btn_update.setOpaque(true);
			btn_update.setHorizontalAlignment(SwingConstants.CENTER);
			btn_update.setForeground(Color.WHITE);
			btn_update.setBorder(new LineBorder(Color.WHITE));
			btn_update.setBackground(Color.BLACK);
			btn_update.setBounds(656, 874, 140, 41);
			btn_update.setVisible(false);
			frame.getContentPane().add(btn_update);
			
			txt_search = new JTextField();
			txt_search.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txt_search.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
				
				}
				@Override
				public void keyReleased(KeyEvent arg0) {
					
					
					String search=txt_search.getText();
					btn_add2.setVisible(true);
					btn_update.setVisible(false);
					
					
					try {
						
						
						   Class.forName("com.mysql.jdbc.Driver");
						   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Shop_bill","root","");
						   Statement stmt=conn.createStatement();
						
						   
						   if (search.isEmpty()) {
							   
							   
								Table();
							
						   
						   }else {
							   
							   
							   String sel="select * from tbl_item where item_name='"+search+"'";
							   ResultSet rs=stmt.executeQuery(sel);
						  
						   
							   table_1.setModel(DbUtils.resultSetToTableModel(rs));
							
						   
						   }
					} catch (Exception e) {
						
						
						System.out.println(e);
					
					
					}
					
					
				}
			});
			txt_search.setBounds(118, 94, 209, 41);
			frame.getContentPane().add(txt_search);
			txt_search.setColumns(10);
			
			txt_gst = new JTextField();
			txt_gst.setHorizontalAlignment(SwingConstants.CENTER);
			txt_gst.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txt_gst.setColumns(10);
			txt_gst.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.BLACK));
			txt_gst.setBounds(263, 704, 99, 41);
			frame.getContentPane().add(txt_gst);
			
			JLabel lblNewLabel_7_1 = new JLabel("GST");
			lblNewLabel_7_1.setForeground(Color.WHITE);
			lblNewLabel_7_1.setBounds(263, 675, 56, 16);
			frame.getContentPane().add(lblNewLabel_7_1);
			
			JLabel lblNewLabel_5_1 = new JLabel("Per");
			lblNewLabel_5_1.setForeground(Color.WHITE);
			lblNewLabel_5_1.setBounds(1478, 570, 56, 16);
			frame.getContentPane().add(lblNewLabel_5_1);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"NOS", "PACKS", "KG"}));
			comboBox.setBounds(1478, 603, 130, 36);
			frame.getContentPane().add(comboBox);
			
			txt_error = new JLabel("Must have digit");
			txt_error.setForeground(Color.RED);
			txt_error.setBounds(761, 636, 120, 16);
			frame.getContentPane().add(txt_error);
			txt_error.setVisible(false);
			
			JLabel txt_error2 = new JLabel("Must have digit");
			txt_error2.setForeground(Color.RED);
			txt_error2.setBounds(1012, 636, 101, 16);
			frame.getContentPane().add(txt_error2);
			
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
			btn_close.setBackground(Color.BLACK);
			btn_close.setHorizontalAlignment(SwingConstants.CENTER);
			btn_close.setForeground(Color.WHITE);
			btn_close.setBounds(12, 13, 110, 36);
			frame.getContentPane().add(btn_close);
			txt_error2.setVisible(false);
			
			Image imges13=new ImageIcon(this.getClass().getResource("/error.png")).getImage();
			txt_taxmsg.setVisible(false);
			Table();
		}
	}

