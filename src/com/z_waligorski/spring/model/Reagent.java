package com.z_waligorski.spring.model;

public class Reagent {
	private int id;
	private String name;
	private String amount;
	private int lot;
	private String provider;
	private String deliveryDate;
	
	public Reagent(){}

	public Reagent(int id, String name, int lot, String provider, String deliveryDate) {
		super();
		this.id = id;
		this.name = name;
		this.lot = lot;
		this.provider = provider;
		this.deliveryDate = deliveryDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public int getLot() {
		return lot;
	}

	public void setLot(int lot) {
		this.lot = lot;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
}
