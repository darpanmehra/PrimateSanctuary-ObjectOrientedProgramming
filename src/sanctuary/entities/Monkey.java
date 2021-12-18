package sanctuary.entities;

import sanctuary.interfaces.AnimalInterface;
import sanctuary.enums.Foods;
import sanctuary.enums.Sex;
import sanctuary.enums.Size;
import sanctuary.enums.Species;

/**
 * Monkey Class denoted the monkey with its several attributes.
 */
public class Monkey implements AnimalInterface {

  private final String name;
  private final Species species;
  private final Sex sex;
  private Size size;
  private double weight;
  private double ageInMonths;
  private final Foods favFood;

  /**
   * Monkey Constructor to create Monkey object.
   *
   * @param name        specifies the name of the monkey.
   * @param species     specifies the species type of the monkey.
   * @param sex         specifies the sex type of the monkey.
   * @param size        specifies the size type of the monkey.
   * @param weight      specifies the weight type of the monkey.
   * @param ageInMonths specifies the age type of the monkey (in months).
   * @param favFood     specifies the favourite food of the monkey.
   */
  public Monkey(String name, Species species, Sex sex, Size size, double weight,
                double ageInMonths, Foods favFood) {
    if (weight < 0 || ageInMonths < 0) {
      throw new IllegalArgumentException("Weight and Age cannot be 0 or less.");
    }
    this.name = name;
    this.species = species;
    this.sex = sex;
    this.size = size;
    this.weight = weight;
    this.ageInMonths = ageInMonths;
    this.favFood = favFood;
  }

  /**
   * Copy constructor to create a copy of the monkey.
   *
   * @param monkey object to be copied in a new Monkey object.
   */
  public Monkey(Monkey monkey) {
    if (monkey == null) {
      throw new IllegalArgumentException("Monkey object is null");
    }
    this.name = monkey.name;
    this.species = monkey.species;
    this.sex = monkey.sex;
    this.size = monkey.size;
    this.weight = monkey.weight;
    this.ageInMonths = monkey.ageInMonths;
    this.favFood = monkey.favFood;
  }

  /**
   * Get the name of the monkey.
   *
   * @return String name of the monkey.
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * Get the Species type of the monkey.
   *
   * @return Species type of the monkey.
   */
  @Override
  public Species getSpeciesType() {
    return this.species;
  }

  /**
   * Get the Sex of the monkey.
   *
   * @return Sex type of the monkey.
   */
  @Override
  public Sex getSex() {
    return this.sex;
  }

  /**
   * Get size of the monkey.
   *
   * @return the size type of the monkey.
   */
  @Override
  public Size getSize() {
    return this.size;
  }

  /**
   * Set the Size of the monkey.
   *
   * @param size size of the monkey.
   */
  @Override
  public void setSize(Size size) {
    this.size = size;
  }

  /**
   * Get weight of the monkey.
   *
   * @return the weight of the monkey.
   */
  @Override
  public double getWeight() {
    return this.weight;
  }

  /**
   * Set the weight of the monkey.
   *
   * @param weight of the monkey.
   */
  @Override
  public void setWeight(double weight) {
    if (weight <= 0) {
      throw new IllegalArgumentException("Weight cannot be 0 or less.");
    }
    this.weight = weight;
  }

  /**
   * Get age of the monkey.
   *
   * @return the age of the monkey (in months).
   */
  @Override
  public double getAge() {
    return this.ageInMonths;
  }

  /**
   * Set the age of the monkey.
   *
   * @param ageInMonths for age of monkey in months.
   */
  @Override
  public void setAge(int ageInMonths) {
    if (ageInMonths <= 0) {
      throw new IllegalArgumentException("Age cannot be 0 or less.");
    }
    this.ageInMonths = ageInMonths;
  }

  /**
   * Get favourite food of the monkey.
   *
   * @return the favourite food of the monkey.
   */
  @Override
  public Foods getFavoriteFood() {
    return this.favFood;
  }

  /**
   * toString method for data representation.
   *
   * @return overview of the attributes of the monkey (Name (Species) - Sex - Favourite Food).
   */
  @Override
  public String toString() {
    return String.format("%s (%s) - %s - %s",
            this.name, this.species, this.sex, this.favFood);
  }

  /**
   * Get the space the monkey will occupy in the sanctuary.
   */
  public int getSpaceOccupancy() {
    switch (this.size) {
      case Large:
        return 10;
      case Medium:
        return 5;
      case Small:
        return 1;
      default:
        return 0;
    }
  }

}
