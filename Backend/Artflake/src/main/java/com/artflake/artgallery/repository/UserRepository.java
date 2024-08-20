package com.artflake.artgallery.repository;

import com.artflake.artgallery.model.Role;
import com.artflake.artgallery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    List<User> findByRole(Role role);
}