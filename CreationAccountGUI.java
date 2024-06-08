import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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

    public void displayDay(JTextArea textArea) {
        textArea.append("Day " + dayNumber + ": " + verse + " " + emoji + "\n");
    }
}

public class CreationAccountGUI {
    private static Stack<CreationDay> creationDays = new Stack<>();

    public static void main(String[] args) {
        populateCreationDays();
        createAndShowGUI();
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

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Creation Account");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.SOUTH);

        JButton viewDayButton = new JButton("View Specific Day");
        JButton viewAllDaysButton = new JButton("View All Days");
        JButton exitButton = new JButton("Exit");

        panel.add(viewDayButton);
        panel.add(viewAllDaysButton);
        panel.add(exitButton);

        viewDayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dayStr = JOptionPane.showInputDialog(frame, "Enter the day number:");
                try {
                    int dayNumber = Integer.parseInt(dayStr);
                    displaySpecificDay(dayNumber, textArea);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid day number.");
                }
            }
        });

        viewAllDaysButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayAllDays(textArea);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }

    private static void displaySpecificDay(int dayNumber, JTextArea textArea) {
        textArea.setText("");
        for (CreationDay day : creationDays) {
            if (day.dayNumber == dayNumber) {
                day.displayDay(textArea);
                return;
            }
        }
        textArea.append("Invalid day number.\n");
    }

    private static void displayAllDays(JTextArea textArea) {
        textArea.setText("");
        Stack<CreationDay> tempStack = new Stack<>();
        while (!creationDays.isEmpty()) {
            CreationDay day = creationDays.pop();
            day.displayDay(textArea);
            tempStack.push(day);
        }
        while (!tempStack.isEmpty()) {
            creationDays.push(tempStack.pop());
        }
    }
}
