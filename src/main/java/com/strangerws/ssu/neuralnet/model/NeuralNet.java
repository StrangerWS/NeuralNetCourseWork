package com.strangerws.ssu.neuralnet.model;

import com.strangerws.ssu.neuralnet.model.element.Perceptron;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс Нейронная сеть - хранит в себе {@code ArrayList} перцептронов и анализирует
 * данные с их помощью
 *
 * @see Perceptron
 */

public class NeuralNet {

    private List<Perceptron> net = new ArrayList<>();

    /** Длина {@code ArrayList}'а */
    private int length;

    public int getLength() {
        return length;
    }

    public List<Perceptron> getNet() {
        return net;
    }

    /**
     * Инициализирует нейросеть с заданным количеством перцептронов
     *
     * @param length
     *        количество перцептронов в нейросети
     */
    public NeuralNet(int length) {
        this.length = length;
    }

    /**
     * Запускает функцию анализа у перцептронов на основе имеющихся данных. Если перцептрон
     * обучен неоднозначно, добавляет значение в {@code ArrayList}.
     *
     * @param input
     *        входные данные
     * @return {@code ArrayList} с полученными при анализе данными
     */
    public List<Integer> analyze(int[][] input){
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < net.size(); i++) {
            Perceptron tmp = net.get(i);
            tmp.setInput(input);
            if(tmp.analyze()) array.add(i);
        }
        return array;
    }
}
