package io.github.codenilson.smartpat.persistence.valueobjects;

public enum Ownership {
    OWNED("OWNED"),
    LEASED("LEASED"),
    UNKNOW("UNKNOWN");

    private final String description;

    Ownership(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}