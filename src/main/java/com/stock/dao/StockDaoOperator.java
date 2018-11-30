package com.stock.dao;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StockDaoOperator {
	
	public static void save(int ranking, String name, String ticker, BigDecimal min, BigDecimal max, BigDecimal p_change,
			BigDecimal total_stock_supply, BigDecimal total_market_cap, BigDecimal price) {
		SessionFactory factory = new Configuration()
													.configure("hibernate.cfg.xml")
													.addAnnotatedClass(StockIndex.class)
													.buildSessionFactory();
		
		
		try {
			
			//building a session for operation creation operation in database
			Session session =  factory.getCurrentSession();
			
			
			StockIndex stock =new StockIndex(ranking, name, ticker, min, max, p_change, total_stock_supply, total_market_cap, price);
			
			//beginning transaction
			session.beginTransaction();
			session.save(stock);
			session.getTransaction().commit();
			//session closing
			session.close();
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			factory.close();

		}
		
		
		
	}
	
	public static void update(int ranking, String name, String ticker, BigDecimal min, BigDecimal max, BigDecimal p_change,
			BigDecimal total_stock_supply, BigDecimal total_market_cap, BigDecimal price) {
	
		
		
		SessionFactory factory = new Configuration()
													.configure("hibernate.cfg.xml")
													.addAnnotatedClass(StockIndex.class)
													.buildSessionFactory();
		
		
		try {
			
			//building a session for operation creation operation in database
			Session session =  factory.getCurrentSession();
			
			//beginning transaction
			session.beginTransaction();
			
			
			StockIndex stock =session.get(StockIndex.class,ticker);
			

			stock.setMin(min);
			stock.setMax(max);
			stock.setP_change(p_change);
			stock.setPrice(price);
			stock.setTotal_market_cap(total_market_cap);
			stock.setTotal_stock_supply(total_stock_supply);
			
			System.out.println(stock);
			
			session.getTransaction().commit();
			//session closing
			session.close();
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			factory.close();

		}
		
		
		
	}

}
