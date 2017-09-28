import java.io.*;

public class Controller {
    public static int[][] readFileToArray(String fileName){
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

    public static void saveArrayToFile(String fileName, int[][] array){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
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
}
