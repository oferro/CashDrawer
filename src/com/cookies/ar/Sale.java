package com.cookies.ar;

import javax.sound.sampled.AudioFileFormat.Type;

public class Sale {

	private float total = 0;

//	--------------------------------- Constractor -----------------------------------------------
	
	public Sale() {
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

	public static Sale createSale(String type, String price) throws CashDrawerExeption {
		int typeAsInt = Integer.parseInt(type);
		try {
			if(type.equalsIgnoreCase("0")) {		 //Cash
				typeAsInt = 0;
			}
			else if (type.equalsIgnoreCase("1")){   //Credit
				typeAsInt = 1;
			}
			else if (type.equalsIgnoreCase("2")) {  //Check
				typeAsInt = 2;
			}
		} catch (NumberFormatException e) {
			throw new CashDrawerExeption("Invalid sale Type. \n "
					+ "Valid types are 0,1,2  \n"
					+ "where: \n"
					+ "0 = Cash \n"
					+ "1 = Credit \n"
					+ "2 = Check");
		}
		
		Sale sale = null;
		switch (typeAsInt) {
			case 0:
				sale = new CashSale(price);
				break;
			case 1:
				sale = new CreditSale(price);
				break;			
			case 2:
				sale = new CheckSale(price);
				break;
			default:	
				throw new CashDrawerExeption("Invalid sale Type. \n "
						+ "Valid types are 0,1,2  \n"
						+ "where: \n"
						+ "0 = Cash \n"
						+ "1 = Credit \n"
						+ "2 = Check");		
		}
		return sale;
	}
}
