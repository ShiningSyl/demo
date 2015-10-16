package com.youtube.rest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CalculateTax {
	
	public static void main1(String[] args) throws IOException {
		double taxable_income = 58100.34;
		getTax(taxable_income);
	}
	
	public static int getTax(double texable_income) throws IOException {
		
		ArrayList<EZ_1040NR_TaxingTable> taxingTable = new ArrayList<EZ_1040NR_TaxingTable>();		
		BufferedReader br = null;
		String singleLine;
		boolean taxfound = false;
		int tax = 0;
		
		/**Load the taxing table*/
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream("EZ_1040NR_TaxingTable")));
		} catch(FileNotFoundException exception) {
			System.out.println("File Not Found!");
		}
		while((singleLine = br.readLine()) != null) {
			String[] ss = singleLine.split(" ");
			EZ_1040NR_TaxingTable cell = new EZ_1040NR_TaxingTable(
					Integer.parseInt(ss[0]), Integer.parseInt(ss[1]), Integer.parseInt(ss[2]));
			taxingTable.add(cell);
		}		
		br.close();
		
		/** compare taxable_income with the taxing table*/
		
		int gross = (int) Math.ceil(texable_income);
		System.out.println("taxable income= " + texable_income + " is round to= " +gross);
		
		while(!taxfound) {
			for(int i = 0; i < taxingTable.size(); i++) {
				if (gross > taxingTable.get(i).atleast) {
					tax = taxingTable.get(i).tax;
					taxfound = true;
				}
			}			
		}
		
		System.out.println("tax= " + tax);
		return tax;
		
	
	}
	
	
}
