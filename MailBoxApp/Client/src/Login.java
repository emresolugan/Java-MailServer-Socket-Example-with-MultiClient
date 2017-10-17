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
import java.awt.Font;

public class Login extends JFrame {

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
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("E-Mail");
		lblNewLabel.setBounds(39, 96, 46, 14);
		contentPane.add(lblNewLabel);
		

		
		txt_mail = new JTextField();
		txt_mail.setBounds(117, 93, 98, 20);
		contentPane.add(txt_mail);
		txt_mail.setColumns(10);
		
		JButton btn_giris = new JButton("Giri\u015F Yap");
		
		btn_giris.setBounds(117, 173, 98, 23);
		contentPane.add(btn_giris);
		
		JLabel lblGiri = new JLabel("G\u0130R\u0130\u015E");
		lblGiri.setBounds(198, 56, 46, 14);
		contentPane.add(lblGiri);
		
		txt_password = new JTextField();
		txt_password.setBounds(117, 124, 199, 20);
		contentPane.add(txt_password);
		txt_password.setColumns(10);
		
		JLabel lblParola = new JLabel("Parola");
		lblParola.setBounds(39, 127, 46, 14);
		contentPane.add(lblParola);
		
		txtmailcom = new JTextField();
		txtmailcom.setEditable(false);
		txtmailcom.setText("@mail.com");
		txtmailcom.setBounds(230, 93, 86, 20);
		contentPane.add(txtmailcom);
		txtmailcom.setColumns(10);
		
		JButton btn_register = new JButton("Kay\u0131t");
		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register reg = new Register();
				reg.setVisible(true);
                setVisible(false);
			}
		});
		btn_register.setBounds(225, 173, 91, 23);
		contentPane.add(btn_register);
		
		JLabel lblalert = new JLabel("");
		lblalert.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblalert.setBounds(98, 21, 264, 24);
		contentPane.add(lblalert);
		
		btn_giris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String s = txt_mail.getText() + txtmailcom.getText() + " " + txt_password.getText();
				try {
					if(Client.Login(s) == true)
					{
				    	String [] str = s.split(" ");
				    	MainMenu m = new MainMenu(str[0]);
				    	m.setVisible(true);	
				    	setVisible(false);
					}
					
					else
					{
						lblalert.setText("Girdiðiniz bilgilere göre kayýt bulunamadý.");
					}
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
	}
}
