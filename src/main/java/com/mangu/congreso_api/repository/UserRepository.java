package com.mangu.congreso_api.repository;

import com.mangu.congreso_api.domain.security.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
    extends JpaRepository<User, String> {

  Optional<User> findByUsername(String username);
}
