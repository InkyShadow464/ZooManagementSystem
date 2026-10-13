import java.util.ArrayList;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ZooManager {

    private ArrayList<Animal> animals = new ArrayList<>();
    private String zooName = "Belfast City Zoo";
    private Scanner scanner = new Scanner(System.in);

    // get zoo name for welcome message
    public String getZooName() {
        return zooName;
    }

    // ---------- ADD ANIMAL ----------
    public void addAnimal() {
        System.out.println("\nWhat type of animal?");
        System.out.println("1. Dog");
        System.out.println("2. Hawk");
        System.out.println("3. Seal");
        int type = scanner.nextInt();
        if (type < 1 || type > 3){
            System.out.println("Invalid animal choice.");
            scanner.nextLine(); // clear buffer
            return;
        }
        scanner.nextLine(); // clear buffer

        System.out.print("Name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be blank. Animal not added.");
            return;
        }

        int age;
        try {
            System.out.print("Age: ");
            age = scanner.nextInt();
            scanner.nextLine(); // clear buffer
            if (age <= 0) {
                System.out.println("Age must be greater than 0. Animal not added.");
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid age - please enter a whole number. Animal not added.");
            scanner.nextLine();
            return;
        }

        // -- COLOUR --
        System.out.print("Colour: ");
        String colour = scanner.nextLine().trim();
        if (colour.isEmpty()) {
            System.out.println("Colour cannot be blank. Animal not added.");
            return;
        }

        // -- WEIGHT --
        int weight;
        try {
            System.out.print("Weight (kg): ");
            weight = scanner.nextInt();
            scanner.nextLine(); // clear buffer
            if (weight <= 0) {
                System.out.println("Weight must be greater than 0. Animal not added.");
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid weight - please enter a whole number. Animal could not be added.");
            scanner.nextLine();
            return;
        }

        switch (type) {
            // Dog Case
            case 1:
                System.out.print("Breed: ");
                String breed = scanner.nextLine().trim();
                if (breed.isEmpty()) {
                    System.out.println("Breed cannot be blank. Animal could not be added");
                    return;
                }
                animals.add(new Dog(name, age, colour, weight, breed));
                break;

            // Hawk Case
            case 2:
                System.out.print("Wingspan (cm): ");
                int wingSpan = scanner.nextInt();
                scanner.nextLine();
                if (wingSpan <= 0) {
                    System.out.println("Invalid wingspan. Animal could not be added.");
                    return;
                }
                animals.add(new Hawk(name, age, colour, weight, wingSpan));
                break;

            // Seal Case
            case 3:
                System.out.println("Skill Level:");
                System.out.println("1. Novice");
                System.out.println("2. Intermediate");
                System.out.println("3. Expert");

                int skillInput = scanner.nextInt();
                scanner.nextLine();
                if (skillInput < 1 || skillInput > 3) {
                    System.out.println("Invalid skill level. Animal could not be added.");
                    return;
                }
                animals.add(new Seal(name, age, colour, weight, skillInput));
                break;

            default:
                System.out.println("Invalid animal type");
                return;
        }
        System.out.println("Animal added successfully!");
    }

    // ---------- REMOVE ANIMAL ----------
    public void removeAnimal() {
        if (animals.isEmpty()) {
            System.out.println("No animals registered.");
            return;
        }
        System.out.print("Enter the name of the animal to remove: ");
        String name = scanner.nextLine().trim();

        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getName().equalsIgnoreCase(name)) {
                animals.remove(i);
                System.out.println(name + " has been removed.");
                return;
            }
        }
        System.out.println("No animal was found with the name: " + name);
    }

    // ---------- MODIFY ANIMAL ----------
    public void modifyAnimal() {
        if (animals.isEmpty()) {
            System.out.println("No animals registered.");
            return;
        }

        System.out.print("Enter the name of the animal to modify: ");
        String name = scanner.nextLine().trim();

        for (Animal a : animals) {
            if (a.getName().equalsIgnoreCase(name)) {

                System.out.println("\nWhat would you like to modify?");
                System.out.println("1. Name");
                System.out.println("2. Age");
                System.out.println("3. Colour");
                System.out.println("4. Weight");

                // show the subclass specific option depending on animal type
                if (a instanceof Dog) {
                    System.out.println("5. Breed");
                } else if (a instanceof Hawk) {
                    System.out.println("5. Wingspan");
                } else if (a instanceof Seal) {
                    System.out.println("5. Skill Level");
                }

                try {
                    System.out.print("Enter choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {

                        case 1:
                            System.out.print("New name: ");
                            String newName = scanner.nextLine().trim();
                            if (newName.isEmpty()) {
                                System.out.println("Name cannot be blank. No changes made.");
                                return;
                            }
                            a.setName(newName);
                            break;

                        case 2:
                            System.out.print("New age: ");
                            int newAge = scanner.nextInt();
                            scanner.nextLine();
                            if (newAge <= 0) {
                                System.out.println("Age must be greater than 0. No changes made.");
                                return;
                            }
                            a.setAge(newAge);
                            break;

                        case 3:
                            System.out.print("New colour: ");
                            String newColour = scanner.nextLine().trim();
                            if (newColour.isEmpty()) {
                                System.out.println("Colour cannot be blank. No changes made.");
                                return;
                            }
                            a.setColour(newColour);
                            break;

                        case 4:
                            System.out.print("New weight (kg): ");
                            int newWeight = scanner.nextInt();
                            scanner.nextLine();
                            if (newWeight <= 0) {
                                System.out.println("Weight must be greater than 0. No changes made.");
                                return;
                            }
                            a.setWeight(newWeight);
                            break;

                        case 5:
                            // handle the subclass specific attribute
                            if (a instanceof Dog) {
                                System.out.print("New breed: ");
                                String newBreed = scanner.nextLine().trim();
                                if (newBreed.isEmpty()) {
                                    System.out.println("Breed cannot be blank. No changes made.");
                                    return;
                                }
                                ((Dog) a).setBreed(newBreed);

                            } else if (a instanceof Hawk) {
                                System.out.print("New wingspan (cm): ");
                                int newWingSpan = scanner.nextInt();
                                scanner.nextLine();
                                if (newWingSpan <= 0) {
                                    System.out.println("Wingspan must be greater than 0. No changes made.");
                                    return;
                                }
                                ((Hawk) a).setWingSpan(newWingSpan);

                            } else if (a instanceof Seal) {
                                System.out.println("New skill level:");
                                System.out.println("1. Novice");
                                System.out.println("2. Intermediate");
                                System.out.println("3. Expert");
                                int newSkill = scanner.nextInt();
                                scanner.nextLine();
                                if (newSkill < 1 || newSkill > 3) {
                                    System.out.println("Invalid skill level. No changes made.");
                                    return;
                                }
                                ((Seal) a).setSkillLevel(newSkill);
                            }
                            break;

                        default:
                            System.out.println("Invalid choice. No changes made.");
                            return;
                    }

                    System.out.println("Animal updated successfully!");
                    return;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. No changes made.");
                    scanner.nextLine();
                    return;
                }
            }
        }
        System.out.println("No animal found with the name: " + name);
    }

    // ---------- VIEW ALL ANIMALS ----------
    public void viewAllAnimals() {
        if (animals.isEmpty()) {
            System.out.println("No animals registered.");
            return;
        }
        System.out.println("\n── All Animals at " + zooName + " ──");
        for (Animal a : animals) {
            printAnimalDetails(a);
        }
    }

    // helper to print a single animal's details
    private void printAnimalDetails(Animal a) {
        System.out.println("-----------------------------");
        System.out.println("Type   : " + a.getClass().getSimpleName());
        System.out.println("Name   : " + a.getName());
        System.out.println("Age    : " + a.getAge());
        System.out.println("Colour : " + a.getColour());
        System.out.println("Weight : " + a.getWeight() + "kg");

        // print subclass-specific details
        if (a instanceof Dog) {
            System.out.println("Breed  : " + ((Dog) a).getBreed());
        } else if (a instanceof Hawk) {
            System.out.println("Wingspan: " + ((Hawk) a).getWingSpan() + "cm");
            System.out.println("Max Altitude: " + ((Hawk) a).getMaxAltitude() + "m");
        } else if (a instanceof Seal) {
            System.out.println("Skill  : " + ((Seal) a).getSkillLevel());
            System.out.println("Swim Speed: " + ((Seal) a).getSwimSpeed() + "mph");
        }

        System.out.println("Sound  : " + a.makeSound());
    }

    // ---------- SEARCH ANIMALS ----------
    public void searchAnimal() {
        if (animals.isEmpty()) {
            System.out.println("No animals registered.");
            return;
        }
        System.out.println("Search by:");
        System.out.println("1. Name");
        System.out.println("2. Colour");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter search term: ");
        String term = scanner.nextLine().trim();

        boolean found = false;
        if (term == "") {
            System.out.println("Search term cannot be blank");
            return;
        }
        for (Animal a : animals) {
            boolean match = (choice == 1 && a.getName().equalsIgnoreCase(term)) ||
                    (choice == 2 && a.getColour().equalsIgnoreCase(term));
            if (match) {
                printAnimalDetails(a);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No animals found matching: " + term);
        }
    }

    // ---------- DAILY CARE ----------
    public void dailyCare() {
        if (animals.isEmpty()) {
            System.out.println("No animals to care for.");
            return;
        }
        System.out.println("\n── Daily Care ──");
        for (Animal a : animals) {
            System.out.println("\nCaring for " + a.getName() + "...");
            System.out.println("Feeding " + a.getName() + ".");

            // specialised care based on interface
            if (a instanceof Flyable) {
                ((Flyable) a).checkWingHealth();
                ((Flyable) a).fly();
            }
            if (a instanceof Swimmable) {
                ((Swimmable) a).checkFinHealth();
                ((Swimmable) a).swim();
            }
        }
        System.out.println("\nDaily care complete!");
    }

    // ---------- ZOO REPORT ----------
    public void printZooReport() {
        System.out.println("\n══ Zoo Report: " + zooName + " ══");
        System.out.println("Total animals: " + animals.size());

        int dogCount = 0, hawkCount = 0, sealCount = 0;
        for (Animal a : animals) {
            if (a instanceof Dog) dogCount++;
            else if (a instanceof Hawk) hawkCount++;
            else if (a instanceof Seal) sealCount++;
        }

        System.out.println("Dogs : " + dogCount);
        System.out.println("Hawks: " + hawkCount);
        System.out.println("Seals: " + sealCount);
        System.out.println("Dominant colour: " + getDominantColour());
        System.out.println("Average Age    : " + getAverageAge() + " years");
        System.out.println("Average Weight : " + getAverageWeight() + " kg");
    }

    // finds the most common colour across all animals
    private String getDominantColour() {
        if (animals.isEmpty()) return "N/A";

        ArrayList<String> colours = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();

        for (Animal a : animals) {
            String col = a.getColour().toLowerCase();
            int index = colours.indexOf(col);
            if (index == -1) {
                colours.add(col);
                counts.add(1);
            } else {
                counts.set(index, counts.get(index) + 1);
            }
        }

        int maxIndex = 0;
        for (int i = 1; i < counts.size(); i++) {
            if (counts.get(i) > counts.get(maxIndex)) {
                maxIndex = i;
            }
        }
        return colours.get(maxIndex);
    }

    // calculates average age of all animals
    private double getAverageAge() {
        if (animals.isEmpty()) return 0;
        int total = 0;
        for (Animal a : animals) {
            total += a.getAge();
        }
        return Math.round((double) total / animals.size() * 10.0) / 10.0;
    }

    // calculates average weight of all animals
    private double getAverageWeight() {
        if (animals.isEmpty()) return 0;
        int total = 0;
        for (Animal a : animals) {
            total += a.getWeight();
        }
        return Math.round((double) total / animals.size() * 10.0) / 10.0;
    }

    // ---------- SAVE TO FILE ----------
    public void saveToFile() {
        // save zoo details
        try (PrintWriter pw = new PrintWriter(new FileWriter("ZooDetails.txt"))) {
            pw.println("─── ZOO DETAILS ───");
            pw.println("── General Information ──");
            pw.println("Zoo Name: " + zooName);
            pw.println("Total Animals: " + animals.size());
            pw.println("Dominant Colour: " + getDominantColour().substring(0,1).toUpperCase() + getDominantColour().substring(1));
            // count each type
            int dogCount = 0, hawkCount = 0, sealCount = 0;
            for (Animal a : animals) {
                if (a instanceof Dog) dogCount++;
                else if (a instanceof Hawk) hawkCount++;
                else if (a instanceof Seal) sealCount++;
            }

            // animal counts
            pw.println("── Animal Counts ──");
            pw.println("Dogs : " + dogCount);
            pw.println("Hawks: " + hawkCount);
            pw.println("Seals: " + sealCount);

            // average age and weight
            pw.println("── Statistics ──");
            pw.println("Average Age    : " + getAverageAge() + " years");
            pw.println("Average Weight : " + getAverageWeight() + " kg");
            pw.println();

            System.out.println("Zoo details saved to ZooDetails.txt");
        } catch (IOException e) {
            System.out.println("Error saving zoo details: " + e.getMessage());
        }

        // save animal details
        try (PrintWriter pw = new PrintWriter(new FileWriter("AnimalDetails.txt"))) {
            for (Animal a : animals) {
                // skip invalid animals (empty fields)
                if (a.getName().isEmpty() || a.getColour().isEmpty()) continue;

                if (a instanceof Dog) {
                    Dog d = (Dog) a;
                    pw.println("DOG," + d.getName() + "," + d.getAge() + "," +
                            d.getColour() + "," + d.getWeight() + "," + d.getBreed());
                } else if (a instanceof Hawk) {
                    Hawk h = (Hawk) a;
                    pw.println("HAWK," + h.getName() + "," + h.getAge() + "," +
                            h.getColour() + "," + h.getWeight() + "," + h.getWingSpan());
                } else if (a instanceof Seal) {
                    Seal s = (Seal) a;
                    pw.println("SEAL," + s.getName() + "," + s.getAge() + "," +
                            s.getColour() + "," + s.getWeight() + "," + s.getSkillLevel());
                }
            }
            System.out.println("Animal details saved to AnimalDetails.txt");
        } catch (IOException e) {
            System.out.println("Error saving animal details: " + e.getMessage());
        }
    }

    // ---------- LOAD FROM FILE ----------
    public void loadFromFile() {
        File file = new File("AnimalDetails.txt");
        // if file doesn't exist, inform user
        if (!file.exists()) {
            System.out.println("No saved data found. Starting fresh.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader("AnimalDetails.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // splits each line's contents at the comma
                String[] parts = line.split(",");
                switch (parts[0]) {
                    case "DOG":
                        animals.add(new Dog(parts[1], Integer.parseInt(parts[2]),
                                parts[3], Integer.parseInt(parts[4]), parts[5]));
                        break;
                    case "HAWK":
                        animals.add(new Hawk(parts[1], Integer.parseInt(parts[2]),
                                parts[3], Integer.parseInt(parts[4]),
                                Integer.parseInt(parts[5])));
                        break;
                    case "SEAL":
                        // skill level is saved as a string so it is added directly
                        Seal s = new Seal(parts[1], Integer.parseInt(parts[2]),
                                parts[3], Integer.parseInt(parts[4]), 1);
                        s.setSkillLevel(parts[5]); // set the string directly
                        animals.add(s);
                        break;
                }
            }
            System.out.println("Previous data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
