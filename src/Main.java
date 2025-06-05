import schemas.Task;
import utils.TaskFileReader;
import utils.FileWriterUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskFileReader fileReader = new TaskFileReader("./src/data/todos.txt");
        List<Task> todos = new ArrayList<>();
        fileReader.readFile(todos);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nВиберіть опцію:");
            System.out.println("1 - Вивести список (за датою додавання)");
            System.out.println("2 - Вивести список (за часом створення)");
            System.out.println("3 - Зберегти список у файл");
            System.out.println("0 - Вихід");

            System.out.print("Ваш вибір: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    todos.forEach(todo -> System.out.println(todo.getValue()));
                    break;
                case 2:
                    todos.stream()
                            .sorted(Comparator.comparing(Task::getCreatedAtAsDateTime))
                            .forEach(todo -> System.out.println(todo.getValue()));
                    break;
                case 3:
                    FileWriterUtil writer = new FileWriterUtil("./src/data/todos_saved.txt");
                    writer.writeToFile(todos);
                    break;
                case 0:
                    running = false;
                    System.out.println("Програму завершено.");
                    break;
                default:
                    System.out.println("Невірний вибір. Повторіть спробу.");
            }
        }
    }
}
