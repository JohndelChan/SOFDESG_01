import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Compare {
    private static double similar;
    private static double total;
    private static DecimalFormat two_point = new DecimalFormat("#.##");

    private static void read_files(String file_ext) {
        String data1, data2;
        try {
            File first_program = new File("Directory/test_program1" + file_ext);
            File second_program = new File("Directory/test_program2" + file_ext);
            Scanner first_cmp = new Scanner(first_program);
            Scanner second_cmp = new Scanner(second_program);
            while (first_cmp.hasNextLine() || second_cmp.hasNextLine()) {
                data1 = first_cmp.nextLine();
                data2 = second_cmp.nextLine();
                total++;
                if (data1.equals(data2)) {
                    similar++;
                }
            }
            first_cmp.close();
            second_cmp.close();
        } catch (FileNotFoundException e) {
            System.out.println("FILE I/O EXCEPTION");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        double percentage;
        read_files(".cpp");
        percentage = (similar / total) * 100;
        System.out.print("\nCPP Similarity: " + two_point.format(percentage) + "%");
        read_files(".java");
        percentage = (similar / total) * 100;
        System.out.print("\nJAVA Similarity: " + two_point.format(percentage) + "%");
    }
}

