package exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;

// Аннотация @AllArgsConstructor генерирует конструктор для всех полей
// Аннотация @Getter генерирует геттеры для всех полей
@AllArgsConstructor
@Getter
public class User {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final int age;
}
