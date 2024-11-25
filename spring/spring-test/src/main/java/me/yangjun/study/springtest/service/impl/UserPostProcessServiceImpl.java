package me.yangjun.study.springtest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.springtest.domain.UserVO;
import me.yangjun.study.springtest.mapper.UserMapper;
import me.yangjun.study.springtest.service.UserPostProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>描述：</p>
 *
 * @author: Brady Yang
 * @date: 2023/10/22  15:18
 */
@Service
@Slf4j
public class UserPostProcessServiceImpl implements UserPostProcessService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public void service() {
        QueryWrapper<UserVO> userVOQueryWrapper = new QueryWrapper<>();
        // userVOQueryWrapper.eq("", "");
        List<UserVO> list = userMapper.selectList(userVOQueryWrapper);
        log.info(list.toString());
    }

    @Override
    @Async
    @Transactional
    public void asyncService() {
        log.info("开始调用异步方法 asyncService 查询数据");
        QueryWrapper<UserVO> userVOQueryWrapper = new QueryWrapper<>();
        // userVOQueryWrapper.eq("", "");
        List<UserVO> list = userMapper.selectList(userVOQueryWrapper);
        log.info(list.toString());
    }

    @Override
    @Async
    public void asyncServiceNoTransaction() {
        log.info("开始调用异步方法 asyncServiceNoTransaction 查询数据");
        QueryWrapper<UserVO> userVOQueryWrapper = new QueryWrapper<>();
        // userVOQueryWrapper.eq("", "");
        List<UserVO> list = userMapper.selectList(userVOQueryWrapper);
        log.info(list.toString());
    }

    @Override
    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void asyncServiceRequiresNew() {
        log.info("开始调用异步方法 asyncServiceA 查询数据");
        QueryWrapper<UserVO> userVOQueryWrapper = new QueryWrapper<>();
        // userVOQueryWrapper.eq("", "");
        List<UserVO> list = userMapper.selectList(userVOQueryWrapper);
        log.info(list.toString());
    }
}
