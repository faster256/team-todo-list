package schemas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Клас, який представляє задачу у списку TODO.
 */
public class Task {
    private String value; // Опис задачі
    private String id; // Ідентифікатор задачі
    private String createdAt; // Дата та час створення задачі

    /**
     * Конструктор класу Task.
     *
     * @param id        Ідентифікатор задачі
     * @param createdAt Дата та час створення задачі
     * @param value     Опис задачі
     */
    public Task(String id, String createdAt, String value) {
        this.id = id;
        this.createdAt = createdAt;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Перетворення createdAt у LocalDateTime.
     *
     * @return Дата та час створення задачі у LocalDateTime
     */
    public LocalDateTime getCreatedAtAsDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(createdAt, formatter);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
