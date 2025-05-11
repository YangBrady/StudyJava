package me.yangjun.study.config.parser.func.impl;

import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.config.parser.func.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FunctionServiceImpl implements FunctionService {
    @Autowired
    private ParseFunctionFactory functionFactory;

}
