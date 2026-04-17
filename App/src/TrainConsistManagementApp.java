import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementApp {

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return type + " -> " + cargo;
        }
    }

    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println(" UC12 Safety Compliance Check for Goods Bogies ");
        System.out.println("===========================================\n");

        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal"));

        System.out.println("Goods Bogies in Train:");
        goodsBogies.forEach(System.out::println);

        boolean isSafe = validateSafety(goodsBogies);

        System.out.println("\nSafety Compliance Status: " + isSafe);
        if (!isSafe) {
            System.out.println("Train formation is NOT SAFE.");
        } else {
            System.out.println("Train formation is SAFE.");
        }

        System.out.println("\nUC12 safety validation completed...");
    }

    public static boolean validateSafety(List<GoodsBogie> bogies) {
        return bogies.stream().allMatch(b ->
                !(b.type.equalsIgnoreCase("Cylindrical") && !b.cargo.equalsIgnoreCase("Petroleum"))
        );
    }

    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> validBogies = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal")
        );
        assertTrue(validateSafety(validBogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> invalidBogies = List.of(new GoodsBogie("Cylindrical", "Coal"));
        assertFalse(validateSafety(invalidBogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> otherBogies = List.of(
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Grain")
        );
        assertTrue(validateSafety(otherBogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> mixedBogies = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Cylindrical", "Coal")
        );
        assertFalse(validateSafety(mixedBogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        assertTrue(validateSafety(new ArrayList<>()));
    }
}