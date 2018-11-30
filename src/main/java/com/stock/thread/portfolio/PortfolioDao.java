package com.stock.thread.portfolio;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

import com.stock.dao.StockPortfolio;
import com.stock.dao.StockWatchlist;

import pl.zankowski.iextrading4j.api.stocks.Quote;

public interface PortfolioDao {



	List<StockPortfolio> getQuotePortfolio(Principal pri);

	List<StockPortfolio> createQuotePortfolio(String ticker, Principal pri, BigDecimal quantity, String date, BigDecimal pricePaid);

	List<StockPortfolio> deleteQuotePortfolio(String id, Principal pri);

 
	
	 
}
