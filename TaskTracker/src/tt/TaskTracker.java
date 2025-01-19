package tt;

import java.util.ArrayList;
import java.util.Scanner;

class Task {
	private int id;
	private String description;
	private boolean isComplete;

	public Task(int id, String description) {
		this.id = id;
		this.description = description;
		this.isComplete = false;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void markComplete() {
		this.isComplete = true;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", Description: " + description + ", Complete: " + isComplete;
	}
}

public class TaskTracker {
	private static ArrayList<Task> tasks = new ArrayList<>();
	private static int idCounter = 1;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("\nTask Tracker");
			System.out.println("1. Add Task");
			System.out.println("2. View Tasks");
			System.out.println("3. Mark Task as Complete");
			System.out.println("4. Delete Task");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1 -> addTask(scanner);
			case 2 -> viewTasks();
			case 3 -> markTaskComplete(scanner);
			case 4 -> deleteTask(scanner);
			case 5 -> {
				System.out.println("Exiting...");
				return;
			}
			default -> System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void addTask(Scanner scanner) {
		System.out.print("Enter task description: ");
		String description = scanner.nextLine();
		tasks.add(new Task(idCounter++, description));
		System.out.println("Task added successfully.");
	}

	private static void viewTasks() {
		if (tasks.isEmpty()) {
			System.out.println("No tasks available.");
			return;
		}
		System.out.println("Task List:");
		for (Task task : tasks) {
			System.out.println(task);
		}
	}

	private static void markTaskComplete(Scanner scanner) {
		System.out.print("Enter task ID to mark complete: ");
		int id = scanner.nextInt();
		Task task = findTaskById(id);
		if (task != null) {
			task.markComplete();
			System.out.println("Task marked as complete.");
		} else {
			System.out.println("Task not found.");
		}
	}

	private static void deleteTask(Scanner scanner) {
		System.out.print("Enter task ID to delete: ");
		int id = scanner.nextInt();
		Task task = findTaskById(id);
		if (task != null) {
			tasks.remove(task);
			System.out.println("Task deleted successfully.");
		} else {
			System.out.println("Task not found.");
		}
	}

	private static Task findTaskById(int id) {
		for (Task task : tasks) {
			if (task.getId() == id) {
				return task;
			}
		}
		return null;
	}
}
