package day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

    PairFinder pairFinder;
    int[] numbers;

    @BeforeEach
    void setUp() {
        pairFinder = new PairFinder();
        numbers = new int[] { 7, 1, 5, 7, 3, 3, 5, 7, 6, 7, 1, 6, 6, 1, 6, 6 };
    }

    @Test
    void findPairsTest() {
        assertEquals(7, pairFinder.findPairs(numbers));
    }
}