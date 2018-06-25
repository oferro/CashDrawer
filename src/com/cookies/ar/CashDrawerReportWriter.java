package com.cookies.ar;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class CashDrawerReportWriter {

	private BufferedWriter writer = null;
	private CashDrawer cashDrawer = null;
	private static final String newLine = "\r\n";
	
	// --------------------------------- Constractor 

	
	public CashDrawerReportWriter() {
	}

	public CashDrawerReportWriter(String filename, CashDrawer cashDrawer) {
		super();
		init(filename, cashDrawer);
	}
	
	// --------------------------------- Getter and Setter 

	
	// --------------------------------- Methods 

	private void init(String filename, CashDrawer cashDrawer) {
		try {
			FileWriter fileWriter = new FileWriter(filename);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			this.cashDrawer = cashDrawer;
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find file: "+ filename);
			System.exit(1);
		} catch (IOException e) {
			System.out.println(e + "encountered while initializing cash drawer writer.");
		}	
	}
	
	private String getAllSales() {
		Iterator <Sale> iterator = cashDrawer.getSales().iterator();
		StringBuffer buffer = new StringBuffer();
		while (iterator.hasNext()) {
			Sale sale = ((Sale) iterator.next());
			if (sale instanceof NonBalancing) {
				NonBalancing nonCashSale = ((NonBalancing) sale);
				buffer.append(nonCashSale.getSaleType());
			} else {
				buffer.append("Cash ");
			}
			buffer.append("Sale: Total Price: $");
			buffer.append(sale.toString());
			buffer.append(newLine);
		}
		return buffer.toString();
	}
	
	private String assembleBalanceReport() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("The total sales are: $");
		buffer.append(NumericFormatter.formatPrice(cashDrawer.getTotal()));
		buffer.append(newLine);
		
		buffer.append("The average sale was: $");
		buffer.append(NumericFormatter.formatPrice(cashDrawer.getAverage()));
		buffer.append(newLine);
		
		buffer.append("The highest sale was: $");
		buffer.append(NumericFormatter.formatPrice(cashDrawer.getHighest()));
		buffer.append(newLine);
		
		buffer.append("The lowest sale was: $");
		buffer.append(NumericFormatter.formatPrice(cashDrawer.getLowest()));
		buffer.append(newLine);
		
		buffer.append("The cash sale was: $");
		buffer.append(NumericFormatter.formatPrice(cashDrawer.getCashTotal()));
		buffer.append(newLine);
		
		buffer.append("The non cash sale was: $");
		buffer.append(NumericFormatter.formatPrice(cashDrawer.getNonCashTotal()));
		buffer.append(newLine);
		
		buffer.append("The number of sales was: $");
		int salesCount = cashDrawer.getCount();
		String salesCountAsString = String.valueOf(salesCount);
		buffer.append(salesCountAsString);
		buffer.append(newLine);
		
		buffer.append("-----------------------------");
		buffer.append(newLine);
		
		buffer.append("Allrecorded sales were:");
		buffer.append(newLine);
		buffer.append(getAllSales());
		buffer.append(newLine);
		buffer.append("-----------------------------");
		buffer.append(newLine);

		buffer.append("Cash in was: $");
		buffer.append(NumericFormatter.formatPrice(cashDrawer.getCashIn()));
		
		buffer.append("Cash out was: $");
		buffer.append(NumericFormatter.formatPrice(cashDrawer.getCashOut()));
		buffer.append(newLine);

		buffer.append("The cash drawer did ");
		if (cashDrawer.isBalanced() == false) {
			buffer.append("Not balance");
			buffer.append(newLine);
			buffer.append("The cash drawer is ");
			buffer.append(NumericFormatter.formatPrice(cashDrawer.getDifferance()));
			buffer.append(" dollars out of balance.");
		} else {
			buffer.append("balance.");			
		}
		String bufferToString = buffer.toString();
		return bufferToString;
	}
	
	public void writeBalanceReport() {
		try {
			writer.write(assembleBalanceReport());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.out.println("Unable to successfully write balance report due to:" + e);
		}
		finally {
			try {
				writer.close();
			} catch (IOException ioe) {
				System.out.println("Unable to close report file due to:" + ioe);
			}
		}
	}
}
