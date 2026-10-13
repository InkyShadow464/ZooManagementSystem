import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ZooManager zoo = new ZooManager();
        boolean active = true;

        System.out.println("Welcome to the Zoo System for " + zoo.getZooName() + "!");
        // try and load data from a previously saved file from the system
        zoo.loadFromFile();

        // menu
        label:
        while(active){
            System.out.println();
            System.out.println("~~ Menu ~~");
            System.out.println("1. Add New Animal");
            System.out.println("2. Modify existing Animal");
            System.out.println("3. Remove Animal");
            System.out.println("4. View current Animals");
            System.out.println("5. Search for Animal");
            System.out.println("6. Perform Daily Care");
            System.out.println("7. Print Zoo Report");
            System.out.println("8. Close Program");

            try {
                System.out.println("Please enter a Number: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        zoo.addAnimal();
                        break;
                    case 2:
                        zoo.modifyAnimal();
                        break;
                    case 3:
                        zoo.removeAnimal();
                        break;
                    case 4:
                        zoo.viewAllAnimals();
                        break;
                    case 5:
                        zoo.searchAnimal();
                        break;
                    case 6:
                        zoo.dailyCare();
                        break;
                    case 7:
                        zoo.printZooReport();
                        break;
                    case 8:
                        System.out.println("Terminating Program");
                        active = false;
                        zoo.saveToFile();
                        break label;
                    default:
                        System.out.println("Please choose a valid option.");
                        break;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Input invalid. Please enter a valid number.");
                scanner.next();
            }
        }
    }
}
