package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.stock.thread.populateApi.MainDatabasePopulate;
import com.stock.thread.populateApi.MainDatabaseUpdate;

@SpringBootApplication
 
@ComponentScan(basePackages = { "com.stock.restController","com.stock.Controllers","com.stock.dao","com.stock.login","com.stock.registration","com.stock.restGetDao","com.stock.service","com.stock.thread.populateApi","com.stock.thread.watchlist"} )
@EntityScan(basePackages={"com.stock.dao"})

@EnableJpaRepositories(basePackages={"com.stock.registration"})
public class StockManagementSystemApplication {
	@Autowired
	static
	MainDatabaseUpdate update = new MainDatabaseUpdate();
	
	static MainDatabasePopulate populate = new MainDatabasePopulate();

	public static void main(String[] args) {
		Thread thread = new Thread(update);
		thread.start();
		
		SpringApplication.run(StockManagementSystemApplication.class, args);
	}
	 
	
}
