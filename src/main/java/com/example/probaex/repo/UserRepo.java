package com.example.probaex.repo;

import com.example.probaex.Model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
List<User> findByNameContainingIgnoreCase(String name);
}
