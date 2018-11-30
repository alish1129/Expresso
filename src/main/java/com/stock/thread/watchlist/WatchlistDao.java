package com.stock.thread.watchlist;

import java.security.Principal;
import java.util.List;

import com.stock.dao.StockWatchlist;

import pl.zankowski.iextrading4j.api.stocks.Quote;

public interface WatchlistDao {

	List<StockWatchlist> createQuoteWatchlist(String ticker, Principal pri);
 
	List<StockWatchlist> getQuoteWatchlist(Principal pri);

	List<StockWatchlist> deleteQuoteWatchlist(String ticker, Principal pri);

 
	
	 
}
