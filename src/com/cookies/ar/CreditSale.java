package com.cookies.ar;

public class CreditSale extends Sale implements NonBalancing {

	public CreditSale() {
		// TODO Auto-generated constructor stub
	}

	public CreditSale(float total) {
		super(total);
		// TODO Auto-generated constructor stub
	}

	public CreditSale(String total) {
		super(total);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getSaleType() {
		// TODO Auto-generated method stub
		return type;
	}

	private String type = "Credit ";
}
