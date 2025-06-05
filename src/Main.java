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
        System.out.println("Виберіть опцію:");
        System.out.println("1 - Вивести список (за датою додавання)");
        System.out.println("2 - Вивести список (за часом створення)");
        System.out.println("3 - Зберегти список у файл");

        int choice = scanner.nextInt();

        if (choice == 1) {
            todos.forEach(todo -> System.out.println(todo.getValue()));
        } else if (choice == 2) {
            todos.stream()
                    .sorted(Comparator.comparing(Task::getCreatedAtAsDateTime))
                    .forEach(todo -> System.out.println(todo.getValue()));
        } else if (choice == 3) {
            FileWriterUtil writer = new FileWriterUtil("./src/data/todos_saved.txt");
            writer.writeToFile(todos);
        } else {
            System.out.println("Невірний вибір. Список буде виведений без сортування.");
            todos.forEach(todo -> System.out.println(todo.getValue()));
        }
    }
}
