package me.yangjun.study.spring2025002.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import me.yangjun.study.spring2025002.service.CacheService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private CacheService cacheService;

    @GetMapping("/getUser/{userId}")
    public String getUser(@PathVariable String userId) {
        return cacheService.get(userId);
    }

    @PostMapping("/updateUser/{userId}")
    public void updateUser(@PathVariable String userId, @RequestBody String newName) {
        cacheService.set(userId, newName, 10, TimeUnit.SECONDS);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public void deleteUser(@PathVariable String userId) {
        cacheService.evict(userId);
    }
}
