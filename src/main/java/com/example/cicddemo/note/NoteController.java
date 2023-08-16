package com.example.cicddemo.note;

import com.example.cicddemo.user.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody NoteDto noteDto) throws UserNotFoundException {
return ResponseEntity.ok(noteService.createNote(noteDto));
    }
    @GetMapping
    public  ResponseEntity<List<Note>> getAllNotes(){
        return ResponseEntity.ok(noteService.getAllNotes());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable("id")Long id) throws NoteDoesNotExistException {
return  ResponseEntity.ok(noteService.getNoteById(id));
    }

}
