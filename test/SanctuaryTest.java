import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import sanctuary.Sanctuary;
import sanctuary.entities.Monkey;
import sanctuary.enums.Foods;
import sanctuary.enums.Sex;
import sanctuary.enums.Size;
import sanctuary.enums.Species;

import sanctuary.housing.Enclosure;

import static org.junit.Assert.assertEquals;

/**
 * Unit Tests for the Sanctuary facade class.
 */
public class SanctuaryTest {

  private Sanctuary sanctuary;

  private Monkey monkey1;
  private Monkey monkey2;
  private Monkey monkey3;
  private Monkey monkey4;
  private Monkey monkey5;

  @Before
  public void setUp() throws Exception {
    sanctuary = new Sanctuary();
    sanctuary.createIsolation(10);
    sanctuary.createEnclosure("Enclosure 1", 50, Species.Spider);
    sanctuary.createEnclosure("Enclosure 2", 50, Species.Drill);
    sanctuary.createEnclosure("Enclosure 3", 50, Species.Tamarin);

    monkey1 = (Monkey) sanctuary.createMonkey("Emma", Species.Drill, Sex.Female,
            Size.Medium, 42, 24, Foods.Eggs);
    monkey2 = (Monkey) sanctuary.createMonkey("Drake", Species.Guereza, Sex.Male,
            Size.Large, 82, 44, Foods.Fruits);
    monkey3 = (Monkey) sanctuary.createMonkey("Emily", Species.Drill, Sex.Female,
            Size.Small, 12, 4, Foods.Insects);
    monkey4 = (Monkey) sanctuary.createMonkey("King", Species.Tamarin, Sex.Male,
            Size.Large, 82, 44, Foods.Fruits);
    monkey5 = (Monkey) sanctuary.createMonkey("Kong", Species.Spider, Sex.Male,
            Size.Large, 22, 40, Foods.Eggs);

  }

  @Test
  public void createIsolation() {
    sanctuary.createIsolation(5);
    assertEquals(5, sanctuary.getIsolationCapacity());
  }

  @Test
  public void createEnclosure() {
    Enclosure enc = (Enclosure) sanctuary.createEnclosure("Enclosure 4",
            50, Species.Spider);
    assertEquals("Enclosure 4", enc.getName());
  }

  @Test
  public void createMonkey() {
    Monkey monkey = (Monkey) sanctuary.createMonkey("Emily", Species.Tamarin,
            Sex.Male, Size.Medium,
            12, 24, Foods.Fruits);
    assertEquals("Emily", monkey.getName());
  }

  @Test
  public void addMonkeyToSanctuary() {

    sanctuary.addMonkeyToSanctuary(monkey1);
    sanctuary.addMonkeyToSanctuary(monkey4);
    sanctuary.addMonkeyToSanctuary(monkey2);
    sanctuary.addMonkeyToSanctuary(monkey5);
    sanctuary.addMonkeyToSanctuary(monkey3);
    assertEquals(5, sanctuary.getIsolationOccupancy());
  }

  @Test
  public void addMonkeyToSanctuarySameName() {

    Monkey monkey1 = (Monkey) sanctuary.createMonkey("Emma", Species.Drill,
            Sex.Female, Size.Medium, 42, 24, Foods.Eggs);
    Monkey monkey2 = (Monkey) sanctuary.createMonkey("Emma", Species.Drill,
            Sex.Male, Size.Large, 42, 24, Foods.Insects);

    sanctuary.addMonkeyToSanctuary(monkey1);
    sanctuary.addMonkeyToSanctuary(monkey2);

    assertEquals(1, sanctuary.getIsolationOccupancy());
  }

  @Test
  public void getMonkeysInIsolation() {
    sanctuary.addMonkeyToSanctuary(monkey1);
    sanctuary.addMonkeyToSanctuary(monkey2);
    sanctuary.addMonkeyToSanctuary(monkey3);
    sanctuary.addMonkeyToSanctuary(monkey4);
    sanctuary.addMonkeyToSanctuary(monkey5);

    List expectedList = new ArrayList<>();
    expectedList.add(monkey2.toString());
    expectedList.add(monkey3.toString());
    expectedList.add(monkey1.toString());
    expectedList.add(monkey4.toString());
    expectedList.add(monkey5.toString());
    List result = sanctuary.getMonkeysInIsolation();

    assertEquals(expectedList, result);
  }

  @Test
  public void getMonkeysInEnclosure() {
    Sanctuary sanctuaryTest = new Sanctuary();
    sanctuaryTest.createIsolation(10);

    Enclosure enclo1 = (Enclosure) sanctuaryTest.createEnclosure("Enclosure 2",
            50, Species.Drill);

    sanctuaryTest.addMonkeyToSanctuary(monkey1);
    sanctuaryTest.addMonkeyToSanctuary(monkey4);
    sanctuaryTest.addMonkeyToSanctuary(monkey2);
    sanctuaryTest.addMonkeyToSanctuary(monkey5);
    sanctuaryTest.addMonkeyToSanctuary(monkey3);

    sanctuaryTest.shiftMonkeyToEnclosure(monkey1);
    sanctuaryTest.shiftMonkeyToEnclosure(monkey3);

    List expected = new ArrayList();
    expected.add(monkey3.toString());
    expected.add(monkey1.toString());

    assertEquals(expected, sanctuaryTest.getMonkeysInEnclosure(enclo1));
  }

  @Test
  public void getSpeciesListInIsolation() {

    sanctuary.addMonkeyToSanctuary(monkey1);
    sanctuary.addMonkeyToSanctuary(monkey2);
    sanctuary.addMonkeyToSanctuary(monkey3);
    sanctuary.addMonkeyToSanctuary(monkey4);
    sanctuary.addMonkeyToSanctuary(monkey5);

    SortedSet speciesSet = new TreeSet();
    speciesSet.add("Drill");
    speciesSet.add("Guereza");
    speciesSet.add("Spider");
    speciesSet.add("Tamarin");

    assertEquals(speciesSet, sanctuary.getSpeciesListInIsolation());
  }


  @Test
  public void getSpeciesListInEnclosure() {
    Sanctuary sanctuaryTest = new Sanctuary();
    sanctuaryTest.createIsolation(10);

    Enclosure enclo1 = (Enclosure) sanctuaryTest.createEnclosure("Enclosure 2",
            50, Species.Drill);

    sanctuaryTest.addMonkeyToSanctuary(monkey1);
    sanctuaryTest.addMonkeyToSanctuary(monkey4);
    sanctuaryTest.addMonkeyToSanctuary(monkey2);
    sanctuaryTest.addMonkeyToSanctuary(monkey5);
    sanctuaryTest.addMonkeyToSanctuary(monkey3);

    sanctuaryTest.shiftMonkeyToEnclosure(monkey1);
    sanctuaryTest.shiftMonkeyToEnclosure(monkey3);

    SortedSet expected = new TreeSet();
    expected.add(Species.Drill.toString());

    assertEquals(expected, sanctuaryTest.getSpeciesListInEnclosure(enclo1));
  }

  @Test
  public void getEnclosureSignBoard() {
    Sanctuary sanctuaryTest = new Sanctuary();
    sanctuaryTest.createIsolation(10);

    Enclosure enclo1 = (Enclosure) sanctuaryTest.createEnclosure("Enclosure 2",
            50, Species.Drill);

    sanctuaryTest.addMonkeyToSanctuary(monkey1);
    sanctuaryTest.addMonkeyToSanctuary(monkey4);
    sanctuaryTest.addMonkeyToSanctuary(monkey2);
    sanctuaryTest.addMonkeyToSanctuary(monkey5);
    sanctuaryTest.addMonkeyToSanctuary(monkey3);

    sanctuaryTest.shiftMonkeyToEnclosure(monkey1);
    sanctuaryTest.shiftMonkeyToEnclosure(monkey3);

    List expected = new ArrayList();
    expected.add(monkey3.toString());
    expected.add(monkey1.toString());

    assertEquals(expected, sanctuaryTest.getEnclosureSignBoard(enclo1));

  }

  @Test
  public void increaseIsolationCapacity() {
    sanctuary.increaseIsolationCapacity(50);
    assertEquals(60, sanctuary.getIsolationCapacity());
  }

  @Test
  public void getIsolationCapacity() {
    assertEquals(10, sanctuary.getIsolationCapacity());
  }

  @Test
  public void getIsolationOccupancy() {
    sanctuary.addMonkeyToSanctuary(monkey1);
    sanctuary.addMonkeyToSanctuary(monkey2);
    sanctuary.addMonkeyToSanctuary(monkey3);
    sanctuary.addMonkeyToSanctuary(monkey4);
    sanctuary.addMonkeyToSanctuary(monkey5);
    assertEquals(5, sanctuary.getIsolationOccupancy());
  }

  @Test
  public void getEnclosureCapacity() {
    Sanctuary sanctuaryTest = new Sanctuary();
    Enclosure enclo1 = (Enclosure) sanctuaryTest.createEnclosure("Enclosure 1",
            70, Species.Spider);
    assertEquals(70, sanctuaryTest.getEnclosureCapacity(enclo1));
  }

  @Test
  public void getEnclosureAvailability() {
    sanctuary = new Sanctuary();
    sanctuary.createIsolation(10);
    Enclosure enclo1 = (Enclosure) sanctuary.createEnclosure(
            "Enclosure 1", 50, Species.Spider);
    Enclosure enclo2 = (Enclosure) sanctuary.createEnclosure(
            "Enclosure 2", 50, Species.Tamarin);
    Enclosure enclo3 = (Enclosure) sanctuary.createEnclosure(
            "Enclosure 3", 50, Species.Mangabey);

    sanctuary.addMonkeyToSanctuary(monkey1);
    sanctuary.addMonkeyToSanctuary(monkey4);
    sanctuary.addMonkeyToSanctuary(monkey2);
    sanctuary.addMonkeyToSanctuary(monkey5);
    sanctuary.addMonkeyToSanctuary(monkey3);

    sanctuary.shiftMonkeyToEnclosure(monkey1);
    sanctuary.shiftMonkeyToEnclosure(monkey3);

    assertEquals(50, sanctuary.getEnclosureAvailability(enclo1));
  }

  @Test
  public void lookupSpeciesInIsolation() {
    sanctuary.addMonkeyToSanctuary(monkey1);
    sanctuary.addMonkeyToSanctuary(monkey2);
    sanctuary.addMonkeyToSanctuary(monkey3);
    sanctuary.addMonkeyToSanctuary(monkey4);
    sanctuary.addMonkeyToSanctuary(monkey5);

    assertEquals(true, sanctuary.lookupSpeciesInIsolation(Species.Drill));
  }

  @Test
  public void lookupSpeciesInEnclosure() {
    Enclosure enc = (Enclosure) sanctuary.createEnclosure("Enclosure 4",
            50, Species.Guereza);

    sanctuary.addMonkeyToSanctuary(monkey2);
    sanctuary.addMonkeyToSanctuary(monkey3);
    sanctuary.addMonkeyToSanctuary(monkey4);
    sanctuary.addMonkeyToSanctuary(monkey5);

    sanctuary.shiftMonkeyToEnclosure(monkey2);

    assertEquals(true, sanctuary.lookupSpeciesInEnclosure(enc, Species.Guereza));
  }

  @Test
  public void getShoppingList() {
    sanctuary.addMonkeyToSanctuary(monkey1);
    sanctuary.addMonkeyToSanctuary(monkey2);
    sanctuary.addMonkeyToSanctuary(monkey3);
    sanctuary.addMonkeyToSanctuary(monkey4);
    sanctuary.addMonkeyToSanctuary(monkey5);

    Map<String, Integer> expected = new TreeMap<>();
    expected.put("Eggs", 750);
    expected.put("Fruits", 1000);
    expected.put("Insects", 100);

    assertEquals(expected, sanctuary.getShoppingList());
  }

  @Test
  public void shiftMonkeyToEnclosure() {
    sanctuary.addMonkeyToSanctuary(monkey1);
    sanctuary.addMonkeyToSanctuary(monkey2);
    sanctuary.addMonkeyToSanctuary(monkey3);
    sanctuary.addMonkeyToSanctuary(monkey4);
    sanctuary.addMonkeyToSanctuary(monkey5);

    sanctuary.shiftMonkeyToEnclosure(monkey1);
    sanctuary.shiftMonkeyToEnclosure(monkey3);

    assertEquals(3, sanctuary.getIsolationOccupancy());
  }
}