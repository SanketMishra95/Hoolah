package com.domain.base;

import java.time.LocalDateTime;

public class Transaction {
	
	private String id;
	private LocalDateTime date;
	private Double amount;
	private Merchant merchant;
	private TransactionType type;
	private Transaction relatedTransaction;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	public TransactionType getType() {
		return type;
	}
	public void setType(TransactionType type) {
		this.type = type;
	}
	public Transaction getRelatedTransaction() {
		return relatedTransaction;
	}
	public void setRelatedTransaction(Transaction relatedTransaction) {
		this.relatedTransaction = relatedTransaction;
	}
	public Transaction(String id, LocalDateTime date, Double amount, Merchant merchant, TransactionType type,
			Transaction relatedTransaction) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.merchant = merchant;
		this.type = type;
		this.relatedTransaction = relatedTransaction;
	}
	public Transaction(String id) {
		super();
		this.id = id;
	}
	
	public Transaction() {
		
	}
	

}
