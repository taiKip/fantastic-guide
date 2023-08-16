package com.example.cicddemo.note;

public class NoteDoesNotExistException extends Exception{
    public NoteDoesNotExistException(String message) {
        super(message);
    }
}
