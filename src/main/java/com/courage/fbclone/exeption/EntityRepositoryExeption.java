package com.courage.fbclone.exeption;

public class EntityRepositoryExeption extends RuntimeException {
    public EntityRepositoryExeption(String message) {
        super(message);
    }
}
