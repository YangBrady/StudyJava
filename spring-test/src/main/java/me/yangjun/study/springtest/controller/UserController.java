package me.yangjun.study.springtest.controller;

import lombok.RequiredArgsConstructor;
import me.yangjun.study.springtest.domain.UserVo;
import me.yangjun.study.springtest.service.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>描述：</p>
 *
 * @author: Brady Yang
 * @date: 2023/4/15  23:30
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @GetMapping("/{id}")
    public UserVo getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @GetMapping("/")
    public UserVo findByAge(@RequestParam("age") Integer age) {
        Map<Integer, UserVo> UserMapByAge = userService.findUserMapByAge();
        return UserMapByAge.get(age);
    }
}
