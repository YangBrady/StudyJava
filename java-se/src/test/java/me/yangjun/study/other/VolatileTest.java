package me.yangjun.study.other;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class VolatileTest {

    @Test
    public void demo() {
        Map<String, String> users = new HashMap<String, String>() {{
            put("A", "aaa");
            put("B", "bbb");
            put("C", "ccc");
        }};

        log.info("users=" + users);
    }
}
