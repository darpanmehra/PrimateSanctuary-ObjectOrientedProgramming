package sanctuary;

import java.util.List;
import sanctuary.entities.Monkey;
import sanctuary.enums.Foods;
import sanctuary.enums.Sex;
import sanctuary.enums.Size;
import sanctuary.enums.Species;
import sanctuary.housing.Enclosure;


/**
 * Main entry point of the program that gives options to the users to execute tasks.
 */

public class Driver {

  /**
   * Main method for the program.
   *
   * @param args default.
   */
  public static void main(String[] args) {

    Sanctuary sanctuary = new Sanctuary();

    System.out.println("Sanctuary starting up...\n");

    System.out.println("Creating Isolation with 10 cages");
    sanctuary.createIsolation(10);
    System.out.println("Isolation Created \n");

    System.out.println("Creating 3 Enclosures of size 50");
    Enclosure enclo1 = (Enclosure) sanctuary.createEnclosure(
            "Enclosure 1", 50, Species.Spider);
    System.out.println("Enclosure name: " + enclo1.getName()
            + ", Size: " + enclo1.getTotalCapacity() + ", Species: " + enclo1.getSpecies());

    Enclosure enclo2 = (Enclosure) sanctuary.createEnclosure(
            "Enclosure 2", 50, Species.Tamarin);
    System.out.println("Enclosure name: " + enclo2.getName()
            + ", Size: " + enclo2.getTotalCapacity() + ", Species: " + enclo2.getSpecies());

    Enclosure enclo3 = (Enclosure) sanctuary.createEnclosure(
            "Enclosure 3", 50, Species.Mangabey);
    System.out.println("Enclosure name: " + enclo3.getName()
            + ", Size: " + enclo3.getTotalCapacity() + ", Species: " + enclo3.getSpecies());
    System.out.println("Enclosure Created. \n");

    System.out.println("<---- Monkeys found in the open world: ---->");
    Monkey monkey1 = (Monkey) sanctuary.createMonkey("Emma", Species.Drill, Sex.Female,
            Size.Medium, 42, 24, Foods.Eggs);
    System.out.println("Monkey name: " + monkey1.getName());

    Monkey monkey2 = (Monkey) sanctuary.createMonkey("Drake", Species.Guereza, Sex.Male,
            Size.Large, 82, 44, Foods.Fruits);
    System.out.println("Monkey name: " + monkey2.getName());

    Monkey monkey3 = (Monkey) sanctuary.createMonkey("Emily", Species.Drill, Sex.Female,
            Size.Small, 12, 4, Foods.Insects);
    System.out.println("Monkey name: " + monkey3.getName());

    Monkey monkey4 = (Monkey) sanctuary.createMonkey("King", Species.Tamarin, Sex.Male,
            Size.Large, 82, 44, Foods.Fruits);
    System.out.println("Monkey name: " + monkey4.getName());

    Monkey monkey5 = (Monkey) sanctuary.createMonkey("Kong", Species.Spider, Sex.Male,
            Size.Large, 22, 40, Foods.Eggs);
    System.out.println("Monkey name: " + monkey5.getName());

    Monkey monkey6 = (Monkey) sanctuary.createMonkey("Emma", Species.Drill, Sex.Male,
            Size.Large, 42, 24, Foods.Insects);
    System.out.println("Monkey name: " + monkey6.getName());

    System.out.println("\n<---- Adding monkeys to sanctuary... ---->");

    sanctuary.addMonkeyToSanctuary(monkey1);
    sanctuary.addMonkeyToSanctuary(monkey4);
    sanctuary.addMonkeyToSanctuary(monkey2);
    sanctuary.addMonkeyToSanctuary(monkey5);
    sanctuary.addMonkeyToSanctuary(monkey3);
    sanctuary.addMonkeyToSanctuary(monkey6);

    System.out.println("\n<---- List of Monkeys in Isolation: ---->");
    List monkeyListInHousing = sanctuary.getMonkeysInIsolation();
    if (monkeyListInHousing.isEmpty()) {
      System.out.println("No Monkey in Isolation");
    } else {
      for (Object monkey : monkeyListInHousing) {
        System.out.println(monkey);
      }
    }

    System.out.println("\n<---- Species List in the Sanctuary ---->");
    System.out.println("Isolation: " + sanctuary.getSpeciesListInIsolation());
    System.out.println("enclosure1: " + sanctuary.getSpeciesListInEnclosure(enclo1));
    System.out.println("enclosure2: " + sanctuary.getSpeciesListInEnclosure(enclo2));
    System.out.println("enclosure3: " + sanctuary.getSpeciesListInEnclosure(enclo3));

    System.out.println("\n<---- Looking up Drill Species in Housing (True = " +
            "Found, False = Not Found) ---->");
    System.out.println("Isolation: " + sanctuary.lookupSpeciesInIsolation(Species.Drill));
    System.out.println("enclosure1: " + sanctuary.lookupSpeciesInEnclosure(enclo1, Species.Drill));
    System.out.println("enclosure2: " + sanctuary.lookupSpeciesInEnclosure(enclo2, Species.Drill));
    System.out.println("enclosure3: " + sanctuary.lookupSpeciesInEnclosure(enclo3, Species.Drill));

    System.out.println("\n<---- Increasing Isolation size by 10 ---->");
    System.out.println("Current Capacity = " + sanctuary.getIsolationCapacity()
            + ", Occupied = " + sanctuary.getIsolationOccupancy());
    sanctuary.increaseIsolationCapacity(10);
    System.out.println("New Capacity = " + sanctuary.getIsolationCapacity()
            + ", Occupied = " + sanctuary.getIsolationOccupancy());

    System.out.println("\n<---- Shifting Monkey - " + monkey1.getName() + " to Enclosure ---->");
    Enclosure monkeyShiftedLocation = (Enclosure) sanctuary.shiftMonkeyToEnclosure(monkey1);
    System.out.println("Monkey Shifted to " + monkeyShiftedLocation.getName()
            + ". Availability = " + monkeyShiftedLocation.getAvailableSpace());

    System.out.println("\n<---- Shifting Monkey - " + monkey2.getName() + " to Enclosure ---->");
    monkeyShiftedLocation = (Enclosure) sanctuary.shiftMonkeyToEnclosure(monkey2);
    System.out.println("Monkey Shifted to " + monkeyShiftedLocation.getName()
            + ". Availability = " + monkeyShiftedLocation.getAvailableSpace());

    System.out.println("\n<---- Shifting Monkey - " + monkey3.getName() + " to Enclosure ---->");
    monkeyShiftedLocation = (Enclosure) sanctuary.shiftMonkeyToEnclosure(monkey3);
    System.out.println("Monkey Shifted to " + monkeyShiftedLocation.getName()
            + ". Availability = " + monkeyShiftedLocation.getAvailableSpace());

    System.out.println("\n<---- Shifting Monkey - " + monkey4.getName() + " to Enclosure ---->");
    monkeyShiftedLocation = (Enclosure) sanctuary.shiftMonkeyToEnclosure(monkey4);
    System.out.println("Monkey Shifted to " + monkeyShiftedLocation.getName()
            + ". Availability = " + monkeyShiftedLocation.getAvailableSpace());

    System.out.println("\n<---- Shifting Monkey - " + monkey5.getName() + " to Enclosure ---->");
    sanctuary.shiftMonkeyToEnclosure(monkey5);


    System.out.println("\n<---- Enclosure 1 Sign Board: ---->");
    monkeyListInHousing = sanctuary.getEnclosureSignBoard(enclo1);
    if (monkeyListInHousing.isEmpty()) {
      System.out.println("No Monkey in Enclosure");
    } else {
      for (Object monkey : monkeyListInHousing) {
        System.out.println(monkey);
      }
    }

    System.out.println("\n<---- Enclosure 2 Sign Board: ---->");
    monkeyListInHousing = sanctuary.getEnclosureSignBoard(enclo2);
    if (monkeyListInHousing.isEmpty()) {
      System.out.println("No Monkey in Enclosure");
    } else {
      for (Object monkey : monkeyListInHousing) {
        System.out.println(monkey);
      }
    }

    System.out.println("\n<---- Enclosure 3 Sign Board: ---->");
    monkeyListInHousing = sanctuary.getEnclosureSignBoard(enclo3);
    if (monkeyListInHousing.isEmpty()) {
      System.out.println("No Monkey in Enclosure");
    } else {
      for (Object monkey : monkeyListInHousing) {
        System.out.println(monkey);
      }
    }

    System.out.println("\n<---- List of Monkeys in Isolation: ---->");
    monkeyListInHousing = sanctuary.getMonkeysInIsolation();
    if (monkeyListInHousing.isEmpty()) {
      System.out.println("No Monkey in Enclosure");
    } else {
      for (Object monkey : monkeyListInHousing) {
        System.out.println(monkey);
      }
    }

    System.out.println("\nShopping List (in gms): " + sanctuary.getShoppingList());

  }

}
