package Basic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Ccalculator {

	private JFrame frame;
	private JTextField txt_screen;
	private JTextField txt_operation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ccalculator window = new Ccalculator();
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
	public Ccalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 454, 387);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btn_1 = new JButton("1");
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String num1=txt_screen.getText() + btn_1.getText();
				
				txt_screen.setText(num1);
				
			}
		});
		btn_1.setBounds(12, 138, 60, 39);
		frame.getContentPane().add(btn_1);
		
		JButton btn_2 = new JButton("2");
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String num2=txt_screen.getText() + btn_2.getText();
			txt_screen.setText(num2);
				
			}
		});
		btn_2.setBounds(85, 138, 54, 39);
		frame.getContentPane().add(btn_2);
		
		JButton btn_3 = new JButton("3");
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String num3=txt_screen.getText() + btn_3.getText();
				txt_screen.setText(num3);
				
			}
		});
		btn_3.setBounds(151, 138, 60, 39);
		frame.getContentPane().add(btn_3);
		
		JButton btn_4 = new JButton("4");
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String num4=txt_screen.getText() + btn_4.getText();
				txt_screen.setText(num4);
				
			}
		});
		btn_4.setBounds(12, 190, 60, 40);
		frame.getContentPane().add(btn_4);
		
		JButton btn_5 = new JButton("5");
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String num5=txt_screen.getText() + btn_5.getText();
				txt_screen.setText(num5);
				
			}
		});
		btn_5.setBounds(85, 191, 60, 39);
		frame.getContentPane().add(btn_5);
		
		JButton btn_6 = new JButton("6");
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String num6=txt_screen.getText() + btn_6.getText();
				txt_screen.setText(num6);
				
			}
		});
		btn_6.setBounds(151, 191, 60, 39);
		frame.getContentPane().add(btn_6);
		
		JButton btn_7 = new JButton("7");
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String num7=txt_screen.getText() + btn_7.getText();
				txt_screen.setText(num7);
				
			}
		});
		btn_7.setBounds(12, 243, 60, 39);
		frame.getContentPane().add(btn_7);
		
		JButton btn_8 = new JButton("8");
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String num8=txt_screen.getText() + btn_8.getText();
				txt_screen.setText(num8);
				
			}
		});
		btn_8.setBounds(85, 243, 60, 39);
		frame.getContentPane().add(btn_8);
		
		JButton btn_9 = new JButton("9");
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String num9=txt_screen.getText() + btn_9.getText();
				txt_screen.setText(num9);
				
			}
		});
		btn_9.setBounds(151, 243, 60, 39);
		frame.getContentPane().add(btn_9);
		
		JButton btn_0 = new JButton("0");
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String num0=txt_screen.getText() + btn_0.getText();
				txt_screen.setText(num0);
				
			}
		});
		btn_0.setBounds(85, 295, 60, 40);
		frame.getContentPane().add(btn_0);
		
		JButton btn_equal = new JButton("=");
		btn_equal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btn_equal.setBounds(151, 295, 60, 40);
		frame.getContentPane().add(btn_equal);
		
		JButton btn_clear = new JButton("C");
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txt_screen.setText(null);
				
			}
		});
		btn_clear.setBounds(12, 295, 60, 36);
		frame.getContentPane().add(btn_clear);
		
		JButton btn_add = new JButton("+");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String add=btn_add.getText();
				txt_operation.setText(add);
				
			}
		});
		btn_add.setBounds(236, 138, 71, 39);
		frame.getContentPane().add(btn_add);
		
		JButton btn_sub = new JButton("-");
		btn_sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sub=btn_sub.getText();
				txt_operation.setText(sub);
				
			}
		});
		btn_sub.setBounds(236, 191, 71, 39);
		frame.getContentPane().add(btn_sub);
		
		JButton btn_mul = new JButton("*");
		btn_mul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String mul=btn_mul.getText();
				txt_operation.setText(mul);
				
			}
		});
		btn_mul.setBounds(236, 243, 71, 39);
		frame.getContentPane().add(btn_mul);
		
		JButton btn_div = new JButton("/");
		btn_div.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String div=btn_div.getText();
				txt_operation.setText(div);
				
			}
		});
		btn_div.setBounds(236, 295, 71, 40);
		frame.getContentPane().add(btn_div);
		
		txt_screen = new JTextField();
		txt_screen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String once=btn_1.getName();
				
				//String num=btn_1.setText(one);
				System.out.println(once);
				//txt_screen.setText(num);
			}
		});
		txt_screen.setBounds(61, 59, 188, 30);
		frame.getContentPane().add(txt_screen);
		txt_screen.setColumns(10);
		
		txt_operation = new JTextField();
		txt_operation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		txt_operation.setBounds(261, 55, 60, 39);
		frame.getContentPane().add(txt_operation);
		txt_operation.setColumns(10);
	}
}
