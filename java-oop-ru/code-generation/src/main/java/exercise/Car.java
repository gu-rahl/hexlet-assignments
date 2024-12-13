package exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.fasterxml.jackson.databind.ObjectMapper;

@AllArgsConstructor
@Getter
public class Car {
    private final int id;
    private final String brand;
    private final String model;
    private final String color;
    private final User owner;

    // Сериализация объекта в JSON
    public String serialize() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(this);
        } catch (Exception e) {
            throw new RuntimeException("Error during serialization", e);
        }
    }

    // Десериализация JSON в объект
    public static Car deserialize(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, Car.class);
        } catch (Exception e) {
            throw new RuntimeException("Error during deserialization", e);
        }
    }
}
