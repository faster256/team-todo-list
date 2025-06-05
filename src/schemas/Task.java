package schemas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private String id;
    private String createdAt;
    private String value;
    private String status;  // active або completed

    public Task(String id, String createdAt, String value, String status) {
        this.id = id;
        this.createdAt = createdAt;
        this.value = value;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getValue() {
        return value;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAtAsDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(createdAt, formatter);
    }

    @Override
    public String toString() {
        return id + ": " + value + " [" + status + "]";
    }
}
