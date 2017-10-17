import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class GelenMail extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GelenMail frame = new GelenMail("s");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public GelenMail(String mail_kimden) throws IOException {
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
		
	    txt_inbox.setText(Client.gelen_maili_goster(mail_kimden) + "\n");
		contentPane.add(txt_inbox);
	}
}
