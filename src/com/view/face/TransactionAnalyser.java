package com.view.face;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import com.csv.reader.CSVReader;
import com.domain.base.InputParam;
import com.domain.base.Merchant;
import com.domain.base.OutputParam;
import com.domain.base.Transaction;

public class TransactionAnalyser {

	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); 
	@SuppressWarnings("resource")
	public static void main(String... args) {
		//String path="/Users/homemac/Downloads/tran.csv";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Path of csv file: ");
		String path = scanner.nextLine().trim(); 
		System.out.println("from Date: "); 
		LocalDateTime dateFrom = null;
		LocalDateTime dateTo = null;
		String fromDate = scanner.nextLine().trim();
		try {
		 dateFrom = LocalDateTime.parse(fromDate, formatter);
		 System.out.println("to Date: ");
			String toDate = scanner.nextLine().trim();
			try {
			dateTo = LocalDateTime.parse(toDate, formatter);
			System.out.println("Merchant: ");
			String merchant = scanner.nextLine().trim(); 
			InputParam inputParam = new InputParam(dateFrom, dateTo, new Merchant(merchant));
			List<Transaction> transactions=CSVReader.readCSV(path);
			if (transactions!=null && !transactions.isEmpty()) {
			OutputParam outputParam=CSVReader.analyse(transactions,inputParam);
			System.out.println("No of transactions: "+outputParam.getNoofTransactions());
			System.out.println("Average Transaction value: "+outputParam.getAverageAmount()); 
				}
			}
			catch (DateTimeParseException dtp) {
					System.out.println("Incorrect To Date Format");
				}
			
		}
		catch (DateTimeParseException dtp) {
			System.out.println("Incorrect From Date Format");
		}
		
		
	}
}
