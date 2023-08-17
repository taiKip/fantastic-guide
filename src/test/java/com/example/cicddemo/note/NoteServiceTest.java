package com.example.cicddemo.note;

import com.example.cicddemo.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class NoteServiceTest {
  @Autowired
  private NoteService noteService;

    @MockBean
    private NoteRepository noteRepository;
    @BeforeEach
    void setUp() throws NoteDoesNotExistException {
        Note note = Note
                .builder()
                .title("Pickles")
                .content("Good Stuff")
                .id(1L)
                .build();
        Mockito.when(noteRepository.findById(1L))
                .thenReturn(Optional.ofNullable(note));
    }

    @Test
    @DisplayName("Get note based on valid noteId")
    public void whenValidNoteId_thenNoteShouldBeFound() throws NoteDoesNotExistException {
        Long noteId = 1L;
        Note found = noteService.getNoteById(noteId);
        assertEquals(noteId,found.getId());
    }
}