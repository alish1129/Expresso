package com.stock.thread.watchlist;

import java.security.Principal;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.stock.dao.StockWatchlist;

import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.stocks.QuoteRequestBuilder;

@Repository
public class WatchlistDaoImplements implements WatchlistDao{
	
	
public static   String  username;
 public static void username(Principal principal) {
	 username = principal.getName();
 }
	
 
 
	public List<StockWatchlist> extended(String ticker, Principal pri) {
		
	 //savves data in the db
 
		
		final IEXTradingClient iexTradingClient = IEXTradingClient.create();
		
		Quote quote ;
		quote = iexTradingClient.executeRequest(new QuoteRequestBuilder()
					        .withSymbol(ticker)
					        .build());
		
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(com.stock.dao.StockWatchlist.class)
				.buildSessionFactory();

					Session session = factory.getCurrentSession();
		 
			
				     
					try {
						 
				     
/*				    	System.out.println("0000000000000000000000000000000000000000000000000000000000000000"+pri.getName());
*/
				
						com.stock.dao.StockWatchlist stock = new 	com.stock.dao.StockWatchlist(pri.getName(),quote.getCompanyName(), quote.getSymbol(), quote.getLow(), quote.getHigh(), quote.getChangePercent(),
								quote.getLatestVolume(), quote.getMarketCap(), quote.getOpen()) ;
				
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
					.addAnnotatedClass(com.stock.dao.StockWatchlist.class)
						.buildSessionFactory();
		 session =factory.getCurrentSession();
		session.beginTransaction();
		System.out.println("-----------------------------------------------------");
		List<com.stock.dao.StockWatchlist> watchlistQuote =session.createQuery("from com.stock.dao.StockWatchlist s where s.userName = '"+pri.getName()+"'").getResultList();
	
		System.out.println("-----------------------------------------------------");
		session.getTransaction().commit();
		
		
		factory.close();
		return watchlistQuote;
 
	}


 




	private List<StockWatchlist> extended(Principal pri) {
		// TODO Auto-generated method stub
		
		
		//getting fetching data from database
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(com.stock.dao.StockWatchlist.class)
				.buildSessionFactory();

					Session session = factory.getCurrentSession();
		 session =factory.getCurrentSession();
		session.beginTransaction();
		System.out.println("--------------------extended(Principal pri)---------------------------------"+ pri.getName()+"a--------");
		List<com.stock.dao.StockWatchlist> watchlistQuote =session.createQuery("from com.stock.dao.StockWatchlist s where s.userName = '"+pri.getName()+"'").getResultList();
		System.out.println(watchlistQuote);
		System.out.println("*******************************************************");
		
		System.out.println("-----------------------------------------------------");
		session.getTransaction().commit();
		
		
		factory.close();
		return watchlistQuote;
		
	}
 



	@Override
	public List<StockWatchlist> createQuoteWatchlist(String ticker,Principal pri) {
		
		// TODO Auto-generated method stub
		
			 
				//SaveToDatabase saveToDatabase = new SaveToDatabase(ticker);
			//	thread1 = new Thread(saveToDatabase);
			//	thread1.start();
				
				
				
				return extended(ticker,pri);
				
	}



	@Override
	public List<StockWatchlist> getQuoteWatchlist(Principal pri) {
		// TODO Auto-generated method stub
		return extended(pri);
	}



	@Override
	public List<StockWatchlist> deleteQuoteWatchlist(String ticker, Principal pri) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(com.stock.dao.StockWatchlist.class)
				.buildSessionFactory();

					Session session = factory.getCurrentSession();
		 session =factory.getCurrentSession();
		session.beginTransaction();
		
		System.out.println("6666666666"+ticker+ "666666666666666666666"+pri);
 		session.createQuery("delete from com.stock.dao.StockWatchlist s where s.userName = '"+pri.getName()+"' and s.ticker='"+ticker+"'").executeUpdate();
		   System.out.println("DDDDDDDDDDDDDOOOOOOOOOOOOOOOOOOONNNNNNNNNNNEEEEEEEEEEE");
		   
 		List<com.stock.dao.StockWatchlist> watchlistQuote =session.createQuery("from com.stock.dao.StockWatchlist s where s.userName = '"+pri.getName()+"'").getResultList();
		session.getTransaction().commit();
		
		
		factory.close();
		return watchlistQuote;
	}
 
	 

}
 
	
	
	