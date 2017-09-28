package model;

public class Neuron {
    private int[][] multiplied;
    private int[][] weights;
    private int[][] input;
    private int limit = 9;
    private int sum;

    public int[][] getMultiplied() {
        return multiplied;
    }

    public int[][] getInput() {
        return input;
    }

    public int getLimit() {
        return limit;
    }

    public int getSum() {
        return sum;
    }

    public Neuron(int sizeX, int sizeY, int[][] input) {
        weights = new int[sizeX][sizeY];
        multiplied = new int[sizeX][sizeY];
        this.input = input;
    }

    public int[][] getWeights() {
        return weights;
    }

    public void setWeights(int[][] weights) {
        this.weights = weights;
    }

    public void multiplyWeights() {
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights[0].length; j++) {
                multiplied[i][j] = input[i][j] * weights[i][j];
            }
        }
    }

    public void sum() {
        sum = 0;
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights[0].length; j++) {
                sum += multiplied[i][j];
            }
        }
    }

    public boolean resolve(){
        return sum >= limit;
    }

    public void changeWeights(boolean flag){
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights[0].length; j++) {
                if (flag) weights[i][j] -= input[i][j];
                else weights[i][j] += input[i][j];
            }
        }
    }
}
