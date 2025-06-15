package me.yangjun.study.controller;

import lombok.RequiredArgsConstructor;
import me.yangjun.study.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/getUser/{userId}")
    public String getUser(@PathVariable String userId) {
        return userService.get(userId);
    }

    @PostMapping("/updateUser/{userId}")
    public void updateUser(@PathVariable String userId) {
        userService.set(userId, "newName");
    }

    @DeleteMapping("/deleteUser/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.delete(userId);
    }

    @DeleteMapping("/deleteAllUser")
    public void deleteAllUser() {
        userService.deleteAll();
    }
}
