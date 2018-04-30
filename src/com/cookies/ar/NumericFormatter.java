package com.cookies.ar;

//--------------------------------- Constractor -----------------------------------------------

public class NumericFormatter {

	public NumericFormatter() {
	}

//	--------------------------------- Methods --------------------------------------------------
	
	public static String formatPrice(String price) {
		int decimalIndex = price.indexOf(".");
		int endIndex;
		String formattedString = "";
		try {
			if (price.length() >= decimalIndex + 3) {
				endIndex = decimalIndex + 3;
				formattedString = price.substring(0, endIndex);			
			} else {
				endIndex = price.length();
				String paddedString = new String(price);
				while (endIndex < decimalIndex + 3) {
					paddedString = paddedString.concat("0");
					++endIndex;
				}
				return paddedString;
			}
		} catch (StringIndexOutOfBoundsException e) {
			return price;
		} catch (Exception e) {
			String error = e.getClass() + " while formatting price. Message " + e.getMessage();
			System.out.println(error);
			return price;
		}
		return formattedString;
	}
	
	public static String formatPrice(float price) {
		return formatPrice(Float.toString(price));
	}
	
	public static String formatPrice(int price) {
		return formatPrice(Integer.toString(price));
	}
	
	public static String formatPrice(long price) {
		return formatPrice(Long.toString(price));
	}
	
	public static String formatPrice(double price) {
		return formatPrice(Double.toString(price));
	}
}
