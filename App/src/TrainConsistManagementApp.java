import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementApp {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println(" UC10 - Count Total Seats in Train ");
        System.out.println("===========================================\n");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        System.out.println("Bogies in Train: ");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        int totalCapacity = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("\nTotal Seating Capacity of Train: " + totalCapacity);
        System.out.println("\nUC10 aggregation completed...");
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> testBogies = List.of(new Bogie("Sleeper", 72), new Bogie("AC Chair", 56));
        int total = testBogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
        assertEquals(128, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> emptyList = new ArrayList<>();
        int total = emptyList.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
        assertEquals(0, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> testBogies = new ArrayList<>(List.of(new Bogie("Sleeper", 72)));
        int originalSize = testBogies.size();
        testBogies.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        assertEquals(originalSize, testBogies.size());
    }
}