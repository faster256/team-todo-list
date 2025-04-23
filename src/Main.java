import schemas.Task;
import utils.FileReader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader("./src/data/todos.txt");
        List<Task> todos = new ArrayList<>();

        fileReader.readFile(todos);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Виберіть варіант сортування:");
        System.out.println("1 - За датою додавання до списку");
        System.out.println("2 - За часом створення задачі");

        int choice = scanner.nextInt();

        if (choice == 1) {
            // Сортування за датою додавання (за замовчуванням порядок у списку)
            todos.forEach(todo -> System.out.println(todo.getValue()));
        } else if (choice == 2) {
            // Сортування за часом створення задачі
            todos.stream()
                    .sorted(Comparator.comparing(Task::getCreatedAtAsDateTime))
                    .forEach(todo -> System.out.println(todo.getValue()));
        } else {
            System.out.println("Невірний вибір. Список буде виведений без сортування.");
            todos.forEach(todo -> System.out.println(todo.getValue()));
        }
    }
}
