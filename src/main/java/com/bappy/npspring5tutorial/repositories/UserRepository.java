package com.bappy.npspring5tutorial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bappy.npspring5tutorial.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);

	User findByForgotPasswordCode(String forgotPasswordCode);
}
