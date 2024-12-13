package exercise;

import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static List<String> buildApartmentsList(List<Home> homes, int n) {
        return homes.stream()
                .sorted() // Сортировка по площади
                .limit(n) // Берем первые n элементов
                .map(Home::toString) // Преобразуем в строку
                .collect(Collectors.toList()); // Возвращаем список
    }
}
