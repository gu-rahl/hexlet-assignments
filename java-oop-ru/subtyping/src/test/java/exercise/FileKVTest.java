package exercise;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FileKVTest {

    @Test
    void testFileKV() {
        String filePath = "src/test/resources/file";
        KeyValueStorage storage = new FileKV(filePath, Map.of("key", "value"));

        // Проверка начальных данных
        assertEquals("value", storage.get("key", "default"));
        assertEquals("default", storage.get("unknown", "default"));

        // Добавление данных
        storage.set("key2", "value2");
        assertEquals("value2", storage.get("key2", "default"));

        // Удаление данных
        storage.unset("key2");
        assertEquals("default", storage.get("key2", "default"));

        // Проверка toMap()
        Map<String, String> data = storage.toMap();
        assertEquals(1, data.size());
        assertEquals("value", data.get("key"));
    }
}
