import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class MailOku extends JFrame {

	private JPanel contentPane;
	private JTextField txt_kimden;
	private JTextField txt_konu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MailOku frame = new MailOku();
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
	public MailOku() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_kimden = new JTextField();
		txt_kimden.setBounds(120, 45, 216, 20);
		contentPane.add(txt_kimden);
		txt_kimden.setColumns(10);
		
		txt_konu = new JTextField();
		txt_konu.setBounds(120, 77, 216, 20);
		contentPane.add(txt_konu);
		txt_konu.setColumns(10);
		
		JTextArea txt_mesaj = new JTextArea();
		txt_mesaj.setBounds(120, 120, 216, 111);
		contentPane.add(txt_mesaj);
		
		JLabel lblKimden = new JLabel("Kimden");
		lblKimden.setBounds(36, 48, 46, 14);
		contentPane.add(lblKimden);
		
		JLabel lblKonu = new JLabel("Konu");
		lblKonu.setBounds(36, 80, 46, 14);
		contentPane.add(lblKonu);
		
		JLabel lblMesaj = new JLabel("Mesaj");
		lblMesaj.setBounds(36, 120, 46, 14);
		contentPane.add(lblMesaj);
	}

}
