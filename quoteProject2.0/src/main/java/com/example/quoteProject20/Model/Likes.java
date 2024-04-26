package com.example.quoteProject20.Model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Builder
@Entity
@Table(name = "Likes")
public class Likes {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;


@Column(name = "isLike")
boolean isLikes;

@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

@ManyToOne
    @JoinColumn(name = "quote_id")
    private Quote quote;



}
