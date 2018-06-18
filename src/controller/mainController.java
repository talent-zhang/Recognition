package controller;

import org.neuroph.core.NeuralNetwork;

import neuralNetwork.imageRecognition;
import neuralNetwork.importNet;
import parser.parserResult;
import windows.closeWindow;
import windows.mainWindow;
import windows.chooseErrorWindow;
import windows.chooseWindow;
import windows.welcomeWindow;

public class mainController {
	public static welcomeWindow welcomeWindow;
	public static mainWindow mainWindow;
	public static closeWindow closeWindow;
	//public static chooseWindow chooseWindow;
	public static updateWindow updateWindow;
	public static chooseErrorWindow chooseErrorWindow;
	public static importNet importNet;
	public static String nameNet;
	public static locationController locationWindows;
	public static int height;
	public static int widht;
	public static NeuralNetwork nnet;
	public static imageRecognition recognition;
	public static parserResult parserResult;

	public static void startInit() {
		locationWindows = new locationController();
		height = locationWindows.getHeight();
		widht = locationWindows.getWidth();
		welcomeWindow = new welcomeWindow();
	}
	public static void optInit() {
		mainWindow = new mainWindow();
		closeWindow = new closeWindow();
		nameNet = "/resources/Dogs2.nnet";
		importNet = new importNet(nameNet);
		recognition = new imageRecognition();
		parserResult = new parserResult();
		//chooseWindow = new chooseWindow();
		chooseErrorWindow = new chooseErrorWindow();
		updateWindow = new updateWindow();
	}
}
