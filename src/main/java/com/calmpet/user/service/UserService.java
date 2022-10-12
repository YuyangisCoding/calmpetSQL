package com.calmpet.user.service;

import com.calmpet.user.entity.User;
import com.calmpet.user.repository.UserRepository;
import com.calmpet.user.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Result getAllUsers() {
        List<User> users = userRepository.findAll();
        List<String> usersName = new ArrayList<>();
        for (User user : users) {
            usersName.add(user.getUsername());
        }
        if (users.isEmpty()) {
            return Result.fail(405, "No user has been found");
        }
        return Result.success(usersName);
    }

    public Result addUser(User user) {
        if (!userRepository.existsUserByUsernameOrEmail(user.getUsername(), user.getEmail())) {
            String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            user.setPassword(md5Password);
            userRepository.save(user);
            return Result.success(null);
        }
        return Result.fail(405, "User exists");
    }

    public Result updateUser(User user) {
        if (userRepository.existsUserById(user.getId())) {
            String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            user.setPassword(md5Password);
            userRepository.save(user);
            return Result.success(null);
        }
        return Result.fail(405, "User does not exists");
    }


    public Result removeUser(User user) {
        if (userRepository.existsUserById(user.getId())) {
            String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            user.setPassword(md5Password);
            userRepository.delete(user);
            return Result.success(null);
        }
        return  Result.fail(405, "User does not exists");
    }

    public Result login(String username, String password) {
        if (userRepository.existsUserByUsernameOrEmail(username, username)) {
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            if (md5Password.equals(userRepository.findByUsernameOrEmail(username, username).getPassword())) {
                User user = userRepository.findByUsernameOrEmail(username, username);
                return Result.success(user);
            }
        }
        return Result.fail(405, "User name or password incorrect. Please check!");
    }
}
