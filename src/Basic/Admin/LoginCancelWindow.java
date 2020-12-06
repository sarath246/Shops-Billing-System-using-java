package Basic.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginCancelWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginCancelWindow window = new LoginCancelWindow();
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
	public LoginCancelWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(600, 350, 583, 307);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THANK YOU");
		lblNewLabel.setFont(new Font("Gabriola", Font.PLAIN, 38));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(149, 64, 224, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel btn_cancel = new JLabel("OK");
		btn_cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				btn_cancel.setBackground(Color.LIGHT_GRAY);
				btn_cancel.setBorder(new LineBorder(Color.BLACK,2));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				
				btn_cancel.setBackground(Color.BLACK);
				btn_cancel.setBorder(null);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				btn_cancel.setBackground(Color.BLACK);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				btn_cancel.setBackground(Color.lightGray);
			}
		});
		btn_cancel.setOpaque(true);
		btn_cancel.setBackground(Color.BLACK);
		btn_cancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_cancel.setForeground(Color.WHITE);
		btn_cancel.setHorizontalAlignment(SwingConstants.CENTER);
		btn_cancel.setBounds(222, 179, 92, 29);
		frame.getContentPane().add(btn_cancel);
	}

}
