package com.example.quoteProject20.Respository;

import com.example.quoteProject20.Model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Likes, Long> {

}
