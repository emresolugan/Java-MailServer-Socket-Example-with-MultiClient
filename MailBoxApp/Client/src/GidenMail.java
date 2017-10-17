import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class GidenMail extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GidenMail frame = new GidenMail("s");
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
	public GidenMail(String mail_kimden) throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_mainmenu = new JButton("Ana Men\u00FCye D\u00F6n");
		btn_mainmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MainMenu m = new MainMenu(mail_kimden);
				m.setVisible(true);
				setVisible(false);				  
			}
		});
		btn_mainmenu.setBounds(410, 256, 128, 23);
		contentPane.add(btn_mainmenu);
		
		JTextArea txt_inbox = new JTextArea();
		txt_inbox.setEditable(false);
		txt_inbox.setBounds(10, 11, 964, 222);
		
	    txt_inbox.setText(Client.giden_maili_goster(mail_kimden) + "\n");
		contentPane.add(txt_inbox);
	}

}
