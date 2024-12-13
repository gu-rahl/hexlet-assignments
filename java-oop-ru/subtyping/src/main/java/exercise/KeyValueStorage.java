package exercise;

import java.util.Map;

public interface KeyValueStorage {
    void set(String key, String value); // Установить значение по ключу
    void unset(String key); // Удалить значение по ключу
    String get(String key, String defaultValue); // Получить значение или вернуть значение по умолчанию
    Map<String, String> toMap(); // Вернуть все данные как Map
}
