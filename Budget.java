import java.util.*;

public class Budget {
    public static void main(String[] args) {
        System.out.println("How much are you able to spend?");
        Scanner scnr = new Scanner(System.in);
        double total = scnr.nextDouble();
        double sum = 0;
        int i = 0;
        ArrayList<Double> proportion = new ArrayList<Double>();
        System.out.println("Enter you proportion of various expenses.");
        System.out.println("The system will stop if the cumulative proportion exceeds 100%.");
        do{
            System.out.println("Your proportion of expense " + (i + 1) + ":");
            double value = scnr.nextDouble();
            proportion.add(value);
            sum += proportion.get(i);
            i++;
        } while (sum <= 100);
        scnr.close();
        if (sum > 100) {
            double cumulativeSum = 0.0;
            for (int j = 0; j < proportion.size() - 1; j++) {
                cumulativeSum += proportion.get(j);
            }
            proportion.set(proportion.size() - 1, 100.0 - cumulativeSum);
        }
        for (double value : proportion) {
            double expense = value * total / 100.0;
            System.out.println("Your " + value + "% equals $" + expense);
        }
    }
}
1