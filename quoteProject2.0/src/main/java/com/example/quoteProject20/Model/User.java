package com.example.quoteProject20.Model;

import com.example.quoteProject20.ENUMS.Role;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

//@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
@Entity
@ToString
@NoArgsConstructor
@Builder
@Table(name = "userNew")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String username;
    private String email;
    private String password;
    private Role role;

    @Builder.Default
    private boolean isActive = true;

  // @JsonIgnore
    @OneToMany(mappedBy = "author")
    @JsonManagedReference
    private List<Quote> quotes = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Likes> like = new ArrayList<>();

//    public User(int id) {
//        this.id = (long) id;
//    }



}
