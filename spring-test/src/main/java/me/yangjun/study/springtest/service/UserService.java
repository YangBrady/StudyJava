package me.yangjun.study.springtest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import me.yangjun.study.springtest.domain.UserVO;

import java.util.Map;

/**
 * @author Brady
 * @description 针对表【user】的数据库操作Service
 * @createDate 2023-04-15 23:25:55
 */
public interface UserService extends IService<UserVO> {
    UserVO getById(Long id);

    Map<Integer, UserVO> findUserMapByAge();

    void add(UserVO userVO);

    void addWastTime(UserVO userVO);

    void addAsync(UserVO userVO);
}
