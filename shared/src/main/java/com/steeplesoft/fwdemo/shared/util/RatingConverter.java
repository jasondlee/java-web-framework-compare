package com.steeplesoft.fwdemo.shared.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.steeplesoft.fwdemo.shared.model.Rating;

@Converter
public class RatingConverter implements AttributeConverter<Rating, String> {
    @Override
    public String convertToDatabaseColumn(Rating rating) {
        if (rating == null) {
            return null;
        } else {
            return rating.toString();
        }
    }

    @Override
    public Rating convertToEntityAttribute(String value) {
        switch (value) {
            case "G": return Rating.G;
            case "PG": return Rating.PG;
            case "PG-13": return Rating.PG13;
            case "R": return Rating.R;
            case "NC-17": return Rating.NC17;
            default: return null;
        }
    }
}
