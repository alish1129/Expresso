package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Stock")
public class StockDao {

	
	private int ranking;
	private String name;
	@Id
	private String ticker;
	private float min;
	private float max;
	private float p_change;
	private long total_stock_supply;
	private String total_market_cap;
	private float price;
 
	public StockDao(int ranking, String name, String ticker, float min, float max, float p_change,
			long total_stock_supply, String total_market_cap, float price) {
		super();
		this.ranking = ranking;
		this.name = name;
		this.ticker = ticker;
		this.min = min;
		this.max = max;
		this.p_change = p_change;
		this.total_stock_supply = total_stock_supply;
		this.total_market_cap = total_market_cap;
		this.price = price;
	}
	
	
	
	
	
}
