package sanctuary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;

import sanctuary.entities.Monkey;
import sanctuary.enums.Foods;
import sanctuary.enums.Sex;
import sanctuary.enums.Size;
import sanctuary.enums.Species;
import sanctuary.housing.Enclosure;
import sanctuary.housing.Isolation;

/**
 * A facade for the implementation of various functions inside Sanctuary.
 */
public class Sanctuary {

  //Monkey Map -> Key = monkey name, Value -> Monkey Object
  private final Map monkeyMap;
  private Isolation isolation;
  private final List<Object> enclosureList;


  /**
   * Sanctuary Constructor.
   */
  public Sanctuary() {
    this.monkeyMap = new TreeMap<>();
    this.isolation = null;
    this.enclosureList = new ArrayList<>();
  }

  /**
   * Create an isolation in the sanctuary.
   *
   * @param isolationSize the size of the isolation (number of cages).
   */
  public void createIsolation(int isolationSize) {
    isolation = new Isolation(isolationSize);
  }

  /**
   * Create an enclosure in the Sanctuary.
   *
   * @param name    name of the enclosure.
   * @param size    size of the enclosure (in square meters).
   * @param species species type designation of the enclosure.
   * @return Object enclosure.
   */
  public Object createEnclosure(String name, int size, Species species) {
    try {
      Enclosure enclosure = new Enclosure(name, size, species);
      enclosureList.add(enclosure);
      Enclosure copyEnclosure = new Enclosure(enclosure);
      return copyEnclosure;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

  /**
   * Create the monkey object by calling the Monkey class.
   *
   * @param name        name of the Monkey.
   * @param species     species of the Monkey.
   * @param sex         sex of the Monkey.
   * @param size        size of the Monkey.
   * @param weight      weight of the Monkey.
   * @param ageInMonths age of the Monkey (in months).
   * @param favFood     favourite food of the monkey.
   * @return copy of the monkey object created.
   */
  public static Object createMonkey(String name, Species species, Sex sex, Size size,
                                    double weight, double ageInMonths, Foods favFood) {
    Monkey monkey = new Monkey(name, species, sex, size, weight, ageInMonths, favFood);

    Monkey copyMonkey = new Monkey(monkey);
    return copyMonkey;
  }

  /**
   * Add monkey to the Sanctuary.
   *
   * @param monkey monkey to be added in the Sanctuary.
   * @throws IllegalStateException if a monkey with same name exists in the Sanctuary.
   */
  public void addMonkeyToSanctuary(Monkey monkey) {
    try {
      if (monkeyMap.containsKey(monkey.getName())) {
        throw new IllegalStateException("Error: Cannot add Monkey- " + monkey.getName()
                + ". A monkey with name " + monkey.getName() + " already exists in Sanctuary.");
      }
      isolation.addMonkey(monkey);
      monkeyMap.put(monkey.getName(), monkey);
    } catch (IllegalStateException e) {
      System.out.println(e.getMessage());
    }

  }

  /**
   * Get the List of monkeys in the Isolation.
   *
   * @return list of monkeys in Isolation.
   */
  public List getMonkeysInIsolation() {
    List monkeys = isolation.reportAllMonkeyInHousing();
    return monkeys;
  }

  /**
   * Get the List of monkeys in the Enclosure.
   *
   * @param enclosure enclosure to get the monkeys from.
   * @return the list of monkeys in the enclosure.
   */
  public List getMonkeysInEnclosure(Enclosure enclosure) {
    return enclosure.reportAllMonkeyInHousing();
  }

  /**
   * Get the set of species in the Isolation.
   *
   * @return set of species in the Isolation (sorted alphabetically).
   */
  public SortedSet getSpeciesListInIsolation() {
    return isolation.reportAllSpeciesList();
  }

  /**
   * Get the set of species in the Enclosure.
   *
   * @return set of species in the Enclosure (sorted alphabetically).
   */
  public SortedSet getSpeciesListInEnclosure(Object enclosure) {
    Enclosure enc = (Enclosure) enclosure;
    return enc.reportAllSpeciesList();
  }

  /**
   * Get the Signboard on the Enclosure.
   *
   * @return the signboard of the Enclosure.
   */
  public List getEnclosureSignBoard(Enclosure enclosure) {
    return enclosure.signBoard();
  }

  /**
   * Increase the capacity of the Isolation.
   *
   * @param size size by which the capacity to be increased.
   */
  public void increaseIsolationCapacity(int size) {
    isolation.increaseSize(size);
  }

  /**
   * Get the Total Capacity of the Isolation.
   *
   * @return total number of cages in the isolation.
   */
  public int getIsolationCapacity() {
    return isolation.getTotalCages();
  }

  /**
   * Get the occupancy of the Isolation.
   *
   * @return the number of cages occupied in the Isolation.
   */
  public int getIsolationOccupancy() {
    return isolation.cageOccupied();
  }

  /**
   * Get the total capacity of the enclosure.
   *
   * @param enclosure enclosure to be checked.
   * @return the total capacity of the enclosure.
   */
  public int getEnclosureCapacity(Enclosure enclosure) {
    return enclosure.getTotalCapacity();
  }

  /**
   * Get the availability of the enclosure.
   *
   * @param enclosure enclosure to be checked for availability.
   * @return the available space in the enclosure.
   */
  public int getEnclosureAvailability(Enclosure enclosure) {
    Enclosure enc = (Enclosure) enclosure;
    return enc.getAvailableSpace();
  }

  /**
   * Lookup for a species type in the Isolation.
   *
   * @param species species to lookup.
   * @return true if species found, false if not found.
   */
  public boolean lookupSpeciesInIsolation(Species species) {
    return isolation.lookupSpecies(species);
  }

  /**
   * Lookup for a species type in the Enclosure.
   *
   * @param species   species to lookup.
   * @param enclosure enclosure to check in.
   * @return true if species found, false if not found.
   */
  public boolean lookupSpeciesInEnclosure(Enclosure enclosure, Species species) {
    return enclosure.lookupSpecies(species);
  }

  /**
   * Get shopping list for the monkeys.
   *
   * @return the shopping list.
   */
  public Map getShoppingList() {
    //Get Shopping List for Monkeys
    return createShoppingList();
  }

  /**
   * Create shopping list for the monkeys in the Sanctuary.
   *
   * @return the created shopping list.
   */
  private Map createShoppingList() {
    Map<String, Integer> shoppingList = new TreeMap<>();
    for (Object monkey : monkeyMap.values()) {
      Monkey tempMonkey = (Monkey) monkey;
      Size monkeySize = tempMonkey.getSize();
      String monkeyFavFood = tempMonkey.getFavoriteFood().toString();
      switch (monkeySize) {
        case Large:
          if (shoppingList.containsKey(monkeyFavFood)) {
            int newValue = shoppingList.get(monkeyFavFood) + 500;
            shoppingList.put(monkeyFavFood, newValue);
          } else {
            shoppingList.put(monkeyFavFood, 500);
          }
          break;
        case Medium:
          if (shoppingList.containsKey(monkeyFavFood)) {
            int newValue = shoppingList.get(monkeyFavFood) + 250;
            shoppingList.put(monkeyFavFood, newValue);
          } else {
            shoppingList.put(monkeyFavFood, 250);
          }
          break;
        case Small:
          if (shoppingList.containsKey(monkeyFavFood)) {
            int newValue = shoppingList.get(monkeyFavFood) + 100;
            shoppingList.put(monkeyFavFood, newValue);
          } else {
            shoppingList.put(monkeyFavFood, 100);
          }
          break;
        default:
          break;
      }
    }

    return shoppingList;
  }

  /**
   * Shift the monkey to enclosure.
   *
   * @param monkey monkey to be shifted.
   */
  public Object shiftMonkeyToEnclosure(Monkey monkey) {
    int monkeySpaceSize = monkey.getSpaceOccupancy();
    Integer enclosureNumber = checkForEnclosure(monkey.getSpeciesType(), monkeySpaceSize);
    try {
      return changeLocationToEnclosure(enclosureNumber, monkey);
    } catch (IllegalStateException e) {
      System.out.println(e.getMessage());
      return e;
    }
  }

  /**
   * Change the location of the Monkey to the enclosure.
   *
   * @param enclosureNumber enclosure number in the enclosure list.
   * @param monkey          monkey to be shifted.
   * @return the enclosure the monkey is shifted to.
   */
  private Object changeLocationToEnclosure(Integer enclosureNumber, Monkey monkey) {
    if (enclosureNumber < 0) {
      throw new IllegalStateException("Cannot add " + monkey.getName()
              + " (" + monkey.getSpeciesType() + "). No enclosure found for the Monkey");
    }
    Enclosure enclosure = (Enclosure) enclosureList.get(enclosureNumber);
    isolation.removeMonkeyFromIsolation(monkey);
    enclosure.addMonkey(monkey);
    return enclosure;
  }

  /**
   * Check for the availability of the enclosure for the monkey.
   *
   * @param species         species type of the monkey.
   * @param monkeySpaceSize space the monkey will occupy in the enclosure.
   * @return the enclosure number in the enclosure list. If none found, return -1.
   */
  private int checkForEnclosure(Species species, int monkeySpaceSize) {
    //Check if an enclosure designated has space available
    for (int i = 0; i < enclosureList.size(); i++) {
      Enclosure enclosure = (Enclosure) enclosureList.get(i);
      if (enclosure.getSpecies() == species && enclosure.getAvailableSpace() >= monkeySpaceSize) {
        return i;
      }
    }
    //Check for any other enclosure which is vacant and can accommodate monkey.
    for (int i = 0; i < enclosureList.size(); i++) {
      Enclosure enclosure = (Enclosure) enclosureList.get(i);
      if (enclosure.isEmpty() && enclosure.getAvailableSpace() >= monkeySpaceSize) {
        return i;
      }
    }
    return -1;
  }
}
