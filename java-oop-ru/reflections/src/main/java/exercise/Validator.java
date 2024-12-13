package exercise;

import java.lang.reflect.Field;
import java.util.*;

public class Validator {

    // Базовая валидация (только @NotNull)
    public static List<String> validate(Object object) {
        List<String> invalidFields = new ArrayList<>();
        Class<?> clazz = object.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true); // Делаем поле доступным для чтения
                try {
                    Object value = field.get(object);
                    if (value == null) {
                        invalidFields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return invalidFields;
    }

    // Расширенная валидация (@NotNull и @MinLength)
    public static Map<String, List<String>> advancedValidate(Object object) {
        Map<String, List<String>> invalidFields = new HashMap<>();
        Class<?> clazz = object.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            List<String> errors = new ArrayList<>();
            field.setAccessible(true); // Делаем поле доступным для чтения

            try {
                Object value = field.get(object);

                // Проверка @NotNull
                if (field.isAnnotationPresent(NotNull.class) && value == null) {
                    errors.add("can not be null");
                }

                // Проверка @MinLength
                if (field.isAnnotationPresent(MinLength.class) && value != null && value instanceof String) {
                    MinLength minLength = field.getAnnotation(MinLength.class);
                    if (((String) value).length() < minLength.minLength()) {
                        errors.add("length less than " + minLength.minLength());
                    }
                }

                if (!errors.isEmpty()) {
                    invalidFields.put(field.getName(), errors);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return invalidFields;
    }
}
