package com.example.Bcrypt.Repositries;

import com.example.Bcrypt.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepositories extends JpaRepository<Post, Integer> {
    List<Post> findByUserId(int id);
}
