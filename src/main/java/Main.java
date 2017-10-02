import controller.Controller;
import model.NeuralNet;
import model.Neuron;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new NeuralNet(10));

        controller.fill();
        for (int k = 0; k < 40; k++) {
            System.out.println("Epoch #" + (k + 1));
            controller.learn();
        }
        //Controller.forget();
        System.out.println(controller.getNet().analyze(Controller.readFileToArray("C:\\Users\\DobryninAM\\IdeaProjects\\NeuralNetCourseWork\\src\\main\\resources\\image\\image4.txt")));

        System.out.println("Tests over");
    }
}
