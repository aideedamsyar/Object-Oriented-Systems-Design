package LotterySimulator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LotteryGenerator {
    private Random rand = new Random();

    public int[] genRandomUnique(int size) {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < size) {
            int randomNumber = rand.nextInt(20) + 1;
            numbers.add(randomNumber);
        }

        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }
}
