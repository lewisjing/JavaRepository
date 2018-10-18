package com.ys.service.impl;
 
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.ys.dao.AccountDao;
import com.ys.service.AccountService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
 
@Transactional(propagation=Propagation.REQUIRED , isolation = Isolation.DEFAULT)
public class AccountServiceImpl implements AccountService{
	
	
	
	//不用事务实现转账
 
//    private AccountDao accountDao;
//     
//    public void setAccountDao(AccountDao accountDao) {
//        this.accountDao = accountDao;
//    }
//    
//    public void transfer(String outer, String inner, int money) {
//        accountDao.out(outer, money);
//        accountDao.in(inner, money);
//    }
	
	
	
	//编程式事务实现转账
	
	private AccountDao accountDao;
    private TransactionTemplate transactionTemplate;
     
    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    
    public void transfer(final String outer,final String inner,final int money) {
//        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus arg0) {
//                accountDao.out(outer, money);
//                int i = 1/0;
//                accountDao.in(inner, money);
//            }
//        });
    	
    	accountDao.out(outer, money);
        int i = 1/0;
        accountDao.in(inner, money);
    }
 
}