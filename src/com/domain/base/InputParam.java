package com.domain.base;

import java.time.LocalDateTime;

public class InputParam {

	private LocalDateTime fromDate;
	private LocalDateTime toDate;
	private Merchant merchant;
	public LocalDateTime getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDateTime fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDateTime getToDate() {
		return toDate;
	}
	public void setToDate(LocalDateTime toDate) {
		this.toDate = toDate;
	}
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	public InputParam(LocalDateTime fromDate, LocalDateTime toDate, Merchant merchant) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.merchant = merchant;
	}
	
	
}
