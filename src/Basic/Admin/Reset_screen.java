package Basic.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Reset_screen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reset_screen window = new Reset_screen();
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
	public Reset_screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(600, 300, 638, 269);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("If you want to delete all contents of table ,please confirm YES otherwise NO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(12, 43, 577, 46);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel btn_yes = new JLabel("Yes");
		btn_yes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/shop_bill","root","");
					Statement stmtt=conn.createStatement();
					
						String del="delete from tbl_item ";
						PreparedStatement pst=conn.prepareStatement(del);
						pst.executeUpdate(del);
						
						JOptionPane.showMessageDialog(null, "Successfully deleted!");
					
					
				} catch (Exception e) {
					System.out.println(e);
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				btn_yes.setBackground(Color.LIGHT_GRAY);
				btn_yes.setBorder(new LineBorder(Color.BLACK,2));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				
				btn_yes.setBackground(Color.BLACK);
				btn_yes.setBorder(new LineBorder(Color.WHITE));
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				btn_yes.setBackground(Color.BLACK);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				btn_yes.setBackground(Color.lightGray);
			}
		});
		btn_yes.setOpaque(true);
		btn_yes.setHorizontalAlignment(SwingConstants.CENTER);
		btn_yes.setForeground(Color.WHITE);
		btn_yes.setBorder(new LineBorder(Color.WHITE));
		btn_yes.setBackground(Color.BLACK);
		btn_yes.setBounds(158, 142, 101, 50);
		frame.getContentPane().add(btn_yes);
		
		JLabel btn_no = new JLabel("No");
		btn_no.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Items.main(null);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				btn_no.setBackground(Color.LIGHT_GRAY);
				btn_no.setBorder(new LineBorder(Color.BLACK,2));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				
				btn_no.setBackground(Color.BLACK);
				btn_no.setBorder(new LineBorder(Color.WHITE));
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				btn_no.setBackground(Color.BLACK);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				btn_no.setBackground(Color.lightGray);
			}
		});
		btn_no.setOpaque(true);
		btn_no.setHorizontalAlignment(SwingConstants.CENTER);
		btn_no.setForeground(Color.WHITE);
		btn_no.setBorder(new LineBorder(Color.WHITE));
		btn_no.setBackground(Color.BLACK);
		btn_no.setBounds(351, 142, 101, 50);
		frame.getContentPane().add(btn_no);
	}

}
