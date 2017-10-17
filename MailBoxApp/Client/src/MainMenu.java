import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JLabel;

public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu("mail");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu(String mail_kimden) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbleft = new JLabel("New label");
		lbleft.setBounds(10, 12, 225, 225);
		contentPane.add(lbleft);
		lbleft.setIcon(new javax.swing.ImageIcon(".\\pictures\\left.png"));
		
		JLabel lblright = new JLabel("New label");
		lblright.setBounds(396, 12, 225, 225);
		contentPane.add(lblright);
		lblright.setIcon(new javax.swing.ImageIcon(".\\pictures\\right.png"));
		
		JButton btn_mail_income = new JButton("Gelen Mailler");
		btn_mail_income.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GelenMail g = null;
				try {
					g = new GelenMail(mail_kimden);
					g.setVisible(true);
					setVisible(false);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_mail_income.setBounds(245, 12, 141, 50);
		contentPane.add(btn_mail_income);
		
		JButton btn_mail_sent = new JButton("Giden Mailler");
		btn_mail_sent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GidenMail g;
				try {
					g = new GidenMail(mail_kimden);
					g.setVisible(true);
					setVisible(false);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_mail_sent.setBounds(245, 73, 141, 50);
		contentPane.add(btn_mail_sent);
		
		JButton btn_mail_send = new JButton("Mail G\u00F6nder");
		btn_mail_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MailGonder m = new MailGonder(mail_kimden);
				m.setVisible(true);
				setVisible(false);
			}
		});
		btn_mail_send.setBounds(245, 134, 141, 50);
		contentPane.add(btn_mail_send);
		
		JButton btn_quit = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btn_quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
				try {
					Client.gelen_maili_goster(mail_kimden);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btn_quit.setBounds(245, 195, 141, 50);
		contentPane.add(btn_quit);
	}
}
