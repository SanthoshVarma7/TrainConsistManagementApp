import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
            return "Capacity -> " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("-------------------------------------------");
        System.out.println(" UC9 - Group Bogies by Type ");
        System.out.println("-------------------------------------------");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));

        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        System.out.println("\nGrouped Bogies:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("\nBogie Type: " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println(b);
            }
        }

        System.out.println("\nUC9 grouping completed...");
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<Bogie> testBogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 56)
        );
        Map<String, List<Bogie>> result = testBogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertEquals(2, result.get("Sleeper").size());
        assertEquals(1, result.get("AC Chair").size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> emptyList = new ArrayList<>();
        Map<String, List<Bogie>> result = emptyList.stream()
                .collect(Collectors.groupingBy(b -> b.name));
        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> testBogies = new ArrayList<>(List.of(new Bogie("Sleeper", 72)));
        int originalSize = testBogies.size();
        testBogies.stream().collect(Collectors.groupingBy(b -> b.name));
        assertEquals(originalSize, testBogies.size());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> testBogies = List.of(new Bogie("First Class", 24));
        Map<String, List<Bogie>> result = testBogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
        assertTrue(result.containsKey("First Class"));
    }
}