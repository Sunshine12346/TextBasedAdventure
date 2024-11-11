import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Adventure Game!");
        System.out.println("You find yourself in a dark forest with only a small lantern and a map.");

        // Starting the adventure
        startAdventure(sc, random);

        System.out.println("Thank you for playing!");
        sc.close();
    }

    public static void startAdventure(Scanner scanner, Random random) {
        System.out.println("Choose your path:");
        System.out.println("1. Go north towards the mountains.");
        System.out.println("2. Head east into the dense forest.");

        int choice = getChoice(scanner, 1, 2);
        if (choice == 1) {
            mountainPath(scanner, random);
        } else {
            forestPath(scanner, random);
        }
    }

    public static void mountainPath(Scanner scanner, Random random) {
        System.out.println("You start climbing towards the mountains. It's getting colder and windier.");
        System.out.println("1. Look for a cave to rest.");
        System.out.println("2. Keep climbing higher.");

        int choice = getChoice(scanner, 1, 2);
        if (choice == 1) {
            if (random.nextInt(100) < 70) {  // 70% chance of success
                System.out.println("You find a small cave and take shelter. Inside, you find an old map and supplies!");
                System.out.println("You have completed the adventure safely. You win!");
            } else {
                System.out.println("The cave is occupied by a bear! You quickly run away, but end up lost in the mountains.");
                System.out.println("Sadly, you don’t survive the storm that night. Game over.");
            }
        } else {
            System.out.println("As you climb higher, a storm hits. You try to find shelter...");
            if (random.nextInt(100) < 40) {  // 40% chance of finding shelter
                System.out.println("You manage to find a small overhang and survive the storm.");
                System.out.println("You wait out the storm and descend the next day. You win!");
            } else {
                System.out.println("You lose your way in the snow and don’t survive the cold. Game over.");
            }
        }
    }

    public static void forestPath(Scanner scanner, Random random) {
        System.out.println("You enter the dense forest. It's quiet, with only the sound of rustling leaves.");
        System.out.println("1. Explore deeper into the forest.");
        System.out.println("2. Build a shelter and wait for daylight.");

        int choice = getChoice(scanner, 1, 2);
        if (choice == 1) {
            System.out.println("As you explore deeper, you find something mysterious...");
            if (random.nextInt(100) < 60) {  // 60% chance of finding treasure
                System.out.println("You encounter a strange glowing object. It turns out to be a hidden treasure!");
                System.out.println("Congratulations! You have found the treasure and completed the adventure.");
            } else {
                System.out.println("You get lost in the forest and encounter a pack of wolves.");
                System.out.println("You barely escape with your life, but you’re injured and lose your supplies. Game over.");
            }
        } else {
            System.out.println("You build a small shelter and rest, but in the middle of the night, you hear strange noises.");
            if (random.nextInt(100) < 50) {  // 50% chance of bandits arriving
                System.out.println("A group of bandits finds your shelter, and you lose all your belongings. Game over.");
            } else {
                System.out.println("The night passes peacefully. At dawn, you safely find your way out of the forest.");
                System.out.println("You survive the adventure and make it back to safety. You win!");
            }
        }
    }

    public static int getChoice(Scanner scanner, int min, int max) {
        int choice;
        do {
            System.out.print("Enter your choice (" + min + "-" + max + "): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear invalid input
            }
            choice = scanner.nextInt();
        } while (choice < min || choice > max);

        return choice;
    }
}
