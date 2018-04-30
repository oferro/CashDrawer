package com.cookies.ar;

public class Driver {

	public static void main(String[] args) {
//		double sales[] = {35.99, 35.99, 9.78, 54.68, 10.00};
		
		int count = args.length;
		
		if(count==0) {
			System.out.println("You must enter sale prices.");
			System.exit(1);
		}

		CashDrawer cashDrawer = new CashDrawer();
		
		cashDrawer.setCashIn(args[0]);
		cashDrawer.setCashOut(args[1]);
		
		
		for (int i = 2; i < count; ++i) {
			cashDrawer.addCashSale(args[i]);
		}
		
		cashDrawer.printBalanceReport();
		
	}
}
