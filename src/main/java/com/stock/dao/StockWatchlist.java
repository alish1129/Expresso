package com.stock.dao;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
 
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Watchlist")
public class StockWatchlist {
	
	public StockWatchlist() {
		
	}

	@Column(name="userName")
	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="name")
	private String name;
	
	 @Id
	@Column(name="ticker")
	private String ticker;
	
	@Column(name="min")
	private BigDecimal min;
	
	@Column(name="max")
	private BigDecimal max;
	
	@Column(name="p_change")
	private BigDecimal p_change;
	
	@Column(name="total_stock_supply")
	private BigDecimal total_stock_supply;
	
	@Column(name="total_market_cap")
	private BigDecimal total_market_cap;
	
	@Column(name="price")
	private BigDecimal price;

	 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public BigDecimal getMin() {
		return min;
	}

	public void setMin(BigDecimal min) {
		this.min = min;
	}

	public BigDecimal getMax() {
		return max;
	}

	public void setMax(BigDecimal max) {
		this.max = max;
	}

	public BigDecimal getP_change() {
		return p_change;
	}

	public void setP_change(BigDecimal p_change) {
		this.p_change = p_change;
	}

	public BigDecimal getTotal_stock_supply() {
		return total_stock_supply;
	}

	public void setTotal_stock_supply(BigDecimal total_stock_supply) {
		this.total_stock_supply = total_stock_supply;
	}

	public BigDecimal getTotal_market_cap() {
		return total_market_cap;
	}

	public void setTotal_market_cap(BigDecimal total_market_cap) {
		this.total_market_cap = total_market_cap;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public StockWatchlist(String userName, String name, String ticker, BigDecimal min, BigDecimal max, BigDecimal p_change,
			BigDecimal total_stock_supply, BigDecimal total_market_cap, BigDecimal price) {
	 
		this.userName = userName;
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
