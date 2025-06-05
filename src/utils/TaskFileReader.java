package utils;

import schemas.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class TaskFileReader {
    private String fileName;

    public TaskFileReader(String fileName) {
        this.fileName = fileName;
    }

    public void readFile(List<Task> todos) {
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] parts = line.split(" ", 4);
                if (parts.length >= 4) {
                    String id = parts[0];
                    String createdAt = parts[1] + " " + parts[2];
                    String value = parts[3].substring(1, parts[3].length() - 1); // remove quotes

                    Task task = new Task(id, createdAt, value);
                    todos.add(task);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено: " + fileName);
        }
    }
}
