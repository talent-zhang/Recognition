package neuralNetwork;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import org.neuroph.imgrec.ImageRecognitionPlugin;

import controller.mainController;

public class imageRecognition {
	private String result;

	public void recognitionFile(String image) {
		ImageRecognitionPlugin imageRecognition = (ImageRecognitionPlugin) mainController.nnet
				.getPlugin(ImageRecognitionPlugin.class);

		try {
			HashMap<String, Double> output = imageRecognition.recognizeImage(new File(image));
			this.result = output.toString();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void recognitionUrl(String url) {
		ImageRecognitionPlugin imageRecognition = (ImageRecognitionPlugin) mainController.nnet
				.getPlugin(ImageRecognitionPlugin.class);

		try {
			HashMap<String, Double> output = imageRecognition.recognizeImage(new URL(url));
			this.result = output.toString();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public String getResult() {
		return result;
	}
}
