package me.yangjun.study.springtest.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.springtest.domain.UserVO;
import me.yangjun.study.springtest.service.TransactionalTestService;
import me.yangjun.study.springtest.service.User2Service;
import me.yangjun.study.springtest.service.UserPostProcessService;
import me.yangjun.study.springtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * <p>描述：</p>
 *
 * @author: Brady Yang
 * @date: 2023/10/22  15:33
 */
@Service
@Slf4j
public class TransactionalTestServiceImpl implements TransactionalTestService {
    @Autowired
    private UserService userService;
    @Autowired
    private User2Service user2Service;

    @Autowired
    private UserPostProcessService userPostProcessService;

    @Override
    @Transactional
    public void test00() {
        UserVO userVO1 = new UserVO();
        userVO1.setName("TestServiceA1");
        userService.add(userVO1);

        userPostProcessService.asyncService();

        UserVO userVO2 = new UserVO();
        userVO2.setName("TestServiceA2");
        user2Service.addWastTime(userVO2);
        //
        // userPostProcessService.asyncService();
    }

    @Override
    @Transactional
    public void test01() {
        UserVO userVO = new UserVO();
        userVO.setName("TestServiceA");
        userService.addAsync(userVO);
        userPostProcessService.asyncService();
    }

    @Override
    @Transactional
    public void test01Fix01() {
        UserVO userVO = new UserVO();
        userVO.setName("TestServiceA");
        userService.addAsync(userVO);

        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void afterCommit() {
                userPostProcessService.asyncService();
            }
        });
    }

    @Override
    @Transactional
    public void test01Fix02() {
        UserVO userVO = new UserVO();
        userVO.setName("TestServiceA");
        userService.addAsync(userVO);

        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void afterCommit() {
                // FIXME 好像不生效
                userPostProcessService.asyncService();
            }
        });
    }
    //
    // @EventListener
    // @Transactional
    // public void handleTransactionCommitEvent(TransactionCommitEvent event) {
    //     userPostProcessService.asyncServiceA();
    // }


    @Override
    @Transactional
    public void test00Fix() {
        UserVO userVO1 = new UserVO();
        userVO1.setName("TestServiceA1");
        userService.add(userVO1);

        userPostProcessService.asyncService();

        UserVO userVO2 = new UserVO();
        userVO2.setName("TestServiceA2");
        user2Service.addWastTime(userVO2);

        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void afterCommit() {
                userPostProcessService.asyncService();
            }
        });
    }
}
