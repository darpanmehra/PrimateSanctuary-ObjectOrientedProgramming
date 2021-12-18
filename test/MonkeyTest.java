import org.junit.Before;
import org.junit.Test;

import sanctuary.entities.Monkey;
import sanctuary.enums.Foods;
import sanctuary.enums.Sex;
import sanctuary.enums.Size;
import sanctuary.enums.Species;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Unit Tests for Monkey class.
 */
public class MonkeyTest {

  private Monkey monkey;

  /**
   * Initialize a monkey object.
   *
   * @throws Exception if weight is null or negative.
   */
  @Before
  public void setUp() throws Exception {
    monkey = new Monkey("Emma", Species.Drill, Sex.Female, Size.Medium,
            42, 24, Foods.Eggs);
  }

  /**
   * Test for invalid weight of the monkey.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidWeight() {
    monkey = new Monkey("Jake", Species.Spider, Sex.Male,
            Size.Small, -1, 24, Foods.Insects);
    fail("The monkey should not have been created.");
  }

  /**
   * Test for invalid age of the monkey.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAge() {
    monkey = new Monkey("Jake", Species.Spider, Sex.Male, Size.Small,
            12, -2, Foods.Insects);
    fail("The monkey should not have been created.");
  }

  /**
   * Test for invalid age & weight of the monkey.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAgeAndWeight() {
    monkey = new Monkey("Jake", Species.Spider, Sex.Male, Size.Small,
            -10, -2, Foods.Insects);
    fail("The monkey should not have been created.");
  }

  /**
   * Test for the name of the monkey.
   */
  @Test
  public void getName() {
    assertEquals("Emma", monkey.getName());
  }

  /**
   * Test for the species of the monkey.
   */
  @Test
  public void getSpeciesType() {
    assertEquals(Species.Drill, monkey.getSpeciesType());
  }

  /**
   * Test for sex of the monkey.
   */
  @Test
  public void getSex() {
    assertEquals(Sex.Female, monkey.getSex());
  }

  /**
   * Test for size of the monkey.
   */
  @Test
  public void getSize() {
    assertEquals(Size.Medium, monkey.getSize());
  }

  /**
   * Test the set Size method.
   */
  @Test
  public void setSize() {
    monkey.setSize(Size.Large);
    assertEquals(Size.Large, monkey.getSize());
  }

  /**
   * Test the get weight method.
   */
  @Test
  public void getWeight() {
    assertEquals(42, monkey.getWeight(), 0);
  }

  /**
   * Test the set weight method.
   */
  @Test
  public void setWeight() {
    monkey.setWeight(98);
    assertEquals(98, monkey.getWeight(), 0);
  }

  /**
   * Test the set negative weight method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void setNegativeWeight() {
    monkey.setWeight(-1);
    assertEquals(98, monkey.getWeight(), 0);
  }

  /**
   * Test the get age method.
   */
  @Test
  public void getAge() {
    assertEquals(24, monkey.getAge(), 0);
  }

  /**
   * Test the set age method.
   */
  @Test
  public void setAge() {
    monkey.setAge(45);
    assertEquals(45, monkey.getAge(), 0);
  }

  /**
   * Test the set negative age method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void setNegativeAge() {
    monkey.setAge(-1);
  }

  /**
   * Test the get favourite food method.
   */
  @Test
  public void getFavoriteFood() {
    assertEquals(Foods.Eggs, monkey.getFavoriteFood());
  }

  /**
   * Get for space the monkey will occupy as per size.
   */
  @Test
  public void getSpaceOccupancy() {
    assertEquals(5, monkey.getSpaceOccupancy());
  }

  /**
   * Test the toString method.
   */
  @Test
  public void testToString() {
    assertEquals("Emma (Drill) - Female - Eggs", monkey.toString());
  }

  @Test
  public void addMonkeyWithoutSize(){
    monkey = new Monkey("Jake", Species.Spider, Sex.Male, Size.Small,
            12, -2, Foods.Insects);
  }
}