package com.example.demo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Stock")
public class Stock {
	
 @Id
	@Column(name="ranking")
	private int ranking;
	
	@Column(name="name")
	private String name;
	
	@Column(name="ticker")
	private String ticker;
	
	@Column(name="min")
	private double min;
	
	@Column(name="max")
	private double max;
	
	@Column(name="p_change")
	private double p_change;
	
	@Column(name="total_stock_supply")
	private long total_stock_supply;
	
	@Column(name="total_market_cap")
	private String total_market_cap;
	
	@Column(name="price")
	private double price;

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

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

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getP_change() {
		return p_change;
	}

	public void setP_change(double p_change) {
		this.p_change = p_change;
	}

	public long getTotal_stock_supply() {
		return total_stock_supply;
	}

	public void setTotal_stock_supply(long total_stock_supply) {
		this.total_stock_supply = total_stock_supply;
	}

	public String getTotal_market_cap() {
		return total_market_cap;
	}

	public void setTotal_market_cap(String total_market_cap) {
		this.total_market_cap = total_market_cap;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Stock(int ranking, String name, String ticker, double min, double max, double p_change,
			long total_stock_supply, String total_market_cap, double price) {
	 
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

	@Override
	public String toString() {
		return "stock [ranking=" + ranking + ", name=" + name + ", ticker=" + ticker + ", min=" + min + ", max=" + max
				+ ", p_change=" + p_change + ", total_stock_supply=" + total_stock_supply + ", total_market_cap="
				+ total_market_cap + ", price=" + price + "]";
	}
	
	
	
 
	 
	
	
	
	
	

}
