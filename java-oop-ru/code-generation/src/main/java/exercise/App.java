package exercise;

import java.nio.file.Path;
import java.nio.file.Files;

public class App {

    // Сохранение объекта Car в файл
    public static void save(Path path, Car car) {
        try {
            String json = car.serialize();
            Files.writeString(path, json);
        } catch (Exception e) {
            throw new RuntimeException("Error during saving to file", e);
        }
    }

    // Извлечение объекта Car из файла
    public static Car extract(Path path) {
        try {
            String json = Files.readString(path);
            return Car.deserialize(json);
        } catch (Exception e) {
            throw new RuntimeException("Error during extracting from file", e);
        }
    }
}
