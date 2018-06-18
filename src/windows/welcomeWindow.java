package windows;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.mainController;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class welcomeWindow extends JFrame {

	private JPanel contentPane;

	public welcomeWindow() {
		setSize(498, 181);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("Вперед!");
		btnNewButton.setIcon(new ImageIcon(getClass().getResource("/resources/button.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainController.optInit();
				mainController.welcomeWindow.setVisible(false);
				mainController.mainWindow.setVisible(true);
				mainController.mainWindow.closeEvent();
				mainController.importNet.importNetName();
			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Century Schoolbook L", Font.BOLD, 15));
		contentPane.add(btnNewButton, BorderLayout.SOUTH);

		JTextPane txtpnO = new JTextPane();
		txtpnO.setBackground(new Color(240, 248, 255));
		txtpnO.setEditable(false);
		txtpnO.setFont(new Font("Century Schoolbook L", Font.BOLD, 18));
		txtpnO.setText("Программа DogsRecognition приветствует Вас!");
		contentPane.add(txtpnO, BorderLayout.CENTER);

	}

}
