package com.stock.restController;

import java.math.BigDecimal;

public class PFStock {

	private String id;
	private BigDecimal quantity;
	private BigDecimal date;
	
	public PFStock(String id, BigDecimal quantity, BigDecimal date){
		this.id = id;
		this.quantity = quantity;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getDate() {
		return date;
	}

	public void setDate(BigDecimal date) {
		this.date = date;
	}
}
