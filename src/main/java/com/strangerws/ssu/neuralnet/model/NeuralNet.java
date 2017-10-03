package com.strangerws.ssu.neuralnet.model;

import java.util.ArrayList;
import java.util.List;

//public class NeuralNet {
//    List<Neuron> net;
//
//    public List<Character> result(){
//        List<Character> array = new ArrayList<>();
//        for (int i = 0; i < net.size(); i++) {
//            if (net.get(i).resolve()){
//                array.add((char) i);
//            }
//        }
//        return array;
//    }
//}

public class NeuralNet {
    private List<Neuron> net = new ArrayList<>();
    private int length;

    public int getLength() {
        return length;
    }

    public List<Neuron> getNet() {
        return net;
    }

    public NeuralNet(int length) {
        this.length = length;
    }

    public List<Integer> analyze(int[][] input){
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < net.size(); i++) {
            Neuron tmp = net.get(i);
            tmp.setInput(input);
            if(tmp.analyze()) array.add(i);
        }
        return array;
    }
}
