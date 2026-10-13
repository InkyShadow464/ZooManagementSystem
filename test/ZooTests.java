import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ZooTests {

    // variables available to all tests
    private Dog dog;
    private Hawk hawk;
    private Seal sealNovice;
    private Seal sealInter;
    private Seal sealExpert;

    // @BeforeEach runs before every single test, creating the animals for the test
    @BeforeEach
    public void setUp() {
        dog = new Dog("Rex", 4, "Brown", 15, "Labrador");
        hawk = new Hawk("Rocky", 7, "Grey", 2, 30);
        sealNovice = new Seal("Splash", 5, "Grey", 90, 1);  // 1 = Novice
        sealInter = new Seal("Bob", 4, "White", 80, 2); // 2 = Intermediate
        sealExpert = new Seal("Flash", 3, "Black", 85, 3);  // 3 = Expert
    }

    // ---------- MAKE SOUND UNIT TESTS ----------

    @Test
    public void testDogMakeSound() {
        String result = dog.makeSound();
        // check the sound contains expected information
        assertTrue(result.contains("Woof"));
        assertTrue(result.contains("Rex"));
        assertTrue(result.contains("4"));
        assertTrue(result.contains("Labrador"));
    }

    @Test
    public void testHawkMakeSound() {
        String result = hawk.makeSound();
        // check the sound contains expected information
        assertTrue(result.contains("Screech"));
        assertTrue(result.contains("Rocky"));
        assertTrue(result.contains("7"));
    }

    @Test
    public void testSealMakeSound() {
        String result = sealNovice.makeSound();
        // check the sound contains expected information
        assertTrue(result.contains("Arf"));
        assertTrue(result.contains("Splash"));
        assertTrue(result.contains("5"));
    }

    // ---------- SEAL SKILL LEVEL CONVERSION TESTS ----------
    // Novice seal
    @Test
    public void testSkillLevelNovice() {
        // input 1 should give "Novice"
        assertEquals("Novice", sealNovice.getSkillLevel());
    }

    // Intermediate seal
    @Test
    public void testSkillLevelIntermediate() {
        assertEquals("Intermediate", sealInter.getSkillLevel());
    }

    // Expert seal
    @Test
    public void testSkillLevelExpert() {
        assertEquals("Expert", sealExpert.getSkillLevel());
    }

    // ---------- MAX ALTITUDE TEST ----------

    @Test
    public void testHawkMaxAltitude() {
        // wingspan 30 * 12.5 = 375.0
        assertEquals(375.0, hawk.getMaxAltitude(), 0.01);
    }


    // ---------- SWIM SPEED TESTS ----------
    // Novice swim speed test
    @Test
    public void testSwimSpeedNovice() {
        assertEquals(10.0, sealNovice.getSwimSpeed(), 0.01);
    }

    // Intermediate swim speed test
    @Test
    public void testSwimSpeedIntermediate() {
        assertEquals(20.0, sealInter.getSwimSpeed(), 0.01);
    }

    // Expert swim speed test
    @Test
    public void testSwimSpeedExpert() {
        assertEquals(30.0, sealExpert.getSwimSpeed(), 0.01);
    }
}

