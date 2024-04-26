package com.example.quoteProject20.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@ToString
@Table(name="quote")
public class Quote {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User author;

    @OneToMany(mappedBy = "quote")
    private List<Likes> like = new ArrayList<>();

    ///heloo change in my file

}
