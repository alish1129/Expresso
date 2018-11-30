package com.stock.restGetDao;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

import com.stock.dao.StockIndex;
import com.stock.dao.StockPortfolio;
import com.stock.dao.StockWatchlist;
import com.stock.dao.User;

import pl.zankowski.iextrading4j.api.stocks.Quote;

public interface StockDao {

	List<StockIndex> getQuotes();

	StockIndex getQuote(String ticker);

	Quote getQuoteDetails(String ticker);
	
	List<StockWatchlist> createQuoteWatchlist(String ticker,Principal pri);
 

	List<StockWatchlist> getQuoteWatchlist(Principal pri);
	
	List<StockWatchlist> deleteQuoteWatchlist(String ticker, Principal pri);
	 

	List<StockPortfolio> createQuotePortfolio(String ticker, Principal pri,BigDecimal quantity,String date, BigDecimal pricePaid);

	List<StockPortfolio> getQuotePortfolio(Principal pri);

	List<StockPortfolio> deleteQuotePortfolio(String id, Principal pri);

	List<User> getUserDetails(Principal pri);

	
}
