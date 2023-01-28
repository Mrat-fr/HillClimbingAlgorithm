import java.util.List;
import java.util.Random;

public class RandomMutationHillClimbing {
    List<Double> RawData;
    Random Ran;
    int[] Iteration;
    int[] BetterIteration;
    double BetterFitness;
    //change for higher larger data set(20 for bricks cv)
    int DataAmount;

    public RandomMutationHillClimbing(List<Double> RawData, int Amount) {
        //set up
        this.RawData = RawData;
        this.DataAmount = Amount;
        Ran = new Random();

        //make a random starting point that are represented as 0 and 1 for the two arrays
        Iteration = new int[DataAmount];
        for (int i = 0; i < Iteration.length; i++) {
            Iteration[i] = Ran.nextInt(2);
        }

        //save the best Iteration and its fitness for the end
        BetterIteration = Iteration.clone();
        BetterFitness = Fitness(Iteration);
    }

    //get the fitness of the solutions
    public double Fitness(int[] Iteration) {
        //get the total value for each truck with 0 being truck 1 and 1 being truck 2
        double truck1 = 0;
        double truck2 = 0;
        for (int i = 0; i < DataAmount; i++) {
            if (Iteration[i] == 0) {
                truck1 += RawData.get(i);
            } else {
                truck2 += RawData.get(i);
            }
        }
        //for the fitness I subtract them both to see the weight difference(one closest to 0 is the best fitness)
        double diffrence = truck1 - truck2;
        //how far from 0
        double distanceFromZero = Math.abs(diffrence);
        return distanceFromZero;
    }

    public double HillClimb(){
        //this is to compare neighbors and see if there is a better iteration
        int[]NextIteration =  Mutate(Iteration);

        double Fitness = Fitness(NextIteration);

        if (Fitness < BetterFitness){
            Iteration = NextIteration;
            BetterIteration = NextIteration;
            BetterFitness = Fitness;
        }

        return Fitness;
    }
    //this is my way to change the value a bit
    public int[] Mutate(int[] solution) {
        int[] mutatedSolution = Iteration.clone();

        // Loop through each bit in the binary string
        for (int i = 0; i < mutatedSolution.length; i++) {
            // has a 0.5 chance that any point in the array and swap its value
            if (Ran.nextDouble() <= 0.2) {
                if (mutatedSolution[i] == 0)
                    mutatedSolution[i] = 1;
                else
                    mutatedSolution[i] = 0;
                break;
            }
        }
        return mutatedSolution;
    }

}
