import schemas.Task;
import utils.FileReader;
import utils.FileWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String FILE_PATH = "./src/data/todos.txt";

    public static void main(String[] args) {
        FileReader fileReader = new FileReader(FILE_PATH);
        FileWriter fileWriter = new FileWriter(FILE_PATH);
        List<Task> todos = new ArrayList<>();

        fileReader.readFile(todos);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1 - Вивести всі задачі");
            System.out.println("2 - Сортувати за часом створення");
            System.out.println("3 - Зберегти задачі у файл");
            System.out.println("4 - Вивести вміст файлу");
            System.out.println("5 - Сортувати за активністю (спочатку активні)");
            System.out.println("6 - Показати лише активні задачі");
            System.out.println("0 - Вийти");

            System.out.print("Виберіть варіант: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // очистити буфер

            switch (choice) {
                case 1 -> {
                    System.out.println("Всі задачі:");
                    todos.forEach(task -> System.out.println(formatTask(task)));
                }
                case 2 -> {
                    System.out.println("Задачі, відсортовані за часом створення:");
                    todos.stream()
                            .sorted(Comparator.comparing(Task::getCreatedAtAsDateTime))
                            .forEach(task -> System.out.println(formatTask(task)));
                }
                case 3 -> {
                    fileWriter.saveToFile(todos);
                }
                case 4 -> {
                    System.out.println("Вміст файлу:");
                    printFileContent(FILE_PATH);
                }
                case 5 -> {
                    System.out.println("Задачі, відсортовані за активністю (спочатку active):");
                    todos.stream()
                            .sorted(Comparator.comparing((Task t) -> t.getStatus().equals("active") ? 0 : 1))
                            .forEach(task -> System.out.println(formatTask(task)));
                }
                case 6 -> {
                    System.out.println("Активні задачі:");
                    todos.stream()
                            .filter(task -> task.getStatus().equals("active"))
                            .forEach(task -> System.out.println(formatTask(task)));
                }
                case 0 -> {
                    System.out.println("Вихід із програми...");
                    running = false;
                }
                default -> System.out.println("Невірний вибір, спробуйте ще раз.");
            }
        }
    }

    private static void printFileContent(String filePath) {
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено: " + filePath);
        }
    }

    private static String formatTask(Task task) {
        return task.getId() + ": " + task.getValue() + " [" + task.getStatus() + "]";
    }
}
