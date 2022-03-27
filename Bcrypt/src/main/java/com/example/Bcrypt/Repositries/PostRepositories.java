package com.example.Bcrypt.Repositries;

import com.example.Bcrypt.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepositories extends JpaRepository<Post, Integer> {
}
