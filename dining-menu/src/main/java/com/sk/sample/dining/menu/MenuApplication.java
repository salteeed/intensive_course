package com.sk.sample.dining.menu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.sk.sample.dining.menu.domain.model.Menu;
import com.sk.sample.dining.menu.domain.model.MenuType;
import com.sk.sample.dining.menu.domain.model.ReviewType;
import com.sk.sample.dining.menu.domain.model.MealTime;
import com.sk.sample.dining.menu.domain.repository.MenuRepository;
import com.sk.sample.dining.menu.domain.service.MenuService;
import com.sk.sample.dining.menu.domain.model.Money;

@SpringBootApplication
@EnableFeignClients
public class MenuApplication {
	public static void main(String[] args) {
		SpringApplication.run(MenuApplication.class, args);
	}

	@Bean
	public CommandLineRunner execSampleCode(MenuRepository menuRepository, MenuService menuService) {	
		return (args) -> {
			insertMenus(menuRepository);
			displayMenus(menuRepository);			
			executeExample1(menuRepository, menuService);
		};
	}
		
	public void insertMenus(MenuRepository menuRepository) {
		Menu menu1 = new Menu(MenuType.KOREANFOOD, MealTime.BREAKFAST, new Money(5900), ReviewType.GOOD);
		menuRepository.save(menu1);
		
		Menu menu2 = new Menu(MenuType.INTERNATIONALFOOD, MealTime.BREAKFAST, new Money(6900), ReviewType.GOOD);
		menuRepository.save(menu2);
		
		Menu menu3 = new Menu(MenuType.KOREANFOOD, MealTime.LUNCH, new Money(5900), ReviewType.BAD);
		menuRepository.save(menu3);
		
		Menu menu4 = new Menu(MenuType.NOODLEFOOD, MealTime.LUNCH, new Money(4900), ReviewType.GOOD);
		menuRepository.save(menu4);
		
		Menu menu5 = new Menu(MenuType.INTERNATIONALFOOD, MealTime.DINNER, new Money(7900), ReviewType.GOOD);
		menuRepository.save(menu5);

	}
	
	public void displayMenus(MenuRepository menuRepository) {
		System.out.println("***************************************************************");
		
		Iterable<Menu> menuList = menuRepository.findAll();
		for(Menu menu : menuList) {
			System.out.println(menu.toString());
		}
		
		System.out.println("***************************************************************");
	}
	
	public void executeExample1(MenuRepository menuRepository, MenuService menuService) {		
		Menu menu = new Menu(MenuType.CHINAFOOD, MealTime.DINNER, new Money(3900), ReviewType.GOOD);		
		menuService.register(menu);
		
		displayMenus(menuRepository);
	}	

}
