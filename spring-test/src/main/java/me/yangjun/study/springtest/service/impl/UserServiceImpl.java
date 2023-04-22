package me.yangjun.study.springtest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.springtest.domain.UserVo;
import me.yangjun.study.springtest.mapper.UserMapper;
import me.yangjun.study.springtest.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Brady
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-04-15 23:25:55
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserVo> implements IUserService {
    private final UserMapper userMapper;

    @Override
    public UserVo getById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public Map<Integer, UserVo> findUserMapByAge() {
        return userMapper.findUserMapByAge();
    }
}
