package com.example.cicddemo.note;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record NoteDto(@NotNull Long userId, @NotEmpty String title,@NotEmpty String content) {
}
