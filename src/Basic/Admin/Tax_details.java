package Basic.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.SystemColor;

public class Tax_details {

	private JFrame frame;
	private JTextField txt_tax;
	private JTextField txt_gst;
	private JTextField txt_discount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tax_details window = new Tax_details();
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
	public Tax_details() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 665, 499);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btn_submit = new JButton("Submit\r\n");
		btn_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String tax=txt_tax.getText();
				String gst=txt_gst.getText();
				String discount=txt_discount.getText();
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/shop_bill","root","");
					Statement stmt=conn.createStatement();
					
					String ins="";
					ins="insert into tbl_tax(tax,gst,discount)values('"+tax+"','"+gst+"','"+discount+"')";
					stmt.executeUpdate(ins);
					System.out.println(ins);
					
					JOptionPane.showMessageDialog(null, "Success");
					
				} catch (Exception e) {
					System.out.println(e);
				}
				
				
			}
		});
		btn_submit.setBounds(188, 385, 105, 33);
		frame.getContentPane().add(btn_submit);
		
		JButton btn_clear = new JButton("Clear");
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txt_tax.setText(null);
				txt_gst.setText(null);
				txt_discount.setText(null);
				
			}
		});
		btn_clear.setBounds(66, 385, 105, 33);
		frame.getContentPane().add(btn_clear);
		
		Panel panel = new Panel();
		panel.setBackground(SystemColor.scrollbar);
		panel.setBounds(0, 0, 647, 56);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Tax or other details\r\n");
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Discount");
		lblNewLabel_3.setBounds(66, 288, 61, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		txt_discount = new JTextField();
		txt_discount.setBounds(177, 280, 133, 33);
		frame.getContentPane().add(txt_discount);
		txt_discount.setHorizontalAlignment(SwingConstants.CENTER);
		txt_discount.setColumns(10);
		
		txt_gst = new JTextField();
		txt_gst.setBounds(177, 206, 133, 33);
		frame.getContentPane().add(txt_gst);
		txt_gst.setHorizontalAlignment(SwingConstants.CENTER);
		txt_gst.setColumns(10);
		
		txt_tax = new JTextField();
		txt_tax.setBounds(177, 119, 133, 33);
		frame.getContentPane().add(txt_tax);
		txt_tax.setHorizontalAlignment(SwingConstants.CENTER);
		txt_tax.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("TAX\r\n\r\n");
		lblNewLabel_1.setBounds(66, 127, 24, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("GST");
		lblNewLabel_2.setBounds(66, 214, 24, 16);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
