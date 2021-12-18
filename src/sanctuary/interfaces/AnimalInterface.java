package sanctuary.interfaces;

import sanctuary.enums.Foods;
import sanctuary.enums.Sex;
import sanctuary.enums.Size;
import sanctuary.enums.Species;

/**
 * The animal interface for methods common to all animals in the sanctuary.
 *
 */
public interface AnimalInterface {

  /**
   * Get the name of the animal.
   *
   * @return String name.
   */
  String getName();

  /**
   * Get the Species type of the animal.
   *
   * @return Species type.
   */
  Species getSpeciesType();

  /**
   * Get the Sex of the animal.
   *
   * @return Sex.
   */
  Sex getSex();

  /**
   * Get the Size of the animal.
   *
   * @return Size.
   */
  Size getSize();

  /**
   * Set the Size of the animal.
   */
  void setSize(Size size);

  /**
   * Get the weight of the animal.
   *
   * @return Double weight.
   */
  double getWeight();

  /**
   * Set/update the weight of the animal.
   *
   * @param weight of the animal.
   */
  void setWeight(double weight);

  /**
   * Get age of the animal (in Months).
   *
   * @return Double age (in months).
   */
  double getAge();

  /**
   * Set/update the age of the animal.
   *
   * @param ageInMonths for age of animal in months.
   */
  void setAge(int ageInMonths);

  /**
   * Get favourite food of the animal.
   *
   * @return Favourite Food.
   */
  Foods getFavoriteFood();

  /**
   * toString method for display.
   *
   * @return String.
   */
  String toString();
}