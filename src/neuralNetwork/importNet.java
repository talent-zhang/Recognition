package neuralNetwork;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.imgrec.ImageRecognitionPlugin;

import controller.mainController;

public class importNet {
	private String nameNet;

	public importNet(String nameNet) {
		this.nameNet = nameNet;
	}

	public void importNetName() {
		InputStream is = this.getClass().getResourceAsStream(nameNet);
		mainController.nnet = NeuralNetwork.load(is);
	}
}
