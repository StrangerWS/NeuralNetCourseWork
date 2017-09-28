public class MathFunctions {

    public static double sigmoid(double x) {
        return 1 / (1 + Math.pow(Math.E, -x));
    }

    public static double MSE(double[] iArray, double[] aArray) {
        double error = 0;
        for (int i = 0; i < iArray.length; i++) {
            error += iArray[i] * iArray[i] - 2 * iArray[i] * aArray[i] + aArray[i] * aArray[i];
        }
        error /= iArray.length;
        return error;
    }

    public static double rootMSE(double[] iArray, double[] aArray) {
        return Math.sqrt(MSE(iArray, aArray));
    }

    public static double arctan(double[] iArray, double[] aArray) {
        double error = 0;
        for (int i = 0; i < iArray.length; i++) {
            error += Math.pow(Math.atan(iArray[i] - aArray[i]), 2);
        }
        error /= iArray.length;
        return error;
    }
}
