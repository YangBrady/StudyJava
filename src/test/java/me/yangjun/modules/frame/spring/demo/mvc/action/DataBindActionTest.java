package me.yangjun.modules.frame.spring.demo.mvc.action;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class DataBindActionTest {

    @Test
    public void testPage() throws Exception {
        DataBindAction dataBindAction = new DataBindAction();
        MockMvc mockMvc = standaloneSetup(dataBindAction).build();
        // 对"/"执行get请求, 期望得到modules/frame/spring/demo/mvc/testPage视图
        mockMvc.perform(get("/frame/spring/demo/mvc/testPage"))
                .andExpect(view().name("modules/frame/spring/demo/mvc/testPage"));
    }

    @Test
    public void justGet() {
    }

    @Test
    public void justPost() {
    }

    @Test
    public void index() {
    }

    @Test
    public void receiveByJavaBean() {
    }

    @Test
    public void receiveUrlParam() {
    }

    @Test
    public void receiveArray() {
    }

    @Test
    public void receiveList() {
    }

    @Test
    public void requestParam() {
    }

    @Test
    public void modelAttributeAtParam() {
    }

    @Test
    public void modelAttributeUser() {
    }

    @Test
    public void modelAttributeAtFunction() {
    }

    @Test
    public void requestBody() {
    }

    @Test
    public void responseBody() {
    }
}