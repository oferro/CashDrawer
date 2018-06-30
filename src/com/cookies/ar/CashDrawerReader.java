package com.cookies.ar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CashDrawerReader {

	private BufferedReader reader = null;
	private CashDrawer cashDrawer = null;

	// --------------------------------- Constractor

	public CashDrawerReader(String filename) throws CashDrawerExeption {
		super();
		init(filename);
	}

	// --------------------------------- Getter and Setter

	CashDrawer getCashDrawer() {
		return cashDrawer;
	}

	void setCashDrawer(CashDrawer cashDrawer) {
		this.cashDrawer = cashDrawer;
	}

	// --------------------------------- Methods
	
	private void init(String filename) throws CashDrawerExeption {
		try {
			FileReader fileReader = new FileReader(filename);
			reader = new BufferedReader(fileReader);
			this.cashDrawer = new CashDrawer();
		} catch (FileNotFoundException e) {
			throw new CashDrawerExeption(e.getMessage());
		}
	}
	
	private Line readLine() {
		Line line = null;
		try {
			String data = reader.readLine();
			if (data==null) return line;
			int substringIndex = data.indexOf(" ");
			String firstString = data.substring(0, substringIndex);
			String secondString = data.substring(substringIndex+1, data.length());
			line = new Line(firstString, secondString);
			return line;
		} catch (IOException e) {
			System.out.println(e + "encountered. Unable to process input file.");
			return null;
		}
	}
	
	public void processFile() {
		Line cashValuesLine = readLine();
		cashDrawer.setCashIn(cashValuesLine.getFirst());
		cashDrawer.setCashOut(cashValuesLine.getSecond());
		
		Line saleLine = null;
		try {
			do {
				saleLine = readLine();
				if (saleLine == null) break;
				cashDrawer.addSale(saleLine.getFirst(), saleLine.getSecond());
			} while (true);
		} catch (CashDrawerExeption e) {
			System.out.println(e + "encountered. Unable to process input file.");	
		}
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.exit(1);
			}
		}
	}

}
