package com.asiainfo.sc.base.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.asiainfo.sc.base.entity.User;


@RepositoryRestResource
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findUserByUsername(@Param("username") String username);
}