/**
 * 
 */
package com.csv.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.domain.base.InputParam;
import com.domain.base.Merchant;
import com.domain.base.OutputParam;
import com.domain.base.Transaction;
import com.domain.base.TransactionType;

/**
 * @author homemac
 *
 */
public class CSVReader {
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); 
	
	public static List<Transaction> readCSV(String path) {
		List<Transaction> transactions = new ArrayList<>(); 
		Path pathToFile = Paths.get(path);
		try (BufferedReader br = Files.newBufferedReader(pathToFile)) 
		{ // read the first line from the text file 
			br.readLine();
			String line = null;
			// loop until all lines are read 
			while ((line = br.readLine()) != null) {
				// use string.split to load a string array with the values from 
				// each line of 
				// the file, using a comma as the delimiter 
				String[] attributes = line.split(","); 
				Transaction transaction = createTransaction(attributes); 
				// adding book into ArrayList 
				transactions.add(transaction); 
				// read next line before looping 
				// if end of file reached, line would be null 
				
				} 
			} catch (IOException ioe) { 
				System.out.println("Incorrect file path"); } 
		return transactions; 
					}
	
	private static Transaction createTransaction(String[] metadata) { 
		String id = metadata[0].trim(); 
		
		String datetime = metadata[1].trim();
		LocalDateTime date = LocalDateTime.parse(datetime, formatter);
		Double amount = Double.parseDouble(metadata[2].trim());
		Merchant merchant = new Merchant(metadata[3].trim());
		TransactionType type = TransactionType.valueOf(metadata[4].trim())  ;
		Transaction relatedTransaction =null;
		if (metadata.length>5) {
		relatedTransaction = new Transaction(metadata[5].trim());
		}
		// create and return book of this metadata 
		return new Transaction(id,date,amount,merchant,type,relatedTransaction); 
		}

	public static OutputParam analyse(List<Transaction> transactions, InputParam inputParam) {
		Integer count=0; Double sum=0.0;
		
		
		for (Transaction transaction: transactions) {
			
			if (inputParam.getMerchant().equals(transaction.getMerchant()) 
					&& transaction.getDate().isAfter(inputParam.getFromDate()) 
					&& transaction.getDate().isBefore(inputParam.getToDate())
					&& !isReversedTransaction(transactions,transaction.getId())) {
				count++;
				sum+=transaction.getAmount();
			}
		}
		return new OutputParam(count,sum/count);
		
	}

	private static Boolean isReversedTransaction(List<Transaction> transactions, String id) {
		for (Transaction transaction: transactions) {
			if (transaction.getRelatedTransaction()!=null 
					&& transaction.getRelatedTransaction().getId().equals(id) 
					 && transaction.getType().equals(TransactionType.REVERSAL)){
				return true;
			}
		}
		return false;
	}

}
	
