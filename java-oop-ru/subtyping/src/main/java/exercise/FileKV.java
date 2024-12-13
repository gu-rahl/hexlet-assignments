package exercise;

import java.util.Map;

public class FileKV implements KeyValueStorage {
    private final String filePath;

    public FileKV(String filePath, Map<String, String> initialData) {
        this.filePath = filePath;
        Utils.writeFile(filePath, Utils.serialize(initialData)); // Сохраняем начальные данные
    }

    private Map<String, String> loadData() {
        String json = Utils.readFile(filePath);
        return Utils.deserialize(json);
    }

    private void saveData(Map<String, String> data) {
        Utils.writeFile(filePath, Utils.serialize(data));
    }

    @Override
    public void set(String key, String value) {
        Map<String, String> data = loadData();
        data.put(key, value);
        saveData(data);
    }

    @Override
    public void unset(String key) {
        Map<String, String> data = loadData();
        data.remove(key);
        saveData(data);
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> data = loadData();
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return loadData();
    }
}
