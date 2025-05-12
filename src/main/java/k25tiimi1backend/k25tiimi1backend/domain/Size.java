package k25tiimi1backend.k25tiimi1backend.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Size {
    S("S"),
    M("M"),
    L("L"),
    ONE_KG("1kg"),

    // EI SAA KÄYTTÄÄ TUOTTEITA LUODESSA/LISÄTESSÄ!
    Medium("Medium"),
    Small("Small"),
    Large("Large"),
    Kilogram("ONE_KG"),
    XXL("xxl");

    private final String label;

    Size(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    @JsonValue
    public String toString() {
        return label;
    }

    @JsonCreator
    public static Size fromLabel(String label) {
        for (Size size : values()) {
            if (size.label.equalsIgnoreCase(label)) {
                return size;
            }
        }
        throw new IllegalArgumentException("No enum constant with label " + label);
    }
}
