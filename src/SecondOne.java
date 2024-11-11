import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

    public class SecondOne {
    private static final ArrayList<String> inventory = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);
    private static final Random random = new Random();

    // Player's starting position
    private static int posX = 0;
    private static int posY = 0;

    // Map layout with descriptions of each location
    private static final Map<String, String> map = new HashMap<>() {{
        put("0,0", "You are in a dark forest. Trees surround you, and there's a path to the north, south, east, and west.");
        put("0,1", "You find a sparkling river. Something might be hidden in the water.");
        put("1,0", "You see an abandoned village with ruined buildings. There might be useful items around.");
        put("0,-1", "There’s a mountain path here. You can climb up to explore.");
        put("-1,0", "You enter a dense forest area. It’s quiet, but you feel like you’re being watched.");
    }};

    public static void main(String[] args) {
        System.out.println("Welcome to the Expanded Adventure Game!");
        System.out.println(map.get("0,0")); // Starting location description
        startGame();
    }

    public static void startGame() {
        while (true) {
            System.out.print("\nWhat do you want to do? ");

            switch (sc.nextLine().toLowerCase()) {
                case "north": move(0, 1); break;
                case "south": move(0, -1); break;
                case "east": move(1, 0); break;
                case "west": move(-1, 0); break;
                case "inventory": showInventory(); break;
                case "help": showHelp(); break;
                case "quit":
                case "exit":
                    System.out.println("Thanks for playing! Goodbye.");
                    return;
                default: System.out.println("Unknown command. Type 'help' for a list of commands.");
            }
        }
    }

    public static void move(int dx, int dy) {
        posX += dx;
        posY += dy;
        String locationKey = posX + "," + posY;

        if (map.containsKey(locationKey)) {
            System.out.println(map.get(locationKey));
            randomEvent();
        } else {
            System.out.println("You encounter an impassable terrain and return to your previous position.");
            posX -= dx;
            posY -= dy;
        }
    }

    public static void randomEvent() {
        int event = random.nextInt(4);
        switch (event) {
            case 0:
                System.out.println("You found a mysterious amulet on the ground.");
                addItem("Mysterious Amulet");
                break;
            case 1:
                System.out.println("You encounter a wild creature! You manage to escape unharmed.");
                break;
            case 2:
                System.out.println("You found an old map fragment. It might lead to treasure.");
                addItem("Map Fragment");
                break;
            case 3:
                System.out.println("The area seems eerily quiet... Nothing happens.");
                break;
        }
    }

    public static void addItem(String item) {
        if (!inventory.contains(item)) {
            inventory.add(item);
            System.out.println("You added " + item + " to your inventory.");
        } else {
            System.out.println("You already have " + item + ".");
        }
    }

    public static void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Inventory:");
            for (String item : inventory) {
                System.out.println("- " + item);
            }
        }
    }

    public static void showHelp() {
        System.out.println("Commands:");
        System.out.println("- north: Move north");
        System.out.println("- south: Move south");
        System.out.println("- east: Move east");
        System.out.println("- west: Move west");
        System.out.println("- inventory: Show your inventory");
        System.out.println("- help: Show this help menu");
    }
}
