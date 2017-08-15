package com.nastuki.blog.repository;

import com.nastuki.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long>{

    List<User> findByUsernameLike(String username);

}
