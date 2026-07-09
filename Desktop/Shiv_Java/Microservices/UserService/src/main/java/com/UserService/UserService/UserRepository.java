package com.UserService.UserService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Another My Git change
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
