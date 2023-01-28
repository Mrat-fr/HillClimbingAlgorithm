import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //get the brick weights from the cv file
        List<Double> Bricks = Data.ReadCVFile();
        //get the random data set for large dataset
        List<Double> Largedataset = Data.CreateNewData100();
        java.util.Scanner input=new java.util.Scanner(System.in);
        //for
        double result [] = new double[100];
        int row = 0;

        System.out.println("1) Bricks \n2) LargeDataset ");
        int Option=input.nextInt();


        if (Option == 1){
            String type = "bricks";
            for (int i = 0; i < 10; i++) {
                RandomMutationHillClimbing RanMut = new RandomMutationHillClimbing(Bricks, 20);
                System.out.println("set one " + (i + 1));
                for (int j = 0; j < 10; j++) {
                        // for one set hill climb 10 times to find its local optima
                        double currentfitness = RanMut.HillClimb();
                        //to write to cv file
                        result [row]  = currentfitness;
                        row++;
                    }
                    // Get the best solution found
                    int[] bestSolution = RanMut.BetterIteration;
                    // Get the fitness of the best solution
                    double bestFitness = RanMut.BetterFitness;
                    // Print the best solution and its fitness
                    System.out.println("Best solution: " + Arrays.toString(bestSolution));
                    System.out.println("Best fitness: " + bestFitness);
            }
            //create cv file
            Data.writeResult(result, type);
        }else{
            String type = "Set100";
            for (int i = 0; i < 10; i++) {
                RandomMutationHillClimbing RanMut = new RandomMutationHillClimbing(Largedataset, 100);
                System.out.println("set one " + (i + 1));
                for (int j = 0; j < 10; j++) {
                    // for one set hill climb 10 times to find its local optima
                    double currentfitness = RanMut.HillClimb();
                    //to write to cv file
                    result [row]  = currentfitness;
                    row++;
                }
                // Get the best solution found
                int[] bestSolution = RanMut.BetterIteration;
                // Get the fitness of the best solution
                double bestFitness = RanMut.BetterFitness;
                // Print the best solution and its fitness
                System.out.println("Best solution: " + Arrays.toString(bestSolution));
                System.out.println("Best fitness: " + bestFitness);
            }
            //create cv file
            Data.writeResult(result, type);
        }
    }

}