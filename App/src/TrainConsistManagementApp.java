import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementApp {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("-------------------------------------------");
        System.out.println(" UC13 Performance Comparison (Loops vs Streams) ");
        System.out.println("-------------------------------------------\n");

        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Sleeper", i % 100));
        }

        long startLoop = System.nanoTime();
        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }
        long endLoop = System.nanoTime();
        System.out.println("Loop Execution Time (ns): " + (endLoop - startLoop));

        long startStream = System.nanoTime();
        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long endStream = System.nanoTime();
        System.out.println("Stream Execution Time (ns): " + (endStream - startStream));

        System.out.println("\nUC13 performance benchmarking completed...");
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> testBogies = List.of(new Bogie("Sleeper", 70), new Bogie("AC", 50));
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : testBogies) {
            if (b.capacity > 60) result.add(b);
        }
        assertEquals(1, result.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> testBogies = List.of(new Bogie("Sleeper", 70), new Bogie("AC", 50));
        List<Bogie> result = testBogies.stream().filter(b -> b.capacity > 60).collect(Collectors.toList());
        assertEquals(1, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> testBogies = List.of(new Bogie("Sleeper", 70), new Bogie("AC", 80), new Bogie("General", 40));

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : testBogies) if (b.capacity > 60) loopResult.add(b);

        List<Bogie> streamResult = testBogies.stream().filter(b -> b.capacity > 60).collect(Collectors.toList());

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        long end = System.nanoTime();
        assertTrue((end - start) >= 0);
    }
}