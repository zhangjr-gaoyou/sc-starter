package com.asiainfo.sc.svc.demo;

import java.util.List;

import com.asiainfo.sc.entity.Account;

public interface DemoService {
	public List<Account> getUserAccounts(String userName);
}
