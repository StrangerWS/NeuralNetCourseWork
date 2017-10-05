package com.strangerws.ssu.neuralnet;

import com.strangerws.ssu.neuralnet.controller.Controller;
import com.strangerws.ssu.neuralnet.model.NeuralNet;
import com.strangerws.ssu.neuralnet.utils.ImageAnalyzer;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new NeuralNet(10));

        controller.fill();
        Controller.forget();
        for (int k = 0; k < 100; k++) {
            System.out.println("Epoch #" + (k + 1));
            controller.learn();
        }

        System.out.println("Tests over");

        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < 6; j++) {
                System.out.println(controller.getNet().analyze(ImageAnalyzer.analyze("C:\\Users\\StrangerWS\\IdeaProjects\\NeuralNetCourseWork\\src\\main\\resources\\image-big\\image" + i + "-" + j + ".jpg")));
            }
        }

    }
}
