package windows;

import java.awt.BorderLayout;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.mainController;
import email.JavaEmail;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class closeWindow extends JFrame {
	private String message;
	private JPanel contentPane;

	public closeWindow() {
		setTitle("Уже уходите? Оставьте пожелания разработчику!");
		setSize(500, 220);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JTextPane txtpnO = new JTextPane();
		txtpnO.setBackground(new Color(240, 248, 255));
		txtpnO.setFont(new Font("Century Schoolbook L", Font.BOLD, 18));
		contentPane.add(txtpnO, BorderLayout.CENTER);
		JButton btnNewButton = new JButton("Отправить");
		btnNewButton.setIcon(new ImageIcon(getClass().getResource("/resources/button.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				message = txtpnO.getText();
				try {
					JavaEmail.send(message);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Century Schoolbook L", Font.BOLD, 15));
		contentPane.add(btnNewButton, BorderLayout.SOUTH);

	}

}
