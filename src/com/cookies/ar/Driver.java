package com.cookies.ar;

public class Driver {

	public static void main(String[] args) {
		
		int count = args.length;

		if(count != 2) {
			System.out.println("You must enter one input file name and one output file name.");
			System.exit(1);
		}
	
		try {
			CashDrawerReader reader = new CashDrawerReader(args[0]);
			reader.processFile();
			CashDrawer cashDrawer = reader.getCashDrawer();
			CashDrawerReportWriter writer = new CashDrawerReportWriter(args[1], cashDrawer);
			writer.writeBalanceReport();	
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Finished");
	}
}
