\import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("-------------------------------------------");
        System.out.println(" UC18 Linear Search for Bogie ID ");
        System.out.println("-------------------------------------------\n");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchId = "BG309";

        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        boolean found = linearSearch(bogieIds, searchId);

        if (found) {
            System.out.println("\nBogie " + searchId + " found in train consist.");
        } else {
            System.out.println("\nBogie " + searchId + " NOT found in train consist.");
        }

        System.out.println("\nUC18 search completed...");
    }

    public static boolean linearSearch(String[] arr, String target) {
        for (String element : arr) {
            if (element.equals(target)) {
                return true;
            }
        }
        return false;
    }

    @Test
    void testSearch_BogieFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(linearSearch(bogieIds, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(linearSearch(bogieIds, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(linearSearch(bogieIds, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(linearSearch(bogieIds, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] bogieIds = {"BG101"};
        assertTrue(linearSearch(bogieIds, "BG101"));
    }
}