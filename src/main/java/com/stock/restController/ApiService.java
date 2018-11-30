package com.stock.restController;

import java.util.List;

import com.stock.dao.StockIndex;

public interface ApiService {

	List<StockIndex> getQuote();

	
}
