package com.example.Bcrypt.Repositries;

import com.example.Bcrypt.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepositories extends JpaRepository<Users , Integer> {

    Users findByuserName(String username);
}
