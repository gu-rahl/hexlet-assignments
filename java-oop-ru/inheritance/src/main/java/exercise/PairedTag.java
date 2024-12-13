package exercise;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PairedTag extends Tag {
    private final String body;
    private final List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        String attributesString = renderAttributes();
        String openingTag = attributesString.isEmpty()
                ? String.format("<%s>", getName())
                : String.format("<%s %s>", getName(), attributesString);

        String childrenString = children.stream()
                .map(Tag::toString)
                .collect(Collectors.joining());

        String closingTag = String.format("</%s>", getName());
        return openingTag + body + childrenString + closingTag;
    }
}
