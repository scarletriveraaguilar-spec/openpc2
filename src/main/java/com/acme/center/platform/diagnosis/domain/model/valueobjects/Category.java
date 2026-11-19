package com.acme.center.platform.diagnosis.domain.model.valueobjects;


/**
 * Categories defined by the Open Treatment domain.
 */
public enum Category {
    INFECTIOUS(1),
    CARDIOVASCULAR(2),
    GASTROINTESTINAL(3),
    MUSCULOSKELETAL(4),
    NEUROLOGICAL(5),
    RESPIRATORY(6),
    MENTAL(7),
    IMMUNE(8);

    private final int id;

    Category(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Category fromName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("validation.disease.category.required");
        }
        try {
            return Category.valueOf(name.trim());
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("validation.disease.category.invalid");
        }
    }

    public static Category fromId(int id) {
        for (var category : values()) {
            if (category.id == id) {
                return category;
            }
        }
        throw new IllegalArgumentException("validation.disease.category.invalid");
    }
}
