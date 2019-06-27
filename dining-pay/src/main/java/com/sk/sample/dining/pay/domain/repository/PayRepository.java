package com.sk.sample.dining.pay.domain.repository;

import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;
import com.sk.sample.dining.pay.domain.model.Pay;

@RepositoryRestResource
public interface PayRepository extends PagingAndSortingRepository<Pay, Long>,
                                           QueryDslPredicateExecutor<Pay> {
	//Account findByEmail(@Param("email") String email);
	List<Pay> findByNameLike(@Param("name") String name);
	
	//List<Account> findByAddressZipCode(@Param("zipCode") Integer zipCode);
	
	//@Query("select a from Account a where a.address.homeAddress like %?1%")
	//List<Account> findByAddressHomeAddressLike(@Param("homeAddress") String homeAddress);
	
	List<Pay> findAll();
	List<Pay> findAll(Predicate predicate); 
}
