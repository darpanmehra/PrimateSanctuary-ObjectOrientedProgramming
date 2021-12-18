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
 * Enclosure class intends to provide the functionality of Enclosure housing in the Sanctuary.
 */
public class Enclosure implements SanctuaryInterface {

  private final String name;
  private Species species;
  private final Map<String, Object> troops;
  private final int totalCapacity;
  private int availableSpace;

  /**
   * Constructor class to initialize Enclosure.
   *
   * @param name    name of the enclosure.
   * @param size    capacity of the enclosure (in square meters).
   * @param species designated species type.
   * @throws IllegalArgumentException if the size is 0 or less.
   */
  public Enclosure(String name, int size, Species species) {
    if (size <= 0) {
      throw new IllegalArgumentException("Error: Cannot create enclosure. " +
              "Enclosure Size cannot be 0 or less.");
    }
    this.name = name;
    this.totalCapacity = size;
    this.availableSpace = size;
    this.species = species;
    this.troops = new TreeMap<>();
  }

  /**
   * Copy constructor to initialize a copy of the Enclosure.
   *
   * @param enclosure enclosure to be copied.
   * @throws IllegalArgumentException is the enclosure passed is null.
   */
  public Enclosure(Enclosure enclosure) {
    if (enclosure == null) {
      throw new IllegalArgumentException("Enclosure passed is null");
    }
    this.name = enclosure.name;
    this.totalCapacity = enclosure.totalCapacity;
    this.availableSpace = enclosure.availableSpace;
    this.species = enclosure.species;
    this.troops = enclosure.troops;
  }

  /**
   * Add monkey to the Enclosure.
   *
   * @param monkey monkey to be added in the enclosure.
   */
  @Override
  public void addMonkey(Monkey monkey) {
    //Change the Species Designation.
    if (isEmpty() && this.species != monkey.getSpeciesType()) {
      this.species = monkey.getSpeciesType();
    }
    //Check if the monkey already exists in the enclosure.

    //Check for species designation match
    if (this.species != monkey.getSpeciesType()) {
      throw new IllegalStateException("Monkey of " + monkey.getSpeciesType()
              + " species cannot be added to this Enclosure");
    }
    if (this.availableSpace >= monkey.getSpaceOccupancy()) {
      this.troops.put(monkey.getName(), monkey);
      manageCapacityAfterAdding(monkey); //Manage Capacity after adding
    } else {
      throw new IllegalArgumentException("Monkey cannot be added to Enclosure");
    }


  }

  /**
   * Check if space is available in the enclosure.
   *
   * @return boolean value for availability of space.
   */
  @Override
  public boolean isSpaceAvailable() {
    return availableSpace > 0;
  }

  /**
   * To lookup a monkey in the Enclosure.
   *
   * @param monkeyName for the unique name of the monkey.
   * @return Object monkey for the name parameter passed.
   */
  @Override
  public Object lookupMonkey(String monkeyName) {
    return this.troops.get(monkeyName);
  }

  /**
   * Set of Species found in the Enclosure.
   *
   * @return species list if found or 'No Species Found'.
   */
  @Override
  public SortedSet reportAllSpeciesList() {
    SortedSet<String> speciesList = new TreeSet<>();

    for (Object monkey : troops.values()) {
      Monkey tempMonkey = (Monkey) monkey;
      speciesList.add(tempMonkey.getSpeciesType().toString());
    }

    if (speciesList.isEmpty()) {
      speciesList.add("No Species Found");
    }

    return speciesList;
  }

  /**
   * List of all monkey in the Enclosure.
   *
   * @return list of the monkeys found in the enclosure.
   */
  @Override
  public List reportAllMonkeyInHousing() {
    List<String> monkeyList = new ArrayList<>();
    for (Object monkey : troops.values()) {
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
    for (Object monkey : troops.values()) {
      Monkey tempMonkey = (Monkey) monkey;
      if (tempMonkey.getSpeciesType() == species) {
        return true;
      }
    }
    return false;
  }

  /**
   * Signboard for the enclosure showing details like Name, Species type, Sex, Favourite food.
   *
   * @return Signboard of the enclosure.
   */
  public List signBoard() {
    List<String> signBoard = new ArrayList<>();
    for (Object monkey : troops.values()) {
      Monkey tempMonkey = (Monkey) monkey;
      signBoard.add(tempMonkey.toString());
    }
    return signBoard;
  }

  /**
   * Get the name of the enclosure.
   *
   * @return name of the enclosure.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get the total capacity of the enclosure.
   *
   * @return the total capacity of the enclosure.
   */
  public int getTotalCapacity() {
    return this.totalCapacity;
  }

  /**
   * Get the space available in the enclosure.
   *
   * @return the space available in the enclosure.
   */
  public int getAvailableSpace() {
    return this.availableSpace;
  }

  /**
   * Get the Species type the enclosure is designated for.
   *
   * @return the species type designation.
   */
  public Species getSpecies() {
    return this.species;
  }

  /**
   * Manage the capacity of the enclosure after adding the monkey.
   *
   * @param monkey monkey that is added.
   */
  private void manageCapacityAfterAdding(Monkey monkey) {
    switch (monkey.getSize()) {
      case Large:
        this.availableSpace -= 10;
        break;
      case Medium:
        this.availableSpace -= 5;
        break;
      case Small:
        this.availableSpace -= 1;
        break;
      default:
        break;
    }
  }

  /**
   * Check if the enclosure is empty or not.
   *
   * @return boolean for enclosure emptiness.
   */
  public boolean isEmpty() {
    return (this.totalCapacity - this.availableSpace) == 0;
  }
}
