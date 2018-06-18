package windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.mainController;

import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class chooseErrorWindow extends JFrame {

	private JPanel contentPane;
	public chooseErrorWindow() {
		setSize(498, 181);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Century Schoolbook L", Font.BOLD, 15));
		textPane.setText("Некорректное изображение! Попробуйте еще раз.");
		textPane.setEditable(false);
		contentPane.add(textPane, BorderLayout.CENTER);
		JButton btnNewButton = new JButton("OK!");
		btnNewButton.setIcon(new ImageIcon(getClass().getResource("/resources/button.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainController.chooseErrorWindow.setVisible(false);
			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Century Schoolbook L", Font.BOLD, 15));
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
	}

}
