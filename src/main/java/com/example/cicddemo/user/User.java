package com.example.cicddemo.user;

import com.example.cicddemo.entity.BaseEntity;
import com.example.cicddemo.note.Note;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "_user")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    private String email;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonBackReference //not serialized
    private List<Note> notes;
}
