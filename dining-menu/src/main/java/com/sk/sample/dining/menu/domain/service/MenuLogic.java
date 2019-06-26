package com.sk.sample.dining.menu.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sk.sample.dining.menu.domain.model.Menu;
import com.sk.sample.dining.menu.domain.repository.MenuRepository;

@Service("menuLogic")
@Primary
public class MenuLogic implements MenuService {
	@Autowired
	private MenuRepository menuRepository;

	@Override
	@Transactional(readOnly=true)
	public Menu findById(Long id) {
		return menuRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Menu> findByMenuTypeLike(String name) {
		return menuRepository.findByMenuTypeLike(name);
	}

	@Override
	@Transactional(readOnly=true)
	public Menu findByMenuType(String menuType) {
		return menuRepository.findByMenuType(menuType);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Menu> findAll() {
		return menuRepository.findAll();
	}

	
	@Override
	@Transactional(readOnly=true)
	public Page<Menu> findAll(Pageable pageable) {
		return menuRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public Menu register(Menu menu) {
		return menuRepository.save(menu);
	}

	@Override
	@Transactional
	public Menu update(Long id, Menu newMenu) {
		Menu oldMenu = menuRepository.findOne(id);
		if(oldMenu != null) {
			BeanUtils.copyProperties(newMenu,  oldMenu, "id");
			return menuRepository.save(oldMenu);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public void delete(Long id) {
		menuRepository.delete(id);
	}
}
