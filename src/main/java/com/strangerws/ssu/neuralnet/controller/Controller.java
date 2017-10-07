package com.strangerws.ssu.neuralnet.controller;

import com.strangerws.ssu.neuralnet.model.NeuralNet;
import com.strangerws.ssu.neuralnet.model.element.Perceptron;
import com.strangerws.ssu.neuralnet.utils.ImageAnalyzer;

import java.io.*;

public class Controller {

    private NeuralNet net;

    public NeuralNet getNet() {
        return net;
    }

    public Controller(NeuralNet net) {
        this.net = net;
    }

    public static int[][] readFileToArray(String fileName) {
        int[][] array = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            array = new int[16][16];
            int k = 0;
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(" ");
                for (int i = 0; i < arr.length; i++) {
                    array[i][k] = Integer.parseInt(arr[i]);
                }
                k++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    public static void saveArrayToFile(String fileName, int[][] array) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < array[0].length; i++) {
                for (int j = 0; j < array.length; j++) {
                    writer.write(array[j][i] + " ");
                }
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fill() {
        for (int i = 0; i < net.getLength(); i++) {
            Perceptron perceptron = new Perceptron(16, 16,ImageAnalyzer.analyze("C:\\Users\\StrangerWS\\IdeaProjects\\NeuralNetCourseWork\\src\\main\\resources\\image-big\\image" + i + "-1.jpg"));
            perceptron.setWeights(readFileToArray("C:\\Users\\StrangerWS\\IdeaProjects\\NeuralNetCourseWork\\src\\main\\resources\\memory\\memory" + i + ".txt"));
            net.getNet().add(perceptron);
        }
    }

    public void learn() {
        for (int i = 0; i < net.getLength(); i++) {
            System.out.println("Perceptron for " + i);
            for (int k = 0; k < net.getLength(); k++) {
                for (int j = 1; j < 6; j++) {
                    Perceptron perceptron = net.getNet().get(i);
                    perceptron.setInput(ImageAnalyzer.analyze("C:\\Users\\StrangerWS\\IdeaProjects\\NeuralNetCourseWork\\src\\main\\resources\\image-big\\image" + k + "-" + j + ".jpg"));
                    perceptron.setWeights(readFileToArray("C:\\Users\\StrangerWS\\IdeaProjects\\NeuralNetCourseWork\\src\\main\\resources\\memory\\memory" + i + ".txt"));
                    System.out.print("\t" + k +" - " + j);
                    if (perceptron.analyze()) {
                        System.out.print(" True ,");
                        if (k != i) {
                            perceptron.changeWeights(true);
                        }
                    } else {
                        System.out.print(" False,");
                        if (k == i) {
                            perceptron.changeWeights(false);
                        }
                    }

                    //System.out.print("sum:" + perceptron.getSum());
                    saveArrayToFile("C:\\Users\\StrangerWS\\IdeaProjects\\NeuralNetCourseWork\\src\\main\\resources\\memory\\memory" + i + ".txt", perceptron.getWeights());
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void forget() {
        int[][] array = new int[16][16];
        for (int i = 0; i < 10; i++) {
            saveArrayToFile("C:\\Users\\StrangerWS\\IdeaProjects\\NeuralNetCourseWork\\src\\main\\resources\\memory\\memory" + i + ".txt", array);
        }
    }

}
