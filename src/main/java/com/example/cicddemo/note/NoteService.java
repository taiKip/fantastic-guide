package com.example.cicddemo.note;

import com.example.cicddemo.user.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {
    Note createNote(NoteDto noteDto) throws UserNotFoundException;

    List<Note> getAllNotes();

    Note getNoteById(Long id) throws NoteDoesNotExistException;
}
