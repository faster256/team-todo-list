package utils;

import schemas.Task;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWriterUtil {
    private String fileName;

    public FileWriterUtil(String fileName) {
        this.fileName = fileName;
    }

    public void writeToFile(List<Task> tasks) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Task task : tasks) {
                // Формат такий самий, як і при зчитуванні
                writer.write(String.format("%s %s \"%s\"\n",
                        task.getId(),
                        task.getCreatedAt(),
                        task.getValue()));
            }
            System.out.println("Завдання збережено у файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Помилка при записі у файл: " + fileName);
        }
    }
}
