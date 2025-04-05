package schemas;

/**
 * Клас, який представляє задачу у списку TODO.
 * Містить інформацію про ідентифікатор задачі, дату її створення та опис.
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

    /**
     * Отримати опис задачі.
     *
     * @return Опис задачі
     */
    public String getValue() {
        return value;
    }

    /**
     * Отримати ідентифікатор задачі.
     *
     * @return Ідентифікатор задачі
     */
    public String getId() {
        return id;
    }

    /**
     * Отримати дату та час створення задачі.
     *
     * @return Дата та час створення задачі
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Переоприділений метод toString для повернення текстового представлення задачі.
     *
     * @return Текстове представлення задачі
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
