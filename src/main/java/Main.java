import controller.Controller;
import model.Neuron;

public class Main {

    public static void main(String[] args) {
        Neuron[] web = new Neuron[10];

        for (int k = 0; k < 40; k++) {
            System.out.println("Epoch #" + (k + 1));
            for (int i = 0; i < web.length; i++) {
                Controller.learn(i, web[i]);
            }
        }

        System.out.println("Tests over");
    }
}
