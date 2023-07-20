package me.yangjun.study.designpattern.create.factory.simplefactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @author mooejun
 * @since 2020/06/28 16:33
 */
@Slf4j
public class MiPhone implements Phone {
    @Override
    public void call() {
        log.info("小米手机 is calling");
    }
}
