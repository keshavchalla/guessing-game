package com.guessing.model;

import org.springframework.stereotype.Component;

@Component
public class GuessModel {

	private int lowerLimit;
	private int upperLimit;
	private int guessNo;
	private String guess;
	private String status;
	private String message;
	
	public int getLowerLimit() {
		return lowerLimit;
	}
	public void setLowerLimit(int lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	public int getUpperLimit() {
		return upperLimit;
	}
	public void setUpperLimit(int upperLimit) {
		this.upperLimit = upperLimit;
	}
	public int getGuessNo() {
		return guessNo;
	}
	public void setGuessNo(int guessNo) {
		this.guessNo = guessNo;
	}
	public String getGuess() {
		return guess;
	}
	public void setGuess(String guess) {
		this.guess = guess;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
