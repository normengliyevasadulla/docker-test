package com.example.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
     private final UserRepository userRepository;

    public User add(UserDto u){
        User build = User.builder()
                .name(u.getName())
                .build();
        return userRepository.save(build);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void delete(Integer id){
        userRepository.deleteById(id);
    }

    public User update(Integer id,UserDto userDto){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
        user.setName(userDto.getName());
        return userRepository.save(user);
    }
}
