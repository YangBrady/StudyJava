package me.yangjun.study.springtest.service;

public interface UserPostProcessService {
    void service();

    void asyncService();

    void asyncServiceNoTransaction();

    void asyncServiceRequiresNew();
}
