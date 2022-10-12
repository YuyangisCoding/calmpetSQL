package com.calmpet.user.repository;

import com.calmpet.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Boolean existsUserByUsernameOrEmail(String username, String email);

    Boolean existsUserById(Integer id);

    User findByUsernameOrEmail(String username, String email);
}
