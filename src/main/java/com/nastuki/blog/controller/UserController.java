package com.nastuki.blog.controller;

import com.nastuki.blog.entity.User;
import com.nastuki.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getList() {
        return userRepository.findAll();
    }


    @GetMapping("/getUsersByUsername/{username}")
    public List<User> getUsersByUsername(@PathVariable("username") String username) {
        return userRepository.findByUsernameLike("%"+username+"%");
    }

    @PostMapping("/saveUser")
    public User saveUser(@RequestParam String username,
                         @RequestParam String password,
                         @RequestParam Integer age) {
        User user = new User();
        user.setAge(age);
        user.setPassword(password);
        user.setUsername(username);

        return userRepository.save(user);
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userRepository.findOne(id);
    }

    @PostMapping("/updateUser/{id}")
    public User updateUser(@PathVariable("id") Long id,
                           @RequestParam String password,
                           @RequestParam String username,
                           @RequestParam Integer age) {
        User user = userRepository.findOne(id);
        user.setAge(age);
        user.setPassword(password);
        user.setUsername(username);

        return userRepository.save(user);
    }

    @GetMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userRepository.delete(id);
    }

}
