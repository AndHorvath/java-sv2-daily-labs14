package day04;

import java.util.HashMap;
import java.util.Map;

public class PairFinder {

    public int findPairs(int[] numbers) {
        Map<Integer, Integer> frequencyToNumbers = createFrequencyToNumbers(numbers);
        return frequencyToNumbers.values().stream()
            .mapToInt(frequency -> frequency / 2)
            .sum();
    }

    // --- private methods ----------------------------------------------------

    private Map<Integer, Integer> createFrequencyToNumbers(int[] numbers) {
        Map<Integer, Integer> frequencyToNumbers = new HashMap<>();
        for (int number : numbers) {
            if (!frequencyToNumbers.containsKey(number)) {
                frequencyToNumbers.put(number, 0);
            }
            frequencyToNumbers.put(number, frequencyToNumbers.get(number) + 1);
        }
        return frequencyToNumbers;
    }
}