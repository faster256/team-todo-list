package utils;

import schemas.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private String fileName;

    public FileReader(String fileName) {
        this.fileName = fileName;
    }

    public void readFile(List<Task> todos) {
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] firstParts = line.split(" ", 4);
                if (firstParts.length >= 4) {
                    String id = firstParts[0];
                    String createdAt = firstParts[1] + " " + firstParts[2];

                    String remainder = firstParts[3];
                    int lastSpace = remainder.lastIndexOf(' ');
                    if (lastSpace == -1) continue;

                    String valuePart = remainder.substring(0, lastSpace);
                    String status = remainder.substring(lastSpace + 1);

                    String value = valuePart.trim();
                    if (value.startsWith("\"") && value.endsWith("\"")) {
                        value = value.substring(1, value.length() - 1);
                    }

                    Task task = new Task(id, createdAt, value, status);
                    todos.add(task);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено: " + fileName);
        }
    }
}
