package me.yangjun.study.springtest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import me.yangjun.study.springtest.domain.UserVo;

import java.util.Map;

/**
 * @author Brady
 * @description 针对表【user】的数据库操作Service
 * @createDate 2023-04-15 23:25:55
 */
public interface IUserService extends IService<UserVo> {
    UserVo getById(Long id);

    Map<Integer, UserVo> findUserMapByAge();
}
