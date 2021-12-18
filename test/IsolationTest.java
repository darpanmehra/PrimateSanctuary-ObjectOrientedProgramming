import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import sanctuary.entities.Monkey;
import sanctuary.enums.Foods;
import sanctuary.enums.Sex;
import sanctuary.enums.Size;
import sanctuary.enums.Species;
import sanctuary.housing.Isolation;

import static org.junit.Assert.assertEquals;

/**
 * Unit Tests for Isolation class.
 */
public class IsolationTest {

  private Isolation isolation;

  /**
   * Initialising the Isolation.
   */
  @Before
  public void setUp() throws Exception {
    isolation = new Isolation(10);
  }

  /**
   * Test creating isolation with negative size.
   */
  @Test(expected = IllegalArgumentException.class)
  public void setupIsolationNegativeSize() {
    isolation = new Isolation(-10);
  }

  /**
   * Test the add method.
   */
  @Test
  public void addMonkey() {
    Monkey monkey = new Monkey("Emma", Species.Drill, Sex.Female, Size.Medium, 42,
            24, Foods.Eggs);
    isolation.addMonkey(monkey);

    List expectedList = new ArrayList<>();
    expectedList.add(monkey.toString());

    List result = isolation.reportAllMonkeyInHousing();
    assertEquals(expectedList, result);
  }

  @Test(expected = IllegalStateException.class)
  public void addMonkeyWhenIsolationFull() {
    isolation = new Isolation(2);
    Monkey monkey1 = new Monkey("Emma", Species.Drill, Sex.Female, Size.Medium,
            42, 24, Foods.Eggs);
    Monkey monkey2 = new Monkey("Jake", Species.Spider, Sex.Male, Size.Medium,
            22, 24, Foods.Insects);
    Monkey monkey3 = new Monkey("Emily", Species.Tamarin, Sex.Male, Size.Medium,
            12, 24, Foods.Fruits);
    isolation.addMonkey(monkey1);
    isolation.addMonkey(monkey2);
    isolation.addMonkey(monkey3);
  }

  @Test(expected = IllegalStateException.class)
  public void addMonkeyWithSameName() {
    isolation = new Isolation(2);
    Monkey monkey1 = new Monkey("Emma", Species.Drill, Sex.Female, Size.Medium,
            42, 24, Foods.Eggs);
    Monkey monkey2 = new Monkey("Jake", Species.Spider, Sex.Male, Size.Medium,
            22, 24, Foods.Insects);
    Monkey monkey3 = new Monkey("Emma", Species.Tamarin, Sex.Male, Size.Medium,
            12, 24, Foods.Fruits);
    isolation.addMonkey(monkey1);
    isolation.addMonkey(monkey2);
    isolation.addMonkey(monkey3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void removeMonkeyTwiceFromIsolation() {
    isolation = new Isolation(5);
    Monkey monkey1 = new Monkey("Emma", Species.Drill, Sex.Female, Size.Medium,
            42, 24, Foods.Eggs);
    Monkey monkey2 = new Monkey("Jake", Species.Spider, Sex.Male, Size.Medium,
            22, 24, Foods.Insects);
    Monkey monkey3 = new Monkey("Emily", Species.Tamarin, Sex.Male, Size.Medium,
            12, 24, Foods.Fruits);
    isolation.addMonkey(monkey1);
    isolation.addMonkey(monkey2);
    isolation.addMonkey(monkey3);

    isolation.removeMonkeyFromIsolation(monkey2);
    isolation.removeMonkeyFromIsolation(monkey2);
  }

  @Test
  public void isSpaceAvailable() {
    assertEquals(true, isolation.isSpaceAvailable());
  }

  @Test
  public void lookupMonkey() {
    Monkey monkey1 = new Monkey("Emma", Species.Drill, Sex.Female, Size.Medium,
            42, 24, Foods.Eggs);
    Monkey monkey2 = new Monkey("Jake", Species.Spider, Sex.Male, Size.Medium,
            22, 24, Foods.Insects);
    Monkey monkey3 = new Monkey("Emily", Species.Tamarin, Sex.Male, Size.Medium,
            12, 24, Foods.Fruits);
    isolation.addMonkey(monkey1);
    isolation.addMonkey(monkey2);
    assertEquals(monkey1, isolation.lookupMonkey("Emma"));
  }

  @Test
  public void reportAllSpeciesList() {
    Monkey monkey1 = new Monkey("Emma", Species.Drill, Sex.Female, Size.Medium,
            42, 24, Foods.Eggs);
    Monkey monkey2 = new Monkey("Jake", Species.Spider, Sex.Male, Size.Medium,
            22, 24, Foods.Insects);
    isolation.addMonkey(monkey1);
    isolation.addMonkey(monkey2);

    SortedSet<String> expected = new TreeSet<>();
    expected.add(monkey1.getSpeciesType().toString());
    expected.add(monkey2.getSpeciesType().toString());

    assertEquals(expected, isolation.reportAllSpeciesList());
  }

  /**
   * Test report of monkeys in the Isolation.
   */
  @Test
  public void reportAllMonkeyInHousing() {
    Monkey monkey = new Monkey("Emma", Species.Drill, Sex.Female, Size.Medium,
            42, 24, Foods.Eggs);
    isolation.addMonkey(monkey);

    List expectedList = new ArrayList<>();
    expectedList.add(monkey.toString());

    List result = isolation.reportAllMonkeyInHousing();
    assertEquals(expectedList, result);
  }

  @Test
  public void lookupSpecies() {
    Monkey monkey1 = new Monkey("Emma", Species.Drill, Sex.Female, Size.Medium,
            42, 24, Foods.Eggs);
    Monkey monkey2 = new Monkey("Jake", Species.Spider, Sex.Male, Size.Medium,
            22, 24, Foods.Insects);
    isolation.addMonkey(monkey1);
    isolation.addMonkey(monkey2);
    assertEquals(true, isolation.lookupSpecies(Species.Spider));
  }

  @Test
  public void increaseSize() {
    isolation.increaseSize(20);
    assertEquals(30, isolation.getTotalCages());
  }

  @Test(expected = IllegalArgumentException.class)
  public void increaseSizeNegativeCapacity() {
    isolation.increaseSize(-1);
  }

  @Test
  public void cageOccupied() {
    Monkey monkey1 = new Monkey("Emma", Species.Drill, Sex.Female, Size.Medium,
            42, 24, Foods.Eggs);
    Monkey monkey2 = new Monkey("Jake", Species.Spider, Sex.Male, Size.Medium,
            22, 24, Foods.Insects);
    isolation.addMonkey(monkey1);
    isolation.addMonkey(monkey2);

    assertEquals(2, isolation.cageOccupied());
  }

  @Test
  public void getTotalCages() {
    assertEquals(10, isolation.getTotalCages());
  }

  @Test
  public void removeMonkeyFromIsolation() {
    Monkey monkey1 = new Monkey("Emma", Species.Drill, Sex.Female, Size.Medium,
            42, 24, Foods.Eggs);
    Monkey monkey2 = new Monkey("Jake", Species.Spider, Sex.Male, Size.Medium,
            22, 24, Foods.Insects);
    Monkey monkey3 = new Monkey("Emily", Species.Tamarin, Sex.Male, Size.Medium,
            12, 24, Foods.Fruits);
    isolation.addMonkey(monkey1);
    isolation.addMonkey(monkey2);
    isolation.addMonkey(monkey3);

    isolation.removeMonkeyFromIsolation(monkey3);

    assertEquals(2, isolation.cageOccupied());
  }

  @Test(expected = IllegalStateException.class)
  public void IsolationFullCapacity() {
    isolation = new Isolation(2);
    Monkey monkey1 = new Monkey("Emma", Species.Drill, Sex.Female, Size.Medium,
            42, 24, Foods.Eggs);
    Monkey monkey2 = new Monkey("Jake", Species.Spider, Sex.Male, Size.Medium,
            22, 24, Foods.Insects);
    Monkey monkey3 = new Monkey("Emily", Species.Tamarin, Sex.Male, Size.Medium,
            12, 24, Foods.Fruits);
    isolation.addMonkey(monkey1);
    isolation.addMonkey(monkey2);
    isolation.addMonkey(monkey3);
  }

  @Test
  public void IsolationCapacityAfterDeletion() {
    isolation = new Isolation(5);
    Monkey monkey1 = new Monkey("Emma", Species.Drill, Sex.Female, Size.Medium,
            42, 24, Foods.Eggs);
    Monkey monkey2 = new Monkey("Jake", Species.Spider, Sex.Male, Size.Medium,
            22, 24, Foods.Insects);
    Monkey monkey3 = new Monkey("Emily", Species.Tamarin, Sex.Male, Size.Medium,
            12, 24, Foods.Fruits);
    isolation.addMonkey(monkey1);
    isolation.addMonkey(monkey2);
    isolation.addMonkey(monkey3);
    isolation.removeMonkeyFromIsolation(monkey1);

    assertEquals(2, isolation.cageOccupied());
  }
}