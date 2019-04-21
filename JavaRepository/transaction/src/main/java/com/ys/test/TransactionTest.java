package com.ys.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ys.service.AccountService;

public class TransactionTest {
     
	// 不使用事务来实现转账
    @Test
    public void testNoTransaction(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService account = (AccountService) context.getBean("accountService");
        //Tom 向 Marry 转账1000
        account.transfer("Tom", "Marry", 1000);
    }
}