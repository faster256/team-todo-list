package utils;

import schemas.Task;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class FileWriter {
    private String fileName;

    public FileWriter(String fileName) {
        this.fileName = fileName;
    }

    public void saveToFile(List<Task> todos) {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(fileName)))) {
            for (Task task : todos) {
                writer.write(task.getId() + " " + task.getCreatedAt() + " \"" + task.getValue() + "\" " + task.getStatus());
                writer.newLine();
            }
            System.out.println("Задачі успішно збережені у файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Помилка під час запису у файл: " + e.getMessage());
        }
    }
}
