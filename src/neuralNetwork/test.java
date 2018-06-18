package neuralNetwork;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.imgrec.ColorMode;
import org.neuroph.imgrec.FractionRgbData;
import org.neuroph.imgrec.ImageRecognitionHelper;
import org.neuroph.imgrec.image.Dimension;
import org.neuroph.nnet.learning.MomentumBackpropagation;
import org.neuroph.util.TransferFunctionType;


public class test {
    
    public static void main(String[] args) throws IOException {
        
       
        String imageDir ="/root/minecraft/neural/Dogs/";
        
      
        List<String> imageLabels = new ArrayList();                                                  
        imageLabels.add("Dalmatinec");
        imageLabels.add("Jork");
        imageLabels.add("Korgi");
        imageLabels.add("Labrador");
        imageLabels.add("Mops");
        imageLabels.add("Ovcharka");
        imageLabels.add("Pydel");              
        imageLabels.add("Shpic");
        
        Map<String,FractionRgbData> map = ImageRecognitionHelper.getFractionRgbDataForDirectory (new File(imageDir), new Dimension(25, 25));
        DataSet dataSet = ImageRecognitionHelper.createRGBTrainingSet(imageLabels, map);

        List <Integer> hiddenLayers = new ArrayList<>();
        hiddenLayers.add(32);
        hiddenLayers.add(16);
        NeuralNetwork nnet = ImageRecognitionHelper.createNewNeuralNetwork("someNetworkName", new Dimension(25,25), ColorMode.COLOR_RGB, imageLabels, hiddenLayers, TransferFunctionType.SIGMOID);

        MomentumBackpropagation mb = (MomentumBackpropagation)nnet.getLearningRule();
        mb.setMaxIterations(100000);
        mb.setLearningRate(0.2);
        mb.setMaxError(0.01);
        mb.setMomentum(1);
      
        // train network
        long time=System.currentTimeMillis();
        System.out.println("NNet start learning...");
            	nnet.learn(dataSet);

        System.out.println("NNet learned in " + (System.currentTimeMillis()-time) +"ms");   
        nnet.save("/root/minecraft/neural/Dogs_10_32_16.nnet");
        System.exit(0);
    }
    
}