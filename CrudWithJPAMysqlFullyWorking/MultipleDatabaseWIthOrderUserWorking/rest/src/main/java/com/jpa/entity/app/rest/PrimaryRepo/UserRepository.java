package com.jpa.entity.app.rest.PrimaryRepo;


import com.jpa.entity.app.rest.PrimaryEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
