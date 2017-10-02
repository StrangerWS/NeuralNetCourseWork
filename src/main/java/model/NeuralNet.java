package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DobryninAM on 02.10.2017.
 */
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
            if(tmp.resolve()) array.add(i);
        }
        return array;
    }
}
