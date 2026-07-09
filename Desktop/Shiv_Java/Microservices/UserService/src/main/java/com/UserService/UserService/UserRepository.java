package com.UserService.UserService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Change by GitHub
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
