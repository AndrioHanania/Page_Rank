import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class MyMath {

    /**
     * Get a random integer in range
     * @param min - the min number in the range
     * @param max - the max number in the range
     * @return - a random integer number between the min number and max number inclusive.
     */
    public static int randomInRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static double randomDouble()
    {
        return ThreadLocalRandom.current().nextDouble();
    }

    public static ArrayList<Double> minusArrays(ArrayList<Double> array1, ArrayList<Double> array2)
    {
        ArrayList<Double> result = new ArrayList<Double>(array1.size());
        for(int i = 0; i < array1.size(); i++)
        {
            result.add(array1.get(i) - array2.get(i));
        }

        return result;
    }

    public static double vectorLength(ArrayList<Double> array)
    {
        double length = 0;
        for(int i = 0;i < array.size();i++)
        {
            length += Math.pow(array.get(i), 2);
        }

        length = Math.sqrt(length);
        return length;
    }
}