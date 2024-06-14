package br.com.hub.forum.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

public enum Category {
    FRONTEND,
    BACKEND,
    FULLSTACK
}
