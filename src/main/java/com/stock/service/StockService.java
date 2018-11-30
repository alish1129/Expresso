package com.stock.service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.stock.dao.StockIndex;
import com.stock.dao.StockPortfolio;
import com.stock.dao.StockWatchlist;
 
import com.stock.dao.User;
 

import pl.zankowski.iextrading4j.api.stocks.Quote;

@Service
public interface StockService {
	public List<StockIndex> getQuotes();
	
	public StockIndex getQuote(String ticker);
	
	Quote getQuoteDetails(String ticker);
	
	List<StockWatchlist> createQuoteWatchlist(String ticker, Principal pri); 

	List<StockWatchlist> deleteQuoteWatchlist(String ticker, Principal pri); 

	public List<StockWatchlist> getQuoteWatchlist(Principal pri);

	public List<StockPortfolio> createQuotePortfolio(String ticker, Principal pri, BigDecimal quantity, String date, BigDecimal pricePaid);

	public List<StockPortfolio> getQuotePortfolio(Principal pri);

	public List<StockPortfolio> deleteQuotePortfolio(String id, Principal pri);

	public List<User> getUserDetails(Principal pri);

}
