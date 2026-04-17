import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("-------------------------------------------");
        System.out.println(" UC16 Manual Sorting using Bubble Sort ");
        System.out.println("-------------------------------------------\n");

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.print("Original Capacities: ");
        printArray(capacities);

        bubbleSort(capacities);

        System.out.print("\nSorted Capacities (Ascending): ");
        printArray(capacities);

        System.out.println("\nUC16 sorting completed...");
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swapping logic
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void printArray(int[] arr) {
        for (int c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    @Test
    void testSort_BasicSorting() {
        int[] capacities = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};
        bubbleSort(capacities);
        assertArrayEquals(expected, capacities);
    }

    @Test
    void testSort_AlreadySortedArray() {
        int[] capacities = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};
        bubbleSort(capacities);
        assertArrayEquals(expected, capacities);
    }

    @Test
    void testSort_DuplicateValues() {
        int[] capacities = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};
        bubbleSort(capacities);
        assertArrayEquals(expected, capacities);
    }

    @Test
    void testSort_SingleElementArray() {
        int[] capacities = {50};
        int[] expected = {50};
        bubbleSort(capacities);
        assertArrayEquals(expected, capacities);
    }

    @Test
    void testSort_AllEqualValues() {
        int[] capacities = {40, 40, 40};
        int[] expected = {40, 40, 40};
        bubbleSort(capacities);
        assertArrayEquals(expected, capacities);
    }
}