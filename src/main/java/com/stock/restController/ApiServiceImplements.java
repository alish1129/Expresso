package com.stock.restController;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import com.stock.dao.StockIndex;
@Component
public class ApiServiceImplements implements ApiService{

	@Override
	public List<StockIndex> getQuote() {
	 //starting factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(StockIndex.class)
										.buildSessionFactory();
		
//starting session
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		List<StockIndex> quote =session.createQuery("from Stock").getResultList();
		
		session.getTransaction().commit();
		
		factory.close();
		
		
		
		return quote;
	}

}
