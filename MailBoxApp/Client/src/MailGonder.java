import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MailGonder extends JFrame {

	private JPanel contentPane;
	private JTextField txt_kime;
	private JTextField txt_konu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MailGonder frame = new MailGonder("mail");
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
	public MailGonder(String mail_kimden) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_kime = new JTextField();
		txt_kime.setBounds(107, 41, 222, 20);
		contentPane.add(txt_kime);
		txt_kime.setColumns(10);
		
		txt_konu = new JTextField();
		txt_konu.setBounds(106, 72, 223, 20);
		contentPane.add(txt_konu);
		txt_konu.setColumns(10);
		
		JTextArea txt_mesaj = new JTextArea();
		txt_mesaj.setBounds(107, 103, 222, 73);
		contentPane.add(txt_mesaj);
		
		JButton btn_gonder = new JButton("G\u00F6nder");
		btn_gonder.setBounds(178, 192, 89, 23);
		contentPane.add(btn_gonder);
		
		JLabel lblNewLabel = new JLabel("Kime");
		lblNewLabel.setBounds(25, 44, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Konu");
		lblNewLabel_1.setBounds(25, 75, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mesaj");
		lblNewLabel_2.setBounds(25, 103, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lbl_alert = new JLabel("Mail g\u00F6nderildi anamen\u00FCye d\u00F6nmek i\u00E7in butona t\u0131klay\u0131n\u0131z.");
		lbl_alert.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_alert.setBounds(0, 226, 333, 20);
		lbl_alert.setVisible(false);
		contentPane.add(lbl_alert);
		
		JButton btn_Mainmenu = new JButton("AnaMen\u00FC");
		btn_Mainmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu m = new MainMenu(mail_kimden);
				m.setVisible(true);
				setVisible(false);
			}
		});
		btn_Mainmenu.setBounds(335, 226, 89, 23);
		btn_Mainmenu.setVisible(false);
		contentPane.add(btn_Mainmenu);
		
		btn_gonder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Client client = new Client();
				try {
					if(Client.mail_gonder(mail_kimden,txt_kime.getText(),txt_konu.getText(),txt_mesaj.getText()) == true)
					{
						btn_Mainmenu.setVisible(true);
						lbl_alert.setVisible(true);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
