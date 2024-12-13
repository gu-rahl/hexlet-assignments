package exercise;

import java.util.Map;
import java.util.stream.Collectors;

public abstract class Tag {
    private final String name;
    private final Map<String, String> attributes;

    public Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    // Формирование строки атрибутов
    protected String renderAttributes() {
        return attributes.entrySet().stream()
                .map(entry -> String.format("%s=\"%s\"", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(" "));
    }

    // Геттеры для имени и атрибутов
    public String getName() {
        return name;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    // Метод toString реализуется в наследниках
    @Override
    public abstract String toString();
}
