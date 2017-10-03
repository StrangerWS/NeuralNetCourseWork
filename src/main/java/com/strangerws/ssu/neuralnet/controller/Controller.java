package com.strangerws.ssu.neuralnet.controller;

import com.strangerws.ssu.neuralnet.model.NeuralNet;
import com.strangerws.ssu.neuralnet.model.Neuron;

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
            array = new int[3][5];
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
            Neuron neuron = new Neuron(3, 5, readFileToArray("C:\\Users\\StrangerWS\\IdeaProjects\\NeuralNetCourseWork\\src\\main\\resources\\image\\image" + i + ".txt"));
            neuron.setWeights(readFileToArray("C:\\Users\\StrangerWS\\IdeaProjects\\NeuralNetCourseWork\\src\\main\\resources\\memory\\memory" + i + ".txt"));
            net.getNet().add(neuron);
        }
    }

    public void learn() {
        for (int i = 0; i < net.getLength(); i++) {
            System.out.print("Neuron for " + i);
            for (int k = 0; k < net.getLength(); k++) {
                Neuron neuron = net.getNet().get(i);
                neuron.setInput(readFileToArray("C:\\Users\\StrangerWS\\IdeaProjects\\NeuralNetCourseWork\\src\\main\\resources\\image\\image" + k + ".txt"));
                neuron.setWeights(readFileToArray("C:\\Users\\StrangerWS\\IdeaProjects\\NeuralNetCourseWork\\src\\main\\resources\\memory\\memory" + i + ".txt"));
                System.out.print("\t" + k);
                if (neuron.analyze()) {
                    System.out.print(" True ,");
                    if (k != i) {
                        neuron.changeWeights(true);
                    }
                } else {
                    System.out.print(" False,");
                    if (k == i) {
                        neuron.changeWeights(false);
                    }
                }

                //System.out.print("sum:" + neuron.getSum());
                saveArrayToFile("C:\\Users\\StrangerWS\\IdeaProjects\\NeuralNetCourseWork\\src\\main\\resources\\memory\\memory" + i + ".txt", neuron.getWeights());
            }
            System.out.println();
        }
    }

    public static void forget() {
        int[][] array = new int[3][5];
        for (int i = 0; i < 10; i++) {
            saveArrayToFile("C:\\Users\\StrangerWS\\IdeaProjects\\NeuralNetCourseWork\\src\\main\\resources\\memory\\memory" + i + ".txt", array);
        }
    }

}
