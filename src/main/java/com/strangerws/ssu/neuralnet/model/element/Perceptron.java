package com.strangerws.ssu.neuralnet.model.element;

import com.strangerws.ssu.neuralnet.model.NeuralNet;

/**
 * Класс Перцептрон - основной класс данной нейронной сети. Умеет запоминать прошлое состояние
 * значений весов и модифицировать их в зависимотси от ошибки.
 *
 * @see NeuralNet
 */

public class Perceptron {

    /** Веса нейронов, иначе - память о прошлом опыте */
    private int[][] weights;

    /** Входной массив элементов - представление нейронов */
    private int[][] input;

    /** Пороговое значение функции активации. Влияет на количество эпох для обучения нейронов */
    private int limit = 50;

    public int[][] getWeights() {
        return weights;
    }

    public void setWeights(int[][] weights) {
        this.weights = weights;
    }

    public int[][] getInput() {
        return input;
    }

    public void setInput(int[][] input) {
        this.input = input;
    }

    public int getLimit() {
        return limit;
    }

    /**
     * Инициализирует перцепторн, основываясь на входных данных. Создаёт пустой массив
     * весов для дальнейшего запоминания опыта.
     *
     * @param sizeX
     *        ширина
     *
     * @param sizeY
     *        высота
     *
     * @param input
     *        входной файл
     */
    public Perceptron(int sizeX, int sizeY, int[][] input) {
        weights = new int[sizeX][sizeY];
        this.input = input;
    }

    /**
     * Инициализирует перцепторн, основываясь на входных данных и файле памяти.
     *
     * @param input
     *        входной массив данных
     *
     * @param weights
     *        веса нейронов
     **/
    public Perceptron(int[][] input, int[][] weights) {
        this.weights = weights;
        this.input = input;
    }

    /**
     * Анализирует данные на входе - перемножает входы и веса и суммирует их, после чего
     * возвращает значение функции активации.
     *
     * @return значение пороговой функции активации
     */
    public boolean analyze(){
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights[0].length; j++) {
                sum += input[i][j] * weights[i][j];
            }
        }
        return sum >= limit;
    }

    /**
     * Меняет значение весов в зависимости от ситуации. Если ошибка случилась на верном
     * значении - добавляет входные значения в память, если на неверном - вычитает входы
     *
     * @param validity
     *        значение ошибки
     */
    public void changeWeights(boolean validity){
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights[0].length; j++) {
                if (validity) weights[i][j] -= input[i][j];
                else weights[i][j] += input[i][j];
            }
        }
    }
}
