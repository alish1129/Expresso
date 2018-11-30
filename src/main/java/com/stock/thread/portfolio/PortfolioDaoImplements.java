package com.stock.thread.portfolio;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.Principal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.stock.dao.StockPortfolio;
 

import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.stocks.QuoteRequestBuilder;

@Repository
public class PortfolioDaoImplements implements PortfolioDao{
	
	
public static   String  username;
 public static void username(Principal principal) {
	 username = principal.getName();
 }
	
 
 
	public List<StockPortfolio> extended(String ticker, Principal pri, BigDecimal quantity, String date,BigDecimal pricePaid) {
		
	 //savves data in the db
 
		
		final IEXTradingClient iexTradingClient = IEXTradingClient.create();
		
		Quote quote ;
		quote = iexTradingClient.executeRequest(new QuoteRequestBuilder()
					        .withSymbol(ticker)
					        .build());
		
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(com.stock.dao.StockPortfolio.class)
				.buildSessionFactory();

					Session session = factory.getCurrentSession();
		 
		
				     
					try {
						 
						BigDecimal bought =quantity.multiply(pricePaid);
						BigDecimal priceToday=quantity.multiply(quote.getOpen());
						BigDecimal difference = priceToday.subtract(bought);
						com.stock.dao.StockPortfolio stock = new 	com.stock.dao.StockPortfolio(pri.getName(),quote.getCompanyName(), quote.getSymbol(), bought, priceToday,difference,
								quantity,pricePaid, date) ;
		
						session.beginTransaction();
					    session.save(stock);
					    session.getTransaction().commit();
					    session.close();
			
		
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						factory.close();
					}
		
		
		
		//getting fetching data from database
		
		 factory = new Configuration()
				.configure("hibernate.cfg.xml")
					.addAnnotatedClass(com.stock.dao.StockPortfolio.class)
						.buildSessionFactory();
		 session =factory.getCurrentSession();
		session.beginTransaction();
		System.out.println("-----------------------------------------------------");
		List<com.stock.dao.StockPortfolio> portfolioQuote =session.createQuery("from com.stock.dao.StockPortfolio s where s.userName = '"+pri.getName()+"'").getResultList();

		System.out.println("-----------------------------------------------------");
		session.getTransaction().commit();
		
		
		factory.close();
		return portfolioQuote;
 
	}


 




	private List<StockPortfolio> extended(Principal pri) {
		// TODO Auto-generated method stub
		
		
		//getting fetching data from database
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(com.stock.dao.StockPortfolio.class)
				.buildSessionFactory();

					Session session = factory.getCurrentSession();
		 session =factory.getCurrentSession();
		session.beginTransaction();
		List<com.stock.dao.StockPortfolio> portfolioQuote =session.createQuery("from com.stock.dao.StockPortfolio s where s.userName = '"+pri.getName()+"'").getResultList();
		System.out.println(portfolioQuote);
		System.out.println("*******************************************************");
		
		System.out.println("-----------------------------------------------------");
		session.getTransaction().commit();
		
		
		factory.close();
		return portfolioQuote;
		
	}
 


 



	@Override
	public List<StockPortfolio> createQuotePortfolio(String ticker, Principal pri, BigDecimal quantity, String date,BigDecimal pricePaid) {
		// TODO Auto-generated method stub
		return extended(ticker,pri,quantity,date,pricePaid);
	}
 
	 
 



	@Override
	public List<StockPortfolio> getQuotePortfolio(Principal pri) {
		// TODO Auto-generated method stub
		return extended(pri);
	}



	@Override
	public List<StockPortfolio> deleteQuotePortfolio(String ticker, Principal pri) {

		System.out.println("In_----------------------------");
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(com.stock.dao.StockPortfolio.class)
				.buildSessionFactory();

					Session session = factory.getCurrentSession();
		 session =factory.getCurrentSession();
		session.beginTransaction();
		
  		session.createQuery("delete from com.stock.dao.StockPortfolio s where s.userName = '"+pri.getName()+"' and s.ticker='"+ticker+"'").executeUpdate();
		   System.out.println("DDDDDDDDDDDDDOOOOOOOOOOOOOOOOOOONNNNNNNNNNNEEEEEEEEEEE");
 		List<com.stock.dao.StockPortfolio> portfolioQuote =session.createQuery("from com.stock.dao.StockPortfolio s where s.userName = '"+pri.getName()+"'"
).getResultList();
		session.getTransaction().commit();
		
		
		factory.close();
		return portfolioQuote;
	}




}

class calculation implements Runnable{
	
	
	private  BigDecimal quantity;
	private BigDecimal pricePaid ;
	static BigDecimal bought;
	private BigDecimal currentPrice;
static BigDecimal priceToday;
	
	public calculation(BigDecimal quantity, BigDecimal pricePaid, BigDecimal currentPrice ) {
		this.quantity=quantity;
		this.pricePaid=pricePaid;
		this.currentPrice=currentPrice;
	}
	
	public void run() {
		
	}
	
}
 
	
	
	