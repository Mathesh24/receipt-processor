package com.example.fetch_backend.receipt_processor.model;


import java.util.List;
import java.util.UUID;

public class Receipt {
	
	public String id;
	private String retailer;
	private String purchaseDate;
	private String purchaseTime;
	private String total;
	private List<Item> items;
	
	public Receipt(String retailer, String purchaseDate, String purchaseTime, String total, List<Item> items) {
		super();
		this.retailer = retailer;
		this.purchaseDate = purchaseDate;
		this.purchaseTime = purchaseTime;
		this.total = total;
		this.items = items;
	}

	public Receipt() {
		super();
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRetailer() {
		return retailer;
	}

	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(String purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Receipt [retailer=" + retailer + ", purchaseDate=" + purchaseDate + ", purchaseTime=" + purchaseTime
				+ ", total=" + total + ", items=" + items + "]";
	}
	
}
