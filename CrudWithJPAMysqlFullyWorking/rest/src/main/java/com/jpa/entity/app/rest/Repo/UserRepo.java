package com.jpa.entity.app.rest.Repo;

import com.jpa.entity.app.rest.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
