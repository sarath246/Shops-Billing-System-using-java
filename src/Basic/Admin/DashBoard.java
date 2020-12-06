package Basic.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import Basic.Investments;
import Basic.Logout_screen;
import Basic.Sale_history;
import Basic.Shop_products;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;

public class DashBoard {

	private JFrame frame;
	private JLabel txt_history;
	private JLabel txt_img2;
	private JLabel txt_img3;
	private JLabel txt_img4;
	private JLabel txt_img5;
	private JLabel txt_acc;
	private JLabel txt_exit;
	private JLabel txt_body;
	private JLabel txt_cpsw;
	private JLabel txt_lbl;
	private JLabel btn_purchase;
	private JLabel btn_items;
	private JLabel txt_menu;
	private JLabel txt_head;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel sale_status;
	private JLabel Balance_status;
	private JLabel txt_home;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard window = new DashBoard();
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
	public DashBoard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	

	@SuppressWarnings("deprecation")
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(0, 0, 2000, 1370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel btn_acc = new JLabel("ACCOUNT");
		btn_acc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_acc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				
				btn_acc.setBackground(Color.LIGHT_GRAY);
				btn_acc.setBorder(new LineBorder(Color.BLACK,2));
				btn_acc.setFont(new Font("Tahoma",Font.PLAIN,20));
				btn_acc.setForeground(Color.BLACK);
			
			}
			@Override
			public void mouseExited(MouseEvent e) {
			
				
				btn_acc.setBackground(Color.BLACK);
				btn_acc.setBorder(null);
				btn_acc.setFont(new Font("Tahoma",Font.PLAIN,16));
				btn_acc.setForeground(Color.WHITE);
			
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			
				
				btn_acc.setBackground(Color.BLACK);
			
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
			
				
				btn_acc.setBackground(Color.lightGray);
			
			}
		});
		btn_acc.setOpaque(true);
		btn_acc.setBackground(Color.BLACK);
		btn_acc.setHorizontalAlignment(SwingConstants.CENTER);
		btn_acc.setForeground(Color.WHITE);
		btn_acc.setBounds(1712, 514, 200, 63);
		frame.getContentPane().add(btn_acc);
		
		JLabel btn_addItems = new JLabel("TYPES");
		btn_addItems.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_addItems.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				
				btn_addItems.setBackground(Color.LIGHT_GRAY);
				btn_addItems.setBorder(new LineBorder(Color.BLACK,2));
				btn_addItems.setFont(new Font("Tahoma",Font.PLAIN,20));
				btn_addItems.setForeground(Color.BLACK);
			
			}
			@Override
			public void mouseExited(MouseEvent e) {
			
				
				btn_addItems.setBackground(Color.BLACK);
				btn_addItems.setBorder(null);
				btn_addItems.setFont(new Font("Tahoma",Font.PLAIN,16));
				btn_addItems.setForeground(Color.WHITE);
			
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
				
				btn_addItems.setBackground(Color.BLACK);
			
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
			
				
				btn_addItems.setBackground(Color.lightGray);
			
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				
				Shop_products.main(null);
			
			}
		});
		btn_addItems.setOpaque(true);
		btn_addItems.setBackground(Color.BLACK);
		btn_addItems.setForeground(Color.WHITE);
		btn_addItems.setHorizontalAlignment(SwingConstants.CENTER);
		btn_addItems.setBounds(1712, 286, 200, 63);
		frame.getContentPane().add(btn_addItems);
		
		btn_purchase = new JLabel("PURCHASE");
		btn_purchase.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_purchase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				
				Purchase.main(null);
			
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			
				
				btn_purchase.setBackground(Color.LIGHT_GRAY);
				btn_purchase.setBorder(new LineBorder(Color.BLACK,2));
				btn_purchase.setFont(new Font("Tahoma",Font.PLAIN,20));
				btn_purchase.setForeground(Color.BLACK);
			
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			
				
				btn_purchase.setBackground(Color.BLACK);
				btn_purchase.setFont(new Font("Tahoma",Font.PLAIN,16));
				btn_purchase.setForeground(Color.WHITE);
			
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			
				
				btn_purchase.setBackground(Color.BLACK);
			
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
			
				
				btn_purchase.setBackground(Color.lightGray);
			
			}
		});
		btn_purchase.setOpaque(true);
		btn_purchase.setHorizontalAlignment(SwingConstants.CENTER);
		btn_purchase.setForeground(Color.WHITE);
		btn_purchase.setBackground(Color.BLACK);
		btn_purchase.setBounds(1712, 362, 200, 63);
		frame.getContentPane().add(btn_purchase);
		
		btn_items = new JLabel("ITEMS");
		btn_items.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				Items.main(null);
			
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			
				
				btn_items.setBackground(Color.LIGHT_GRAY);
				btn_items.setBorder(new LineBorder(Color.BLACK,2));
				btn_items.setFont(new Font("Tahoma",Font.PLAIN,20));
				btn_items.setForeground(Color.BLACK);
			
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			
				
				btn_items.setBackground(Color.BLACK);
				btn_items.setFont(new Font("Tahoma",Font.PLAIN,16));
				btn_items.setForeground(Color.WHITE);
			
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			
				
				btn_items.setBackground(Color.BLACK);
			
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
			
				
				btn_items.setBackground(Color.lightGray);
			
			}
		});
		btn_items.setOpaque(true);
		btn_items.setHorizontalAlignment(SwingConstants.CENTER);
		btn_items.setForeground(Color.WHITE);
		btn_items.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_items.setBackground(Color.BLACK);
		btn_items.setBounds(1712, 438, 200, 63);
		frame.getContentPane().add(btn_items);
		   
		txt_history = new JLabel("");
		txt_history.setBackground(Color.DARK_GRAY);
		txt_history.setOpaque(true);
		txt_history.setHorizontalAlignment(SwingConstants.CENTER);
		txt_history.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				
				txt_history.setBackground(Color.BLUE);
				txt_history.setBorder(new LineBorder(Color.BLUE));
			
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			
				
				txt_history.setBackground(Color.DARK_GRAY);
				txt_history.setBorder(null);
			
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				
				Sale_history.main(null);
				
				
			}
		});
		txt_history.setToolTipText("History");
		txt_history.setBounds(0, 213, 155, 136);
		frame.getContentPane().add(txt_history);
		Image img3=new ImageIcon(this.getClass().getResource("/history.png")).getImage();
		txt_history.setIcon(new ImageIcon(img3));
		
		txt_img2 = new JLabel("");
		txt_img2.setBackground(Color.DARK_GRAY);
		txt_img2.setOpaque(true);
		txt_img2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				
				txt_img2.setBackground(Color.BLUE);
				txt_img2.setBorder(new LineBorder(Color.BLUE));
			
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			
				
				txt_img2.setBackground(Color.DARK_GRAY);
				txt_img2.setBorder(null);
			
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				
				Investments.main(null);
			
			}
		});
		txt_img2.setToolTipText("Investments");
		txt_img2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_img2.setBounds(0, 362, 155, 136);
		frame.getContentPane().add(txt_img2);
		Image img2=new ImageIcon(this.getClass().getResource("/investments.png")).getImage();
		txt_img2.setIcon(new ImageIcon(img2));
		
		txt_img3 = new JLabel("");
		txt_img3.setBackground(Color.DARK_GRAY);
		txt_img3.setOpaque(true);
		txt_img3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				
				txt_img3.setBackground(Color.BLUE);
				txt_img3.setBorder(new LineBorder(Color.BLUE));
			
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			
				
				txt_img3.setBackground(Color.DARK_GRAY);
				txt_img3.setBorder(null);
			
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				
				Balance.main(null);
			
			}
		});
		txt_img3.setToolTipText("Balance sheet");
		txt_img3.setHorizontalAlignment(SwingConstants.CENTER);
		txt_img3.setBounds(0, 511, 155, 136);
		frame.getContentPane().add(txt_img3);
		Image img=new ImageIcon(this.getClass().getResource("/balance.png")).getImage();
		txt_img3.setIcon(new ImageIcon(img));
		
		txt_img4 = new JLabel("");
		txt_img4.setBackground(Color.DARK_GRAY);
		txt_img4.setOpaque(true);
		txt_img4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				
				txt_img4.setBackground(Color.BLUE);
				txt_img4.setBorder(new LineBorder(Color.BLUE));
			
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			
				
				txt_img4.setBackground(Color.DARK_GRAY);
				txt_img4.setBorder(null);
			
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
			}
		});
		txt_img4.setToolTipText("Shop items");
		txt_img4.setHorizontalAlignment(SwingConstants.CENTER);
		txt_img4.setBounds(0, 660, 155, 146);
		frame.getContentPane().add(txt_img4);
		Image img4=new ImageIcon(this.getClass().getResource("/cart.png")).getImage();
		txt_img4.setIcon(new ImageIcon(img4));
		    
		txt_img5 = new JLabel("");
		txt_img5.setBackground(Color.DARK_GRAY);
		txt_img5.setOpaque(true);
		txt_img5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			
				
				txt_img5.setBackground(Color.BLUE);
				txt_img5.setBorder(new LineBorder(Color.BLUE));
			
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			
				
				txt_img5.setBackground(Color.DARK_GRAY);
				txt_img5.setBorder(null);
			
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				
				Sale_repport.main(null);
			
			}
		});
		txt_img5.setToolTipText("Sale repport");
		txt_img5.setHorizontalAlignment(SwingConstants.CENTER);
		txt_img5.setBounds(0, 819, 155, 146);
		frame.getContentPane().add(txt_img5);
		Image img5=new ImageIcon(this.getClass().getResource("/sale2.png")).getImage();
		txt_img5.setIcon(new ImageIcon(img5));
		
		txt_menu = new JLabel("");
		txt_menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				

				txt_acc.setVisible(true);
				txt_exit.setVisible(true);
				txt_body.setVisible(true);
				txt_cpsw.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			
			}
		});
		txt_menu.setHorizontalTextPosition(SwingConstants.CENTER);
		txt_menu.setHorizontalAlignment(SwingConstants.CENTER);
		txt_menu.setForeground(Color.WHITE);
		txt_menu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_menu.setBounds(1846, 0, 38, 56);
		frame.getContentPane().add(txt_menu);
		Image imgee=new ImageIcon(this.getClass().getResource("/menu4.png")).getImage();
		txt_menu.setIcon(new ImageIcon(imgee));
		
		txt_acc = new JLabel("Account");
		txt_acc.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txt_acc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				txt_acc.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				
				txt_acc.setBackground(Color.WHITE);
			}
		});
		txt_acc.setHorizontalAlignment(SwingConstants.CENTER);
		txt_acc.setOpaque(true);
		txt_acc.setBackground(Color.WHITE);
		txt_acc.setBounds(1726, 47, 171, 49);
		txt_acc.setVisible(false);
		frame.getContentPane().add(txt_acc);
		
		txt_exit = new JLabel("LogOut");
		txt_exit.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 0, 0)));
		txt_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Logout_screen.main(null);
				txt_body.setVisible(false);
				txt_acc.setVisible(false);
				txt_exit.setVisible(false);
				txt_cpsw.setVisible(false);
				frame.getContentPane().setBackground(Color.LIGHT_GRAY);
				txt_history.setVisible(false);
				txt_img2.setVisible(false);
				txt_img3.setVisible(false);
				txt_img4.setVisible(false);
				txt_img5.setVisible(false);
				txt_history.setBackground(Color.LIGHT_GRAY);
				txt_img2.setBackground(Color.LIGHT_GRAY);
				txt_img3.setBackground(Color.LIGHT_GRAY);
				txt_img4.setBackground(Color.LIGHT_GRAY);
				txt_img5.setBackground(Color.LIGHT_GRAY);
				btn_purchase.setVisible(false);
				btn_addItems.setVisible(false);
				btn_items.setVisible(false);
				btn_acc.setVisible(false);
				txt_lbl.setVisible(false);
				txt_menu.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				txt_exit.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				
				txt_exit.setBackground(Color.WHITE);
			}
		});
		txt_exit.setHorizontalAlignment(SwingConstants.CENTER);
		txt_exit.setOpaque(true);
		txt_exit.setBackground(Color.WHITE);
		txt_exit.setBounds(1726, 144, 171, 49);
		txt_exit.setVisible(false);
		frame.getContentPane().add(txt_exit);
		
		txt_cpsw = new JLabel("Change Password");
		txt_cpsw.setOpaque(true);
		txt_cpsw.setBackground(Color.WHITE);
		txt_cpsw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				Change_psw.main(null);
				txt_body.setVisible(false);
				txt_acc.setVisible(false);
				txt_exit.setVisible(false);
				txt_cpsw.setVisible(false);
				frame.getContentPane().setBackground(Color.LIGHT_GRAY);
				txt_history.setVisible(false);
				txt_img2.setVisible(false);
				txt_img3.setVisible(false);
				txt_img4.setVisible(false);
				txt_img5.setVisible(false);
				txt_history.setBackground(Color.LIGHT_GRAY);
				txt_img2.setBackground(Color.LIGHT_GRAY);
				txt_img3.setBackground(Color.LIGHT_GRAY);
				txt_img4.setBackground(Color.LIGHT_GRAY);
				txt_img5.setBackground(Color.LIGHT_GRAY);
				btn_purchase.setVisible(false);
				btn_addItems.setVisible(false);
				btn_items.setVisible(false);
				btn_acc.setVisible(false);
				txt_menu.setVisible(false);
				txt_head.setVisible(false);
				sale_status.setVisible(false);
				Balance_status.setVisible(false);
			
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				
				txt_cpsw.setBackground(Color.LIGHT_GRAY);
			
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			
				
				txt_cpsw.setBackground(Color.WHITE);
			
			}
		});
		txt_cpsw.setHorizontalAlignment(SwingConstants.CENTER);
		txt_cpsw.setBounds(1726, 95, 171, 49);
		frame.getContentPane().add(txt_cpsw);
		txt_cpsw.setVisible(false);
		
		txt_body = new JLabel("");
		txt_body.setOpaque(true);
		txt_body.setBackground(Color.DARK_GRAY);
		txt_body.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			
				
				txt_body.setVisible(false);
				txt_acc.setVisible(false);
				txt_exit.setVisible(false);
				txt_cpsw.setVisible(false);
			
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			
				
				txt_body.setVisible(true);
				txt_acc.setVisible(true);
				txt_exit.setVisible(true);
				txt_cpsw.setVisible(true);
			
			}
		});
		txt_body.setBounds(1715, 47, 197, 158);
		frame.getContentPane().add(txt_body);
		
		sale_status = new JLabel("687389");
		sale_status.setFont(new Font("Tahoma", Font.PLAIN, 38));
		sale_status.setHorizontalAlignment(SwingConstants.CENTER);
		sale_status.setOpaque(true);
		sale_status.setBounds(332, 220, 352, 102);
		frame.getContentPane().add(sale_status);
		
		Balance_status = new JLabel("83764576");
		Balance_status.setFont(new Font("Tahoma", Font.PLAIN, 38));
		Balance_status.setHorizontalAlignment(SwingConstants.CENTER);
		Balance_status.setOpaque(true);
		Balance_status.setBounds(779, 220, 352, 102);
		frame.getContentPane().add(Balance_status);
		
		JLabel sale_status_1 = new JLabel("74568789");
		sale_status_1.setFont(new Font("Tahoma", Font.PLAIN, 38));
		sale_status_1.setHorizontalAlignment(SwingConstants.CENTER);
		sale_status_1.setOpaque(true);
		sale_status_1.setBounds(332, 428, 352, 102);
		frame.getContentPane().add(sale_status_1);
		
		JLabel sale_status_2 = new JLabel("0938475");
		sale_status_2.setFont(new Font("Tahoma", Font.PLAIN, 38));
		sale_status_2.setHorizontalAlignment(SwingConstants.CENTER);
		sale_status_2.setOpaque(true);
		sale_status_2.setBounds(779, 428, 352, 102);
		frame.getContentPane().add(sale_status_2);
		
		JLabel lblNewLabel = new JLabel("Sale Status");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(332, 182, 102, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Balance Status");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(779, 182, 95, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Item Status");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(332, 386, 95, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(779, 386, 77, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_5 = new JLabel("CASHIER   :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(12, 13, 115, 25);
		frame.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(139, 12, 115, 30);
		frame.getContentPane().add(lblNewLabel_6);
		
		txt_head = new JLabel("SUPER MARKET");
		txt_head.setFont(new Font("Tahoma", Font.PLAIN, 34));
		txt_head.setHorizontalAlignment(SwingConstants.CENTER);
		txt_head.setBackground(SystemColor.activeCaption);
		txt_head.setOpaque(true);
		txt_head.setBounds(0, 0, 1924, 63);
		frame.getContentPane().add(txt_head);
		
		txt_home = new JLabel("");
		txt_home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				DashBoard.main(null);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				
				txt_home.setBackground(Color.BLUE);
				txt_home.setBorder(new LineBorder(Color.BLUE));
			
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			
				
				txt_home.setBackground(Color.DARK_GRAY);
				txt_home.setBorder(null);
			
			}
		});
		txt_home.setBackground(Color.DARK_GRAY);
		txt_home.setOpaque(true);
		txt_home.setHorizontalAlignment(SwingConstants.CENTER);
		txt_home.setBounds(0, 78, 145, 122);
		frame.getContentPane().add(txt_home);
		txt_body.setVisible(false);
		
		Image home=new ImageIcon(this.getClass().getResource("/home.png")).getImage();
		txt_home.setIcon(new ImageIcon(home));
		
	}
}
