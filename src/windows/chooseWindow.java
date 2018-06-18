package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.mainController;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class chooseWindow extends JFrame {

	private JPanel contentPane;
	private FileFilter filter = new FileNameExtensionFilter("PNG file", "png");
	private String result;
	private String parseResult;
	private JFileChooser fileopen = new JFileChooser();;
	private int ret;
	private File file;
	private String path;
	private String url;

	public chooseWindow() {
		setSize(430, 50);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JTextPane textPane = new JTextPane();
		contentPane.add(textPane, BorderLayout.NORTH);
		textPane.setVisible(false);

		JButton btnNewButton_2 = new JButton("OK");
		btnNewButton_2.setBackground(Color.WHITE);

		contentPane.add(btnNewButton_2, BorderLayout.CENTER);
		btnNewButton_2.setVisible(false);

		JButton btnNewButton = new JButton("Файл");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileopen.setFileFilter(filter);
				ret = fileopen.showDialog(null, "Открыть файл");
				if (ret == JFileChooser.APPROVE_OPTION) {
					file = fileopen.getSelectedFile();
					path = file.getPath();
					try {
						mainController.recognition.recognitionFile(path);
						result = mainController.recognition.getResult();
						mainController.parserResult.parse(result);
						parseResult = mainController.parserResult.getResult();
						mainController.mainWindow.getTextPane().setText(parseResult);
						mainController.mainWindow.getImagePanel().setLayout(new BorderLayout());
						mainController.mainWindow.getImagePanel().setImage(ImageIO.read(new File(path)));
						mainController.updateWindow.chooseWindow.setVisible(false);
					} catch (Exception ed) {
						mainController.chooseErrorWindow.setVisible(true);
					}
				}
			}
		});
		contentPane.add(btnNewButton, BorderLayout.WEST);

		JButton btnNewButton_1 = new JButton("Ссылка");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setVisible(true);
				btnNewButton_2.setVisible(true);

			}
		});
		contentPane.add(btnNewButton_1, BorderLayout.EAST);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				url = textPane.getText();
				try {
					mainController.recognition.recognitionUrl(url);
					result = mainController.recognition.getResult();
					mainController.parserResult.parse(result);
					parseResult = mainController.parserResult.getResult();
					mainController.mainWindow.getTextPane().setText(parseResult);
					mainController.mainWindow.getImagePanel().setLayout(new BorderLayout());
					mainController.mainWindow.getImagePanel().setImage(ImageIO.read(new URL(url)));
					btnNewButton_2.setVisible(false);
					textPane.setText("");
					textPane.setVisible(false);
					mainController.updateWindow.chooseWindow.setVisible(false);
				} catch (Exception es) {
					mainController.chooseErrorWindow.setVisible(true);
				}
			}
		});

	}

}
