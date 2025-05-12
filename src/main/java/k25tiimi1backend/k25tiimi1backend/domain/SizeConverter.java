package k25tiimi1backend.k25tiimi1backend.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false) 
public class SizeConverter implements AttributeConverter<Size, String> {

    @Override
    public String convertToDatabaseColumn(Size attribute) {
        return attribute != null ? attribute.getLabel() : null;
    }

    @Override
    public Size convertToEntityAttribute(String dbData) {
        return dbData != null ? Size.fromLabel(dbData) : null;
    }
}
