package dev.decagon.facebookcloneapp.exeption;

public class EntityRepositoryExeption extends RuntimeException {
    public EntityRepositoryExeption(String message) {
        super(message);
    }
}
