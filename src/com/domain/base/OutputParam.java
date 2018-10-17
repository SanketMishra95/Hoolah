package com.domain.base;

public class OutputParam {

	
	
	private Integer noofTransactions;
	private Double averageAmount;
	public Integer getNoofTransactions() {
		return noofTransactions;
	}
	public void setNoofTransactions(Integer noofTransactions) {
		this.noofTransactions = noofTransactions;
	}
	public Double getAverageAmount() {
		return averageAmount;
	}
	public void setAverageAmount(Double averageAmount) {
		this.averageAmount = averageAmount;
	}
	public OutputParam(Integer noofTransactions, Double averageAmount) {
		super();
		this.noofTransactions = noofTransactions;
		this.averageAmount = averageAmount;
	}
	
	
}
