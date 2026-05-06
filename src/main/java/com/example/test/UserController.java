package com.example.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping
    public User add(@RequestBody UserDto user){
        return userService.add(user);
    }

    @GetMapping("/list")
    public List<User> getAll(){
        return userService.getUsers();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        log.info("delete qo'shildi");
        userService.delete(id);
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable Integer id,@RequestBody UserDto userDto){
        return userService.update(id,userDto);
    }
}
