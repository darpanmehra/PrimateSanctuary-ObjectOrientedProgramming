# About

* Class: **Programming Design Paradigms**
* Professor: **Clark Freifeld** (Northeastern University)
* Term: *Fall 2021*
* Design and developed: **Darpan Mehra**

# Project 1: Primate Sanctuary

The Primate Sanctuary provides a permanent home and high-quality sanctuary care for New World primates who have been cast-off from the pet trade, retired from research, or confiscated by authorities. They are seeking to replace all of their paper records with computer records where they can keep track of the individual animals that are in their care.

The sanctuary has two housing:

* **Isolation** - is used to keep monkeys when they first arrive at the sanctuary and anytime they are receiving medical attention. Isolation consists of a series of cages each of which can house a single animal.
* **Enclosure** - are much larger and can host a single troop (i.e., a group) of monkeys. Each troop consists of a single species that is found in the New World (some of which are pictured below): drill, guereza, howler, mangabey, saki, spider, squirrel, and tamarin.

## List of Features

* Create an Isolation with 'n' cages.
* Create multiple Enclosures of a specific size to house a troop of monkeys.
* Create monkey objects that are found in the open world.
* Change the weight of the Monkey.
* Change the age of the monkey.
* Change the size of the monkey.
* Data representation of the monkey object.
* Increase the capacity of the Isolation if required.
* Get the occupancy and availability of the isolation.
* Get the occupancy and availability of each enclosure.
* Add monkeys to the sanctuary (will go into Isolation first).
* Enclosure can hold a different type of Specie if it is free.
* Monkeys can be shifted from Isolation to Enclosure.
* If no enclosure is found. It is reported and the monkey stays in Isolation.
* Report of the species currently being housed in Isolation (in alphabetical order).
* Report of the species currently being housed in Enclosures (in alphabetical order).
* Lookup a species type in Isolation. If not found, it is reported.
* Lookup a species type in Enclosures. If not found, it is reported.
* A signboard for the Enclosures with details of all the Monkeys it holds.
* List of Monkeys in Isolation (in alphabetical order).
* List of Monkeys in each Enclosure (in alphabetical order).
* Create a shopping list of the favorite food of monkeys depending on their size.

## How to Run

Run the jar file.

```bash
cd /YourProjectDirectory/res
java -jar PrimateSanctuaryProject01.jar
```

## Description of Example

Running example of the program.

```Sanctuary starting up...

Creating Isolation with 10 cages
Isolation Created

Creating 3 Enclosures of size 50
Enclosure name: Enclosure 1, Size: 50, Species: Spider
Enclosure name: Enclosure 2, Size: 50, Species: Tamarin
Enclosure name: Enclosure 3, Size: 50, Species: Mangabey
Enclosure Created.

<---- Monkeys found in the open world: ---->
Monkey name: Emma
Monkey name: Drake
Monkey name: Emily
Monkey name: King
Monkey name: Kong
Monkey name: Emma

<---- Adding monkeys to sanctuary... ---->
Error: Cannot add Monkey- Emma. A monkey with name Emma already exists in Sanctuary.

<---- List of Monkeys in Isolation: ---->
Drake (Guereza) - Male - Fruits
Emily (Drill) - Female - Insects
Emma (Drill) - Female - Eggs
King (Tamarin) - Male - Fruits
Kong (Spider) - Male - Eggs

<---- Species List in the Sanctuary ---->
Isolation: [Drill, Guereza, Spider, Tamarin]
enclosure1: [No Species Found]
enclosure2: [No Species Found]
enclosure3: [No Species Found]

<---- Looking up Drill Species in Housing (True = Found, False = Not Found) ---->
Isolation: true
enclosure1: false
enclosure2: false
enclosure3: false

<---- Increasing Isolation size by 10 ---->
Current Capacity = 10, Occupied = 5
New Capacity = 20, Occupied = 5

<---- Shifting Monkey - Emma to Enclosure ---->
Monkey Shifted to Enclosure 1. Availability = 45

<---- Shifting Monkey - Drake to Enclosure ---->
Monkey Shifted to Enclosure 2. Availability = 40

<---- Shifting Monkey - Emily to Enclosure ---->
Monkey Shifted to Enclosure 1. Availability = 44

<---- Shifting Monkey - King to Enclosure ---->
Monkey Shifted to Enclosure 3. Availability = 40

<---- Shifting Monkey - Kong to Enclosure ---->
Cannot add Kong (Spider). No enclosure found for the Monkey

<---- Enclosure 1 Sign Board: ---->
Emily (Drill) - Female - Insects
Emma (Drill) - Female - Eggs

<---- Enclosure 2 Sign Board: ---->
Drake (Guereza) - Male - Fruits

<---- Enclosure 3 Sign Board: ---->
King (Tamarin) - Male - Fruits

<---- List of Monkeys in Isolation: ---->
Kong (Spider) - Male - Eggs

Shopping List (in gms): {Eggs=750, Fruits=1000, Insects=100}

Process finished with exit code 0
```

## Design & Model Changes

* There were complex tasks such as finding an enclosure for a monkey and shifting it, generating the shopping list for monkeys, lookup monkeys, etc. I have used a facade design pattern where all my method calls reside.
* I have used a Map data structure to store my monkeys in isolation and enclosure. This helps me in searching and getting a specific monkey in O(1) time complexity.
* Created more private helper methods which help in generating a shopping list.

## Assumptions

* A new species discovery is not frequent and may take several years to find a new species of monkey.

## Limitations
* Only monkeys with unique names can be added to the sanctuary.
