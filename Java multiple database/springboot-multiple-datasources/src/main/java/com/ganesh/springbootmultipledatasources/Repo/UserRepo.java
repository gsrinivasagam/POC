package com.ganesh.springbootmultipledatasources.Repo;


import com.ganesh.springbootmultipledatasources.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
