package me.yangjun.study.spring2025002.controller;

import me.yangjun.study.spring2025002.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private CacheService cacheService;

    @GetMapping("/{userId}")
    public String getUser(@PathVariable String userId) {
        return cacheService.get(userId);
    }

    @PostMapping("/{userId}")
    public void updateUser(@PathVariable String userId, @RequestBody String newName) {
        cacheService.set(userId, newName, 10, TimeUnit.SECONDS);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {
        cacheService.evict(userId);
    }
}
