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
import sanctuary.housing.Enclosure;

import static org.junit.Assert.assertEquals;

/**
 * Unit Tests for Enclosure class.
 */
public class EnclosureTest {

  private Enclosure enclosure;

  @Before
  public void setUp() throws Exception {
    enclosure = new Enclosure("Enclosure 1", 50, Species.Drill);
  }

  @Test(expected = IllegalArgumentException.class)
  public void enclosureWithNegativeSize() {
    enclosure = new Enclosure("Enclosure 1", -10, Species.Drill);
  }

  @Test
  public void addMonkey() {
    Monkey monkey = new Monkey("Emma", Species.Drill, Sex.Female, Size.Medium,
            42, 24, Foods.Eggs);
    enclosure.addMonkey(monkey);

    assertEquals(45, enclosure.getAvailableSpace());
  }

  @Test
  public void addMonkeyWhenEnclosureEmpty() {
    Monkey monkey = new Monkey("Emma", Species.Spider, Sex.Female, Size.Medium,
            42, 24, Foods.Eggs);
    enclosure.addMonkey(monkey);
    assertEquals(45, enclosure.getAvailableSpace());
  }

  @Test(expected = IllegalArgumentException.class)
  public void addMonkeyWhenEnclosureFull() {
    enclosure = new Enclosure("Enclosure 1", 1, Species.Drill);
    Monkey monkey = new Monkey("Emma", Species.Drill, Sex.Female, Size.Medium,
            42, 24, Foods.Eggs);
    enclosure.addMonkey(monkey);
  }

  @Test(expected = IllegalStateException.class)
  public void addMonkeyOfDifferentSpecies() {
    enclosure = new Enclosure("Enclosure 1", 50, Species.Drill);
    Monkey monkey1 = new Monkey("Emma", Species.Drill, Sex.Female, Size.Medium,
            42, 24, Foods.Eggs);
    Monkey monkey2 = new Monkey("Emily", Species.Spider, Sex.Female, Size.Medium,
            42, 24, Foods.Eggs);

    enclosure.addMonkey(monkey1);
    enclosure.addMonkey(monkey2);
  }

  @Test
  public void isSpaceAvailable() {
    assertEquals(true, enclosure.isSpaceAvailable());
  }

  @Test
  public void lookupMonkey() {
    Monkey monkey1 = new Monkey("Emma", Species.Drill, Sex.Female, Size.Medium,
            42, 24, Foods.Eggs);
    Monkey monkey2 = new Monkey("Jake", Species.Drill, Sex.Male, Size.Medium,
            22, 24, Foods.Insects);

    enclosure.addMonkey(monkey1);
    enclosure.addMonkey(monkey2);
    assertEquals(monkey1, enclosure.lookupMonkey("Emma"));
  }

  @Test
  public void reportAllSpeciesList() {
    Monkey monkey1 = new Monkey("Emma", Species.Drill, Sex.Female, Size.Medium,
            42, 24, Foods.Eggs);
    Monkey monkey2 = new Monkey("Jake", Species.Drill, Sex.Male, Size.Medium,
            22, 24, Foods.Insects);
    enclosure.addMonkey(monkey1);
    enclosure.addMonkey(monkey2);

    SortedSet<String> expected = new TreeSet<>();
    expected.add(monkey1.getSpeciesType().toString());
    expected.add(monkey2.getSpeciesType().toString());

    assertEquals(expected, enclosure.reportAllSpeciesList());
  }

  @Test
  public void reportAllMonkeyInHousing() {
    Monkey monkey1 = new Monkey("Emma", Species.Drill, Sex.Female, Size.Medium,
            42, 24, Foods.Eggs);
    Monkey monkey2 = new Monkey("Jake", Species.Drill, Sex.Male, Size.Medium,
            22, 24, Foods.Insects);
    enclosure.addMonkey(monkey1);
    enclosure.addMonkey(monkey2);

    List expectedList = new ArrayList<>();
    expectedList.add(monkey1.toString());
    expectedList.add(monkey2.toString());

    List result = enclosure.reportAllMonkeyInHousing();
    assertEquals(expectedList, result);
  }

  @Test
  public void lookupSpecies() {
    Monkey monkey1 = new Monkey("Emma", Species.Drill, Sex.Female, Size.Medium,
            42, 24, Foods.Eggs);

    enclosure.addMonkey(monkey1);

    assertEquals(false, enclosure.lookupSpecies(Species.Spider));
  }

  @Test
  public void signBoard() {
    Monkey monkey2 = new Monkey("Emma", Species.Drill, Sex.Female, Size.Medium,
            42, 24, Foods.Eggs);
    Monkey monkey3 = new Monkey("Jake", Species.Drill, Sex.Male, Size.Medium,
            22, 24, Foods.Insects);
    Monkey monkey1 = new Monkey("Emily", Species.Drill, Sex.Male, Size.Medium,
            22, 24, Foods.Insects);
    enclosure.addMonkey(monkey1);
    enclosure.addMonkey(monkey2);
    enclosure.addMonkey(monkey3);

    List expectedList = new ArrayList<>();
    expectedList.add(monkey1.toString());
    expectedList.add(monkey2.toString());
    expectedList.add(monkey3.toString());

    assertEquals(expectedList, enclosure.signBoard());

  }

  @Test
  public void getName() {
    assertEquals("Enclosure 1", enclosure.getName());
  }

  @Test
  public void getTotalCapacity() {
    assertEquals(50, enclosure.getTotalCapacity());
  }

  @Test
  public void getAvailableSpace() {
    Monkey monkey1 = new Monkey("Emma", Species.Drill, Sex.Female, Size.Medium,
            42, 24, Foods.Eggs);
    enclosure.addMonkey(monkey1);

    assertEquals(45, enclosure.getAvailableSpace());
  }

  @Test
  public void getSpecies() {
    assertEquals(Species.Drill, enclosure.getSpecies());
  }

  @Test
  public void isEmpty() {
    assertEquals(true, enclosure.isEmpty());
  }
}