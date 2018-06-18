package windows;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import controller.mainController;
import javax.swing.border.BevelBorder;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.CardLayout;


public class mainWindow extends JFrame {

	private JPanel contentPane;
	private Graphics g;
	private Image image;

	private JTextPane textPane;
	private imagePanel pp;

	public mainWindow() {
		
		setBackground(Color.WHITE);
		setSize(900, 600);
		setLocationByPlatform(true);
		setLocationRelativeTo(null);

		setTitle("DogsRecognition");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JProgressBar progressBar = new JProgressBar();
		contentPane.add(progressBar, BorderLayout.NORTH);
		// backgroundImage backPanel = new backgroundImage(new
		// ImageIcon("back.png").getImage());
		// contentPane.add(backPanel);
		// backPanel.setLayout(new CardLayout(0, 0));

		pp = new imagePanel();
		pp.setBackground(Color.WHITE);

		JPanel panel = new JPanel();
		panel.setLayout(new java.awt.GridLayout());
		panel.setOpaque(false);
		pp.add(panel, java.awt.BorderLayout.NORTH);
		pp.setPreferredSize(new Dimension(500, 500));
		contentPane.add(new JScrollPane(pp));

		textPane = new JTextPane();
		textPane.setBackground(new Color(240, 248, 255));
		textPane.setEditable(false);
		textPane.setFont(new Font("Century Schoolbook L", Font.LAYOUT_NO_LIMIT_CONTEXT, 20));
		contentPane.add(textPane, BorderLayout.WEST);
		JButton btnNewButton = new JButton("Выбрать фото");
		btnNewButton.setIcon(new ImageIcon(getClass().getResource("/resources/button.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainController.updateWindow.createChooseWindow();
				mainController.updateWindow.chooseWindow.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Century Schoolbook L", Font.BOLD, 20));
		btnNewButton.setBackground(Color.WHITE);
		contentPane.add(btnNewButton, BorderLayout.SOUTH);

	}

	public void closeEvent() {
		if (mainController.mainWindow.isVisible() == true) {

			mainController.mainWindow.addWindowListener(new java.awt.event.WindowAdapter() {
				@Override
				public void windowClosing(java.awt.event.WindowEvent windowEvent) {
					mainController.closeWindow.setVisible(true);
				}
			});

		}
	}

	public imagePanel getImagePanel() {
		return pp;
	}

	public JTextPane getTextPane() {
		return textPane;
	}

}
