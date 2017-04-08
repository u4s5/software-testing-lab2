import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Logger {

    private static final String DELIMITER = ";";

    public static void printToFile(UnaryOperator<Double> function, String functionName,
                                   double minArg, double maxArg, double step) {

        File file = new File("logs/" + functionName +
                "From" + minArg + "To" + maxArg + "Step" + step + ".log");
        file.getParentFile().mkdirs();

        try {
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            while (minArg <= maxArg) {
                writer.write(minArg + DELIMITER + function.apply(minArg));
                writer.newLine();
                minArg += step;
            }

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printLogarithmToFile(BiFunction<Integer, Double, Double> function,
                                            String functionName, int base, double minArg,
                                            double maxArg, double step) {

        File file = new File("logs/" + functionName + base +
                "From" + minArg + "To" + maxArg + "Step" + step + ".log");
        file.getParentFile().mkdirs();

        try {
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            while (minArg <= maxArg) {
                writer.write(minArg + DELIMITER + function.apply(base, minArg));
                writer.newLine();
                minArg += step;
            }

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
