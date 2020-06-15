package me.yangjun.study.action;

import me.yangjun.study.dto.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mooejun
 * @since 2019/05/07
 */
@Controller
@RequestMapping(value = "/frame/spring/demo/mvc/rest")
public class RESTFulAction {

    /**
     * GET 方式请求 /user/ 返回用户列表
     */
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("1", "哈哈"));
        users.add(new User("2", "嘿嘿"));
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /**
     * GET 方式请求 /user/1 返回id为1的用户
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        User user = new User(String.valueOf(id), "哈哈");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * POST 方式请求 /user/ 通过user对象的JSON 参数创建新的user对象
     */
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    /**
     * PUT 方式请求 /user/1 更新id为3的发送json格式的用户对象
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        System.out.println("Updating User " + id);
        User currentUser = new User(String.valueOf(id), user.getUsername());
        return new ResponseEntity<>(currentUser, HttpStatus.OK);
    }

    /**
     * DELETE 方式请求/user/1删除 ID为 1的user对象
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * DELETE 方式请求/user/删除所有user
     */
    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteAllUsers() {
        System.out.println("Deleting All Users");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
