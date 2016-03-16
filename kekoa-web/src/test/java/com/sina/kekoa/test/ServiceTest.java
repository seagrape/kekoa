package com.sina.kekoa.test;

import com.sina.kekoa.KekoaApplication;
import com.sina.kekoa.datasource.DynamicDataSourceAspect;
import com.sina.kekoa.demo3.jdbc.StudentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by whf on 3/15/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = KekoaApplication.class)
//@WebAppConfiguration
public class ServiceTest {
/*    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mvc;*/

    @Autowired
    private StudentService studentService;

    @Autowired
    private DynamicDataSourceAspect aspect;


    /**
     * 测试Spring AOP代码是否执行
     * @throws Exception
     */
    @Test
    public void aopTest() throws Exception {
        studentService.testAOP();

        Assert.assertTrue("AOP @Before hasn't been invoked!", aspect.beforeExecuted);
        Assert.assertTrue("AOP @After hasn't been invoked!", aspect.afterExecuted);
    }
}
