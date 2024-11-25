package me.yangjun.study.springtest.controller;

import lombok.RequiredArgsConstructor;
import me.yangjun.study.springtest.domain.UserVO;
import me.yangjun.study.springtest.service.UserService;
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
    private final UserService userService;

    @GetMapping("/{id}")
    public UserVO getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @GetMapping("/")
    public UserVO findByAge(@RequestParam("age") Integer age) {
        Map<Integer, UserVO> UserMapByAge = userService.findUserMapByAge();
        return UserMapByAge.get(age);
    }
}
