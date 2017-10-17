import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txt_mail;
	private JTextField txt_password;
	private JTextField txtmailcom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKayot = new JLabel("KAYIT");
		lblKayot.setBounds(192, 43, 46, 14);
		contentPane.add(lblKayot);
		
		txt_mail = new JTextField();
		txt_mail.setBounds(109, 92, 99, 20);
		contentPane.add(txt_mail);
		txt_mail.setColumns(10);
		
		txt_password = new JTextField();
		txt_password.setBounds(109, 123, 199, 20);
		contentPane.add(txt_password);
		txt_password.setColumns(10);
		
		txtmailcom = new JTextField();
		txtmailcom.setText("@mail.com");
		txtmailcom.setBounds(218, 92, 90, 20);
		contentPane.add(txtmailcom);
		txtmailcom.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setBounds(32, 95, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(32, 127, 46, 14);
		contentPane.add(lblPassword);
		 
		JButton btn_register = new JButton("Kay\u0131t");
		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String s = txt_mail.getText() + txtmailcom.getText() + " " + txt_password.getText() + "\n";
				try {
					setVisible(false);
					Client.Register(s);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_register.setBounds(168, 168, 89, 23);
		contentPane.add(btn_register);
	}
}
