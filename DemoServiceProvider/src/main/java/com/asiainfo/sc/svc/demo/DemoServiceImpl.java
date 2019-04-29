package com.asiainfo.sc.svc.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.sc.entity.Account;
import com.asiainfo.sc.entity.AccountRepository;

@Service("DemoService")
public class DemoServiceImpl implements DemoService{

	
	@Autowired
	private AccountRepository accountRepository;
	
//	@Autowired
//    public DemoServiceImpl(AccountRepository accountRepository) {
//        this.accountRepository = accountRepository;
//       
//    }
	
	@Override
	public List<Account> getUserAccounts(String userName) {
		// TODO Auto-generated method stub
		List<Account> account = null;
	
		if (userName != null) {
            account = accountRepository.findAccountsByUserId(userName);
        }
		
		return account;
	}
}
