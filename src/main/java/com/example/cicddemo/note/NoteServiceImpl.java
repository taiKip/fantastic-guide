package com.example.cicddemo.note;

import com.example.cicddemo.user.UserNotFoundException;
import com.example.cicddemo.user.User;
import com.example.cicddemo.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    @Override
    public Note createNote(NoteDto noteDto) throws UserNotFoundException {
        User userDB = userRepository.findById(noteDto.userId()).orElseThrow(() -> new UserNotFoundException(String.format("User with id %d does not exist", noteDto.userId())));

      Note newNote =    Note.builder().title(noteDto.title()).content(noteDto.content()).user(userDB).build();
      return  noteRepository.save(newNote);
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(Long id) throws NoteDoesNotExistException {
        return noteRepository.findById(id).orElseThrow(()->new NoteDoesNotExistException(String.format("Note with id %d does not exist",id)));

    }
}
