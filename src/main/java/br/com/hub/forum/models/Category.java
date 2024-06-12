package br.com.hub.forum.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

public enum Category {
    FRONTEND,
    BACKEND,
    FULLSTACK;

    public static Category fromString(String value) {
        if (value.equalsIgnoreCase("FRONTEND")){
            return Category.FRONTEND;
        } else if (value.equalsIgnoreCase("BACKEND")){
            return Category.BACKEND;
        } else {
            return Category.FULLSTACK;
        }
    }
}
