package org.example.hibernate.controller;

import org.example.hibernate.DTO.UserDTO;
import org.example.hibernate.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable("id") UUID id) {
        return userService.findById(id);
    }

    @GetMapping
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public UserDTO save(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @PutMapping
    public UserDTO update(@RequestBody UserDTO user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        userService.deleteById(id);
    }


}
