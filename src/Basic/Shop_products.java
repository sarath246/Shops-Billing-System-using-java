package Basic;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;
import javax.swing.text.BadLocationException;

import Basic.Admin.Change_psw;
import Basic.Admin.DashBoard;
import Basic.Admin.Items;
import Basic.Admin.Login;
import Basic.Admin.Purchase;

import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageProducer;

import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBoxMenuItem;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JSpinField;
import datechooser.beans.DateChooserCombo;
import datechooser.beans.DateChooserPanel;
import net.proteanit.sql.DbUtils;

import com.toedter.components.JLocaleChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Shop_products {

	private JFrame frame;
	private JTextField txt_type;
	private JSpinner spinner_2;
	private JTable table;
	private JTable table_1;
	private JTextField txt_search;
	private JLabel btn_update;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Shop_products window = new Shop_products();
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
	public Shop_products() {
		initialize();
		
		
	}

	private void Table() {
		
		
		try {
			
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Shop_bill","root","");
			  Statement stmt=conn.createStatement();
			   
			  String sel="select * from tbl_type";
			  ResultSet rs=stmt.executeQuery(sel);
			  
			 table.setModel(DbUtils.resultSetToTableModel(rs));
			 
		} catch (Exception e) {
			
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setForeground(new Color(0, 100, 0));
		frame.setBounds(300, 100, 1381, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Type *");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(477, 310, 46, 28);
		frame.getContentPane().add(lblNewLabel);
		Image img3=new ImageIcon(this.getClass().getResource("/tick.png")).getImage();
		
		JLabel txt_typemsg = new JLabel("");
		txt_typemsg.setToolTipText("Field required");
		txt_typemsg.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_typemsg.setBounds(431, 351, 46, 43);
		frame.getContentPane().add(txt_typemsg);
		Image imges2=new ImageIcon(this.getClass().getResource("/error.png")).getImage();
		txt_typemsg.setIcon(new ImageIcon(imges2));
		txt_typemsg.setVisible(false);
		
		txt_type = new JTextField();
		txt_type.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_type.setForeground(new Color(255, 255, 255));
		txt_type.setBackground(Color.BLACK);
		txt_type.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				txt_typemsg.setVisible(false);
			}
		});
		txt_type.addMouseListener(new MouseAdapter() {
			
		});
		txt_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		txt_type.setBorder(new MatteBorder(1, 1, 3, 1, (Color) new Color(255, 255, 255)));
		txt_type.setToolTipText("");
		txt_type.setHorizontalAlignment(SwingConstants.CENTER);
		txt_type.setBounds(477, 351, 209, 43);
		frame.getContentPane().add(txt_type);
		txt_type.setColumns(10);
		
		JLabel btn_add = new JLabel("Add");
		btn_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String type=txt_type.getText().toUpperCase();
				Image imges2=new ImageIcon(this.getClass().getResource("/error.png")).getImage();
				txt_typemsg.setIcon(new ImageIcon(imges2));
				
				try {
					
					   Class.forName("com.mysql.jdbc.Driver");
					   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Shop_bill","root","");
					   Statement stmt=conn.createStatement();
			
					   
					    if (type.isEmpty()) {
						
						   txt_typemsg.setVisible(true);
						   
						   }
					    else {
						   
					   String ins="insert into tbl_type(type_name)values('"+type+"')";
					   stmt.executeUpdate(ins);
					   System.out.println(ins);
					   txt_type.setText(null);
					   JOptionPane.showMessageDialog(null, "Data saved");
					   Table();
					   //Thread.sleep(1000);
					   }	
				} catch (Exception e) {
					System.err.println(e);
				}
				
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				btn_add.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				btn_add.setBackground(Color.BLACK);
			}
			
		});
		btn_add.setBorder(new LineBorder(Color.WHITE));
		btn_add.setOpaque(true);
		btn_add.setBackground(Color.BLACK);
		btn_add.setHorizontalAlignment(SwingConstants.CENTER);
		btn_add.setForeground(Color.WHITE);
		btn_add.setBounds(527, 429, 104, 43);
		frame.getContentPane().add(btn_add);
		Image imgs=new ImageIcon(this.getClass().getResource("/reseticon.png")).getImage();
		
		JLabel lblNew = new JLabel("TYPES");
		lblNew.setForeground(Color.WHITE);
		lblNew.setFont(new Font("Gabriola", Font.PLAIN, 38));
		lblNew.setHorizontalAlignment(SwingConstants.CENTER);
		lblNew.setBounds(35, 382, 332, 37);
		frame.getContentPane().add(lblNew);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(804, 199, 461, 533);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String sel="",type="";
				btn_add.setVisible(false);
				btn_update.setVisible(true);
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/shop_bill","root","");
					Statement stmtt=conn.createStatement();
					
					int tables=table.getSelectedRow();
					Object value= (table.getModel().getValueAt(tables, 0));
					
					sel="select * from tbl_type where type_id='"+value+"'";
					ResultSet rs=stmtt.executeQuery(sel);
					
					while(rs.next()) {
						type=rs.getString("type_name");
						txt_type.setText(type);
					}
					
				} catch (Exception e) {
					
				}
				
			}
		});
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLACK);
		table.setRowHeight(48);
		scrollPane.setViewportView(table);
		Table();
		
		JLabel btn_delete = new JLabel("Delete");
		btn_delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btn_update.setVisible(false);
				btn_add.setVisible(true);
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/shop_bill","root","");
					Statement stmtt=conn.createStatement();
					
					int tables=table.getSelectedRow();
					Object value= (table.getModel().getValueAt(tables, 0));
					
					
						String del="delete from tbl_type where type_id='"+value+"'";
						PreparedStatement pst=conn.prepareStatement(del);
						pst.executeUpdate(del);
						JOptionPane.showMessageDialog(null, "Deleted");
						Table();
						txt_type.setText(null);
						txt_search.setText(null);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please select a row");
					
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
		btn_delete.setBounds(1017, 158, 118, 36);
		frame.getContentPane().add(btn_delete);
		
		btn_update = new JLabel("Update");
		btn_update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String upqry="";
				String type=txt_type.getText().toUpperCase();
				btn_update.setVisible(false);
				btn_add.setVisible(true);
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/shop_bill","root","");
					Statement stmtt=conn.createStatement();
					
					int tables=table.getSelectedRow();
					Object value= (table.getModel().getValueAt(tables, 0));
					
					upqry="update tbl_type set type_name='"+type+"' where type_id='"+value+"'";
					stmtt.executeUpdate(upqry);
					Table();
					txt_type.setText(null);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please select");
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				btn_update.setBackground(Color.LIGHT_GRAY);
				btn_update.setBorder(new LineBorder(Color.BLACK,2));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				
				btn_update.setBackground(Color.BLACK);
				btn_update.setBorder(new LineBorder(Color.WHITE));
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
		btn_update.setBounds(527, 429, 104, 43);
		btn_update.setVisible(false);
		frame.getContentPane().add(btn_update);
		
		txt_search = new JTextField();
		txt_search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				txt_type.setText(null);
				btn_update.setVisible(false);
				btn_add.setVisible(true);
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				String search=txt_search.getText();
				try {
					
					   Class.forName("com.mysql.jdbc.Driver");
					   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Shop_bill","root","");
					   Statement stmt=conn.createStatement();
					   if (search.isEmpty()) {
							Table();
						}else {
					   String sel="select * from tbl_type where type_name='"+search+"'";
					   ResultSet rs=stmt.executeQuery(sel);
					 
					   table.setModel(DbUtils.resultSetToTableModel(rs));
						}
				} catch (Exception e) {
					System.out.println(e);
				}
				
			}
				
		});
		txt_search.setBounds(804, 158, 201, 36);
		frame.getContentPane().add(txt_search);
		txt_search.setColumns(10);
		
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
				
				btn_close.setBackground(Color.GRAY);
			}
		});
		btn_close.setOpaque(true);
		btn_close.setBackground(Color.DARK_GRAY);
		btn_close.setHorizontalAlignment(SwingConstants.CENTER);
		btn_close.setForeground(Color.WHITE);
		btn_close.setBounds(12, 13, 118, 37);
		frame.getContentPane().add(btn_close);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(0, 0, 419, 803);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel txt_img = new JLabel("");
		txt_img.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				txt_type.setText(null);
				txt_search.setText(null);
				txt_typemsg.setVisible(false);
				btn_update.setVisible(false);
				btn_add.setVisible(true);
				Table();
			}
		});
		txt_img.setHorizontalAlignment(SwingConstants.CENTER);
		txt_img.setBounds(1257, 13, 94, 61);
		frame.getContentPane().add(txt_img);
		Image img4=new ImageIcon(this.getClass().getResource("/reseticon.png")).getImage();
		txt_img.setIcon(new ImageIcon(img4));
		
	}
}
