import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("-------------------------------------------");
        System.out.println(" UC17 Sort Bogie Names Using Arrays.sort() ");
        System.out.println("-------------------------------------------\n");

        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        // Sorting alphabetically using the optimized Java library utility
        Arrays.sort(bogieNames);

        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nUC17 sorting completed...");
    }

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        String[] expected = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};
        Arrays.sort(bogieNames);
        assertArrayEquals(expected, bogieNames);
    }

    @Test
    void testSort_UnsortedInput() {
        String[] bogieNames = {"Luxury", "General", "Sleeper", "AC Chair"};
        String[] expected = {"AC Chair", "General", "Luxury", "Sleeper"};
        Arrays.sort(bogieNames);
        assertArrayEquals(expected, bogieNames);
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] bogieNames = {"AC Chair", "First Class", "General"};
        String[] expected = {"AC Chair", "First Class", "General"};
        Arrays.sort(bogieNames);
        assertArrayEquals(expected, bogieNames);
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] bogieNames = {"Sleeper", "AC Chair", "Sleeper", "General"};
        String[] expected = {"AC Chair", "General", "Sleeper", "Sleeper"};
        Arrays.sort(bogieNames);
        assertArrayEquals(expected, bogieNames);
    }

    @Test
    void testSort_SingleElementArray() {
        String[] bogieNames = {"Sleeper"};
        String[] expected = {"Sleeper"};
        Arrays.sort(bogieNames);
        assertArrayEquals(expected, bogieNames);
    }
}