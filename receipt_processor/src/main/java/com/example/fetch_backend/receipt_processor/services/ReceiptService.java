package com.example.fetch_backend.receipt_processor.services;

import java.time.LocalTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fetch_backend.receipt_processor.model.Item;
import com.example.fetch_backend.receipt_processor.model.Receipt;


@Service
public class ReceiptService {
	
	long rewards = 0;
	
	public final List<Receipt> purchases = new ArrayList<>();
	@Autowired
	ItemService itemService;
		
	public void addReceipt(Receipt receipt) {
		purchases.add(receipt);
	}
	
	public List<Receipt> getAllBillList(){
		return purchases;
	}
	
	public long getReceiptById(String id){
		
		Receipt response  =  purchases.stream().filter(p -> p.getId().equals(id))
														.findFirst().orElse(null);
		rewards = pointsCalculator(response);
		return rewards;
	}
	
	public long pointsCalculator(Receipt response) {
		
		
		//Alphanumeric reward Calculation
		rewards = response.getRetailer().chars().filter(Character::isLetterOrDigit).count();
		
		//50 Points for round total with no cents
		if(Double.parseDouble(response.getTotal()) % 1 == 0)
			rewards += 50;
		
		//25 points for multiple of 0.25
		if(Double.parseDouble(response.getTotal()) % 	0.25 == 0)
			rewards += 25;
		
		//5 points for two items
		rewards += (response.getItems().size() / 2) * 5;
		
		//Trimmed length of Item description
		List<Item> descRewards = response.getItems();
		
		for (Item item : descRewards) {
			rewards	+= itemService.getDescRewards(item);
			}
		
		//6points for odd days
		 String date = response.getPurchaseDate();
		 int day = Integer.parseInt(date.substring(date.length()-2));
		 
		 if(day%2 !=0)
			 rewards += 6;
		 
		 //Purchase time rewards
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		 LocalTime purchaseTime = LocalTime.parse(response.getPurchaseTime(),formatter);
		 LocalTime startTime = LocalTime.of(14, 0);
		 LocalTime endTime = LocalTime.of(16, 0);
		 
		 if(purchaseTime.isAfter(startTime) && purchaseTime.isBefore(endTime))
			 rewards += 10;
		 
		 
		 return rewards;
		 
	}
	
}
