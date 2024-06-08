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
        creationDays.push(new CreationDay(1, "In the beginning, God created the heavens and the earth...", "🌍"));
        creationDays.push(new CreationDay(2, "And God said, 'Let there be light'...", "☀️"));
        // Add instances for the remaining days
        // ...
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