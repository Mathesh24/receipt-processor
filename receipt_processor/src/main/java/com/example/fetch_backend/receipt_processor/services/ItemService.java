package com.example.fetch_backend.receipt_processor.services;

import org.springframework.stereotype.Component;

import com.example.fetch_backend.receipt_processor.model.Item;

@Component
public class ItemService {

	public long getDescRewards(Item item) {
		// TODO Auto-generated method stub
		String desc = item.getShortDescription().trim();
		double rewards = 0;
		
		if(desc.length()%3 == 0)
			  rewards = Double.parseDouble(item.getPrice())*0.2;
	
		
		return (long)Math.ceil(rewards);
		
	}

	
}
