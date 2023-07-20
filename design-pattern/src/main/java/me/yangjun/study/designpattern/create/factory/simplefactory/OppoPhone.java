package me.yangjun.study.designpattern.create.factory.simplefactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @author mooejun
 * @since 2020/06/28 16:34
 */
@Slf4j
public class OppoPhone implements Phone {
    @Override
    public void call() {
        log.info("OPPO手机 is calling");
    }
}
