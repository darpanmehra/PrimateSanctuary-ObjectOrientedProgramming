package sanctuary.housing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import sanctuary.interfaces.SanctuaryInterface;
import sanctuary.entities.Monkey;
import sanctuary.enums.Species;

/**
 * Isolation class intends to provide the functionality of Isolation housing in the Sanctuary.
 */
public class Isolation implements SanctuaryInterface {

  //Map cages -> Key = name of monkey, Value = Monkey object.
  private final Map<String, Object> cages;
  private int totalCapacity;
  private int spaceAvailable;

  /**
   * Constructor for isolation.
   *
   * @param totalSize is the size of the Isolation cage.
   * @throws IllegalArgumentException if the totalSize is 0 or less.
   */
  public Isolation(int totalSize) {
    if (totalSize <= 0) {
      throw new IllegalArgumentException("Isolation capacity cannot be 0 or less.");
    }
    this.cages = new TreeMap<>();
    this.totalCapacity = totalSize;
    this.spaceAvailable = totalSize;
  }

  /**
   * Copy constructor to create a copy of the isolation.
   *
   * @param isolation is the isolation object to be copied.
   * @throws IllegalArgumentException if the argument passed in null.
   */
  public Isolation(Isolation isolation) {
    if (isolation == null) {
      throw new IllegalArgumentException("Enclosure passed is null");
    }
    this.cages = isolation.cages;
    this.totalCapacity = isolation.totalCapacity;
    this.spaceAvailable = isolation.spaceAvailable;
  }

  /**
   * Add monkey to a isolation.
   *
   * @param monkey monkey is the monkey to be added to isolation.
   * @throws IllegalStateException if the capacity is less than space available.
   */
  @Override
  public void addMonkey(Monkey monkey) {
    if (spaceAvailable <= 0) {
      throw new IllegalStateException("Error: Cannot add Monkey- " + monkey.getName()
              + ". No space available in the Isolation. Request you to contact another facility");
    }
    if (cages.containsKey(monkey.getName())) {
      throw new IllegalStateException("Monkey with same name already exists in the Isolation.");
    }
    this.cages.put(monkey.getName(), monkey);
    this.spaceAvailable -= 1;
  }

  /**
   * Check if space is available in the isolation.
   *
   * @return boolean value for availability of space.
   */
  @Override
  public boolean isSpaceAvailable() {
    return spaceAvailable > 0;
  }

  /**
   * To lookup a monkey in the Isolation.
   *
   * @param monkeyName for the unique name of the monkey.
   * @return Object monkey for the name parameter passed.
   */
  @Override
  public Object lookupMonkey(String monkeyName) {
    return this.cages.get(monkeyName);
  }

  /**
   * Set of Species found in the isolation.
   *
   * @return species list if found or 'No Species Found'.
   */
  @Override
  public SortedSet reportAllSpeciesList() {
    SortedSet<String> speciesList = new TreeSet<>();

    for (Object monkey : cages.values()) {
      Monkey tempMonkey = (Monkey) monkey;
      speciesList.add(tempMonkey.getSpeciesType().toString());
    }
    if (speciesList.isEmpty()) {
      speciesList.add("No Species Found");
    }
    return speciesList;
  }

  /**
   * List of all monkey in the Isolation.
   *
   * @return list of the monkeys found in the isolation.
   */
  @Override
  public List reportAllMonkeyInHousing() {
    List<String> monkeyList = new ArrayList<>();

    for (Object monkey : cages.values()) {
      Monkey tempMonkey = (Monkey) monkey;
      monkeyList.add(tempMonkey.toString());
    }

    return monkeyList;
  }

  /**
   * Lookup if monkeys of the passed species type exists.
   *
   * @param species type to lookup.
   * @return boolean true if monkey(s) of passed parameter exists.
   */
  @Override
  public boolean lookupSpecies(Species species) {
    for (Object monkey : cages.values()) {
      Monkey tempMonkey = (Monkey) monkey;
      if (tempMonkey.getSpeciesType() == species) {
        return true;
      }
    }
    return false;
  }

  /**
   * Increase the size of the Isolation.
   *
   * @param size size by which you want to increase.
   */
  public void increaseSize(int size) {
    if (size <= 0) {
      throw new IllegalArgumentException("Size cannot be 0 or less");
    }
    this.spaceAvailable += size;
    this.totalCapacity += size;
  }

  /**
   * Number of cages occupied.
   *
   * @return the number of the cages occupied.
   */
  public int cageOccupied() {
    return this.cages.size();
  }

  /**
   * Get the total capacity of the isolation.
   *
   * @return the total capacity of the isolation.
   */
  public int getTotalCages() {
    return this.totalCapacity;
  }

  /**
   * Remove monkey from the Isolation.
   *
   * @param monkey is the monkey to remove from isolation.
   */
  public void removeMonkeyFromIsolation(Monkey monkey) {
    Boolean checkMonkeyExists = cages.containsValue(monkey);
    if (checkMonkeyExists) {
      cages.remove(monkey.getName());
      this.spaceAvailable -= 1;
    } else {
      throw new IllegalArgumentException("Monkey does not exists in the Isolation");
    }
  }

}
