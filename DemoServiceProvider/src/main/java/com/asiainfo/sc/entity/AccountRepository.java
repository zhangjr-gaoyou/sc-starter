package com.asiainfo.sc.entity;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
    List<Account> findAccountsByUserId(@Param("userId") String userId);
}
