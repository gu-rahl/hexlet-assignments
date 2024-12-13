package exercise;

import java.util.Map;

public class SingleTag extends Tag {
    public SingleTag(String name, Map<String, String> attributes) {
        super(name, attributes);
    }

    @Override
    public String toString() {
        String attributesString = renderAttributes();
        if (attributesString.isEmpty()) {
            return String.format("<%s>", getName());
        }
        return String.format("<%s %s>", getName(), attributesString);
    }
}
