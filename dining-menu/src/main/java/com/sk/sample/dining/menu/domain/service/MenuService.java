package com.sk.sample.dining.menu.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sk.sample.dining.menu.domain.model.Menu;

public interface MenuService {
	Menu findById(Long id);
	Menu findByMenuType(String menuType);
	List<Menu> findAll();
	Page<Menu> findAll(Pageable pageable);	
	List<Menu> findByMenuTypeLike(String name);	
	Menu register(Menu menu);
	Menu update(Long id, Menu menu);
	void delete(Long id);
}
