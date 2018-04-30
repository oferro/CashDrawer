package com.cookies.ar;

public class Sale {

	private float total = 0;

//	--------------------------------- Constractor -----------------------------------------------
	
	public Sale() {
		// TODO Auto-generated constructor stub
	}

	public Sale (float total) {
		super();
		this.total = total;
	}
	
	public Sale (String total) {
		super();
		this.total = Float.parseFloat(total);
	}
	
//	--------------------------------- Getter and Setter -----------------------------------------
	
	float getTotalAsFloat() {
		return total;
	}


	@Override
	public String toString() {
		return getTotalAsString();
	}

	void setTotal(float total) {
		this.total = total;
	}

//	--------------------------------- Methods --------------------------------------------------

	public String getTotalAsString() {
		return NumericFormatter.formatPrice(String.valueOf(total));
	}

	public void setTotal(String total) {
		this.total = Float.parseFloat(total);
	}

}
