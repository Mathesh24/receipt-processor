package com.example.fetch_backend.receipt_processor.controller;

import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fetch_backend.receipt_processor.model.Receipt;
import com.example.fetch_backend.receipt_processor.services.ReceiptService;

@RestController
public class ReceiptController {
	
	@Autowired 
	ReceiptService receiptService;
	
	//Creating ID for receipt
	@PostMapping("/receipt/process")
	public ResponseEntity<HashMap<String, String>> addReceipt(@RequestBody Receipt receipt) {
		receiptService.addReceipt(receipt);
		HashMap<String, String> response = new HashMap<>();
		response.put("id",receipt.getId());
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	//To check all the bills
	@GetMapping("/receipt/process/all")
	public List<Receipt> getAllBillList(){
		return receiptService.getAllBillList();
	}
	
	//For total points earned
	@GetMapping("/receipt/{id}/points")
	public ResponseEntity<HashMap<String, Long>> getPointsById(@PathVariable String id) {
		HashMap<String, Long> response = new HashMap<>();
		response.put("points", receiptService.getReceiptById(id));
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
}
