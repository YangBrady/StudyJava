package me.yangjun.study.springtest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.springtest.domain.UserVO;
import me.yangjun.study.springtest.mapper.UserMapper;
import me.yangjun.study.springtest.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Brady
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-04-15 23:25:55
 */
@Service
@Slf4j
public class User2ServiceImpl extends ServiceImpl<UserMapper, UserVO> implements User2Service {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserVO getById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public Map<Integer, UserVO> findUserMapByAge() {
        return userMapper.findUserMapByAge();
    }

    @Override
    @Transactional
    public void add(UserVO userVO) {
        userMapper.insert(userVO);
    }

    @Override
    @Transactional
    public void addWastTime(UserVO userVO) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        userMapper.insert(userVO);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Async
    @Transactional(propagation = Propagation.REQUIRED)
    public void addAsync(UserVO userVO) {
        log.info("addAsync 开始执行");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        userMapper.insert(userVO);
        log.info("addAsync 执行完成");

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
