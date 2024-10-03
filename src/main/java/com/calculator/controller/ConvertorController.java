package com.calculator.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import com.calculator.soap.generated.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.soap.client.SoapClient;

@RestController
public class ConvertorController {

	@Autowired
	private SoapClient soapClient;

	/**
	 * 
	 * @param value
	 * @return
	 */
	@PostMapping("/numbertowords")
	public ResponseEntity<?> numberToWords(@RequestParam BigInteger value) {

		NumberToWordsResponse res = soapClient.getNumberToWordsResponse(value);

		Map<String, String> response = new HashMap<>();
		response.put("resultado", res.getNumberToWordsResult());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	@PostMapping("/numbertodollars")
	public ResponseEntity<?> numberToDollars(@RequestParam BigDecimal value) {

		NumberToDollarsResponse res = soapClient.getNumberToDollarsResponse(value);

		Map<String, String> response = new HashMap<>();
		response.put("resultado", res.getNumberToDollarsResult());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/Add")
	public ResponseEntity<?> add(@RequestParam int valueA, @RequestParam int valueB) {

		AddResponse res = soapClient.getAddResponse(valueA, valueB);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@PostMapping("/Subtract")
	public ResponseEntity<?> subtract(@RequestParam int valueA, @RequestParam int valueB) {

		SubtractResponse res = soapClient.getSubtractResponse(valueA, valueB);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@PostMapping("/Multiply")
	public ResponseEntity<?> multiply(@RequestParam int valueA, @RequestParam int valueB) {

		MultiplyResponse res = soapClient.getMultiplyResponse(valueA, valueB);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@PostMapping("/Divide")
	public ResponseEntity<?> divide(@RequestParam int valueA, @RequestParam int valueB) {

		DivideResponse res = soapClient.getDivideResponse(valueA, valueB);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}