package com.stock.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

 
import com.stock.dao.User;
import com.stock.restGetDao.StockDAOImplements;
import com.stock.restGetDao.StockDao;
import com.stock.thread.portfolio.PortfolioDao;
import com.stock.thread.portfolio.PortfolioDaoImplements;
import com.stock.thread.watchlist.WatchlistDao;
import com.stock.thread.watchlist.WatchlistDaoImplements;



@ComponentScan(basePackages = {"com.stock.registration"})
@Configuration
public class BeanConfiguration {
	
	@Bean
	public StockService stockService() {
		return new StockImplementation();
	}
	
	 
	/*@Bean
	public SignUpController signUpController() {
		return new SignUpController();
	}*/

	@Bean
	public StockDao stockDao() {
		return new StockDAOImplements();
	}
	@Bean 
	public WatchlistDao watchlistDao() {
		return new WatchlistDaoImplements();
	}
	
	
	@Bean
	public User user() {
		return new User(null, null, null, null, null, null);
	}
	
	
	@Bean
	public UserService userService() {
		return new UserServiceImplementation();
	}
	
	@Bean 
	public PortfolioDao portfolioDao() {
		return new PortfolioDaoImplements();
	}

	 
	
}
