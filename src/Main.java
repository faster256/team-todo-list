import schemas.Task;
import utils.FileReader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader("./src/data/todos.txt");
        List<Task> todos = new ArrayList<>();

        fileReader.readFile(todos);

        // Сортування за часом створення задачі
        todos.stream()
                .sorted(Comparator.comparing(Task::getCreatedAtAsDateTime))
                .forEach(todo -> System.out.println(todo.getValue()));
    }
}
