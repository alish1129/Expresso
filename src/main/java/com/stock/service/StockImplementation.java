package com.stock.service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stock.dao.StockPortfolio;
import com.stock.dao.StockWatchlist;
import com.stock.dao.User;
 
import com.stock.restGetDao.StockDao;
import com.stock.thread.watchlist.WatchlistDao;

import pl.zankowski.iextrading4j.api.stocks.Quote;

@Service
public class StockImplementation implements StockService {

 
	@Autowired
	private StockDao stockDao;
	
	
	@Autowired
	private WatchlistDao watchlistDao;
	

/*	@Autowired
	private AuthenticatorClass authenticate;
	*/
	@Override
	@Transactional
	public List<com.stock.dao.StockIndex> getQuotes() {
		// TODO Auto-generated method stub
		System.out.println("-------------------------------------------------------------------------------");
		return stockDao.getQuotes();
	}

	@Override
	@Transactional
	public com.stock.dao.StockIndex getQuote(String ticker) {
		// TODO Auto-generated method stub
		return stockDao.getQuote(ticker);
	}

	@Override
	public Quote getQuoteDetails(String ticker) {
		return stockDao.getQuoteDetails(ticker);
	}
	
	//watchlist

	@Override
	public  List<com.stock.dao.StockWatchlist> createQuoteWatchlist(String ticker,Principal pri) {
 
  
		return stockDao.createQuoteWatchlist(ticker,pri);
		
	}

	
	@Override
	public  List<com.stock.dao.StockWatchlist> getQuoteWatchlist(Principal pri) {
 
  
		return stockDao.getQuoteWatchlist(pri);
	}
	
	
	@Override
	public List<StockWatchlist> deleteQuoteWatchlist(String ticker, Principal pri) {
		return stockDao.deleteQuoteWatchlist(ticker,pri);
	}
	 
	
	
//portfolio
	@Override
	public List<StockPortfolio> createQuotePortfolio(String ticker, Principal pri, BigDecimal quantity, String date,BigDecimal pricePaid){
		
	// TODO Auto-generated method stub
		return stockDao.createQuotePortfolio(ticker,pri,quantity,date,pricePaid);
	}

	@Override
	public List<StockPortfolio> getQuotePortfolio(Principal pri) {
		// TODO Auto-generated method stub
		return stockDao.getQuotePortfolio(pri);
	}

	public List<StockPortfolio> deleteQuotePortfolio(String id, Principal pri) {
		return stockDao.deleteQuotePortfolio(id,pri);	
		}

	@Override
	public List<User> getUserDetails(Principal pri) {
		// TODO Auto-generated method stub
		return stockDao.getUserDetails(pri);
	}

	
	 
	
	
	
	
	
}
