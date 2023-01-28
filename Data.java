import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.text.DecimalFormat;

public class Data {
    int runNum;
    public static List<Double> CreateNewData100() {
        Random rand = new Random();
        int num = rand.nextInt(101);
        List<Double> LargeDataset = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            double min = 10.00;
            double max = 30.00;
            double RanDouble = min + (max - min) * rand.nextDouble();
            DecimalFormat df = new DecimalFormat("#.##");
            String ForDouble = df.format(RanDouble);
            double finalDouble = Double.parseDouble(ForDouble);
            LargeDataset.add(finalDouble);
        }

        String fileName = "C:\\Users\\mratf\\Desktop\\Project 5 Dataset100"+num+".csv";

        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.append("value");
            bw.newLine();

            for (int i=0; i<LargeDataset.size(); i++) {
                bw.append(Double.toString(LargeDataset.get(i)));
                bw.newLine();
            }
            bw.close();
            fw.close();

        }
        catch(Exception e) {
            System.err.print("error");
        }

        return LargeDataset;
    }

    //get the data from the CV file
    public static List<Double> ReadCVFile () {
        String fileName = "C:\\Users\\mratf\\Desktop\\bricks.csv";
        List<Double> data = new ArrayList<>();

        try {
            FileReader fr = new FileReader (fileName);
            BufferedReader br = new BufferedReader (fr);
            String line = null;
            while((line = br.readLine())!=null) {
                data.add(Double.valueOf(line));
            }
            br.close();
            fr.close();
        }
        catch(Exception e) {
            System.err.print("Unable to read the file");
        }

        return data;
    }

    //put the results into a cv file
    public static void writeResult(double [] result, String type) {
        Random rand = new Random();
        int num = rand.nextInt(101);

        String fileName = "C:\\Users\\mratf\\Desktop\\Project 5 "+type+num+" results.csv";

        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.append("Fitness");
            bw.newLine();

            for (int i=0; i<result.length; i++) {
                bw.append(Double.toString(result[i]));
                bw.newLine();
            }
            bw.close();
            fw.close();

        }
        catch(Exception e) {
            System.err.print("error");
        }

    }
}
