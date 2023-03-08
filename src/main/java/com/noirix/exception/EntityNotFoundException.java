package com.noirix.exception;

public class EntityNotFoundException extends Exception {
    private final Long id;
    private final String entityType;

    public EntityNotFoundException(Long id, String entityType) {
        this.id = id;
        this.entityType = entityType.toUpperCase();
    }

    @Override
    public String toString() {
        return "Entity _" + entityType + "_ with id _" + id + "_ isn't found!";
    }
}
