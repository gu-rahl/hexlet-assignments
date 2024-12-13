package exercise;

import java.util.Map;

public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> currentData = storage.toMap();

        // Удаляем текущие ключи
        for (String key : currentData.keySet()) {
            storage.unset(key);
        }

        // Меняем местами ключи и значения
        for (Map.Entry<String, String> entry : currentData.entrySet()) {
            storage.set(entry.getValue(), entry.getKey());
        }
    }
}
