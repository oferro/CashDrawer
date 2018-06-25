package com.cookies.ar;

public class CheckSale extends Sale implements NonBalancing {

	public CheckSale() {
		// TODO Auto-generated constructor stub
	}

	public CheckSale(float total) {
		super(total);
		// TODO Auto-generated constructor stub
	}

	public CheckSale(String total) {
		super(total);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getSaleType() {
		// TODO Auto-generated method stub
		return type;
	}

	private String type = "Check ";
}
