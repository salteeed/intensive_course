package com.sk.sample.dining.menu.application.sp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sk.sample.dining.menu.domain.model.Menu;
import com.sk.sample.dining.menu.domain.service.MenuService;

@RestController
@RequestMapping("/v1/menus")
public class MenuRestController implements MenuService {
	@Autowired
	private MenuService menuService;

	@Override
	@GetMapping
	public List<Menu> findAll() {
		return menuService.findAll(); 
	}
	
	@Override
	@GetMapping("/{id}")
	public Menu findById(@PathVariable("id") Long id) {
		return menuService.findById(id);
	}

	@Override
	@PostMapping
	public Menu register(@RequestBody Menu menu) {
		return menuService.register(menu);
	}

	@Override
	@PutMapping("/{id}")
	public Menu update(@PathVariable("id") Long id, @RequestBody Menu menu) {
		return menuService.update(id, menu);
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		menuService.delete(id);
	}
	
	@Override
	@GetMapping("/search/name")
	public List<Menu> findByMenuTypeLike(@RequestParam("name") String name) {
		return menuService.findByMenuTypeLike(name);
	}

	@Override
	@GetMapping("/search/menuType")
	public Menu findByMenuType(@RequestParam("menuType") String menuType) {
		return menuService.findByMenuType(menuType);
	}

	@Override
	//@GetMapping
	public Page<Menu> findAll(Pageable pageable) {
		return menuService.findAll(pageable); 
	}


}
