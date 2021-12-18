package sanctuary.interfaces;

import java.util.List;
import java.util.SortedSet;

import sanctuary.entities.Monkey;
import sanctuary.enums.Species;

/**
 * The Sanctuary interface for methods common to all housing in the sanctuary.
 */
public interface SanctuaryInterface {

  /**
   * Add Monkey to the housing.
   *
   * @param monkey object.
   */
  void addMonkey(Monkey monkey);

  /**
   * Check if space is available in the housing.
   *
   * @return Boolean value for space availability.
   */
  boolean isSpaceAvailable();

  /**
   * Lookup for a monkey in the housing using the name (unique).
   *
   * @param monkeyName for the unique name of the monkey.
   * @return
   */
  Object lookupMonkey(String monkeyName);

  /**
   * Report of all species in the housing.
   *
   * @return Sorted Set of all Species in the housing.
   */
  SortedSet reportAllSpeciesList();

  /**
   * List of Monkeys in the Housing.
   *
   * @return List of monkeys.
   */
  List reportAllMonkeyInHousing();

  /**
   * Look up a particular species in the housing.
   *
   * @param species type to lookup.
   * @return Boolean if the species type exists in the housing or not.
   */
  boolean lookupSpecies(Species species);

}
