import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("-------------------------------------------");
        System.out.println(" UC20 Exception Handling During Search ");
        System.out.println("-------------------------------------------\n");

        // Simulate an empty train scenario
        String[] bogieIds = {};
        String searchId = "BG101";

        try {
            boolean found = performSearch(bogieIds, searchId);
            if (found) {
                System.out.println("Bogie " + searchId + " found.");
            } else {
                System.out.println("Bogie " + searchId + " NOT found.");
            }
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC20 execution completed...");
    }

    public static boolean performSearch(String[] bogieIds, String searchId) {
        // FAIL-FAST VALIDATION: Check system state before search [cite: 2168, 2169]
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search."); // [cite: 2182, 2207]
        }

        // SEARCH LOGIC: Executes only if data exists [cite: 2172]
        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                return true;
            }
        }
        return false;
    }

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] emptyBogies = {};
        assertThrows(IllegalStateException.class, () -> {
            performSearch(emptyBogies, "BG101");
        }); // [cite: 2222]
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] bogies = {"BG101", "BG205"};
        assertDoesNotThrow(() -> performSearch(bogies, "BG101")); // [cite: 2225]
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] bogies = {"BG101", "BG205", "BG309"};
        assertTrue(performSearch(bogies, "BG205")); // [cite: 2228]
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] bogies = {"BG101", "BG205", "BG309"};
        assertFalse(performSearch(bogies, "BG999")); // [cite: 2231]
    }
}