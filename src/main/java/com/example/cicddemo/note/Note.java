package com.example.cicddemo.note;

import com.example.cicddemo.entity.BaseEntity;
import com.example.cicddemo.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Note extends BaseEntity {
@Id
@GeneratedValue
    private Long id;
    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonManagedReference //gets serialized
    private User user;
}
