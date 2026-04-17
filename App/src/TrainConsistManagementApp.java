import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("-------------------------------------------");
        System.out.println(" UC8 Filter Passenger Bogies Using Streams ");
        System.out.println("-------------------------------------------");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("All Bogies:");
        bogies.forEach(System.out::println);
        System.out.println();

        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        System.out.println("Filtered Bogies (Capacity > 60):");
        filteredBogies.forEach(System.out::println);

        System.out.println("\nUC8 filtering completed...");
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> testBogies = List.of(new Bogie("Sleeper", 72), new Bogie("AC Chair", 56));
        List<Bogie> result = testBogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());
        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).name);
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> testBogies = List.of(new Bogie("First Class", 24));
        List<Bogie> result = testBogies.stream()
                .filter(b -> b.capacity > 100)
                .collect(Collectors.toList());
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> testBogies = new ArrayList<>(List.of(new Bogie("General", 90)));
        int originalSize = testBogies.size();
        testBogies.stream().filter(b -> b.capacity > 100).collect(Collectors.toList());
        assertEquals(originalSize, testBogies.size());
    }
}