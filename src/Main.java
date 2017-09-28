import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Web web = new Web(3, 5, Controller.readFileToArray("C:\\Users\\StrangerWS\\IdeaProjects\\NeuralNetCourseWork\\src\\image.txt"));
        web.setWeights(Controller.readFileToArray("C:\\Users\\StrangerWS\\IdeaProjects\\NeuralNetCourseWork\\src\\memory.txt"));
        web.multiplyWeights();
        web.sum();
        if (web.resolve()) System.out.println("True , sum:" + web.getSum());
        else System.out.println("False, sum: " + web.getSum());



        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        if (c == 1) web.changeWeights(true);
        if (c == -1) web.changeWeights(false);

        Controller.saveArrayToFile("C:\\Users\\StrangerWS\\IdeaProjects\\NeuralNetCourseWork\\src\\memory.txt", web.getWeights());
    }
}
