package Basic;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.LineBorder;

import Basic.Admin.DashBoard;
import Basic.Admin.Login;
import Basic.Admin.LoginCancelWindow;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class Logout_screen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logout_screen window = new Logout_screen();
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
	public Logout_screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(800, 350, 405, 269);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Are you sure ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(117, 35, 151, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel btn_yes = new JLabel("Yes");
		btn_yes.setOpaque(true);
		btn_yes.setBackground(Color.BLACK);
		btn_yes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btn_yes.setBackground(Color.LIGHT_GRAY);
				btn_yes.setBorder(new LineBorder(Color.BLACK,2));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btn_yes.setBackground(Color.BLACK);
				btn_yes.setBorder(new LineBorder(Color.WHITE));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
				btn_yes.setBackground(Color.BLACK);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				
				btn_yes.setBackground(Color.lightGray);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				LoginCancelWindow.main(null);
			}
		});
		btn_yes.setBorder(new LineBorder(Color.WHITE));
		btn_yes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_yes.setHorizontalAlignment(SwingConstants.CENTER);
		btn_yes.setForeground(Color.WHITE);
		btn_yes.setBounds(43, 137, 119, 45);
		frame.getContentPane().add(btn_yes);
		
		JLabel btn_no = new JLabel("No");
		btn_no.setOpaque(true);
		btn_no.setBackground(Color.BLACK);
		btn_no.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btn_no.setBackground(Color.LIGHT_GRAY);
				btn_no.setBorder(new LineBorder(Color.BLACK,2));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btn_no.setBackground(Color.BLACK);
				btn_no.setBorder(new LineBorder(Color.WHITE));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
				btn_yes.setBackground(Color.BLACK);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				
				btn_yes.setBackground(Color.lightGray);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DashBoard.main(null);
			}
		});
		btn_no.setHorizontalAlignment(SwingConstants.CENTER);
		btn_no.setForeground(Color.WHITE);
		btn_no.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_no.setBorder(new LineBorder(Color.WHITE));
		btn_no.setBounds(215, 137, 119, 45);
		frame.getContentPane().add(btn_no);
		
		JLabel txt_img = new JLabel("");
		txt_img.setHorizontalAlignment(SwingConstants.CENTER);
		txt_img.setOpaque(true);
		txt_img.setBackground(Color.DARK_GRAY);
		txt_img.setBounds(75, 33, 56, 52);
		frame.getContentPane().add(txt_img);
		Image imge=new ImageIcon(this.getClass().getResource("/alert2.png")).getImage();
		txt_img.setIcon(new ImageIcon(imge));
		
	}
}
