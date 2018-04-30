package com.cookies.ar;

import java.util.Iterator;
import java.util.Vector;

public class CashDrawer {

	private Vector<Sale> sales = new Vector<Sale>();   // Configure the Vector
	private double total = 0;
	private float highest = Float.MIN_VALUE;
	private float lowest = Float.MAX_VALUE;

	private float cashIn;
	// This will represent the amount of cash in the register when the cashier signs
	// in.

	private float cashOut;
	// This will represent the amount of cash in the register when the cashier signs
	// out.

	private float differance = 0;

	// --------------------------------- Constractor  -----------------------------------------------

	// --------------------------------- Getter and Setter -----------------------------------------
	double getTotal() {
		return total;
	}

	void setTotal(double total) {
		this.total += total;
	}

	float getHighest() {
		return highest;
	}

	void setHighest(float highest) {
		this.highest = highest;
	}

	float getLowest() {
		return lowest;
	}

	void setLowest(float lowest) {
		this.lowest = lowest;
	}


	float getCashIn() {
		return cashIn;
	}

	void setCashIn(float cashIn) {
		this.cashIn = cashIn;
	}
	
	void setCashIn(String cashIn) {
		this.cashIn = Float.valueOf(cashIn); // Check if not unnecessary because we get String
	}

	float getCashOut() {
		return cashOut;
	}

	void setCashOut(float cashOut) {
		this.cashOut = cashOut;  // Check if not unnecessary because we get String 
	}
	
	void setCashOut(String cashOut) {
		this.cashOut = Float.valueOf(cashOut);
	}

	float getDifferance() {
		return differance;
	}

	void setDifferance(float differance) {
		this.differance = differance;
	}

	// --------------------------------- Methods -------------------------------------------------

	public int getCount() {
		return sales.size();
	}

	public double getAverage() {
		return getTotal() / getCount();
	}

	public void addCashSale(String price) {
		CashSale cashSale = new CashSale(price);
		sales.add(cashSale);
		float cashSaleTotal = cashSale.getTotalAsFloat();
		setTotal(cashSaleTotal);
		if (cashSaleTotal > highest) {
			highest = cashSaleTotal;
		}
		if (cashSaleTotal < lowest) {
			lowest = cashSaleTotal;
		}
	}

	public boolean isBalanced() {
		boolean isInBalance = false;
		float combinedCash = (float) (getCashIn() + getTotal());
		if (combinedCash == getCashOut()) {
			isInBalance = true;
		} else {
			setDifferance(getCashOut() - combinedCash); 
		}
		return isInBalance;
	}
	
	private void printAllSales() {
		Iterator<Sale> iterator = sales.iterator();
		int index = 0;
		while (iterator.hasNext()) {
			Sale sale = iterator.next();
			System.out.println("Sales "+ index + " Total Prices: $"+sale.getTotalAsString());
//			System.out.println("Sales "+ index + " Total Prices: $"+sale.toString());
//			System.out.println("Sales "+ index + " Total Prices: $"+sale);
			++index;
		}
		
	}
	
	public void printBalanceReport() {
		System.out.println("The total is: $" + NumericFormatter.formatPrice(getTotal()));
		System.out.println("The average is: $" + NumericFormatter.formatPrice(getAverage()));
		System.out.println("The highest sale was: $" + NumericFormatter.formatPrice(getHighest()));
		System.out.println("The lowest sale was: $" + NumericFormatter.formatPrice(getLowest()));
		System.out.println("The number of sales was: " + getCount());
		System.out.println("---------------------------------------------");
		System.out.println("All recorded sales were");
		printAllSales();
		System.out.println("---------------------------------------------");
		
		if (isBalanced() == false) {
			System.out.println("The Cash Drawer is not balanced");
			System.out.println("The differance is : $" + getDifferance());
		} else {
			System.out.println("Cash in was: $" + getCashIn() + ". Cash out was: $" + getCashOut());
			System.out.println("The cash drawer did balance.");
		}
	}
}
