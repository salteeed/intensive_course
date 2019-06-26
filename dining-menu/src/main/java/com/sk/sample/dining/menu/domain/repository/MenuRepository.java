package com.sk.sample.dining.menu.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;
import com.sk.sample.dining.menu.domain.model.Menu;

@RepositoryRestResource
public interface MenuRepository extends PagingAndSortingRepository<Menu, Long>,
                                           QueryDslPredicateExecutor<Menu> {
	Menu findById(@Param("id") Long id);
	Menu findByMenuType(@Param("menuType") String menuType);
	List<Menu> findByMenuTypeLike(@Param("name") String name);
	List<Menu> findAll();
	List<Menu> findAll(Predicate predicate); 
}
