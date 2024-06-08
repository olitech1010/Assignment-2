import java.util.Scanner;
import java.util.Stack;

class CreationDay {
    int dayNumber;
    private String verse;
    private String emoji;

    public CreationDay(int dayNumber, String verse, String emoji) {
        this.dayNumber = dayNumber;
        this.verse = verse;
        this.emoji = emoji;
    }

    public void displayDay() {
        System.out.println("Day " + dayNumber + ": " + verse + " " + emoji);
    }
}

public class CreationAccount {
    private static Stack<CreationDay> creationDays = new Stack<>();

    public static void main(String[] args) {
        populateCreationDays();
        userInterface();
    }

    private static void populateCreationDays() {
        creationDays.push(new CreationDay(1, "\"In the beginning, God created the heavens and the earth.\" - Genesis 1:1", "🌍"));
        creationDays.push(new CreationDay(2, "\"And God said, 'Let there be light,' and there was light.\" - Genesis 1:3", "☀️"));
        creationDays.push(new CreationDay(3, "\"And God said, 'Let there be a vault between the waters to separate water from water.'\" - Genesis 1:6", "🌌"));
        creationDays.push(new CreationDay(4, "\"And God said, 'Let the water under the sky be gathered to one place, and let dry ground appear.'\" - Genesis 1:9", "🏞️"));
        creationDays.push(new CreationDay(5, "\"Then God said, 'Let the land produce vegetation: seed-bearing plants and trees on the land that bear fruit with seed in it, according to their various kinds.'\" - Genesis 1:11", "🌿"));
        creationDays.push(new CreationDay(6, "\"And God said, 'Let there be lights in the vault of the sky to separate the day from the night, and let them serve as signs to mark sacred times, and days and years.'\" - Genesis 1:14", "☀️🌙⭐"));
        creationDays.push(new CreationDay(7, "\"And God said, 'Let the water teem with living creatures, and let birds fly above the earth across the vault of the sky.'\" - Genesis 1:20", "🐟🐦"));
        creationDays.push(new CreationDay(8, "\"And God said, 'Let the land produce living creatures according to their kinds: the livestock, the creatures that move along the ground, and the wild animals, each according to its kind.' And God said, 'Let us make mankind in our image, in our likeness, so that they may rule over the fish in the sea and the birds in the sky, over the livestock and all the wild animals, and over all the creatures that move along the ground.'\" - Genesis 1:24,26", "🦁👨"));
    }
    
    private static void userInterface() {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;

            do {
                System.out.println("Choose an option:");
                System.out.println("1. View a specific day");
                System.out.println("2. View all days in order");
                System.out.println("3. Exit");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter the day number: ");
                        int dayNumber = scanner.nextInt();
                        displaySpecificDay(dayNumber);
                        break;
                    case 2:
                        displayAllDays();
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                        break;
                }
            } while (choice != 3);
        }
    }

    private static void displaySpecificDay(int dayNumber) {
        for (CreationDay day : creationDays) {
            if (day.dayNumber == dayNumber) {
                day.displayDay();
                return;
            }
        }
        System.out.println("Invalid day number.");
    }

    private static void displayAllDays() {
        while (!creationDays.isEmpty()) {
            CreationDay day = creationDays.pop();
            day.displayDay();
        }
    }
}