package com.stock.dao;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
 
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Portfolio")
public class StockPortfolio {
	
	public StockPortfolio() {
		
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
	
	@Column(name="bought")
	private BigDecimal bought;
	
	@Column(name="priceToday")
	private BigDecimal priceToday;
	
	@Column(name="difference")
	private BigDecimal difference;
	
	@Column(name="supply")
	private BigDecimal margin;
	
	@Column(name="price")
	private BigDecimal price;

	@Column(name="date")
	private String date;

	 

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

	public BigDecimal getbought() {
		return bought;
	}

	public void setbought(BigDecimal bought) {
		this.bought = bought;
	}

	public BigDecimal getpriceToday() {
		return priceToday;
	}

	public void setpriceToday(BigDecimal priceToday) {
		this.priceToday = priceToday;
	}

	public BigDecimal getdifference() {
		return difference;
	}

	public void setdifference(BigDecimal difference) {
		this.difference = difference;
	}

	
	public void setMargin(BigDecimal margin) {
		this.margin = margin;
	}

	public BigDecimal getMargin() {
		return margin;
	}

	 

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public StockPortfolio(String userName, String name, String ticker, BigDecimal bought, BigDecimal priceToday, BigDecimal difference,
			BigDecimal margin, BigDecimal price,String date) {
	 
		this.userName = userName;
		this.name = name;
		this.ticker = ticker;
		this.bought = bought;
		this.priceToday = priceToday;
		this.difference = difference;
		this.margin = margin;
		this.price = price;
		this.date = date;
	}
 
	
 
	 
	
	
	
	
	

}
