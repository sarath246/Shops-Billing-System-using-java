package Basic.Admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Basic.Logout_screen;
import Basic.Shop_products;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Sale_repport {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sale_repport window = new Sale_repport();
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
	public Sale_repport() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(300, 100, 1381, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel btn_cancel = new JLabel("Cancel");
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
				
				btn_cancel.setBackground(Color.GRAY);
			}
		});
		btn_cancel.setBackground(Color.GRAY);
		btn_cancel.setOpaque(true);
		btn_cancel.setForeground(Color.WHITE);
		btn_cancel.setHorizontalAlignment(SwingConstants.CENTER);
		btn_cancel.setBounds(12, 24, 111, 40);
		frame.getContentPane().add(btn_cancel);
		
		JLabel lblNewLabel_6 = new JLabel("Sale");
		lblNewLabel_6.setFont(new Font("Gabriola", Font.PLAIN, 48));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setOpaque(true);
		lblNewLabel_6.setBackground(Color.BLACK);
		lblNewLabel_6.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		lblNewLabel_6.setBounds(0, 0, 458, 803);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel txt_menu = new JLabel("");
		txt_menu.setHorizontalTextPosition(SwingConstants.CENTER);
		txt_menu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_menu.setHorizontalAlignment(SwingConstants.CENTER);
		txt_menu.setForeground(Color.WHITE);
		txt_menu.setBounds(1789, 24, 56, 56);
		frame.getContentPane().add(txt_menu);
		Image img=new ImageIcon(this.getClass().getResource("/menu4.png")).getImage();
		txt_menu.setIcon(new ImageIcon(img));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(525, 150, 783, 426);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	}
}
