import java.util.ArrayList;
import java.util.Scanner;

public class App {
    // Priority lists stored as static variables for easy access across methods
    private static ArrayList<Task> high = new ArrayList<>();
    private static ArrayList<Task> medium = new ArrayList<>();
    private static ArrayList<Task> low = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        
        do {
            printMenu();
            choice = sc.nextInt();
            sc.nextLine(); // consume newline for buffer problems
            
            switch (choice) {
                case 1:
                    addTask(sc); //scanner is for main so we have to pass it to the method
                    break;
                case 2:
                    removeTask(sc);
                    break;
                case 3:
                    listTasks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (choice != 4);
        
        sc.close();
    }
    
    private static void printMenu() {
        System.out.println("\nTask Manager Menu:");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. List Tasks");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }
    
    private static void addTask(Scanner sc) {
        System.out.print("Enter your task description: ");
        String description = sc.nextLine();
        Task task = new Task(description);
        
        System.out.print("Enter your priority (1 = High, 2 = Medium, 3 = Low): ");
        int priority = sc.nextInt();
        sc.nextLine(); // consume newline
        
        switch (priority) {
            case 1:
                high.add(task);
                break;
            case 2:
                medium.add(task);
                break;
            case 3:
                low.add(task);
                break;
            default:
                System.out.println("Invalid priority. Task not added.");
                break;
        }
    }
    
    private static void removeTask(Scanner sc) {
        System.out.print("Enter the priority of the task to remove (1 = High, 2 = Medium, 3 = Low): ");
        int listChoice = sc.nextInt();
        sc.nextLine(); // consume newline
        
        ArrayList<Task> selectedList;
        switch (listChoice) {
            case 1:
                selectedList = high;
                break;
            case 2:
                selectedList = medium;
                break;
            case 3:
                selectedList = low;
                break;
            default:
                System.out.println("Invalid priority choice.");
                return;
        }
        
        if (selectedList.isEmpty()) {
            System.out.println("No tasks in this priority.");
            return;
        }
        
        System.out.println("Tasks:");
        printTaskList(selectedList);
        System.out.print("Enter the task number to remove: ");
        int index = sc.nextInt();
        sc.nextLine(); // consume newline
        
        if (index < 1 || index > selectedList.size()) {
            System.out.println("Invalid task number.");
        } else {
            Task removedTask = selectedList.remove(index - 1);
            System.out.println("Removed task: " + removedTask);
        }
    }
    
    private static void listTasks() {
        System.out.println("\nAll Tasks:");
        if (high.isEmpty() && medium.isEmpty() && low.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        if (!high.isEmpty()) {
            System.out.println("High Priority:");
            printTaskList(high);
        }
        if (!medium.isEmpty()) {
            System.out.println("Medium Priority:");
            printTaskList(medium);
        }
        if (!low.isEmpty()) {
            System.out.println("Low Priority:");
            printTaskList(low);
        }
    }
    
    private static void printTaskList(ArrayList<Task> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }
}
