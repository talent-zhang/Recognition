package controller;

import java.awt.Dimension;
import java.awt.Toolkit;

public class locationController {
	private int screenHeight;
	private int screenWidth;
	private Dimension screenSize;
	private Toolkit kit;

	public locationController() {
		kit = Toolkit.getDefaultToolkit();
		screenSize = kit.getScreenSize();
		screenHeight = screenSize.height;
		screenWidth = screenSize.width;
	}

	public int getHeight() {
		return screenHeight;
	}

	public int getWidth() {
		return screenWidth;
	}
}
